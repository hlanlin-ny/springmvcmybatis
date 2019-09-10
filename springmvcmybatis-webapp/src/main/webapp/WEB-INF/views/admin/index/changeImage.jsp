<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--edit model -->
<div id="image-modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="image-modal-label" aria-hidden="true"
     data-backdrop="static">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">×</span>
        </button>
        <h4 class="modal-title" id="import-excel-label">背景图片更换</h4>
      </div>
      <form role="form" id="img-form" name="img-form">
        <div class="modal-body">
          <div class="form-group">
            <label for="backgroundImage">当前背景图片</label>
            <img id="image" class="form-control" style="height: 120px;width: 240px"/>
          </div>
          <br>
          <div class="form-group">
            <label for="backgroundImage">背景图片选择</label>
            <input type="file" id="backgroundImage" name="bgImageFile" class="form-control"/>
            <p class="help-block">背景图片大小设定在1800*850像素</p>
          </div>
        </div>
        <div class="modal-footer">
          <div class="pull-right">
            <button type="button" class="btn btn-primary" id="changeBgImg">更换</button>
          </div>
        </div>
      </form>
    </div>
    <!-- /.modal-content -->
  </div>
  <!-- /.modal-dialog -->
</div>
