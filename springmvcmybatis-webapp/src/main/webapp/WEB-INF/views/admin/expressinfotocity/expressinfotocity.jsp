<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/listtop.jsp" %>

<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        快递信息查询
        <small></small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="${ctxPath}/admin/index/main.html"><i class="fa fa-home"></i> 首页</a></li>
        <li class="active">静态数据分类查询</li>
        <li class="active"> 快递信息查询</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">


    <div class="row">
        <div class="col-md-12">
            <shiro:hasPermission name="expressinfotocity:search">
                <!-- form start -->
                <form id="query-form" class="form-horizontal">
                    <div class="box">
                        <div class="box-header with-border">
                            <h3 class="box-title">查询条件</h3>
                        </div>
                        <div class="box-body">
                            <div class="form-group">
                                <label for="extra-search-YDH" class="col-sm-2 control-label">运单号</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-YDH"
                                           name="extra-search-YDH" placeholder="运单号"/>
                                </div>

                                <label for="extra-search-fahr_XM" class="col-sm-2 control-label">寄件人姓名</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-fahr_XM"
                                           name="extra-search-fahr_XM" placeholder="寄件人姓名"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="extra-search-fahr_LXDH" class="col-sm-2 control-label">寄件人联系电话</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-fahr_LXDH"
                                           name="extra-search-fahr_LXDH" placeholder="寄件人联系电话"/>
                                </div>

                                <label for="extra-search-shhr_XM" class="col-sm-2 control-label">收件人姓名</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-shhr_XM"
                                           name="extra-search-shhr_XM" placeholder="收件人姓名"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="extra-search-shhr_LXDH" class="col-sm-2 control-label">收件人联系电话</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-shhr_LXDH"
                                           name="extra-search-shhr_LXDH" placeholder="收件人联系电话"/>
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
                        <shiro:hasPermission name="expressinfotocity:refersh">
                            <button id="btn-refresh" type="button" class="btn btn-default">
                                <i class="fa fa-refresh"></i> 刷 新
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="expressinfotocity:export">
                            <%@ include file="/WEB-INF/views/admin/common/tableexport.jsp" %>
                        </shiro:hasPermission>
                    </div>
                </div>
                <div class="box-body no-padding">
                    <table id="data-table" class="table table-hover table-striped">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>运单号</th>
                            <th>快递公司单位名称</th>
                            <th>寄件人姓名</th>
                            <th>寄件人证件号码</th>
                            <th>寄件人联系电话</th>
                            <th>寄件时间</th>
                            <th>收件人姓名</th>
                            <th>收件人证件号码</th>
                            <th>收件人联系电话</th>
                            <th>收货时间</th>
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
<%@ include file="/WEB-INF/views/admin/expressinfotocity/expressinfotocityView.jsp" %>

<!-- js -->
<%@ include file="/WEB-INF/views/admin/expressinfotocity/expressinfotocityjs.jsp" %>
<%@ include file="/WEB-INF/views/admin/common/tableexportjs.jsp" %>

<%@ include file="/WEB-INF/views/admin/common/listbottom.jsp" %>