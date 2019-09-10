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
            $.get("${ctxPath}/admin/api/medicalOutpatientRecord/" + id + "/detail", function (data) {
                $("#collectTime").html(data.result.collectTime);
                $("#hospitalName").html(data.result.hospitalName);
                $("#name").html(data.result.name);
                $("#sex").html(data.result.sex);
                $("#age").html(data.result.age);
                $("#bornTime").html(data.result.bornTime);
                $("#phone").html(data.result.phone);
                $("#idCardNum").html(data.result.idCardNum);
                $("#address").html(data.result.address);
                $("#profession").html(data.result.profession);
                $("#organization").html(data.result.organization);
                $("#diagnoseDatetime").html(data.result.diagnoseDatetime);
                $("#diagnoseNo").html(data.result.diagnoseNo);
                $("#diagnoseDepartment").html(data.result.diagnoseDepartment);
                $("#costType").html(data.result.costType);
                $("#medicareCardNo").html(data.result.medicareCardNo);
                $("#diagnoseResult").html(data.result.diagnoseResult);
                $("#cost").html(data.result.cost);
                $("#remark").html(data.result.remark);
            });
        }
    });
</script>