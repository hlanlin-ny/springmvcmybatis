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
    <title>系统设置</title>
</head>
<%--<body class="hold-transition skin-blue fixed sidebar-mini">--%>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <%@ include file="/WEB-INF/views/admin/index/headerModule.jsp" %>
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- sidebar menu: : style can be found in sidebar.less -->
            <ul class="sidebar-menu">
                <li class="header">系统导航</li>

                <shiro:hasPermission name="sysmanage:menu">
                    <li class="treeview active"><a href="#"><i class="fa fa-laptop"></i> <span>系统管理</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                    </a>
                        <ul class="treeview-menu">
                            <shiro:hasPermission name="sysconfig:list">
                                <li data-url="${ctxPath}/admin/sysconfig/list.html"><a href="#"><i
                                        class="fa fa-cog"></i>系统设置 </a></li>
                            </shiro:hasPermission>
                                <%--<shiro:hasPermission name="sysconfig:list">--%>
                                <%--<li class="active" data-url="${ctxPath}/admin/sysconfig/list.html"><a--%>
                                <%--href="#"><i--%>
                                <%--class="fa fa-gg"></i> 参数管理</a></li>--%>
                                <%--</shiro:hasPermission>--%>
                            <shiro:hasPermission name="syslog:list">
                                <li data-url="${ctxPath}/admin/syslog/list.html"><a href="#"><i
                                        class="fa fa-eye"></i> 系统日志</a></li>
                            </shiro:hasPermission>
                                <%--<shiro:hasPermission name="druid:list">--%>
                                <%--<li data-url="${ctxPath}/druid"><a href="#"><i--%>
                                <%--class="fa fa-heartbeat"></i>Druid监控</a></li>--%>
                                <%--</shiro:hasPermission>--%>
                            <shiro:hasPermission name="schedulejob:list">
                                <li data-url="${ctxPath}/admin/schedulejob/list.html"><a href="#"><i
                                        class="fa fa-clock-o"></i> 定时任务管理</a></li>
                            </shiro:hasPermission>
                            <shiro:hasPermission name="schedulejoblog:list">
                                <li data-url="${ctxPath}/admin/schedulejoblog/list.html"><a href="#"><i
                                        class="fa fa-history"></i> 定时任务日志</a></li>
                            </shiro:hasPermission>
                                <%--<shiro:hasPermission name="syscodegenerator:list">--%>
                                <%--<li data-url="${ctxPath}/admin/syscodegenerator/list.html"><a href="#"><i--%>
                                <%--class="fa fa-code"></i> 代码生成器</a></li>--%>
                                <%--</shiro:hasPermission>--%>
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