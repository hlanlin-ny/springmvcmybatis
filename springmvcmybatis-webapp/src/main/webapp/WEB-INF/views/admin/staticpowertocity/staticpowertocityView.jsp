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
                        <label for="XM" class="col-sm-2 control-label">姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="XM" name="XM" placeholder="姓名"
                                  readonly required minlength="2"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="GMSFHM" class="col-sm-2 control-label">身份号码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="GMSFHM" name="GMSFHM" placeholder="身份号码"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="YDDH" class="col-sm-2 control-label">联系电话</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="YDDH" name="YDDH" placeholder="联系电话"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="YDDZ" class="col-sm-2 control-label">用电地址</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="YDDZ" name="YDDZ" placeholder="户籍地址"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="JSRQ" class="col-sm-2 control-label">缴费日期</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="JSRQ" name="JSRQ" placeholder="职业资格名称"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="DWMC" class="col-sm-2 control-label">单位名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="DWMC" name="DWMC" placeholder="单位名称"/>
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