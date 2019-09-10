<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/listtop.jsp" %>

<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        静态情报入云
        <small></small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="${ctxPath}/admin/index/main.html"><i class="fa fa-home"></i> 首页</a></li>
        <li class="active">情报管理</li>
        <li class="active"> 静态情报入云</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">


    <div class="row">
        <div class="col-md-12">
            <shiro:hasPermission name="intelligenceimport:search">
                <!-- form start -->
                <form id="query-form" class="form-horizontal">
                    <div class="box">
                        <div class="box-header with-border">
                            <h3 class="box-title">查询条件</h3>
                        </div>
                        <div class="box-body">

                            <div class="form-group">
                                <label for="extra-search-businessTypeId" class="col-sm-2 control-label">情报业务类型</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-businessTypeName" name="extra-search-businessTypeName" placeholder="情报业务类型。请点击这里进行选择"  style="cursor:pointer;" readonly="readonly">
                                    <input type="hidden" class="form-control" id="extra-search-businessTypeId" name="extra-search-businessTypeId">
                                </div>

                                <label for="extra-search-fileType" class="col-sm-2 control-label">文件类型</label>
                                <div class="col-sm-4">
                                    <select class="form-control" id="extra-search-fileType" name='extra-search-fileType'>
                                        <option value="">全部</option>
                                        <option value="1">结构化数据</option>
                                        <option value="2">word文件</option>
                                        <option value="3">ppt文件</option>
                                        <option value="4">excel文件</option>
                                        <option value="5">txt文件</option>
                                        <option value="6">csv文件</option>
                                        <option value="7">pdf文件</option>
                                        <option value="8">图片文件</option>
                                        <option value="9">音频文件</option>
                                        <option value="10">视频文件</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="extra-search-filename" class="col-sm-2 control-label">文件名称</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-filename"
                                           name="extra-search-filename" placeholder="文件名称"/>
                                </div>

                                <label for="extra-search-filedesc" class="col-sm-2 control-label">文件内容描述</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-filedesc"
                                           name="extra-search-filedesc" placeholder="文件内容描述"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="reservation" class="col-sm-2 control-label">收集时间</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="reservation" name="reservation">
                                    <input type="hidden" class="form-control" id="extra-search-collectTimeBegin"
                                           name="extra-search-collectTimeBegin">
                                    <input type="hidden" class="form-control" id="extra-search-collectTimeEnd"
                                           name="extra-search-collectTimeEnd">
                                </div>
                                <input type="hidden" class="form-control" id="extra-search-areaId" name="extra-search-areaId" value="<myshiro:currentAreaId/>">
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
                        <shiro:hasPermission name="intelligenceimport:add">
                            <button id="btn-add" type="button" class="btn btn-primary">
                                <i class="glyphicon glyphicon-plus"></i> 添 加
                            </button>
                        </shiro:hasPermission>
                        <<shiro:hasPermission name="intelligenceimport:batchdelete">
                            <button id="btn-delAll" type="button" class="btn btn-default">
                                <i class="glyphicon glyphicon-trash"></i> 批量删除
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="intelligenceimport:refersh">
                            <button id="btn-refresh" type="button" class="btn btn-default">
                                <i class="fa fa-refresh"></i> 刷 新
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="intelligenceimport:export">
                            <%@ include file="/WEB-INF/views/admin/common/tableexport.jsp" %>
                        </shiro:hasPermission>
                    </div>
                </div>
                <div class="box-body no-padding">
                    <table id="data-table" class="table table-hover table-striped">
                        <thead>
                        <tr>
                            <shiro:hasPermission name="intelligenceimport:batchdelete">
                                <th><input type="checkbox" id="checkAll"></th>
                            </shiro:hasPermission>
                            <th>序号</th>
                            <th>编号</th>
                            <th>情报业务类型</th>
                            <th>文件类型</th>
                            <th>文件名称</th>
                            <th>文件内容描述</th>
                            <th>收集时间</th>
                            <th>备注</th>
                            <myshiro:hasAnyPermission permissions="intelligenceimport:edit,intelligenceimport:delete">
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
<%@ include file="/WEB-INF/views/admin/intelligenceimport/edit.jsp" %>
<%@ include file="/WEB-INF/views/admin/intelligenceimport/tree.jsp" %>
<%@ include file="/WEB-INF/views/admin/common/operateconfirmmodal.jsp" %>

<!-- js -->
<%@ include file="/WEB-INF/views/admin/intelligenceimport/listjs.jsp" %>
<%@ include file="/WEB-INF/views/admin/common/tableexportjs.jsp" %>

<%@ include file="/WEB-INF/views/admin/common/listbottom.jsp" %>