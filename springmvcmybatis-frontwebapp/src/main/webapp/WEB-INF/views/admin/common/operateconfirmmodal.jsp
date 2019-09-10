<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- delete Confirm Modal --%>
<div class="modal fade" id="operate-confirm-modal" tabindex="-1" role="dialog" aria-labelledby="operate-confirm-form-label"
     aria-hidden="true" data-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="operate-confirm-form-label">确认框</h4>
            </div>
            <div class="modal-body">
                你确定要执行吗？
                <%-- form start --%>
                <form id="operate-confirm-form" name="operate-confirm-form" class="form-horizontal">
                    <input type="hidden" class="form-control" id="ids-to-operate-confirm" name="ids-to-operate-confirm">
                    <input type="hidden" class="form-control" id="type-to-operate-confirm" name="type-to-operate-confirm">
                </form>
            </div>
            <div class="modal-footer">

                <div class="pull-right">
                    <button id="btn-operate-confirm" type="button" class="btn btn-primary"><i
                            class="glyphicon glyphicon-ok"></i> 确 定
                    </button>
                    <button type="button" class="btn btn-default" data-dismiss="modal"><i
                            class="glyphicon glyphicon-remove"></i> 取 消
                    </button>
                </div>
            </div>
        </div>
        <%-- /.modal-content --%>
    </div>
    <%-- /.modal-dialog --%>
</div>
<%-- /.modal --%>