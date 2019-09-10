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
                            <input type="text" class="form-control" id="name" name="name" placeholder="姓名">
                        </div>
                        <label for="idCardNum" class="col-sm-2 control-label">身份证号码</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="idCardNum" name="idCardNum" placeholder="身份证号码">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="phone" class="col-sm-2 control-label">联系电话</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="phone" name="phone" placeholder="联系电话">
                        </div>
                        <label for="address" class="col-sm-2 control-label">家庭地址</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="address" name="address" placeholder="家庭地址">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="profession" class="col-sm-2 control-label">职业</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="profession" name="profession" placeholder="职业">
                        </div>
                        <label for="organization" class="col-sm-2 control-label">工作单位</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="organization" name="organization" placeholder="工作单位">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="examinationDateime" class="col-sm-2 control-label">体检时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="examinationDateime" name="examinationDateime" placeholder="体检时间">
                        </div>
                        <label for="examinationTerm" class="col-sm-2 control-label">体检项目</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="examinationTerm" name="examinationTerm" placeholder="体检项目">
                        </div>
                    </div>

                    <div class="form-group">
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