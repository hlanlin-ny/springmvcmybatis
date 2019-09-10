package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.IntelligenceOfficer;
import com.yaofei.springmvcmybatis.entity.FileStaticClass;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;

import java.util.List;

/**
 * 情报员信息表
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-12 11:31:29
 */
public interface FileStaticCountService extends BaseService<FileStaticClass> {

    List<FileStaticClass> queryCount(DataTablesRequest dataTablesRequest);
    List<FileStaticClass> querySum(DataTablesRequest dataTablesRequest);
}
