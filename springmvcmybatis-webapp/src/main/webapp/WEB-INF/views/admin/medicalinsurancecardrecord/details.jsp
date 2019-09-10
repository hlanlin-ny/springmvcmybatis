<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/WEB-INF/views/admin/common/basecss.jsp" %>
    <title>医保刷卡记录信息</title>
</head>
<body>

<!-- Main content -->
<section class="content">

    <div class="row">
        <div class="col-md-12 table-responsive">
            <table class="table table-bordered table-striped table-hover">
                <tr>
                    <th colspan="4">医保刷卡记录信息</th>
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
                    <th>医疗类型</th>
                    <td>
                        <div id="medicalType"></div>
                    </td>
                    <th>医疗类型代码</th>
                    <td>
                        <div id="medicalTypeCode"></div>
                    </td>
                </tr>
                <tr>
                    <th>医疗费用金额</th>
                    <td>
                        <div id="cost"></div>
                    </td>
                    <th>住院时间</th>
                    <td>
                        <div id="hospitalizationDatetime"></div>
                    </td>
                </tr>
                <tr>
                    <th>出院时间</th>
                    <td >
                        <div id="leavehospitalDatetime"></div>
                    </td>
                    <th>入院疾病</th>
                    <td >
                        <div id="hospitalizationIllness"></div>
                    </td>
                </tr>
                <tr>
                    <th>确诊疾病</th>
                    <td>
                        <div id="diagnosisHospitalization"></div>
                    </td>
                    <th>并发症简要情况</th>
                    <td>
                        <div id="complicationDetail"></div>
                    </td>
                </tr>
                <tr>
                    <th>出院原因</th>
                    <td>
                        <div id="leavehospitalReason"></div>
                    </td>
                    <th>医生姓名</th>
                    <td >
                        <div id="doctor"></div>
                    </td>
                </tr>
                <tr>
                    <th>住院号</th>
                    <td>
                        <div id="hospitalizationNo"></div>
                    </td>
                    <th>住院科室</th>
                    <td>
                        <div id="hospitalizationDepartment"></div>
                    </td>
                </tr>
                <tr>
                    <th>办理日期</th>
                    <td>
                        <div id="takeDatetime"></div>
                    </td>
                    <th>经办人姓名</th>
                    <td>
                        <div id="responsiblePersonName"></div>
                    </td>
                </tr>
                <tr>
                    <th>医院编号</th>
                    <td>
                        <div id="hospitalNumber"></div>
                    </td>
                    <th>单位编号</th>
                    <td>
                        <div id="organizationNumber"></div>
                    </td>
                </tr>
                <tr>
                    <th>个人编号</th>
                    <td>
                        <div id="personNumber"></div>
                    </td>
                    <th>报销标志</th>
                    <td>
                        <div id="reimbursementSign"></div>
                    </td>
                </tr>
                <tr>
                <tr>
                    <th>报销标志_简要情况</th>
                    <td>
                        <div id="reimbursementSignDetail"></div>
                    </td>
                    <th>结算状态</th>
                    <td>
                        <div id="accountEndStatus"></div>
                    </td>
                </tr>
                <tr>
                <tr>
                    <th>结算状态_简要情况</th>
                    <td>
                        <div id="accountEndStatusDetail"></div>
                    </td>
                <th>备注</th>
                <td >
                    <div id="remark"></div>
                </td>
                </tr>
            </table>
        </div>
    </div>

</section>
<!-- /.content -->
<!-- js -->
<%@ include file="/WEB-INF/views/admin/medicalinsurancecardrecord/detailsjs.jsp" %>

</body>
</html>