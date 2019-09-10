<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/listtop.jsp" %>

<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        参数管理
        <small></small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="${ctxPath}/admin/index/main.html"><i class="fa fa-home"></i> 首页</a></li>
        <li class="active">代码生成器</li>
        <li class="active">参数管理</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">


    <div class="row">
        <div class="col-md-12">
            <shiro:hasPermission name="syscodegenerator:search">
                <!-- form start -->
                <form id="query-form" class="form-horizontal">
                    <div class="box">
                        <div class="box-header with-border">
                            <h3 class="box-title">查询条件</h3>
                        </div>
                        <div class="box-body">
                            <div class="form-group">
                                <label for="extra-search-tableName" class="col-sm-2 control-label">表名</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="extra-search-tableName"
                                           name="extra-search-tableName" placeholder="表名">
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

                        <shiro:hasPermission name="syscodegenerator:refersh">
                            <button id="btn-refresh" type="button" class="btn btn-default">
                                <i class="fa fa-refresh"></i> 刷 新
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="syscodegenerator:generatorCode">
                            <button id="btn-generator" type="button" class="btn btn-primary">
                                <i class="fa fa-code"></i> 生成代码
                            </button>
                        </shiro:hasPermission>
                    </div>
                </div>
                <div class="box-body no-padding">
                    <table id="data-table" class="table table-hover table-striped">
                        <thead>
                        <tr>
                            <shiro:hasPermission name="syscodegenerator:generatorCode">
                                <th><input type="checkbox" id="checkAll"></th>
                            </shiro:hasPermission>
                            <th>序号</th>
                            <th>表名</th>
                            <th>Engine</th>
                            <th>表备注</th>
                            <th>创建时间</th>
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
<%@ include file="/WEB-INF/views/admin/syscodegenerator/js.jsp" %>

<%@ include file="/WEB-INF/views/admin/common/listbottom.jsp" %>