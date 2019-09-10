<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/listjs.jsp" %>
<!-- 本页面用到的js -->
<script type="text/javascript">
    // To make Pace works on Ajax calls
    $(document).ajaxStart(function () {
        Pace.restart();
    });

    //添加、修改异步提交地址
    var url = "";
    var tables = "";
    var deleteToOperateConfirmFlag = "delete";
    var batchDeleteToOperateConfirmFlag = "batch-delete";

    function formatTen(num) {
        return num > 9 ? (num + "") : ("0" + num);
    }

    function formatDate(date) {
        var year = date.getFullYear();
        var month = date.getMonth() + 1;
        var day = date.getDate();
        var hour = date.getHours();
        var minute = date.getMinutes();
        var second = date.getSeconds();
        return year + "-" + formatTen(month) + "-" + formatTen(day);
    }

    function formatTime(date) {
        var year = date.getFullYear();
        var month = date.getMonth() + 1;
        var day = date.getDate();
        var hour = date.getHours();
        var minute = date.getMinutes();
        var second = date.getSeconds();
        return year + "-" + formatTen(month) + "-" + formatTen(day)+" "+formatTen(hour)+":"+formatTen(minute)+":"+formatTen(second);
    }

    $.validator.setDefaults({
        submitHandler: function () {
            var controlByName = $("#controlByName").html();
            var nickName = $("#nickName").html();
            var sex = $("#sex").val();
            var bornTime = $("#bornTime").html();
            var nation = $("#nation").html();
            var cardType = $("#cardType").html();
            var cardNumber = $("#cardNumber").html();
            var address = $("#address").html();
            var workUnit = $("#workUnit").html();
            var controlReason = $("#controlReason").html();
            var remark = $("#remark").html();
            var controlMeasureRequire = $("#controlMeasureRequire").val();
            var controlBeginTime = $("#controlBeginTime").html();
            var controlDays = $("#controlDays").val();
            var controlEndTime = $("#controlEndTime").html();
            var controlUnit = $("#controlUnit").html();
            var feedBackContact = $("#feedBackContact").html();
            var applyUnit = $("#applyUnit").html();
            var applyUnitContactTel = $("#applyUnitContactTel").html();
            var applyName = $("#applyName").html();
            var applyUnitPrincipal = $("#applyUnitPrincipal").html();
            var applySafeOrgan = $("#applySafeOrgan").val();
            var data = {controlByName:controlByName,nickName:nickName,sex:sex,bornTime:bornTime,nation:nation,
                cardType:cardType,cardNumber:cardNumber,address:address,workUnit:workUnit,controlReason:controlReason,
                remark:remark,controlMeasureRequire:controlMeasureRequire,controlBeginTime:controlBeginTime,controlDays:
                        controlDays,controlEndTime:controlEndTime,controlUnit:controlUnit
            ,feedBackContact:feedBackContact,applyUnit:applyUnit,applyUnitContactTel:applyUnitContactTel,applyName:applyName
            ,applyUnitPrincipal:applyUnitPrincipal,applySafeOrgan:applySafeOrgan};
            console.log(data);
            $.ajax({
                cache: false,
                type: "POST",
                url: url,
                data: data,
                success: function (data) {
                    if (data.code == 0) {
                        $("#edit-modal").modal("hide");
                        tables.fnDraw(false);
                        $.toaster("提交成功", "系统提示");
                    } else {
                        console.log("服务异常:" + data);
                        $.toaster("异常信息:" + data.message, "服务异常", "danger");
                    }
                },
                error: function (data) {
                    console.log("请求异常:" + data);
                    $.toaster("请求异常:" + data, "请求异常", "danger");
                }
            });
        }
    });

    $().ready(function () {
        $('.modal').on('shown.bs.modal', function () {
            $(this).find('input:text:visible:first').focus();
        });

        // 提交时验证表单
        var validator = $("#edit-form").validate();

        $("#btn-cancel").on("click", function () {
            validator.resetForm();
        });

        tables = $("#data-table")
                .dataTable({
                    serverSide: true,
                    paging: true,
                    processing: true,
                    pageLength: 10,
                    ordering: true,
                    pagingType: "full_numbers",
                    stateSave: true,
                    searching: false,
                    ajax: {
                        type: "post",
                        url: "${ctxPath}/admin/controlapplyapplication/queryList",
                        dataSrc: function (json) {
                            json.draw = json.result.draw;
                            json.recordsTotal = json.result.recordsTotal;
                            json.recordsFiltered = json.result.recordsFiltered;
                            return json.result.data;
                        },
                        data: function (d) {
                            var formData = $("#query-form").serializeArray();
                            formData.forEach(function (e) {
                                d[e.name] = e.value;
                            });
                            return d;
                        }
                    },
                    <shiro:lacksPermission name="controlapplyapplication:batchdelete">
                    "order": [[1, "desc"]],
                    </shiro:lacksPermission>
                    columns: [
                        <shiro:hasPermission name="controlapplyapplication:batchdelete">
                        {
                            "data": "id",
                            "bSortable": false
                        },
                        </shiro:hasPermission>
                        {"data": "id"},
                        {"data": "controlByName", defaultContent: ""},
                        {"data": "sex", defaultContent: ""},
                        {"data": "bornTime", defaultContent: ""},
                        {"data": "cardNumber", defaultContent: ""},
                        {"data": "address", defaultContent: ""},
                        {"data": "controlReason", defaultContent: ""},
                        {"data": "controlUnit", defaultContent: ""},
                        {"data": "applyName", defaultContent: ""},
                        {"data": "applyUnit", defaultContent: ""},
                        {
                            "data": "status",
                            "render": function (data, type, full, callback) {
                                if (data == "布控中") {
                                    return "<span class='label label-success'>布控中</span>";
                                }else if(data == "失效"){
                                    return "<span class='label label-danger'>失效</span>";
                                }
                            }
                        }
                        <myshiro:hasAnyPermission permissions="controlapplyapplication:detail,controlapplyapplication:delete">
                        ,
                        {"data": null, "bSortable": false}
                        </myshiro:hasAnyPermission>
                    ],
                    //操作按钮
                    columnDefs: [
                        <shiro:hasPermission name="controlapplyapplication:batchdelete">
                        {
                            "targets": [0],
                            "data": "id",
                            "render": function (data, type, full) {
                                return "<input type='checkbox' name='checkList' value='" + data + "'>";
                            }
                        },
                        </shiro:hasPermission>
                        <myshiro:hasAnyPermission permissions="controlapplyapplication:detail,controlapplyapplication:delete">
                        {
                            targets: -1,
                            "data": "id",
                            "render": function (data, type, full) {
                                if(data.status=="布控中"){
                                    return "<div class='btn-group'>" +
                                            <shiro:hasPermission name="controlapplyapplication:detail">
                                            "<button type='button' id='btn-detail-row' class='btn btn-default btn-sm' data-toggle='tooltip' data-container='body' title='详 情'><i class='fa fa-info'></i></button>" +
                                            </shiro:hasPermission>
                                            <shiro:hasPermission name="controlapplyapplication:delete">
                                            "<button type='button' id='btn-del-row' class='btn btn-default btn-sm' data-toggle='tooltip' data-container='body' title='删 除'><i class='fa fa-trash-o'></i></button>" +
                                            </shiro:hasPermission>
                                            "</div>";
                                }else{
                                    return "<div class='btn-group'>" +
                                            <shiro:hasPermission name="controlapplyapplication:detail">
                                            "<button type='button' id='btn-control-row' class='btn btn-default btn-sm' data-toggle='tooltip' data-container='body' title='重新布控'><i class='fa fa-wrench'></i></button>" +
                                            </shiro:hasPermission>
                                            <shiro:hasPermission name="controlapplyapplication:delete">
                                            "<button type='button' id='btn-del-row' class='btn btn-default btn-sm' data-toggle='tooltip' data-container='body' title='删 除'><i class='fa fa-trash-o'></i></button>" +
                                            </shiro:hasPermission>
                                            "</div>";
                                }

                            }
                        }
                        </myshiro:hasAnyPermission>
                    ],
                    language: {
                        url: "${ctxPath}/resources/plugins/datatables/i18n/Chinese.json"
                    },
                    //在每次table被draw完后回调函数
                    fnDrawCallback: function () {
                        var api = this.api();
                        //获取到本页开始的条数
                        var startIndex = api.context[0]._iDisplayStart;

                        <shiro:lacksPermission name="controlapplyapplication:batchdelete">
                        api.column(0).nodes().each(function (cell, i) {
                            cell.innerHTML = startIndex + i + 1;
                        });
                        </shiro:lacksPermission>

                        <shiro:hasPermission name="controlapplyapplication:batchdelete">
                        api.column(1).nodes().each(function (cell, i) {
                            cell.innerHTML = startIndex + i + 1;
                        });

                        $("input").iCheck({
                            checkboxClass: "icheckbox_square-blue",
                            radioClass: "iradio_square-blue"
                        });

                        //checkbox全选
                        $("#checkAll").on("ifChecked", function () {
                            $("input[name='checkList']:checkbox").iCheck("check");
                            $("#data-table tbody tr").addClass("selected");
                        });

                        //checkbox全不选
                        $("#checkAll").on("ifUnchecked", function () {
                            $("input[name='checkList']:checkbox").iCheck("uncheck");
                            $("#data-table tbody tr").removeClass("selected");
                        });
                        </shiro:hasPermission>
                    },
                    "fnInitComplete": function () {
                        this.width("100%");
                        this.fnAdjustColumnSizing();//重置列宽
                        this.fnDraw();//重新绘制
                    }
                });

        //查询按钮
        $("#btn-search").on("click", function () {
            tables.fnDraw();
            return false;
        });

        //重置
        $("#btn-reset").on("click", function () {
            $("#query-form :input").val("");
            tables.fnDraw(false);
        });

        //添加
        $("#btn-add").on("click", function () {
            url = "${ctxPath}/admin/controlapplyapplication/addApplyApplication";
            $("#edit-modal-label").html("临时布控单");
            $(".td_select").select2().val("").trigger("change");
            $(".td_select").select2({
                placeholder:"请选择",
                allowClear:true
            }).change();
            $(".td_auto_select").select2().val("").trigger("change");
            $(".td_auto_select").select2({
                placeholder:"请选择",
                allowClear:true,
                tags: true
            }).change();

            $(".td_value").html("");
            $("#edit-modal").modal("show");
        });

        //批量删除
        $("#btn-delAll").on("click", function () {
            $("#deleteConfirmForm :input").val("");

            var checkedIds = new Array();
            $("input[name='checkList']:checkbox").each(function () {
                if (true == $(this).is(":checked")) {
                    checkedIds.push($(this).val());
                }
            });
            if (checkedIds.length > 0) {
                $("#ids-to-operate-confirm").val(JSON.stringify(checkedIds));
                $("#type-to-operate-confirm").val(batchDeleteToOperateConfirmFlag);
                $("#operate-confirm-modal").modal("show");
            }
        });

        //刷新
        $("#btn-refresh").on("click", function () {
            tables.fnDraw(false);
        });

        //详情
        $("#data-table tbody").on("click", "#btn-detail-row", function () {
            $(".td_value").html("");
            var data = tables.api().row($(this).parents("tr")).data();
            $("#detail_controlByName").html(data.controlByName);
            $("#detail_nickName").html(data.nickName);
            $("#detail_sex").html(data.sex);
            $("#detail_bornTime").html(data.bornTime);
            $("#detail_nation").html(data.nation);
            $("#detail_cardType").html(data.cardType);
            $("#detail_cardNumber").html(data.cardNumber);
            $("#detail_address").html(data.address);
            $("#detail_workUnit").html(data.workUnit);
            $("#detail_controlReason").html(data.controlReason);
            $("#detail_controlMeasureRequire").html(data.controlMeasureRequire);
            $("#detail_controlBeginTime").html(data.controlBeginTime);
            $("#detail_controlEndTime").html(data.controlEndTime);
            $("#detail_controlDays").html(data.controlDays);
            $("#detail_controlUnit").html(data.controlUnit);
            $("#detail_feedBackContact").html(data.feedBackContact);
            $("#detail_applyUnit").html(data.applyUnit);
            $("#detail_applyUnitContactTel").html(data.applyUnitContactTel);
            $("#detail_applyName").html(data.applyName);
            $("#detail_applyUnitPrincipal").html(data.applyUnitPrincipal);
            $("#detail_applySafeOrgan").html(data.applySafeOrgan);
            $("#detail_remark").html(data.remark);
            $("#detail-modal").modal("show");
        });

        //删除
        $("#data-table tbody").on("click", "#btn-del-row", function () {
            $("#operate-confirm-form :input").val("");
            var data = tables.api().row($(this).parents("tr")).data();
            $("#ids-to-operate-confirm").val(data.id);
            $("#type-to-operate-confirm").val(deleteToOperateConfirmFlag);
            $("#operate-confirm-modal").modal("show");
        });

        //删除
        $("#btn-operate-confirm").on("click", function () {

            var url;
            var data;
            var operateTypeIds = $("#ids-to-operate-confirm").val();
            var operateType = $("#type-to-operate-confirm").val();
            if (operateType == deleteToOperateConfirmFlag) {
                url = "${ctxPath}/admin/controlapplyapplication/" + operateTypeIds + "/delete";
                data = "";
            } else if (operateType == batchDeleteToOperateConfirmFlag) {
                url = "${ctxPath}/admin/controlapplyapplication/batch/delete";
                data = operateTypeIds;
            }

            if (!url) {
                return false;
            }

            $.ajax({
                cache: "false",
                url: url,
                type: "POST",
                data: data,
                contentType: "application/json;charset=UTF-8",
                success: function (data) {
                    if (data.code == 0) {
                        $("#operate-confirm-modal").modal("hide");
                        tables.api().row().remove().draw(false);
                        $.toaster("提交成功", "系统提示");
                        $("#operate-confirm-form :input").val("");
                        $("#checkAll").iCheck("uncheck");
                        $("#checkAll").removeClass("selected");
                    } else {
                        console.log("服务异常:" + data);
                        $.toaster("异常信息:" + data.message, "服务异常", "danger");
                    }
                },
                error: function (data) {
                    console.log("请求异常:" + data);
                    $.toaster("请求异常:" + data, "请求异常", "danger");
                }
            });
        });
        //监听选择布控时间事件
        $("#controlDays").on("change",function(){
             var day = $("#controlDays").val();
             var now = new Date();
             var end = new Date(now.getTime()+(day*24*60*60*1000));
             now = formatTime(now);
             end = formatTime(end);
            $("#controlBeginTime").html(now);
            $("#controlEndTime").html(end);
        });

        $(".select2").select2({
            placeholder:"请选择",
            allowClear:true
        });
        $(".select_day").select2({
            placeholder:"请选择",
            allowClear:true
        });
        $(".select_require").select2({
            placeholder:"请选择",
            allowClear:true,
            tags: true
        });

        $("#bornTime").datetimepicker({
            weekStart: 1,
            todayHighlight: 1,
            timepicker:false,
            startView: 2,
            minView : 2,
            forceParse: 0,
            todayBtn:  true,
            language: "zh-CN",
            autoclose:"true",
            showMeridian: 1,
            pickerPosition:'buttom-right',
            format: 'yyyy-mm-dd hh:ii:ss'
        });
        $('#bornTime')
                .datetimepicker()
                .on('changeDate', function(ev){
                    var date = new Date(ev.date);
                    date_value=formatDate(date);
                    $("#bornTime").html(date_value);
                });

        //Date range picker
        $('#extra-search-controlTime').daterangepicker(
                {
                    locale: {
                        format: 'YYYY-MM-DD', //控件中from和to 显示的日期格式
                        applyLabel: '确定',
                        cancelLabel: '取消',
                        fromLabel: '起始时间',
                        toLabel: '结束时间',
                        customRangeLabel: '自定义',
                        daysOfWeek: ['日', '一', '二', '三', '四', '五', '六'],
                        monthNames: ['一月', '二月', '三月', '四月', '五月', '六月',
                            '七月', '八月', '九月', '十月', '十一月', '十二月'],
                        firstDay: 1
                    },
                    startDate: moment().subtract(7, 'days'),
                    endDate: moment()
                }
        ).val("");

        //选择时间后触发重新加载的方法
        $("#extra-search-controlTime").on('hide.daterangepicker', function (ev, picker) {
            $('#extra-search-controlBeginTime').val(picker.startDate.format('YYYY-MM-DD'));
            $('#extra-search-controlEndTime').val(picker.endDate.format('YYYY-MM-DD'));
        });

    });
</script>