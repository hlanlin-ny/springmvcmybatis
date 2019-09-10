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
                        <label for="LXSMC" class="col-sm-2 control-label">旅行社单位名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="LXSMC" name="LXSMC" placeholder="旅行社单位名称"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="MDD_DZMC" class="col-sm-2 control-label">目的地</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="MDD_DZMC" name="MDD_DZMC" placeholder="目的地"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="CFSJ" class="col-sm-2 control-label">出发时间</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="CFSJ" name="CFSJ" placeholder="出发时间"/>
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