<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/listtop.jsp" %>

<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        医保刷卡记录信息
        <small></small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="${ctxPath}/admin/index/main.html"><i class="fa fa-home"></i> 首页</a></li>
        <li class="active">系统管理</li>
        <li class="active"> 医保刷卡记录信息Z</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">


    <div class="row">
        <div class="col-md-12">
            <shiro:hasPermission name="medicalinsurancecardrecord:search">
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
                                <label for="extra-search-doctor" class="col-sm-2 control-label">医生姓名</label>

                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-doctor"
                                           name="extra-search-doctor" placeholder="医生姓名"/>
                                </div>
                                <label for="extra-search-hospitalizationNo" class="col-sm-2 control-label">住院号</label>

                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-hospitalizationNo"
                                           name="extra-search-hospitalizationNo" placeholder="住院号"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="extra-search-takeDatetime" class="col-sm-2 control-label">办理日期</label>

                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-takeDatetime"
                                           name="extra-search-takeDatetime" placeholder="办理日期"/>
                                    <input type="hidden" class="form-control" id="extra-search-takeDatetimeBegin"
                                           name="extra-search-takeDatetimeBegin">
                                    <input type="hidden" class="form-control" id="extra-search-takeDatetimeEnd"
                                           name="extra-search-takeDatetimeEnd">
                                </div>
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
                        <shiro:hasPermission name="medicalinsurancecardrecord:add">
                            <button id="btn-add" type="button" class="btn btn-primary">
                                <i class="glyphicon glyphicon-plus"></i> 添 加
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="medicalinsurancecardrecord:batchdelete">
                            <button id="btn-delAll" type="button" class="btn btn-default">
                                <i class="glyphicon glyphicon-trash"></i> 批量删除
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="medicalinsurancecardrecord:refersh">
                            <button id="btn-refresh" type="button" class="btn btn-default">
                                <i class="fa fa-refresh"></i> 刷 新
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="medicalinsurancecardrecord:export">
                            <%@ include file="/WEB-INF/views/admin/common/tableexport.jsp" %>
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
                            <shiro:hasPermission name="medicalinsurancecardrecord:batchdelete">
                                <th><input type="checkbox" id="checkAll"></th>
                            </shiro:hasPermission>
                            <th>编号</th>
                            <th>医疗类型</th>
                            <th>医疗类型代码</th>
                            <th>入院疾病</th>
                            <th>医生姓名</th>
                            <th>医疗费用金额</th>
                            <th>住院时间</th>
                            <th>出院时间</th>
                            <th>办理日期</th>
                            <th>经办人姓名</th>
                            <myshiro:hasAnyPermission
                                    permissions="medicalinsurancecardrecord:detail">
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
<%@ include file="/WEB-INF/views/admin/medicalinsurancecardrecord/edit.jsp" %>
<%@ include file="/WEB-INF/views/admin/common/operateconfirmmodal.jsp" %>

<!-- js -->
<%@ include file="/WEB-INF/views/admin/medicalinsurancecardrecord/listjs.jsp" %>
<%@ include file="/WEB-INF/views/admin/common/tableexportjs.jsp" %>

<%@ include file="/WEB-INF/views/admin/common/listbottom.jsp" %>