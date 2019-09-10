<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/listtop.jsp" %>

<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        情报数据统计
        <small></small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="${ctxPath}/admin/main.html"><i class="fa fa-home"></i> 首页</a></li>
        <li class="active">情报数据统计</li>
        <li class="active"> 情报数据统计</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">

    <div class="row">
        <div class="col-md-12">
           <shiro:hasPermission name="updatingfilecount:search">
                <!-- form start -->
                <form id="query-form" class="form-horizontal">
                    <div class="box">
                        <div class="box-header with-border">
                            <h3 class="box-title">查询条件</h3>
                        </div>
                        <div class="box-body">
                            <div class="form-group">
                                <label for="extra-search-businessTypeId" class="col-sm-2 control-label">情报业务类型</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-businessTypeName" name="extra-search-businessTypeName" placeholder="情报业务类型。请点击这里进行选择"  style="cursor:pointer;" readonly="readonly">
                                    <input type="hidden" class="form-control" id="extra-search-businessTypeId" name="extra-search-businessTypeId">
                                </div>

                            </div>
                            <div class="pull-right">
                                <button id="btn-search" type="submit" class="btn btn-primary"><i class="fa fa-search"></i> 查 询
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

                        <shiro:hasPermission name="updatingfilecount:refersh">
                            <button id="btn-refresh" type="button" class="btn btn-default">
                                <i class="fa fa-refresh"></i> 刷 新
                            </button>
                            <button id="btn-queryTotal" type="button" class="btn btn-default">
                                <i class="fa fa-search"></i> 总量查询
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="updatingfilecount:export">
                            <%@ include file="/WEB-INF/views/admin/common/tableexport.jsp" %>
                        </shiro:hasPermission>
                    </div>
                </div>
                <div class="box-body no-padding">
                    <table id="data-table" class="table table-hover table-striped">
                        <thead>
                            <tr>
                                <th>序号</th>
                                <th>数据类型</th>
                                <th>数据量</th>
                                <%--<myshiro:hasAnyPermission permissions="updatingfilecount:refersh,updatingfilecount:refersh">
                                    <th>操作</th>
                                </myshiro:hasAnyPermission>--%>
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
<%@ include file="/WEB-INF/views/admin/updatingfilecount/edit.jsp" %>
<%@ include file="/WEB-INF/views/admin/updatingfilecount/tree.jsp" %>
<%@ include file="/WEB-INF/views/admin/common/operateconfirmmodal.jsp" %>

<!-- js -->
<%@ include file="/WEB-INF/views/admin/updatingfilecount/listjs.jsp" %>
<%@ include file="/WEB-INF/views/admin/common/tableexportjs.jsp" %>

<%@ include file="/WEB-INF/views/admin/common/listbottom.jsp" %>