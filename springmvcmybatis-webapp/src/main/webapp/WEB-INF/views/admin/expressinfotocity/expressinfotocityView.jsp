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
                        <label for="YDH" class="col-sm-2 control-label">运单号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="YDH" name="YDH" placeholder="运单号"
                                  readonly required minlength="2"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="wlzx_DWMC" class="col-sm-2 control-label">快递公司单位名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="wlzx_DWMC" name="wlzx_DWMC" placeholder="快递公司单位名称"
                                   readonly required minlength="2"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="fahr_XM" class="col-sm-2 control-label">寄件人姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="fahr_XM" name="fahr_XM" placeholder="寄件人姓名"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="fahr_ZJHM" class="col-sm-2 control-label">寄件人证件号码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="fahr_ZJHM" name="fahr_ZJHM" placeholder="寄件人证件号码"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="fahr_LXDH" class="col-sm-2 control-label">寄件人联系电话</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="fahr_LXDH" name="fahr_LXDH" placeholder="寄件人联系电话"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="FHSJ" class="col-sm-2 control-label">寄件时间</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="FHSJ" name="FHSJ" placeholder="寄件时间"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="shhr_XM" class="col-sm-2 control-label">收件人姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="shhr_XM" name="shhr_XM" placeholder="收件人姓名"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="shhr_ZJHM" class="col-sm-2 control-label">收件人证件号码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="shhr_ZJHM" name="shhr_ZJHM" placeholder="收件人证件号码"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="shhr_LXDH" class="col-sm-2 control-label">收件人联系电话</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="shhr_LXDH" name="shhr_LXDH" placeholder="收件人联系电话"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="SHSJ" class="col-sm-2 control-label">收货时间</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="SHSJ" name="SHSJ" placeholder="收货时间"/>
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