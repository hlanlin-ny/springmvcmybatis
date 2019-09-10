<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--edit model -->
<div id="edit-modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="edit-modal-label" aria-hidden="true"
     data-backdrop="static">
    <div class="modal-dialog modal-lg">
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
                        <label for="title" class="col-sm-2 control-label">协查标题</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="title" name="title" placeholder="协查标题">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="intelligenceOfficerId" class="col-sm-2 control-label">上报人</label>
                        <div class="col-sm-10">
                            <select class="form-control select2" id="intelligenceOfficerId" name="intelligenceOfficerId"  style="width: 100%;"></select>
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="reportingTime" class="col-sm-2 control-label">上报时间</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="reportingTime" name="reportingTime" placeholder="上报时间">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="infoDesc" class="col-sm-2 control-label">情报描述</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" id="infoDesc" name="infoDesc" placeholder="情报描述" rows="3"></textarea>
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="foundTime" class="col-sm-2 control-label">发现时间</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="foundTime" name="foundTime" placeholder="发现时间">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="level" class="col-sm-2 control-label">情报级别</label>
                        <div class="col-sm-10">
                            <select class="form-control" id="level" name="level" placeholder="情报级别">
                                <option value=0>一般</option>
                                <option value=1>重要</option>
                                <option value=2>非常重要</option>
                            </select>
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="awardsStatus" class="col-sm-2 control-label">奖励状态</label>
                        <div class="col-sm-10">
                            <select class="form-control" id="awardsStatus" name="awardsStatus" placeholder="奖励状态">
                                <option value=true>已奖励</option>
                                <option value=false>未奖励</option>
                            </select>
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="awardsDesc" class="col-sm-2 control-label">奖励描述</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" id="awardsDesc" name="awardsDesc" placeholder="奖励描述" rows="3"></textarea>
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="remark" class="col-sm-2 control-label">备注</label>
                        <div class="col-sm-10">
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