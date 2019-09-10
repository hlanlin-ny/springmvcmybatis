package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.SysCodeGenerator;
import com.yaofei.springmvcmybatis.plugins.datatables.DataTablesUtils;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesResponse;
import com.yaofei.springmvcmybatis.service.SysCodeGeneratorService;
import com.yaofei.springmvcmybatis.webapp.dto.common.JsonResult;
import org.apache.commons.io.IOUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 代码生成
 */
@Controller
@RequestMapping("admin/syscodegenerator")
public class SysCodeGeneratorController extends BaseCRUDController<SysCodeGenerator> {
    @Autowired
    private SysCodeGeneratorService sysCodeGeneratorService;

    /**
     * 列表
     */
    @ResponseBody
    @RequestMapping(value = "/queryListTables", method = RequestMethod.POST)
    @RequiresPermissions("codegenerator:list")
    public JsonResult queryListTables(HttpServletRequest request, HttpServletResponse response) {
        //对请求参数解析，生成 排序条件、列搜索对象、全局搜索对象
        DataTablesRequest dataTablesRequest = DataTablesUtils.getDataTableRequest(request);
        //查询列表数据
        List<SysCodeGenerator> currentPageData = sysCodeGeneratorService.queryListTables(dataTablesRequest);
        long recordsTotal = sysCodeGeneratorService.queryTotalTables(dataTablesRequest);

        //dataTable 相应参数
        DataTablesResponse<SysCodeGenerator> dataTablesResponse = new DataTablesResponse<>(dataTablesRequest.getDraw(), recordsTotal, currentPageData);
        return JsonResult.ok().addResult(dataTablesResponse);
    }

    /**
     * 生成代码
     */
    @RequiresPermissions("syscodegenerator:generatorCode")
    @RequestMapping(value = "/generatorCode", method = RequestMethod.GET)
    public void generatorCode(@RequestParam("tables") String tables, HttpServletResponse response) throws IOException {
        String[] tableNames =  tables.split(",");

        byte[] data = sysCodeGeneratorService.generatorCode(tableNames);

        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"generatorCode.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");

        IOUtils.write(data, response.getOutputStream());
    }
}
