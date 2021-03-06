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


    $().ready(function () {
        $('.modal').on('shown.bs.modal', function () {
            $(this).find('input:text:visible:first').focus();
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
                        url: "${ctxPath}/admin/medicalcheckincheckoutrecord/queryList",
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
                    "order": [[0, "desc"]],
                    columns: [
                        {"data": 'id'},
                        {"data": "name", defaultContent: "", "bSortable": false},
                        {"data": "idCardNum", defaultContent: "", "bSortable": false},
                        {"data": "phone", defaultContent: "", "bSortable": false},
                        {"data": "profession", defaultContent: "", "bSortable": false},
                        {"data": "hospitalizationNo", defaultContent: ""},
                        {"data": "hospitalizationDepartment", defaultContent: "", "bSortable": false},
                        {"data": "hospitalizationDatetime", defaultContent: ""},
                        {"data": "leavehospitalDatetime", defaultContent: ""}

                        <myshiro:hasAnyPermission permissions="medicalcheckincheckoutrecord:detail">
                        ,
                        {"data": null, "bSortable": false}
                        </myshiro:hasAnyPermission>
                    ],
                    //操作按钮
                    columnDefs: [
                        <myshiro:hasAnyPermission permissions="medicalcheckincheckoutrecord:detail">
                        {
                            targets: -1,
                            "data": "id",
                            "render": function (data, type, full) {
                                var url = data.detailsUrl;
                                return "<div class='btn-group'>" +
                                        "<a href='" + url + "' target='_blank'>"+
                                        "<button type='button' id='btn-detail-row' class='btn btn-default btn-sm' data-toggle='tooltip' data-container='body' title='详 情'><i class='fa fa-info'>" +
                                        "</i></button>" +
                                        "</a>" +
                                        "</div>";
                            }
                        }
                        </myshiro:hasAnyPermission>
                    ],
                    language: {
                        url: "${ctxPath}/resources/plugins/datatables/i18n/Chinese.json"
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


        //刷新
        $("#btn-refresh").on("click", function () {
            tables.fnDraw(false);
        });



        //同步到总表
        $("#btn-update").on("click", function () {
            $.ajax({
                cache: "false",
                url: "${ctxPath}/admin/medicalcheckincheckoutrecord/updatetocommon",
                type: "POST",
                data: null,
                contentType: "application/json;charset=UTF-8",
                success: function (data) {
                    console.log(data);
                    $.toaster("提交成功", "系统提示");
                },
                error: function (data) {
                    console.log("请求异常:" + data);
                    $.toaster("请求异常:" + data, "请求异常", "danger");
                }
            });
        });

        $(".box-tools").on("click", "#btn-export-excel", function () {
            var formElement = document.createElement('form');
            formElement.setAttribute('id','batchfiledownload');
            formElement.setAttribute('action','${ctxPath}/admin/medicalcheckincheckoutrecord/batch/export');
            formElement.setAttribute('method','post');
            $(document.body).append($(formElement));
            $(formElement).submit();
        });

        //Date range picker
        $('#extra-search-hospitalizationDatetime').daterangepicker(
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
        $("#extra-search-hospitalizationDatetime").on('hide.daterangepicker', function (ev, picker) {
            $('#extra-search-hospitalizationDatetimeBegin').val(picker.startDate.format('YYYY-MM-DD'));
            $('#extra-search-hospitalizationDatetimeEnd').val(picker.endDate.format('YYYY-MM-DD'));
        });

        //Date range picker
        $('#extra-search-leavehospitalDatetime').daterangepicker(
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
        $("#extra-search-leavehospitalDatetime").on('hide.daterangepicker', function (ev, picker) {
            $('#extra-search-leavehospitalDatetimeBegin').val(picker.startDate.format('YYYY-MM-DD'));
            $('#extra-search-leavehospitalDatetimeEnd').val(picker.endDate.format('YYYY-MM-DD'));
        });


        $("#hospitalizationDatetime").datetimepicker({
            showSecond: true,
            weekStart: 1,
            todayHighlight: 1,
            startView: 2,
            stepHour: 1,
            forceParse: 0,
            stepMinute: 1,
            stepSecond: 1,
            todayBtn:  true,
            language: "zh-CN",
            autoclose:"true",
            showMeridian: 1,
            pickerPosition:'top-right',
            format: 'yyyy-mm-dd hh:ii:ss'
        });

        $("#leavehospitalDatetime").datetimepicker({
            showSecond: true,
            weekStart: 1,
            todayHighlight: 1,
            startView: 2,
            stepHour: 1,
            forceParse: 0,
            stepMinute: 1,
            stepSecond: 1,
            todayBtn:  true,
            language: "zh-CN",
            autoclose:"true",
            showMeridian: 1,
            pickerPosition:'top-right',
            format: 'yyyy-mm-dd hh:ii:ss'
        });

        //加载所属用户
        var item = "<option value=''>全部</option>";
        $('#extra-search-userId').append(item);
        $.get("${ctxPath}/admin/hospitaluser/queryHospitalUsersByAreaId", function (data) {
            $.each(data.result,
                    function (i, result) {
                        item = "<option value='" + result['id'] + "'>" + result['branchName'] + "</option>";
//                        $('#userId').append(item);
                        $('#extra-search-userId').append(item);
                    })
        });

        //Initialize Select2 Elements
        $(".select2").select2();
        $("#extra-search-userId").find("option").eq(0).attr("selected", "selected");

    });
</script>