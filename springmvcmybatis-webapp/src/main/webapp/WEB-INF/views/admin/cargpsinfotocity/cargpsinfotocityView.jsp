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
                        <label for="cph" class="col-sm-2 control-label">车牌号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="cph" name="cph" placeholder="车牌号"
                                  readonly required minlength="2"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="czdh" class="col-sm-2 control-label">车载电话</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="czdh" name="czdh" placeholder="车载电话"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="ssqy" class="col-sm-2 control-label">所属区域</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="ssqy" name="ssqy" placeholder="所属区域"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="dwsj" class="col-sm-2 control-label">定位时间</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="dwsj" name="dwsj" placeholder="定位时间"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="jd" class="col-sm-2 control-label">经度</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="jd" name="jd" placeholder="经度"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="wd" class="col-sm-2 control-label">纬度</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="wd" name="wd" placeholder="纬度"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="sd" class="col-sm-2 control-label">速度</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="sd" name="sd" placeholder="速度"/>
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