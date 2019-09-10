package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.IntelligenceStatistics;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 物流公司信息表
 *
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-21 10:00:19
 */
@Controller
@RequestMapping("/admin/intelligenceStatistics")
public class IntelligenceStatisticsController  extends BaseCRUDController<IntelligenceStatistics> {

    @Override
    protected void queryListBefore(HttpServletRequest request, HttpServletResponse response, DataTablesRequest dataTablesRequest) {
        super.queryListBefore(request, response, dataTablesRequest);
        dataTablesRequest.getExtraSearch().put("areaId", String.valueOf(this.getAreaId()));
    }

}
