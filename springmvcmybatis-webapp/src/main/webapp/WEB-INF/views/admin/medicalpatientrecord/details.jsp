<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/WEB-INF/views/admin/common/basecss.jsp" %>
    <title>医疗机构患者信息</title>
</head>
<body>

<!-- Main content -->
<section class="content">

    <div class="row">
        <div class="col-md-12 table-responsive">
            <table class="table table-bordered table-striped table-hover">
                <tr>
                    <th colspan="4">医疗机构患者信息</th>
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
                    <th>姓名</th>
                    <td>
                        <div id="name"></div>
                    </td>
                    <th>姓别</th>
                    <td>
                        <div id="sex"></div>
                    </td>
                </tr>
                <tr>
                    <th>电话</th>
                    <td>
                        <div id="phone"></div>
                    </td>
                    <th>身份证号码</th>
                    <td>
                        <div id="idCardNum"></div>
                    </td>
                </tr>
                <tr>
                    <th>家庭地址</th>
                    <td colspan="3">
                        <div id="address"></div>
                    </td>
                </tr>
                <tr>
                    <th>联系人</th>
                    <td>
                        <div id="contactPerson"></div>
                    </td>
                    <th>联系人拼音</th>
                    <td>
                        <div id="contactPersonSpell"></div>
                    </td>
                </tr>
                <tr>
                    <th>联系人常用证件号码</th>
                    <td colspan="3">
                        <div id="contactCardNumber"></div>
                    </td>
                </tr>
                <tr>
                    <th>联系人现居地址</th>
                    <td>
                        <div id="contactAddress"></div>
                    </td>
                    <th>联系电话</th>
                    <td>
                        <div id="contactPhone"></div>
                    </td>
                </tr>
                <tr>
                    <th>与患者的关系</th>
                    <td>
                        <div id="relation"></div>
                    </td>
                    <th>血型</th>
                    <td>
                        <div id="bloodType"></div>
                    </td>
                </tr>
                <tr>
                    <th>住院原因</th>
                    <td colspan="3">
                        <div id="hospitalizedReason"></div>
                    </td>
                </tr>
                <tr>
                    <th>住院日期</th>
                    <td>
                        <div id="hospitalizedDatetime"></div>
                    </td>
                    <th>出院时间</th>
                    <td>
                        <div id="leavehospitalDatetime"></div>
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
<%@ include file="/WEB-INF/views/admin/medicalpatientrecord/detailsjs.jsp" %>

</body>
</html>