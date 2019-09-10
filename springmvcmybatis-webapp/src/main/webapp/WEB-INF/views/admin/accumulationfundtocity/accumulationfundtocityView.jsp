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
                            <input type="text" class="form-control" id="xb" name="xb" placeholder="性别"
                                   readonly required minlength="2"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="zjhm" class="col-sm-2 control-label">身份证号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="zjhm" name="zjhm" readonly placeholder="身份证号"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="xzzDzmc" class="col-sm-2 control-label">住所地址名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="xzzDzmc" name="xzzDzmc" placeholder="住所地址名称"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="fwcs" class="col-sm-2 control-label">工作单位</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="fwcs" name="fwcs" placeholder="工作单位"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="djdwGajgmc" class="col-sm-2 control-label">所属公安机关名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="djdwGajgmc" name="djdwGajgmc" placeholder="所属公安机关名称"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="djsj" class="col-sm-2 control-label">登记日期</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="djsj" name="djsj" placeholder="登记日期"/>
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