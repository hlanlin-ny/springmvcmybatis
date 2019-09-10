<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/listtop.jsp" %>

<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        情报信息录入
        <small></small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="${ctxPath}/admin/main.html"><i class="fa fa-home"></i> 首页</a></li>
        <li class="active">情报信息员管理</li>
        <li class="active"> 情报信息录入</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">


    <div class="row">
        <div class="col-md-12">
           <shiro:hasPermission name="intelligence:search">
                <!-- form start -->
                <form id="query-form" class="form-horizontal">
                    <div class="box">
                        <div class="box-header with-border">
                            <h3 class="box-title">查询条件</h3>
                        </div>
                        <div class="box-body">
                            <div class="form-group">
                                <label for="extra-search-title" class="col-sm-2 control-label">协查标题</label>
                                <div class="col-sm-4">
                                  <input type="text" class="form-control" id="extra-search-title" name="extra-search-title" placeholder="协查标题"/>
                                </div>

                                <label for="extra-search-level" class="col-sm-2 control-label">情报级别</label>
                                <div class="col-sm-4">
                                    <select class="form-control" id="extra-search-level" name="extra-search-level"/>
                                    <option value="">全部</option>
                                    <option value="0">一般</option>
                                    <option value="1">重要</option>
                                    <option value="2">非常重要</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="extra-search-intelligenceOfficerId" class="col-sm-2 control-label">上报人</label>
                                <div class="col-sm-4">
                                    <select class="form-control select2" id="extra-search-intelligenceOfficerId" name="extra-search-intelligenceOfficerId"  style="width: 100%;"></select>
                                </div>
                                <label for="extra-search-awardsStatus" class="col-sm-2 control-label">奖励状态</label>
                                <div class="col-sm-4">
                                    <select class="form-control" id="extra-search-awardsStatus" name="extra-search-awardsStatus"/>
                                    <option value="">全部</option>
                                    <option value=true>已奖励</option>
                                    <option value=false>未奖励</option>
                                    </select>
                                </div>

                            </div>

                            <div class="form-group">
                                <label for="reservation" class="col-sm-2 control-label">上报时间</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="reservation" name="reservation">
                                    <input type="hidden" class="form-control" id="extra-search-reportingTimeStart"
                                           name="extra-search-reportingTimeStart">
                                    <input type="hidden" class="form-control" id="extra-search-reportingTimeEnd"
                                           name="extra-search-reportingTimeEnd">
                                </div>
                                <label for="extra-search-infoDesc" class="col-sm-2 control-label">情报描述</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-infoDesc" name="extra-search-infoDesc" placeholder=""/>
                                </div>
                            </div>

                             <div class="form-group">
                                <label for="reservation2" class="col-sm-2 control-label">发现时间</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="reservation2" name="reservation2">
                                    <input type="hidden" class="form-control" id="extra-search-foundTimeStart"
                                           name="extra-search-foundTimeStart">
                                    <input type="hidden" class="form-control" id="extra-search-foundTimeEnd"
                                           name="extra-search-foundTimeEnd">
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
                        <shiro:hasPermission name="intelligence:add">
                            <button id="btn-add" type="button" class="btn btn-primary">
                                <i class="glyphicon glyphicon-plus"></i> 添 加
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="intelligence:batchdelete">
                            <button id="btn-delAll" type="button" class="btn btn-default">
                                <i class="glyphicon glyphicon-trash"></i> 批量删除
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="intelligence:refersh">
                            <button id="btn-refresh" type="button" class="btn btn-default">
                                <i class="fa fa-refresh"></i> 刷 新
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="intelligence:export">
                            <%@ include file="/WEB-INF/views/admin/common/tableexport.jsp" %>
                        </shiro:hasPermission>
                    </div>
                </div>
                <div class="box-body no-padding">
                    <table id="data-table" class="table table-hover table-striped">
                        <thead>
                            <tr>
                                <shiro:hasPermission name="intelligence:batchdelete">
                                    <th><input type="checkbox" id="checkAll"></th>
                                </shiro:hasPermission>
                                <th>序号</th>
                                <th>编号</th>
                                <th>协查标题</th>
                                <th>上报人</th>
                                <th>上报时间</th>
                                <th>情报描述</th>
                                <th>发现时间</th>
                                <th>情报级别</th>
                                <th>奖励状态</th>
                                <th>奖励描述</th>
                                <th>备注</th>
                                <myshiro:hasAnyPermission permissions="intelligence:edit,intelligence:delete">
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
<%@ include file="/WEB-INF/views/admin/intelligence/edit.jsp" %>
<%@ include file="/WEB-INF/views/admin/common/operateconfirmmodal.jsp" %>

<!-- js -->
<%@ include file="/WEB-INF/views/admin/intelligence/listjs.jsp" %>
<%@ include file="/WEB-INF/views/admin/common/tableexportjs.jsp" %>

<%@ include file="/WEB-INF/views/admin/common/listbottom.jsp" %>