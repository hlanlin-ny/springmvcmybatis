<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--edit model -->
<div id="show-modal" class="modal fade"  tabindex="-1" role="dialog" aria-labelledby="edit-modal-label" aria-hidden="true"
     data-backdrop="static">
    <div >
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="edit-modal-label">情报详情</h4>
            </div>
            <div class="modal-body">
            <div class="box-body no-padding">
                <table id="data-table-show" class="table table-hover table-striped">
                    <thead>
                    <tr>
                        <th>协查标题</th>
                        <th>上报人</th>
                        <th>上报时间</th>
                        <th>情报描述</th>
                        <th>发现时间</th>
                        <th>情报级别</th>
                        <th>奖励状态</th>
                        <th>奖励描述</th>
                        <th>备注</th>
                    </tr>
                    </thead>
                    <tbody></tbody>
                    <tfoot></tfoot>
                </table>
            </div>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>