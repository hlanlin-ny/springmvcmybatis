<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/listtop.jsp" %>

<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        情报员信息员建档
        <small></small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="${ctxPath}/admin/main.html"><i class="fa fa-home"></i> 首页</a></li>
        <li class="active">情报信息员管理</li>
        <li class="active"> 情报员信息员建档</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">

    <div class="row">
        <div class="col-md-12">
           <shiro:hasPermission name="intelligenceofficer:search">
                <!-- form start -->
                <form id="query-form" class="form-horizontal">
                    <div class="box">
                        <div class="box-header with-border">
                            <h3 class="box-title">查询条件</h3>
                        </div>
                        <div class="box-body">
                            <div class="form-group">
                                <label for="extra-search-name" class="col-sm-2 control-label">姓名</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-name" name="extra-search-name" placeholder="姓名"/>
                                </div>
                                <label for="extra-search-idNumbers" class="col-sm-2 control-label">身份证号</label>
                                <div class="col-sm-4">
                                  <input type="text" class="form-control" id="extra-search-idNumbers" name="extra-search-idNumbers" placeholder="身份证号"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="reservation" class="col-sm-2 control-label">入职时间</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="reservation" name="reservation">
                                    <input type="hidden" class="form-control" id="extra-search-hireDateStart"
                                           name="extra-search-hireDateStart">
                                    <input type="hidden" class="form-control" id="extra-search-hireDateEnd"
                                           name="extra-search-hireDateEnd">
                                </div>
                                <label for="extra-search-status" class="col-sm-2 control-label">信息员状态</label>
                                <div class="col-sm-4">
                                  <select class="form-control" id="extra-search-status" name="extra-search-status"/>
                                    <option value="">全部</option>
                                    <option value="0">启用</option>
                                    <option value="1">停用</option>
                                    <option value="2">失效</option>
                                  </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="extra-search-belongwechat" class="col-sm-2 control-label">所属微信群</label>
                                <div class="col-sm-4">
                                    <select class="form-control" id="extra-search-belongwechat" name="extra-search-belongwechat" placeholder="所属微信群">
                                        <option value=''>全部</option>
                                    </select>
                                </div>
                                <label for="extra-search-isOfficer" class="col-sm-2 control-label">是否是情报员</label>
                                <div class="col-sm-4">
                                    <select class="form-control" id="extra-search-isOfficer" name="extra-search-isOfficer"/>
                                    <option value="">全部</option>
                                    <option value=true>是</option>
                                    <option value=false>否 </option>
                                    </select>
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
                        <shiro:hasPermission name="intelligenceofficer:add">
                            <button id="btn-add" type="button" class="btn btn-primary">
                                <i class="glyphicon glyphicon-plus"></i> 添 加
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="intelligenceofficer:batchdelete">
                            <button id="btn-delAll" type="button" class="btn btn-default">
                                <i class="glyphicon glyphicon-trash"></i> 批量删除
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="intelligenceofficer:refersh">
                            <button id="btn-refresh" type="button" class="btn btn-default">
                                <i class="fa fa-refresh"></i> 刷 新
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="intelligenceofficer:export">
                            <%@ include file="/WEB-INF/views/admin/common/tableexport.jsp" %>
                        </shiro:hasPermission>
                    </div>
                </div>
                <div class="box-body no-padding">
                    <table id="data-table" class="table table-hover table-striped">
                        <thead>
                            <tr>
                                <shiro:hasPermission name="intelligenceofficer:batchdelete">
                                    <th><input type="checkbox" id="checkAll"></th>
                                </shiro:hasPermission>
                                <th>序号</th>
                                <th>编号</th>
                                <th>姓名</th>
                                <th>性别</th>
                                <th>身份证号</th>
                                <th>住址</th>
                                <th>入职时间</th>
                                <th>职业</th>
                                <th>婚姻状况</th>
                                <th>手机号</th>
                                <th>状态</th>
                                <th>微信群</th>
                                <th>情报员?</th>
                                <th>备注</th>
                                <myshiro:hasAnyPermission permissions="intelligenceofficer:edit,intelligenceofficer:delete">
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
<%@ include file="/WEB-INF/views/admin/intelligenceofficer/edit.jsp" %>
<%@ include file="/WEB-INF/views/admin/common/operateconfirmmodal.jsp" %>

<!-- js -->
<%@ include file="/WEB-INF/views/admin/intelligenceofficer/listjs.jsp" %>
<%@ include file="/WEB-INF/views/admin/common/tableexportjs.jsp" %>

<%@ include file="/WEB-INF/views/admin/common/listbottom.jsp" %>