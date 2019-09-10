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
                    <%--<label for="areaCode" class="col-sm-3 control-label">行政区划编码</label>--%>
                    <%--<div class="col-sm-9">--%>
                    <input type="hidden" class="form-control" id="areaId" name="areaId" value="<myshiro:currentAreaId/>">
                    <%--</div>--%>
                    <%--</div>--%>
                                            
                    <div class="form-group">
                        <label for="companyId" class="col-sm-3 control-label">所属公司</label>
                        <div class="col-sm-9">
                            <select class="form-control select2" id="companyId" name="companyId"  style="width: 100%;"></select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="branchName" class="col-sm-3 control-label">网点名称</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="branchName" name="branchName" placeholder="网点名称" required>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="address" class="col-sm-3 control-label">网点地址</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="address" name="address" placeholder="网点地址" required>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="policeOffice" class="col-sm-3 control-label">所属公安机关</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="policeOffice" name="policeOffice" placeholder="所属公安机关" required>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="username" class="col-sm-3 control-label">用户名</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="username" name="username" placeholder="用户名" required>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="password" class="col-sm-3 control-label">密码</label>
                        <div class="col-sm-9">
                            <input type="password" class="form-control" id="password" name="password" placeholder="密码" required>
                        </div>
                    </div>

                    <%--<div class="form-group">--%>
                    <%--<label for="seckey" class="col-sm-3 control-label">密钥</label>--%>
                    <%--<div class="col-sm-9">--%>
                    <%--<input type="text" class="form-control" id="seckey" name="seckey" placeholder="密钥" readonly>--%>
                    <%--</div>--%>
                    <%--</div>--%>


                    <div class="form-group">
                        <label for="contactPerson" class="col-sm-3 control-label">联系人</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="contactPerson" name="contactPerson" placeholder="联系人">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="contactPhone" class="col-sm-3 control-label">联系电话</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="contactPhone" name="contactPhone" placeholder="联系电话">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="emergencyContactPerson" class="col-sm-3 control-label">紧急联系人</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="emergencyContactPerson" name="emergencyContactPerson" placeholder="紧急联系人">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="emergencyContactPhone" class="col-sm-3 control-label">紧急联系电话</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="emergencyContactPhone" name="emergencyContactPhone" placeholder="紧急联系电话">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="disabled" class="col-sm-3 control-label">状态</label>
                        <div class="col-sm-9">
                            <select class="form-control" id="disabled" name='disabled'>
                                <option value="false">正常</option>
                                <option value="true">禁用</option>
                            </select>
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="remark" class="col-sm-3 control-label">备注</label>
                        <div class="col-sm-9">
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