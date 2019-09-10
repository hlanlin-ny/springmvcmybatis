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
                        <label for="gmsfhm" class="col-sm-2 control-label">身份证号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="gmsfhm" name="gmsfhm" readonly placeholder="身份证号"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="zsDzmc" class="col-sm-2 control-label">住所地址名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="zsDzmc" name="zsDzmc" placeholder="住所地址名称"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="lxdh" class="col-sm-2 control-label">联系电话</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="lxdh" name="lxdh" placeholder="联系电话"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="gajgmc" class="col-sm-2 control-label">所属公安机关名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="gajgmc" name="gajgmc" placeholder="所属公安机关名称"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="gmRq" class="col-sm-2 control-label">购买日期</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="gmRq" name="gmRq" placeholder="购买日期"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="ddcPp" class="col-sm-2 control-label">电动车品牌</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="ddcPp" name="ddcPp" placeholder="电动车品牌"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="hphm" class="col-sm-2 control-label">号牌号码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="hphm" name="hphm" placeholder="号牌号码"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="csysdm" class="col-sm-2 control-label">车身颜色代码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="csysdm" name="csysdm" placeholder="车身颜色代码"/>
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