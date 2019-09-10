package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.component.es.ESClient;
import com.yaofei.springmvcmybatis.dto.es.CommonIndexDate;
import com.yaofei.springmvcmybatis.dto.es.EsSearchResult;
import com.yaofei.springmvcmybatis.dto.es.EsSearchResultTimeline;
import com.yaofei.springmvcmybatis.dto.es.index.CommonIndex;
import com.yaofei.springmvcmybatis.dto.es.index.CommonIndexTimeline;
import com.yaofei.springmvcmybatis.dto.exprotsearchresult.Track;
import com.yaofei.springmvcmybatis.dto.exprotsearchresult.TrackDetail;
import com.yaofei.springmvcmybatis.entity.*;
import com.yaofei.springmvcmybatis.exception.BussinessException;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;
import com.yaofei.springmvcmybatis.repository.ActivityDetailRepository;
import com.yaofei.springmvcmybatis.runnable.SaveSearchLogRunnable;
import com.yaofei.springmvcmybatis.service.IntelligenceBusinessTypeService;
import com.yaofei.springmvcmybatis.service.IntelligenceSharePermissionService;
import com.yaofei.springmvcmybatis.service.SearchLogService;
import com.yaofei.springmvcmybatis.service.SearchService;
import com.yaofei.springmvcmybatis.utils.DateTimeUtil;
import com.yaofei.springmvcmybatis.utils.DocUtil;
import freemarker.template.TemplateException;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.util.*;

/**
 * Created by phoenix on 2017/8/4.
 */
@Service("searchService")
public class SearchServiceImpl implements SearchService {

    private static final String INDEX = "commonindex_index_*";
    private static final String TYPE = "commonindex";
    private static final int DEFAULT_PAGE_SIZE = 10;
    private final static String UPLOAD_DIR = "export";

    private final static List<String> DATE_BACKGROUND_COLOR = Arrays.asList("bg-red", "bg-orange", "bg-yellow", "bg-fuchsia", "bg-green", "bg-purple", "bg-maroon");

    @Autowired
    private SearchLogService searchLogService;
    @Autowired
    private ESClient esClient;
    @Autowired
    private IntelligenceSharePermissionService intelligenceSharePermissionService;
    @Autowired
    private IntelligenceBusinessTypeService intelligenceBusinessTypeService;
    @Autowired
    private ActivityDetailRepository activityDetailRepository;


    @Override
    public  List<MedicalCheckinCheckoutRecordTransfer> selectMarder(String idCard, String name) {
        List<MedicalCheckinCheckoutRecordTransfer> medicalCheckinCheckoutRecordTransfer = activityDetailRepository.selectMarder(idCard, name);
        return medicalCheckinCheckoutRecordTransfer;
    }
    @Override
    public  List<MedicalOutpatientRecordTransfer> selectPatient(String idCard, String name) {
        List<MedicalOutpatientRecordTransfer> medicalOutpatientRecordTransfer = activityDetailRepository.selectPatient(idCard, name);
        return medicalOutpatientRecordTransfer;
    }
    @Override
    public EsSearchResult querySearchResult(Integer datasourceType, List<Long> intelligenceBusinessTypeIds, String keyword, boolean preciseQuery, int pageIndex, int pageSize, Long userId, Long areaId, String username, List<Integer> fileTypes, String startTime, String endTime, HttpServletRequest request) {
        List<String> keywords = new ArrayList<>();
        if (StringUtils.isNotBlank(keyword)) {
            for (String s : keyword.split(" ")) {
                if (StringUtils.isNotBlank(s.trim())) {
                    keywords.add(s);
                }
            }
        }

        if (fileTypes == null || fileTypes.size() == 0) {
            fileTypes = new ArrayList<>();
            if (datasourceType == 1) {
            } else if (datasourceType == 2) {
                fileTypes.add(1);
            } else if (datasourceType == 3) {
                fileTypes.add(2);
                fileTypes.add(3);
                fileTypes.add(4);
                fileTypes.add(5);
                fileTypes.add(6);
                fileTypes.add(7);
                fileTypes.add(8);
                fileTypes.add(9);
                fileTypes.add(10);
            }
        }

        List<IntelligenceSharePermission> intelligenceSharePermissions = getIntelligenceSharePermissions(areaId);
        List<Long> areaIds = getRightAreaIds(areaId, intelligenceSharePermissions);
        List<Long> intelligenceBusinessTypeIdsNew = getIntelligenceBusinessTypeIds(areaId, intelligenceBusinessTypeIds, intelligenceSharePermissions);

        if (pageIndex == 1) {
            //异步记录下搜索日志
            aysnSaveSearchLog(datasourceType, intelligenceBusinessTypeIdsNew, keyword, userId, areaId, username, request);
        }

        Long startTimeLong = null;
        if (StringUtils.isNotBlank(startTime)) {
            startTimeLong = DateTimeUtil.dateFromStr(startTime).getTime();
        }
        Long endTimeLong = null;
        if (StringUtils.isNotBlank(endTime)) {
            endTimeLong = DateTimeUtil.dateFromStr(endTime).getTime();
        }

        if (pageSize == 0) {
            pageSize = DEFAULT_PAGE_SIZE;
        }

        return searchFromEs("", areaIds, intelligenceBusinessTypeIdsNew, fileTypes, keywords, true, preciseQuery, startTimeLong, endTimeLong, pageIndex, pageSize);
    }

