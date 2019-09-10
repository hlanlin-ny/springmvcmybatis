<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--edit model -->
<div id="edit-modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="edit-modal-label" aria-hidden="true"
     data-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="edit-modal-label">添加</h4>
            </div>

            <!-- form start -->
            <form id="edit-form" name="edit-form" class="form-horizontal">

                <div class="modal-body">
                    <input type="hidden" class="form-control" id="id" name="id">


                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">姓名</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="name" name="name" placeholder="重点人员姓名">
                        </div>
                        <label for="idCardNo" class="col-sm-2 control-label">身份证号码</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="idCardNo" name="idCardNo" placeholder="身份证号码" maxlength="18">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="sex" class="col-sm-2 control-label">性别</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="sex" name="sex" placeholder="重点人员性别">
                        </div>
                        <label for="nation" class="col-sm-2 control-label">民族</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="nation" name="nation" placeholder="民族">
                        </div>
                    </div>


                    <div class="form-group">
                        <label for="bornTime" class="col-sm-2 control-label">出生日期</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="bornTime" name="bornTime" placeholder="出生日期">
                        </div>
                        <label for="address" class="col-sm-2 control-label">户籍地址</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="address" name="address" placeholder="地址">
                        </div>
                    </div>


                    <div class="form-group">
                        <label for="personType" class="col-sm-2 control-label">人员类别</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="personType" name="personType" placeholder="人员类别">
                        </div>
                        <label for="controlName" class="col-sm-2 control-label">布控人姓名</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="controlName" name="controlName" placeholder="布控人姓名">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="controlPersonUnit" class="col-sm-2 control-label">布控人单位</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="controlPersonUnit" name="controlPersonUnit" placeholder="布控人单位">
                        </div>
                        <label for="controlUnit" class="col-sm-2 control-label">布控单位</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="controlUnit" name="controlUnit" placeholder="布控单位">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="controlTel" class="col-sm-2 control-label">联系方式</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="controlTel" name="controlTel" placeholder="联系方式">
                        </div>
                        <label for="remark" class="col-sm-2 control-label">备注</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="remark" name="remark" placeholder="备注">
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