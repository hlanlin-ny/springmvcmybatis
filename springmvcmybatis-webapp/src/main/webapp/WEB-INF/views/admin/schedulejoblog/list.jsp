<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/listtop.jsp" %>

<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        定时任务日志
        <small></small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="${ctxPath}/admin/index/main.html"><i class="fa fa-home"></i> 首页</a></li>
        <li class="active">系统管理</li>
        <li class="active">定时任务日志</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">

    <div class="row">
        <div class="col-md-12">
            <shiro:hasPermission name="schedulejoblog:search">
                <!-- form start -->
                <form id="query-form" class="form-horizontal">
                    <div class="box">
                        <div class="box-header with-border">
                            <h3 class="box-title">查询条件</h3>
                        </div>
                        <div class="box-body">
                            <div class="form-group">
                                <label for="extra-search-beanName" class="col-sm-2 control-label">类名</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-beanName"
                                           name="extra-search-beanName" placeholder="类名">
                                </div>

                                <label for="extra-search-methodName" class="col-sm-2 control-label">方法名</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-methodName"
                                           name="extra-search-methodName" placeholder="方法名">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="extra-search-params" class="col-sm-2 control-label">参数值</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-params"
                                           name="extra-search-params" placeholder="参数值">
                                </div>

                                <label for="extra-search-type" class="col-sm-2 control-label">状态</label>
                                <div class="col-sm-4">
                                    <select class="form-control" id="extra-search-type" name='extra-search-type'>
                                        <option value="">全部</option>
                                        <option value="1">成功</option>
                                        <option value="2">失败</option>
                                    </select>
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
                        <shiro:hasPermission name="schedulejoblog:refersh">
                            <button id="btn-refresh" type="button" class="btn btn-default">
                                <i class="fa fa-refresh"></i> 刷 新
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="schedulejoblog:export">
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
                            <th>类名</th>
                            <th>方法名</th>
                            <th>参数值</th>
                            <th>状态</th>
                            <th>信息</th>
                            <th>耗时（ms）</th>
                            <th>执行人</th>
                            <th>执行IP</th>
                            <th>执行时间</th>
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
<%@ include file="/WEB-INF/views/admin/schedulejoblog/js.jsp" %>
<%@ include file="/WEB-INF/views/admin/common/tableexportjs.jsp" %>

<%@ include file="/WEB-INF/views/admin/common/listbottom.jsp" %>