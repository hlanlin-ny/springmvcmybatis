<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--edit model -->
<div id="change-password-modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="edit-modal-label"
     aria-hidden="true"
     data-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="edit-modal-label">修改密码</h4>
            </div>

            <!-- form start -->
            <form id="change-password-form" name="edit-form" class="form-horizontal">

                <div class="modal-body">

                    <div class="form-group">
                        <label for="username-show" class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="username-show" name="username-show" readonly="readonly"
                                   placeholder="<shiro:principal/>">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="password" class="col-sm-2 control-label">原密码</label>

                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="password" name="password"
                                   placeholder="原密码"
                                   required minlength="6">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="newPassword" class="col-sm-2 control-label">新密码</label>

                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="newPassword" name="newPassword"
                                   placeholder="新密码"
                                   required minlength="6">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="confirmPassword" class="col-sm-2 control-label">确认密码</label>

                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="confirmPassword" name="confirmPassword"
                                   placeholder="确认密码"
                                   required minlength="6" equalTo="#newPassword">
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