package com.yaofei.springmvcmybatis.service.impl;

import com.yaofei.springmvcmybatis.entity.SysCodeGenerator;
import com.yaofei.springmvcmybatis.plugins.codegenerator.GenUtils;
import com.yaofei.springmvcmybatis.repository.SysCodeGeneratorRepository;
import com.yaofei.springmvcmybatis.service.SysCodeGeneratorService;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

/**
 * Created by f_yao on 2017/2/24.
 */
@Service("SysCodeGeneratorService")
public class SysCodeGeneratorServiceImpl extends AbstractBaseService<SysCodeGenerator> implements SysCodeGeneratorService {

    @Autowired
    private SysCodeGeneratorRepository sysCodeGeneratorRepository;

    @Override
    public List<SysCodeGenerator> queryListTables(DataTablesRequest dataTablesRequest) {
        return sysCodeGeneratorRepository.queryListTables(dataTablesRequest);
    }

    @Override
    public long queryTotalTables(DataTablesRequest dataTablesRequest) {
        return sysCodeGeneratorRepository.queryTotalTables(dataTablesRequest);
    }

    @Override
    public byte[] generatorCode(String[] tableNames) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);

        for(String tableName : tableNames){
            //查询表信息
            Map<String, String> table = queryTable(tableName);
            //查询列信息
            List<Map<String, String>> columns = queryColumns(tableName);
            //生成代码
            GenUtils.generatorCode(table, columns, zip);
        }
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }

    private Map<String, String> queryTable(String tableName) {
        return sysCodeGeneratorRepository.queryTable(tableName);
    }

    private List<Map<String, String>> queryColumns(String tableName) {
        return sysCodeGeneratorRepository.queryColumns(tableName);
    }
}
