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
                        <label for="GDDW" class="col-sm-2 control-label">供电单位</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="GDDW" name="GDDW" placeholder="供电单位"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="HH" class="col-sm-2 control-label">户号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="HH" name="HH" placeholder="户号"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="HM" class="col-sm-2 control-label">户名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="HM" name="HM" placeholder="户名"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="JFJE" class="col-sm-2 control-label">缴费金额</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="JFJE" name="JFJE" placeholder="缴费金额"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="JFSJ" class="col-sm-2 control-label">缴费时间</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="JFSJ" name="JFSJ" placeholder="缴费时间"/>
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