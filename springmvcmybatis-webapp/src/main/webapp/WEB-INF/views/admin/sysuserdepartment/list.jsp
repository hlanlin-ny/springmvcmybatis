<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/listtop.jsp" %>

<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        部门管理
        <small></small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="${ctxPath}/admin/index/main.html"><i class="fa fa-home"></i> 首页</a></li>
        <li class="active">权限管理</li>
        <li class="active">部门管理</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">

    <div class="row">
        <div class="col-md-12">
            <!-- form start -->
            <form id="query-form" class="form-horizontal">
                <shiro:hasPermission name="sysuserdepartment:search">
                    <div class="box">
                        <div class="box-header with-border">
                            <h3 class="box-title">查询条件</h3>
                        </div>
                        <div class="box-body">

                            <div class="form-group">
                                <label for="extra-search-name" class="col-sm-2 control-label">名称</label>

                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-name"
                                           name="extra-search-name" placeholder="名称">
                                </div>

                                <label for="extra-search-parentName" class="col-sm-2 control-label">上级部门</label>

                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-parentName"
                                           name="extra-search-parentName" placeholder="上级部门">
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
                </shiro:hasPermission>
            </form>
        </div>
    </div>


    <div class="row">
        <div class="col-md-12">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">数据列表</h3>

                    <div class="box-tools">
                        <shiro:hasPermission name="sysuserdepartment:add">
                            <button id="btn-add" type="button" class="btn btn-primary">
                                <i class="glyphicon glyphicon-plus"></i> 添 加
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="sysuserdepartment:batchdelete">
                            <button id="btn-delAll" type="button" class="btn btn-default">
                                <i class="glyphicon glyphicon-trash"></i> 批量删除
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="sysuserdepartment:refersh">
                            <button id="btn-refresh" type="button" class="btn btn-default">
                                <i class="fa fa-refresh"></i> 刷 新
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="sysuserdepartment:export">
                            <%@ include file="/WEB-INF/views/admin/common/tableexport.jsp" %>
                        </shiro:hasPermission>
                    </div>
                </div>
                <div class="box-body no-padding">
                    <table id="data-table" class="table table-hover table-striped">
                        <thead>
                        <tr>
                            <shiro:hasPermission name="sysuserdepartment:batchdelete">
                                <th><input type="checkbox" id="checkAll"></th>
                            </shiro:hasPermission>
                            <th>序号</th>
                            <th>编号</th>
                            <th>名称</th>
                            <th>上级部门</th>
                            <th>排序</th>
                            <th>备注</th>
                            <myshiro:hasAnyPermission permissions="sysuserdepartment:edit,sysuserdepartment:delete">
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
<%@ include file="/WEB-INF/views/admin/sysuserdepartment/edit.jsp" %>
<%@ include file="/WEB-INF/views/admin/sysuserdepartment/tree.jsp" %>
<%@ include file="/WEB-INF/views/admin/common/operateconfirmmodal.jsp" %>

<!-- js -->
<%@ include file="/WEB-INF/views/admin/sysuserdepartment/js.jsp" %>
<%@ include file="/WEB-INF/views/admin/common/tableexportjs.jsp" %>

<%@ include file="/WEB-INF/views/admin/common/listbottom.jsp" %>