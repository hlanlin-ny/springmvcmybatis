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
                        <label for="sfhm" class="col-sm-2 control-label">身份号码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="sfhm" name="sfhm" placeholder="身份号码"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="Lxdh" class="col-sm-2 control-label">联系电话</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="Lxdh" name="Lxdh" placeholder="联系电话"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="Dwmc" class="col-sm-2 control-label">户籍地址</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="Dwmc" name="Dwmc" placeholder="户籍地址"/>
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