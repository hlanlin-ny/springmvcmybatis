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
                        <label for="name" class="col-sm-2 control-label">姓名</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="name" name="name" placeholder="姓名">
                        </div>
                        <label for="sex" class="col-sm-2 control-label">性别</label>
                        <div class="col-sm-4">
                            <select class="form-control" id="sex" name="sex" placeholder="性别">
                                <option value=true>男</option>
                                <option value=false>女</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="idNumbers" class="col-sm-2 control-label">身份证号</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="idNumbers" name="idNumbers" placeholder="身份证号">
                        </div>
                        <label for="birthDate" class="col-sm-2 control-label">出生日期</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="birthDate" name="birthDate" placeholder="出生日期">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="adress" class="col-sm-2 control-label">住址</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="adress" name="adress" placeholder="住址">
                        </div>
                        <label for="hireDate" class="col-sm-2 control-label">入职时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="hireDate" name="hireDate" placeholder="入职时间">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="profession" class="col-sm-2 control-label">职业</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="profession" name="profession" placeholder="职业">
                        </div>
                        <label for="maritalStatus" class="col-sm-2 control-label">婚姻状况</label>
                        <div class="col-sm-4">
                            <select class="form-control" id="maritalStatus" name="maritalStatus" placeholder="婚姻状况">
                                <option value=0>未婚</option>
                                <option value=1>已婚</option>
                                <option value=2>离异</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="phone" class="col-sm-2 control-label">手机号</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="phone" name="phone" placeholder="手机号">
                        </div>
                        <label for="qq" class="col-sm-2 control-label">QQ</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="qq" name="qq" placeholder="QQ">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="wechat" class="col-sm-2 control-label">微信号</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="wechat" name="wechat" placeholder="微信号">
                        </div>
                        <label for="email" class="col-sm-2 control-label">邮箱</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="email" name="email" placeholder="邮箱">
                        </div>
                    </div>
                                            
                    <div class="form-group">
                        <label for="status" class="col-sm-2 control-label">状态</label>
                        <div class="col-sm-4">
                            <select class="form-control" id="status" name="status" placeholder="信息员状态">
                            <option value=0>启用</option>
                            <option value=1>停用</option>
                            <option value=2>失效</option>
                            </select>
                        </div>
                        <label for="belongwechat" class="col-sm-2 control-label">微信群</label>
                        <div class="col-sm-4">
                            <select class="form-control" id="belongwechat" name="belongwechat">

                            </select>

                        </div>
                    </div>

                    <div class="form-group">
                        <label for="isOfficer" class="col-sm-2 control-label">情报员</label>
                        <div class="col-sm-4">
                            <select class="form-control" id="isOfficer" name="isOfficer"/>
                            <option value=true>是</option>
                            <option value=false>否 </option>
                            </select>
                        </div>
                        <label for="remark" class="col-sm-2 control-label">备注</label>
                        <div class="col-sm-4">
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