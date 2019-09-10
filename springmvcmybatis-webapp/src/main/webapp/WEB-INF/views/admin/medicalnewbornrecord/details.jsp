<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/WEB-INF/views/admin/common/basecss.jsp" %>
    <title>新生儿出生信息</title>
</head>
<body>

<!-- Main content -->
<section class="content">

    <div class="row">
        <div class="col-md-12 table-responsive">
            <table class="table table-bordered table-striped table-hover">
                <tr>
                    <th colspan="4">新生儿出生信息</th>
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
                    <th>姓别描述</th>
                    <td>
                        <div id="sexDetail"></div>
                    </td>
                    <th>出生日期</th>
                    <td>
                        <div id="bornTime"></div>
                    </td>
                </tr>
                <tr>
                    <th>身份证号码</th>
                    <td colspan="3">
                        <div id="idCardNum"></div>
                    </td>
                </tr>
                <tr>
                    <th>接生机构名称</th>
                    <td>
                        <div id="deliverOrganization"></div>
                    </td>
                    <th>家庭地址</th>
                    <td>
                        <div id="address"></div>
                    </td>
                </tr>
                <tr>
                    <th>信息登记时间</th>
                    <td>
                        <div id="checkInDatetime"></div>
                    </td>
                    <th>母亲姓名</th>
                    <td >
                        <div id="motherName"></div>
                    </td>
                </tr>
                <tr>
                    <th>母亲民族</th>
                    <td>
                        <div id="motherNation"></div>
                    </td>
                    <th>母亲民族描述</th>
                    <td>
                        <div id="motherNationDetail"></div>
                    </td>
                </tr>
                <tr>
                    <th>母亲身份证号码</th>
                    <td>
                        <div id="motherIdcardnum"></div>
                    </td>
                    <th>母亲联系电话</th>
                    <td>
                        <div id="motherPhone"></div>
                    </td>
                </tr>
                <tr>
                    <th>父亲名字</th>
                    <td>
                        <div id="fatherName"></div>
                    </td>
                    <th>父亲民族</th>
                    <td>
                        <div id="fatherNation"></div>
                    </td>
                </tr>
                <tr>
                    <th>父亲身份证号</th>
                    <td>
                        <div id="fatherNationDetail"></div>
                    </td>
                    <th>父亲联系电话</th>
                    <td>
                        <div id="fatherIdcardnum"></div>
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
<%@ include file="/WEB-INF/views/admin/medicalnewbornrecord/detailsjs.jsp" %>

</body>
</html>