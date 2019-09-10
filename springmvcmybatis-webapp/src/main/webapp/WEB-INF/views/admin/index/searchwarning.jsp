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
      <ul class="sidebar-menu">
        <li class="header">系统导航</li>

        <shiro:hasPermission name="controlapplyapplication:list">
          <li data-url="${ctxPath}/admin/controlapplyapplication/list.html">
            <a href="#">
              <i class="fa fa-wrench"></i> <span>临时预警布控</span>
            </a>
          </li>
        </shiro:hasPermission>

        <shiro:hasPermission name="importantperson:list">
          <li data-url="${ctxPath}/admin/importantperson/list.html">
            <a href="#">
              <i class="fa fa-user"></i> <span>重点人员信息</span>
            </a>
          </li>
        </shiro:hasPermission>

        <shiro:hasPermission name="warningdispostion:list">
          <li data-url="${ctxPath}/admin/warningdispostion/list.html">
            <a href="#">
              <i class="fa fa-wrench"></i> <span>活动预警详情</span>
            </a>
          </li>
        </shiro:hasPermission>


        <%--<shiro:hasPermission name="sysSearchWarning:menu">--%>
          <%--<li class="treeview"><a href="#"><i class="fa fa-bell"></i> <span>搜索预警</span>--%>
                    <%--<span class="pull-right-container">--%>
                        <%--<i class="fa fa-angle-left pull-right"></i>--%>
                    <%--</span>--%>
          <%--</a>--%>
            <%--<ul class="treeview-menu">--%>
              <%--<shiro:hasPermission name="controlapplyapplication:list">--%>
                <%--<li class="active" data-url="${ctxPath}/admin/controlapplyapplication/list.html"><a--%>
                        <%--href="#"><i--%>
                        <%--class="fa fa-wrench"></i> 临时预警布控</a></li>--%>
              <%--</shiro:hasPermission>--%>
              <%--<shiro:hasPermission name="sysSearchWarningConfig:list">--%>
                <%--<li class="active" data-url="${ctxPath}/admin/syssearchwarningconfig/list.html"><a--%>
                        <%--href="#"><i--%>
                        <%--class="fa fa-street-view"></i> 搜索预警设置</a></li>--%>
              <%--</shiro:hasPermission>--%>
              <%--&lt;%&ndash;<shiro:hasPermission name="sysSearchWarningLog:list">&ndash;%&gt;--%>
                <%--&lt;%&ndash;<li class="active" data-url="${ctxPath}/admin/syssearchwarninglog/list.html"><a&ndash;%&gt;--%>
                        <%--&lt;%&ndash;href="#"><i&ndash;%&gt;--%>
                        <%--&lt;%&ndash;class="fa fa-sticky-note"></i> 搜索结果日志</a></li>&ndash;%&gt;--%>
              <%--&lt;%&ndash;</shiro:hasPermission>&ndash;%&gt;--%>
              <%--<shiro:hasPermission name="importantPerson:list">--%>
                <%--<li class="active" data-url="${ctxPath}/admin/importantperson/list.html"><a--%>
                        <%--href="#"><i--%>
                        <%--class="fa fa-user"></i> 重点人员信息</a></li>--%>
              <%--</shiro:hasPermission>--%>
              <%--&lt;%&ndash;<shiro:hasPermission name="warningDispostion:list">&ndash;%&gt;--%>
                <%--&lt;%&ndash;<li class="active" data-url="${ctxPath}/admin/warningdispostion/list.html"><a&ndash;%&gt;--%>
                        <%--&lt;%&ndash;href="#"><i&ndash;%&gt;--%>
                        <%--&lt;%&ndash;class="fa fa-street-view"></i> 活动预警详情</a></li>&ndash;%&gt;--%>
              <%--&lt;%&ndash;</shiro:hasPermission>&ndash;%&gt;--%>
            <%--</ul>--%>
          <%--</li>--%>
        <%--</shiro:hasPermission>--%>
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