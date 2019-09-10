package com.yaofei.springmvcmybatis.component.es;

import com.alibaba.fastjson.JSONObject;
import com.carrotsearch.hppc.ObjectLookupContainer;
import com.carrotsearch.hppc.cursors.ObjectCursor;
import com.carrotsearch.hppc.cursors.ObjectObjectCursor;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse;
import org.elasticsearch.action.admin.indices.analyze.AnalyzeAction;
import org.elasticsearch.action.admin.indices.analyze.AnalyzeRequestBuilder;
import org.elasticsearch.action.admin.indices.analyze.AnalyzeResponse;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.action.admin.indices.mapping.get.GetMappingsRequest;
import org.elasticsearch.action.admin.indices.mapping.get.GetMappingsResponse;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequest;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingResponse;
import org.elasticsearch.action.admin.indices.settings.get.GetSettingsResponse;
import org.elasticsearch.action.bulk.*;
import org.elasticsearch.action.delete.DeleteRequestBuilder;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.get.MultiGetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.MultiSearchResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.IndicesAdminClient;
import org.elasticsearch.client.Requests;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.health.ClusterHealthStatus;
import org.elasticsearch.cluster.health.ClusterIndexHealth;
import org.elasticsearch.cluster.metadata.MappingMetaData;
import org.elasticsearch.common.Nullable;
import org.elasticsearch.common.collect.ImmutableOpenMap;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.unit.ByteSizeUnit;
import org.elasticsearch.common.unit.ByteSizeValue;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.index.reindex.DeleteByQueryAction;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.suggest.Suggest;
import org.elasticsearch.search.suggest.SuggestBuilder;
import org.elasticsearch.search.suggest.completion.CompletionSuggestion;
import org.elasticsearch.search.suggest.completion.CompletionSuggestionBuilder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * Created by phoenix on 2017/8/2.
 */
@Component
public class ESClient implements InitializingBean {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${es.cluster.name}")
    private String clusterName; //实例名称
    @Value("${es.host.ip}")
    private String host;
    @Value("${es.host.port}")
    private int hostPort = 9300;  //端口


    private TransportClient client;

    private BulkProcessor bulkProcessor;
    private int bulkActions = 20000;
    private long bulkByteSize = 15;
    private long bulkTimeValueSeconds = 30;
    private int bulkConcurrentRequests = 0;


    @Override
    public void afterPropertiesSet() throws Exception {
        initClient();
        initBulkProcessor();
    }

