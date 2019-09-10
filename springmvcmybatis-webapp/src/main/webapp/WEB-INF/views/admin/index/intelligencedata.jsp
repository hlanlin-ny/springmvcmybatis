<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
  <%@ include file="/WEB-INF/views/admin/common/basecss.jsp" %>
  <%-- jQuery validation --%>
  <link rel="stylesheet" href="${ctxPath}/resources/plugins/jquery-validation/validation.css">
  <%-- Pace style --%>
  <link rel="stylesheet" href="${ctxPath}/resources/plugins/pace/pace.min.css">
  <title>情报数据管理</title>
</head>
<%--<body class="hold-transition skin-blue fixed sidebar-mini">--%>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <%@ include file="/WEB-INF/views/admin/index/headerModule.jsp" %>
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu">
        <li class="header">系统导航</li>


        <shiro:hasPermission name="intelligencemanagement:menu">
          <li class="treeview"><a href="#"><i class="fa fa-bullseye"></i> <span>情报设置</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
          </a>
            <ul class="treeview-menu">
              <shiro:hasPermission name="intelligencebusinesstype:list">
                <li class="active" data-url="${ctxPath}/admin/intelligencebusinesstype/list.html"><a
                        href="#"><i
                        class="fa fa-folder-o"></i> 情报分类管理</a></li>
              </shiro:hasPermission>

              <shiro:hasPermission name="intelligencesharepermission:list">
                <li data-url="${ctxPath}/admin/intelligencesharepermission/list.html"><a href="#"><i
                        class="fa fa-share-alt"></i> 情报共享授权</a></li>
              </shiro:hasPermission>

              <shiro:hasPermission name="commontool:list">
                <li data-url="${ctxPath}/admin/commontool/list.html"><a href="#"><i
                        class="fa fa-cutlery"></i> 常用工具管理</a></li>
              </shiro:hasPermission>
            </ul>
          </li>
        </shiro:hasPermission>

          <shiro:hasPermission name="intelligenceofficer:menu">
              <li class="treeview"><a href="#"><i class="fa fa-bullhorn"></i> <span>情报信息员管理</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
              </a>
                  <ul class="treeview-menu">
                      <shiro:hasPermission name="intelligenceofficer:list">
                          <li class="active" data-url="${ctxPath}/admin/intelligenceofficer/list.html"><a
                                  href="#"><i
                                  class="fa fa-file-text"></i> 情报信息员建档</a></li>
                      </shiro:hasPermission>
                      <shiro:hasPermission name="intelligence:list">
                          <li class="active" data-url="${ctxPath}/admin/intelligence/list.html"><a
                                  href="#"><i
                                  class="fa fa-bullhorn"></i> 情报信息录入</a></li>
                      </shiro:hasPermission>
                      <shiro:hasPermission name="intelligenceStatistics:list">
                          <li class="active" data-url="${ctxPath}/admin/intelligenceStatistics/list.html"><a
                                  href="#"><i
                                  class="fa fa-calculator"></i> 情报查询统计</a></li>
                      </shiro:hasPermission>
                  </ul>
              </li>
          </shiro:hasPermission>

        <shiro:hasPermission name="staticintelligence:menu">
        <li class="treeview">
          <a href="#">
                    <i class="fa fa-cloud"></i>
                    <span>静态情报数据</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
          </a>
          <ul class="treeview-menu">
              <shiro:hasPermission name="staticfilecount:list">
                  <li data-url="${ctxPath}/admin/staticfilecount/list.html"><a href="#"><i
                          class="fa fa-cloud-upload"></i> 静态数据统计</a></li>
              </shiro:hasPermission>
          <shiro:hasPermission name="intelligenceimport:list">
            <li data-url="${ctxPath}/admin/intelligenceimport/list.html"><a href="#"><i
                    class="fa fa-cloud-upload"></i> 静态情报入云</a></li>
          </shiro:hasPermission>
          <shiro:hasPermission name="intelligenceimportcity:list">
                  <li data-url="${ctxPath}/admin/intelligenceimportcity/list.html"><a href="#"><i
                          class="fa fa-cloud-upload"></i> 静态情报上传市局</a></li>
          </shiro:hasPermission>
          </ul>
        </li>
        </shiro:hasPermission>

          <shiro:hasPermission name="staticfilequery:menu">
              <li class="treeview">
                  <a href="#">
                      <i class="fa fa-cloud"></i>
                      <span>静态数据分类查询</span>
                      <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                  </a>
                  <ul class="treeview-menu">
                      <%--<shiro:hasPermission name="insurancetocity:list">
                          <li data-url="${ctxPath}/admin/insurancetocity/insuranceCityData.html"><a href="#"><i
                                  class="fa fa-cloud-upload"></i> 医保人员信息查询</a></li>
                      </shiro:hasPermission>--%>
                      <shiro:hasPermission name="medicalLettersCallsToCity:list">
                          <li data-url="${ctxPath}/admin/medicalLettersCallsToCity/medicalLettersCallsToCity.html"><a href="#"><i
                                  class="fa fa-cloud-upload"></i> 信访人员信息查询</a></li>
                      </shiro:hasPermission>
                      <shiro:hasPermission name="medicalncmstocitytransfer:list">
                          <li data-url="${ctxPath}/admin/medicalNcmsToCityTransfer/medicalNcmsToCityTransfer.html"><a href="#"><i
                                  class="fa fa-cloud-upload"></i> 新农合人员信息查询</a></li>
                      </shiro:hasPermission>
                      <%--<shiro:hasPermission name="medicalparkingtocitytransfer:list">
                          <li data-url="${ctxPath}/admin/medicalParkingToCityTransfer/medicalParkingToCityTransfer.html"><a href="#"><i
                                  class="fa fa-cloud-upload"></i> 停车场信息查询</a></li>
                      </shiro:hasPermission>--%>
                      <%--<shiro:hasPermission name="medicalstaticeconomicaltocitytransfer:list">
                          <li data-url="${ctxPath}/admin/medicalStaticEconomicalToCityTransfer/medicalStaticEconomicalToCityTransfer.html"><a href="#"><i
                                  class="fa fa-cloud-upload"></i> 电动车信息查询</a></li>
                      </shiro:hasPermission>--%>
                      <shiro:hasPermission name="gasuserinfo:list">
                          <li data-url="${ctxPath}/admin/gasuserinfo/gasuserinfo.html"><a href="#"><i
                                  class="fa fa-cloud-upload"></i> 燃气用户信息查询</a></li>
                      </shiro:hasPermission>
                      <%-- <shiro:hasPermission name="wateruserinfo:list">
                          <li data-url="${ctxPath}/admin/wateruserinfo/wateruserinfo.html"><a href="#"><i
                                  class="fa fa-cloud-upload"></i> 自来水用户信息查询</a></li>
                      </shiro:hasPermission>--%>
                      <shiro:hasPermission name="staticpeopletocity:list">
                          <li data-url="${ctxPath}/admin/staticpeopletocity/staticpeopletocity.html"><a href="#"><i
                                  class="fa fa-cloud-upload"></i> 从业人员信息查询</a></li>
                      </shiro:hasPermission>
                      <shiro:hasPermission name="statichealthytocity:list">
                          <li data-url="${ctxPath}/admin/statichealthytocity/statichealthytocity.html"><a href="#"><i
                                  class="fa fa-cloud-upload"></i> 健康证明信息查询</a></li>
                      </shiro:hasPermission>
                      <shiro:hasPermission name="accumulationfundtocity:list">
                          <li data-url="${ctxPath}/admin/accumulationfundtocity/accumulationfundtocity.html"><a href="#"><i
                                  class="fa fa-cloud-upload"></i> 公积金信息查询</a></li>
                      </shiro:hasPermission>
                      <shiro:hasPermission name="studentinfotocity:list">
                          <li data-url="${ctxPath}/admin/studentinfotocity/studentinfotocity.html"><a href="#"><i
                                  class="fa fa-cloud-upload"></i> 学生学籍信息查询</a></li>
                      </shiro:hasPermission>
                      <shiro:hasPermission name="televisoninfotocity:list">
                          <li data-url="${ctxPath}/admin/televisoninfotocity/televisoninfotocity.html"><a href="#"><i
                                  class="fa fa-cloud-upload"></i> 有线电视用户信息查询</a></li>
                      </shiro:hasPermission>
                      <shiro:hasPermission name="physicalexamination:list">
                          <li data-url="${ctxPath}/admin/physicalexamination/physicalexamination.html"><a href="#"><i
                                  class="fa fa-cloud-upload"></i> 医院体检信息查询</a></li>
                      </shiro:hasPermission>
                      <shiro:hasPermission name="vipuserinfotocity:list">
                          <li data-url="${ctxPath}/admin/vipuserinfotocity/vipuserinfotocity.html"><a href="#"><i
                                  class="fa fa-cloud-upload"></i> 会员用户信息查询</a></li>
                      </shiro:hasPermission>
                      <shiro:hasPermission name="cargpsinfotocity:list">
                          <li data-url="${ctxPath}/admin/cargpsinfotocity/cargpsinfotocity.html"><a href="#"><i
                                  class="fa fa-cloud-upload"></i> 出租车轨迹信息查询</a></li>
                      </shiro:hasPermission>
                     <%-- <shiro:hasPermission name="visitorinfotocity:list">
                          <li data-url="${ctxPath}/admin/visitorinfotocity/visitorinfotocity.html"><a href="#"><i
                                  class="fa fa-cloud-upload"></i> 游客信息查询</a></li>
                      </shiro:hasPermission>--%>
                      <%--<shiro:hasPermission name="gasfeeinfotocity:list">
                          <li data-url="${ctxPath}/admin/gasfeeinfotocity/gasfeeinfotocity.html"><a href="#"><i
                                  class="fa fa-cloud-upload"></i> 燃气缴费信息查询</a></li>
                      </shiro:hasPermission>--%>
                      <%--<shiro:hasPermission name="ecogpsinfotocity:list">
                          <li data-url="${ctxPath}/admin/ecogpsinfotocity/ecogpsinfotocity.html"><a href="#"><i
                                  class="fa fa-cloud-upload"></i> 电动车轨迹信息查询</a></li>
                      </shiro:hasPermission>--%>
                      <%--<shiro:hasPermission name="expressinfotocity:list">
                          <li data-url="${ctxPath}/admin/expressinfotocity/expressinfotocity.html"><a href="#"><i
                                  class="fa fa-cloud-upload"></i> 快递信息查询</a></li>
                      </shiro:hasPermission>--%>
                      <%--<shiro:hasPermission name="expressinfotocity:list">
                          <li data-url="${ctxPath}/admin/staticpowertocity/staticpowertocity.html"><a href="#"><i
                                  class="fa fa-cloud-upload"></i> 电力用户信息查询</a></li>
                      </shiro:hasPermission>--%>
                      <%--<shiro:hasPermission name="expressinfotocity:list">
                          <li data-url="${ctxPath}/admin/staticpowerdatatocity/staticpowerdatatocity.html"><a href="#"><i
                                  class="fa fa-cloud-upload"></i> 电力缴费信息查询</a></li>
                      </shiro:hasPermission>--%>

                  </ul>
              </li>
          </shiro:hasPermission>

        <%--<shiro:hasPermission name="dynamicintelligence:menu">
          <li class="treeview">
            <a href="#">
              <i class="fa fa-recycle"></i>
              <span>动态情报数据</span>
                       <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
            </a>
            <ul class="treeview-menu">
               &lt;%&ndash; <shiro:hasPermission name="updatingfilecount:list">
                    <li data-url="${ctxPath}/admin/updatingfilecount/list.html"><a href="#"><i
                            class="fa fa-cloud-upload"></i> 动态数据统计</a></li>
                </shiro:hasPermission>&ndash;%&gt;
              <shiro:hasPermission name="logisticsintelligence:menu">
                <li class="treeview"><a href="#"><i class="fa fa-truck"></i> <span>物流情报管理</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                  <ul class="treeview-menu">
                    <shiro:hasPermission name="logisticscompany:list">
                      <li class="active" data-url="${ctxPath}/admin/logisticscompany/list.html"><a
                              href="#"><i
                              class="fa fa-building"></i> 物流公司管理</a></li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="logisticsuser:list">
                      <li data-url="${ctxPath}/admin/logisticsuser/list.html"><a href="#"><i
                              class="fa fa-user"></i> 物流网点管理</a></li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="logisticsrecord:list">
                      <li data-url="${ctxPath}/admin/logisticsrecord/list.html"><a href="#"><i
                              class="fa fa-truck"></i> 物流记录管理</a></li>
                    </shiro:hasPermission>
                  </ul>
                </li>
              </shiro:hasPermission>
              <shiro:hasPermission name="expressintelligence:menu">
                <li class="treeview"><a href="#"><i class="fa fa-motorcycle"></i> <span>快递情报管理</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                  <ul class="treeview-menu">
                    <shiro:hasPermission name="expresscompany:list">
                      <li class="active" data-url="${ctxPath}/admin/expresscompany/list.html"><a
                              href="#"><i
                              class="fa fa-building"></i> 快递公司管理</a></li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="expressuser:list">
                      <li data-url="${ctxPath}/admin/expressuser/list.html"><a href="#"><i
                              class="fa fa-user"></i> 快递网点管理</a></li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="expressrecord:list">
                      <li data-url="${ctxPath}/admin/expressrecord/list.html"><a href="#"><i
                              class="fa fa-motorcycle"></i> 快递记录管理</a></li>
                    </shiro:hasPermission>
                  </ul>
                </li>
              </shiro:hasPermission>
              <shiro:hasPermission name="medicalinformationmanagement:menu">
                <li class="treeview"><a href="#"><i class="fa fa-user-md"></i> <span>就医情报管理</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                  <ul class="treeview-menu">
                    <shiro:hasPermission name="hospitalunitinformation:list">
                      <li class="active" data-url="${ctxPath}/admin/hospitalunitinformation/list.html"><a
                              href="#"><i
                              class="fa fa-hospital-o"></i> 医院单位管理</a></li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="hospitaluser:list">
                      <li class="active" data-url="${ctxPath}/admin/hospitaluser/list.html"><a
                              href="#"><i
                              class="fa fa-h-square"></i> 医院网点管理</a></li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="medicaloutpatientrecord:list">
                      <li class="active" data-url="${ctxPath}/admin/medicaloutpatientrecord/list.html"><a
                              href="#"><i
                              class="fa  fa-user-md"></i> 医疗门诊记录管理</a></li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="medicalcheckincheckoutrecord:list">
                      <li class="active" data-url="${ctxPath}/admin/medicalcheckincheckoutrecord/list.html"><a
                              href="#"><i
                              class="fa fa-address-book"></i> 医疗出(住)院记录管理</a></li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="medicalnewbornrecord:list">
                      <li class="active" data-url="${ctxPath}/admin/medicalnewbornrecord/list.html"><a
                              href="#"><i
                              class="fa fa-male"></i> 新生儿出生记录管理</a></li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="medicalinsurancecardrecord:list">
                      <li class="active" data-url="${ctxPath}/admin/medicalinsurancecardrecord/list.html"><a
                              href="#"><i
                              class="fa fa-address-card-o"></i> 医保刷卡记录管理</a></li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="medicalpatientrecord:list">
                      <li class="active" data-url="${ctxPath}/admin/medicalpatientrecord/list.html"><a
                              href="#"><i
                              class="fa fa fa-wheelchair"></i> 医疗机构患者记录管理</a></li>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="medicalexaminationrecord:list">
                      <li class="active" data-url="${ctxPath}/admin/medicalexaminationrecord/list.html"><a
                              href="#"><i
                              class="fa fa-stethoscope"></i> 医疗体检记录管理</a></li>
                    </shiro:hasPermission>
                  </ul>
                </li>
              </shiro:hasPermission>
            </ul>
          </li>

        </shiro:hasPermission>--%>
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper" id="main_content">
    <%--<div class="embed-responsive embed-responsive-16by9">--%>
    <%--<div style="display: none" class="embed-responsive-item loading"></div>--%>
    <%--<iframe id="content-frame" class="embed-responsive-item" frameborder="0"></iframe>--%>
    <%--</div>--%>
    <iframe id="content-frame" scrolling="yes" frameborder="0"
            style="width:100%;height:100%;min-height:200px;" src="${ctxPath}/admin/index/main.html"></iframe>
  </div>
  <!-- /.content-wrapper -->

  <footer class="main-footer" style="padding: 2px; border: none;">
  </footer>
</div>
<!-- ./wrapper -->

<%@ include file="/WEB-INF/views/admin/index/changepassword.jsp" %>
<%@ include file="/WEB-INF/views/admin/index/modulejs.jsp" %>
<%@ include file="/WEB-INF/views/admin/index/warning.jsp" %>

</body>
</html>