    @Override
    public EsSearchResult querySearchResultNow(Integer datasourceType, List<Long> intelligenceBusinessTypeIds, String keyword, boolean preciseQuery, int pageIndex, int pageSize, Long userId, Long areaId, String username, List<Integer> fileTypes, String startTime, String endTime) {
        List<String> keywords = new ArrayList<>();
        if (StringUtils.isNotBlank(keyword)) {
            for (String s : keyword.split(" ")) {
                if (StringUtils.isNotBlank(s.trim())) {
                    keywords.add(s);
                }
            }
        }

        if (fileTypes == null || fileTypes.size() == 0) {
            fileTypes = new ArrayList<>();
            if (datasourceType == 1) {
            } else if (datasourceType == 2) {
                fileTypes.add(1);
            } else if (datasourceType == 3) {
                fileTypes.add(2);
                fileTypes.add(3);
                fileTypes.add(4);
                fileTypes.add(5);
                fileTypes.add(6);
                fileTypes.add(7);
                fileTypes.add(8);
                fileTypes.add(9);
                fileTypes.add(10);
            }
        }

        List<IntelligenceSharePermission> intelligenceSharePermissions = getIntelligenceSharePermissions(areaId);
        List<Long> areaIds = getRightAreaIds(areaId, intelligenceSharePermissions);
        List<Long> intelligenceBusinessTypeIdsNew = getIntelligenceBusinessTypeIds(areaId, intelligenceBusinessTypeIds, intelligenceSharePermissions);

        Long startTimeLong = null;
        if (StringUtils.isNotBlank(startTime)) {
            startTimeLong = DateTimeUtil.dateFromStr(startTime).getTime();
        }
        Long endTimeLong = null;
        if (StringUtils.isNotBlank(endTime)) {
            endTimeLong = DateTimeUtil.dateFromStr(endTime).getTime();
        }
        if (pageSize == 0) {
            pageSize = DEFAULT_PAGE_SIZE;
        }

        String indexName = "commonindex_index_" + DateTimeUtil.format(new Date(), "yyyy-MM");

        return searchFromEs(indexName, areaIds, intelligenceBusinessTypeIdsNew, fileTypes, keywords, true, preciseQuery, startTimeLong, endTimeLong, pageIndex, pageSize);
    }

