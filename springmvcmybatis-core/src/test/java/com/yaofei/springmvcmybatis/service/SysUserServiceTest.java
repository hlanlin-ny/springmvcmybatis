package com.yaofei.springmvcmybatis.service;

import com.yaofei.springmvcmybatis.BaseSpringJunit4Test;
import org.apache.tika.exception.TikaException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * Created by f_yao on 2017/2/9.
 */
public class SysUserServiceTest extends BaseSpringJunit4Test {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private IntelligenceImportService intelligenceImportService;

    @Test
    public void queryTotal() {

        System.out.println(sysUserService.querySysUserByUsername("admin"));

        System.out.println("-------------------------------------------------------------------");
        System.out.println(sysUserService.querySysUserByUsername("admin"));

        System.out.println("-------------------------------------------------------------------");
        Long[] ids = new Long[1];
        ids[0] = 0L;
        sysUserService.deleteUserAndUserRolesInBatch(ids);
    }



}
