package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.SearchLog;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;
import com.yaofei.springmvcmybatis.repository.SearchLogRepository;
import com.yaofei.springmvcmybatis.service.SearchLogService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("searchLogService")
public class SearchLogServiceImpl extends AbstractBaseService<SearchLog> implements SearchLogService {
    @Autowired
    private SearchLogRepository searchLogRepository;

    @Override
    public List<SearchLog> querySearchHistory(Long userId) {
        DataTablesRequest dataTablesRequest = new DataTablesRequest();
        Map<String, String> extraSearch = new HashMap<>();
        extraSearch.put("userId", userId.toString());
        dataTablesRequest.setExtraSearch(extraSearch);
        dataTablesRequest.setOrderString("id desc");
        dataTablesRequest.setStart(0);
        dataTablesRequest.setLength(1000);
        List<SearchLog> searchLogs = searchLogRepository.queryList(dataTablesRequest);
        List<SearchLog> returnSearchLogs = new ArrayList<>();
        List<String> distinct = new ArrayList<>();
        for (SearchLog searchLog : searchLogs) {
            if (StringUtils.isNotBlank(searchLog.getKeyword()) && !distinct.contains(searchLog.getKeyword()) && returnSearchLogs.size() < 10) {
                returnSearchLogs.add(searchLog);
                distinct.add(searchLog.getKeyword());
            }
        }
        return returnSearchLogs;
    }

    @Override
    public List<SearchLog> queryRelatedSearchHistory(String keyword) {
        DataTablesRequest dataTablesRequest = new DataTablesRequest();
        Map<String, String> extraSearch = new HashMap<>();
        extraSearch.put("keyword", keyword);
        dataTablesRequest.setExtraSearch(extraSearch);
        dataTablesRequest.setOrderString("id desc");
        dataTablesRequest.setStart(0);
        dataTablesRequest.setLength(1000);
        List<SearchLog> searchLogs = searchLogRepository.queryList(dataTablesRequest);
        List<SearchLog> returnSearchLogs = new ArrayList<>();
        List<String> distinct = new ArrayList<>();
        for (SearchLog searchLog : searchLogs) {
            if (StringUtils.isNotBlank(searchLog.getKeyword()) && !keyword.equals(searchLog.getKeyword()) && !distinct.contains(searchLog.getKeyword()) && returnSearchLogs.size() < 10) {
                returnSearchLogs.add(searchLog);
                distinct.add(searchLog.getKeyword());
            }
        }
        return returnSearchLogs;
    }


    @Override
    public List<SearchLog> queryHotSearchList() {
        List<SearchLog> searchLogs = searchLogRepository.queryHotSearchList();
        List<SearchLog> returnSearchLogs = new ArrayList<>();
        List<String> distinct = new ArrayList<>();
        for (SearchLog searchLog : searchLogs) {
            if (StringUtils.isNotBlank(searchLog.getKeyword()) && !distinct.contains(searchLog.getKeyword()) && returnSearchLogs.size() < 10) {
                returnSearchLogs.add(searchLog);
                distinct.add(searchLog.getKeyword());
            }
        }
        return returnSearchLogs;
    }
}
