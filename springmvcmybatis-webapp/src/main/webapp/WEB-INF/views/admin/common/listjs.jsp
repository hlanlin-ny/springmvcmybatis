<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/basejs.jsp" %>
<%-- PACE --%>
<script src="${ctxPath}/resources/plugins/pace/pace.min.js"></script>
<%-- Select2 --%>
<script src="${ctxPath}/resources/plugins/select2/select2.full.min.js"></script>
<script type="text/javascript">
    $.fn.modal.Constructor.prototype.enforceFocus = function () {};
</script>
<%-- InputMask --%>
<script src="${ctxPath}/resources/plugins/input-mask/jquery.inputmask.js"></script>
<script src="${ctxPath}/resources/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="${ctxPath}/resources/plugins/input-mask/jquery.inputmask.extensions.js"></script>

<%-- bootstrap datepicker --%>
<%--<script src="${ctxPath}/resources/plugins/datepicker/bootstrap-datepicker.js"></script>--%>
<%--<script src="${ctxPath}/resources/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>--%>
<%-- bootstrap time picker --%>
<%--<script src="${ctxPath}/resources/plugins/timepicker/bootstrap-timepicker.min.js"></script>--%>
<%-- date-range-picker --%>
<script src="${ctxPath}/resources/plugins/moment/moment.min.js"></script>
<script src="${ctxPath}/resources/plugins/daterangepicker/daterangepicker.js"></script>
<%--bootstrap datetimepicker--%>
<script src="${ctxPath}/resources/plugins/datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<script src="${ctxPath}/resources/plugins/datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<%-- bootstrap color picker --%>
<script src="${ctxPath}/resources/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<%-- SlimScroll 1.3.0 --%>
<script src="${ctxPath}/resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<%-- iCheck 1.0.1 --%>
<script src="${ctxPath}/resources/plugins/iCheck/icheck.min.js"></script>
<%-- DataTables --%>
<script src="${ctxPath}/resources/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="${ctxPath}/resources/plugins/datatables/dataTables.bootstrap.min.js"></script>
<%-- DataTables Responsive --%>
<script src="${ctxPath}/resources/plugins/datatables/extensions/Responsive/js/dataTables.responsive.min.js"></script>
<%-- jQuery Toaster --%>
<script src="${ctxPath}/resources/plugins/toaster/jquery.toaster.js"></script>
<%-- jQuery validation --%>
<script src="${ctxPath}/resources/plugins/jquery-validation/jquery.validate.min.js"></script>
<script src="${ctxPath}/resources/plugins/jquery-validation/localization/messages_zh.js"></script>
<%-- jQuery serializeObject --%>
<script src="${ctxPath}/resources/plugins/serializeobject/jquery.serialize-object.min.js"></script>
<%-- zTree --%>
<script src="${ctxPath}/resources/plugins/zTree/js/jquery.ztree.all.min.js"></script>
<%-- json2 --%>
<script src="${ctxPath}/resources/plugins/json2/json2.js"></script>
<%--jquery form--%>
<script src="${ctxPath}/resources/plugins/jquey-form/jquery-form.js"></script>