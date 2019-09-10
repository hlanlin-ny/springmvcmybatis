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
                        <label for="businessTypeName" class="col-sm-2 control-label">情报业务类型</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="businessTypeName" name="businessTypeName"
                                   placeholder="情报业务类型。请点击这里进行选择" style="cursor:pointer;" readonly="readonly" required>
                            <input type="hidden" class="form-control" id="businessTypeId" name="businessTypeId">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="fileType" class="col-sm-2 control-label">文件类型</label>

                        <div class="col-sm-10">
                            <select class="form-control" id="fileType" name='fileType'>
                                <option value="1" selected>结构化数据</option>
                                <option value="2">word文件</option>
                                <option value="3">ppt文件</option>
                                <option value="4">excel文件</option>
                                <option value="5">txt文件</option>
                                <option value="6">csv文件</option>
                                <option value="7">pdf文件</option>
                                <option value="8">图片文件</option>
                                <option value="9">音频文件</option>
                                <option value="10">视频文件</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="file1" class="col-sm-2 control-label">文件</label>
                        <div class="col-sm-10">
                            <%--<input type="hidden" class="form-control" id="filename" name="filename" placeholder="文件名称">--%>
                            <input type="file" id="file1" name="files" required>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="fileDesc" class="col-sm-2 control-label">文件内容描述</label>
                        <div class="col-sm-10">
                            <textarea class='form-control' id="fileDesc" name="fileDesc" placeholder="文件内容描述" rows='5'></textarea>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="collectTime" class="col-sm-2 control-label">收集时间</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="collectTime" name="collectTime" placeholder="收集时间" required>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="remark" class="col-sm-2 control-label">备注</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="remark" name="remark" placeholder="备注">
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