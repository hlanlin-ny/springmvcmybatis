package com.yaofei.springmvcmybatis.repository;

import com.yaofei.springmvcmybatis.BaseSpringJunit4Test;
import org.junit.Test;

/**
 * Created by f_yao on 2017/2/8.
 */
public class SysUserRepositoryTest extends BaseSpringJunit4Test {

    @Test
    public void queryTotal() {
        //从spring容器中获取mapper的动态代理对象userMapper
        SysUserRepository sysUserRepository = (SysUserRepository) getBean("sysUserRepository");
        System.out.println(sysUserRepository.queryTotal());
    }
}
