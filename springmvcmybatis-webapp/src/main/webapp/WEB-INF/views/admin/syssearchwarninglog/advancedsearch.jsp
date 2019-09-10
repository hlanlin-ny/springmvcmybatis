<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/WEB-INF/views/admin/common/basecss.jsp" %>
    <%-- jQuery validation --%>
    <link rel="stylesheet" href="${ctxPath}/resources/plugins/jquery-validation/validation.css">
    <%-- Pace style --%>
    <link rel="stylesheet" href="${ctxPath}/resources/plugins/pace/pace.min.css">
    <%-- daterange picker --%>
    <link rel="stylesheet" href="${ctxPath}/resources/plugins/daterangepicker/daterangepicker.css">
    <%--iCheck--%>
    <link rel="stylesheet" href="${ctxPath}/resources/plugins/iCheck/all.css">
    <%-- jQuery validation --%>
    <link rel="stylesheet" href="${ctxPath}/resources/plugins/jquery-validation/validation.css">
    <%-- zTree --%>
    <link rel="stylesheet" href="${ctxPath}/resources/plugins/zTree/css/metroStyle/metroStyle.css">

    <link rel="icon" href="${ctxPath}/resources/dist/img/favicon.ico" type="image/x-icon"/>
    <link rel="shortcut icon" href="${ctxPath}/resources/dist/img/favicon.png" type="image/x-icon"/>
    <title>情报管理大数据平台</title>
</head>
<!-- ADD THE CLASS layout-top-nav TO REMOVE THE SIDEBAR. -->
<body class="hold-transition skin-blue layout-top-nav">
<div class="wrapper">
    <!-- Full Width Column -->
    <div class="content-wrapper">
        <div class="container">
            <!-- Main content -->
            <section class="content">
                <!-- form start -->
                <form id="query-form" class="form-horizontal">
                    <div class="box box-default">
                        <div class="box-header with-border">
                            <h3 class="box-title">搜索条件</h3>
                            <div class="box-tools pull-right">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                </button>
                            </div>
                            <!-- /.box-tools -->
                        </div>
                        <div class="box-body">
                            <input type="hidden" id="datasourceType" name="datasourceType"
                                   value="1"/>
                            <input type="hidden" class="form-control" id="pageIndex"
                                   name="pageIndex" value="1">
                            <input type="hidden" class="form-control" id="pageSize"
                                   name="pageSize" value="10">

                            <div class="form-group">
                                <label for="keyword" class="col-sm-3 control-label">关键字</label>

                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="keyword"
                                           name="keyword" placeholder="关键字"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="startTime" class="col-sm-3 control-label">起始时间</label>

                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="startTime" name="startTime" placeholder="查询数据开始时间">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="tree-layer" class="col-sm-3 control-label">情报分类</label>
                                <div class="col-sm-9">
                                    <input type="hidden" class="form-control" id="intelligenceBusinessTypeIds" name="intelligenceBusinessTypeIds">
                                    <div id="tree-layer" class="box box-solid">
                                        <div class="box-body">
                                            <ul id="menuTree" class="ztree"></ul>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="fileTypes" class="col-sm-3 control-label">文件类型</label>
                                <div class="col-sm-9">
                                    <div class="checkbox" id="fileTypeList">
                                        <label><input type='checkbox' name='fileType' value="1">结构化数据</label>
                                        <label><input type='checkbox' name='fileType' value="2">word文件</label>
                                        <label><input type='checkbox' name='fileType' value="3">ppt文件</label>
                                        <label><input type='checkbox' name='fileType' value="4">excel文件</label>
                                        <label><input type='checkbox' name='fileType' value="5">txt文件</label>
                                        <label><input type='checkbox' name='fileType' value="6">csv文件</label>
                                        <label><input type='checkbox' name='fileType' value="7">pdf文件</label>
                                        <label><input type='checkbox' name='fileType' value="8">图片文件</label>
                                        <label><input type='checkbox' name='fileType' value="9">音频文件</label>
                                        <label><input type='checkbox' name='fileType' value="10">视频文件</label>
                                    </div>
                                    <input type="hidden" class="form-control" id="fileTypes" name="fileTypes">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="preciseQuery" class="col-sm-3 control-label">只显示精确匹配结果</label>

                                <div class="col-sm-9">
                                    <div class="checkbox" id="preciseQueryList">
                                        <label><input type='checkbox' id="preciseQuery" name='preciseQuery' value="1">是</label>
                                    </div>
                                </div>
                            </div>


                            <div class="pull-right">
                                <button id="btn-search" type="button" class="btn btn-primary"><i
                                        class="fa fa-search"></i> 搜 索
                                </button>
                                <button id="btn-reset" type="button" class="btn btn-default"><i class="fa fa-undo"></i>
                                    重 置
                                </button>
                            </div>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </form>

                <div class="box box-default">
                    <div class="box-header with-border">
                        <h3 class="box-title">搜索结果</h3>
                        <div class="box-tools">
                            <div class="input-group input-group-sm"
                                 style="width: 780px; margin-top: 5px;">
                                <div class="row">
                                    <div class="col-md-6">

                                    </div>
                                    <div class="col-md-3">
                                        <%--<input id="cb_precise_query" type="checkbox">只显示精确匹配结果--%>
                                    </div>
                                    <div class="col-md-3">
                                        <div id="totalHits" class="text-right"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="box-tools pull-right">
                            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                            </button>
                        </div>
                        <!-- /.box-tools -->
                    </div>
                    <div id="searchResultList" class="box-body"></div>
                    <!-- /.box-body -->
                    <div class="box-footer clearfix">
                        <ul id="pagination1" class="pagination no-margin pull-right"></ul>
                    </div>
                </div>
                <!-- /.box -->

            </section>
            <!-- /.content -->
        </div>
        <!-- /.container -->
    </div>

</div>
<!-- ./wrapper -->

<%@ include file="/WEB-INF/views/admin/syssearchwarninglog/advancedsearchjs.jsp" %>

<%--<%@ include file="/WEB-INF/views/admin/index/changepassword.jsp" %>--%>
<%--<%@ include file="/WEB-INF/views/admin/index/changepasswordjs.jsp" %>--%>

</body>
</html>