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
            $.get("${ctxPath}/admin/api/medicalCheckinCheckoutRecord/" + id + "/detail", function (data) {
                $("#collectTime").html(data.result.collectTime);
                $("#hospitalName").html(data.result.hospitalName);
                $("#name").html(data.result.name);
                $("#phone").html(data.result.phone);
                $("#sex").html(data.result.sex);
                $("#age").html(data.result.age);
                $("#idCardNum").html(data.result.idCardNum);
                $("#address").html(data.result.address);
                $("#organization").html(data.result.organization);
                $("#profession").html(data.result.profession);
                $("#houseHeadName").html(data.result.houseHeadName);
                $("#familyPopulation").html(data.result.familyPopulation);
                $("#familyType").html(data.result.familyType);
                $("#medicalGuaranteeNumber").html(data.result.medicalGuaranteeNumber);
                $("#hospitalizationDatetime").html(data.result.hospitalizationDatetime);
                $("#hospitalizationNo").html(data.result.hospitalizationNo);
                $("#hospitalizationDepartment").html(data.result.hospitalizationDepartment);
                $("#bedNumber").html(data.result.bedNumber);
                $("#hospitalWay").html(data.result.hospitalWay);
                $("#doctorName").html(data.result.doctorName);
                $("#admittingDiagnosis").html(data.result.admittingDiagnosis);
                $("#leaveHospitalDatetime").html(data.result.leavehospitalDatetime);
                $("#dischargeDiagnosis").html(data.result.dischargeDiagnosis);
                $("#subjectSalvage").html(data.result.subjectSalvage);
                $("#subjectSalvageType").html(data.result.subjectSalvageType);
                $("#subjectSalvageCost").html(data.result.subjectSalvageCost);
                $("#responsiblePersonName").html(data.result.responsiblePersonName);
                $("#remark").html(data.result.remark);
            });
        }
    });
</script>