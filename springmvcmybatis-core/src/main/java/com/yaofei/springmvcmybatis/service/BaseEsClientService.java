package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.dto.es.index.BaseIndex;

import java.io.IOException;
import java.util.List;

/**
 * Created by f_yao on 2017/2/22.
 */
public interface BaseEsClientService<T extends BaseIndex> {
    String createIndex(List<T> entitys) throws IOException;
    String updateIndex(String esIndexName, List<T> entitys) throws IOException;
    void deleteIndex(String indexName, String id) throws IOException;
}