<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--edit model -->
<div id="edit-modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="edit-modal-label" aria-hidden="true"
     data-backdrop="static">
    <div class="modal-dialog" style="width: 1000px">
        <div class="modal-content" >
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="edit-modal-label">临时布控单</h4>
            </div>

            <!-- form start -->
            <form id="edit-form" name="edit-form" class="form-horizontal">
                <input type="hidden" class="form-control" id="id" name="id">
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
                                        <td class="col-sm-2"><b>* 姓名</b></td><td class="col-sm-2 td_value" id="controlByName" name="controlByName" contentEditable="true"></td>
                                        <td class="col-sm-2"><b>别名绰号</b></td><td class="col-sm-2 td_value" id="nickName" name="nickName" contentEditable="true"></td>
                                        <td class="col-sm-2"><b>性别</b></td>
                                        <td class="col-sm-2">
                                            <select  class="select2 td_select" id="sex" name="sex" style="width: 120px;">
                                                <option></option>
                                                <option value="男">男</option>
                                                <option value="女">女</option>
                                           </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="col-sm-2"><b>* 出生日期</b></td><td  class="col-sm-2 td_value" id="bornTime" name="bornTime" contentEditable="true"></td>
                                        <td class="col-sm-2"><b>民族</b></td><td   class="col-sm-2 td_value" id="nation" name="nation" contentEditable="true"></td>
                                        <td class="col-sm-2"><b>* 证件类型</b></td> <td  class="col-sm-2 td_value" id="cardType" name="cardType" contentEditable="true"></td>
                                    </tr>
                                    <tr>
                                        <td class="col-sm-2"><b>* 证件号码</b></td> <td class="col-sm-2 td_value"  id="cardNumber" name="cardNumber" contentEditable="true"></td>
                                        <td class="col-sm-2"><b>户籍地址</b></td> <td class="col-sm-2 td_value"  id="address" name="address" contentEditable="true"></td>
                                        <td class="col-sm-2"><b>工作单位</b></td> <td class="col-sm-2 td_value"  id="workUnit" name="workUnit" contentEditable="true"></td>
                                    </tr>
                                    <tr>
                                        <td class="col-sm-2"><b>布控事由</b></td><td class="col-sm-2 td_value" id="controlReason" name="controlReason" colspan="7" contentEditable="true"></td>
                                    </tr>
                                    <tr>
                                        <td class="col-sm-2"><b>备注</b></td><td class="col-sm-2 td_value"  id="remark" name="remark" colspan="7" contentEditable="true"></td>
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
                                    <td class="col-sm-2"><b>临控措施要求</b></td>
                                    <td class="col-sm-2" colspan="5">
                                        <select  class="select_require td_auto_select" id="controlMeasureRequire" name="controlMeasureRequire" style="width: 120px;">
                                            <option></option>
                                            <option value="抓获">抓获</option>
                                            <option value="关注">关注</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="col-sm-2"><b>* 布控起始时间</b></td><td  class="col-sm-2 td_value" id="controlBeginTime" name="controlBeginTime"></td>
                                    <td class="col-sm-1"><b>* 布控天数</b></td>
                                    <td class="col-sm-2">
                                        <select  class="select_day td_select" id="controlDays" name="controlDays" style="width: 100px;">
                                            <option></option>
                                            <option value="7">7天</option>
                                            <option value="15">15天</option>
                                            <option value="30">30天</option>
                                        </select>
                                    </td>
                                    <td  class="col-sm-2"><b>* 布控截止时间</b></td> <td  class="col-sm-2 td_value" id="controlEndTime" name="controlEndTime"></td>
                                </tr>
                                <tr>
                                    <td class="col-sm-2"><b>* 布控单位</b></td> <td class="col-sm-2 td_value" id="controlUnit" name="controlUnit"contentEditable="true"></td>
                                    <td class="col-sm-2"><b>* 反馈联系方式</b></td><td  class="col-sm-2 td_value" colspan="5" id="feedBackContact" name="feedBackContact" contentEditable="true"></td>
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
                                    <td class="col-sm-2"><b>*申请单位</b></td><td  class="col-sm-2 td_value"  id="applyUnit" name="applyUnit" contentEditable="true"></td>
                                    <td class="col-sm-2"><b>*申请单位联系电话</b></td><td class="col-sm-2 td_value" id="applyUnitContactTel" name="applyUnitContactTel" contentEditable="true"></td>
                                    <td class="col-sm-2"><b>*申请人姓名</b></td><td class="col-sm-2 td_value" id="applyName" name="applyName" contentEditable="true"></td>
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
                                    <td  class="col-sm-2"><b>*申请单位负责人签字</b></td><td  colspan="2" class="col-sm-4 td_value" id="applyUnitPrincipal" name="applyUnitPrincipal" contentEditable="true"></td>
                                    <td class="col-sm-2"><b>*申请公安机关负责人签字</b></td><td colspan="2"class="col-sm-4 td_value" id="applySafeOrgan" name="applySafeOrgan" contentEditable="true"></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

                <div class="modal-footer">
                    <div class="pull-right">
                        <button id="btn-submit" type="submit" class="btn btn-primary"><i
                                class="glyphicon glyphicon-ok"></i> 确 定
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