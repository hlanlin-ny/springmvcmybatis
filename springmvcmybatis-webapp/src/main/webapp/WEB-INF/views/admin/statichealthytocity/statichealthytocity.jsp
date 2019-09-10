<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/listtop.jsp" %>

<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        健康证明信息查询
        <small></small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="${ctxPath}/admin/index/main.html"><i class="fa fa-home"></i> 首页</a></li>
        <li class="active">静态数据分类查询</li>
        <li class="active"> 健康证明信息查询</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">


    <div class="row">
        <div class="col-md-12">
            <shiro:hasPermission name="statichealthytocity:search">
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

                                <label for="extra-search-gmsfhm" class="col-sm-2 control-label">公民身份号码</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-gmsfhm"
                                           name="extra-search-gmsfhm" placeholder="公民身份号码"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="extra-search-dwmc" class="col-sm-2 control-label">工作单位名称</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-dwmc"
                                           name="extra-search-dwmc" placeholder="工作单位名称"/>
                                </div>

                                <label for="extra-search-lxdh" class="col-sm-2 control-label">联系电话</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-lxdh"
                                           name="extra-search-lxdh" placeholder="联系电话"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="extra-search-dzmc" class="col-sm-2 control-label">住所地址名称</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-dzmc"
                                           name="extra-search-dzmc" placeholder="住所地址名称"/>
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
                        <shiro:hasPermission name="statichealthytocity:refersh">
                            <button id="btn-refresh" type="button" class="btn btn-default">
                                <i class="fa fa-refresh"></i> 刷 新
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="statichealthytocity:export">
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
                            <th>个人编号</th>
                            <th>身份号码</th>
                            <th>联系电话</th>
                            <th>住所地址名称</th>
                            <th>工作单位名称</th>
                            <th>体检日期</th>
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
<%@ include file="/WEB-INF/views/admin/statichealthytocity/statichealthytocityView.jsp" %>

<!-- js -->
<%@ include file="/WEB-INF/views/admin/statichealthytocity/statichealthytocityjs.jsp" %>
<%@ include file="/WEB-INF/views/admin/common/tableexportjs.jsp" %>

<%@ include file="/WEB-INF/views/admin/common/listbottom.jsp" %>