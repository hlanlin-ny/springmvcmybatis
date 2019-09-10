package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.*;
import com.yaofei.springmvcmybatis.plugins.datatables.domain.DataTablesResponse;
import com.yaofei.springmvcmybatis.service.*;
import com.yaofei.springmvcmybatis.webapp.dto.common.JsonResult;
import com.yaofei.springmvcmybatis.webapp.utils.BindingResultChecker;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

/**
 * 快递记录接口
 *
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-09 14:32:19
 */
@Controller
@RequestMapping("/admin/api")
public class ApiController {

    @ResponseBody
    @RequestMapping(value = "/logisticsRecord/test", method = RequestMethod.GET)
    public JsonResult test() {
        return JsonResult.ok();
    }


    // =================================================================================================================


    @Autowired
    private LogisticsRecordApiService logisticsRecordApiService;

    @ResponseBody
    @RequestMapping(value = "/logisticsRecord/login", method = RequestMethod.POST)
    public JsonResult loginLogisticsRecord(@RequestHeader("u") String username, @RequestHeader("p") String password) {
        LogisticsUser logisticsUser = logisticsRecordApiService.checkLogisticsUerRight(username, password);
        return JsonResult.ok().addResult(logisticsUser.getSeckey());
    }

    /**
     * 列表
     */
    @ResponseBody
    @RequestMapping(value = "/logisticsRecord/queryList", method = RequestMethod.POST)
    public JsonResult queryListLogisticsRecord(@RequestHeader("u") String username, @RequestHeader("s") String sign, @RequestHeader("n") Integer nonce, @RequestHeader("t") String timestamp, @RequestHeader("e") String extension, HttpServletRequest request, HttpServletResponse response) throws Exception {
        DataTablesResponse<T> dataTablesResponse = logisticsRecordApiService.queryList(username, sign, nonce, request);
        return JsonResult.ok().addResult(dataTablesResponse);
    }

