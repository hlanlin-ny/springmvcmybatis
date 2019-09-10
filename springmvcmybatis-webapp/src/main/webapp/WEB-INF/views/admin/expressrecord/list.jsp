<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/listtop.jsp" %>

<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        快递记录管理
        <small></small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="${ctxPath}/admin/index/main.html"><i class="fa fa-home"></i> 首页</a></li>
        <li class="active">快递情报管理</li>
        <li class="active"> 快递记录管理</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">


    <div class="row">
        <div class="col-md-12">
            <shiro:hasPermission name="expressrecord:search">
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
                                <label for="reservation" class="col-sm-2 control-label">上报时间</label>

                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="reservation" name="reservation">
                                    <input type="hidden" class="form-control" id="extra-search-collectTimeBegin"
                                           name="extra-search-collectTimeBegin">
                                    <input type="hidden" class="form-control" id="extra-search-collectTimeEnd"
                                           name="extra-search-collectTimeEnd">
                                </div>

                                <label for="extra-search-userId" class="col-sm-2 control-label">上报网点</label>

                                <div class="col-sm-4">
                                    <select class="form-control select2" id="extra-search-userId"
                                            name="extra-search-userId" style="width: 100%;"></select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="extra-search-senderName" class="col-sm-2 control-label">发件人姓名</label>

                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-senderName"
                                           name="extra-search-senderName" placeholder="发件人姓名"/>
                                </div>

                                <label for="extra-search-senderPhone" class="col-sm-2 control-label">发件人电话</label>

                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-senderPhone"
                                           name="extra-search-senderPhone" placeholder="发件人电话"/>
                                </div>
                            </div>

                            <div class="form-group">

                                <label for="extra-search-senderIdCardNum" class="col-sm-2 control-label">发件人身份证号码</label>

                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-senderIdCardNum"
                                           name="extra-search-senderIdCardNum" placeholder="发件人身份证号码"/>
                                </div>

                                <label for="extra-search-receiverName" class="col-sm-2 control-label">收件人姓名</label>

                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-receiverName"
                                           name="extra-search-receiverName" placeholder="收件人姓名"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="extra-search-receiverPhone" class="col-sm-2 control-label">收件人电话</label>

                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-receiverPhone"
                                           name="extra-search-receiverPhone" placeholder="收件人电话"/>
                                </div>

                                <label for="extra-search-receiverAddress" class="col-sm-2 control-label">收件人地址</label>

                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-receiverAddress"
                                           name="extra-search-receiverAddress" placeholder="收件人地址"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="extra-search-goodsName" class="col-sm-2 control-label">货物名称</label>

                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-goodsName"
                                           name="extra-search-goodsName" placeholder="货物名称"/>
                                </div>

                                <label for="extra-search-remark" class="col-sm-2 control-label">备注</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-remark" name="extra-search-remark" placeholder="备注"/>
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
                        <shiro:hasPermission name="expressrecord:add">
                            <button id="btn-add" type="button" class="btn btn-primary">
                                <i class="glyphicon glyphicon-plus"></i> 添 加
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="expressrecord:batchdelete">
                            <button id="btn-delAll" type="button" class="btn btn-default">
                                <i class="glyphicon glyphicon-trash"></i> 批量删除
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="expressrecord:refersh">
                            <button id="btn-refresh" type="button" class="btn btn-default">
                                <i class="fa fa-refresh"></i> 刷 新
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="expressrecord:export">
                            <%@ include file="/WEB-INF/views/admin/common/tableexport.jsp" %>
                        </shiro:hasPermission>
                    </div>
                </div>
                <div class="box-body no-padding">
                    <table id="data-table" class="table table-hover table-striped">
                        <thead>
                        <tr>
                            <shiro:hasPermission name="expressrecord:batchdelete">
                                <th><input type="checkbox" id="checkAll"></th>
                            </shiro:hasPermission>
                            <th>序号</th>
                            <th>编号</th>
                            <th>上报时间</th>
                            <th>上报网点</th>
                            <th>发件人姓名</th>
                            <th>发件人电话</th>
                            <th>发件人身份证号码</th>
                            <th>收件人姓名</th>
                            <th>收件人电话</th>
                            <th>收件人地址</th>
                            <th>货物名称</th>
                            <th>备注</th>
                            <myshiro:hasAnyPermission permissions="expressrecord:edit,expressrecord:delete">
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
<%@ include file="/WEB-INF/views/admin/expressrecord/edit.jsp" %>
<%@ include file="/WEB-INF/views/admin/common/operateconfirmmodal.jsp" %>

<!-- js -->
<%@ include file="/WEB-INF/views/admin/expressrecord/listjs.jsp" %>
<%@ include file="/WEB-INF/views/admin/common/tableexportjs.jsp" %>

<%@ include file="/WEB-INF/views/admin/common/listbottom.jsp" %>