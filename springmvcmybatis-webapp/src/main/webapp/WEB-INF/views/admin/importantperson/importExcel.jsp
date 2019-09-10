<%--
  Created by IntelliJ IDEA.
  User: 87796
  Date: 2017/9/16
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--edit model -->
<div id="import-modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="edit-modal-label" aria-hidden="true"
     data-backdrop="static">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">×</span>
        </button>
        <h4 class="modal-title" id="import-excel-label">导入重点人员信息</h4>
      </div>

      <!-- form start -->
      <form id="import-form"  name="import-form" class="form-horizontal" enctype="multipart/form-data" action="${ctxPath}/admin/importantperson/batch/import" method="post">

        <div class="modal-body">

          <div class="form-group">
            <label for="excel_file" class="col-sm-2 control-label" >选择文件</label>
            <div class="col-sm-5">
                <input id="excel_file" type="file" name="filename" size="80" accept=".xls,.xlsx"/>
              <span style="color:#a9a9a9">只支持&nbsp;&nbsp;xlsx, xls 文件格式导入 </span>
            </div>
            <div class="col-sm-4">
              <button id="btn-upload" type="button" class="btn btn-primary">
                <i class="fa fa-upload"></i> 上 传
              </button>
            </div>

          </div>
        </div>
      </form>
      <!-- form start -->
      <form id="excel-download" action="${ctxPath}/admin/importantperson/template/download" name="excel-download" class="form-horizontal" method="post">

        <div class="modal-body">

          <div class="form-group">
            <label for="excel-download" class="col-sm-2 control-label">EXCEL模板下载</label>
            <div class="col-sm-4">
              <button id="btn-down" type="button" class="btn btn-primary" onclick="document.getElementById('excel-download').submit()">
              <i class="fa fa-download"></i> 下 载
            </button>
            </div>
          </div>
        </div>
      </form>

    </div>
    <!-- /.modal-content -->
  </div>
  <!-- /.modal-dialog -->
</div>
