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
                <h4 class="modal-title" id="edit-modal-label">查看</h4>
            </div>

            <!-- form start -->
            <form id="edit-form" name="edit-form" class="form-horizontal">

                <div class="modal-body">

                    <input type="hidden" class="form-control" id="id" name="id">
                    <div class="form-group">
                        <label for="xm" class="col-sm-2 control-label">姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="xm" name="xm" placeholder="姓名"
                                  readonly required minlength="2"/>
                        </div>

                    </div>
                    <div class="form-group">
                        <label for="xb" class="col-sm-2 control-label">性别</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="xb" name="xb" readonly placeholder="性别"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="mz" class="col-sm-2 control-label">民族</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="mz" name="mz" placeholder="民族"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="xb" class="col-sm-2 control-label">出生日期</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="csrq" name="csrq" placeholder="出生日期"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="cyzjmc" class="col-sm-2 control-label">证件名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="cyzjmc" name="cyzjmc" placeholder="常用证件名称"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="zjhm" class="col-sm-2 control-label">证件号码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="zjhm" name="zjhm" placeholder="证件号码"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="sbkh" class="col-sm-2 control-label">社保卡号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="sbkh" name="sbkh" placeholder="社保卡号"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="bldwDwmc" class="col-sm-2 control-label">办理单位</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="bldwDwmc" name="bldwDwmc" placeholder="办理单位"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="djrXm" class="col-sm-2 control-label">登记人</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="djrXm" name="djrXm" placeholder="登记人"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="djsj" class="col-sm-2 control-label">登记时间</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="djsj" name="djsj" placeholder="登记时间"/>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <div class="pull-right">
                        <button id="btn-cancel" type="button" class="btn btn-default" data-dismiss="modal"><i
                                class="glyphicon glyphicon-remove"></i> 退出
                        </button>
                    </div>
                </div>
            </form>

        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>