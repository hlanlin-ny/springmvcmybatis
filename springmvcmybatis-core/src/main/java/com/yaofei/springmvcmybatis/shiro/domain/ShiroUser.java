package com.yaofei.springmvcmybatis.shiro.domain;

import java.io.Serializable;

/**
 * @description：自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息
 */
public class ShiroUser implements Serializable {
    private static final long serialVersionUID = -1373760761780840081L;
    
    private Long id;
    private String username;
    private String userRealName;
    private Long areaId;
    //private Set<String> stringPermissions;
    //private Set<String> roles;

    public ShiroUser(String username) {
        this.username = username;
    }

    public ShiroUser(Long id, String username, String userRealName) {
        this.id = id;
        this.username = username;
        this.userRealName = userRealName;
    }

    public ShiroUser(Long id, String username, String userRealName,Long areaId) {
        this.id = id;
        this.username = username;
        this.userRealName = userRealName;
        this.areaId=areaId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //public Set<String> getStringPermissions() {
    //    return stringPermissions;
    //}
    //
    //public void setStringPermissions(Set<String> stringPermissions) {
    //    this.stringPermissions = stringPermissions;
    //}
    //
    //public Set<String> getRoles() {
    //    return roles;
    //}
    //
    //public void setRoles(Set<String> roles) {
    //    this.roles = roles;
    //}

    public String getUserRealName() {
        return userRealName;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    /**
     * 本函数输出将作为默认的<shiro:principal/>输出.
     */
    @Override
    public String toString() {
        return username;
    }
}