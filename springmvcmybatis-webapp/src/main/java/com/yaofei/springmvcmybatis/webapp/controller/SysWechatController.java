package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.SysWechat;
import com.yaofei.springmvcmybatis.service.SysWechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 信息员微信群
 * 
 * @author yaofei
 * @email f_yao@ctrip.com
 * @date 2017-08-17 09:46:13
 */
@Controller
@RequestMapping("/admin/syswechat")
public class SysWechatController extends BaseCRUDController<SysWechat>  {
	@Autowired
	private SysWechatService sysWechatService;

}