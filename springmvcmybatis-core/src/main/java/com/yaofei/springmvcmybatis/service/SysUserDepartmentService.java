package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.entity.SysUserDepartment;

import java.util.List;
import java.util.Map;

/**
 * 系统用户部门表
 *
 * @author f_yao
 * @email f_yao@ctrip.com
 * @date 2017-02-08 18:32:22
 */
public interface SysUserDepartmentService extends BaseService<SysUserDepartment> {

    List<SysUserDepartment> queryListOrderByOrderNum();

    Map querySysUserDepartmentIdNameMap();
}