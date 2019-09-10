<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/WEB-INF/views/admin/common/basecss.jsp" %>
    <title>医疗出(住)院信息详情</title>
</head>
<body>

<!-- Main content -->
<section class="content">

    <div class="row">
        <div class="col-md-12 table-responsive">
            <table class="table table-bordered table-striped table-hover">
                <tr>
                    <th colspan="4" style="text-align: center">被布控人员信息</th>
                </tr>
                <tr>
                    <th>姓名</th>
                    <td>
                        <div id="name"></div>
                    </td>
                    <th>身份证号码</th>
                    <td>
                        <div id="idcardNo"></div>
                    </td>
                </tr>
                <tr>
                    <th>性别</th>
                    <td>
                        <div id="sex"></div>
                    </td>
                    <th>民族</th>
                    <td>
                        <div id="nation"></div>
                    </td>
                </tr>
                <tr>
                    <th>出生日期</th>
                    <td>
                        <div id="bornTime"></div>
                    </td>
                    <th>户籍地址</th>
                    <td>
                        <div id="address"></div>
                    </td>
                </tr>
                <tr>
                    <th>人员类别</th>
                    <td colspan="3">
                        <div id="personType"></div>
                    </td>
                </tr>
                <tr>
                    <th colspan="4" style="text-align: center">活动详情</th>
                </tr>
                <tr>
                    <th>登记姓名</th>
                    <td>
                        <div id="registerName"></div>
                    </td>
                    <th>登记身份证</th>
                    <td>
                        <div id="registerIDcardNo"></div>
                    </td>
                </tr>
                <tr>
                    <th>登记出生日期</th>
                    <td>
                        <div id="registerBornDate"></div>
                    </td>
                    <th>发生时间</th>
                    <td>
                        <div id="occurTime"></div>
                    </td>
                </tr>
                <tr>
                    <th>行政区划</th>
                    <td>
                        <div id="areaName"></div>
                    </td>
                    <th>发生的详细地址</th>
                    <td>
                        <div id="providerAddress"></div>
                    </td>
                </tr>
                <tr>
                    <th>所属社会场所</th>
                    <td>
                        <div id="informationProvider"></div>
                    </td>
                    <th>所属公安机关</th>
                    <td>
                        <div id="policeOffice"></div>
                    </td>
                </tr>

                <tr>
                    <th>活动相关信息</th>
                    <td >
                        <div id="activityInformation"></div>
                    </td>
                    <th>动态信息类别</th>
                    <td >
                        <div id="dynamicInformationType"></div>
                    </td>
                </tr>
                <tr>
                    <th>动态信息提供单位</th>
                    <td>
                        <div id="dynamicInformationProvider"></div>
                    </td>
                </tr>
                <tr>
                    <th colspan="4" style="text-align: center">预警详情</th>
                </tr>
                <tr>
                    <th>预警时间</th>
                    <td>
                        <div id="warningTime"></div>
                    </td>
                    <th>布控人员</th>
                    <td>
                        <div id="controlName"></div>
                    </td>
                </tr>
                <tr>
                    <th>布控人员单位</th>
                    <td>
                        <div id="controlPersonUnit"></div>
                    </td>
                    <th>布控单位</th>
                    <td>
                        <div id="controlUnit"></div>
                    </td>
                </tr>
                <tr>
                    <th>联系方式</th>
                    <td>
                        <div id="controlContact"></div>
                    </td>
                </tr>
            </table>
        </div>
    </div>

</section>
<!-- /.content -->
<!-- js -->
<%@ include file="/WEB-INF/views/admin/index/detailsjs.jsp" %>

</body>
</html>