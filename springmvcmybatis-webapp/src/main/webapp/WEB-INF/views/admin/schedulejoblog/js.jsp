<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/listjs.jsp" %>
<!-- 本页面用到的js -->
<script type="text/javascript">
    // To make Pace works on Ajax calls
    $(document).ajaxStart(function () {
        Pace.restart();
    });

    var tables = "";

    $().ready(function () {

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
                        url: "${ctxPath}/admin/schedulejoblog/queryList",
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
                    "order": [[1, "desc"]],
                    columns: [
                        {"data": null, "bSortable": false},
                        {"data": "id"},
                        {"data": "beanName"},
                        {"data": "methodName"},
                        {"data": "params"},
                        {
                            "data": "status",
                            "render": function (data, type, full, callback) {
                                if (data == "0") {
                                    return "<span class='label label-success'>成功</span>";
                                }
                                return "<span class='label label-danger'>失败</span>";
                            }
                        },
                        {
                            "data": "error",
                            "render": function (data, type, full, callback) {
                                return "<textarea class='form-control' id='remark' rows='2' readonly>" + data + "</textarea>";
                            }
                        },
                        {"data": "times"},
                        {"data": "createdTime"},
                        {"data": "createdBy"},
                        {"data": "createdIp"}
                    ],
                    language: {
                        url: "${ctxPath}/resources/plugins/datatables/i18n/Chinese.json"
                    },
                    //在每次table被draw完后回调函数
                    fnDrawCallback: function () {
                        var api = this.api();
                        //获取到本页开始的条数
                        var startIndex = api.context[0]._iDisplayStart;
                        api.column(0).nodes().each(function (cell, i) {
                            cell.innerHTML = startIndex + i + 1;
                        });
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

        //刷新
        $("#btn-refresh").on("click", function () {
            tables.fnDraw(false);
        });

    });
</script>