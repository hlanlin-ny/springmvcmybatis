package com.yaofei.springmvcmybatis.webapp.controller;

import com.yaofei.springmvcmybatis.entity.SysUserUserRole;
import com.yaofei.springmvcmybatis.service.SysUserUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 系统用户角色关系表
 * 
 * @author f_yao
 * @email f_yao@ctrip.com
 * @date 2017-02-08 18:32:22
 */
@Controller
@RequestMapping("/admin/sysuseruserrole")
public class SysUserUserRoleController extends BaseCRUDController<SysUserUserRole> {
	@Autowired
	private SysUserUserRoleService sysUserUserRoleService;
}