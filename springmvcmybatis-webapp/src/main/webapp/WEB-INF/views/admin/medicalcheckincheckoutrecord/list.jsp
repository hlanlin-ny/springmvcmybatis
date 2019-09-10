<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/listtop.jsp" %>

<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        医疗住（出）院记录管理
        <small></small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="${ctxPath}/admin/index/main.html"><i class="fa fa-home"></i> 首页</a></li>
        <li class="active">系统管理</li>
        <li class="active"> 医疗住（出）院记录管理</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">


    <div class="row">
        <div class="col-md-12">
            <shiro:hasPermission name="medicalcheckincheckoutrecord:search">
                <!-- form start -->
                <form id="query-form" class="form-horizontal">
                    <div class="box">
                        <div class="box-header with-border">
                            <h3 class="box-title">查询条件</h3>
                            <div class="box-tools pull-right">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                </button>
                            </div>
                        </div>
                        <div class="box-body">

                            <div class="form-group">
                                <label for="extra-search-name" class="col-sm-2 control-label">姓名</label>

                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-name"
                                           name="extra-search-name" placeholder="姓名"/>
                                </div>
                                <label for="extra-search-idCardNum" class="col-sm-2 control-label">身份证号码</label>

                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-idCardNum"
                                           name="extra-search-idCardNum" placeholder="身份证号码"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="extra-search-hospitalizationNo" class="col-sm-2 control-label">住院号</label>

                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-hospitalizationNo"
                                           name="extra-search-hospitalizationNo" placeholder="住院号"/>
                                </div>
                                <label for="extra-search-hospitalizationDepartment"
                                       class="col-sm-2 control-label">住院科室</label>

                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-hospitalizationDepartment"
                                           name="extra-search-hospitalizationDepartment" placeholder="住院科室"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="extra-search-hospitalizationDatetime"
                                       class="col-sm-2 control-label">住院时间</label>

                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-hospitalizationDatetime"
                                           name="extra-search-hospitalizationDatetime" placeholder="住院时间"/>
                                    <input type="hidden" class="form-control" id="extra-search-hospitalizationDatetimeBegin"
                                           name="extra-search-hospitalizationDatetimeBegin">
                                    <input type="hidden" class="form-control" id="extra-search-hospitalizationDatetimeEnd"
                                           name="extra-search-hospitalizationDatetimeEnd">
                                </div>
                                <label for="extra-search-leavehospitalDatetime"
                                       class="col-sm-2 control-label">出院时间</label>

                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-leavehospitalDatetime"
                                           name="extra-search-leavehospitalDatetime" placeholder="出院时间"/>
                                    <input type="hidden" class="form-control" id="extra-search-leavehospitalDatetimeBegin"
                                           name="extra-search-leavehospitalDatetimeBegin">
                                    <input type="hidden" class="form-control" id="extra-search-leavehospitalDatetimeEnd"
                                           name="extra-search-leavehospitalDatetimeEnd">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="extra-search-userId" class="col-sm-2 control-label">上报网点</label>

                                <div class="col-sm-4">
                                    <select class="form-control select2" id="extra-search-userId"
                                            name="extra-search-userId" style="width: 100%;"></select>
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
                        <shiro:hasPermission name="medicalcheckincheckoutrecord:refersh">
                            <button id="btn-refresh" type="button" class="btn btn-default">
                                <i class="fa fa-refresh"></i> 刷 新
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="medicalcheckincheckoutrecord:export">
                            <button type="button" class="btn btn-default" id="btn-export-excel">
                                <i class="fa fa-sign-out"></i> 导出
                            </button>
                        </shiro:hasPermission>
                        <button type="button" class="btn btn-default" id="btn-update">
                            <i class="fa fa-sign-out"></i> 同步到总表
                        </button>
                    </div>
                </div>
                <div class="box-body no-padding">
                    <table id="data-table" class="table table-hover table-striped">
                        <thead>
                        <tr>
                            <shiro:hasPermission name="medicalcheckincheckoutrecord:batchdelete">
                                <th><input type="checkbox" id="checkAll"></th>
                            </shiro:hasPermission>
                            <th>编号</th>
                            <th>姓名</th>
                            <th>身份证号码</th>
                            <th>联系电话</th>
                            <th>职业</th>
                            <th>住院号</th>
                            <th>住院科室</th>
                            <th>住院时间</th>
                            <th>出院时间</th>
                            <myshiro:hasAnyPermission
                                    permissions="medicalcheckincheckoutrecord:detail">
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
<%@ include file="/WEB-INF/views/admin/common/operateconfirmmodal.jsp" %>

<!-- js -->
<%@ include file="/WEB-INF/views/admin/medicalcheckincheckoutrecord/listjs.jsp" %>
<%@ include file="/WEB-INF/views/admin/common/tableexportjs.jsp" %>

<%@ include file="/WEB-INF/views/admin/common/listbottom.jsp" %>