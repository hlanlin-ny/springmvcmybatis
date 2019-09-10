package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.MedicalExaminationRecord;
import com.yaofei.springmvcmybatis.service.MedicalExaminationRecordApiService;
import com.yaofei.springmvcmybatis.webapp.dto.common.JsonResult;
import com.yaofei.springmvcmybatis.webapp.utils.BindingResultChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * 物流记录接口
 *
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-09 14:32:19
 */
@Controller
@RequestMapping("/admin/api/medicalExaminationApi")
public class MedicalExaminationApiController {

    @Autowired
    private MedicalExaminationRecordApiService medicalExaminationRecordApiService;

    /**
     * 列表
     */
    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public JsonResult test() {
        return JsonResult.ok();
    }

    @RequestMapping(value = "/details.html", method = RequestMethod.GET)
    public String details() {
        return "admin/medicalExaminationRecord/details";
    }

//    /**
//     * 列表
//     */
//    @ResponseBody
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public JsonResult login(@RequestHeader("u") String username, @RequestHeader("p") String password) {
//        LogisticsUser logisticsUser = logisticsRecordApiService.checkLogisticsUerRight(username, password);
//        return JsonResult.ok().addResult(logisticsUser.getSeckey());
//    }

//    /**
//     * 列表
//     */
//    @ResponseBody
//    @RequestMapping(value = "/queryList", method = RequestMethod.POST)
//    public JsonResult queryList(@RequestHeader("u") String username, @RequestHeader("s") String sign, @RequestHeader("n") Integer nonce, @RequestHeader("t") String timestamp, @RequestHeader("e") String extension, HttpServletRequest request, HttpServletResponse response) throws Exception {
//        DataTablesResponse<T> dataTablesResponse = logisticsRecordApiService.queryList(username, sign, nonce, request);
//        return JsonResult.ok().addResult(dataTablesResponse);
//    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public JsonResult add(@RequestHeader("u") String username, @RequestHeader("s") String sign, @RequestHeader("n") Integer nonce, @RequestHeader("t") String timestamp, @RequestHeader("e") String extension, @Valid @RequestBody MedicalExaminationRecord medicalExaminationRecord, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws Exception {
        BindingResultChecker.check(result);
        medicalExaminationRecordApiService.add(username, sign, nonce, medicalExaminationRecord, request);
        return JsonResult.ok();
    }

//    /**
//     * 修改
//     */
//    @ResponseBody
//    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    public JsonResult update(@RequestHeader("u") String username, @RequestHeader("s") String sign, @RequestHeader("n") Integer nonce, @RequestHeader("t") String timestamp, @RequestHeader("e") String extension, @Valid @RequestBody LogisticsRecord logisticsRecord, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws Exception {
//        BindingResultChecker.check(result);
//        logisticsRecordApiService.update(username, sign, nonce, logisticsRecord, request);
//        return JsonResult.ok();
//    }
//
//    /**
//     * 删除
//     */
//    @ResponseBody
//    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
//    public JsonResult delete(@RequestHeader("u") String username, @RequestHeader("s") String sign, @RequestHeader("n") Integer nonce, @RequestHeader("t") String timestamp, @RequestHeader("e") String extension, @PathVariable("id") Object id, HttpServletRequest request, HttpServletResponse response) throws Exception {
//        logisticsRecordApiService.delete(username, sign, nonce, id);
//        return JsonResult.ok();
//    }

//
//    @ResponseBody
//    @RequestMapping(value = "/changepassword", method = RequestMethod.POST)
//    public JsonResult changePassword(@RequestHeader("u") String username, @RequestHeader("p") String password, String newPassword, String confirmPassword) {
//        if (StringUtils.isBlank(password)) {
//            return JsonResult.error("原密码不为能空");
//        }
//        if (StringUtils.isBlank(newPassword) || StringUtils.isBlank(confirmPassword)) {
//            return JsonResult.error("新密码不为能空");
//        }
//        if (!newPassword.equals(confirmPassword)) {
//            return JsonResult.error("新密码和确认密码不一致");
//        }
//
//        //更新密码
//        logisticsRecordApiService.changePassword(username, password, newPassword);
//        return JsonResult.ok();
//    }
}