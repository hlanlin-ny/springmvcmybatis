package com.yaofei.springmvcmybatis.repository;

import com.yaofei.springmvcmybatis.entity.BaseEntity;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;

import java.util.List;

/**
 * 基础Dao(还需在XML文件里，有对应的SQL语句)
 *
 * @author f_yao
 * @email f_yao@ctrip.com
 * @date 2016年9月18日 上午9:31:36
 */
public interface BaseRepository<T extends BaseEntity> {

    long queryTotal();

    long queryListTotal(DataTablesRequest dataTablesRequest);

    <T> List<T> queryList(DataTablesRequest dataTablesRequest);

    T queryObject(Object id);

    int save(T t);

    int update(T t);

    int delete(Object id);

    int deleteBatch(Object[] ids);
}