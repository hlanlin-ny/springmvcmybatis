<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/listtop.jsp" %>

<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        用户管理
        <small></small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="${ctxPath}/admin/index/main.html"><i class="fa fa-home"></i> 首页</a></li>
        <li class="active">权限管理</li>
        <li class="active">用户管理</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">

    <div class="row">
        <div class="col-md-12">
            <shiro:hasPermission name="sysuser:search">
            <!-- form start -->
            <form id="query-form" class="form-horizontal">
                <div class="box">
                    <div class="box-header with-border">
                        <h3 class="box-title">查询条件</h3>
                    </div>
                    <div class="box-body">
                        <div class="form-group">
                            <label for="extra-search-userDepartmentName" class="col-sm-2 control-label">行政区划</label>

                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="extra-search-userDepartmentName"
                                       name="extra-search-userDepartmentName" placeholder="行政区划">
                            </div>
                            <label for="extra-search-userRoleNames" class="col-sm-2 control-label">角色</label>

                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="extra-search-userRoleNames"
                                       name="extra-search-userRoleNames" placeholder="角色">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="extra-search-name" class="col-sm-2 control-label">姓名</label>

                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="extra-search-name"
                                       name="extra-search-name" placeholder="用户名">
                            </div>

                            <label for="extra-search-username" class="col-sm-2 control-label">用户名</label>

                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="extra-search-username"
                                       name="extra-search-username" placeholder="用户名">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="extra-search-mobile" class="col-sm-2 control-label">手机</label>

                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="extra-search-mobile"
                                       name="extra-search-mobile" placeholder="手机">
                            </div>

                            <label for="extra-search-email" class="col-sm-2 control-label">邮箱</label>

                            <div class="col-sm-4">
                                <input type="email" class="form-control" id="extra-search-email"
                                       name="extra-search-email" placeholder="邮箱">
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
                        <shiro:hasPermission name="sysuser:add">
                            <button id="btn-add" type="button" class="btn btn-primary">
                                <i class="glyphicon glyphicon-plus"></i> 添 加
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="sysuser:batchdelete">
                            <button id="btn-delAll" type="button" class="btn btn-default">
                                <i class="glyphicon glyphicon-trash"></i> 批量删除
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="sysuser:refersh">
                            <button id="btn-refresh" type="button" class="btn btn-default">
                                <i class="fa fa-refresh"></i> 刷 新
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="sysuser:export">
                            <%@ include file="/WEB-INF/views/admin/common/tableexport.jsp" %>
                        </shiro:hasPermission>
                    </div>
                </div>
                <div class="box-body no-padding">
                    <table id="data-table" class="table table-hover table-striped">
                        <thead>
                        <tr>
                            <shiro:hasPermission name="sysuser:batchdelete">
                                <th><input type="checkbox" id="checkAll"></th>
                            </shiro:hasPermission>
                            <th>序号</th>
                            <th>编号</th>
                            <th>姓名</th>
                            <th>用户名</th>
                            <th>管理员</th>
                            <th>行政区划</th>
                            <th>角色</th>
                            <th>手机</th>
                            <th>邮箱</th>
                            <th>激活</th>
                            <th>锁定</th>
                            <th>禁用</th>
                            <%--<th>创建时间</th>--%>
                            <%--<th>创建人</th>--%>
                            <%--<th>创建人IP</th>--%>
                            <%--<th>修改时间</th>--%>
                            <%--<th>修改人</th>--%>
                            <%--<th>修改人IP</th>--%>
                            <th>备注</th>
                            <myshiro:hasAnyPermission permissions="sysuser:edit,sysuser:delete">
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
<%@ include file="/WEB-INF/views/admin/sysuser/edit.jsp" %>
<%@ include file="/WEB-INF/views/admin/common/operateconfirmmodal.jsp" %>

<!-- js -->
<%@ include file="/WEB-INF/views/admin/sysuser/js.jsp" %>
<%@ include file="/WEB-INF/views/admin/common/tableexportjs.jsp" %>

<%@ include file="/WEB-INF/views/admin/common/listbottom.jsp" %>