    @Override
    public EsSearchResultTimeline querySearchResultTimeline(Integer datasourceType, List<Long> intelligenceBusinessTypeIds, String keyword, boolean preciseQuery, int pageIndex, int pageSize, Long userId, Long areaId, String username, List<Integer> fileTypes, String startTime, String endTime, HttpServletRequest request) {
        EsSearchResult searchResult = querySearchResult(datasourceType, intelligenceBusinessTypeIds, keyword, preciseQuery, pageIndex, pageSize, userId, areaId, username, fileTypes, startTime, endTime, request);

        //得到该行政区划下的
        //得到自己区域的所有的业务类型
        DataTablesRequest dataTablesRequest = new DataTablesRequest();
        Map<String, String> extraSearch = new HashMap<>();
        extraSearch.put("areaId", areaId.toString());
        dataTablesRequest.setExtraSearch(extraSearch);
        dataTablesRequest.setLength(10000);
        List<IntelligenceBusinessType> intelligenceBusinessTypes = intelligenceBusinessTypeService.queryList(dataTablesRequest);

        List<IntelligenceSharePermission> intelligenceSharePermissions = getIntelligenceSharePermissions(areaId);
        for (IntelligenceSharePermission intelligenceSharePermission : intelligenceSharePermissions) {
            IntelligenceBusinessType intelligenceBusinessType = intelligenceBusinessTypeService.queryObject(intelligenceSharePermission.getIntelligenceBusinessTypeId());
            intelligenceBusinessTypes.add(intelligenceBusinessType);
        }

        List<CommonIndexDate> commonIndexDates = new ArrayList<>();
        boolean haveDateNow = false;
        CommonIndexDate commonIndexDateNow = new CommonIndexDate();
        List<CommonIndexTimeline> commonIndexes = new ArrayList<>();
        for (CommonIndex commonIndex : searchResult.getHitDatas()) {
            //先判断有没有
            haveDateNow = false;
            for (CommonIndexDate commonIndexDate : commonIndexDates) {
                if (commonIndexDate.getDate().equals(DateTimeUtil.getFormatDate(commonIndex.getCreatedTime()))) {
                    haveDateNow = true;
                    commonIndexDateNow = commonIndexDate;
                    break;
                }
            }
            if (haveDateNow) {
                commonIndexDateNow.getHitDatas().add(convert(commonIndex, intelligenceBusinessTypes));
            } else {
                commonIndexes = new ArrayList<>();
                commonIndexes.add(convert(commonIndex, intelligenceBusinessTypes));
                commonIndexDateNow = new CommonIndexDate();
                commonIndexDateNow.setHitDatas(commonIndexes);
                commonIndexDateNow.setDate(DateTimeUtil.getFormatDate(commonIndex.getCreatedTime()));
                Calendar cal = Calendar.getInstance();
                cal.setTime(commonIndex.getCreatedTime());
                int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
                if (w < 0)
                    w = 0;
                commonIndexDateNow.setDateBackgroundColor(DATE_BACKGROUND_COLOR.get(w));
                commonIndexDates.add(commonIndexDateNow);
            }
        }

        EsSearchResultTimeline esSearchResultTimeline = new EsSearchResultTimeline();
        esSearchResultTimeline.setCommonIndexDates(commonIndexDates);
        esSearchResultTimeline.setPageIndex(searchResult.getPageIndex());
        esSearchResultTimeline.setTotalHits(searchResult.getTotalHits());

        return esSearchResultTimeline;
    }

