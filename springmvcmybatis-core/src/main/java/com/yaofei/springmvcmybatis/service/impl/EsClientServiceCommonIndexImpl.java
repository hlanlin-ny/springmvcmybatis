package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.dto.es.index.CommonIndex;
import com.yaofei.springmvcmybatis.service.EsClientServiceCommonIndex;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * Created by phoenix on 2017/8/2.
 */
@Service("esClientServiceCommonIndex")
public class EsClientServiceCommonIndexImpl extends AbstractBaseEsClientService<CommonIndex> implements EsClientServiceCommonIndex {

    @Override
    protected boolean createIndexType(String indexName, String typeName) throws IOException {
        //属性解说
        //        index
        //可选值为analyzed(默认)和no，如果是字段是字符串类型的，则可以是not_analyzed.
        // 1 analyzed 先分词，再索引，全文搜索
        // 2 not_analyzed 索引这个字段，这样可以被搜索，但是直接索引，不分词。
        // 3 no 不要索引这个字段，这个字段也不会被搜出来。
        // string字段默认是analyzed.
        // 其它简单的字段类型-long, double,date etc ，也可以接收index参数，不过只可以取值no ,not_analyzed.
        //        analyzer
        //对于需要分词的string字段，analyzer属性决定使用哪个分词器，默认，使用standard分词器。
        //但是你可以设置为一个内置的分词器，比如 whitespace,simple,english.
        //        store
        //可选值为yes或no，指定该字段的原始值是否被写入索引中，默认为no，即结果中不能返回该字段。
        //        boost
        //默认为1，定义了文档中该字段的重要性，越高越重要
        //        null_value
        //如果一个字段为null值(空数组或者数组都是null值)的话不会被索引及搜索到，null_value参数可以显示替代null values为指定值，这样使得字段可以被搜索到。
        //        include_in_all
        //指定该字段是否应该包括在_all字段里头，默认情况下都会包含。
        //XContentBuilder xContentBuilder = jsonBuilder()
        //        .startObject()
        //        .startObject("_all").field("enabled", "true").field("analyzer", "ik_max_word").endObject()
        //        .startObject("properties")
        //        .startObject("id").field("type", "string").field("index", "not_analyzed").field("store", "yes").endObject()
        //        .startObject("areaId").field("type", "long").field("index", "not_analyzed").field("store", "yes").endObject()
        //        .startObject("areaName").field("type", "string").field("index", "not_analyzed").field("store", "yes").endObject()
        //        .startObject("businessTypeId").field("type", "long").field("index", "not_analyzed").field("store", "yes").endObject()
        //        .startObject("businessTypeName").field("type", "string").field("index", "not_analyzed").field("store", "yes").endObject()
        //        .startObject("fileType").field("type", "integer").field("index", "not_analyzed").field("store", "yes").endObject()
        //        .startObject("title").field("type", "string").field("analyzer", "ik_smart").endObject()
        //        .startObject("content").field("type", "string").field("analyzer", "ik_max_word").endObject()
        //        .startObject("url").field("type", "string").field("index", "not_analyzed").field("store", "yes").endObject()
        //        .startObject("collectTime").field("type", "date").field("index", "not_analyzed").endObject()
        //        .startObject("createdTime").field("type", "date").field("index", "not_analyzed").endObject()
        //        .startObject("suggest").field("type", "completion").field("analyzer", "ik_smart").endObject()
        //        .endObject()
        //        .endObject();


        XContentBuilder xContentBuilder = jsonBuilder()
                .startObject()
                .startObject("_all").field("enabled", "true").field("analyzer", "ik_max_word").endObject()
                .startObject("properties")
                .startObject("id").field("type", "string").field("index", "not_analyzed").field("store", "yes").endObject()
                .startObject("areaId").field("type", "long").field("index", "not_analyzed").field("store", "yes").endObject()
                .startObject("areaName").field("type", "string").field("index", "not_analyzed").field("store", "yes").endObject()
                .startObject("businessTypeId").field("type", "long").field("index", "not_analyzed").field("store", "yes").endObject()
                .startObject("businessTypeName").field("type", "string").field("index", "not_analyzed").field("store", "yes").endObject()
                .startObject("informationProvider").field("type", "string").field("index", "not_analyzed").field("store", "yes").endObject()
                .startObject("providerAddress").field("type", "string").field("index", "not_analyzed").field("store", "yes").endObject()
                .startObject("policeOffice").field("type", "string").field("index", "not_analyzed").field("store", "yes").endObject()
                .startObject("contactPerson").field("type", "string").field("index", "not_analyzed").field("store", "yes").endObject()
                .startObject("contactPhone").field("type", "string").field("index", "not_analyzed").field("store", "yes").endObject()
                .startObject("emergencyContactPerson").field("type", "string").field("index", "not_analyzed").field("store", "yes").endObject()
                .startObject("emergencyContactPhone").field("type", "string").field("index", "not_analyzed").field("store", "yes").endObject()
                .startObject("fileType").field("type", "integer").field("index", "not_analyzed").field("store", "yes").endObject()
                //.startObject("title").field("type", "string").field("analyzer", "ik_smart").endObject()
                //.startObject("content").field("type", "string").field("analyzer", "ik_max_word").endObject()
                .startObject("name1").field("type", "string").field("analyzer", "ik_smart")
                .endObject()
                .startObject("idCardNum1").field("type", "string")
                //.field("analyzer", "ik_smart")
                .endObject()
                .startObject("location1").field("type", "string").field("analyzer", "ik_smart")
                .endObject()
                .startObject("dtTime").field("type", "date").field("index", "not_analyzed").endObject()
                .startObject("name2").field("type", "string").field("analyzer", "ik_smart")
                .endObject()
                .startObject("idCardNum2").field("type", "string")
                //.field("analyzer", "ik_smart")
                .endObject()
                .startObject("location2").field("type", "string").field("analyzer", "ik_smart").endObject()

                .startObject("content").field("type", "string").field("analyzer", "ik_max_word").endObject()

                .startObject("url").field("type", "string").field("index", "not_analyzed").field("store", "yes").endObject()
                .startObject("collectTime").field("type", "date").field("index", "not_analyzed").endObject()
                .startObject("createdTime").field("type", "date").field("index", "not_analyzed").endObject()
                .startObject("suggest").field("type", "completion").field("analyzer", "ik_smart").endObject()
                .endObject()
                .endObject();

        return esClient.createIndexType(typeName, xContentBuilder, indexName);
    }

    //http://localhost:9200/_analyze?analyzer=ik_max_word&pretty=true&text=41130219851001457X
    //http://localhost:9200/_analyze?analyzer=ik_smart&pretty=true&text=41130219851001457X
    //验证中文分词
    //        终端中输入命令
    //curl -XGET 'http://10.202.105.41:9200/_analyze?pretty&analyzer=ik_max_word' -d '联想是全球最大的笔记本厂商'
}