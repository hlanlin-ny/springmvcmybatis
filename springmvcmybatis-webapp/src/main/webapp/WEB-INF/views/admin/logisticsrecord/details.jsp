<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/WEB-INF/views/admin/common/basecss.jsp" %>
    <title>物流信息详情</title>
</head>
<body>

<!-- Main content -->
<section class="content">

    <div class="row">
        <div class="col-md-12 table-responsive">
            <table class="table table-bordered table-striped table-hover">
                <tr>
                    <th colspan="4">物流信息详情</th>
                </tr>
                <tr>
                    <th style="width: 150px">上报时间</th>
                    <td>
                        <div id="collectTime"></div>
                    </td>
                    <th style="width: 150px">上报网点</th>
                    <td>
                        <div id="branchName"></div>
                    </td>
                </tr>
                <tr>
                    <th>发件人姓名</th>
                    <td>
                        <div id="senderName"></div>
                    </td>
                    <th>发件人电话</th>
                    <td>
                        <div id="senderPhone"></div>
                    </td>
                </tr>
                <tr>
                    <th>发件人身份证号码</th>
                    <td colspan="3">
                        <div id="senderIdCardNum"></div>
                    </td>
                </tr>
                <tr>
                    <th>收件人姓名</th>
                    <td>
                        <div id="receiverName"></div>
                    </td>
                    <th>收件人电话</th>
                    <td>
                        <div id="receiverPhone"></div>
                    </td>
                </tr>
                <tr>
                    <th>收件人地址</th>
                    <td colspan="3">
                        <div id="receiverAddress"></div>
                    </td>
                </tr>
                <tr>
                    <th>货物名称</th>
                    <td colspan="3">
                        <div id="goodsName"></div>
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
<%@ include file="/WEB-INF/views/admin/logisticsrecord/detailsjs.jsp" %>

</body>
</html>