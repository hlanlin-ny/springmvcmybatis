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
            $.get("${ctxPath}/admin/api/medicalExaminationRecord/" + id + "/detail", function (data) {
                $("#collectTime").html(data.result.collectTime);
                $("#hospitalName").html(data.result.hospitalName);
                $("#name").html(data.result.name);
                $("#phone").html(data.result.phone);
                $("#idCardNum").html(data.result.idCardNum);
                $("#address").html(data.result.address);
                $("#profession").html(data.result.profession);
                $("#workUnit").html(data.result.organization);
                $("#examinationDateime").html(data.result.examinationDateime);
                $("#examinationTerm").html(data.result.examinationTerm);
                $("#remark").html(data.result.remark);
            });
        }
    });
</script>