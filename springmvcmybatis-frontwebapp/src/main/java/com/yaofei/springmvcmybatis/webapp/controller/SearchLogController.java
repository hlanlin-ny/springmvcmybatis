package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.SearchLog;
import com.yaofei.springmvcmybatis.service.SearchLogService;
import com.yaofei.springmvcmybatis.webapp.dto.common.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 搜索日志表
 *
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-03 17:46:20
 */
@Controller
@RequestMapping("/admin/searchlog")
public class SearchLogController extends BaseCRUDController<SearchLog> {
    @Autowired
    private SearchLogService searchLogService;

    @ResponseBody
    @RequestMapping(value = "/querySearchHistory", method = RequestMethod.GET)
    public JsonResult querySearchHistory() {
        List<SearchLog> searchLogs = searchLogService.querySearchHistory(super.getUserId());
        return JsonResult.ok().addResult(searchLogs);
    }

    @ResponseBody
    @RequestMapping(value = "/queryRelatedSearchHistory", method = RequestMethod.GET)
    public JsonResult queryRelatedSearchHistory(@RequestParam("k") String keyword) {
        List<SearchLog> searchLogs = searchLogService.queryRelatedSearchHistory(keyword);
        return JsonResult.ok().addResult(searchLogs);
    }

    @ResponseBody
    @RequestMapping(value = "/queryHotSearchList", method = RequestMethod.GET)
    public JsonResult queryHotSearchList() {
        List<SearchLog> searchLogs = searchLogService.queryHotSearchList();
        return JsonResult.ok().addResult(searchLogs);
    }
}