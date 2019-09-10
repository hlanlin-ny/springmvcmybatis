<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/WEB-INF/views/admin/common/basecss.jsp" %>
    <%-- iCheck for checkboxes and radio inputs --%>
    <link rel="stylesheet" href="${ctxPath}/resources/plugins/iCheck/all.css">
    <%-- jQuery validation --%>
    <link rel="stylesheet" href="${ctxPath}/resources/plugins/jquery-validation/validation.css">
    <link rel="icon" href="${ctxPath}/resources/dist/img/favicon.ico" type="image/x-icon" />
    <link rel="shortcut icon" href="${ctxPath}/resources/dist/img/favicon.png" type="image/x-icon" />
    <title>情报管理大数据平台</title>
    <style>
        .main {
            min-width: 980px;
            height: 100%;
            background: url(${ctxPath}/resources/dist/img/many.jpg) center 0 repeat-y;
        }

        .all {
            position: relative;
            height: 100%;
            background: url(${ctxPath}/resources/dist/img/center.jpg) center 0 no-repeat;
            min-height: 880px;
        }
    </style>
</head>

<div class="main">
    <div class="all">
        <!-- 浏览器使用提示 -->
        <!--[if lt IE 9]>
        <div class="row">
            <div class="col-md-12">
                <div class="box box-default">
                    <div class="box-header with-border">
                        <i class="fa fa-warning"></i>

                        <h3 class="box-title">系统提示</h3>
                    </div>
                    <div class="box-body">
                        <div class="alert alert-danger alert-dismissible">
                            <h4><i class="icon fa fa-ban"></i>您的浏览器版本太低，请使用最新版本的浏览器</h4>
                            请使用 谷歌浏览器（ <strong><a href="{ctxPath}/resources/ChromeStandalone_60.0.3112.101_Setup.exe" target="_blank">点击下载</a></strong> ）、360浏览器【极速模式】（ <strong><a href="{ctxPath}/resources/360se_setup.exe" target="_blank">点击下载</a></strong> ）或 火狐浏览器（ <strong><a href="{ctxPath}/resources/Firefox-58.0.2.6611-setup.exe" target="_blank">点击下载</a></strong> ）或！
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <![endif]-->

        <div class="login-box" style="padding-top: 200px;color: #FFFFFF;">
            <div class="login-logo">
                <b>情报管理大数据平台</b>
            </div>
            <div class="box" style="border-radius: 3px; background:url(${ctxPath}/resources/dist/img/bg01.png);">
                <!-- /.login-logo -->
                <div class="login-box-body" style="margin:0 10px;color: #FFFFFF;">
                    <p class="login-box-msg">系统登录</p>

                    <div class="alert alert-danger alert-dismissible"
                         style="display: none;" id="login-message">
                        <h5>
                            <i class="icon fa fa-ban"></i> 系统提醒
                        </h5>

                        <div id="login-message-content"></div>
                    </div>
                    <form id="login-form">
                        <input type="hidden" name="${_csrf.parameterName}"
                               value="${_csrf.token}"/>

                        <div class="form-group has-feedback">
                            <input type="text" class="form-control" placeholder="用户名"
                                   id="username" name="username" required minlength="5" value="">
                        </div>
                        <div class="form-group has-feedback">
                            <input type="password" class="form-control" placeholder="密码"
                                   id="password" name="password" required minlength="6"
                                   maxlength="20" value="">
                        </div>
                        <%--<div class="form-group has-feedback">--%>
                        <%--<input type="text" class="form-control" placeholder="验证码" id="captcha" name="captcha" required minlength="5" maxlength="5" value="12345">--%>
                        <%--</div>--%>
                        <%--<div class="form-group has-feedback">--%>
                        <%--<div class="col-sm-8">--%>
                        <%--<img alt="如果看不清楚，请单击图片刷新！" class="pointer" src="${ctxPath}/captcha.html" id="captcha-img">--%>
                        <%--</div>--%>
                        <%--<div class="col-sm-4">--%>
                        <%--<a id="captcha-img-refersh" href="javascript:;">点击刷新</a>--%>
                        <%--</div>--%>
                        <%--</div>--%>
                        <div class="row">
                            <div class="col-xs-8">
                                <div class="checkbox icheck">
                                    <label> <input type="checkbox" id="rememberMe" name="rememberMe">
                                        自动登录 </label>
                                </div>
                            </div>
                            <!-- /.col -->
                            <div class="col-xs-4 pull-right">
                                <button id="btn-submit" type="submit"
                                        class="btn btn-primary btn-block">登 录
                                </button>
                            </div>
                            <!-- /.col -->
                        </div>
                    </form>

                    <%--<a href="#">忘记密码</a><br>--%>
                    <%--<a href="${ctxPath}/admin/register.html" class="text-center">注册新用户</a>--%>

                </div>
                <!-- /.login-box-body -->
            </div>
        </div>
    </div>
</div>

<!-- /.login-box -->
<%@ include file="/WEB-INF/views/admin/common/basejs.jsp" %>
<%-- iCheck 1.0.1 --%>
<script src="${ctxPath}/resources/plugins/iCheck/icheck.min.js"></script>
<%@ include file="/WEB-INF/views/admin/login/js.jsp" %>
</body>
</html>