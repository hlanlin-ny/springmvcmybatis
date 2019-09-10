package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.IntelligenceImport;
import com.yaofei.springmvcmybatis.service.IntelligenceImportService;
import com.yaofei.springmvcmybatis.webapp.dto.common.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 情报导入记录
 *
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-01 11:11:40
 */
@Controller
@RequestMapping("/admin/intelligenceimport")
public class IntelligenceImportController extends BaseCRUDController<IntelligenceImport> {

    @Value("${upload.temp.dir}")
    private String upload_dir = "upload_temp";

    @Autowired
    private IntelligenceImportService intelligenceImportService;

    @ResponseBody
    @RequestMapping(value = "/addAndUpload", method = RequestMethod.POST)
    public JsonResult addAndUpload(@RequestParam("files") CommonsMultipartFile[] files,Long areaId, Long businessTypeId, Integer fileType, String fileDesc, String collectTime, String remark, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (permissionService != null) {
            this.permissionService.assertHasAddPermission();
        }
        intelligenceImportService.addAndUpload(files,areaId, businessTypeId, fileType, fileDesc, collectTime, remark, super.getUsername(), request, response);
        return JsonResult.ok();
    }

    ///**
    // * 修改
    // */
    //@ResponseBody
    //@RequestMapping(value = "/updateAndUpload", method = RequestMethod.POST)
    //public JsonResult updateAndUpload(@RequestParam("files") CommonsMultipartFile[] files,Long areaId, Long businessTypeId, Integer fileType, String fileDesc, String collectTime, String remark,Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
    //
    //	if (permissionService != null) {
    //		this.permissionService.assertHasEditPermission();
    //	}
    //    intelligenceImportService.updateAndUpload(files,areaId, businessTypeId, fileType, fileDesc, collectTime, remark, id, super.getUsername(), request, response);
    //    return JsonResult.ok();
    //}
}