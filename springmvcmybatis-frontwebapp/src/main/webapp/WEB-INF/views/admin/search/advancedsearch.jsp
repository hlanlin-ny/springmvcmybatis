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
    <%-- daterange picker --%>
    <link rel="stylesheet" href="${ctxPath}/resources/plugins/daterangepicker/daterangepicker.css">
    <%--iCheck--%>
    <link rel="stylesheet" href="${ctxPath}/resources/plugins/iCheck/all.css">
    <%-- jQuery validation --%>
    <link rel="stylesheet" href="${ctxPath}/resources/plugins/jquery-validation/validation.css">
    <%-- zTree --%>
    <link rel="stylesheet" href="${ctxPath}/resources/plugins/zTree/css/metroStyle/metroStyle.css">

    <link rel="icon" href="${ctxPath}/resources/dist/img/favicon.ico" type="image/x-icon"/>
    <link rel="shortcut icon" href="${ctxPath}/resources/dist/img/favicon.png" type="image/x-icon"/>
    <title>情报管理大数据平台</title>
</head>
<!-- ADD THE CLASS layout-top-nav TO REMOVE THE SIDEBAR. -->
<body class="hold-transition skin-blue layout-top-nav">
<div class="wrapper">

    <header class="main-header">
        <nav class="navbar navbar-static-top"
             style="background-image:url('${ctxPath}/resources/dist/img/logo_bg.jpg'); background-repeat:repeat-x">
            <div class="container">
                <div class="navbar-header">
                    <a href="${ctxPath}/admin/index/index.html"><img src="${ctxPath}/resources/dist/img/logo.jpg"
                                                                     style="padding-left: 12px;"></a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <%--<div class="collapse navbar-collapse pull-right" id="navbar-collapse">--%>
                <%--<ul class="nav navbar-nav">--%>
                <%--<li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>--%>
                <%--<li><a href="#">Link</a></li>--%>
                <%--<li class="dropdown">--%>
                <%--<a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <span--%>
                <%--class="caret"></span></a>--%>
                <%--<ul class="dropdown-menu" role="menu">--%>
                <%--<li><a href="#">Action</a></li>--%>
                <%--<li><a href="#">Another action</a></li>--%>
                <%--<li><a href="#">Something else here</a></li>--%>
                <%--<li class="divider"></li>--%>
                <%--<li><a href="#">Separated link</a></li>--%>
                <%--<li class="divider"></li>--%>
                <%--<li><a href="#">One more separated link</a></li>--%>
                <%--</ul>--%>
                <%--</li>--%>
                <%--</ul>--%>
                <%--<form class="navbar-form navbar-left" role="search">--%>
                <%--<div class="form-group">--%>
                <%--<input type="text" class="form-control" id="navbar-search-input" placeholder="Search">--%>
                <%--</div>--%>
                <%--</form>--%>
                <%--</div>--%>
                <!-- /.navbar-collapse -->
                <!-- Navbar Right Menu -->
                <div class="navbar-custom-menu" style="margin-right: 12px;">
                    <ul class="nav navbar-nav">
                        <%--<li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>--%>
                        <li><a href="${ctxPath}/admin/search/advancedSearch.html">高级搜索</a></li>
                        <%--<li class="dropdown">--%>
                        <%--<a href="#" class="dropdown-toggle" data-toggle="dropdown">高级搜索 <span--%>
                        <%--class="caret"></span></a>--%>
                        <%--<ul class="dropdown-menu" role="menu">--%>
                        <%--<li><a href="#">Action</a></li>--%>
                        <%--<li><a href="#">Another action</a></li>--%>
                        <%--<li><a href="#">Something else here</a></li>--%>
                        <%--<li class="divider"></li>--%>
                        <%--<li><a href="#">Separated link</a></li>--%>
                        <%--<li class="divider"></li>--%>
                        <%--<li><a href="#">One more separated link</a></li>--%>
                        <%--</ul>--%>
                        <%--</li>--%>
                        <!-- Messages: style can be found in dropdown.less-->
                        <%--<li class="dropdown messages-menu">--%>
                        <%--<!-- Menu toggle button -->--%>
                        <%--<a href="#" class="dropdown-toggle" data-toggle="dropdown">--%>
                        <%--<i class="fa fa-envelope-o"></i>--%>
                        <%--<span class="label label-success">4</span>--%>
                        <%--</a>--%>
                        <%--<ul class="dropdown-menu">--%>
                        <%--<li class="header">You have 4 messages</li>--%>
                        <%--<li>--%>
                        <%--<!-- inner menu: contains the messages -->--%>
                        <%--<ul class="menu">--%>
                        <%--<li><!-- start message -->--%>
                        <%--<a href="#">--%>
                        <%--<div class="pull-left">--%>
                        <%--<!-- User Image -->--%>
                        <%--<img src="../../dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">--%>
                        <%--</div>--%>
                        <%--<!-- Message title and timestamp -->--%>
                        <%--<h4>--%>
                        <%--Support Team--%>
                        <%--<small><i class="fa fa-clock-o"></i> 5 mins</small>--%>
                        <%--</h4>--%>
                        <%--<!-- The message -->--%>
                        <%--<p>Why not buy a new awesome theme?</p>--%>
                        <%--</a>--%>
                        <%--</li>--%>
                        <%--<!-- end message -->--%>
                        <%--</ul>--%>
                        <%--<!-- /.menu -->--%>
                        <%--</li>--%>
                        <%--<li class="footer"><a href="#">See All Messages</a></li>--%>
                        <%--</ul>--%>
                        <%--</li>--%>
                        <!-- /.messages-menu -->

                        <!-- Notifications Menu -->
                        <%--<li class="dropdown notifications-menu">--%>
                        <%--<!-- Menu toggle button -->--%>
                        <%--<a href="#" class="dropdown-toggle" data-toggle="dropdown">--%>
                        <%--<i class="fa fa-bell-o"></i>--%>
                        <%--<span class="label label-warning">10</span>--%>
                        <%--</a>--%>
                        <%--<ul class="dropdown-menu">--%>
                        <%--<li class="header">You have 10 notifications</li>--%>
                        <%--<li>--%>
                        <%--<!-- Inner Menu: contains the notifications -->--%>
                        <%--<ul class="menu">--%>
                        <%--<li><!-- start notification -->--%>
                        <%--<a href="#">--%>
                        <%--<i class="fa fa-users text-aqua"></i> 5 new members joined today--%>
                        <%--</a>--%>
                        <%--</li>--%>
                        <%--<!-- end notification -->--%>
                        <%--</ul>--%>
                        <%--</li>--%>
                        <%--<li class="footer"><a href="#">View all</a></li>--%>
                        <%--</ul>--%>
                        <%--</li>--%>
                        <!-- Tasks Menu -->
                        <%--<li class="dropdown tasks-menu">--%>
                        <%--<!-- Menu Toggle Button -->--%>
                        <%--<a href="#" class="dropdown-toggle" data-toggle="dropdown">--%>
                        <%--<i class="fa fa-flag-o"></i>--%>
                        <%--<span class="label label-danger">9</span>--%>
                        <%--</a>--%>
                        <%--<ul class="dropdown-menu">--%>
                        <%--<li class="header">You have 9 tasks</li>--%>
                        <%--<li>--%>
                        <%--<!-- Inner menu: contains the tasks -->--%>
                        <%--<ul class="menu">--%>
                        <%--<li><!-- Task item -->--%>
                        <%--<a href="#">--%>
                        <%--<!-- Task title and progress text -->--%>
                        <%--<h3>--%>
                        <%--Design some buttons--%>
                        <%--<small class="pull-right">20%</small>--%>
                        <%--</h3>--%>
                        <%--<!-- The progress bar -->--%>
                        <%--<div class="progress xs">--%>
                        <%--<!-- Change the css width attribute to simulate progress -->--%>
                        <%--<div class="progress-bar progress-bar-aqua" style="width: 20%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">--%>
                        <%--<span class="sr-only">20% Complete</span>--%>
                        <%--</div>--%>
                        <%--</div>--%>
                        <%--</a>--%>
                        <%--</li>--%>
                        <%--<!-- end task item -->--%>
                        <%--</ul>--%>
                        <%--</li>--%>
                        <%--<li class="footer">--%>
                        <%--<a href="#">View all tasks</a>--%>
                        <%--</li>--%>
                        <%--</ul>--%>
                        <%--</li>--%>
                        <!-- User Account Menu -->
                        <li class="dropdown user user-menu">
                            <!-- Menu Toggle Button -->
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <!-- The user image in the navbar-->
                                <img src="${ctxPath}/resources/dist/img/user2-160x160.jpg" class="user-image"
                                     alt="User Image">
                                <!-- hidden-xs hides the username on small devices so only the image appears. -->
                                <span class="hidden-xs"><myshiro:currentName/></span>
                            </a>
                            <ul class="dropdown-menu">
                                <!-- The user image in the menu -->
                                <%--<li class="user-header">--%>
                                <%--<img src="../../dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">--%>

                                <%--<p>--%>
                                <%--Alexander Pierce - Web Developer--%>
                                <%--<small>Member since Nov. 2012</small>--%>
                                <%--</p>--%>
                                <%--</li>--%>
                                <!-- Menu Body -->
                                <%--<li class="user-body">--%>
                                <%--<div class="row">--%>
                                <%--<div class="col-xs-4 text-center">--%>
                                <%--<a href="#">Followers</a>--%>
                                <%--</div>--%>
                                <%--<div class="col-xs-4 text-center">--%>
                                <%--<a href="#">Sales</a>--%>
                                <%--</div>--%>
                                <%--<div class="col-xs-4 text-center">--%>
                                <%--<a href="#">Friends</a>--%>
                                <%--</div>--%>
                                <%--</div>--%>
                                <%--<!-- /.row -->--%>
                                <%--</li>--%>
                                <!-- Menu Footer-->
                                <li class="user-footer">
                                    <div class="pull-left">
                                        <a id="btn-change-password" href="#" class="btn btn-default btn-flat">修改密码</a>
                                    </div>
                                    <div class="pull-right">
                                        <a href="${ctxPath}/admin/login/logout"
                                           class="btn btn-default btn-flat">安全退出</a>
                                    </div>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-custom-menu -->
            </div>
            <!-- /.container-fluid -->
        </nav>
    </header>
    <!-- Full Width Column -->
    <div class="content-wrapper">
        <div class="container">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>
                    高级搜索
                    <%--<small>Example 2.0</small>--%>
                </h1>
                <%--<ol class="breadcrumb">--%>
                <%--<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>--%>
                <%--<li><a href="#">Layout</a></li>--%>
                <%--<li class="active">Top Navigation</li>--%>
                <%--</ol>--%>
            </section>

            <!-- Main content -->
            <section class="content">
                <!-- form start -->
                <form id="query-form" class="form-horizontal">
                    <div class="box box-default">
                        <div class="box-header with-border">
                            <h3 class="box-title">搜索条件</h3>
                            <div class="box-tools pull-right">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                </button>
                            </div>
                            <!-- /.box-tools -->
                        </div>
                        <div class="box-body">
                            <input type="hidden" id="datasourceType" name="datasourceType"
                                   value="1"/>
                            <input type="hidden" class="form-control" id="keyword" name="keyword">
                            <input type="hidden" class="form-control" id="pageIndex"
                                   name="pageIndex" value="1">
                            <input type="hidden" class="form-control" id="pageSize"
                                   name="pageSize" value="10">

                            <div class="form-group">
                                <label for="keyword1" class="col-sm-3 control-label">包含这些全部的关键词</label>

                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="keyword1"
                                           name="keyword1" placeholder="包含这些全部的关键词"/>
                                </div>
                            </div>

                            <%--<div class="form-group">--%>
                                <%--<label for="keyword2" class="col-sm-3 control-label">包含这个的完整关键词</label>--%>

                                <%--<div class="col-sm-9">--%>
                                    <%--<input type="text" class="form-control" id="keyword2"--%>
                                           <%--name="keyword2" placeholder="包含这个的完整关键词"/>--%>
                                <%--</div>--%>
                            <%--</div>--%>

                            <div class="form-group">
                                <label for="keyword2" class="col-sm-3 control-label">包含这些任意一个关键词</label>

                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="keyword2"
                                           name="keyword2" placeholder="包含这些任意一个关键词"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="keyword3" class="col-sm-3 control-label">不包括这些关键词</label>

                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="keyword3"
                                           name="keyword3" placeholder="不包括这些关键词"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="reservation" class="col-sm-3 control-label">时间范围</label>

                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="reservation" name="reservation">
                                    <input type="hidden" class="form-control" id="startTime"
                                           name="startTime">
                                    <input type="hidden" class="form-control" id="endTime"
                                           name="endTime">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="tree-layer" class="col-sm-3 control-label">情报分类</label>
                                <div class="col-sm-9">
                                    <input type="hidden" class="form-control" id="intelligenceBusinessTypeIds" name="intelligenceBusinessTypeIds">
                                    <div id="tree-layer" class="box box-solid">
                                        <div class="box-body">
                                            <ul id="menuTree" class="ztree"></ul>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="reservation" class="col-sm-3 control-label">文件类型</label>

                                <div class="col-sm-9">
                                    <div class="checkbox" id="fileTypeList">
                                        <label><input type='checkbox' name='fileType' value="1">结构化数据</label>
                                        <label><input type='checkbox' name='fileType' value="2">word文件</label>
                                        <label><input type='checkbox' name='fileType' value="3">ppt文件</label>
                                        <label><input type='checkbox' name='fileType' value="4">excel文件</label>
                                        <label><input type='checkbox' name='fileType' value="5">txt文件</label>
                                        <label><input type='checkbox' name='fileType' value="6">csv文件</label>
                                        <label><input type='checkbox' name='fileType' value="7">pdf文件</label>
                                        <label><input type='checkbox' name='fileType' value="8">图片文件</label>
                                        <label><input type='checkbox' name='fileType' value="9">音频文件</label>
                                        <label><input type='checkbox' name='fileType' value="10">视频文件</label>
                                    </div>
                                    <input type="hidden" class="form-control" id="fileTypes" name="fileTypes">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="reservation" class="col-sm-3 control-label">只显示精确匹配结果</label>

                                <div class="col-sm-9">
                                    <div class="checkbox" id="preciseQueryList">
                                        <label><input type='checkbox' id="preciseQuery" name='preciseQuery' value="1">是</label>
                                    </div>
                                </div>
                            </div>


                            <div class="pull-right">
                                <button id="btn-search" type="button" class="btn btn-primary"><i
                                        class="fa fa-search"></i> 搜 索
                                </button>
                                <button id="btn-reset" type="button" class="btn btn-default"><i class="fa fa-undo"></i>
                                    重 置
                                </button>
                            </div>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </form>

                <div class="box box-default">
                    <div class="box-header with-border">
                        <h3 class="box-title">搜索结果</h3>
                        <div class="box-tools">
                            <div class="input-group input-group-sm"
                                 style="width: 780px; margin-top: 5px;">
                                <div class="row">
                                    <div class="col-md-6">
                                        <%--筛选： <input type="checkbox">DOC&nbsp;<input type="checkbox">PPT--%>
                                        <%--&nbsp;<input--%>
                                        <%--type="checkbox">TXT&nbsp;<input type="checkbox">PDF&nbsp;<input--%>
                                        <%--type="checkbox">XLS--%>
                                    </div>
                                    <div class="col-md-3">
                                        <%--<input id="cb_precise_query" type="checkbox">只显示精确匹配结果--%>
                                    </div>
                                    <div class="col-md-3">
                                        <div id="totalHits" class="text-right"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="box-tools pull-right">
                            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                            </button>
                        </div>
                        <!-- /.box-tools -->
                    </div>
                    <div class="box-body table-responsive">
                        <table id="searchResultList" class="table table-bordered table-hover">
                        </table>
                    </div>
                    <!-- /.box-body -->
                    <div class="box-footer clearfix">
                        <ul id="pagination1" class="pagination no-margin pull-right"></ul>
                    </div>
                </div>
                <!-- /.box -->

            </section>
            <!-- /.content -->
        </div>
        <!-- /.container -->
    </div>
    <!-- /.content-wrapper -->
    <%--<footer class="main-footer">--%>
    <%--<div class="container">--%>
    <%--<div class="pull-right hidden-xs">--%>
    <%--<b>Version</b> 1.0.0--%>
    <%--</div>--%>
    <%--<strong>Copyright &copy; 2014-2017 <a href="#">新野县公安局</a>.</strong> All rights--%>
    <%--reserved.--%>
    <%--</div>--%>
    <%--<!-- /.container -->--%>
    <%--</footer>--%>
</div>
<!-- ./wrapper -->

<%@ include file="/WEB-INF/views/admin/search/advancedsearchjs.jsp" %>

<%@ include file="/WEB-INF/views/admin/index/changepassword.jsp" %>
<%@ include file="/WEB-INF/views/admin/index/changepasswordjs.jsp" %>

</body>
</html>