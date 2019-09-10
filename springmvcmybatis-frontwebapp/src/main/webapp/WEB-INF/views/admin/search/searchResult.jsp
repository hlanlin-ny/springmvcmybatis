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
    <link rel="icon" href="${ctxPath}/resources/dist/img/favicon.ico" type="image/x-icon" />
    <link rel="shortcut icon" href="${ctxPath}/resources/dist/img/favicon.png" type="image/x-icon" />
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
            <%--<section class="content-header">--%>
            <%--<h1>--%>
            <%--Top Navigation--%>
            <%--<small>Example 2.0</small>--%>
            <%--</h1>--%>
            <%--<ol class="breadcrumb">--%>
            <%--<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>--%>
            <%--<li><a href="#">Layout</a></li>--%>
            <%--<li class="active">Top Navigation</li>--%>
            <%--</ol>--%>
            <%--</section>--%>

            <!-- Main content -->
            <section class="content">

                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <ul class="nav nav-tabs">
                                <li id="li_tab_1" class="active"><a href="#tab_1" data-toggle="tab">全部</a></li>
                                <li id="li_tab_2"><a href="#tab_2" data-toggle="tab">标准化数据</a></li>
                                <li id="li_tab_3"><a href="#tab_3" data-toggle="tab">文件数据</a></li>
                            </ul>
                            <div class="tab-content">
                                <div class="tab-pane active" id="tab_1">
                                    <form id="dataSearchForm" name="dataSearchForm">
                                        <div class="row">
                                            <div class="col-md-12">&nbsp;
                                                <input type="hidden" id="datasourceType" name="datasourceType"
                                                       value="1"/>
                                                <%--<input type="hidden" class="form-control" id="userId" name="userId"--%>
                                                <%--value="<myshiro:currentId/>">--%>
                                                <%--<input type="hidden" class="form-control" id="areaId" name="areaId"--%>
                                                <%--value="<myshiro:currentAreaId/>">--%>
                                                <input type="hidden" class="form-control" id="pageIndex"
                                                       name="pageIndex" value="1">
                                                <input type="hidden" class="form-control" id="pageSize"
                                                       name="pageSize" value="10">
                                                <%--<input type="hidden" class="form-control"--%>
                                                       <%--id="intelligenceBusinessTypeId"--%>
                                                       <%--name="intelligenceBusinessTypeId">--%>
                                                <%--<input type="hidden" class="form-control" id="fileType" name="fileType">--%>
                                                <input type="hidden" class="form-control" id="preciseQuery" name="preciseQuery" value="false">
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="input-group">
                                            <span class="input-group-addon"><i
                                                    class="glyphicon glyphicon-search"></i></span>
                                                    <input id="keyword" name="keyword" autocomplete="off" data-provide="typeahead" type="text" class="form-control" placeholder="请输入要查询的关键字"
                                                           maxlength="250" required>
                                                    <span class="input-group-btn">
                                                        <button id="btn-submit-search" type="submit"
                                                                                          class="btn btn-primary btn-flat">
                                                        搜索一下
                                                       </button>
                                                    </span>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                    <div class="row">
                                        <div class="col-md-12">&nbsp;
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <ul class="list-inline" id="search-history-ul"></ul>
                                        </div>
                                    </div>

                                </div>
                                <!-- /.tab-pane -->
                                <%--<div class="tab-pane" id="tab_2"></div>--%>
                                <!-- /.tab-pane -->
                            </div>
                            <!-- /.tab-content -->
                        </div>
                        <!-- nav-tabs-custom -->
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-10">
                        <div class="box">
                            <div class="box-header">
                                <h4 class="box-title">搜索结果</h4>

                                <div class="box-tools">
                                    <div class="input-group input-group-sm"
                                         style="width: 780px; margin-top: 5px;">

                                        <div class="row">
                                            <div class="col-md-4">
                                                <input id="cb_precise_query" type="checkbox">只显示精确匹配结果
                                            </div>
                                            <div class="col-md-4">
                                                <div id="totalHits" class="text-right"></div>
                                            </div>

                                            <div class="col-md-4">
                                                <div id="div-export">
                                                    <div class="btn-group pull-right">
                                                        <button type="button" class="btn btn-default btn-flat btn-sm" id="btn-searchresult-list"><i class="fa fa-list"></i></button>
                                                        <button type="button" class="btn btn-default btn-flat btn-sm" id="btn-searchresult-timeline"><i class="fa fa-clock-o"></i></button>
                                                        <button id="btn-export" type="button" class="btn btn-default btn-sm btn-flat">
                                                            <i class="fa fa-cloud-download"></i> 导出搜索结果
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- /.box-header -->
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
                    </div>
                    <div class="col-md-2">
                        <div class="box">
                            <div class="box-header">
                                <h4 class="box-title">相关搜索</h4>
                            </div>
                            <!-- /.box-header -->
                            <div class="box-body">
                                <ul class="list-unstyled" id="related-search-history-ul">
                                </ul>
                            </div>
                            <!-- /.box-body -->
                        </div>
                    </div>
                </div>

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
<%@ include file="/WEB-INF/views/admin/search/searchresultjs.jsp" %>

<%@ include file="/WEB-INF/views/admin/index/changepassword.jsp" %>
<%@ include file="/WEB-INF/views/admin/index/changepasswordjs.jsp" %>

</body>
</html>