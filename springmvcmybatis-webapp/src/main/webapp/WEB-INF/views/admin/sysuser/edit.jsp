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
                        <label for="realName" class="col-sm-2 control-label">姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="realName" name="realName" placeholder="姓名"
                                   required minlength="2" maxlength="50">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="username" class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="username" name="username" placeholder="用户名"
                                   required minlength="4" maxlength="20">
                        </div>
                    </div>
                    <div class="form-group" id="password-area">
                        <label for="password" class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="password" name="password" placeholder="密码" required minlength="6" maxlength="20">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="isAdmin" class="col-sm-2 control-label">管理员</label>
                        <div class="col-sm-10">
                            <select class="form-control" id="isAdmin" name='isAdmin'>
                                <option value="0">否</option>
                                <option value="1">是</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="tree-layer" class="col-sm-2 control-label">行政区划</label>
                        <div class="col-sm-10">
                            <div id="tree-layer" class="box box-solid">
                                <div class="box-body">
                                    <ul id="menuTree" class="ztree"></ul>
                                </div>
                            </div>
                        </div>
                        <input type="hidden" class="form-control" id="userDepartmentId" name="userDepartmentId">
                    </div>
                    <div class="form-group">
                        <label for="userRoleIds" class="col-sm-2 control-label">角色</label>
                        <div class="col-sm-10">
                            <div class="checkbox" id="userRoleList">
                            </div>
                            <%--<select class="form-control" id="userRoleId" name='userRoleId'>--%>
                            <%--</select>--%>
                            <input type="hidden" class="form-control" id="userRoleIds" name="userRoleIds">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="mobile" class="col-sm-2 control-label">手机</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="mobile" name="mobile" placeholder="手机">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email" class="col-sm-2 control-label">邮箱</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control" id="email" name="email" placeholder="邮箱">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="activated" class="col-sm-2 control-label">激活</label>
                        <div class="col-sm-10">
                            <select class="form-control" id="activated" name='activated'>
                                <option value="1">已激活</option>
                                <option value="0">未激活</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="locked" class="col-sm-2 control-label">锁定</label>
                        <div class="col-sm-10">
                            <select class="form-control" id="locked" name='locked'>
                                <option value="0">正常</option>
                                <option value="1">锁定</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="disabled" class="col-sm-2 control-label">禁用</label>
                        <div class="col-sm-10">
                            <select class="form-control" id="disabled" name='disabled'>
                                <option value="0">正常</option>
                                <option value="1">禁用</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="remark" class="col-sm-2 control-label">备注</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" rows="3" id="remark" name='remark' placeholder="备注"></textarea>
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
<!-- /.modal -->