    private void initClient() {
        Settings settings = Settings.builder()
                .put("cluster.name", clusterName)//设置ES实例的名称
                .put("client.transport.sniff", true)//自动嗅探整个集群的状态，把集群中其他ES节点的ip添加到本地的客户端列表中
                .build();
        try {
            client = new PreBuiltTransportClient(settings)
                    //此步骤添加IP，至少一个，其实一个就够了，因为添加了自动嗅探配置
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), hostPort));
        } catch (UnknownHostException e) {
            logger.error(e.toString());
            e.printStackTrace();
        }
    }

    private void initBulkProcessor() {
        bulkProcessor = BulkProcessor
                .builder(client, new BulkProcessor.Listener() {

                    @Override
                    public void beforeBulk(long arg0, BulkRequest arg1) {
                        logger.info("executionId: " + arg0);
                        logger.info("numberOfActions: " + arg1.numberOfActions());
                    }

                    @Override
                    public void afterBulk(long executionId, BulkRequest bulkRequest,
                                          BulkResponse bulkResponse) {
                        logger.info("bulk done with executionId: " + executionId);
                        List<DocWriteRequest> requests = bulkRequest.requests();
                        int toberetry = 0;
                        int totalFailed = 0;
                        for (BulkItemResponse item : bulkResponse.getItems()) {
                            if (item.isFailed()) {
                                switch (item.getFailure().getStatus()) {
                                    case TOO_MANY_REQUESTS:
                                    case SERVICE_UNAVAILABLE:
                                        if (toberetry == 0) {
                                            logger.error("bulk has failed item which NEED to retry");
                                            logger.error(item.getFailureMessage());
                                        }
                                        toberetry++;
                                        bulkProcessor.add(requests.get(item.getItemId()));
                                        break;
                                    default:
                                        if (totalFailed == 0) {
                                            logger.error("bulk has failed item which do NOT need to retry");
                                            logger.error(item.getFailureMessage());
                                        }
                                        break;
                                }
                                totalFailed++;
                            }
                        }

                        if (totalFailed > 0) {
                            logger.info(totalFailed + " doc failed, " + toberetry + " need to retry");
                        } else {
                            logger.debug("no failed docs");
                        }

                        if (toberetry > 0) {
                            try {
                                logger.info("sleep " + toberetry / 2 + "millseconds after bulk failure");
                                Thread.sleep(toberetry / 2);
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        } else {
                            logger.debug("no docs need to retry");
                        }
                    }

                    @Override
                    public void afterBulk(long arg0, BulkRequest arg1,
                                          Throwable arg2) {
                        logger.error("bulk got exception");
                        logger.error(arg2.getMessage());
                    }
                }).setBulkActions(bulkActions)
                .setBulkSize(new ByteSizeValue(bulkByteSize, ByteSizeUnit.MB))
                .setFlushInterval(TimeValue.timeValueSeconds(bulkTimeValueSeconds))
                .setConcurrentRequests(bulkConcurrentRequests)
                        //.setBackoffPolicy(
                        //        BackoffPolicy.exponentialBackoff(TimeValue.timeValueMillis(100), 3))
                .build();
    }

    public TransportClient getClient() {
        return client;
    }

    public void setClient(TransportClient client) {
        this.client = client;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getHostPort() {
        return hostPort;
    }

    public void setHostPort(int hostPort) {
        this.hostPort = hostPort;
    }


    public BulkProcessor getBulkProcessor() {
        return bulkProcessor;
    }

    public void setBulkProcessor(BulkProcessor bulkProcessor) {
        this.bulkProcessor = bulkProcessor;
    }

    public long getBulkByteSize() {
        return bulkByteSize;
    }

    public void setBulkByteSize(long bulkByteSize) {
        this.bulkByteSize = bulkByteSize;
    }

    public long getBulkTimeValueSeconds() {
        return bulkTimeValueSeconds;
    }

    public void setBulkTimeValueSeconds(long bulkTimeValueSeconds) {
        this.bulkTimeValueSeconds = bulkTimeValueSeconds;
    }

    public int getBulkConcurrentRequests() {
        return bulkConcurrentRequests;
    }

    public void setBulkConcurrentRequests(int bulkConcurrentRequests) {
        this.bulkConcurrentRequests = bulkConcurrentRequests;
    }

    //====================================================================================================================================================

    /**
     * 创建索引
     *
     * @param index
     * @param shardsNum   分片数
     * @param replicasNum 备份数
     */

    public boolean createIndex(String index, String shardsNum, String replicasNum) {

        Settings settings = Settings.builder()
                //.put("index.number_of_shards", 3)
                //.put("index.number_of_replicas", 2)
                .build();

        //String settingsJson="{\"analysis\":{\"analyzer\":{\"ik\":{\"tokenizer\":\"ik_smart\"}}}}";
        CreateIndexResponse indexresponse = client.admin().indices().prepareCreate(index) // 这个索引库的名称还必须不包含大写字母
                .setSettings(settings)//设置分片数
                        //.setSettings(settingsJson, XContentType.JSON)//在新建索引的时候配置默认的分词器IK
                .get();

        return indexresponse.isAcknowledged();
    }


    /**
     * 判断索引是否存在
     *
     * @param indices
     * @return
     */

    public boolean isIndexExist(String... indices) {

        IndicesExistsResponse inExistsResponse = client.admin().indices().exists(new IndicesExistsRequest(indices)).actionGet();
        return inExistsResponse.isExists();
    }

    /**
     * 得到索引的配置信息
     *
     * @param indices
     */
    private void getSetting(String... indices) {

        //检索设置：
        GetSettingsResponse response = client.admin().indices()
                .prepareGetSettings(indices).get();
        for (ObjectObjectCursor<String, Settings> cursor : response.getIndexToSettings()) {
            String index = cursor.key;
            Settings settings = cursor.value;
            Integer shards = settings.getAsInt("index.number_of_shards", null);
            Integer replicas = settings.getAsInt("index.number_of_replicas", null);
        }
    }

    /**
     * 读取索引元数据信息
     */

    public void readIndicesTypesMappingsMetadata() throws ExecutionException, InterruptedException, IOException {


        IndicesAdminClient indicesAdminClient = client.admin().indices();
        GetMappingsResponse getMappingsResponse = indicesAdminClient.getMappings(new GetMappingsRequest()).get();
        ImmutableOpenMap<String, ImmutableOpenMap<String, MappingMetaData>> mappings =
                getMappingsResponse.getMappings();
        Iterator<ObjectObjectCursor<String, ImmutableOpenMap<String, MappingMetaData>>>
                mappingIterator = mappings.iterator();
        while (mappingIterator.hasNext()) {
            ObjectObjectCursor<String, ImmutableOpenMap<String, MappingMetaData>>
                    objectObjectCursor = mappingIterator.next();
            logger.debug("index: {}", objectObjectCursor.key);
            ImmutableOpenMap<String, MappingMetaData> immutableOpenMap = objectObjectCursor.value;
            ObjectLookupContainer<String> keys = immutableOpenMap.keys();
            Iterator<ObjectCursor<String>> keysIterator = keys.iterator();
            while (keysIterator.hasNext()) {
                String type = keysIterator.next().value;
                logger.debug("type: {}", type);
                MappingMetaData mappingMetaData = immutableOpenMap.get(type);
                Map<String, Object> mapping = mappingMetaData.getSourceAsMap();
                if (mapping.containsKey("properties")) {
                    Map<String, Object> properties = (Map<String, Object>) mapping.get("properties");
                    for (String attribute : properties.keySet()) {
                        logger.debug("attribute: {}", attribute);
                    }
                }
            }
        }
    }

    /**
     * 删除索引
     *
     * @param index
     */

    public boolean deleteIndex(String index) throws ExecutionException, InterruptedException {

        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest(index);
        ActionFuture<DeleteIndexResponse> response = client.admin().indices().delete(deleteIndexRequest);
        return response.get().isAcknowledged();
    }


//====================================================================================================================================================


    /**
     * 创建索引类型表
     *
     * @param type
     * @param indices
     * @throws java.io.IOException
     */
    private boolean createIndexType(String type, String... indices) throws IOException {
        XContentBuilder mapping = jsonBuilder()
                .startObject()
                .startObject(type)
                .startObject("properties")
                .startObject("title").field("type", "string").field("store", "yes").endObject()
                .startObject("description").field("type", "string").field("index", "not_analyzed").endObject()
                .startObject("price").field("type", "double").endObject()
                .startObject("onSale").field("type", "boolean").endObject()
                .startObject("type").field("type", "integer").endObject()
                .startObject("createDate").field("type", "date").endObject()
                .endObject()
                .endObject()
                .endObject();
        return createIndexType(type, mapping, indices);
    }


    /**
     * 创建索引类型表
     *
     * @param type
     * @param builder
     * @param indices
     */

    public boolean createIndexType(String type, XContentBuilder builder, String... indices) {
        PutMappingRequest mapping = Requests.putMappingRequest(indices).type(type).source(builder);

        PutMappingResponse response = client.admin().indices().putMapping(mapping).actionGet();
        return response.isAcknowledged();
    }

//====================================================================================================================================================


    public void addDocument(String index, String type, String jsonString) {

        IndexResponse response = client.prepareIndex(index, type).setSource(jsonString, XContentType.JSON).execute().actionGet();
        // 索引名称
        String _index = response.getIndex();
        // 类型名称
        String _type = response.getType();
        // 文档id
        String _id = response.getId();
        // 版本(if it's the first time you index this document, you will get: 1)
        long _version = response.getVersion();
        logger.debug("createIndexData:  _index:" + _index + "; _type:" + _type + "; _id：" + _id + "; _version:" + _version);


        //IndexResponse response = client.prepareIndex("twitter", "tweet", "1")
        //        .setSource(jsonBuilder()
        //                        .startObject()
        //                        .field("user", "kimchy")
        //                        .field("postDate", new Date())
        //                        .field("message", "trying out Elasticsearch")
        //                        .endObject()
        //        )
        //        .get();
    }

    /**
     * 批量添加文档
     */

    public void addDocument(String index, String type, List<JSONObject> jsonObjects) {

        ////批量添加：
        //BulkRequestBuilder bulkRequestBuilder = client.prepareBulk();
        //for (int i = 0; i < jsonObjects.size(); i++) {
        //    bulkRequestBuilder.add(client.prepareIndex(index, type).setId(jsonObjects.get(i).getString("id")).setSource(jsonObjects.get(i).toJSONString(), XContentType.JSON));
        //}
        //BulkResponse bulkResponse = bulkRequestBuilder.execute().actionGet();
        //bulkRequestBuilder.request().requests().clear();
        //if (bulkResponse.hasFailures()) {
        //    //TODO:
        //}

        //批量添加：
        for (int i = 0; i < jsonObjects.size(); i++) {
            IndexRequest indexRequest = client.prepareIndex(index, type).setId(jsonObjects.get(i).getString("id")).setSource(jsonObjects.get(i).toJSONString(), XContentType.JSON).request();
            this.bulkProcessor.add(indexRequest);
        }
    }

    /**
     * 批量添加文档
     */

    public void bulkAddDocument(String index, String type, List<JSONObject> jsonObjects) {
        for (int i = 0; i < jsonObjects.size(); i++) {
            IndexRequest indexRequest = new IndexRequest(index, type).id(jsonObjects.get(i).getString("id")).source(jsonObjects.get(i).toJSONString(), XContentType.JSON);
            getBulkProcessor().add(indexRequest);
        }
    }

    //====================================================================================================================================================


    private boolean deleteIndex(String... indices) {

        //删除整个索引
        DeleteIndexResponse dResponse = client.admin().indices().prepareDelete(indices).execute().actionGet();

        if (dResponse.isAcknowledged()) {
            logger.info("delete index " + indices + "  successfully!");
        } else {
            logger.info("Fail to delete index " + indices);
        }
        return dResponse.isAcknowledged();

        //删除整个索引
        //client.admin().indices().delete(new DeleteIndexRequest(indexName)).actionGet();
    }

    private void deleteIndex(String type, String... indices) {
        //删除整个type
        QueryBuilder builder = QueryBuilders.typeQuery(type);//查询整个type

        DeleteByQueryAction.INSTANCE.newRequestBuilder(client).source(indices).filter(builder).execute().actionGet();
    }

    private void deleteIndex(String index, String type, String id) {

        client.prepareDelete(index, type, id).execute().actionGet();

        //指定删除（删除查询） 同步条件删除
        //BulkIndexByScrollResponse response =
        //        DeleteByQueryAction.INSTANCE.newRequestBuilder(client)
        //                .filter(QueryBuilders.matchQuery("gender", "male"))
        //                .source("persons")
        //.execute(new ActionListener<BulkIndexByScrollResponse>() {
        //                @Override
        //                public void onResponse(BulkIndexByScrollResponse response) {
        //                    long deleted = response.getDeleted();
        //                }
        //                @Override
        //                public void onFailure(Exception e) {
        //                    // Handle the exception
        //                }
        //            })
        //                .get();
        //
        //long deleted = response.getDeleted();

        //异步方式： 异步条件删除
        //DeleteByQueryAction.INSTANCE.newRequestBuilder(client)
        //        .filter(QueryBuilders.matchQuery("gender", "male"))
        //        .source("persons")
        //        .execute(new ActionListener<BulkIndexByScrollResponse>() {
        //            @Override
        //            public void onResponse(BulkIndexByScrollResponse response) {
        //                long deleted = response.getDeleted();
        //            }
        //            @Override
        //            public void onFailure(Exception e) {
        //                // Handle the exception
        //            }
        //        });
    }

    /**
     * 删除索引类型表所有数据，批量删除
     *
     * @param index
     * @param type
     */

    public void deleteIndexTypeAllData(String index, String type) {

        SearchResponse response = client.prepareSearch(index).setTypes(type)
                .setQuery(QueryBuilders.matchAllQuery()).setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setScroll(new TimeValue(60000)).setSize(10000).setExplain(false).execute().actionGet();
        BulkRequestBuilder bulkRequest = client.prepareBulk();
        while (true) {
            SearchHit[] hitArray = response.getHits().getHits();
            SearchHit hit = null;
            for (int i = 0, len = hitArray.length; i < len; i++) {
                hit = hitArray[i];
                DeleteRequestBuilder request = client.prepareDelete(index, type, hit.getId());
                bulkRequest.add(request);
            }
            BulkResponse bulkResponse = bulkRequest.execute().actionGet();
            if (bulkResponse.hasFailures()) {
                logger.error(bulkResponse.buildFailureMessage());
            }
            if (hitArray.length == 0) break;
            response = client.prepareSearchScroll(response.getScrollId())
                    .setScroll(new TimeValue(60000)).execute().actionGet();
        }
    }

    /**
     * 删除索引类型表所有数据，定制批量删除
     *
     * @param index
     * @param type
     */

    public void deleteIndexTypeAllDataWithProcessor(String index, String type) {

        SearchResponse response = client.prepareSearch(index).setTypes(type)
                .setQuery(QueryBuilders.matchAllQuery()).setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setScroll(new TimeValue(60000)).setSize(10000).setExplain(false).execute().actionGet();
        BulkProcessor.Listener listener = new BulkProcessor.Listener() {

            @Override
            public void beforeBulk(long executionId, BulkRequest request) {
                logger.info("request actions num {}", request.numberOfActions());
            }

            @Override
            public void afterBulk(long executionId, BulkRequest request,
                                  Throwable failure) {
                logger.error(failure.getMessage());
            }

            @Override
            public void afterBulk(long executionId, BulkRequest request,
                                  BulkResponse response) {
                if (response.hasFailures()) {
                    logger.error(response.buildFailureMessage());
                }
            }
        };
        BulkProcessor bulkProcessor = BulkProcessor.builder(client, listener)
                .setBulkActions(10000)
                .setBulkSize(new ByteSizeValue(1, ByteSizeUnit.GB))
                .setFlushInterval(TimeValue.timeValueSeconds(5))
                .setConcurrentRequests(1)
                .setBackoffPolicy(BackoffPolicy.exponentialBackoff(TimeValue.timeValueMillis(100), 3))
                .build();
        while (true) {
            SearchHit[] hitArray = response.getHits().getHits();
            SearchHit hit = null;
            for (int i = 0, len = hitArray.length; i < len; i++) {
                hit = hitArray[i];
                DeleteRequestBuilder request = client.prepareDelete(index, type, hit.getId());
                bulkProcessor.add(request.request());
            }
            if (hitArray.length == 0) break;
            response = client.prepareSearchScroll(response.getScrollId())
                    .setScroll(new TimeValue(60000)).execute().actionGet();
        }
        try {
            bulkProcessor.awaitClose(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * 根据ID删除索引类型表数据
     *
     * @param index
     * @param type
     * @param id
     */

    public void deleteIndexTypeDataById(String index, String type, String id) {

        DeleteResponse response = client.prepareDelete().setIndex(index)
                .setType(type).setId(id).execute().actionGet();
        //System.out.println(response.isFound());
    }

    /**
     * 根据条件删除索引类型表数据
     *
     * @param index
     * @param type
     * @param query
     */

    public void deleteIndexTypeDatasByQuery(String index, String type, QueryBuilder query) {

        SearchResponse response = client.prepareSearch(index).setTypes(type).setQuery(query)
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH).setScroll(new TimeValue(60000))
                .setSize(1000).setExplain(false).execute().actionGet();
        logger.info("total hits: {}", response.getHits().getTotalHits());
        BulkRequestBuilder bulkRequest = client.prepareBulk();
        while (true) {
            SearchHit[] hitArray = response.getHits().getHits();
            SearchHit hit = null;
            for (int i = 0, len = hitArray.length; i < len; i++) {
                hit = hitArray[i];
                DeleteRequestBuilder request = client.prepareDelete(index, type, hit.getId());
                bulkRequest.add(request);
            }
            BulkResponse bulkResponse = bulkRequest.execute().actionGet();
            if (bulkResponse.hasFailures()) {
                logger.error(bulkResponse.buildFailureMessage());
            }
            if (hitArray.length == 0) break;
            response = client.prepareSearchScroll(response.getScrollId())
                    .setScroll(new TimeValue(60000)).execute().actionGet();
        }
    }

    //====================================================================================================================================================


    private void update(String index, String type, JSONObject jsonObject) throws ExecutionException, InterruptedException {
        UpdateRequest updateRequest = new UpdateRequest();
        updateRequest.index(index).type(type).id(jsonObject.getString("id")).doc(jsonObject);

        client.update(updateRequest).get();

        ////也支持upsert，就是没有就创建
        //IndexRequest indexRequest = new IndexRequest("index", "type", "1")
        //        .source(jsonBuilder()
        //                .startObject()
        //                .field("name", "Joe Smith")
        //                .field("gender", "male")
        //                .endObject());
        //UpdateRequest updateRequest = new UpdateRequest("index", "type", "1")
        //        .doc(jsonBuilder()
        //                .startObject()
        //                .field("gender", "male")
        //                .endObject())
        //        .upsert(indexRequest);
        //client.update(updateRequest).get();
    }


//====================================================================================================================================================

    /**
     * 根据ID查询一条数据记录。
     *
     * @param id 要查询数据的ID。
     * @return 返回查询出来的记录对象的json字符串。
     */

    public String get(String index, String type, String id) {

        GetResponse getResponse = client
                .prepareGet()   // 准备进行get操作，此时还有真正地执行get操作。（与直接get的区别）
                .setIndex(index)  // 要查询的
                .setType(type)
                .setId(id)
                .get();
        return getResponse.getSourceAsString();
    }

    /**
     * 根据id读取索引类型表数据
     *
     * @param index
     * @param type
     * @param id
     */

    public Map<String, Object> searchById(String index, String type, String id) {

        GetResponse response = client.prepareGet(index, type, id)
                .execute().actionGet();
        return response.getSource();
        //Iterator<Map.Entry<String, Object>> rpItor = rpMap.entrySet().iterator();
        //while (rpItor.hasNext()) {
        //    Map.Entry<String, Object> rpEnt = rpItor.next();
        //    System.out.println(rpEnt.getKey() + " : " + rpEnt.getValue());
        //}
    }

    /**
     * 通过文档id获得文档内容
     *
     * @param index
     * @param type
     * @param id
     * @param fields
     * @return
     */

    public Map<String, Object> getSourceById(String index, String type, String id, String fields) {
        //fields是需要获得的列

        GetResponse getResponse = client.prepareGet(index, type, id).setFetchSource(fields.split(","), null).get();
        logger.debug(getResponse.getSourceAsString());
        return getResponse.getSource();
    }

    ///**
    // * 使用filter方式查询数据。
    // * @param index 数据所在的索引名
    // * @param type 数据所在的type
    // * @return
    // */
    //public List<String> queryByFilter(String index, String type) {
    //
    //    // 查询名为zhangsan的数据
    //    FilterBuilder filterBuilder = FilterBuilders.termFilter("name", "zhangsan");
    //    SearchResponse searchResponse =
    //            this.client
    //                    .prepareSearch()
    //                    .setIndices(index)
    //                    .setTypes(type)
    //                    .setPostFilter(filterBuilder)
    //                    .get();
    //
    //    List<String> docList = new ArrayList<String>();
    //    SearchHits searchHits = searchResponse.getHits();
    //    for (SearchHit hit : searchHits) {
    //        docList.add(hit.getSourceAsString());
    //    }
    //    return docList;
    //}

    private void testSearch() {


        //MultiSearch API
        SearchRequestBuilder srb1 = client
                .prepareSearch().setQuery(QueryBuilders.queryStringQuery("elasticsearch")).setSize(1);
        SearchRequestBuilder srb2 = client
                .prepareSearch().setQuery(QueryBuilders.matchQuery("name", "kimchy")).setSize(1);

        MultiSearchResponse sr = client.prepareMultiSearch()
                .add(srb1)
                .add(srb2)
                .get();

        //方式二
        MultiGetResponse multiGetItemResponses = client.prepareMultiGet()
                .add("twitter", "tweet", "1")
                .add("twitter", "tweet", "2", "3", "4")
                .add("another", "type", "foo")
                .get();

        long nbHits = 0;
        for (MultiSearchResponse.Item item : sr.getResponses()) {
            SearchResponse response = item.getResponse();
            nbHits += response.getHits().getTotalHits();
        }
    }


    public void query() {

        //QueryBuilder builder = QueryBuilders.typeQuery(type);//查询整个type
        //DeleteByQueryAction.INSTANCE.newRequestBuilder(client).source(indexName).filter(builder).execute().actionGet();


        //匹配所有
        //QueryBuilder queryBuilder = QueryBuilders.matchAllQuery();

        //设置查询条件
        QueryBuilder queryBuilder = QueryBuilders.disMaxQuery()
                .add(QueryBuilders.termQuery("cmd-statistic", "http.avg5"))
                .add(QueryBuilders.prefixQuery("info-type", "statistic"));

        //System.out.println(queryBuilder.toString());

        SearchResponse response = client.prepareSearch("INDEXNAME")
                .setQuery(queryBuilder).execute().actionGet();

        for (SearchHit hit : response.getHits().getHits()) {
            System.out.println("---->>hit.getId(): " + hit.getId());
            if (hit.getFields().containsKey("cmd-statistic")) {

                System.out.println("field.cmd-statistic: "
                        + hit.getFields().get("cmd-statistic").getValue());
            }
            System.out.println("cmd-statistic: " + hit.getSource().get("cmd-statistic"));
        }
    }


    public void search() {

        //搜索数据 （按照id查询）
        //System.out.println(client.prepareGet("index", "fulltext", "1").execute().actionGet().getSourceAsString());

        //Match Query
        QueryBuilder qb = QueryBuilders.matchQuery("name", "kimchy elasticsearch"); //name是field,kimchy elasticsearch是要查询的字符串

        // MultiMatch Query
        qb = QueryBuilders.multiMatchQuery(
                "kimchy elasticsearch",     // Text you are looking for //kimchy elasticsearch是要查询的字符串
                "user", "message"           // Fields you query on //user 和 message都是field
        );

        //Range Query
        qb = QueryBuilders
                .rangeQuery("price")
                .from(5)
                .to(10)
                .includeLower(true)
                .includeUpper(false); //price是field, 数字代表范围.除了from to还有lt gt等等...


        //Boolean Query 如果bool查询语句中不存在must,则必须至少有一个should查询,同时可以通过minimum_should_match参数来设置至少需要满足的should个数.
        qb = QueryBuilders
                .boolQuery()
                .must(QueryBuilders.termQuery("age", "0"))
                .should(QueryBuilders.termQuery("id", "0")) //在这里"id"是要查询的field,"0"是要查询的内容
        //.mustNot(QueryBuilders.termQuery("content", "test2"))
        //.should(QueryBuilders.termQuery("content", "test3"))
        //.setFilter(FilterBuilders.rangeFilter("age").from(12).to(18))  Filter 查询之二, FilterBuilders接下来会解释. 在这里"age"是要查询的field, 后面的数字是查询的条件范围
        ;


        SearchResponse response = client.prepareSearch("users") //设置要查询的索引(index)，可以多个。
                .setTypes("user") //设置type,可以多个。 这个在建立索引的时候同时设置了, 或者可以使用head工具查看
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(qb) // Query
                        //.setScroll(new TimeValue(60000))
                        //.setFilter(FilterBuilders.rangeFilter("age").from(0).to(100)) // Filter
                .setFrom(0).setSize(100).setExplain(true) //0-100 表示显示数量
                .execute().actionGet();
        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        for (int i = 0; i < hits.getHits().length; i++) {
            System.out.println(hits.getHits()[i].getSourceAsString());
        }
    }


    /**
     * 根据条件读取索引类型表数据
     *
     * @param index
     * @param type
     * @param query
     * @return
     */

    public List<Map<String, Object>> readIndexTypeDatasByQuery(String index, String type, QueryBuilder query) {

        SearchResponse response = client.prepareSearch(index).setTypes(type).setQuery(query)
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH).setScroll(new TimeValue(60000))
                .setSize(1000).setExplain(false).execute().actionGet();
        logger.info("total hits: " + response.getHits().getTotalHits());
        List<Map<String, Object>> datas = new ArrayList<Map<String, Object>>();
        while (true) {
            SearchHit[] hitArray = response.getHits().getHits();
            for (int i = 0, len = hitArray.length; i < len; i++) {
                datas.add(hitArray[i].getSource());
            }
            if (hitArray.length == 0) break;
            response = client.prepareSearchScroll(response.getScrollId())
                    .setScroll(new TimeValue(60000)).execute().actionGet();
        }
        return datas;
    }

    ///**
    // * 根据条件获得文档列表
    // *
    // * @param index           索引名称
    // * @param type            类型名称,可传入多个type逗号分隔
    // * @param startTime       开始时间
    // * @param endTime         结束时间
    // * @param pageSize        文档大小限制
    // * @param fields          需要的字段，逗号分隔（缺省为全部字段）
    // * @param keywordMatchStr
    // * @return
    // */
    //public Map<String, Object> getEsSearchResult(String index, String type, @Nullable Long startTime, @Nullable Long endTime, int pageFrom, int pageSize, String fields, String keywordMatchStr, boolean preciseQuery, String andTermStr, String orTermStr, String notTermStr) {
    //
    //    SearchRequestBuilder searchRequest = client.prepareSearch(index);
    //    if (StringUtils.isNotEmpty(type)) {
    //        searchRequest.setTypes(type.split(","));
    //    }
    //    BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
    //
    //    if (startTime != null || endTime != null) {
    //        RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("collectTime");
    //        if (startTime == null) {
    //            rangeQuery
    //                    .format("epoch_millis")
    //                    .from(Long.MIN_VALUE)
    //                    .includeLower(true);
    //        } else {
    //            rangeQuery
    //                    .format("epoch_millis")
    //                    .from(startTime)
    //                    .includeLower(true);
    //        }
    //        if (endTime == null) {
    //            rangeQuery
    //                    .format("epoch_millis")
    //                    .to(Long.MAX_VALUE)
    //                    .includeUpper(true);
    //        } else {
    //            rangeQuery
    //                    .format("epoch_millis")
    //                    .to(endTime)
    //                    .includeUpper(true);
    //        }
    //        boolQuery.must(rangeQuery);
    //    }
    //
    //    if (StringUtils.isNotEmpty(keywordMatchStr)) {
    //        for (String s : keywordMatchStr.split(",")) {
    //            String[] ss = s.split("=");
    //            if (ss.length > 1) {
    //                if (preciseQuery) {
    //                    boolQuery.should(QueryBuilders.termQuery(ss[0], ss[1]));
    //                    //boolQuery.should(QueryBuilders.prefixQuery(s.split("=")[0], s.split("=")[1]));
    //                } else {
    //                    boolQuery.should(QueryBuilders.matchQuery(ss[0], ss[1]));
    //                    //boolQuery.must(QueryBuilders.matchQuery(s.split("=")[0], s.split("=")[1]));
    //                }
    //            }
    //        }
    //    }
    //
    //    if (StringUtils.isNotEmpty(andTermStr)) {
    //        for (String s : andTermStr.split(",")) {
    //            String[] ss = s.split("=");
    //            if (ss.length > 1) {
    //                boolQuery.must(QueryBuilders.termQuery(ss[0], ss[1]));
    //            }
    //        }
    //    }
    //
    //    if (StringUtils.isNotEmpty(orTermStr)) {
    //        for (String s : orTermStr.split(",")) {
    //            String[] ss = s.split("=");
    //            if (ss.length > 1) {
    //                boolQuery.should(QueryBuilders.termQuery(ss[0], ss[1]));
    //            }
    //        }
    //    }
    //
    //    if (StringUtils.isNotEmpty(notTermStr)) {
    //        for (String s : notTermStr.split(",")) {
    //            String[] ss = s.split("=");
    //            if (ss.length > 1) {
    //                boolQuery.mustNot(QueryBuilders.termQuery(ss[0], ss[1]));
    //            }
    //        }
    //    }
    //
    //    searchRequest.setQuery(boolQuery);
    //    if (StringUtils.isNotEmpty(fields)) {
    //        searchRequest.setFetchSource(fields.split(","), null);
    //    }
    //    searchRequest.setFetchSource(true);
    //
    //    //设置高亮显示
    //    HighlightBuilder highlightBuilder = new HighlightBuilder().field("*").requireFieldMatch(false);
    //    highlightBuilder.preTags("<span class=\"text-red\">");
    //    highlightBuilder.postTags("</span>");
    //    searchRequest.highlighter(highlightBuilder);
    //
    //    SearchResponse response = searchRequest
    //            //.addSort("collectTime", SortOrder.DESC)
    //            .setFrom(pageFrom)
    //            .setSize(pageSize)
    //            .setExplain(true)//设置是否按查询匹配度排序
    //                    //设置查询类型：1.SearchType.DFS_QUERY_THEN_FETCH 精确查询； 2.SearchType.SCAN 扫描查询,无序
    //            .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
    //            .execute()
    //            .actionGet();
    //    //System.out.println(response.toString());
    //    SearchHits searchHits = response.getHits();
    //
    //    List<Map<String, Object>> dataList = new ArrayList<>();
    //    for (SearchHit searchHit : searchHits) {
    //
    //        Map<String, Object> source = searchHit.getSource();
    //        Map<String, HighlightField> highlightFields = searchHit.getHighlightFields();
    //
    //        //title高亮
    //        HighlightField titleField = highlightFields.get("title");
    //        if (titleField != null) {
    //            Text[] fragments = titleField.fragments();
    //            String title = "";
    //            for (Text text : fragments) {
    //                title += text;
    //            }
    //            source.put("title", title);
    //        }
    //
    //        //content高亮
    //        HighlightField contentField = highlightFields.get("content");
    //        if (contentField != null) {
    //            Text[] fragments = contentField.fragments();
    //            String content = "";
    //            for (Text text : fragments) {
    //                content += text;
    //            }
    //            source.put("content", content);
    //        }
    //        dataList.add(source);
    //    }
    //
    //    Map<String, Object> map = new HashMap<>();
    //    //总命中数
    //    long total = searchHits.getTotalHits();
    //    map.put("total", total);
    //    map.put("dataList", dataList);
    //    return map;
    //
    //    //List<String> jsonStringList = new ArrayList<>();
    //    //for (SearchHit searchHit : searchHits) {
    //    //    jsonStringList.add(searchHit.getSourceAsString());
    //    //}
    //    //EsSearchResponse esSearchResponse = new EsSearchResponse(searchHits.getTotalHits(), jsonStringList);
    //    //return esSearchResponse;
    //
    //    //sourceList = new ArrayList<Map<String, Object>>();
    //    //for (SearchHit sh : searchHits) {
    //    //    sh.getSource().put("id", sh.getId());
    //    //    sourceList.add(sh.getSource());
    //    //}
    //    //
    //    //logger.debug("GET DOCS SIZE: " + sourceList.size());
    //    //return sourceList;
    //}


    public Map<String, Object> getEsSearchResult(String index, String type, @Nullable Long startTime, @Nullable Long endTime, int pageFrom, int pageSize, String fields,  BoolQueryBuilder boolQuery) {

        SearchRequestBuilder searchRequest = client.prepareSearch(index);
        if (StringUtils.isNotEmpty(type)) {
            searchRequest.setTypes(type.split(","));
        }

        if(boolQuery==null) {
            boolQuery = QueryBuilders.boolQuery();
        }
        if (startTime != null || endTime != null) {
            RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("collectTime");
            if (startTime == null) {
                rangeQuery
                        .format("epoch_millis")
                        .from(Long.MIN_VALUE)
                        .includeLower(true);
            } else {
                rangeQuery
                        .format("epoch_millis")
                        .from(startTime)
                        .includeLower(true);
            }
            if (endTime == null) {
                rangeQuery
                        .format("epoch_millis")
                        .to(Long.MAX_VALUE)
                        .includeUpper(true);
            } else {
                rangeQuery
                        .format("epoch_millis")
                        .to(endTime)
                        .includeUpper(true);
            }
            boolQuery.must(rangeQuery);
        }

        searchRequest.setQuery(boolQuery);
        if (StringUtils.isNotEmpty(fields)) {
            searchRequest.setFetchSource(fields.split(","), null);
        }
        searchRequest.setFetchSource(true);

        //设置高亮显示
        HighlightBuilder highlightBuilder = new HighlightBuilder().field("*").requireFieldMatch(false);
        highlightBuilder.preTags("<span class=\"text-red\">");
        highlightBuilder.postTags("</span>");
        searchRequest.highlighter(highlightBuilder);

        System.out.println(searchRequest.toString());
        SearchResponse response = searchRequest
                //.addSort("businessTypeId", SortOrder.ASC)
                //.addSort("collectTime", SortOrder.DESC)
                .setFrom(pageFrom)
                .setSize(pageSize)
                .setExplain(true)//设置是否按查询匹配度排序
                        //设置查询类型：1.SearchType.DFS_QUERY_THEN_FETCH 精确查询； 2.SearchType.SCAN 扫描查询,无序
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .execute()
                .actionGet();
        SearchHits searchHits = response.getHits();

        List<Map<String, Object>> dataList = new ArrayList<>();
        for (SearchHit searchHit : searchHits) {

            Map<String, Object> source = searchHit.getSource();
            Map<String, HighlightField> highlightFields = searchHit.getHighlightFields();

            //title高亮
            HighlightField name1Field = highlightFields.get("name1");
            if (name1Field != null) {
                Text[] fragments = name1Field.fragments();
                String name1 = "";
                for (Text text : fragments) {
                    name1 += text;
                }
                source.put("name1", name1);
            }

            //title高亮
            HighlightField name2Field = highlightFields.get("name2");
            if (name2Field != null) {
                Text[] fragments = name2Field.fragments();
                String name2 = "";
                for (Text text : fragments) {
                    name2 += text;
                }
                source.put("name2", name2);
            }

            //title高亮
            HighlightField idCardNum1Field = highlightFields.get("idCardNum1");
            if (idCardNum1Field != null) {
                Text[] fragments = idCardNum1Field.fragments();
                String idCardNum1 = "";
                for (Text text : fragments) {
                    idCardNum1 += text;
                }
                source.put("idCardNum1", idCardNum1);
            }

            //title高亮
            HighlightField idCardNum2Field = highlightFields.get("idCardNum2");
            if (idCardNum2Field != null) {
                Text[] fragments = idCardNum2Field.fragments();
                String idCardNum2 = "";
                for (Text text : fragments) {
                    idCardNum2 += text;
                }
                source.put("idCardNum2", idCardNum2);
            }

            //content高亮
            HighlightField contentField = highlightFields.get("content");
            if (contentField != null) {
                Text[] fragments = contentField.fragments();
                String content = "";
                for (Text text : fragments) {
                    content += text;
                }
                source.put("content", content);
            }
            dataList.add(source);
        }

        Map<String, Object> map = new HashMap<>();
        //总命中数
        long total = searchHits.getTotalHits();
        map.put("total", total);
        map.put("dataList", dataList);
        return map;
    }


    public List<String> searchSuggestion(String index, String type, String field, String prefix, int size) {
        List<String> suggests = new ArrayList<String>();

        CompletionSuggestionBuilder compBuilder = new CompletionSuggestionBuilder(field);
        compBuilder.text(prefix);
        compBuilder.size(size);

        String suggestionName = "complete";
        SuggestBuilder suggestBuilder = new SuggestBuilder();
        suggestBuilder.addSuggestion(suggestionName, compBuilder);

        SearchResponse searchResponse = client.prepareSearch(index)
                .setTypes(type)
                .setQuery(QueryBuilders.matchAllQuery())
                .suggest(suggestBuilder)
                .execute().actionGet();

        CompletionSuggestion compSuggestion = searchResponse.getSuggest().getSuggestion(suggestionName);
        List<? extends Suggest.Suggestion.Entry<? extends Suggest.Suggestion.Entry.Option>> list = compSuggestion.getEntries();
        if (list != null) {
            for (Suggest.Suggestion.Entry<? extends Suggest.Suggestion.Entry.Option> e : list) {
                for (Suggest.Suggestion.Entry.Option option : e) {
                    suggests.add(option.getText().toString());
                }
            }
        }
        return suggests;
    }
//====================================================================================================================================================


    /**
     * 根据列名读取索引类型表的分组信息
     *
     * @param index
     * @param type
     * @param groupFieldName
     */
    public static void readIndexTypeDatasWithGroup(String index, String type, String groupFieldName) {
        //String groupFieldAgg = groupFieldName + "Agg";
        //Client client = esClient().getClient();
        //TermsBuilder termsBuilder = AggregationBuilders.terms(groupFieldAgg)
        //        .size(Integer.MAX_VALUE).field(groupFieldName);
        //SearchResponse response = client.prepareSearch(index).setTypes(type)
        //        .setQuery(QueryBuilders.matchAllQuery())
        //        .addAggregation(termsBuilder).execute().actionGet();
        //Terms terms = response.getAggregations().get(groupFieldAgg);
        //if (null != terms) {
        //    List<Bucket> buckets = terms.getBuckets();
        //    for (int i = 0, len = buckets.size(); i < len; i++) {
        //        Bucket bucket = buckets.get(i);
        //        System.out.println(bucket.getKey() + " - " + bucket.getDocCount());
        //    }
        //}
    }

    /**
     * 根据列名读取索引类型表的分组信息，二次分组
     *
     * @param index
     * @param type
     * @param groupFieldName
     * @param subGroupFieldName
     */
    public static void readIndexTypeDatasWithGroup(String index, String type, String groupFieldName,
                                                   String subGroupFieldName) {
        //String groupFieldAgg = groupFieldName + "Agg";
        //String subGroupFieldAgg = subGroupFieldName + "Agg";
        //Client client = esClient().getClient();
        //TermsBuilder subTermsBuilder = AggregationBuilders.terms(subGroupFieldAgg)
        //        .size(Integer.MAX_VALUE).field(subGroupFieldName);
        //TermsBuilder termsBuilder = AggregationBuilders.terms(groupFieldAgg)
        //        .size(Integer.MAX_VALUE).field(groupFieldName).subAggregation(subTermsBuilder);
        //SearchResponse response = client.prepareSearch(index).setTypes(type)
        //        .setQuery(QueryBuilders.matchAllQuery())
        //        .addAggregation(termsBuilder).execute().actionGet();
        //Terms terms = response.getAggregations().get(groupFieldAgg);
        //if (null != terms) {
        //    List<Bucket> buckets = terms.getBuckets();
        //    for (int i = 0, len = buckets.size(); i < len; i++) {
        //        Bucket bucket = buckets.get(i);
        //        System.out.println(bucket.getKey() + " - " + bucket.getDocCount());
        //        Terms subTerms = bucket.getAggregations().get(subGroupFieldAgg);
        //        if (null != subTerms) {
        //            List<Bucket> subBuckets = subTerms.getBuckets();
        //            for (int j = 0, slen = subBuckets.size(); j < slen; j++) {
        //                Bucket subBucket = subBuckets.get(j);
        //                System.out.println(subBucket.getKey() + " - " + subBucket.getDocCount());
        //            }
        //        }
        //    }
        //}
    }

    /**
     * 读取索引类型表指定列名的平均值
     *
     * @param index
     * @param type
     * @param avgField
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static double readIndexTypeFieldValueWithAvg(String index, String type, String avgField) {
        //Client client = esClient().getClient();
        //String avgName = avgField + "Avg";
        //MetricsAggregationBuilder aggregation = AggregationBuilders.avg(avgName).field(avgField);
        //SearchResponse response = client.prepareSearch(index).setTypes(type)
        //        .setQuery(QueryBuilders.matchAllQuery())
        //        .addAggregation(aggregation).execute().actionGet();
        //Avg avg = response.getAggregations().get(avgName);
        //return avg.getValue();
        return Double.MAX_VALUE;
    }

    /**
     * 读取索引类型表指定列名的总和
     *
     * @param index
     * @param type
     * @param sumField
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static double readIndexTypeFieldValueWithSum(String index, String type, String sumField) {
        //Client client = esClient().getClient();
        //String sumName = sumField + "Sum";
        //MetricsAggregationBuilder aggregation = AggregationBuilders.sum(sumName).field(sumField);
        //SearchResponse response = client.prepareSearch(index).setTypes(type)
        //        .setQuery(QueryBuilders.matchAllQuery())
        //        .addAggregation(aggregation).execute().actionGet();
        //Sum sum = response.getAggregations().get("priceSum");
        //return sum.getValue();
        return Double.MAX_VALUE;
    }

    /**
     * 读取指定索引指定类型表的总记录数
     *
     * @param indices
     * @param types
     * @return
     */
    public long readIndicesTypesDatasCount(String[] indices, String types) {

        SearchRequestBuilder searchRequestBuilder = client.prepareSearch(indices).setTypes(types);
        searchRequestBuilder.setQuery(QueryBuilders.matchAllQuery());
        searchRequestBuilder.setSearchType(SearchType.QUERY_THEN_FETCH);
        SearchResponse response = searchRequestBuilder.execute().actionGet();
        return response.getHits().getTotalHits();
    }


    //====================================================================================================================================================

    private void testClusterAdmin() {

        //ClusterAdminClient clusterAdminClient = client.admin().cluster();

        //集群健康
        ClusterHealthResponse healths = client.admin().cluster().prepareHealth().get();
        String clusterName = healths.getClusterName();
        int numberOfDataNodes = healths.getNumberOfDataNodes();
        int numberOfNodes = healths.getNumberOfNodes();

        for (ClusterIndexHealth health : healths.getIndices().values()) {
            String index = health.getIndex();
            int numberOfShards = health.getNumberOfShards();
            int numberOfReplicas = health.getNumberOfReplicas();
            ClusterHealthStatus status = health.getStatus();
        }

        //集群状态
        //client.admin().cluster().prepareHealth()
        //        .setWaitForYellowStatus()
        //        .get();
        //client.admin().cluster().prepareHealth("company")
        //        .setWaitForGreenStatus()
        //        .get();
        //
        //client.admin().cluster().prepareHealth("employee")
        //        .setWaitForGreenStatus()
        //        .setTimeout(TimeValue.timeValueSeconds(2))
        //        .get();
    }


    public void close() {
        client.close();
    }

    /**
     * 分词
     *
     * @param index
     * @param text
     */

    public void analyze(String index, String text) {

        AnalyzeRequestBuilder request = new AnalyzeRequestBuilder(client, AnalyzeAction.INSTANCE, index, text);
        request.setAnalyzer("ik");
        List<AnalyzeResponse.AnalyzeToken> analyzeTokens = request.execute().actionGet().getTokens();
        for (int i = 0, len = analyzeTokens.size(); i < len; i++) {
            AnalyzeResponse.AnalyzeToken analyzeToken = analyzeTokens.get(i);
            System.out.println(analyzeToken.getTerm());
        }
    }


    private void testBulkAPI() throws IOException {

        //Bulk API 索引和删除在一个请求
        BulkRequestBuilder bulkRequest = client.prepareBulk();

        bulkRequest.add(client.prepareIndex("twitter", "tweet", "1")
                        .setSource(jsonBuilder()
                                        .startObject()
                                        .field("user", "kimchy")
                                        .field("postDate", new Date())
                                        .field("message", "trying out Elasticsearch")
                                        .endObject()
                        )
        );
        bulkRequest.add(client.prepareIndex("twitter", "tweet", "2")
                        .setSource(jsonBuilder()
                                        .startObject()
                                        .field("user", "kimchy")
                                        .field("postDate", new Date())
                                        .field("message", "another post")
                                        .endObject()
                        )
        );

        BulkResponse bulkResponse = bulkRequest.get();
        if (bulkResponse.hasFailures()) {
            // process failures by iterating through each bulk response item
        }
    }
}