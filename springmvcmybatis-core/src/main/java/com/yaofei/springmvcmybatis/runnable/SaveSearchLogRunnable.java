package com.yaofei.springmvcmybatis.runnable;

import com.yaofei.springmvcmybatis.entity.SearchLog;
import com.yaofei.springmvcmybatis.service.SearchLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by phoenix on 2017/7/20.
 */
public class SaveSearchLogRunnable implements Runnable {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private SearchLogService searchLogService;
    private List<SearchLog> searchLogs;

    //public SaveSearchLogRunnable() {
    //}

    public SaveSearchLogRunnable(SearchLogService _searchLogService, List<SearchLog> _searchLogs) {
        searchLogService = _searchLogService;
        searchLogs = _searchLogs;
    }

    @Override
    public void run() {
        try {
            for (SearchLog searchLog : searchLogs) {
                searchLogService.save(searchLog);
            }
        } catch (Exception e) {
            logger.error("SaveSearchLogRunnable.run() error", e);
        }
    }
}