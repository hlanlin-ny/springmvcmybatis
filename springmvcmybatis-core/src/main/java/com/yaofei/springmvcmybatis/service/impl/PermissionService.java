package com.yaofei.springmvcmybatis.service.impl;

import com.google.common.collect.Maps;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.io.Serializable;
import java.util.Map;

public class PermissionService implements Serializable {

    @Autowired
    private MessageSource messageSource;

    public static final String LIST_PERMISSION = "list";
    public static final String SEARCH_PERMISSION = "search";
    public static final String REFERSH_PERMISSION = "refersh";

    public static final String ADD_PERMISSION = "add";
    public static final String EDIT_PERMISSION = "edit";
    public static final String DELETE_PERMISSION = "delete";
    public static final String BATCHDELETE_PERMISSION = "batchdelete";

    public static final String EXPORT_PERMISSION = "export";
    public static final String VIEW_PERMISSION = "view";

    public static final String DEFAULT_MESSAGE = "对不起，你没有相关权限，请联系系统管理员！";

    /**
     * 资源前缀
     */
    private String resourceIdentity;

    /**
     * key:    权限
     * value : 资源
     */
    private Map<String, String> resourcePermissions = Maps.newHashMap();


    /**
     * 自动生成 create update delete 的权限串
     *
     * @param resourceIdentity
     * @return
     */
    public static PermissionService newPermissionList(String resourceIdentity) {

        PermissionService permissionService = new PermissionService();

        permissionService.resourceIdentity = resourceIdentity;

        permissionService.resourcePermissions.put(LIST_PERMISSION, resourceIdentity + ":" + LIST_PERMISSION);
        permissionService.resourcePermissions.put(SEARCH_PERMISSION, resourceIdentity + ":" + SEARCH_PERMISSION);
        permissionService.resourcePermissions.put(REFERSH_PERMISSION, resourceIdentity + ":" + REFERSH_PERMISSION);

        permissionService.resourcePermissions.put(ADD_PERMISSION, resourceIdentity + ":" + ADD_PERMISSION);
        permissionService.resourcePermissions.put(EDIT_PERMISSION, resourceIdentity + ":" + EDIT_PERMISSION);
        permissionService.resourcePermissions.put(DELETE_PERMISSION, resourceIdentity + ":" + DELETE_PERMISSION);
        permissionService.resourcePermissions.put(BATCHDELETE_PERMISSION, resourceIdentity + ":" + BATCHDELETE_PERMISSION);

        permissionService.resourcePermissions.put(EXPORT_PERMISSION, resourceIdentity + ":" + EXPORT_PERMISSION);
        permissionService.resourcePermissions.put(VIEW_PERMISSION, resourceIdentity + ":" + VIEW_PERMISSION);

        return permissionService;
    }

    /**
     * 添加权限 自动生成如 showcase:permission
     */
    public void addPermission(String permission) {
        resourcePermissions.put(permission, resourceIdentity + ":" + permission);
    }


    public void assertHasListPermission() {
        assertHasPermission(LIST_PERMISSION);
    }

    public void assertHasSearchPermission() {
        assertHasAnyPermission(new String[]{
                SEARCH_PERMISSION,
                REFERSH_PERMISSION,
                ADD_PERMISSION,
                EDIT_PERMISSION,
                DELETE_PERMISSION,
                BATCHDELETE_PERMISSION,
                EXPORT_PERMISSION,
                VIEW_PERMISSION,
                DELETE_PERMISSION
        });
    }

    public void assertHasAddPermission() {
        assertHasPermission(ADD_PERMISSION);
    }

    public void assertHasEditPermission() {
        assertHasPermission(EDIT_PERMISSION);
    }

    public void assertHasDeletePermission() {
        assertHasPermission(DELETE_PERMISSION);
    }


    public void assertHasBatchDeletePermission() {
        assertHasPermission(BATCHDELETE_PERMISSION);
    }

    public void assertHasPermission(String permission) {

        String resourcePermission = resourcePermissions.get(permission);
        if (resourcePermission == null) {
            resourcePermission = this.resourceIdentity + ":" + permission;
        }
        if (!SecurityUtils.getSubject().isPermitted(resourcePermission)) {
            throw new UnauthorizedException(DEFAULT_MESSAGE);
        }
    }

    public void assertHasAllPermission(String[] permissions) {
        if (permissions == null || permissions.length == 0) {
            throw new UnauthorizedException(DEFAULT_MESSAGE);
        }

        Subject subject = SecurityUtils.getSubject();

        for (String permission : permissions) {
            String resourcePermission = resourcePermissions.get(permission);
            if (resourcePermission == null) {
                resourcePermission = this.resourceIdentity + ":" + permission;
            }
            if (!subject.isPermitted(resourcePermission)) {
                throw new UnauthorizedException(DEFAULT_MESSAGE);
            }
        }
    }

    public void assertHasAnyPermission(String[] permissions) {
        if (permissions == null || permissions.length == 0) {
            throw new UnauthorizedException(DEFAULT_MESSAGE);
        }

        Subject subject = SecurityUtils.getSubject();
        for (String permission : permissions) {
            String resourcePermission = resourcePermissions.get(permission);
            if (resourcePermission == null) {
                resourcePermission = this.resourceIdentity + ":" + permission;
            }
            if (subject.isPermitted(resourcePermission)) {
                return;
            }
        }

        throw new UnauthorizedException(DEFAULT_MESSAGE);
    }
}