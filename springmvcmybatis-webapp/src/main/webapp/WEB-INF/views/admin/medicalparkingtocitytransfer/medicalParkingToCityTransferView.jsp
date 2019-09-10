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
                        <label for="tccbh" class="col-sm-2 control-label">停车场编号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="tccbh" name="tccbh" placeholder="停车场编号"
                                  readonly required minlength="2"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="fxfs" class="col-sm-2 control-label">放行方式</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="fxfs" name="fxfs" readonly placeholder="放行方式"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="gcbh" class="col-sm-2 control-label">过车编号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="gcbh" name="gcbh" placeholder="过车编号"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="csysdm" class="col-sm-2 control-label">车身颜色代码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="csysdm" name="csysdm" placeholder="车身颜色代码"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="jcSj" class="col-sm-2 control-label">进场时间</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="jcSj" name="jcSj" placeholder="进场时间"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="ccSj" class="col-sm-2 control-label">出场时间</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="ccSj" name="ccSj" placeholder="出场时间"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="jczt" class="col-sm-2 control-label">进出状态</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="jczt" name="jczt" placeholder="进出状态"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="cpys" class="col-sm-2 control-label">车牌颜色</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="cpys" name="cpys" placeholder="车牌颜色"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="jdccllxdm" class="col-sm-2 control-label">车辆类型</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="jdccllxdm" name="jdccllxdm" placeholder="车辆类型"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="jdchphm" class="col-sm-2 control-label">号牌号码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="jdchphm" name="jdchphm" placeholder="号牌号码"/>
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