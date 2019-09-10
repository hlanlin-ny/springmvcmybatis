<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/listtop.jsp" %>

<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        静态情报上传市局
        <small></small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="${ctxPath}/admin/index/main.html"><i class="fa fa-home"></i> 首页</a></li>
        <li class="active">情报管理</li>
        <li class="active"> 静态情报上传市局</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">

    <div class="row">
        <div class="col-md-12">
            <div class="box">
                <div class="box-header"style="border:1px groove #000;border-style:dotted">
                    <h3 class="box-title">燃气用户数据上传</h3>

                    <div class="box-tools">
                        <shiro:hasPermission name="intelligenceimportcity:add">
                            <button id="btn-add" type="button" class="btn btn-primary" style="float: left">
                                <i class="glyphicon glyphicon-plus"></i>点击上传燃气用户数据
                            </button>
                        </shiro:hasPermission>
                    </div>
                </div>
                <%--<div class="box-header"style="border:1px groove #000;border-style:dotted">
                    <h3 class="box-title">自来水数据上传</h3>
                    <div class="box-tools">
                        <shiro:hasPermission name="intelligenceimportcity:add">
                            <button id="btn-add-water" type="button" class="btn btn-primary" style="float: left">
                                <i class="glyphicon glyphicon-plus"></i>点击上传自来水数据
                            </button>
                        </shiro:hasPermission>
                    </div>
                </div>--%>

                <div class="box-header"style="border:1px groove #000;border-style:dotted">
                    <h3 class="box-title">从业人员数据上传</h3>

                    <div class="box-tools">
                        <shiro:hasPermission name="intelligenceimportcity:add">
                            <button id="btn-add-people" type="button" class="btn btn-primary" style="float: left">
                                <i class="glyphicon glyphicon-plus"></i>点击上传从业人员数据
                            </button>
                        </shiro:hasPermission>
                    </div>
                </div>


                <div class="box-header"style="border:1px groove #000;border-style:dotted">
                    <h3 class="box-title">职工健康证明数据上传</h3>

                    <div class="box-tools">
                        <shiro:hasPermission name="intelligenceimportcity:add">
                            <button id="btn-add-healthy" type="button" class="btn btn-primary" style="float: left">
                                <i class="glyphicon glyphicon-plus"></i>点击上传职工健康证明数据
                            </button>
                        </shiro:hasPermission>
                    </div>
                </div>


                <div class="box-header"style="border:1px groove #000;border-style:dotted">
                    <h3 class="box-title">新农合数据上传</h3>

                    <div class="box-tools">
                        <shiro:hasPermission name="intelligenceimportcity:add">
                            <button id="btn-add-ncms" type="button" class="btn btn-primary" style="float: left">
                                <i class="glyphicon glyphicon-plus"></i>点击上传新农合数据
                            </button>
                        </shiro:hasPermission>
                    </div>
                </div>


                <%--<div class="box-header"style="border:1px groove #000;border-style:dotted">
                    <h3 class="box-title">医保人员数据上传</h3>
                    <div class="box-tools">
                        <shiro:hasPermission name="intelligenceimportcity:add">
                            <button id="btn-medical-insurance" type="button" class="btn btn-primary"
                                    style="float: left">
                                <i class="glyphicon glyphicon-plus"></i>点击上传医保人员数据
                            </button>
                        </shiro:hasPermission>
                    </div>
                </div>--%>


                <div class="box-header"style="border:1px groove #000;border-style:dotted">
                    <h3 class="box-title">公积金数据上传</h3>

                    <div class="box-tools">
                        <shiro:hasPermission name="intelligenceimportcity:add">
                            <button id="btn-accumulation-fund" type="button" class="btn btn-primary"
                                    style="float: left">
                                <i class="glyphicon glyphicon-plus"></i>点击上传公积金数据
                            </button>
                        </shiro:hasPermission>
                    </div>
                </div>


                <div class="box-header"style="border:1px groove #000;border-style:dotted">
                    <h3 class="box-title">信访数据上传</h3>

                    <div class="box-tools">
                        <shiro:hasPermission name="intelligenceimportcity:add">
                            <button id="btn-letters-calls" type="button" class="btn btn-primary" style="float: left">
                                <i class="glyphicon glyphicon-plus"></i>点击上传信访数据
                            </button>
                        </shiro:hasPermission>
                    </div>
                </div>

                <div class="box-header"style="border:1px groove #000;border-style:dotted">
                    <h3 class="box-title">学籍数据上传</h3>

                    <div class="box-tools">
                        <shiro:hasPermission name="intelligenceimportcity:add">
                            <button id="btn-student-calls" type="button" class="btn btn-primary" style="float: left">
                                <i class="glyphicon glyphicon-plus"></i>点击上传学籍数据
                            </button>
                        </shiro:hasPermission>
                    </div>
                </div>

                <div class="box-header"style="border:1px groove #000;border-style:dotted">
                    <h3 class="box-title">有线用户数据上传</h3>
                    <div class="box-tools">
                        <shiro:hasPermission name="intelligenceimportcity:add">
                            <button id="btn-television-calls" type="button" class="btn btn-primary" style="float: left">
                                <i class="glyphicon glyphicon-plus"></i>点击上传有线用户数据
                            </button>
                        </shiro:hasPermission>
                    </div>
                </div>

                <div class="box-header"style="border:1px groove #000;border-style:dotted">
                    <h3 class="box-title">医院体检数据上传</h3>
                    <div class="box-tools">
                        <shiro:hasPermission name="intelligenceimportcity:add">
                            <button id="btn-PhysicalExamination-calls" type="button" class="btn btn-primary"
                                    style="float: left">
                                <i class="glyphicon glyphicon-plus"></i>点击上传医院体检数据
                            </button>
                        </shiro:hasPermission>
                    </div>
                </div>

                <%--<div class="box-header"style="border:1px groove #000;border-style:dotted">
                    <h3 class="box-title">停车场数据上传</h3>

                    <div class="box-tools">
                        <shiro:hasPermission name="intelligenceimportcity:add">
                            <button id="btn-paking-calls" type="button" class="btn btn-primary" style="float: left">
                                <i class="glyphicon glyphicon-plus"></i>点击上传停车场数据
                            </button>
                        </shiro:hasPermission>
                    </div>
                </div>--%>

                <div class="box-header"style="border:1px groove #000;border-style:dotted">
                    <h3 class="box-title">会员登记数据上传</h3>

                    <div class="box-tools">
                        <shiro:hasPermission name="intelligenceimportcity:add">
                            <button id="btn-vip-calls" type="button" class="btn btn-primary" style="float: left">
                                <i class="glyphicon glyphicon-plus"></i>点击上传会员登记数据
                            </button>
                        </shiro:hasPermission>
                    </div>
                </div>

                <div class="box-header"style="border:1px groove #000;border-style:dotted">
                    <h3 class="box-title">出租车轨迹数据上传</h3>
                    <div class="box-tools">
                        <shiro:hasPermission name="intelligenceimportcity:add">
                            <button id="btn-cargps-calls" type="button" class="btn btn-primary" style="float: left">
                                <i class="glyphicon glyphicon-plus"></i>点击上传出租车轨迹数据
                            </button>
                        </shiro:hasPermission>
                    </div>
                </div>

                <%--<div class="box-header"style="border:1px groove #000;border-style:dotted">
                    <h3 class="box-title">旅行社接待游客数据上传</h3>

                    <div class="box-tools">
                        <shiro:hasPermission name="intelligenceimportcity:add">
                            <button id="btn-visitor-calls" type="button" class="btn btn-primary" style="float: left">
                                <i class="glyphicon glyphicon-plus"></i>点击上传旅行社接待游客数据
                            </button>
                        </shiro:hasPermission>
                    </div>
                </div>--%>

                <%--<div class="box-header"style="border:1px groove #000;border-style:dotted">
                    <h3 class="box-title">电动车车辆数据上传</h3>

                    <div class="box-tools">
                        <shiro:hasPermission name="intelligenceimportcity:add">
                            <button id="btn-economical-calls" type="button" class="btn btn-primary" style="float: left">
                                <i class="glyphicon glyphicon-plus"></i>点击上传电动车车辆数据
                            </button>
                        </shiro:hasPermission>
                    </div>
                </div>--%>

                <%--<div class="box-header"style="border:1px groove #000;border-style:dotted">
                    <h3 class="box-title">燃气缴费数据上传</h3>

                    <div class="box-tools">
                        <shiro:hasPermission name="intelligenceimportcity:add">
                            <button id="btn-gasfee-calls" type="button" class="btn btn-primary" style="float: left">
                                <i class="glyphicon glyphicon-plus"></i>点击上传燃气缴费数据
                            </button>
                        </shiro:hasPermission>
                    </div>
                </div>--%>

                <%--<div class="box-header"style="border:1px groove #000;border-style:dotted">
                    <h3 class="box-title">电动车轨迹数据上传</h3>

                    <div class="box-tools">
                        <shiro:hasPermission name="intelligenceimportcity:add">
                            <button id="btn-EcoGps-calls" type="button" class="btn btn-primary" style="float: left">
                                <i class="glyphicon glyphicon-plus"></i>点击上传电动车轨迹数据
                            </button>
                        </shiro:hasPermission>
                    </div>
                </div>--%>

                <%--<div class="box-header"style="border:1px groove #000;border-style:dotted">
                    <h3 class="box-title">快递数据上传</h3>

                    <div class="box-tools">
                        <shiro:hasPermission name="intelligenceimportcity:add">
                            <button id="btn-Express-calls" type="button" class="btn btn-primary" style="float: left">
                                <i class="glyphicon glyphicon-plus"></i>点击上传快递数据
                            </button>
                        </shiro:hasPermission>
                    </div>
                </div>--%>

                <%--<div class="box-header"style="border:1px groove #000;border-style:dotted">
                    <h3 class="box-title">电力用户数据上传</h3>

                    <div class="box-tools">
                        <shiro:hasPermission name="intelligenceimportcity:add">
                            <button id="btn-power-calls" type="button" class="btn btn-primary" style="float: left">
                                <i class="glyphicon glyphicon-plus"></i>点击上传电力用户数据
                            </button>
                        </shiro:hasPermission>
                    </div>
                </div>--%>

               <%-- <div class="box-header"style="border:1px groove #000;border-style:dotted">
                    <h3 class="box-title">电力缴费数据上传</h3>

                    <div class="box-tools">
                        <shiro:hasPermission name="intelligenceimportcity:add">
                            <button id="btn-powerdata-calls" type="button" class="btn btn-primary" style="float: left">
                                <i class="glyphicon glyphicon-plus"></i>点击上传电力缴费数据
                            </button>
                        </shiro:hasPermission>
                    </div>
                </div>--%>

               <%-- <div class="box-header"style="border:1px groove #000;border-style:dotted">
                    <h3 class="box-title">新生儿数据上传</h3>

                    <div class="box-tools">
                        <shiro:hasPermission name="intelligenceimportcity:add">
                            <button id="btn-newborn-calls" type="button" class="btn btn-primary" style="float: left">
                                <i class="glyphicon glyphicon-plus"></i>点击上传新生儿数据
                            </button>
                        </shiro:hasPermission>
                    </div>
                </div>--%>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->
        </div>
    </div>

</section>
<!-- /.content -->
<%@ include file="/WEB-INF/views/admin/intelligenceimportcity/edit.jsp" %>
<%@ include file="/WEB-INF/views/admin/intelligenceimportcity/tree.jsp" %>
<%@ include file="/WEB-INF/views/admin/common/operateconfirmmodal.jsp" %>

<!-- js -->
<%@ include file="/WEB-INF/views/admin/intelligenceimportcity/listjs.jsp" %>
<%@ include file="/WEB-INF/views/admin/common/tableexportjs.jsp" %>

<%@ include file="/WEB-INF/views/admin/common/listbottom.jsp" %>