    @ResponseBody
    @RequestMapping(value = "/logisticsRecord/add", method = RequestMethod.POST)
    public JsonResult addLogisticsRecord(@RequestHeader("u") String username, @RequestHeader("s") String sign, @RequestHeader("n") Integer nonce, @RequestHeader("t") String timestamp, @RequestHeader("e") String extension, @Valid @RequestBody LogisticsRecord logisticsRecord, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws Exception {
        BindingResultChecker.check(result);
        logisticsRecordApiService.add(username, sign, nonce, logisticsRecord, request);
        return JsonResult.ok();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping(value = "/logisticsRecord/update", method = RequestMethod.POST)
    public JsonResult updateLogisticsRecord(@RequestHeader("u") String username, @RequestHeader("s") String sign, @RequestHeader("n") Integer nonce, @RequestHeader("t") String timestamp, @RequestHeader("e") String extension, @Valid @RequestBody LogisticsRecord logisticsRecord, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws Exception {
        BindingResultChecker.check(result);
        logisticsRecordApiService.update(username, sign, nonce, logisticsRecord, request);
        return JsonResult.ok();
    }

    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping(value = "/logisticsRecord/{id}/delete", method = RequestMethod.POST)
    public JsonResult deleteLogisticsRecord(@RequestHeader("u") String username, @RequestHeader("s") String sign, @RequestHeader("n") Integer nonce, @RequestHeader("t") String timestamp, @RequestHeader("e") String extension, @PathVariable("id") Object id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logisticsRecordApiService.delete(username, sign, nonce, id);
        return JsonResult.ok();
    }


    @ResponseBody
    @RequestMapping(value = "/logisticsRecord/changepassword", method = RequestMethod.POST)
    public JsonResult changePasswordLogisticsRecord(@RequestHeader("u") String username, @RequestHeader("p") String password, String newPassword, String confirmPassword) {
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
        logisticsRecordApiService.changePassword(username, password, newPassword);
        return JsonResult.ok();
    }


    @RequestMapping(value = "/logisticsRecord/details.html", method = RequestMethod.GET)
    public String detailsLogisticsRecord() {
        return "admin/logisticsrecord/details";
    }

    @ResponseBody
    @RequestMapping(value = "/logisticsRecord/{id}/detail", method = RequestMethod.GET)
    public JsonResult queryLogisticsRecord(@PathVariable("id") Object id, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletRequestBindingException {
        if (id == null) {
            throw new ServletRequestBindingException("校验请求失败");
        }
        LogisticsRecord logisticsRecord = logisticsRecordApiService.queryLogisticsRecord(id);
        return JsonResult.ok().addResult(logisticsRecord);
    }

    // ==================================================================================================================


    @Autowired
    private ExpressRecordApiService expressRecordApiService;


    @ResponseBody
    @RequestMapping(value = "/expressrecord/login", method = RequestMethod.POST)
    public JsonResult loginExpressRecord(@RequestHeader("u") String username, @RequestHeader("p") String password) {
        ExpressUser expressUser = expressRecordApiService.checkExpressUerRight(username, password);
        return JsonResult.ok().addResult(expressUser.getSeckey());
    }

    /**
     * 列表
     */
    @ResponseBody
    @RequestMapping(value = "/expressrecord/queryList", method = RequestMethod.POST)
    public JsonResult queryListExpressRecord(@RequestHeader("u") String username, @RequestHeader("s") String sign, @RequestHeader("n") Integer nonce, @RequestHeader("t") String timestamp, @RequestHeader("e") String extension, HttpServletRequest request, HttpServletResponse response) throws Exception {
        DataTablesResponse<T> dataTablesResponse = expressRecordApiService.queryList(username, sign, nonce, request);
        return JsonResult.ok().addResult(dataTablesResponse);
    }

    @ResponseBody
    @RequestMapping(value = "/expressrecord/add", method = RequestMethod.POST)
    public JsonResult addExpressRecord(@RequestHeader("u") String username, @RequestHeader("s") String sign, @RequestHeader("n") Integer nonce, @RequestHeader("t") String timestamp, @RequestHeader("e") String extension, @Valid @RequestBody ExpressRecord expressRecord, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws Exception {
        BindingResultChecker.check(result);
        expressRecordApiService.add(username, sign, nonce, expressRecord, request);
        return JsonResult.ok();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping(value = "/expressrecord/update", method = RequestMethod.POST)
    public JsonResult updateExpressRecord(@RequestHeader("u") String username, @RequestHeader("s") String sign, @RequestHeader("n") Integer nonce, @RequestHeader("t") String timestamp, @RequestHeader("e") String extension, @Valid @RequestBody ExpressRecord expressRecord, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws Exception {
        BindingResultChecker.check(result);
        expressRecordApiService.update(username, sign, nonce, expressRecord, request);
        return JsonResult.ok();
    }

    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping(value = "/expressrecord/{id}/delete", method = RequestMethod.POST)
    public JsonResult deleteExpressRecord(@RequestHeader("u") String username, @RequestHeader("s") String sign, @RequestHeader("n") Integer nonce, @RequestHeader("t") String timestamp, @RequestHeader("e") String extension, @PathVariable("id") Object id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        expressRecordApiService.delete(username, sign, nonce, id);
        return JsonResult.ok();
    }


    @ResponseBody
    @RequestMapping(value = "/expressrecord/changepassword", method = RequestMethod.POST)
    public JsonResult changePasswordExpressRecord(@RequestHeader("u") String username, @RequestHeader("p") String password, String newPassword, String confirmPassword) {
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

    @RequestMapping(value = "/expressrecord/details.html", method = RequestMethod.GET)
    public String detailsExpressRecord() {
        return "admin/expressrecord/details";
    }

    @ResponseBody
    @RequestMapping(value = "/expressrecord/{id}/detail", method = RequestMethod.GET)
    public JsonResult queryExpressRecord(@PathVariable("id") Object id, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletRequestBindingException {
        if (id == null) {
            throw new ServletRequestBindingException("校验请求失败");
        }
        ExpressRecord expressRecord = expressRecordApiService.queryExpressRecord(id);
        return JsonResult.ok().addResult(expressRecord);
    }

    // ==================================================================================================================
    //医疗体检
    @Autowired
    private MedicalExaminationRecordApiService medicalExaminationRecordApiService;

    /*
    *  跳 转 详 情 页 面
    * */
    @RequestMapping(value = "/medicalExaminationRecord/details.html", method = RequestMethod.GET)
    public String detailsMedicalExaminationRecord() {
        return "admin/medicalexaminationrecord/details";
    }

    /*
    *  单 个 详 情
    * */
    @ResponseBody
    @RequestMapping(value = "/medicalExaminationRecord/{id}/detail", method = RequestMethod.GET)
    public JsonResult queryMedicalExaminationRecord(@PathVariable("id") Object id, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletRequestBindingException {
        if (id == null) {
            throw new ServletRequestBindingException("校验请求失败");
        }
        MedicalExaminationRecord medicalExaminationRecord = medicalExaminationRecordApiService.queryMedicalExaminationRecord(id);
        return JsonResult.ok().addResult(medicalExaminationRecord);
    }

//    /*
//    *  添 加
//    * */
//    @ResponseBody
//    @RequestMapping(value = "/medicalExaminationRecord/add", method = RequestMethod.POST)
//    public JsonResult addMedicalExaminationRecord(@RequestHeader("u") String username, @RequestHeader("s") String sign, @RequestHeader("n") Integer nonce, @RequestHeader("t") String timestamp, @RequestHeader("e") String extension, @Valid @RequestBody MedicalExaminationRecord medicalExaminationRecord, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws Exception {
//        BindingResultChecker.check(result);
//        request.setCharacterEncoding("UTF-8");
//        medicalExaminationRecordApiService.add(username, sign, nonce, medicalExaminationRecord, request);
//        return JsonResult.ok();
//    }




    // ==================================================================================================================
    //医疗门诊
    @Autowired
    private MedicalOutpatientRecordApiService medicalOutpatientRecordApiService;

    /*
    *  跳 转 详 情 页 面
    * */
    @RequestMapping(value = "/medicalOutpatientRecord/details.html", method = RequestMethod.GET)
    public String detailsMedicalOutpatientRecord() {
        return "admin/medicaloutpatientrecord/details";
    }

    /*
    *  单 个 详 情
    * */
    @ResponseBody
    @RequestMapping(value = "/medicalOutpatientRecord/{id}/detail", method = RequestMethod.GET)
    public JsonResult queryMedicalOutpatientRecord(@PathVariable("id") Object id, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletRequestBindingException {
        if (id == null) {
            throw new ServletRequestBindingException("校验请求失败");
        }
        MedicalOutpatientRecord medicalOutpatientRecord = medicalOutpatientRecordApiService.queryMedicalOutpatientRecord(id);
        return JsonResult.ok().addResult(medicalOutpatientRecord);
    }

//    /*
//    *  添 加
//    * */
//    @ResponseBody
//    @RequestMapping(value = "/medicalOutpatientRecord/add", method = RequestMethod.POST)
//    public JsonResult addMedicalOutpatientRecord(@RequestHeader("u") String username, @RequestHeader("s") String sign, @RequestHeader("n") Integer nonce, @RequestHeader("t") String timestamp, @RequestHeader("e") String extension, @Valid @RequestBody MedicalOutpatientRecord medicalOutpatientRecord, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws Exception {
//        BindingResultChecker.check(result);
//        request.setCharacterEncoding("UTF-8");
//        medicalOutpatientRecordApiService.add(username, sign, nonce, medicalOutpatientRecord, request);
//        return JsonResult.ok();
//    }


    // ==================================================================================================================
    //医疗出（住）院
    @Autowired
    private MedicalCheckinCheckoutRecordApiService medicalCheckinCheckoutRecordApiService;

    /*
    *  跳 转 详 情 页 面
    * */
    @RequestMapping(value = "/medicalCheckinCheckoutRecord/details.html", method = RequestMethod.GET)
    public String detailsMedicalCheckinCheckoutRecord() {
        return "admin/medicalcheckincheckoutrecord/details";
    }

    /*
    *  单 个 详 情
    * */
    @ResponseBody
    @RequestMapping(value = "/medicalCheckinCheckoutRecord/{id}/detail", method = RequestMethod.GET)
    public JsonResult queryMedicalCheckinCheckoutRecord(@PathVariable("id") Object id, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletRequestBindingException {
        if (id == null) {
            throw new ServletRequestBindingException("校验请求失败");
        }
        MedicalCheckinCheckoutRecord medicalCheckinCheckoutRecord = medicalCheckinCheckoutRecordApiService.queryMedicalCheckinCheckoutRecord(id);
        return JsonResult.ok().addResult(medicalCheckinCheckoutRecord);
    }

//    /*
//    *  添 加
//    * */
//    @ResponseBody
//    @RequestMapping(value = "/medicalNewbornRecord/add", method = RequestMethod.POST)
//    public JsonResult addMedicalOutpatientRecord(@RequestHeader("u") String username, @RequestHeader("s") String sign, @RequestHeader("n") Integer nonce, @RequestHeader("t") String timestamp, @RequestHeader("e") String extension, @Valid @RequestBody MedicalCheckinCheckoutRecord medicalCheckinCheckoutRecord, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws Exception {
//        BindingResultChecker.check(result);
//        request.setCharacterEncoding("UTF-8");
//        medicalCheckinCheckoutRecordApiService.add(username, sign, nonce, medicalCheckinCheckoutRecord, request);
//        return JsonResult.ok();
//    }


    // ==================================================================================================================
    //新生儿
    @Autowired
    private MedicalNewbornRecordApiService medicalNewbornRecordApiService;

    /*
    *  跳 转 详 情 页 面
    * */
    @RequestMapping(value = "/medicalNewbornRecord/details.html", method = RequestMethod.GET)
    public String detailsMedicalNewbornRecord() {
        return "admin/medicalnewbornrecord/details";
    }

    /*
    *  单 个 详 情
    * */
    @ResponseBody
    @RequestMapping(value = "/medicalNewbornRecord/{id}/detail", method = RequestMethod.GET)
    public JsonResult queryMedicalNewbornRecord(@PathVariable("id") Object id, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletRequestBindingException {
        if (id == null) {
            throw new ServletRequestBindingException("校验请求失败");
        }
        MedicalNewbornRecord medicalNewbornRecord = medicalNewbornRecordApiService.queryMedicalNewbornRecord(id);
        return JsonResult.ok().addResult(medicalNewbornRecord);
    }
//
//    /*
//    *  添 加
//    * */
//    @ResponseBody
//    @RequestMapping(value = "/medicalNewbornRecord/add", method = RequestMethod.POST)
//    public JsonResult addMedicalNewborntRecord(@RequestHeader("u") String username, @RequestHeader("s") String sign, @RequestHeader("n") Integer nonce, @RequestHeader("t") String timestamp, @RequestHeader("e") String extension, @Valid @RequestBody MedicalNewbornRecord medicalNewbornRecord, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws Exception {
//        BindingResultChecker.check(result);
//        request.setCharacterEncoding("UTF-8");
//        medicalNewbornRecordApiService.add(username, sign, nonce, medicalNewbornRecord, request);
//        return JsonResult.ok();
//    }


    // ==================================================================================================================
    //医保刷卡
    @Autowired
    private MedicalInsuranceCardRecordApiService medicalInsuranceCardRecordApiService;

    /*
    *  跳 转 详 情 页 面
    * */
    @RequestMapping(value = "/medicalInsuranceCardRecord/details.html", method = RequestMethod.GET)
    public String detailsMedicalInsuranceCardRecord() {
        return "admin/medicalinsurancecardrecord/details";
    }

    /*
    *  单 个 详 情
    * */
    @ResponseBody
    @RequestMapping(value = "/medicalInsuranceCardRecord/{id}/detail", method = RequestMethod.GET)
    public JsonResult queryMedicalInsuranceCardRecord(@PathVariable("id") Object id, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletRequestBindingException {
        if (id == null) {
            throw new ServletRequestBindingException("校验请求失败");
        }
        MedicalInsuranceCardRecord medicalInsuranceCardRecord = medicalInsuranceCardRecordApiService.queryMedicalInsuranceCardRecord(id);
        return JsonResult.ok().addResult(medicalInsuranceCardRecord);
    }
//
//    /*
//    *  添 加
//    * */
//    @ResponseBody
//    @RequestMapping(value = "/medicalInsuranceCardRecord/add", method = RequestMethod.POST)
//    public JsonResult addMedicalInsuranceCardtRecord(@RequestHeader("u") String username, @RequestHeader("s") String sign, @RequestHeader("n") Integer nonce, @RequestHeader("t") String timestamp, @RequestHeader("e") String extension, @Valid @RequestBody MedicalInsuranceCardRecord medicalInsuranceCardRecord, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws Exception {
//        BindingResultChecker.check(result);
//        request.setCharacterEncoding("UTF-8");
//        medicalInsuranceCardRecordApiService.add(username, sign, nonce, medicalInsuranceCardRecord, request);
//        return JsonResult.ok();
//    }


    // ==================================================================================================================
    //医疗患者
    @Autowired
    private MedicalPatientRecordApiService medicalPatientRecordApiService;

    /*
    *  跳 转 详 情 页 面
    * */
    @RequestMapping(value = "/medicalPatientRecord/details.html", method = RequestMethod.GET)
    public String detailsMedicalPatientRecord() {
        return "admin/medicalpatientrecord/details";
    }

    /*
    *  单 个 详 情
    * */
    @ResponseBody
    @RequestMapping(value = "/medicalPatientRecord/{id}/detail", method = RequestMethod.GET)
    public JsonResult queryMedicalPatientRecord(@PathVariable("id") Object id, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletRequestBindingException {
        if (id == null) {
            throw new ServletRequestBindingException("校验请求失败");
        }
        MedicalPatientRecord medicalPatientRecord = medicalPatientRecordApiService.queryMedicalPatientRecord(id);
        return JsonResult.ok().addResult(medicalPatientRecord);
    }
//
//    /*
//    *  添 加
//    * */
//    @ResponseBody
//    @RequestMapping(value = "/medicalPatientRecord/add", method = RequestMethod.POST)
//    public JsonResult addMedicalPatientRecord(@RequestHeader("u") String username, @RequestHeader("s") String sign, @RequestHeader("n") Integer nonce, @RequestHeader("t") String timestamp, @RequestHeader("e") String extension, @Valid @RequestBody MedicalPatientRecord medicalPatientRecord, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws Exception {
//        BindingResultChecker.check(result);
//        request.setCharacterEncoding("UTF-8");
//        medicalPatientApiService.add(username, sign, nonce, medicalPatientRecord, request);
//        return JsonResult.ok();
//    }

}