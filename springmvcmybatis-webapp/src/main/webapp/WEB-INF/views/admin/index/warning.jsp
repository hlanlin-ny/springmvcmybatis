<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--edit model -->
<div id="warning-modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="edit-modal-label"
     aria-hidden="true"
     data-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="edit-modal-label">当前预警</h4>
            </div>
            <div class="modal-body">
            <div class="row" style="width:600px;">
                <div class="col-md-12">
                    <div class="box">
                        <div class="box-header">
                        </div>
                        <div class="box-body no-padding">
                            <table id="data-table" class="table table-hover table-striped">
                                <thead>
                                <tr>
                                    <th>姓名</th>
                                    <th>预警时间</th>
                                    <th>布控单位</th>
                                    <th>布控联系方式</th>
                                    <th>签收</th>
                                </tr>
                                </thead>
                                <tbody></tbody>
                                <tfoot></tfoot>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            </div>

        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>

