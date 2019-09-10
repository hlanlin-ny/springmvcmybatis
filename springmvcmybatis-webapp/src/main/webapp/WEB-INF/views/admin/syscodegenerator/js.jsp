<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/listjs.jsp" %>
<!-- 本页面用到的js -->
<script type="text/javascript">
    // To make Pace works on Ajax calls
    $(document).ajaxStart(function () {
        Pace.restart();
    });

    var tables = "";
    var codeGeneratorToOperateConfirmFlag = "code-generator";

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
                        url: "${ctxPath}/admin/syscodegenerator/queryListTables",
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
                    <shiro:lacksPermission name="syscodegenerator:generatorCode">
                    "order": [[1, "desc"]],
                    </shiro:lacksPermission>
                    <shiro:hasPermission name="syscodegenerator:generatorCode">
                    "order": [[2, "desc"]],
                    </shiro:hasPermission>
                    columns: [
                        <shiro:hasPermission name="syscodegenerator:generatorCode">
                        {
                            "data": "tableName",
                            "bSortable": false
                        },
                        </shiro:hasPermission>
                        {"data": null, "bSortable": false},
                        {"data": "tableName"},
                        {"data": "engine"},
                        {"data": "tableComment", defaultContent: ""},
                        {"data": "createTime"}
                    ],
                    //操作按钮
                    columnDefs: [
                        <shiro:hasPermission name="syscodegenerator:generatorCode">
                        {
                            "targets": [0],
                            "data": "id",
                            "render": function (data, type, full) {
                                return "<input type='checkbox' name='checkList' value='" + data + "'>";
                            }
                        }
                        </shiro:hasPermission>
                    ],
                    language: {
                        url: "${ctxPath}/resources/plugins/datatables/i18n/Chinese.json"
                    },
                    //在每次table被draw完后回调函数
                    fnDrawCallback: function () {
                        var api = this.api();
                        //获取到本页开始的条数
                        var startIndex = api.context[0]._iDisplayStart;

                        <shiro:lacksPermission name="syscodegenerator:generatorCode">
                        api.column(0).nodes().each(function (cell, i) {
                            cell.innerHTML = startIndex + i + 1;
                        });
                        </shiro:lacksPermission>

                        <shiro:hasPermission name="syscodegenerator:generatorCode">
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

        //生成代码
        $("#btn-generator").on("click", function () {
            $("#deleteConfirmForm :input").val("");

            var checkedIds = new Array();
            $("input[name='checkList']:checkbox").each(function () {
                if (true == $(this).is(":checked")) {
                    checkedIds.push($(this).val());
                }
            });
            if (checkedIds.length > 0) {
                $("#ids-to-operate-confirm").val(checkedIds.join(","));
                $("#type-to-operate-confirm").val(codeGeneratorToOperateConfirmFlag);
                $("#operate-confirm-modal").modal("show");
            }
        });

        //生成代码
        $("#btn-operate-confirm").on("click", function () {

            var url;
            var operateTypeIds = $("#ids-to-operate-confirm").val();
            var operateType = $("#type-to-operate-confirm").val();
            if (operateType == codeGeneratorToOperateConfirmFlag) {
                url = "${ctxPath}/admin/syscodegenerator/generatorCode?tables=" + operateTypeIds;
            }

            if (!url) {
                return false;
            }
            location.href = url;
            $("#operate-confirm-modal").modal("hide");
        });
    });
</script>