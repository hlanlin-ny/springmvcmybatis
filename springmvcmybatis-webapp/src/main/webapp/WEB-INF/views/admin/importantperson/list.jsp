<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/listtop.jsp" %>

<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        重点人员信息表
        <small></small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="${ctxPath}/admin/index/main.html"><i class="fa fa-home"></i> 首页</a></li>
        <li class="active">系统管理</li>
        <li class="active"> 重点人员信息表</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">

    <div class="row">
        <div class="col-md-12">
            <shiro:hasPermission name="importantperson:search">
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
                        <div class="box-body" >
                            <div class="form-group">
                                <label for="extra-search-name" class="col-sm-2 control-label">重点人员姓名</label>

                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-name"
                                           name="extra-search-name" placeholder="重点人员姓名"/>
                                </div>
                                <label for="extra-search-idCardNo" class="col-sm-2 control-label">身份证号码</label>

                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-idCardNo"
                                           name="extra-search-idCardNo" placeholder="身份证号码"/>
                                </div>

                            </div>
                            <div class="form-group">

                                <label for="extra-search-controlName"
                                       class="col-sm-2 control-label">布控人员姓名</label>

                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-controlName"
                                           name="extra-search-controlName" placeholder="布控人员姓名"/>
                                </div>

                                <label for="extra-search-controlUnit"
                                       class="col-sm-2 control-label">布控单位</label>

                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-controlUnit"
                                           name="extra-search-controlUnit" placeholder="布控单位"/>
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
                        <shiro:hasPermission name="importantperson:batchadd">
                            <button id="btn-batchadd" type="button" class="btn btn-primary">
                                <i class="fa fa-sign-in"></i> 导入
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="importantperson:add">
                            <button id="btn-add" type="button" class="btn btn-primary">
                                <i class="glyphicon glyphicon-plus"></i> 添 加
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="importantperson:batchdelete">
                            <button id="btn-delAll" type="button" class="btn btn-default">
                                <i class="glyphicon glyphicon-trash"></i> 批量删除
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="importantperson:refersh">
                            <button id="btn-refresh" type="button" class="btn btn-default">
                                <i class="fa fa-refresh"></i> 刷 新
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="importantperson:export">
                            <button type="button" class="btn btn-default" id="btn-export-excel">
                                <i class="fa fa-sign-out"></i> 导出
                            </button>
                        </shiro:hasPermission>
                    </div>
                </div>
                <div class="box-body no-padding">
                    <table id="data-table" class="table table-hover table-striped">
                        <thead>
                        <tr>
                            <shiro:hasPermission name="importantperson:batchdelete">
                                <th><input type="checkbox" id="checkAll"></th>
                            </shiro:hasPermission>
                            <%--<th>序号</th>--%>
                            <th>编号</th>
                            <th>姓名</th>
                            <th>身份证号码</th>
                            <th>性别</th>
                            <th>民族</th>
                            <th>出生日期</th>
                            <th>户籍地址</th>
                            <th>人员类别</th>
                            <th>布控人员姓名</th>
                            <th>布控人员单位</th>
                            <th>布控单位</th>
                            <th>布控人员联系方式</th>
                            <myshiro:hasAnyPermission permissions="importantperson:control,importantperson:reply">
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
<%@ include file="/WEB-INF/views/admin/importantperson/importExcel.jsp" %>
<%@ include file="/WEB-INF/views/admin/importantperson/edit.jsp" %>
<%@ include file="/WEB-INF/views/admin/common/operateconfirmmodal.jsp" %>

<!-- js -->
<%@ include file="/WEB-INF/views/admin/importantperson/listjs.jsp" %>
<%@ include file="/WEB-INF/views/admin/common/tableexportjs.jsp" %>

<%@ include file="/WEB-INF/views/admin/common/listbottom.jsp" %>