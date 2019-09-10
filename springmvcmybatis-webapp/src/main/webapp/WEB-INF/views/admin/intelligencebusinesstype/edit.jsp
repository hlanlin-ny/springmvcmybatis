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
                        <label for="name" class="col-sm-2 control-label">名称</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="name" name="name" placeholder="名称">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="parentName" class="col-sm-2 control-label">上级分类</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="parentName" name="parentName"
                                   placeholder="上级分类。请点击这里进行选择" style="cursor:pointer;" readonly="readonly" required>
                            <input type="hidden" class="form-control" id="parentId" name="parentId">
                        </div>
                    </div>

                    <%--<div class="form-group">--%>
                    <%--<label for="areaCode" class="col-sm-2 control-label">行政区划编码</label>--%>
                    <%--<div class="col-sm-10">--%>
                    <input type="hidden" class="form-control" id="areaId" name="areaId"
                           value="<myshiro:currentAreaId/>">
                    <%--</div>--%>
                    <%--</div>--%>

                    <div class="form-group">
                        <label for="icon" class="col-sm-2 control-label">图标</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="icon" name="icon" placeholder="图标。格式：fa fa-key">
                            <span class="help-block">用于时间轴展现，获取图标：http://fontawesome.io/icons/</span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="backgroundColor" class="col-sm-2 control-label">背景色</label>
                        <div class="col-sm-10">
                            <select class="form-control" id="backgroundColor" name='backgroundColor'>
                                <option value="">无</option>
                                <option value="bg-red">红色</option>
                                <option value="bg-fuchsia">紫红色</option>
                                <option value="bg-maroon">褐红色</option>
                                <option value="bg-yellow">黄色</option>
                                <option value="bg-blue">蓝色</option>
                                <option value="bg-light-blue">浅蓝色</option>
                                <option value="bg-navy">深蓝色</option>
                                <option value="bg-green">绿色</option>
                                <option value="bg-teal">水绿色</option>
                                <option value="bg-olive">橄榄绿色</option>
                                <option value="bg-lime">青柠色</option>
                                <option value="bg-orange">橙色</option>
                                <option value="bg-purple">紫色</option>
                                <option value="bg-black">黑色</option>
                            </select>
                            <span class="help-block">用于时间轴展现</span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="icon-view" class="col-sm-2 control-label">图标预览</label>
                        <div class="col-sm-10">
                            <i id="icon-view" class=""></i>
                            <%--<span class="help-block">时间轴图标展现方式预览</span>--%>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="orderNum" class="col-sm-2 control-label">排序</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="orderNum" name="orderNum" placeholder="排序">
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