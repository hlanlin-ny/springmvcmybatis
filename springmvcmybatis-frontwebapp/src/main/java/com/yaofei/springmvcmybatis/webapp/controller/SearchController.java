package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.dto.es.EsSearchRequest;
import com.yaofei.springmvcmybatis.dto.es.EsSearchResult;
import com.yaofei.springmvcmybatis.dto.es.EsSearchResultTimeline;
import com.yaofei.springmvcmybatis.service.SearchService;
import com.yaofei.springmvcmybatis.shiro.domain.ShiroUser;
import com.yaofei.springmvcmybatis.webapp.dto.common.JsonResult;
import com.yaofei.springmvcmybatis.webapp.utils.BindingResultChecker;
import freemarker.template.TemplateException;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
@RequestMapping("/admin/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @RequestMapping(value = "/searchKeyword", method = RequestMethod.POST)
    public String searchKeyword(Integer datasourceType, Long intelligenceBusinessTypeId, String keyword, Long pageIndex, Integer fileType, @RequestParam(required = false, defaultValue = "false") boolean preciseQuery, ModelMap model) throws UnsupportedEncodingException {
        model.addAttribute("d", datasourceType);
        model.addAttribute("i", intelligenceBusinessTypeId);
        model.addAttribute("k", URLEncoder.encode(keyword, "UTF-8"));
        model.addAttribute("p", pageIndex);
        model.addAttribute("t", fileType);
        model.addAttribute("pq", preciseQuery);
        //return "admin/index/searchResult";
        return "redirect:/admin/search/searchresult.html";
    }

    @RequestMapping(value = "/searchresult.html", method = RequestMethod.GET)
    public String searchResult() {
        return "admin/search/searchResult";
    }

    @ResponseBody
    @RequestMapping(value = "/querySearchResult", method = RequestMethod.POST)
    //@RequiresPermissions("manPhotoCompare:api")
    public JsonResult querySearchResult(@Valid @RequestBody EsSearchRequest searchRequest, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException {
        BindingResultChecker.check(result);
        ShiroUser shiroUser = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
        EsSearchResult searchResult = searchService.querySearchResult(searchRequest.getDatasourceType(), searchRequest.getIntelligenceBusinessTypeIds(), searchRequest.getKeyword(), searchRequest.isPreciseQuery(), searchRequest.getPageIndex(), 0, shiroUser.getId(), shiroUser.getAreaId(), shiroUser.getUsername(), searchRequest.getFileTypes(), searchRequest.getStartTime(), searchRequest.getEndTime(), request);
        return JsonResult.ok().addResult(searchResult);
    }

    @ResponseBody
    @RequestMapping(value = "/querySearchResultTimeline", method = RequestMethod.POST)
    //@RequiresPermissions("manPhotoCompare:api")
    public JsonResult querySearchResultTimeline (@Valid @RequestBody EsSearchRequest searchRequest, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException {
        BindingResultChecker.check(result);
        ShiroUser shiroUser = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
        EsSearchResultTimeline esSearchResultTimeline = searchService.querySearchResultTimeline(searchRequest.getDatasourceType(), searchRequest.getIntelligenceBusinessTypeIds(), searchRequest.getKeyword(), searchRequest.isPreciseQuery(), searchRequest.getPageIndex(), 0, shiroUser.getId(), shiroUser.getAreaId(), shiroUser.getUsername(), searchRequest.getFileTypes(), searchRequest.getStartTime(), searchRequest.getEndTime(), request);
        return JsonResult.ok().addResult(esSearchResultTimeline);
    }

    @ResponseBody
    @RequestMapping(value = "/genQuerySearchResult", method = RequestMethod.POST)
    //@RequiresPermissions("manPhotoCompare:api")
    public JsonResult genQuerySearchResult(@Valid @RequestBody EsSearchRequest searchRequest, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException, IOException, TemplateException {
        BindingResultChecker.check(result);
        ShiroUser shiroUser = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
        String fileName =  searchService.genQuerySearchResult(searchRequest.getDatasourceType(), searchRequest.getIntelligenceBusinessTypeIds(), searchRequest.getKeyword(), searchRequest.isPreciseQuery(), searchRequest.getPageIndex(), 10000, shiroUser.getId(), shiroUser.getAreaId(), shiroUser.getUsername(), searchRequest.getFileTypes(), searchRequest.getStartTime(), searchRequest.getEndTime(), request, response);
        return JsonResult.ok().addResult(fileName);
    }

    @RequestMapping(value = "/exprotQuerySearchResult", method = RequestMethod.POST)
    //@RequiresPermissions("manPhotoCompare:api")
    public void exprotQuerySearchResult(String fileName, HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException, IOException, TemplateException {
        if (StringUtils.isNotBlank(fileName)) {
            searchService.exportQuerySearchResult(fileName, request, response);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/queryRecommendSearchResult", method = RequestMethod.GET)
    //@RequiresPermissions("manPhotoCompare:api")
    public JsonResult queryRecommendSearchResult(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException {
        ShiroUser shiroUser = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
        EsSearchResult searchResult = searchService.queryRecommendSearchResult(shiroUser.getId(), shiroUser.getAreaId(), shiroUser.getUsername(), request);
        return JsonResult.ok().addResult(searchResult);
    }

    @ResponseBody
    @RequestMapping(value = "/querySearchSuggestion", method = RequestMethod.GET)
    public JsonResult querySearchSuggestion(@RequestParam("k") String keyword) {
        return JsonResult.ok().addResult(searchService.querySearchSuggestion(keyword));
    }


    @RequestMapping(value = "/advancedSearch.html", method = RequestMethod.GET)
    public String advancedSearch() {
        return "admin/search/advancedsearch";
    }
}