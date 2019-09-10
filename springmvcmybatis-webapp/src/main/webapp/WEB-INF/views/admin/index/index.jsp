<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/WEB-INF/views/admin/common/basecss.jsp" %>
    <%-- jQuery validation --%>
    <link rel="stylesheet" href="${ctxPath}/resources/plugins/jquery-validation/validation.css">
    <%-- Pace style --%>
    <link rel="stylesheet" href="${ctxPath}/resources/plugins/pace/pace.min.css">


    <title>情报管理大数据平台</title>

</head>
<%--<body class="hold-transition skin-blue fixed sidebar-mini">--%>
<body class="hold-transition skin-blue layout-top-nav">
<div class="wrapper">
    <%@ include file="/WEB-INF/views/admin/index/header.jsp" %>

    <div class="content-wrapper" id="body-bg" style="background-image: url('${ctxPath}/resources/dist/img/allbg.jpg');">
        <div class="container">
            <section class="content">
                <div class="row">
                    <div class="col-lg-4 col-xs-6" id="adminModuleDiv" style="top: 130px;">
                        <!-- small box -->
                        <div class="small-box bg-yellow" style="border-radius: 20px">
                            <div class="inner">
                                <p>&nbsp;</p>
                                <h3 style="font-size: 38px;font-family: SimSun;font-weight: normal;">管理员模块</h3>
                            </div>
                            <div class="icon">
                                <i class="ion ion-person"></i>
                            </div>
                            <a href="javascript:void(0);" id="adminModule" class="small-box-footer" target="_blank">点 我 查 看 <i class="fa fa-arrow-circle-right"></i></a>
                        </div>
                    </div>

                    <div class="col-lg-4 col-xs-6" id="intellInfoDiv" style="left: 50px; top: 130px;">
                        <!-- small box -->
                        <div class="small-box bg-aqua" style="border-radius: 20px">
                            <div class="inner">
                                <p>&nbsp;</p>
                                <h3 style="font-size: 38px;font-family: SimSun;font-weight: normal;">情报数据</h3>
                            </div>
                            <div class="icon">
                                <i class="ion ion-ios-thunderstorm"></i>
                            </div>
                            <a href="javascript:void(0);" id="intellInfo" class="small-box-footer"  target="_blank">点 我 查 看 <i class="fa fa-arrow-circle-right"></i></a>
                        </div>
                    </div>
                    <%--<div class="col-lg-4 col-xs-6" id="searchwarningDiv" style="left: 100px; top: 130px;">
                        <!-- small box -->
                        <div class="small-box bg-red" style="border-radius: 20px">
                            <div class="inner">
                                <p>&nbsp;</p>
                                <h3 style="font-size: 38px;font-family: SimSun;font-weight: normal;">实时预警</h3>
                            </div>
                            <div class="icon">
                                <i class="ion ion-ios-bell"></i>
                            </div>
                            <a href="javascript:void(0);" id="searchwarning" class="small-box-footer"  target="_blank">点 我 查 看 <i class="fa fa-arrow-circle-right"></i></a>
                        </div>
                    </div>--%>
                    <div class="col-lg-4 col-xs-6" id="sysconfigDiv" style="left: 100px; top: 130px;">
                        <!-- small box -->
                        <div class="small-box bg-purple" style="border-radius: 20px">
                            <div class="inner">
                                <p>&nbsp;</p>
                                <h3 style="font-size: 38px;font-family: SimSun;font-weight: normal;">系统设置</h3>
                            </div>
                            <div class="icon">
                                <i class="ion ion-gear-a"></i>
                            </div>
                            <a href="javascript:void(0);" id="sysconfig" class="small-box-footer"  target="_blank">点 我 查 看 <i class="fa fa-arrow-circle-right"></i></a>
                        </div>
                    </div>
                </div>
                <%--<div class="row">
                    &lt;%&ndash;<div class="col-lg-4 col-xs-6" id="searchplatDiv" style="left: 200px; top: 180px;">
                        <!-- small box -->
                        <div class="small-box bg-green" style="border-radius: 20px">
                            <div class="inner">
                                <p>&nbsp;</p>
                                <h3 style="font-size: 38px;font-family: SimSun;font-weight: normal;">搜索平台</h3>
                            </div>
                            <div class="icon">
                                <i class="ion ion-android-globe"></i>
                            </div>
                            <a href="javascript:void(0);" id="searchplat" class="small-box-footer"  target="_blank">点 我 查 看 <i class="fa fa-arrow-circle-right"></i></a>
                        </div>
                    </div>&ndash;%&gt;
                    &lt;%&ndash;<div class="col-lg-4 col-xs-6" id="sysconfigDiv" style="left: 250px; top: 180px;">
                        <!-- small box -->
                        <div class="small-box bg-purple" style="border-radius: 20px">
                            <div class="inner">
                                <p>&nbsp;</p>
                                <h3 style="font-size: 38px;font-family: SimSun;font-weight: normal;">系统设置</h3>
                            </div>
                            <div class="icon">
                                <i class="ion ion-gear-a"></i>
                            </div>
                            <a href="javascript:void(0);" id="sysconfig" class="small-box-footer"  target="_blank">点 我 查 看 <i class="fa fa-arrow-circle-right"></i></a>
                        </div>
                    </div>&ndash;%&gt;
                </div>--%>
            </section>
        </div>
    </div>
</div>
<!-- ./wrapper -->

<%@ include file="/WEB-INF/views/admin/index/changeImage.jsp" %>
<%@ include file="/WEB-INF/views/admin/index/changepassword.jsp" %>

<%@ include file="/WEB-INF/views/admin/index/indexjs.jsp" %>

<%@ include file="/WEB-INF/views/admin/index/warning.jsp" %>

</body>
</html>