<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/basejs.jsp" %>
<%-- PACE --%>
<script src="${ctxPath}/resources/plugins/pace/pace.min.js"></script>
<!-- 本页面用到的js -->
<script type="text/javascript">
    // To make Pace works on Ajax calls
    $(document).ajaxStart(function () {
        Pace.restart();
    });

    //获取url中的参数
    function getUrlParam(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
        var r = window.location.search.substr(1).match(reg);  //匹配目标参数
        if (r != null) return unescape(r[2]);
        return ""; //返回参数值
    }

    $().ready(function () {
        //得到id
        var id = getUrlParam('id');
        if (id != "") {
            //加载详情
            $.get("${ctxPath}/admin/api/medicalInsuranceCardRecord/" + id + "/detail", function (data) {
                $("#collectTime").html(data.result.collectTime);
                $("#hospitalName").html(data.result.hospitalName);
                $("#medicalType").html(data.result.medicalType);
                $("#medicalTypeCode").html(data.result.medicalTypeCode);
                $("#cost").html(data.result.cost);
                $("#hospitalizationDatetime").html(data.result.hospitalizationDatetime);
                $("#leavehospitalDatetime").html(data.result.leavehospitalDatetime);
                $("#hospitalizationIllness").html(data.result.hospitalizationIllness);
                $("#diagnosisHospitalization").html(data.result.diagnosisHospitalization);
                $("#complicationDetail").html(data.result.complicationDetail);
                $("#leavehospitalReason").html(data.result.leavehospitalReason);
                $("#doctor").html(data.result.doctor);
                $("#hospitalizationNo").html(data.result.hospitalizationNo);
                $("#hospitalizationDepartment").html(data.result.hospitalizationDepartment);
                $("#takeDatetime").html(data.result.takeDatetime);
                $("#responsiblePersonName").html(data.result.responsiblePersonName);
                $("#hospitalNumber").html(data.result.hospitalNumber);
                $("#personNumber").html(data.result.personNumber);
                $("#organizationNumber").html(data.result.organizationNumber);
                $("#reimbursementSign").html(data.result.reimbursementSign);
                $("#reimbursementSignDetail").html(data.result.reimbursementSignDetail);
                $("#accountEndStatus").html(data.result.accountEndStatus);
                $("#accountEndStatusDetail").html(data.result.accountEndStatusDetail);
                $("#remark").html(data.result.remark);
            });
        }
    });
</script>