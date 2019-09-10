<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/listtop.jsp" %>

<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        系统日志
        <small></small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="${ctxPath}/admin/index/main.html"><i class="fa fa-home"></i> 首页</a></li>
        <li class="active">系统管理</li>
        <li class="active">系统日志</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">

    <div class="row">
        <div class="col-md-12">
            <shiro:hasPermission name="syslog:search">
                <!-- form start -->
                <form id="query-form" class="form-horizontal">
                    <div class="box">
                        <div class="box-header with-border">
                            <h3 class="box-title">查询条件</h3>
                        </div>
                        <div class="box-body">
                            <div class="form-group">
                                <label for="extra-search-username" class="col-sm-2 control-label">用户名</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-username"
                                           name="extra-search-username" placeholder="用户名">
                                </div>

                                <label for="extra-search-userRealName" class="col-sm-2 control-label">姓名</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-userRealName"
                                           name="extra-search-userRealName" placeholder="姓名">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="extra-search-opertionClassName" class="col-sm-2 control-label">类名</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-opertionClassName"
                                           name="extra-search-opertionClassName" placeholder="类名">
                                </div>

                                <label for="extra-search-opertionMethodName" class="col-sm-2 control-label">方法名</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-opertionMethodName"
                                           name="extra-search-opertionMethodName" placeholder="方法名">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="extra-search-opertionParamValue" class="col-sm-2 control-label">参数值</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="extra-search-opertionParamValue"
                                           name="extra-search-opertionParamValue" placeholder="参数值">
                                </div>
                            </div>
                            <div class="pull-right">
                                <button id="btn-search" type="submit" class="btn btn-primary"><i
                                        class="fa fa-search"></i> 查 询
                                </button>
                                <button id="btn-reset" type="reset" class="btn btn-default"><i class="fa fa-undo"></i>
                                    重 置
                                </button>
                            </div>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </form>
            </shiro:hasPermission>
        </div>
    </div>


    <div class="row">
        <div class="col-md-12">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">数据列表</h3>

                    <div class="box-tools">
                        <shiro:hasPermission name="syslog:refersh">
                            <button id="btn-refresh" type="button" class="btn btn-default">
                                <i class="fa fa-refresh"></i> 刷 新
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="syslog:export">
                            <%@ include file="/WEB-INF/views/admin/common/tableexport.jsp" %>
                        </shiro:hasPermission>
                    </div>
                </div>
                <div class="box-body no-padding">
                    <table id="data-table" class="table table-hover table-striped">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>编号</th>
                            <th>用户名</th>
                            <th>姓名</th>
                            <th>类名</th>
                            <th>方法名</th>
                            <th>参数值</th>
                            <th>IP</th>
                            <th>时间</th>
                        </tr>
                        </thead>
                        <tbody></tbody>
                        <tfoot></tfoot>
                    </table>
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->
        </div>
    </div>

</section>
<!-- /.content -->

<!-- js -->
<%@ include file="/WEB-INF/views/admin/syslog/js.jsp" %>
<%@ include file="/WEB-INF/views/admin/common/tableexportjs.jsp" %>

<%@ include file="/WEB-INF/views/admin/common/listbottom.jsp" %>