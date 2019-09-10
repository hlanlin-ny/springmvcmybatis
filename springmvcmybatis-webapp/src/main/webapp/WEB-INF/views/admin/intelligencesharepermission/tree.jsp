<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--tree-modal -->
<div id="tree-modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="tree-modal-label"
     aria-hidden="true"
     data-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="tree-modal-label">请选择</h4>
            </div>

            <div class="modal-body">
                <div id="tree-layer">
                    <ul id="menuTree" class="ztree"></ul>
                </div>
            </div>

            <div class="modal-footer">
                <div class="pull-right">
                    <button id="btn-tree-modal-confirm" type="submit" class="btn btn-primary"><i
                            class="glyphicon glyphicon-ok"></i> 确 定
                    </button>
                    <button id="btn-cancel" type="button" class="btn btn-default" data-dismiss="modal"><i
                            class="glyphicon glyphicon-remove"></i> 取 消
                    </button>
                </div>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>