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
                        <label for="shareToAreaId" class="col-sm-2 control-label">行政区划</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="shareToAreaName" name="shareToAreaName"
                                   placeholder="行政区划。请点击这里进行选择" style="cursor:pointer;" readonly="readonly">
                            <input type="hidden" class="form-control" id="shareToAreaId" name="shareToAreaId">
                        </div>
                    </div>


                    <div class="form-group">
                        <label for="intelligenceBusinessTypeName" class="col-sm-2 control-label">情报业务类型</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="intelligenceBusinessTypeName" name="intelligenceBusinessTypeName"
                                   placeholder="情报业务类型。请点击这里进行选择" style="cursor:pointer;" readonly="readonly" required>
                            <input type="hidden" class="form-control" id="intelligenceBusinessTypeId" name="intelligenceBusinessTypeId">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="remark" class="col-sm-2 control-label">备注</label>

                        <div class="col-sm-10">
                            <textarea class="form-control" rows="3" id="remark" name='remark'
                                      placeholder="备注"></textarea>
                        </div>
                    </div>

                    <%--<div class="form-group">--%>
                    <%--<label for="areaCode" class="col-sm-2 control-label">行政区划编码</label>--%>
                    <%--<div class="col-sm-10">--%>
                    <input type="hidden" class="form-control" id="areaId" name="areaId" value="<myshiro:currentAreaId/>">
                    <%--</div>--%>
                    <%--</div>--%>

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