//package com.yaofei.springmvcmybatis.framework.web.control;
//
//import com.alibaba.fastjson.JSONObject;
//import com.yaofei.springmvcmybatis.framework.service.impl.ServerMonitorServiceImpl;
//import com.yaofei.springmvcmybatis.framework.web.dto.common.JsonResult;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@Controller
//@RequestMapping("ServerMonitor")
//public class ServerMonitorController {
//
//    @Autowired
//    private ServerMonitorServiceImpl monitorService;
//
//    @RequestMapping(value = "", method = RequestMethod.GET)
//    @ResponseBody
//    public ResponseEntity<JsonResult> monitor() throws Exception {
//        JSONObject monitor = monitorService.monitor();
//        JsonResult result = new JsonResult();
//        result.addAttribute("result", monitor);
//        Boolean ok = monitor.getBoolean("ok");
//        if (ok) {
//            return new ResponseEntity<JsonResult>(result, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<JsonResult>(result, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//}