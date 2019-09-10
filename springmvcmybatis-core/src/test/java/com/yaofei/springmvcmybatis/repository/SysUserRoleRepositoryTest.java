package com.yaofei.springmvcmybatis.repository;

import com.yaofei.springmvcmybatis.BaseSpringJunit4Test;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by f_yao on 2017/2/8.
 */
public class SysUserRoleRepositoryTest extends BaseSpringJunit4Test {

    @Autowired
    private SysUserRoleRepository sysUserRoleRepository;

    @Test
    public void queryTotal() {
        System.out.println(sysUserRoleRepository.queryTotal());
    }
}
