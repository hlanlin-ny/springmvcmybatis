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
            var data = {id:id};
            $.post("${ctxPath}/admin/warningdispostion/detail",data, function (data) {
                if (data.code == 0) {
                    var result = data.result;
                    //活动发生详情
                    var activity = result[0];
                    $("#relateId").val(activity.id);
                    $("#occurTime").html(activity.occurTime);
                    $("#acceptProvider").html(activity.acceptProvider);
                    $("#warningLevel").html(activity.warningLevel);
                    $("#warningTime").html(activity.warningTime);
                    $("#areaName").html(activity.areaName);
                    $("#providerAddress").html(activity.providerAddress);
                    $("#informationProvider").html(activity.informationProvider);
                    $("#policeOffice").html(activity.policeOffice);
                    $("#activityInformation").html(activity.activityInformation);
                    $("#registerName").html(activity.registerName);
                    $("#registerIDcardNo").html(activity.registerIDcardNo);
                    $("#registerBornDate").html(activity.registerBornDate);
                    $("#dynamicInformationType").html(activity.dynamicInformationType);
                    $("#dynamicInformationProvider").html(activity.dynamicInformationProvider);
                    //预警人员信息
                    if(result[2]=="重点人员"){
                        var impotantPerson = result[1];
                        $("#name").html(impotantPerson.name);
                        $("#idcardNo").html(impotantPerson.idCardNo);
                        $("#sex").html(impotantPerson.sex);
                        $("#nation").html(impotantPerson.nation);
                        $("#bornTime").html(impotantPerson.bornTime);
                        $("#personAddress").html(impotantPerson.address);
                        $("#controlName").html(impotantPerson.controlName);
                        $("#controlPersonUnit").html(impotantPerson.controlPersonUnit);
                        $("#controlUnit").html(impotantPerson.controlUnit);
                        $("#controlContact").html(impotantPerson.controlTel);
                        $("#personType").html(impotantPerson.personType);
                    }else{
                        var controlPerson = result[1];
                        $("#name").html(controlPerson.controlByName);
                        $("#idcardNo").html(controlPerson.cardNumber);
                        $("#sex").html(controlPerson.sex);
                        $("#nation").html(controlPerson.nation);
                        $("#bornTime").html(controlPerson.bornTime);
                        $("#personAddress").html(controlPerson.address);
                        $("#controlName").html(controlPerson.applyName);
                        $("#controlPersonUnit").html(controlPerson.applyUnit);
                        $("#controlUnit").html(controlPerson.controlUnit);
                        $("#controlContact").html(controlPerson.feedBackContact);
                        $("#personType").html("临时布控");
                    }
                } else {
                    console.log("服务异常:" + data);
                    $.toaster("异常信息:" + data.message, "服务异常", "danger");
                }
            });
        }
    });
</script>