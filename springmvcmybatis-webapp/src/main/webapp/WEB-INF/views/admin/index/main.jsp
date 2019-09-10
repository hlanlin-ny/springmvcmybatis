<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/WEB-INF/views/admin/common/basecss.jsp" %>
    <title>AdminLTE 2 | Dashboard</title>
</head>

<body style="padding: 0;margin:0;">
<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        后台首页
        <small></small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#" id="index"><i class="fa fa-home"></i> 首页</a></li>
        <%--<a href="${ctxPath}/admin/index/index.html"></a>--%>
    </ol>
</section>

<!-- Main content -->
<section class="content"  style="width:200px;">



</section>
<!-- /.content -->
<%@ include file="/WEB-INF/views/admin/common/basejs.jsp" %>
<script>
    $().ready(function(){
        $("#index").click(function(){
            top.location = "${ctxPath}/admin/index/index.html";
        });
    });
</script>
<!-- 本页面用到的js -->
</body>
</html>
