<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--edit model -->
<div id="edit-modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="edit-modal-label"
     aria-hidden="true"
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
                        <label for="beanName" class="col-sm-3 control-label">类名</label>

                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="beanName" name="beanName" placeholder="类名"
                                   required minlength="2">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="methodName" class="col-sm-3 control-label">方法名</label>

                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="methodName" name="methodName" placeholder="方法名"
                                   required minlength="2">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="params" class="col-sm-3 control-label">参数</label>

                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="params" name="params" placeholder="参数">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="cronExpression" class="col-sm-3 control-label">CRON表达式</label>

                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="cronExpression" name="cronExpression"
                                   placeholder="CRON表达式"
                                   required minlength="2">
                        </div>
                    </div>

                    <div class="form-group">
                    <label for="params" class="col-sm-3 control-label">定时任务类别</label>

                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="scheduleType" name="scheduleType" placeholder="定时任务类别">
                    </div>
                </div>

                    <div class="form-group">
                        <label for="status" class="col-sm-3 control-label">状态</label>
                        <div class="col-sm-9">
                            <select class="form-control" id="status" name='status'>
                                <option value="0">正常</option>
                                <option value="1">暂停</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="remark" class="col-sm-3 control-label">备注</label>

                        <div class="col-sm-9">
                            <textarea class="form-control" rows="3" id="remark" name='remark'
                                      placeholder="备注"></textarea>
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