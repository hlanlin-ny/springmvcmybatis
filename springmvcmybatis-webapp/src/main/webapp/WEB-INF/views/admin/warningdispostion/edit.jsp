<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!--edit model -->
<div id="disposition-all-modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="disposition-modal-label"
     aria-hidden="true"
     data-backdrop="static" style="font-size: 12px;">
    <div class="modal-dialog" style="width: 1000px">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="edit-modal-label">预警处置</h4>
            </div>

            <!-- form start -->
            <form id="edit-form" name="edit-form" class="form-horizontal">
                <input type="hidden" name="resultList" id="resultList"/>
                <input type="hidden" name="relateId" id="relateId"/>

                <div class="modal-body">
                    <%--重点人员信息模块--%>
                    <div class="box-header with-border">
                        <h3 class="box-title">被布控人员信息</h3>
                    </div>
                    <div class="box-body">
                        <div id="data-table_perosn" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                            <div class="row">
                                <div class="col-sm-12">
                                    <table id="data-table_perosn_info"
                                           class="table table-hover table-bordered dataTable no-footer" role="grid"
                                           aria-describedby="data-table_info" style="width: 100%;">
                                        <tbody>
                                        <tr>
                                            <td><b>姓名</b></td>
                                            <td id="name"></td>
                                            <td><b>身份证号码</b></td>
                                            <td id="idcardNo"></td>
                                            <td><b>性别</b></td>
                                            <td id="sex"></td>
                                            <td><b>民族</b></td>
                                            <td id="nation"></td>
                                        </tr>
                                        <tr>
                                            <td><b>出生日期</b></td>
                                            <td id="bornTime"></td>
                                            <td><b>户籍地址</b></td>
                                            <td id="personAddress" colspan="3"></td>
                                            <td><b>人员类别</b></td>
                                            <td id="personType"></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%--活动发生详情模块--%>
                    <div class="box-header with-border">
                        <h3 class="box-title">活动发生详情</h3>
                    </div>
                    <div class="box-body">
                        <div id="data-table_activity" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                            <div class="row">
                                <div class="col-sm-12">
                                    <table id="data-table_activity_info"
                                           class="table table-hover  table-bordered   dataTable no-footer" role="grid"
                                           aria-describedby="data-table_info" style="width: 100%;">
                                        <tbody>
                                        <tr>
                                            <td colspan="2"><b>登记姓名</b></td>
                                            <td id="registerName"></td>
                                            <td><b>登记身份证</b></td>
                                            <td id="registerIDcardNo"></td>
                                            <td><b>登记出生日期</b></td>
                                            <td id="registerBornDate"></td>
                                        </tr>
                                        <tr>
                                            <td colspan="2"><b>发生时间</b></td>
                                            <td id="occurTime" colspan="2"></td>
                                            <td><b>行政区划</b></td>
                                            <td id="areaName" colspan="3"></td>
                                        </tr>
                                        <tr>
                                            <td colspan="2"><b>发生的详细地址</b></td>
                                            <td id="providerAddress" colspan="5"></td>
                                        </tr>
                                        <tr>
                                            <td colspan="2"><b>所属社会场所</b></td>
                                            <td colspan="2" id="informationProvider"></td>
                                            <td><b>所属公安机关</b></td>
                                            <td id="policeOffice" colspan="3"></td>
                                        </tr>
                                        <tr>
                                            <td colspan="2"><b>活动相关信息</b></td>
                                            <td id="activityInformation" colspan="6"></td>
                                        </tr>
                                        <tr>
                                            <td colspan=2"><b>动态信息类别</b></td>
                                            <td id="dynamicInformationType"></td>
                                            <td><b>动态信息提供单位</b></td>
                                            <td colspan="3" id="dynamicInformationProvider"></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%--预警详情模块--%>
                    <div class="box-header with-border">
                        <h3 class="box-title">预警详情</h3>
                    </div>
                    <div class="box-body">
                        <div id="data-table_disposition" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                            <div class="row">
                                <div class="col-sm-12">
                                    <table id="data-table_disposition_info"
                                           class="table table-hover table-bordered  dataTable no-footer" role="grid"
                                           aria-describedby="data-table_info" style="width: 100%;">
                                        <tbody>
                                        <tr>
                                            <td><b>预警时间</b></td>
                                            <td id="warningTime" colspan="1"></td>
                                            <td><b>布控人员</b></td>
                                            <td id="controlName" colspan="3"></td>
                                            <td><b>布控人员单位</b></td>
                                            <td id="controlPersonUnit" colspan="3"></td>
                                        </tr>
                                        <tr>
                                            <td><b>布控单位</b></td>
                                            <td id="controlUnit"></td>
                                            <td><b>联系方式</b></td>
                                            <td id="controlContact"></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%--处置措施模块--%>
                    <div id="disposition_model" hidden="hidden">
                        <div class="box-header with-border">
                            <h3 class="box-title">处置措施</h3>
                        </div>
                        <div class="box-body ">
                            <div class="form-group">
                                <label for="issuerName" class="col-sm-2 control-label">措施发布人</label>

                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="issuerName" name="issuerName"
                                           placeholder="发布人姓名">
                                </div>
                                <label for="dispositionTime" class="col-sm-2 control-label">处置时间</label>

                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="dispositionTime" name="dispositionTime"
                                           placeholder="处置时间">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="issueProvider" class="col-sm-2 control-label">发布单位</label>

                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="issueProvider"
                                           name="issueProvider" placeholder="发布单位">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="result" class="col-sm-2 control-label">处置结果</label>

                                <div class="col-sm-10">
                                    <textarea class="form-control" id="result" name="result"/>
                                    </textarea>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="remark" class="col-sm-2 control-label">备注</label>

                                <div class="col-sm-10">
                            <textarea class="form-control" id="remark" name="remark">
                            </textarea>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div id="dispostion_table" hidden="hidden">
                        <div class="box-header with-border">
                            <h3 class="box-title">处置措施</h3>
                        </div>
                        <div class="box-body">
                            <div id="data-table-takeMethod"
                                 class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                                <div class="row">
                                    <div class="col-sm-12">
                                        <table id="data-table_disposition_method"
                                               class="table table-hover table-bordered  dataTable no-footer" role="grid"
                                               aria-describedby="data-table_info" style="width: 100%;">
                                            <tbody>
                                            <tr>
                                                <td><b>措施发布人</b></td>
                                                <td id="method_name" colspan="1"></td>
                                                <td><b>发布时间</b></td>
                                                <td id="method_time" colspan="3"></td>
                                                <td><b>发布单位</b></td>
                                                <td id="method_unit" colspan="3"></td>
                                            </tr>
                                            <tr>
                                                <td><b>处置结果</b></td>
                                                <td id="method_result"></td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer" id="result-close" hidden="hidden">
                        <div class="pull-right">
                            <button id="btn-cancel1" type="button" class="btn btn-default" data-dismiss="modal"><i
                                    class="glyphicon glyphicon-remove"></i> 关 闭
                            </button>
                        </div>
                    </div>
                    <div class="modal-footer" id="disposition-tools">
                        <div class="pull-right">
                            <button id="btn-submit-info" class="btn btn-primary"><i
                                    class="glyphicon glyphicon-ok"></i>提 交
                            </button>
                            <button id="btn-cancel" type="button" class="btn btn-default" data-dismiss="modal"><i
                                    class="glyphicon glyphicon-remove"></i> 取 消
                            </button>
                        </div>
                    </div>

            </form>

        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>

