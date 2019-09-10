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
    var tablesShow = "";
    var deleteToOperateConfirmFlag = "delete";
    var batchDeleteToOperateConfirmFlag = "batch-delete";

    $.validator.setDefaults({
        submitHandler: function () {
            $.ajax({
                cache: false,
                type: "POST",
                url: url,
                data: $("#edit-form").serializeJSON(),
                contentType: "application/json;charset=UTF-8",
                success: function (data) {
                    if (data.code == 0) {
                        $("#edit-modal").modal("hide");
                        tables.fnDraw();
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

    //Date range picker
    $('#reservation').daterangepicker(
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
    $("#reservation").on('hide.daterangepicker', function (ev, picker) {
        $('#extra-search-reportingTimeStart').val(picker.startDate.format('YYYY-MM-DD'));
        $('#extra-search-reportingTimeEnd').val(picker.endDate.format('YYYY-MM-DD'));
    });

    $().ready(function () {
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
                        url: "${ctxPath}/admin/intelligenceStatistics/queryList",
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
                    "order": [[6, "desc"]],
                    columns: [
                        {"data": "name","bSortable": false},
                        {"data": "idNumbers", defaultContent: ""},
                        {
                            "data": "isOfficer",
                            "render": function (data, type, full, callback) {
                                if (data == true) {
                                    return "是";
                                } else {
                                    return "否";
                                }
                                return "";
                            }
                        },
                        {"data": "sum1", defaultContent: ""},
                        {"data": "sum2", defaultContent: ""},
                        {"data": "sum3",defaultContent: "" },
                        {"data": "counts", defaultContent: ""}
                    ],
                    //操作按钮
                    columnDefs: [
                        {
                            targets:[3],
                            "data": "sum1",
                            "render": function (data, type, full) {
                                return "<div class='btn-group'>" +
                                        "<button type='button' id='btn-show-row1' data-toggle='tooltip' data-container='body' title='详情'><i>"+data+" </i></button>" +
                                        "</div>"
                            }
                        },
                        {
                            targets:[4],
                            "data": "sum2",
                            "render": function (data, type, full) {
                                return "<div class='btn-group'>" +
                                        "<button type='button' id='btn-show-row2' data-toggle='tooltip' data-container='body' title='详情'><i>"+data+" </i></button>" +
                                        "</div>"
                            }
                        } ,
                        {
                            targets:[5],
                            "data": "sum3",
                            "render": function (data, type, full) {
                                return "<div class='btn-group'>" +
                                        "<button type='button' id='btn-show-row3' data-toggle='tooltip' data-container='body' title='详情'><i>"+data+" </i></button>" +
                                        "</div>"
                            }
                        },
                        {
                            targets:[6],
                            "data": "counts",
                            "render": function (data, type, full) {
                                return "<div class='btn-group'>" +
                                        "<button type='button' id='btn-show-row4' data-toggle='tooltip' data-container='body' title='详情'><i>"+data+" </i></button>" +
                                        "</div>"
                            }
                        }
                    ],
                    language: {
                        url: "${ctxPath}/resources/plugins/datatables/i18n/Chinese.json"
                    },
                    //在每次table被draw完后回调函数
                    fnDrawCallback: function () {
                        var api = this.api();
                        //获取到本页开始的条数
                        var startIndex = api.context[0]._iDisplayStart;
                    },
                    "fnInitComplete":function(){
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

        //加载上传人（信息员）
        $("#extra-search-intelligenceOfficerId").append("<option value=''>全部</option>");
        $.ajax({
            type: "get",
            url: '${ctxPath}/admin/intelligenceofficer/queryOfficerNames',
            contentType: "application/json;charset=UTF-8",
            cache: false,
            success: function (json) {
                var names = json.result;
                $.each(names,function(idx,item){
                    $("#extra-search-intelligenceOfficerId").append("<option value='"+item['id']+"'>"+item['name']+"</option>");
                })
            }
        });
        //Initialize Select2 Elements
        $(".select2").select2();


        //------------情报详细展示----------------
        tablesShow = $("#data-table-show")
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
                        url: "${ctxPath}/admin/intelligence/queryList",
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
                            //d['extra-search-idNumbers'] = idNumbers;
                            //d['extra-search-level'] = args;
                            return d;
                        }
                    },
                    columns: [
                        {"data": "title", defaultContent: ""},
                        {"data": "intelligenceOfficerName", defaultContent: ""},
                        {"data": "reportingTime", defaultContent: ""},
                        {
                            "data": "infoDesc",
                            "render": function (data, type, full, callback) {
                                return "<textarea class='form-control' rows='2' readonly>" + data + "</textarea>";
                            }
                        },
                        {"data": "foundTime", defaultContent: ""},
                        {
                            "data": "level",
                            "render": function (data, type, full, callback) {
                                if (data == 0) {
                                    return "一般";
                                } else if (data == 1) {
                                    return "重要";
                                } else if (data == 2) {
                                    return "非常重要";
                                }
                                return "";
                            }
                        },
                        {
                            "data": "awardsStatus",
                            "render": function (data, type, full, callback) {
                                if (data == true) {
                                    return "已奖励";
                                } else if (data == false) {
                                    return "未奖励";
                                }
                                return "";
                            }
                        },
                        {
                            "data": "awardsDesc",
                            "render": function (data, type, full, callback) {
                                return "<textarea class='form-control' rows='2' readonly>" + data + "</textarea>";
                            }
                        },
                        {"data": "remark", defaultContent: ""}
                    ],
                    language: {
                        url: "${ctxPath}/resources/plugins/datatables/i18n/Chinese.json"
                    },
                    //在每次table被draw完后回调函数
                    fnDrawCallback: function () {
                        var api = this.api();
                        //获取到本页开始的条数
                        var startIndex = api.context[0]._iDisplayStart;
                    },
                    "fnInitComplete":function(){
                        this.width("100%");
                        this.fnAdjustColumnSizing();//重置列宽
                        this.fnDraw();//重新绘制
                    }
                });
        //-------------------------
        //详情
        $("#data-table tbody").on("click", "#btn-show-row1",function(){
            var data = tables.api().row($(this).parents("tr")).data();
            $('#extra-search-idNumbers').val(data.idNumbers);
            $('#extra-search-level').val(0);
            $("#show-modal").modal("show");
            tablesShow.fnDraw();
        });
        $("#data-table tbody").on("click", "#btn-show-row2",function(){
            var data = tables.api().row($(this).parents("tr")).data();
            $('#extra-search-idNumbers').val(data.idNumbers);
            $('#extra-search-level').val(1);
            $("#show-modal").modal("show");
            tablesShow.fnDraw();
        });
        $("#data-table tbody").on("click", "#btn-show-row3",function(){
            var data = tables.api().row($(this).parents("tr")).data();
            $('#extra-search-idNumbers').val(data.idNumbers);
            $('#extra-search-level').val(2);
            $("#show-modal").modal("show");
            tablesShow.fnDraw();
        });
        $("#data-table tbody").on("click", "#btn-show-row4",function(){
            var data = tables.api().row($(this).parents("tr")).data();
            $('#extra-search-idNumbers').val(data.idNumbers);
            $('#extra-search-level').val("");
            $("#show-modal").modal("show");
            tablesShow.fnDraw();
        });
    });
</script>