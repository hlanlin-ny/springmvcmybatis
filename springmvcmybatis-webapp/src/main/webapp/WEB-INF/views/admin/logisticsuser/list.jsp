<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/listtop.jsp" %>

<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        物流网点管理
        <small></small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="${ctxPath}/admin/index/main.html"><i class="fa fa-home"></i> 首页</a></li>
        <li class="active">物流情报管理</li>
        <li class="active"> 物流网点管理</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">


    <div class="row">
        <div class="col-md-12">
            <shiro:hasPermission name="logisticsuser:search">
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

                                <%--<div class="form-group">--%>
                                <%--<label for="extra-search-areaId" class="col-sm-2 control-label">行政区划编号</label>--%>

                                <%--<div class="col-sm-10">--%>
                            <input type="hidden" class="form-control" id="extra-search-areaId"
                                   name="extra-search-areaId" value="<myshiro:currentAreaId/>">
                                <%--</div>--%>
                                <%--</div>--%>
                            <div class="form-group">
                                <label for="extra-search-companyId" class="col-sm-2 control-label">所属公司</label>

                                <div class="col-sm-4">
                                    <select class="form-control select2" id="extra-search-companyId"
                                            name="extra-search-companyId" style="width: 100%;"></select>
                                </div>

                                <label for="extra-search-branchName" class="col-sm-2 control-label">网点名称</label>

                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-branchName"
                                           name="extra-search-branchName" placeholder="网点名称"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="extra-search-address" class="col-sm-2 control-label">网点地址</label>

                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-address"
                                           name="extra-search-address" placeholder="网点地址"/>
                                </div>

                                <label for="extra-search-disabled" class="col-sm-2 control-label">状态</label>
                                <div class="col-sm-4">
                                    <select class="form-control" id="extra-search-disabled" name='extra-search-disabled'>
                                        <option value="">全部</option>
                                        <option value="false">正常</option>
                                        <option value="true">禁用</option>
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
                        <shiro:hasPermission name="logisticsuser:add">
                            <button id="btn-add" type="button" class="btn btn-primary">
                                <i class="glyphicon glyphicon-plus"></i> 添 加
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="logisticsuser:batchdelete">
                            <button id="btn-delAll" type="button" class="btn btn-default">
                                <i class="glyphicon glyphicon-trash"></i> 批量删除
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="logisticsuser:refersh">
                            <button id="btn-refresh" type="button" class="btn btn-default">
                                <i class="fa fa-refresh"></i> 刷 新
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="logisticsuser:export">
                            <%@ include file="/WEB-INF/views/admin/common/tableexport.jsp" %>
                        </shiro:hasPermission>
                    </div>
                </div>
                <div class="box-body no-padding">
                    <table id="data-table" class="table table-hover table-striped">
                        <thead>
                        <tr>
                            <shiro:hasPermission name="logisticsuser:batchdelete">
                                <th><input type="checkbox" id="checkAll"></th>
                            </shiro:hasPermission>
                            <th>序号</th>
                            <th>编号</th>
                            <th>所属公司</th>
                            <th>网点名称</th>
                            <th>网点地址</th>
                            <th>所属公安机关</th>
                            <th>用户名</th>
                            <%--<th>密钥</th>--%>
                            <th>联系人</th>
                            <th>联系电话</th>
                            <th>紧急联系人</th>
                            <th>紧急联系电话</th>
                            <th>状态</th>
                            <th>备注</th>
                            <myshiro:hasAnyPermission permissions="logisticsuser:edit,logisticsuser:delete">
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
<%@ include file="/WEB-INF/views/admin/logisticsuser/edit.jsp" %>
<%@ include file="/WEB-INF/views/admin/common/operateconfirmmodal.jsp" %>

<!-- js -->
<%@ include file="/WEB-INF/views/admin/logisticsuser/listjs.jsp" %>
<%@ include file="/WEB-INF/views/admin/common/tableexportjs.jsp" %>

<%@ include file="/WEB-INF/views/admin/common/listbottom.jsp" %>