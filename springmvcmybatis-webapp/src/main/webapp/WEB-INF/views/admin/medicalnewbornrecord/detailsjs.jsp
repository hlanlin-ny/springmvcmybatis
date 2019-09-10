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
            $.get("${ctxPath}/admin/api/medicalNewbornRecord/" + id + "/detail", function (data) {
                console.log(data.result);
                $("#collectTime").html(data.result.collectTime);
                $("#hospitalName").html(data.result.hospitalName);
                $("#name").html(data.result.name);
                $("#sex").html(data.result.sex);
                $("#sexDetail").html(data.result.sexDetail);
                $("#bornTime").html(data.result.bornTime);
                $("#idCardNum").html(data.result.idCardNum);
                $("#deliverOrganization").html(data.result.deliverOrganization);
                $("#address").html(data.result.address);
                $("#checkInDatetime").html(data.result.checkInDatetime);
                $("#motherName").html(data.result.motherName);
                $("#motherNation").html(data.result.motherNation);
                $("#motherNationDetail").html(data.result.motherNationDetail);
                $("#motherIdcardnum").html(data.result.motherIdcardnum);
                $("#motherPhone").html(data.result.motherPhone);
                $("#fatherName").html(data.result.fatherName);
                $("#fatherNation").html(data.result.fatherNation)
                $("#fatherNationDetail").html(data.result.fatherNationDetail);
                $("#fatherIdcardnum").html(data.result.fatherIdcardnum);
                $("#fatherPhone").html(data.result.fatherPhone);
                $("#remark").html(data.result.remark);
            });
        }
    });
</script>