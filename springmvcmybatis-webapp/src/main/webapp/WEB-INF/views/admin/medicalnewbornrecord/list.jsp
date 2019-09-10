<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/listtop.jsp" %>

<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        新生儿出生信息
        <small></small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="${ctxPath}/admin/index/main.html"><i class="fa fa-home"></i> 首页</a></li>
        <li class="active">系统管理</li>
        <li class="active"> 新生儿出生信息</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">


    <div class="row">
        <div class="col-md-12">
            <shiro:hasPermission name="medicalnewbornrecord:search">
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
                                <label for="extra-search-bornTime" class="col-sm-2 control-label">出生日期</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-bornTime"
                                           name="extra-search-bornTime" placeholder="出生日期"/>
                                    <input type="hidden" class="form-control" id="extra-search-bornDateBegin"
                                           name="extra-search-bornDateBegin">
                                    <input type="hidden" class="form-control" id="extra-search-bornDateEnd"
                                           name="extra-search-bornDateEnd">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="extra-search-idCardNum" class="col-sm-2 control-label">身份证号码</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-idCardNum"
                                           name="extra-search-idCardNum" placeholder="身份证号码"/>
                                </div>
                                <label for="extra-search-motherName" class="col-sm-2 control-label">母亲姓名</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-motherName"
                                           name="extra-search-motherName" placeholder="母亲姓名"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="extra-search-fatherName" class="col-sm-2 control-label">父亲姓名</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-fatherName"
                                           name="extra-search-fatherName" placeholder="父亲姓名"/>
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
                        <shiro:hasPermission name="medicalnewbornrecord:add">
                            <button id="btn-add" type="button" class="btn btn-primary">
                                <i class="glyphicon glyphicon-plus"></i> 添 加
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="medicalnewbornrecord:batchdelete">
                            <button id="btn-delAll" type="button" class="btn btn-default">
                                <i class="glyphicon glyphicon-trash"></i> 批量删除
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="medicalnewbornrecord:refersh">
                            <button id="btn-refresh" type="button" class="btn btn-default">
                                <i class="fa fa-refresh"></i> 刷 新
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="medicalnewbornrecord:export">
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
                            <shiro:hasPermission name="medicalnewbornrecord:batchdelete">
                                <th><input type="checkbox" id="checkAll"></th>
                            </shiro:hasPermission>
                            <th>编号</th>
                            <th>姓名</th>
                            <th>性别</th>
                            <th>出生日期</th>
                            <th>身份证号码</th>
                            <th>母亲姓名</th>
                            <th>父亲姓名</th>
                            <th>登记时间</th>
                            <myshiro:hasAnyPermission
                                    permissions="medicalnewbornrecord:detail">
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
<%@ include file="/WEB-INF/views/admin/medicalnewbornrecord/edit.jsp" %>
<%@ include file="/WEB-INF/views/admin/common/operateconfirmmodal.jsp" %>

<!-- js -->
<%@ include file="/WEB-INF/views/admin/medicalnewbornrecord/listjs.jsp" %>
<%@ include file="/WEB-INF/views/admin/common/tableexportjs.jsp" %>

<%@ include file="/WEB-INF/views/admin/common/listbottom.jsp" %>