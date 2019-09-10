<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/listtop.jsp" %>

<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        搜索预警设置
        <small></small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="${ctxPath}/admin/index/main.html"><i class="fa fa-home"></i> 首页</a></li>
        <li class="active">搜索预警</li>
        <li class="active"> 搜索预警设置</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">


    <div class="row">
        <div class="col-md-12">
           <shiro:hasPermission name="syssearchwarningconfig:search">
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

                                <label for="extra-search-status" class="col-sm-2 control-label">状态</label>
                                <div class="col-sm-4">
                                    <select class="form-control" id="extra-search-status" name="extra-search-status"/>
                                    <option value="">全部</option>
                                    <option value=0>正常</option>
                                    <option value=1>暂停 </option>
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
                        <shiro:hasPermission name="syssearchwarningconfig:add">
                            <button id="btn-add" type="button" class="btn btn-primary">
                                <i class="glyphicon glyphicon-plus"></i> 添 加
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="syssearchwarningconfig:batchdelete">
                            <button id="btn-delAll" type="button" class="btn btn-default">
                                <i class="glyphicon glyphicon-trash"></i> 批量删除
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="syssearchwarningconfig:pause">
                            <button id="btn-pause" type="button" class="btn btn-default">
                                <i class="fa fa-pause"></i> 暂停
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="syssearchwarningconfig:resume">
                            <button id="btn-resume" type="button" class="btn btn-default">
                                <i class="fa fa-rotate-left"></i> 恢复
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="syssearchwarningconfig:run">
                            <button id="btn-run" type="button" class="btn btn-default">
                                <i class="fa fa-bolt"></i> 立即执行
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="syssearchwarningconfig:refersh">
                            <button id="btn-refresh" type="button" class="btn btn-default">
                                <i class="fa fa-refresh"></i> 刷 新
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="syssearchwarningconfig:export">
                            <%@ include file="/WEB-INF/views/admin/common/tableexport.jsp" %>
                        </shiro:hasPermission>
                    </div>
                </div>
                <div class="box-body no-padding">
                    <table id="data-table" class="table table-hover table-striped">
                        <thead>
                            <tr>
                                <shiro:hasPermission name="syssearchwarningconfig:batchdelete">
                                    <th><input type="checkbox" id="checkAll"></th>
                                </shiro:hasPermission>
                                <th>序号</th>
                                <th>编号</th>
                                <th>关键字</th>
                                <th>情报类型</th>
                                <th>文件类型</th>
                                <th>开始时间</th>
                                <th>是否精确匹配</th>
                                <th>状态</th>
                                <th>通知频率(分钟)</th>
                                <th>执行频率(分钟)</th>
                                <myshiro:hasAnyPermission permissions="syssearchwarningconfig:edit,syssearchwarningconfig:delete">
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
<%@ include file="/WEB-INF/views/admin/syssearchwarningconfig/edit.jsp" %>
<%@ include file="/WEB-INF/views/admin/common/operateconfirmmodal.jsp" %>

<!-- js -->
<%@ include file="/WEB-INF/views/admin/syssearchwarningconfig/listjs.jsp" %>
<%@ include file="/WEB-INF/views/admin/common/tableexportjs.jsp" %>

<%@ include file="/WEB-INF/views/admin/common/listbottom.jsp" %>