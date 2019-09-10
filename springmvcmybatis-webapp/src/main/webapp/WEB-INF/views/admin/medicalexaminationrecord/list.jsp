<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/listtop.jsp" %>

<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        医疗体检记录管理
        <small></small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="${ctxPath}/admin/index/main.html"><i class="fa fa-home"></i> 首页</a></li>
        <li class="active">系统管理</li>
        <li class="active"> 医疗体检记录管理</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">


    <div class="row">
        <div class="col-md-12">
            <shiro:hasPermission name="medicalexaminationrecord:search">
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

                            <div class="form-group">
                                <label for="extra-search-name" class="col-sm-2 control-label">姓名</label>

                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-name"
                                           name="extra-search-name" placeholder="姓名"/>
                                </div>
                                <label for="extra-search-idCardNum" class="col-sm-2 control-label">身份证号码</label>

                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-idCardNum"
                                           name="extra-search-idCardNum" placeholder="身份证号码"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="extra-search-phone" class="col-sm-2 control-label">联系电话</label>

                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-phone"
                                           name="extra-search-phone" placeholder="联系电话"/>
                                </div>
                                <label for="extra-search-address" class="col-sm-2 control-label">家庭地址</label>

                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-address"
                                           name="extra-search-address" placeholder="家庭地址"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="extra-search-profession" class="col-sm-2 control-label">职业</label>

                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-profession"
                                           name="extra-search-profession" placeholder="职业"/>
                                </div>
                                <label for="extra-search-organization" class="col-sm-2 control-label">工作单位</label>

                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-organization"
                                           name="extra-search-organization" placeholder="工作单位"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="extra-search-examinationDateime" class="col-sm-2 control-label">体检时间</label>

                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-examinationDateime" name="extra-search-examinationDateime"  placeholder="体检时间">
                                    <input type="hidden" class="form-control" id="extra-search-examinationDateimeBegin"
                                           name="extra-search-examinationDateimeBegin">
                                    <input type="hidden" class="form-control" id="extra-search-examinationDateimeEnd"
                                           name="extra-search-examinationDateimeEnd">
                                </div>
                                <label for="extra-search-examinationTerm" class="col-sm-2 control-label">体检项目</label>

                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-examinationTerm"
                                           name="extra-search-examinationTerm" placeholder="体检项目"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="extra-search-remark" class="col-sm-2 control-label">备注</label>

                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="extra-search-remark"
                                           name="extra-search-remark" placeholder="备注"/>
                                </div>
                                <label for="extra-search-userId" class="col-sm-2 control-label">上报网点</label>

                                <div class="col-sm-4">
                                    <select class="form-control select2" id="extra-search-userId"
                                            name="extra-search-userId" style="width: 100%;"></select>
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
                        <shiro:hasPermission name="medicalexaminationrecord:add">
                            <button id="btn-add" type="button" class="btn btn-primary">
                                <i class="glyphicon glyphicon-plus"></i> 添 加
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="medicalexaminationrecord:batchdelete">
                            <button id="btn-delAll" type="button" class="btn btn-default">
                                <i class="glyphicon glyphicon-trash"></i> 批量删除
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="medicalexaminationrecord:refersh">
                            <button id="btn-refresh" type="button" class="btn btn-default">
                                <i class="fa fa-refresh"></i> 刷 新
                            </button>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="medicalexaminationrecord:export">
                            <button type="button" class="btn btn-default" id="btn-export-excel">
                                <i class="fa fa-sign-out"></i> 导出
                            </button>
                        </shiro:hasPermission>
                    </div>
                </div>
                <div class="box-body no-padding">
                    <table id="data-table" class="table table-hover table-striped">
                        <thead>
                        <tr>
                            <shiro:hasPermission name="medicalexaminationrecord:batchdelete">
                                <th><input type="checkbox" id="checkAll"></th>
                            </shiro:hasPermission>
                            <th>序号</th>
                            <th>编号</th>
                            <th>姓名</th>
                            <th>身份证号码</th>
                            <th>联系电话</th>
                            <th>家庭地址</th>
                            <th>职业</th>
                            <th>工作单位</th>
                            <th>体检时间</th>
                            <th>体检项目</th>
                            <th>备注</th>
                            <myshiro:hasAnyPermission
                                    permissions="medicalexaminationrecord:edit,medicalexaminationrecord:delete">
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
<%@ include file="/WEB-INF/views/admin/medicalexaminationrecord/edit.jsp" %>
<%@ include file="/WEB-INF/views/admin/common/operateconfirmmodal.jsp" %>

<!-- js -->
<%@ include file="/WEB-INF/views/admin/medicalexaminationrecord/listjs.jsp" %>
<%@ include file="/WEB-INF/views/admin/common/tableexportjs.jsp" %>

<%@ include file="/WEB-INF/views/admin/common/listbottom.jsp" %>