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
                                                        
                    <div class="form-group">
                        <label for="keywords" class="col-sm-3 control-label">关键字</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="keywords" name="keywords" placeholder="关键字">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="tree-layer2" class="col-sm-3 control-label">情报类型</label>
                        <div class="col-sm-8">
                            <input type="hidden" class="form-control" id="businesstypeid" name="businesstypeid" placeholder="情报类型"/>
                            <input type="hidden" class="form-control" id="businesstypename" name="businesstypename" placeholder="情报类型名称"/>
                            <div id="tree-layer2" class="box box-solid">
                                <div class="box-body">
                                    <ul id="menuTree2" class="ztree"></ul>
                                </div>
                            </div>
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="fileTypeList2" class="col-sm-3 control-label">文件类型</label>
                        <div class="col-sm-8">
                                <div class="checkbox" id="fileTypeList2">
                                    <label><input type='checkbox' name='filetypeitem' value="1">结构化数据</label>
                                    <label><input type='checkbox' name='filetypeitem' value="2">word文件</label>
                                    <label><input type='checkbox' name='filetypeitem' value="3">ppt文件</label>
                                    <label><input type='checkbox' name='filetypeitem' value="4">excel文件</label>
                                    <label><input type='checkbox' name='filetypeitem' value="5">txt文件</label>
                                    <label><input type='checkbox' name='filetypeitem' value="6">csv文件</label>
                                    <label><input type='checkbox' name='filetypeitem' value="7">pdf文件</label>
                                    <label><input type='checkbox' name='filetypeitem' value="8">图片文件</label>
                                    <label><input type='checkbox' name='filetypeitem' value="9">音频文件</label>
                                    <label><input type='checkbox' name='filetypeitem' value="10">视频文件</label>
                                </div>
                                <input type="hidden" class="form-control" id="filetype" name="filetype">
                                <input type="hidden" class="form-control" id="filetypename" name="filetypename">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="startTime" class="col-sm-3 control-label">开始时间</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="startTime" name="startTime" placeholder="查询数据开始时间">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="isExactMatching" class="col-sm-3 control-label">是否精确匹配</label>
                        <div class="col-sm-8">
                            <select class="form-control" id="isExactMatching" name="isExactMatching"/>
                            <option value=true>是</option>
                            <option value=false>否 </option>
                            </select>
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="status" class="col-sm-3 control-label">状态</label>
                        <div class="col-sm-8">
                            <select class="form-control" id="status" name="status"/>
                            <option value=0>正常</option>
                            <option value=1>暂停 </option>
                            </select>
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="noticeFrequency" class="col-sm-3 control-label">通知频率(分钟)</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="noticeFrequency" name="noticeFrequency" placeholder="通知频率">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="cronFrequency" class="col-sm-3 control-label">执行频率(分钟)</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="cronFrequency" name="cronFrequency" placeholder="请填写1-59的数字" required>
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="remark" class="col-sm-3 control-label">备注</label>
                        <div class="col-sm-8">
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