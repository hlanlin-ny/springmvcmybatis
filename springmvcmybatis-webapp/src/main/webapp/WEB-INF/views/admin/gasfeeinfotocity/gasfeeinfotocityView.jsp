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
                        <label for="METCARDNAME" class="col-sm-2 control-label">姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="METCARDNAME" name="METCARDNAME" placeholder="姓名"
                                  readonly required minlength="2"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="SHOULDEARN" class="col-sm-2 control-label">消费金额</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="SHOULDEARN" name="SHOULDEARN" placeholder="消费金额"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="ACTUALEARN" class="col-sm-2 control-label">缴费金额</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="ACTUALEARN" name="ACTUALEARN" placeholder="缴费金额"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="CHARGETIME" class="col-sm-2 control-label">缴费时间</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="CHARGETIME" name="CHARGETIME" placeholder="缴费时间"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="ACCOUNT_CUBE" class="col-sm-2 control-label">气量</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="ACCOUNT_CUBE" name="ACCOUNT_CUBE" placeholder="气量"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="METERED_CUBE" class="col-sm-2 control-label">本次抄表气量</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="METERED_CUBE" name="METERED_CUBE" placeholder="本次抄表气量"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="METERED_TIME" class="col-sm-2 control-label">本次抄表时间</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="METERED_TIME" name="METERED_TIME" placeholder="本次抄表时间"/>
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