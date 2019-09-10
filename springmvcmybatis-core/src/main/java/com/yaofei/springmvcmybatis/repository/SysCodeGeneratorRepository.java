package com.yaofei.springmvcmybatis.repository;

import com.yaofei.springmvcmybatis.entity.SysCodeGenerator;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;

import java.util.List;
import java.util.Map;

/**
 * 代码生成
 * Created by f_yao on 2017/2/24.
 */
public interface SysCodeGeneratorRepository extends BaseRepository<SysCodeGenerator> {
    List<SysCodeGenerator> queryListTables(DataTablesRequest dataTablesRequest);

    long queryTotalTables(DataTablesRequest dataTablesRequest);

    Map<String,String> queryTable(String tableName);

    List<Map<String,String>> queryColumns(String tableName);
}
