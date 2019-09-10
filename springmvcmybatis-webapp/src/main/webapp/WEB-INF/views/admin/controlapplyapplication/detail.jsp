<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--edit model -->
<div id="detail-modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="detail-modal-label" aria-hidden="true"
     data-backdrop="static">
    <div class="modal-dialog" style="width: 1000px">
        <div class="modal-content" >
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="edit-modal-label">临时布控单</h4>
            </div>
            <div class="modal-body">
                <%--被布控人信息模块--%>
                <div class="box-header with-border" style="text-align:center">
                    <h3 class="box-title"><b>被布控人信息</b></h3>
                </div>
                <div class="box-body">
                    <div class="row">
                        <div class="col-sm-12">
                            <table id="data-table_control_person" class="table table-hover table-bordered dataTable no-footer" role="grid" aria-describedby="data-table_info" style="width: 100%;">
                                <tbody>
                                <tr>
                                    <td class="col-sm-2"><b>姓名</b></td><td class="col-sm-2 td_value" id="detail_controlByName"></td>
                                    <td class="col-sm-2"><b>别名绰号</b></td><td class="col-sm-2 td_value" id="detail_nickName"></td>
                                    <td class="col-sm-2"><b>性别</b></td><td class="col-sm-2 td_value" id="detail_sex"></td>
                                </tr>
                                <tr>
                                    <td class="col-sm-2"><b>出生日期</b></td><td  class="col-sm-2 td_value" id="detail_bornTime"></td>
                                    <td class="col-sm-2"><b>民族</b></td><td class="col-sm-2 td_value" id="detail_nation"></td>
                                    <td class="col-sm-2"><b>证件类型</b></td> <td  class="col-sm-2 td_value" id="detail_cardType"></td>
                                </tr>
                                <tr>
                                    <td class="col-sm-2"><b>证件号码</b></td> <td class="col-sm-2 td_value"  id="detail_cardNumber"></td>
                                    <td class="col-sm-2"><b>户籍地址</b></td> <td class="col-sm-2 td_value"  id="detail_address"></td>
                                    <td class="col-sm-2"><b>工作单位</b></td> <td class="col-sm-2 td_value"  id="detail_workUnit"></td>
                                </tr>
                                <tr>
                                    <td class="col-sm-2"><b>布控事由</b></td><td class="col-sm-2 td_value" id="detail_controlReason" colspan="7"></td>
                                </tr>
                                <tr>
                                    <td class="col-sm-2"><b>备注</b></td><td class="col-sm-2 td_value"  id="detail_remark" colspan="7"></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

            <%--布控信息模块--%>
            <div class="box-header with-border" style="text-align:center">
                <h3 class="box-title"><b>布控信息</b></h3>
            </div>
            <div class="box-body">
                <div class="row">
                    <div class="col-sm-12">
                        <table id="data-table_control" class="table table-hover table-bordered dataTable no-footer" role="grid" aria-describedby="data-table_info" style="width: 100%;">
                            <tbody>
                            <tr>
                                <td class="col-sm-2"><b>临控措施要求</b></td><td colspan="5" class="col-sm-2 td_value" id="detail_controlMeasureRequire"></td>
                            </tr>
                            <tr>
                                <td class="col-sm-2"><b>布控起始时间</b></td><td  class="col-sm-2 td_value" id="detail_controlBeginTime"></td>
                                <td class="col-sm-1"><b>布控天数</b></td><td class="col-sm-2 td_value" id="detail_controlDays"></td>
                                <td class="col-sm-2"><b>布控截止时间</b></td> <td class="col-sm-2 td_value" id="detail_controlEndTime"></td>
                            </tr>
                            <tr>
                                <td class="col-sm-2"><b>布控单位</b></td> <td class="col-sm-2 td_value" id="detail_controlUnit"></td>
                                <td class="col-sm-2"><b>反馈联系方式</b></td><td class="col-sm-2 td_value" colspan="5" id="detail_feedBackContact"></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <%--申请人信息模块--%>
            <div class="box-header with-border" style="text-align:center">
                <h3 class="box-title"><b>申请人信息</b></h3>
            </div>
            <div class="box-body">
                <div class="row">
                    <div class="col-sm-12">
                        <table id="data-table_apply" class="table table-hover table-bordered dataTable no-footer" role="grid" aria-describedby="data-table_info" style="width: 100%;">
                            <tbody>
                            <tr>
                                <td class="col-sm-2"><b>申请单位</b></td><td  class="col-sm-2 td_value"  id="detail_applyUnit"></td>
                                <td class="col-sm-2"><b>申请单位联系电话</b></td><td class="col-sm-2 td_value" id="detail_applyUnitContactTel" ></td>
                                <td class="col-sm-2"><b>申请人姓名</b></td><td class="col-sm-2 td_value" id="detail_applyName"></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <%--申请人信息模块--%>
            <div class="box-header with-border" style="text-align:center">
                <h3 class="box-title"><b>布控申请公安单位负责人审批</b></h3>
            </div>
            <div class="box-body">
                <div class="row">
                    <div class="col-sm-12">
                        <table id="data-table_audit" class="table table-hover table-bordered dataTable no-footer" role="grid" aria-describedby="data-table_info" style="width: 100%;">
                            <tbody>
                            <tr>
                                <td class="col-sm-2"><b>申请单位负责人签字</b></td><td  colspan="2" class="col-sm-4 td_value" id="detail_applyUnitPrincipal"></td>
                                <td class="col-sm-2"><b>申请公安机关负责人签字</b></td><td colspan="2"class="col-sm-4 td_value" id="detail_applySafeOrgan"></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <div class="modal-footer">
                <div class="pull-right">
                    <button id="btn-cancel" type="button" class="btn btn-default" data-dismiss="modal"><i
                            class="glyphicon glyphicon-remove"></i> 关 闭
                    </button>
                </div>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>