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
                        <label for="xfrXm" class="col-sm-2 control-label">信访人姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="xfrXm" name="xfrXm" placeholder="信访人姓名"
                                  readonly required minlength="2"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="sfrq" class="col-sm-2 control-label">信访日期</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="sfrq" name="sfrq" readonly placeholder="信访日期"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="xfrGmsfhm" class="col-sm-2 control-label">信访人身份号码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="xfrGmsfhm" name="xfrGmsfhm" placeholder="信访人身份号码"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="xfrLxdh" class="col-sm-2 control-label">信访人联系电话</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="xfrLxdh" name="xfrLxdh" placeholder="信访人联系电话"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="sldwDwmc" class="col-sm-2 control-label">受理单位</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" readonly id="sldwDwmc" name="sldwDwmc" placeholder="受理单位"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="xfsyJyqk" class="col-sm-2 control-label">信访事由</label>
                        <div class="col-sm-10">
                            <textarea class="form-control"  rows="3" readonly id="xfsyJyqk" name="xfsyJyqk" placeholder="信访事由">

                            </textarea>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="gjxwJyqk" class="col-sm-2 control-label">过激行为</label>
                        <div class="col-sm-10">
                        <textarea class="form-control" rows="3" readonly id="gjxwJyqk" name="gjxwJyqk" placeholder="过激行为">

                        </textarea>
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