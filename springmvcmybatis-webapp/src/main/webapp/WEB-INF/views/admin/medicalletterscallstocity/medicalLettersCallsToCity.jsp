<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/listtop.jsp" %>

<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        信访人员信息查询
        <small></small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="${ctxPath}/admin/index/main.html"><i class="fa fa-home"></i> 首页</a></li>
        <li class="active">静态数据分类查询</li>
        <li class="active"> 信访人员信息查询</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">


    <div class="row">
        <div class="col-md-12">
            <shiro:hasPermission name="medicalletterscallstocity:search">
                <!-- form start -->
                <form id="query-form" class="form-horizontal">
                    <div class="box">
                        <div class="box-header with-border">
                            <h3 class="box-title">查询条件</h3>
                        </div>
                        <div class="box-body">
                            <div class="form-group">
                                <label for="extra-search-xfrXm" class="col-sm-2 control-label">信访人姓名</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-xfrXm"
                                           name="extra-search-xfrXm" placeholder="信访人姓名"/>
                                </div>

                                <label for="extra-search-xfrGmsfhm" class="col-sm-2 control-label">信访人证件号码</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-xfrGmsfhm"
                                           name="extra-search-xfrGmsfhm" placeholder="信访人证件号码"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="extra-search-sfrqBegin" class="col-sm-2 control-label">信访人时间起</label>
                                <div class="col-sm-4">
                                    <input  type="date" class="form-control" id="extra-search-sfrqBegin"
                                           name="extra-search-sfrqBegin" placeholder="信访人时间起"/>
                                </div>
                                <label for="extra-search-sfrqEnd" class="col-sm-2 control-label">至</label>
                                <div class="col-sm-4">
                                    <input type="date" class="form-control" id="extra-search-sfrqEnd"
                                           name="extra-search-sfrqEnd" placeholder="信访人时间止"/>
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
                        <shiro:hasPermission name="medicalletterscallstocity:refersh">
                            <button id="btn-refresh" type="button" class="btn btn-default">
                                <i class="fa fa-refresh"></i> 刷 新
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="medicalletterscallstocity:export">
                            <%@ include file="/WEB-INF/views/admin/common/tableexport.jsp" %>
                        </shiro:hasPermission>
                    </div>
                </div>
                <div class="box-body no-padding">
                    <table id="data-table" class="table table-hover table-striped">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>信访人姓名</th>
                            <th>信访日期</th>
                            <th>信访人身份号码</th>
                            <th>信访人联系电话</th>
                            <th>受理单位</th>
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
<%@ include file="/WEB-INF/views/admin/medicalletterscallstocity/medicalLettersCallsToCityView.jsp" %>

<!-- js -->
<%@ include file="/WEB-INF/views/admin/medicalletterscallstocity/medicalLettersCallsToCityjs.jsp" %>
<%@ include file="/WEB-INF/views/admin/common/tableexportjs.jsp" %>

<%@ include file="/WEB-INF/views/admin/common/listbottom.jsp" %>