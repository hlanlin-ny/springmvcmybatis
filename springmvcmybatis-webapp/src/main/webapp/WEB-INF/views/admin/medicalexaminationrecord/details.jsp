<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/WEB-INF/views/admin/common/basecss.jsp" %>
    <title>医疗体检信息详情</title>
</head>
<body>

<!-- Main content -->
<section class="content">

    <div class="row">
        <div class="col-md-12 table-responsive">
            <table class="table table-bordered table-striped table-hover">
                <tr>
                    <th colspan="4">医疗体检信息详情</th>
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
                    <th>体检者姓名</th>
                    <td>
                        <div id="name"></div>
                    </td>
                    <th>体检者电话</th>
                    <td>
                        <div id="phone"></div>
                    </td>
                </tr>
                <tr>
                    <th>体检者身份证号码</th>
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
                        <div id="workUnit"></div>
                    </td>
                </tr>
                <tr>
                    <th>体检时间</th>
                    <td colspan="3">
                        <div id="examinationDateime"></div>
                    </td>
                </tr>
                <tr>
                    <th>体检项目</th>
                    <td colspan="3">
                        <div id="examinationTerm"></div>
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
<%@ include file="/WEB-INF/views/admin/medicalexaminationrecord/detailsjs.jsp" %>

</body>
</html>