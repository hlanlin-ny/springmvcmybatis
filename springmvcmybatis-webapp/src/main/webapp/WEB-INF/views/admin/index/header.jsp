<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="main-header">
    <audio src="${ctxPath}/resources/dist/music/warning.mp3" controls="controls" preload id="music1" hidden>
    </audio>
    <nav class="navbar navbar-static-top"  style="background-image:url('${ctxPath}/resources/dist/img/logo_bg.jpg'); background-repeat:repeat-x">
        <div class="container">
            <div class="navbar-header">
                <a href="${ctxPath}/admin/index/index.html">
                    <img src="${ctxPath}/resources/dist/img/logo.jpg" style="padding-left: 12px;"></a>
            </div>
            <%--个人信息栏--%>
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <!-- User Account: style can be found in dropdown.less -->
                    <%--<li class="dropdown notifications-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" id="time-warning-modal">
                            <i class="fa fa-bell-o"></i>
                            <span class="label label-danger" id="un_claim_number"></span>
                        </a>
                    </li>--%>

                    <li class="dropdown user user-menu" id="user-main-candan">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <img src="${ctxPath}/resources/dist/img/user2-160x160.jpg" class="user-image"
                                 alt="User Image">
                            <span class="hidden-xs"><myshiro:currentName/></span>
                        </a>
                        <ul class="dropdown-menu" id="user-caidan">
                            <li class="user-footer">
                                <div class="pull-left">
                                    <a id="btn-change-password" href="#" class="btn btn-default btn-flat">修改密码</a>
                                </div>
                                <div class="pull-right">
                                    <a href="${ctxPath}/admin/login/logout" class="btn btn-default btn-flat">安全退出</a>
                                </div>
                            </li>
                            <li class="user-footer">
                                <div class="pull-left">
                                    <button type="button" class="btn btn-default" id="change"><i class='fa fa-image'></i> 更换背景图片</button>
                                </div>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
    </nav>
</header>