<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/listtop.jsp" %>

<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        医疗门诊记录管理
        <small></small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="${ctxPath}/admin/index/main.html"><i class="fa fa-home"></i> 首页</a></li>
        <li class="active">系统管理</li>
        <li class="active"> 医疗门诊记录管理</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">


    <div class="row">
        <div class="col-md-12">
            <shiro:hasPermission name="medicaloutpatientrecord:search">
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
                                <label for="extra-search-diagnoseDatetime" class="col-sm-2 control-label">门诊时间</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-diagnoseDatetime" name="extra-search-diagnoseDatetime"  placeholder="体检时间">
                                    <input type="hidden" class="form-control" id="extra-search-diagnoseDatetimeBegin"
                                           name="extra-search-diagnoseDatetimeBegin">
                                    <input type="hidden" class="form-control" id="extra-search-diagnoseDatetimeEnd"
                                           name="extra-search-diagnoseDatetimeEnd">
                                </div>
                                <label for="extra-search-diagnoseNo" class="col-sm-2 control-label">门诊号</label>

                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-diagnoseNo"
                                           name="extra-search-diagnoseNo" placeholder="门诊号"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="extra-search-medicareCardNo" class="col-sm-2 control-label">医保证号</label>

                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-medicareCardNo"
                                           name="extra-search-medicareCardNo"
                                           placeholder="医保证号" title="含城镇医保、农村医保、费医保病人填就诊卡卡号（自费人员、外地人员)"/>
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
                        <shiro:hasPermission name="medicaloutpatientrecord:add">
                            <button id="btn-add" type="button" class="btn btn-primary">
                                <i class="glyphicon glyphicon-plus"></i> 添 加
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="medicaloutpatientrecord:batchdelete">
                            <button id="btn-delAll" type="button" class="btn btn-default">
                                <i class="glyphicon glyphicon-trash"></i> 批量删除
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="medicaloutpatientrecord:refersh">
                            <button id="btn-refresh" type="button" class="btn btn-default">
                                <i class="fa fa-refresh"></i> 刷 新
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="medicaloutpatientrecord:export">
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
                            <shiro:hasPermission name="medicaloutpatientrecord:batchdelete">
                                <th><input type="checkbox" id="checkAll"></th>
                            </shiro:hasPermission>
                            <th>编号</th>
                            <th>姓名</th>
                            <th>性别</th>
                            <th>年龄</th>
                            <th>身份证号码</th>
                            <th>联系电话</th>
                            <th>门诊时间</th>
                            <th>门诊号</th>
                            <th>人员费用类别</th>
                            <th>费用金额</th>
                            <myshiro:hasAnyPermission
                                    permissions="medicaloutpatientrecord:detail">
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
<%@ include file="/WEB-INF/views/admin/medicaloutpatientrecord/listjs.jsp" %>
<%@ include file="/WEB-INF/views/admin/common/tableexportjs.jsp" %>

<%@ include file="/WEB-INF/views/admin/common/listbottom.jsp" %>