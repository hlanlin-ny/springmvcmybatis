package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.dto.es.EsSearchRequest;
import com.yaofei.springmvcmybatis.dto.es.EsSearchResult;
import com.yaofei.springmvcmybatis.entity.SysSearchwarningConfig;
import com.yaofei.springmvcmybatis.entity.SysSearchwarningLog;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesRequest;
import com.yaofei.springmvcmybatis.service.SearchService;
import com.yaofei.springmvcmybatis.service.SysSearchwarningConfigService;
import com.yaofei.springmvcmybatis.service.SysSearchwarningLogService;
import com.yaofei.springmvcmybatis.shiro.domain.ShiroUser;
import com.yaofei.springmvcmybatis.webapp.dto.common.JsonResult;
import com.yaofei.springmvcmybatis.webapp.utils.BindingResultChecker;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Map;

/**
 * 系统搜索预警通知日志表
 *
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-24 17:13:53
 */
@Controller
@RequestMapping("/admin/syssearchwarninglog")
public class SysSearchwarningLogController extends BaseCRUDController<SysSearchwarningLog> {
    @Autowired
    private SysSearchwarningLogService sysSearchwarningLogService;
    @Autowired
    private SysSearchwarningConfigService confService;
    @Autowired
    private SearchService searchService;

    @Override
    protected void queryListBefore(HttpServletRequest request, HttpServletResponse response, DataTablesRequest dataTablesRequest) {
        super.queryListBefore(request, response, dataTablesRequest);
        Map<String,String> search = dataTablesRequest.getExtraSearch();
        search.put("areaId",this.getAreaId().toString());
        dataTablesRequest.setExtraSearch(search);
    }

    @RequestMapping(value = "/advancedSearch.html", method = RequestMethod.GET)
    public String advancedSearch(HttpServletRequest request, HttpServletResponse response) {
        String confId = request.getParameter("id");
        request.setAttribute("confId", confId);
        return "admin/syssearchwarninglog/advancedsearch";
    }

    @RequestMapping(value = "/foundConfObj", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult foundConfObj(Long confId, HttpServletRequest request, HttpServletResponse response) {
//		String confId = request.getParameter("confId");
        SysSearchwarningConfig allData = confService.queryObject(confId);
        return JsonResult.ok().addResult(allData);
    }

    @ResponseBody
    @RequestMapping(value = "/querySearchResult", method = RequestMethod.POST)
    public JsonResult querySearchResult(@Valid @RequestBody EsSearchRequest searchRequest, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException {
        BindingResultChecker.check(result);
        ShiroUser shiroUser = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
        EsSearchResult searchResult = searchService.querySearchResult(searchRequest.getDatasourceType(), searchRequest.getIntelligenceBusinessTypeIds(), searchRequest.getKeyword(), searchRequest.isPreciseQuery(), searchRequest.getPageIndex(), 10000, shiroUser.getId(), shiroUser.getAreaId(), shiroUser.getUsername(), searchRequest.getFileTypes(), searchRequest.getStartTime(), searchRequest.getEndTime(), request);
         return JsonResult.ok().addResult(searchResult);
    }


}