<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/listtop.jsp" %>

<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        临时布控申请单
        <small></small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="${ctxPath}/admin/index/main.html"><i class="fa fa-home"></i> 首页</a></li>
        <li class="active">实时预警</li>
        <li class="active"> 临时布控申请单</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">


    <div class="row">
        <div class="col-md-12">
            <shiro:hasPermission name="controlapplyapplication:search">
                <!-- form start -->
                <form id="query-form" class="form-horizontal">
                    <div class="box">
                        <div class="box-header with-border">
                            <h3 class="box-title">查询条件</h3>
                        </div>
                        <div class="box-body">

                            <div class="form-group">
                                <label for="extra-search-controlByName" class="col-sm-2 control-label">被布控人姓名</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-controlByName"
                                           name="extra-search-controlByName" placeholder="被布控人姓名"/>
                                </div>
                                <label for="extra-search-controlMeasureRequire"
                                       class="col-sm-2 control-label">布控措施要求</label>

                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-controlMeasureRequire"
                                           name="extra-search-controlMeasureRequire" placeholder="布控措施要求"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="extra-search-controlTime" class="col-sm-2 control-label">布控时间</label>

                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-controlTime"
                                           name="extra-search-controlTime" placeholder="布控时间"/>
                                    <input type="hidden" class="form-control" id="extra-search-controlBeginTime"
                                           name="extra-search-controlBeginTime">
                                    <input type="hidden" class="form-control" id="extra-search-controlEndTime"
                                           name="extra-search-controlEndTime">
                                </div>
                                <label for="extra-search-applyName" class="col-sm-2 control-label">申请人</label>

                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-applyName"
                                           name="extra-search-applyName" placeholder="申请人姓名"/>
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
                        <shiro:hasPermission name="controlapplyapplication:add">
                            <button id="btn-add" type="button" class="btn btn-primary">
                                <i class="glyphicon glyphicon-plus"></i> 添 加
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="controlapplyapplication:batchdelete">
                            <button id="btn-delAll" type="button" class="btn btn-default">
                                <i class="glyphicon glyphicon-trash"></i> 批量删除
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="controlapplyapplication:refersh">
                            <button id="btn-refresh" type="button" class="btn btn-default">
                                <i class="fa fa-refresh"></i> 刷 新
                            </button>
                        </shiro:hasPermission>
                    </div>
                </div>
                <div class="box-body no-padding">
                    <table id="data-table" class="table table-hover table-striped">
                        <thead>
                        <tr>
                            <shiro:hasPermission name="controlapplyapplication:batchdelete">
                                <th><input type="checkbox" id="checkAll"></th>
                            </shiro:hasPermission>
                            <th>编号</th>
                            <th>被布控人姓名</th>
                            <th>性别</th>
                            <th>出生日期</th>
                            <th>证件号码</th>
                            <th>地址</th>
                            <th>布控事由</th>
                            <th>布控单位</th>
                            <th>申请人</th>
                            <th>申请单位</th>
                            <th>预警状态</th>
                            <myshiro:hasAnyPermission
                                    permissions="controlapplyapplication:detail,controlapplyapplication:delete">
                                <th>操作</th>
                            </myshiro:hasAnyPermission>
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
<%@ include file="/WEB-INF/views/admin/controlapplyapplication/edit.jsp" %>
<%@ include file="/WEB-INF/views/admin/controlapplyapplication/detail.jsp" %>
<%@ include file="/WEB-INF/views/admin/common/operateconfirmmodal.jsp" %>

<!-- js -->
<%@ include file="/WEB-INF/views/admin/controlapplyapplication/listjs.jsp" %>
<%@ include file="/WEB-INF/views/admin/common/tableexportjs.jsp" %>

<%@ include file="/WEB-INF/views/admin/common/listbottom.jsp" %>