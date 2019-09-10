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


                    <%--<div class="form-group">--%>
                    <%--<label for="areaCode" class="col-sm-2 control-label">行政区划编码</label>--%>
                    <%--<div class="col-sm-10">--%>
                    <input type="hidden" class="form-control" id="areaId" name="areaId" value="<myshiro:currentAreaId/>">
                    <%--</div>--%>
                    <%--</div>--%>
                                            
                    <div class="form-group">
                        <label for="businessTypeId" class="col-sm-2 control-label">情报业务分类ID</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="businessTypeId" name="businessTypeId" placeholder="情报业务分类ID">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="fileType" class="col-sm-2 control-label">文件类型（1：结构化数据；2：word文件；3：ppt文件；4：excel文件；5：txt文件；6：csv文件；7：pdf文件；8：图片文件；9：音频文件；10：视频文件；）</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="fileType" name="fileType" placeholder="文件类型（1：结构化数据；2：word文件；3：ppt文件；4：excel文件；5：txt文件；6：csv文件；7：pdf文件；8：图片文件；9：音频文件；10：视频文件；）">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="detailsUrl" class="col-sm-2 control-label">文件上传路径</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="detailsUrl" name="detailsUrl" placeholder="文件上传路径">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="collectTime" class="col-sm-2 control-label">收集时间</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="collectTime" name="collectTime" placeholder="收集时间">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="esIndexName" class="col-sm-2 control-label">插入es的时候用的es的索引名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="esIndexName" name="esIndexName" placeholder="插入es的时候用的es的索引名称">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="userId" class="col-sm-2 control-label">所属用户编号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="userId" name="userId" placeholder="所属用户编号">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="senderIdCardNum" class="col-sm-2 control-label">发件人身份证号码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="senderIdCardNum" name="senderIdCardNum" placeholder="发件人身份证号码">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="senderName" class="col-sm-2 control-label">发件人姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="senderName" name="senderName" placeholder="发件人姓名">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="senderPhone" class="col-sm-2 control-label">发件人电话</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="senderPhone" name="senderPhone" placeholder="发件人电话">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="receiverName" class="col-sm-2 control-label">收件人姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="receiverName" name="receiverName" placeholder="收件人姓名">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="receiverPhone" class="col-sm-2 control-label">收件人电话</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="receiverPhone" name="receiverPhone" placeholder="收件人电话">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="receiverAddress" class="col-sm-2 control-label">收件人地址</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="receiverAddress" name="receiverAddress" placeholder="收件人地址">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="goodsName" class="col-sm-2 control-label">货物名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="goodsName" name="goodsName" placeholder="货物名称">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="remark" class="col-sm-2 control-label">备注</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="remark" name="remark" placeholder="备注">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="isDeleted" class="col-sm-2 control-label">删除状态  0：正常   1：已删除</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="isDeleted" name="isDeleted" placeholder="删除状态  0：正常   1：已删除">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="createdTime" class="col-sm-2 control-label">创建时间</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="createdTime" name="createdTime" placeholder="创建时间">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="createdBy" class="col-sm-2 control-label">创建人</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="createdBy" name="createdBy" placeholder="创建人">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="createdIp" class="col-sm-2 control-label">创建IP</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="createdIp" name="createdIp" placeholder="创建IP">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="modificationTime" class="col-sm-2 control-label">修改时间</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="modificationTime" name="modificationTime" placeholder="修改时间">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="modificationBy" class="col-sm-2 control-label">修改人</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="modificationBy" name="modificationBy" placeholder="修改人">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="modificationIp" class="col-sm-2 control-label">修改人IP</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="modificationIp" name="modificationIp" placeholder="修改人IP">
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