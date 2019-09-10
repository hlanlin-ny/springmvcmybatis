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
                        <label for="zy" class="col-sm-2 control-label">职业</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="zy" name="zy" placeholder="职业"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="fwcs" class="col-sm-2 control-label">工作单位</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="fwcs" name="fwcs" placeholder="工作单位"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="yyDwmc" class="col-sm-2 control-label">医院单位名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="yyDwmc" name="yyDwmc" placeholder="医院单位名称"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="ybzZjhm" class="col-sm-2 control-label">医保征证件号码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="ybzZjhm" name="ybzZjhm" placeholder="医保征证件号码"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="ksDwmc" class="col-sm-2 control-label">科室单位名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="ksDwmc" name="ksDwmc" placeholder="科室单位名称"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="ysXm" class="col-sm-2 control-label">医生姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="ysXm" name="ysXm" placeholder="医生姓名"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="ryzdJyqk" class="col-sm-2 control-label">入院诊断</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="ryzdJyqk" name="ryzdJyqk" placeholder="入院诊断"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="cyrq" class="col-sm-2 control-label">出院日期</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="cyrq" name="cyrq" placeholder="出院日期"/>
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