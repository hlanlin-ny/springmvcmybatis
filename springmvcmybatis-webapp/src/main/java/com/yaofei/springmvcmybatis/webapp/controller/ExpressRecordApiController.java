package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.ExpressRecord;
import com.yaofei.springmvcmybatis.entity.ExpressUser;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesResponse;
import com.yaofei.springmvcmybatis.service.ExpressRecordApiService;
import com.yaofei.springmvcmybatis.webapp.dto.common.JsonResult;
import com.yaofei.springmvcmybatis.webapp.utils.BindingResultChecker;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * 快递记录接口
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-09 14:32:19
 */
@Controller
@RequestMapping("/admin/expressrecordapi")
public class ExpressRecordApiController {

    @Autowired
    private ExpressRecordApiService expressRecordApiService;

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
        return "admin/expressrecord/details";
    }

    /**
     * 列表
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JsonResult login(@RequestHeader("u") String username, @RequestHeader("p") String password) {
        ExpressUser expressUser = expressRecordApiService.checkExpressUerRight(username, password);
        return JsonResult.ok().addResult(expressUser.getSeckey());
    }

    /**
     * 列表
     */
    @ResponseBody
    @RequestMapping(value = "/queryList", method = RequestMethod.POST)
    public JsonResult queryListExpressRecord(@RequestHeader("u") String username, @RequestHeader("s") String sign, @RequestHeader("n") Integer nonce, @RequestHeader("t") String timestamp, @RequestHeader("e") String extension, HttpServletRequest request, HttpServletResponse response) throws Exception {
        DataTablesResponse<T> dataTablesResponse = expressRecordApiService.queryList(username, sign, nonce, request);
        return JsonResult.ok().addResult(dataTablesResponse);
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public JsonResult addExpressRecord(@RequestHeader("u") String username, @RequestHeader("s") String sign, @RequestHeader("n") Integer nonce, @RequestHeader("t") String timestamp, @RequestHeader("e") String extension, @Valid @RequestBody ExpressRecord expressRecord, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws Exception {
        BindingResultChecker.check(result);
        expressRecordApiService.add(username, sign, nonce, expressRecord, request);
        return JsonResult.ok();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public JsonResult updateExpressRecord(@RequestHeader("u") String username, @RequestHeader("s") String sign, @RequestHeader("n") Integer nonce, @RequestHeader("t") String timestamp, @RequestHeader("e") String extension, @Valid @RequestBody ExpressRecord expressRecord, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws Exception {
        BindingResultChecker.check(result);
        expressRecordApiService.update(username, sign, nonce, expressRecord, request);
        return JsonResult.ok();
    }

    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public JsonResult deleteExpressRecord(@RequestHeader("u") String username, @RequestHeader("s") String sign, @RequestHeader("n") Integer nonce, @RequestHeader("t") String timestamp, @RequestHeader("e") String extension, @PathVariable("id") Object id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        expressRecordApiService.delete(username, sign, nonce, id);
        return JsonResult.ok();
    }


    @ResponseBody
    @RequestMapping(value = "/changepassword", method = RequestMethod.POST)
    public JsonResult changePassword(@RequestHeader("u") String username, @RequestHeader("p") String password, String newPassword, String confirmPassword) {
        if (StringUtils.isBlank(password)) {
            return JsonResult.error("原密码不为能空");
        }
        if (StringUtils.isBlank(newPassword) || StringUtils.isBlank(confirmPassword)) {
            return JsonResult.error("新密码不为能空");
        }
        if (!newPassword.equals(confirmPassword)) {
            return JsonResult.error("新密码和确认密码不一致");
        }

        //更新密码
        expressRecordApiService.changePassword(username, password, newPassword);
        return JsonResult.ok();
    }
}