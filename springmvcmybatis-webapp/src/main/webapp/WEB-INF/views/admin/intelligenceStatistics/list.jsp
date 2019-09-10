<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/listtop.jsp" %>

<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        情报查询统计
        <small></small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="${ctxPath}/admin/main.html"><i class="fa fa-home"></i> 首页</a></li>
        <li class="active">情报信息员管理</li>
        <li class="active"> 情报查询统计</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">


    <div class="row">
        <div class="col-md-12">
           <shiro:hasPermission name="intelligenceStatistics:search">
                <!-- form start -->
                <form id="query-form" class="form-horizontal">
                    <div class="box">
                        <div class="box-header with-border">
                            <h3 class="box-title">查询条件</h3>
                        </div>
                        <div class="box-body">
                            <div class="form-group">
                                <label for="reservation" class="col-sm-2 control-label">上报时间</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="reservation" name="reservation">
                                    <input type="hidden" class="form-control" id="extra-search-reportingTimeStart"
                                           name="extra-search-reportingTimeStart">
                                    <input type="hidden" class="form-control" id="extra-search-reportingTimeEnd"
                                           name="extra-search-reportingTimeEnd">
                                </div>

                                <label for="extra-search-intelligenceOfficerId" class="col-sm-2 control-label">上报人</label>
                                <div class="col-sm-4">
                                    <select class="form-control select2" id="extra-search-intelligenceOfficerId" name="extra-search-intelligenceOfficerId"  style="width: 100%;"></select>
                                </div>

                            </div>

                             <div class="form-group">
                                 <label for="extra-search-isOfficer" class="col-sm-2 control-label">是否是情报员</label>
                                 <div class="col-sm-4">
                                     <select class="form-control" id="extra-search-isOfficer" name="extra-search-isOfficer"/>
                                     <option value="">全部</option>
                                     <option value=true>是</option>
                                     <option value=false>否 </option>
                                     </select>
                                 </div>
                                 <input type="hidden" class="form-control" id="extra-search-idNumbers"
                                        name="extra-search-idNumbers">
                                 <input type="hidden" class="form-control" id="extra-search-level"
                                        name="extra-search-level">
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

                    </div>
                </div>
                <div class="box-body no-padding">
                    <table id="data-table" class="table table-hover table-striped">
                        <thead>
                            <tr>
                                <th>上报人</th>
                                <th>身份证号</th>
                                <th>是否是情报员</th>
                                <th>一般</th>
                                <th>重要(条数)</th>
                                <th>非常重要(条数)</th>
                                <th>总(条数)</th>
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
<%@ include file="/WEB-INF/views/admin/intelligenceStatistics/show.jsp" %>
<!-- js -->
<%@ include file="/WEB-INF/views/admin/intelligenceStatistics/listjs.jsp" %>
<%@ include file="/WEB-INF/views/admin/common/tableexportjs.jsp" %>

<%@ include file="/WEB-INF/views/admin/common/listbottom.jsp" %>