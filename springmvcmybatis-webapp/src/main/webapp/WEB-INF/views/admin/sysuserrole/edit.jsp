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

                    <input type="hidden" class="form-control" id="permissionNames" name="permissionNames">
                    <input type="hidden" class="form-control" id="permissionIds" name="permissionIds">

                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="name" name="name" placeholder="名称"
                                   required minlength="2">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="roleCode" class="col-sm-2 control-label">代码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="roleCode" name="roleCode" placeholder="代码">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="remark" class="col-sm-2 control-label">备注</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" rows="3" id="remark" name='remark' placeholder="备注"></textarea>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="tree-layer" class="col-sm-2 control-label">权限</label>
                        <div class="col-sm-10">
                            <div id="tree-layer" class="box box-solid">
                                <div class="box-body">
                                    <ul id="menuTree" class="ztree"></ul>
                                </div>
                            </div>
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