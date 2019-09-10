package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.dto.es.EsSearchResult;
import com.yaofei.springmvcmybatis.dto.es.EsSearchResultTimeline;
import com.yaofei.springmvcmybatis.entity.MedicalCheckinCheckoutRecordTransfer;
import com.yaofei.springmvcmybatis.entity.MedicalOutpatientRecordTransfer;
import com.yaofei.springmvcmybatis.entity.MedicalPatientRecordTransfer;
import freemarker.template.TemplateException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * 搜索日志表
 *
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-03 17:46:20
 */
public interface SearchService {
    EsSearchResult queryRecommendSearchResult(Long userId, Long areaId, String username, HttpServletRequest request);

    List<String> querySearchSuggestion(String keyword);

    EsSearchResult querySearchResult(Integer datasourceType, List<Long> intelligenceBusinessTypeIds, String keyword, boolean preciseQuery, int pageIndex, int pageSize, Long userId, Long areaId, String username, List<Integer> fileTypes, String startTime, String endTime, HttpServletRequest request);

    EsSearchResult querySearchResultNow(Integer datasourceType, List<Long> intelligenceBusinessTypeIds, String keyword, boolean preciseQuery, int pageIndex, int pageSize, Long userId, Long areaId, String username, List<Integer> fileTypes, String startTime, String endTime);

    EsSearchResultTimeline querySearchResultTimeline(Integer datasourceType, List<Long> intelligenceBusinessTypeIds, String keyword, boolean preciseQuery, int pageIndex, int pageSize, Long userId, Long areaId, String username, List<Integer> fileTypes, String startTime, String endTime, HttpServletRequest request);

    EsSearchResult querySearchResult(List<Long> intelligenceBusinessTypeIds, String keyword, boolean preciseQuery, Long userId, Long areaId, String username, List<Integer> fileTypes, Date startTime);

    String genQuerySearchResult(Integer datasourceType, List<Long> intelligenceBusinessTypeIds, String keyword, boolean preciseQuery, int pageIndex, int maxValue, Long id, Long areaId, String username, List<Integer> fileTypes, String startTime, String endTime, HttpServletRequest request, HttpServletResponse response) throws IOException, TemplateException;

    void exportQuerySearchResult(String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException;

    List<MedicalCheckinCheckoutRecordTransfer> selectMarder(String idCard, String name);

    List<MedicalOutpatientRecordTransfer> selectPatient(String idCard, String name);
}
