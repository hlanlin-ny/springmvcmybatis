<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="main-header">
    <audio src="${ctxPath}/resources/dist/music/warning.mp3" controls="controls" preload id="music1" hidden>
    </audio>
    <!-- Logo -->
    <a href="#" class="logo" style="margin: 0px;padding: 0px;">
        <!-- mini logo for sidebar mini 50x50 pixels -->
        <span class="logo-mini"><b>情报</b></span>
        <!-- logo for regular state and mobile devices -->
        <span class="logo-lg"><img src="${ctxPath}/resources/dist/img/logo.jpg" style="padding-left: -12px;"></span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top" style="background-image:url('${ctxPath}/resources/dist/img/logo_bg.jpg'); background-repeat:repeat-x">
        <!-- Sidebar toggle button-->
        <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">折叠导航</span>
        </a>

        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
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
                    </ul>
                </li>
                <!-- Control Sidebar Toggle Button -->
                <%--<li>--%>
                <%--<a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>--%>
                <%--</li>--%>
            </ul>
        </div>
    </nav>
</header>