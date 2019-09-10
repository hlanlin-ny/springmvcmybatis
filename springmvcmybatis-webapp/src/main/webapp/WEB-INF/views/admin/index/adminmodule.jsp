<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/WEB-INF/views/admin/common/basecss.jsp" %>
    <%-- jQuery validation --%>
    <link rel="stylesheet" href="${ctxPath}/resources/plugins/jquery-validation/validation.css">
    <%-- Pace style --%>
    <link rel="stylesheet" href="${ctxPath}/resources/plugins/pace/pace.min.css">
    <title>情报管理大数据平台</title>

</head>
<%--<body class="hold-transition skin-blue fixed sidebar-mini">--%>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <%@ include file="/WEB-INF/views/admin/index/headerModule.jsp" %>

    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- Sidebar user panel -->
            <ul class="sidebar-menu">
                <li class="header">系统导航</li>
                <shiro:hasPermission name="userpermission:menu">
                    <li class="treeview active">   <a href="#"><i class="fa fa-user-secret">
                    </i>
                        <span>用户权限管理</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                    </a>
                        <ul class="treeview-menu">
                            <shiro:hasPermission name="sysarea:list">
                                <li data-url="${ctxPath}/admin/sysarea/list.html"><a
                                        href="#"><i
                                        class="fa fa-institution"></i> 行政区划管理</a></li>
                            </shiro:hasPermission>
                            <shiro:hasPermission name="sysuserdepartment:list">
                                <li data-url="${ctxPath}/admin/sysuserdepartment/list.html"><a
                                        href="#"><i
                                        class="fa fa-building"></i>部门管理</a></li>
                            </shiro:hasPermission>
                            <shiro:hasPermission name="sysuserpermission:list">
                                <li data-url="${ctxPath}/admin/sysuserpermission/list.html"><a href="#"><i
                                        class="fa fa-key"></i>权限管理</a></li>
                            </shiro:hasPermission>
                            <shiro:hasPermission name="sysuserrole:list">
                                <li data-url="${ctxPath}/admin/sysuserrole/list.html"><a href="#"><i
                                        class="fa fa-users"></i>
                                    角色管理</a></li>
                            </shiro:hasPermission>
                            <shiro:hasPermission name="sysuser:list">
                                <li data-url="${ctxPath}/admin/sysuser/list.html"><a href="#"><i class="fa fa-user"></i>
                                    用户管理</a></li>
                            </shiro:hasPermission>
                        </ul>
                    </li>
                </shiro:hasPermission>
            </ul>
        </section>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper" id="main_content">
        <%--<div class="embed-responsive embed-responsive-16by9">--%>
        <%--<div style="display: none" class="embed-responsive-item loading"></div>--%>
        <%--<iframe id="content-frame" class="embed-responsive-item" frameborder="0"></iframe>--%>
        <%--</div>--%>
        <iframe id="content-frame" scrolling="yes" frameborder="0"
                style="width:100%;height:100%;min-height:200px;" src="${ctxPath}/admin/index/main.html"></iframe>
    </div>
    <!-- /.content-wrapper -->

    <footer class="main-footer" style="padding: 2px; border: none;">
    </footer>

</div>
<!-- ./wrapper -->

<%@ include file="/WEB-INF/views/admin/index/changepassword.jsp" %>
<%@ include file="/WEB-INF/views/admin/index/modulejs.jsp" %>
<%@ include file="/WEB-INF/views/admin/index/warning.jsp" %>

</body>
</html>