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
                        <label for="sfzh" class="col-sm-2 control-label">身份号码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="sfzh" name="sfzh" placeholder="身份号码"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="lxdh" class="col-sm-2 control-label">联系电话</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="lxdh" name="lxdh" placeholder="联系电话"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="xzddzmc" class="col-sm-2 control-label">家庭住址</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="xzddzmc" name="xzddzmc" placeholder="家庭住址"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="blsj" class="col-sm-2 control-label">办理时间</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="blsj" name="blsj" placeholder="办理时间"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="bldzdzmc" class="col-sm-2 control-label">办理地址名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="bldzdzmc" name="bldzdzmc" placeholder="办理地址名称"/>
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