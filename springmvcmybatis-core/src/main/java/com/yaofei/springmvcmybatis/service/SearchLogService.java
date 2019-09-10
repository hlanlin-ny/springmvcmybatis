package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.SearchLog;

import java.util.List;

/**
 * 搜索日志表
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-03 17:46:20
 */
public interface SearchLogService extends BaseService<SearchLog> {

    List<SearchLog> querySearchHistory(Long userId);

    List<SearchLog> queryRelatedSearchHistory(String keyword);

    List<SearchLog> queryHotSearchList();
}