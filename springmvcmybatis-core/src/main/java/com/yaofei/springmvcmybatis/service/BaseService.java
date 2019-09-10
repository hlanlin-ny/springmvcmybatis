package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.BaseEntity;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;

import java.io.IOException;
import java.util.List;

/**
 * Created by f_yao on 2017/2/22.
 */
public interface BaseService<T extends BaseEntity> {
    void save(T t);

    int update(T t);

    int delete(Object id) throws IOException;

    int deleteBatch(Object[] ids) throws IOException;

    T queryObject(Object id);

    <T> List<T> queryList(DataTablesRequest dataTablesRequest);

    <T> List<T> queryAll();

    long queryTotal();

    long queryTotal(DataTablesRequest dataTablesRequest);
}
