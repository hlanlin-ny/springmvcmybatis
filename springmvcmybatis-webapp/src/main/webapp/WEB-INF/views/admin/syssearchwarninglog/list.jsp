<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/listtop.jsp" %>

<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
       搜索结果日志
        <small></small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="${ctxPath}/admin/index/main.html"><i class="fa fa-home"></i> 首页</a></li>
        <li class="active">搜索预警</li>
        <li class="active"> 搜索结果日志</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">


    <div class="row">
        <div class="col-md-12">
           <shiro:hasPermission name="syssearchwarninglog:search">
                <!-- form start -->
                <form id="query-form" class="form-horizontal">
                    <div class="box">
                        <div class="box-header with-border">
                            <h3 class="box-title">查询条件</h3>
                        </div>
                        <div class="box-body">

                            <div class="form-group">
                                <label for="extra-search-keywords" class="col-sm-2 control-label">关键字</label>
                                <div class="col-sm-4">
                                  <input type="text" class="form-control" id="extra-search-keywords" name="extra-search-keywords" placeholder="关键字"/>
                                </div>
                                <label for="extra-search-recordCount" class="col-sm-2 control-label">记录条数</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-recordCount" name="extra-search-recordCount" placeholder="记录条数"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="extra-search-noticeToName" class="col-sm-2 control-label">通知人</label>
                                <div class="col-sm-4">
                                  <input type="text" class="form-control" id="extra-search-noticeToName" name="extra-search-noticeToName" placeholder="通知人"/>
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
                        <shiro:hasPermission name="syssearchwarninglog:add">
                            <button id="btn-add" type="button" class="btn btn-primary">
                                <i class="glyphicon glyphicon-plus"></i> 添 加
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="syssearchwarninglog:batchdelete">
                            <button id="btn-delAll" type="button" class="btn btn-default">
                                <i class="glyphicon glyphicon-trash"></i> 批量删除
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="syssearchwarninglog:refersh">
                            <button id="btn-refresh" type="button" class="btn btn-default">
                                <i class="fa fa-refresh"></i> 刷 新
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="syssearchwarninglog:export">
                            <%@ include file="/WEB-INF/views/admin/common/tableexport.jsp" %>
                        </shiro:hasPermission>
                    </div>
                </div>
                <div class="box-body no-padding">
                    <table id="data-table" class="table table-hover table-striped">
                        <thead>
                            <tr>
                                <shiro:hasPermission name="syssearchwarninglog:batchdelete">
                                    <th><input type="checkbox" id="checkAll"></th>
                                </shiro:hasPermission>
                                <th>序号</th>
                                <th>编号</th>
                                <th>关键字</th>
                                <th>记录条数</th>
                                <th>通知人</th>
                                <th>通知时间</th>
                                <th>备注</th>
                                <th>操作</th>
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
<%@ include file="/WEB-INF/views/admin/syssearchwarninglog/listjs.jsp" %>
<%@ include file="/WEB-INF/views/admin/common/tableexportjs.jsp" %>

<%@ include file="/WEB-INF/views/admin/common/listbottom.jsp" %>