<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/listtop.jsp" %>

<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        系统设置
        <small></small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="${ctxPath}/admin/index/index.html"><i class="fa fa-home"></i> 首页</a></li>
        <li class="active">系统管理</li>
        <li class="active">系统设置</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">


    <div class="row">
        <div class="col-md-6">
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">背景图片设置</h3>
                    <div class="pull-right">
                        <button type="button" class="btn btn-primary" id="changeBgImg">更换</button>
                    </div>
                </div>
                <form role="form" id="img-form" name="img-form">
                    <div class="box-body">
                        <div class="form-group">
                            <label for="backgroundImage">背景图片选择</label>
                            <input type="file" id="backgroundImage" name="bgImageFile">
                            <p class="help-block">选择图片设置成功后，刷新首页即可更换背景</p>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>


    <div class="row">
        <div class="col-md-6">
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">预警音乐设置</h3>
                    <div class="pull-right">
                        <button type="button" class="btn btn-primary" id="warningMusicChange">更换</button>
                    </div>
                </div>
                <form role="form" id="warning-change" name="warning-form">
                    <div class="box-body">
                        <div class="form-group">
                            <label for="backgroundImage">音乐选择</label>
                            <input type="file" id="musicWarning" name="musicFile">
                            <p class="help-block">该音乐为预警时报警音乐</p>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <%--<div class="row">--%>
        <%--<div class="col-md-6">--%>
            <%--<div class="box box-primary">--%>
                <%--<div class="box-header with-border">--%>
                    <%--<h3 class="box-title">背景音乐设置</h3>--%>
                    <%--<div class="pull-right">--%>
                        <%--<button type="button" class="btn btn-primary" id="bgMusicChange">更换</button>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<form role="form" id="bg-change">--%>
                    <%--<div class="box-body">--%>
                        <%--<div class="form-group">--%>
                            <%--<label for="backgroundImage">音乐选择</label>--%>
                            <%--<input type="file" id="bgWarning" name="bgMusicFile">--%>
                            <%--<p class="help-block">该音乐为预警时报警音乐</p>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</form>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>

</section>
<!-- /.content -->
<%@ include file="/WEB-INF/views/admin/common/operateconfirmmodal.jsp" %>

<!-- js -->
<%@ include file="/WEB-INF/views/admin/sysconfig/js.jsp" %>

<%@ include file="/WEB-INF/views/admin/common/listbottom.jsp" %>