    private CommonIndexTimeline convert(CommonIndex commonIndex, List<IntelligenceBusinessType> intelligenceBusinessTypes) {
        CommonIndexTimeline commonIndexTimeline = new CommonIndexTimeline();
        try {
            BeanUtils.copyProperties(commonIndexTimeline, commonIndex);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        for (IntelligenceBusinessType intelligenceBusinessType : intelligenceBusinessTypes) {
            if (intelligenceBusinessType.getId() == commonIndexTimeline.getBusinessTypeId()) {
                commonIndexTimeline.setTimelineItemIconClass(intelligenceBusinessType.getIcon() + " " + intelligenceBusinessType.getBackgroundColor());
                break;
            }
        }

        return commonIndexTimeline;
    }

    /*
     * 2017-08-31添加该方法
     */
    @Override
    public EsSearchResult querySearchResult(List<Long> intelligenceBusinessTypeIds, String keyword, boolean preciseQuery, Long userId, Long areaId, String username, List<Integer> fileTypes, Date startTime) {
        List<String> keywords = new ArrayList<>();
        if (StringUtils.isNotBlank(keyword)) {
            for (String s : keyword.split(" ")) {
                if (StringUtils.isNotBlank(s.trim())) {
                    keywords.add(s);
                }
            }
        }

        List<IntelligenceSharePermission> intelligenceSharePermissions = getIntelligenceSharePermissions(areaId);
        List<Long> areaIds = getRightAreaIds(areaId, intelligenceSharePermissions);
        List<Long> intelligenceBusinessTypeIdsNew = getIntelligenceBusinessTypeIds(areaId, intelligenceBusinessTypeIds, intelligenceSharePermissions);

        Long startTimeLong = null;
        if (startTime != null) {
            startTimeLong = startTime.getTime();
        }
        Long endTimeLong = (new Date()).getTime();

        String indexName = "commonindex_index_" + DateTimeUtil.format(new Date(), "yyyy-MM");
        return searchFromEs(indexName, areaIds, intelligenceBusinessTypeIdsNew, fileTypes, keywords, true, preciseQuery, startTimeLong, endTimeLong, 0, DEFAULT_PAGE_SIZE);
    }

    @Override
    public String genQuerySearchResult(Integer datasourceType, List<Long> intelligenceBusinessTypeIds, String keyword, boolean preciseQuery, int pageIndex, int maxValue, Long id, Long areaId, String username, List<Integer> fileTypes, String startTime, String endTime, HttpServletRequest request, HttpServletResponse response) throws IOException, TemplateException {

        EsSearchResult searchResult = querySearchResult(datasourceType, intelligenceBusinessTypeIds, keyword, preciseQuery, pageIndex, maxValue, id, areaId, username, fileTypes, startTime, endTime, request);

        if (searchResult == null || searchResult.getHitDatas() == null) {
            throw new BussinessException("搜索引擎错误");
        }

        //遍历结果
        List<Track> tracks = new ArrayList<Track>();
        boolean haveAdd = false;
        Track currentTrack = new Track();
        for (CommonIndex commonIndex : searchResult.getHitDatas()) {
            //先判断是否包含该类
            haveAdd = false;
            for (Track track : tracks) {
                if (commonIndex.getBusinessTypeName().equals(track.getName())) {
                    haveAdd = true;
                    currentTrack = track;
                }
            }
            if (!haveAdd) {
                currentTrack = new Track();
                currentTrack.setName(commonIndex.getBusinessTypeName());
                tracks.add(currentTrack);
            }
            TrackDetail trackDetail = new TrackDetail();
            trackDetail.setDate(DateTimeUtil.formatDateTime(commonIndex.getCreatedTime()));
            trackDetail.setAddress(commonIndex.getProviderAddress());
            trackDetail.setContent(commonIndex.getContent().replace("<span class=\"text-red\">", "").replace("</span>", ""));
            if (currentTrack.getDetails() == null) {
                List<TrackDetail> details = new ArrayList<>();
                currentTrack.setDetails(details);
            }
            currentTrack.getDetails().add(trackDetail);
        }

        // 设定文件保存的目录
        String filePath = request.getSession().getServletContext().getRealPath("/") + UPLOAD_DIR + File.separator;
        judeDirExists(new File(filePath));
        String fileName = filePath + getUUID() + ".doc";

        //生成文档
        DocUtil docUtil = new DocUtil();
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("tracks", tracks);
        //dataMap.put("secondPic1", docUtil.getImageStr("D:\\Img\\secondPic1.png"));
        docUtil.createDoc(dataMap, "baseDoc5", fileName);

        return fileName;
    }

    @Override
    public void exportQuerySearchResult(String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //下载文档
        File file = null;
        InputStream fin = null;
        ServletOutputStream out = null;
        try {
            file = new File(fileName);
            fin = new FileInputStream(file);

            response.setCharacterEncoding("utf-8");
            response.setContentType("application/msword");
            // 设置浏览器以下载的方式处理该文件默认名
            String filename = "报告.doc";
            filename = processFileName(request, filename);
            response.addHeader("Content-Disposition", "attachment;filename=" + filename);

            out = response.getOutputStream();
            byte[] buffer = new byte[1024];  // 缓冲区
            int bytesToRead = -1;
            // 通过循环将读入的Word文件的内容输出到浏览器中
            while ((bytesToRead = fin.read(buffer)) != -1) {
                out.write(buffer, 0, bytesToRead);
            }
        } finally {
            if (fin != null) fin.close();
            if (out != null) out.close();
            if (file != null) file.delete(); // 删除临时文件
        }
    }

    // 判断文件夹是否存在
    public void judeDirExists(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                //System.out.println("dir exists");
            } else {
                //System.out.println("the same name file exists, can not create dir");
            }
        } else {
            //System.out.println("dir not exists, create it ...");
            file.mkdirs();
        }
    }

    public static String getUUID() {
        String s = UUID.randomUUID().toString();
        //去掉“-”符号
        return s.replace("-", "");
    }

    /**
     * 处理导出生成的Excel文件名在火狐或ie下出现乱码的问题
     *
     * @Title: processFileName
     * @Description: ie, chrom, firfox下处理文件名显示乱码
     */
    public static String processFileName(HttpServletRequest request, String fileNames) {
        String codedfilename = null;
        try {
            String agent = request.getHeader("User-Agent").toUpperCase();
            if ((null != agent && -1 != agent.indexOf("MSIE")) || (null != agent && -1 != agent.indexOf("TRIDENT"))) {// ie

                String name = URLEncoder.encode(fileNames, "UTF8");

                codedfilename = name;
            } else if (null != agent && -1 != agent.indexOf("MOZILLA")) {// 火狐,chrome等

                codedfilename = new String(fileNames.getBytes("UTF-8"), "iso-8859-1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return codedfilename;
    }

    @Override
    public EsSearchResult queryRecommendSearchResult(Long userId, Long areaId, String username, HttpServletRequest request) {
        List<SearchLog> searchLogs = searchLogService.querySearchHistory(userId);
        List<String> keywords = new ArrayList<>();
        for (SearchLog searchLog : searchLogs) {
            keywords.add(searchLog.getKeyword());
        }

        List<IntelligenceSharePermission> intelligenceSharePermissions = getIntelligenceSharePermissions(areaId);
        List<Long> areaIds = getRightAreaIds(areaId, intelligenceSharePermissions);
        List<Long> intelligenceBusinessTypeIds = getIntelligenceBusinessTypeIds(areaId, null, intelligenceSharePermissions);
        return searchFromEs("", areaIds, intelligenceBusinessTypeIds, null, keywords, false, true, null, null, 0, DEFAULT_PAGE_SIZE);
    }

    private List<IntelligenceSharePermission> getIntelligenceSharePermissions(Long areaId) {
        //获取其他区域权限
        DataTablesRequest dataTablesRequest = new DataTablesRequest();
        Map<String, String> extraSearch = new HashMap<>();
        extraSearch.put("shareToAreaId", areaId.toString());
        dataTablesRequest.setExtraSearch(extraSearch);
        dataTablesRequest.setLength(10000);
        return intelligenceSharePermissionService.queryList(dataTablesRequest);
    }

    private List<Long> getRightAreaIds(Long areaId, List<IntelligenceSharePermission> intelligenceSharePermissions) {
        List<Long> areaIds = new ArrayList<>();
        areaIds.add(areaId);
        //其他区域权限
        if (intelligenceSharePermissions != null && intelligenceSharePermissions.size() > 0) {
            for (IntelligenceSharePermission intelligenceSharePermission : intelligenceSharePermissions) {
                areaIds.add(intelligenceSharePermission.getAreaId());
            }
        }
        return areaIds;
    }

    private List<Long> getIntelligenceBusinessTypeIds(Long areaId, List<Long> intelligenceBusinessTypeIds, List<IntelligenceSharePermission> intelligenceSharePermissions) {

        if (intelligenceBusinessTypeIds == null || intelligenceBusinessTypeIds.size() == 0) {

            intelligenceBusinessTypeIds = new ArrayList<>();

            //得到自己区域的所有的业务类型
            DataTablesRequest dataTablesRequest = new DataTablesRequest();
            Map<String, String> extraSearch = new HashMap<>();
            extraSearch.put("areaId", areaId.toString());
            dataTablesRequest.setExtraSearch(extraSearch);
            dataTablesRequest.setLength(10000);
            List<IntelligenceBusinessType> intelligenceBusinessTypes = intelligenceBusinessTypeService.queryList(dataTablesRequest);
            for (IntelligenceBusinessType intelligenceBusinessType : intelligenceBusinessTypes) {
                intelligenceBusinessTypeIds.add(intelligenceBusinessType.getId());
            }

            //其他区域权限
            if (intelligenceSharePermissions != null && intelligenceSharePermissions.size() > 0) {

                //其他区域权限
                for (IntelligenceSharePermission intelligenceSharePermission : intelligenceSharePermissions) {
                    intelligenceBusinessTypeIds.add(intelligenceSharePermission.getIntelligenceBusinessTypeId());
                }
            }
        }
        return intelligenceBusinessTypeIds;
    }

    private void aysnSaveSearchLog(Integer datasourceType, List<Long> intelligenceBusinessTypeIds, String keyword, Long userId, Long areaId, String username, HttpServletRequest request) {
        List<SearchLog> searchLogs = new ArrayList<>();
        SearchLog searchLog;
        for (Long intelligenceBusinessTypeId : intelligenceBusinessTypeIds) {
            searchLog = new SearchLog();
            searchLog.setAreaId(areaId);
            searchLog.setCreatedBy(username);
            searchLog.setCreatedIp(request.getRemoteAddr());
            searchLog.setDatasourceType(datasourceType);
            searchLog.setIntelligenceBusinessTypeId(intelligenceBusinessTypeId);
            searchLog.setKeyword(keyword);
            searchLog.setUserId(userId);
            searchLogs.add(searchLog);
        }

        SaveSearchLogRunnable saveSearchLogRunnable = new SaveSearchLogRunnable(searchLogService, searchLogs);
        Thread thread1 = new Thread(saveSearchLogRunnable); // 将myRunnable作为Thread target创建新的线程
        thread1.start(); // 调用start()方法使得线程进入就绪状态
    }

    private EsSearchResult searchFromEs(String index, List<Long> areaIds, List<Long> intelligenceBusinessTypeIds, List<Integer> fileTypes, List<String> keywords, boolean keywordsAnd, boolean preciseQuery, Long startTime, Long endTime, int pageIndex, int pageSize) {

        BoolQueryBuilder boolQueryAll = QueryBuilders.boolQuery();

        BoolQueryBuilder boolQueryAreaIds = QueryBuilders.boolQuery();
        if (areaIds != null) {
            for (Long areaId : areaIds) {
                boolQueryAreaIds.should(QueryBuilders.termQuery("areaId", areaId));
            }
            boolQueryAll.must(boolQueryAreaIds);
        }


        BoolQueryBuilder boolQueryIntelligenceBusinessTypeIds = QueryBuilders.boolQuery();
        if (intelligenceBusinessTypeIds != null) {
            for (Long intelligenceBusinessTypeId : intelligenceBusinessTypeIds) {
                boolQueryIntelligenceBusinessTypeIds.should(QueryBuilders.termQuery("businessTypeId", intelligenceBusinessTypeId));
            }
            boolQueryAll.must(boolQueryIntelligenceBusinessTypeIds);
        }

        BoolQueryBuilder boolQueryFileTypes = QueryBuilders.boolQuery();
        if (fileTypes != null) {
            for (Integer fileType : fileTypes) {
                boolQueryFileTypes.should(QueryBuilders.termQuery("fileType", fileType));
            }
            boolQueryAll.must(boolQueryFileTypes);
        }

        //基本搜索
        //　　Google 查询简洁方便，仅需输入查询内容并敲一下回车键 (Enter)，或单击“Google 搜索”按钮即可得到相关资料。
        //　　搜索两个及两个以上关键字
        //　　Google 只会返回那些符合您的全部查询条件的网页。不需要在关键词之间加上“and”或“+”。如果您想缩小搜索范围，只需输入更多的关键词，只要在关键词中间留空格就行了。
        //　　搜索结果不包含某些特定信息
        //　　如果要避免搜索某个词语，可以在这个词前面加上一个减号（“-”， 英文字符）。但在减号之前必须留一空格。
        BoolQueryBuilder boolQueryKeywords = QueryBuilders.boolQuery();
        BoolQueryBuilder boolQueryKeyword;
        if (keywords != null) {
            for (String keyword : keywords) {
                boolQueryKeyword = QueryBuilders.boolQuery();
                if (keyword.startsWith("-")) {
                    keyword = keyword.replace("-", "");
                    if (preciseQuery) {
                        boolQueryKeyword.should(QueryBuilders.termQuery("name1", keyword));
                        boolQueryKeyword.should(QueryBuilders.termQuery("name2", keyword));
                        boolQueryKeyword.should(QueryBuilders.termQuery("idCardNum1", keyword));
                        boolQueryKeyword.should(QueryBuilders.termQuery("idCardNum2", keyword));
                        boolQueryKeyword.should(QueryBuilders.termQuery("content", keyword));
                    } else {
                        boolQueryKeyword.should(QueryBuilders.matchQuery("name1", keyword));
                        boolQueryKeyword.should(QueryBuilders.matchQuery("name2", keyword));
                        boolQueryKeyword.should(QueryBuilders.matchQuery("idCardNum1", keyword));
                        boolQueryKeyword.should(QueryBuilders.matchQuery("idCardNum2", keyword));
                        boolQueryKeyword.should(QueryBuilders.matchQuery("content", keyword));
                    }
                    boolQueryKeywords.mustNot(boolQueryKeyword);
                } else if (keyword.startsWith("|")) {
                    keyword = keyword.replace("|", "");
                    if (preciseQuery) {
                        boolQueryKeyword.should(QueryBuilders.termQuery("name1", keyword));
                        boolQueryKeyword.should(QueryBuilders.termQuery("name2", keyword));
                        boolQueryKeyword.should(QueryBuilders.termQuery("idCardNum1", keyword));
                        boolQueryKeyword.should(QueryBuilders.termQuery("idCardNum2", keyword));
                        boolQueryKeyword.should(QueryBuilders.termQuery("content", keyword));
                    } else {
                        boolQueryKeyword.should(QueryBuilders.matchQuery("name1", keyword));
                        boolQueryKeyword.should(QueryBuilders.matchQuery("name2", keyword));
                        boolQueryKeyword.should(QueryBuilders.matchQuery("idCardNum1", keyword));
                        boolQueryKeyword.should(QueryBuilders.matchQuery("idCardNum2", keyword));
                        boolQueryKeyword.should(QueryBuilders.matchQuery("content", keyword));
                    }
                    boolQueryKeywords.should(boolQueryKeyword);
                } else {
                    if (preciseQuery) {
                        //boolQueryKeyword.should(QueryBuilders.termQuery("title", keyword));
                        //boolQueryKeyword.should(QueryBuilders.termQuery("content", keyword));
                        boolQueryKeyword.should(QueryBuilders.prefixQuery("name1", keyword));
                        boolQueryKeyword.should(QueryBuilders.prefixQuery("name2", keyword));
                        boolQueryKeyword.should(QueryBuilders.prefixQuery("idCardNum1", keyword));
                        boolQueryKeyword.should(QueryBuilders.prefixQuery("idCardNum2", keyword));
                        boolQueryKeyword.should(QueryBuilders.prefixQuery("content", keyword));
                    } else {
                        boolQueryKeyword.should(QueryBuilders.matchQuery("name1", keyword));
                        boolQueryKeyword.should(QueryBuilders.matchQuery("name2", keyword));
                        boolQueryKeyword.should(QueryBuilders.matchQuery("idCardNum1", keyword));
                        boolQueryKeyword.should(QueryBuilders.matchQuery("idCardNum2", keyword));
                        boolQueryKeyword.should(QueryBuilders.matchQuery("content", keyword));
                    }
                    boolQueryKeywords.must(boolQueryKeyword);
                }
            }
            if (keywordsAnd) {
                boolQueryAll.must(boolQueryKeywords);
            } else {
                boolQueryAll.should(boolQueryKeywords);
            }
        }

        int pageFrom = (pageIndex - 1) * pageSize;
        if (pageFrom < 0) {
            pageFrom = 0;
        }

        if (StringUtils.isBlank(index)) {
            index = INDEX;
        }

        Map<String, Object> searchResult = esClient.getEsSearchResult(index, TYPE, startTime, endTime, pageFrom, pageSize, null, boolQueryAll);

        List<Map<String, Object>> dataList = (List<Map<String, Object>>) searchResult.get("dataList");
        List<CommonIndex> commonIndexes = new ArrayList<>();
        CommonIndex commonIndex;
        for (Map<String, Object> map : dataList) {
            commonIndex = new CommonIndex();
            commonIndex.setAreaId(Long.parseLong(map.get("areaId").toString()));
            commonIndex.setAreaName(map.get("areaName").toString());
            commonIndex.setBusinessTypeId(Long.parseLong(map.get("businessTypeId").toString()));
            commonIndex.setBusinessTypeName(map.get("businessTypeName").toString());
            commonIndex.setCollectTime(new Date(Long.parseLong(map.get("collectTime").toString())));

            commonIndex.setCreatedTime(new Date(Long.parseLong(map.get("createdTime").toString())));
            commonIndex.setFileType(Integer.parseInt(map.get("fileType").toString()));
            commonIndex.setId(map.get("id").toString());
            commonIndex.setSuggest(map.get("suggest").toString());
            //commonIndex.setTitle(map.get("title").toString());

            if (map.containsKey("name1")) {
                commonIndex.setName1(map.get("name1").toString());
            }else{
                commonIndex.setName1("");
            }
            if (map.containsKey("idCardNum1")) {
                commonIndex.setIdCardNum1(map.get("idCardNum1").toString());
            }else{
                commonIndex.setIdCardNum1("");
            }
            if (map.containsKey("location1")) {
                commonIndex.setLocation1(map.get("location1").toString());
            }else{
                commonIndex.setLocation1("");
            }
            if (map.containsKey("dtTime")) {
                commonIndex.setDtTime(new Date(Long.parseLong(map.get("dtTime").toString())));
            }else{
                commonIndex.setDtTime(null);
            }
            if (map.containsKey("name2")) {
                commonIndex.setName2(map.get("name2").toString());
            }else{
                commonIndex.setName2("");
            }
            if (map.containsKey("idCardNum2")) {
                commonIndex.setIdCardNum2(map.get("idCardNum2").toString());
            }else{
                commonIndex.setIdCardNum2("");
            }
            if (map.containsKey("location2")) {
                commonIndex.setLocation2(map.get("location2").toString());
            }else{
                commonIndex.setLocation2("");
            }

            if (map.containsKey("content")) {
                commonIndex.setContent(map.get("content").toString());
            }else{
                commonIndex.setContent("");
            }

            if (map.containsKey("url")) {
                commonIndex.setUrl(map.get("url").toString());
            }else{
                commonIndex.setUrl("");
            }

            if (map.containsKey("informationProvider")) {
                commonIndex.setInformationProvider(map.get("informationProvider").toString());
            }else{
                commonIndex.setInformationProvider("");
            }
            if (map.containsKey("providerAddress")) {
                commonIndex.setProviderAddress(map.get("providerAddress").toString());
            }else{
                commonIndex.setProviderAddress("");
            }
            if (map.containsKey("policeOffice")) {
                commonIndex.setPoliceOffice(map.get("policeOffice").toString());
            }else{
                commonIndex.setPoliceOffice("");
            }
            if (map.containsKey("contactPerson")) {
                commonIndex.setContactPerson(map.get("contactPerson").toString());
            }else{
                commonIndex.setContactPerson("");
            }
            if (map.containsKey("contactPhone")) {
                commonIndex.setContactPhone(map.get("contactPhone").toString());
            }else{
                commonIndex.setContactPhone("");
            }
            if (map.containsKey("emergencyContactPerson")) {
                commonIndex.setEmergencyContactPerson(map.get("emergencyContactPerson").toString());
            }else{
                commonIndex.setEmergencyContactPerson("");
            }
            if (map.containsKey("emergencyContactPhone")) {
                commonIndex.setEmergencyContactPhone(map.get("emergencyContactPhone").toString());
            }else{
                commonIndex.setEmergencyContactPhone("");
            }
            commonIndexes.add(commonIndex);
        }

        //if(!preciseQuery){
        //    //按业务类型排序
        //    Collections.sort(commonIndexes);
        //}

        EsSearchResult esSearchResult = new EsSearchResult(pageIndex, Long.parseLong(searchResult.get("total").toString()), commonIndexes);
        return esSearchResult;
    }

    @Override
    public List<String> querySearchSuggestion(String keyword) {
        List<String> distinct = new ArrayList<>();
        List<String> suggestions = esClient.searchSuggestion(INDEX, TYPE, "suggest", keyword, 20);
        for (String suggestion : suggestions) {
            if (!distinct.contains(suggestion)) {
                distinct.add(suggestion);
            }
        }
        return distinct;
    }


}