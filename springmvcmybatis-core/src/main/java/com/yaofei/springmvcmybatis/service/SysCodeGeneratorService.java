package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.SysCodeGenerator;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;

import java.util.List;

/**
 * Created by f_yao on 2017/2/24.
 */
public interface SysCodeGeneratorService extends BaseService<SysCodeGenerator> {
    List<SysCodeGenerator> queryListTables(DataTablesRequest dataTablesRequest);

    long queryTotalTables(DataTablesRequest dataTablesRequest);

    byte[] generatorCode(String[] tableNames);
}
