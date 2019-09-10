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
                    <th colspan="4">医疗出(住)院信息详情</th>
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
                    <th>身份证号码</th>
                    <td colspan="3">
                        <div id="idCardNum"></div>
                    </td>
                </tr>
                <tr>
                    <th>家庭地址</th>
                    <td>
                        <div id="address"></div>
                    </td>
                    <th>职业</th>
                    <td>
                        <div id="profession"></div>
                    </td>
                </tr>
                <tr>
                    <th>工作单位</th>
                    <td colspan="3">
                        <div id="organization"></div>
                    </td>
                </tr>
                <tr>
                    <th>户主姓名</th>
                    <td>
                        <div id="houseHeadName"></div>
                    </td>
                    <th>家庭人口数</th>
                    <td>
                        <div id="familyPopulation"></div>
                    </td>
                </tr>
                <tr>
                    <th>家庭类别</th>
                    <td>
                        <div id="familyType"></div>
                    </td>
                    <th>医保证号</th>
                    <td>
                        <div id="medicalGuaranteeNumber"></div>
                    </td>
                </tr>


                <tr>
                    <th>住院时间</th>
                    <td colspan="3">
                        <div id="hospitalizationDatetime"></div>
                    </td>
                </tr>
                <tr>
                    <th>住院号</th>
                    <td >
                        <div id="hospitalizationNo"></div>
                    </td>
                    <th>住院科室</th>
                    <td >
                        <div id="hospitalizationDepartment"></div>
                    </td>
                </tr>
                <tr>
                    <th>床号</th>
                    <td>
                        <div id="bedNumber"></div>
                    </td>
                    <th>入院途径</th>
                    <td>
                        <div id="hospitalWay"></div>
                    </td>
                </tr>
                <tr>
                    <th>医生名字</th>
                    <td>
                        <div id="doctorName"></div>
                    </td>
                    <th>入院诊断</th>
                    <td>
                        <div id="admittingDiagnosis"></div>
                    </td>
                </tr>
                <tr>
                    <th>出院时间</th>
                    <td colspan="3">
                        <div id="leaveHospitalDatetime"></div>
                    </td>
                </tr>
                <tr>
                    <th>出院诊断</th>
                    <td>
                        <div id="dischargeDiagnosis"></div>
                    </td>
                    <th>救助对象</th>
                    <td>
                        <div id="subjectSalvage"></div>
                    </td>
                </tr>
                <tr>
                    <th>救助对象类别</th>
                    <td>
                        <div id="subjectSalvageType"></div>
                    </td>
                    <th>救助金额</th>
                    <td>
                        <div id="subjectSalvageCost"></div>
                    </td>
                </tr>
                <tr>
                    <th>备注</th>
                    <td>
                        <div id="remark"></div>
                    </td>
                </tr>
            </table>
        </div>
    </div>

</section>
<!-- /.content -->
<!-- js -->
<%@ include file="/WEB-INF/views/admin/medicalcheckincheckoutrecord/detailsjs.jsp" %>

</body>
</html>