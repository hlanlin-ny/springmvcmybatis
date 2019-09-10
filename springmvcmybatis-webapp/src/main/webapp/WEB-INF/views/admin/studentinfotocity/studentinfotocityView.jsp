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
                            <input type="text" class="form-control" id="xb" name="xb" placeholder="性别"
                                   readonly required minlength="2"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="gmsfhm" class="col-sm-2 control-label">身份号码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="gmsfhm" name="gmsfhm" placeholder="身份号码"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="lxdh" class="col-sm-2 control-label">联系电话</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="lxdh" name="lxdh" placeholder="联系电话"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="jtzzDzmc" class="col-sm-2 control-label">家庭住址</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="jtzzDzmc" name="jtzzDzmc" placeholder="家庭住址"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="xz" class="col-sm-2 control-label">学制</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="xz" name="xz" placeholder="学制"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="xxmc" class="col-sm-2 control-label">学校名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="xxmc" name="xxmc" placeholder="职业资格名称"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="xh" class="col-sm-2 control-label">学号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="xh" name="xh" placeholder="学号"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="fqXm" class="col-sm-2 control-label">父亲姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="fqXm" name="fqXm" placeholder="父亲_姓名"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="fqZjhhm" class="col-sm-2 control-label">父亲证件号码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="fqZjhhm" name="fqZjhhm" placeholder="父亲证件号码"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="fqLxdh" class="col-sm-2 control-label">父亲联系电话</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="fqLxdh" name="fqLxdh" placeholder="父亲联系电话"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="mqXm" class="col-sm-2 control-label">母亲姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="mqXm" name="mqXm" placeholder="母亲_姓名"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="mqZjhhm" class="col-sm-2 control-label">母亲证件号码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="mqZjhhm" name="mqZjhhm" placeholder="母亲证件号码"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="mqLxdh" class="col-sm-2 control-label">母亲联系电话</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="mqLxdh" name="mqLxdh" placeholder="母亲联系电话"/>
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