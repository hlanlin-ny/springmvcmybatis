<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/listtop.jsp" %>

<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        公积金信息查询
        <small></small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="${ctxPath}/admin/index/main.html"><i class="fa fa-home"></i> 首页</a></li>
        <li class="active">静态数据分类查询</li>
        <li class="active"> 公积金信息查询</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">


    <div class="row">
        <div class="col-md-12">
            <shiro:hasPermission name="accumulationfundtocity:search">
                <!-- form start -->
                <form id="query-form" class="form-horizontal">
                    <div class="box">
                        <div class="box-header with-border">
                            <h3 class="box-title">查询条件</h3>
                        </div>
                        <div class="box-body">
                            <div class="form-group">
                                <label for="extra-search-xm" class="col-sm-2 control-label">姓名</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-xm"
                                           name="extra-search-xm" placeholder="姓名"/>
                                </div>

                                <label for="extra-search-xb" class="col-sm-2 control-label">性别</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-xb"
                                           name="extra-search-xb" placeholder="性别"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="extra-search-zjhm" class="col-sm-2 control-label">身份证号</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-zjhm"
                                           name="extra-search-zjhm" placeholder="身份证号"/>
                                </div>
                                <label for="extra-search-xzzDzmc" class="col-sm-2 control-label">现住址_地址名称</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-xzzDzmc"
                                           name="extra-search-xzzDzmc" placeholder="现住址_地址名称"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="extra-search-fwcs" class="col-sm-2 control-label">工作单位</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-fwcs"
                                           name="extra-search-fwcs" placeholder="工作单位"/>
                                </div>
                                <label for="extra-search-bz" class="col-sm-2 control-label">备注</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-bz"
                                           name="extra-search-bz" placeholder="备注"/>
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
                        <shiro:hasPermission name="accumulationfundtocity:refersh">
                            <button id="btn-refresh" type="button" class="btn btn-default">
                                <i class="fa fa-refresh"></i> 刷 新
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="accumulationfundtocity:export">
                            <%@ include file="/WEB-INF/views/admin/common/tableexport.jsp" %>
                        </shiro:hasPermission>
                    </div>
                </div>
                <div class="box-body no-padding">
                    <table id="data-table" class="table table-hover table-striped">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>姓名</th>
                            <th>性别</th>
                            <th>身份证号</th>
                            <th>住所地址名称</th>
                            <th>工作单位</th>
                            <th>登记时间</th>
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
<%@ include file="/WEB-INF/views/admin/accumulationfundtocity/accumulationfundtocityView.jsp" %>

<!-- js -->
<%@ include file="/WEB-INF/views/admin/accumulationfundtocity/accumulationfundtocityjs.jsp" %>
<%@ include file="/WEB-INF/views/admin/common/tableexportjs.jsp" %>

<%@ include file="/WEB-INF/views/admin/common/listbottom.jsp" %>