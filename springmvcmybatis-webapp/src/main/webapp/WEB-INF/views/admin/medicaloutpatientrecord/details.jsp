<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/WEB-INF/views/admin/common/basecss.jsp" %>
    <title>医疗门诊信息详情</title>
</head>
<body>

<!-- Main content -->
<section class="content">

    <div class="row">
        <div class="col-md-12 table-responsive">
            <table class="table table-bordered table-striped table-hover">
                <tr>
                    <th colspan="4">医疗门诊信息详情</th>
                </tr>
                <tr>
                    <th style="width: 150px">上报时间</th>
                    <td>
                        <div id="collectTime"></div>
                    </td>
                    <th style="width: 150px">医院名字</th>
                    <td>
                        <div id="hospitalName"></div>
                    </td>
                </tr>
                <tr>
                    <th>门诊人员姓名</th>
                    <td>
                        <div id="name"></div>
                    </td>
                    <th>门诊人员电话</th>
                    <td>
                        <div id="phone"></div>
                    </td>
                </tr>
                <tr>
                    <th>门诊人员姓别</th>
                    <td>
                        <div id="sex"></div>
                    </td>
                    <th>门诊人员年龄</th>
                    <td>
                        <div id="age"></div>
                    </td>
                </tr>
                <tr>
                    <th>门诊人员身份证号码</th>
                    <td colspan="3">
                        <div id="idCardNum"></div>
                    </td>
                </tr>
                <tr>
                    <th>门诊人员职业</th>
                    <td>
                        <div id="profession"></div>
                    </td>
                    <th>门诊人员单位</th>
                    <td>
                        <div id="organization"></div>
                    </td>
                </tr>
                <tr>
                    <th>家庭地址</th>
                    <td>
                        <div id="address"></div>
                    </td>
                    <th>门诊号</th>
                    <td >
                        <div id="diagnoseNo"></div>
                    </td>
                </tr>
                <tr>
                    <th>就诊时间</th>
                    <td colspan="3">
                        <div id="diagnoseDatetime"></div>
                    </td>
                </tr>
                <tr>
                    <th>科室名称</th>
                    <td>
                        <div id="diagnoseDepartment"></div>
                    </td>
                    <th>人员类别</th>
                    <td>
                        <div id="costType"></div>
                    </td>
                </tr>
                <tr>
                    <th>医保证号</th>
                    <td colspan="3">
                        <div id="medicareCardNo"></div>
                    </td>
                </tr>
                <tr>
                    <th>医院诊断结果</th>
                    <td colspan="3">
                        <div id="diagnoseResult"></div>
                    </td>
                </tr>
                <tr>
                    <th>费用</th>
                    <td colspan="3">
                        <div id="cost"></div>
                    </td>
                </tr>
                <tr>
                    <th>备注</th>
                    <td colspan="3">
                        <div id="remark"></div>
                    </td>
                </tr>
            </table>
        </div>
    </div>

</section>
<!-- /.content -->
<!-- js -->
<%@ include file="/WEB-INF/views/admin/medicaloutpatientrecord/detailsjs.jsp" %>

</body>
</html>