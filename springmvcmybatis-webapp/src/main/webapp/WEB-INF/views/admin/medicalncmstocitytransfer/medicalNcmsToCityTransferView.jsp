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
                        <label for="csrq" class="col-sm-2 control-label">出生日期</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="csrq" name="csrq" placeholder="出生日期"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="ylkh" class="col-sm-2 control-label">医疗卡号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="ylkh" name="ylkh" placeholder="医疗卡号"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="sfxh" class="col-sm-2 control-label">身份证号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="sfxh" name="sfxh" placeholder="身份证号"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="dz" class="col-sm-2 control-label">地址</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="dz" name="dz" placeholder="地址"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="rklx" class="col-sm-2 control-label">人口类型</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="rklx" name="rklx" placeholder="人口类型"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="xxcjdw" class="col-sm-2 control-label">信息采集单位</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="xxcjdw" name="xxcjdw" placeholder="信息采集单位"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="xxcjsl" class="col-sm-2 control-label">信息采集时间</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="xxcjsl" name="xxcjsl" placeholder="信息采集时间"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="xxxl" class="col-sm-2 control-label">信息细类</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="xxxl" name="xxxl" placeholder="信息细类"/>
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