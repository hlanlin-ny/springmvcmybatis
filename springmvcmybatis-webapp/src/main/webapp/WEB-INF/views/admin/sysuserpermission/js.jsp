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
                        url: "${ctxPath}/admin/sysuserpermission/queryList",
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
                    <shiro:lacksPermission name="sysuserpermission:batchdelete">
                    "order": [[1, "desc"]],
                    </shiro:lacksPermission>
                    <shiro:hasPermission name="sysuserpermission:batchdelete">
                    "order": [[2, "desc"]],
                    </shiro:hasPermission>
                    columns: [
                        <shiro:hasPermission name="sysuserpermission:batchdelete">
                        {
                            "data": "id",
                            "bSortable": false
                        },
                        </shiro:hasPermission>
                        {"data": null, "bSortable": false},
                        {"data": "id"},
                        {"data": "name"},
                        {
                            "data": "type",
                            "render": function (data, type, full, callback) {
                                if (data == "1") {
                                    return "<span class='label label-primary'>系统</span>";
                                } else if (data == "2") {
                                    return "<span class='label label-info'>目录</span>";
                                } else if (data == "3") {
                                    return "<span class='label label-success'>菜单</span>";
                                } else if (data == "4") {
                                    return "<span class='label label-warning'>按钮</span>";
                                } else if (data == "5") {
                                    return "<span class='label label-danger'>接口</span>";
                                }
                            }
                        },
                        {"data": "parentName"},
                        {"data": "url"},
                        {"data": "permissionCode"},
                        {
                            "data": "icon",
                            "render": function (data, type, full, callback) {
                                if (data.length == "0") {
                                    return "";
                                }
                                return "<i class='" + data + "'></i>";
                            }
                        },
                        {"data": "orderNum"},
                        {"data": "remark", defaultContent: ""}
                        <myshiro:hasAnyPermission permissions="sysuserpermission:edit,sysuserpermission:delete">
                        ,
                        {"data": null, "bSortable": false}
                        </myshiro:hasAnyPermission>
                    ],
                    //操作按钮
                    columnDefs: [
                        <shiro:hasPermission name="sysuserpermission:batchdelete">
                        {
                            "targets": [0],
                            "data": "id",
                            "render": function (data, type, full) {
                                return "<input type='checkbox' name='checkList' value='" + data + "'>";
                            }
                        },
                        </shiro:hasPermission>
                        <myshiro:hasAnyPermission permissions="sysuserpermission:edit,sysuserpermission:delete">
                        {
                            targets: -1,
                            defaultContent: "<div class='btn-group'>" +
                            <shiro:hasPermission name="sysuserpermission:edit">
                            "<button type='button' id='btn-edit-row' class='btn btn-default btn-sm' data-toggle='tooltip' data-container='body' title='编 辑'><i class='fa fa-edit'></i></button>" +
                            </shiro:hasPermission>
                            <shiro:hasPermission name="sysuserpermission:delete">
                            "<button type='button' id='btn-del-row' class='btn btn-default btn-sm' data-toggle='tooltip' data-container='body' title='删 除'><i class='fa fa-trash-o'></i></button>" +
                            </shiro:hasPermission>
                            "</div>"
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

                        <shiro:lacksPermission name="sysuserpermission:batchdelete">
                        api.column(0).nodes().each(function (cell, i) {
                            cell.innerHTML = startIndex + i + 1;
                        });
                        </shiro:lacksPermission>

                        <shiro:hasPermission name="sysuserpermission:batchdelete">
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

        //添加
        $("#btn-add").on("click", function () {
            url = "${ctxPath}/admin/sysuserpermission/add";
            $("#edit-modal-label").html("添加");
            $("#edit-form :input").val("");
            $("#type").find("option").eq(0).attr("selected", "selected");
            $("#orderNum").val(1);
            $("#edit-form :input").parent().parent().hide();
            $("#id").parent().parent().show();
            $("#type").parent().parent().show();
            $("#name").parent().parent().show();
            $("#parentId").parent().parent().show();
            $("#remark").parent().parent().show();
            $("#btn-submit").parent().parent().show();
            $("#orderNum").parent().parent().show();
            $("#icon").parent().parent().show();
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


        //修改
        $("#data-table tbody").on("click", "#btn-edit-row", function () {
            url = "${ctxPath}/admin/sysuserpermission/update";
            $("#edit-modal-label").html("编辑");
            var data = tables.api().row($(this).parents("tr")).data();
            $("#edit-form :input").val("");
            $("#id").val(data.id);
            $("#type").val(data.type);
            $("#name").val(data.name);
            $("#parentId").val(data.parentId);
            $("#parentName").val(data.parentName);
            $("#url").val(data.url);
            $("#permissionCode").val(data.permissionCode);
            $("#icon").val(data.icon);
            $("#orderNum").val(data.orderNum);
            $("#remark").val(data.remark);


            $("#edit-form :input").parent().parent().hide();
            $("#id").parent().parent().show();
            $("#type").parent().parent().show();
            $("#name").parent().parent().show();
            $("#parentId").parent().parent().show();
            $("#remark").parent().parent().show();
            $("#btn-submit").parent().parent().show();
            $("#orderNum").parent().parent().show();
            $("#permissionCode").parent().parent().show();

            if (1 == data.type || 2 == data.type) {
                $("#icon").parent().parent().show();
            } else if (3 == data.type) {
                $("#url").parent().parent().show();
                $("#icon").parent().parent().show();
            } else if (4 == data.type || 5 == data.type) {

            }

            $("#edit-modal").modal("show");
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
                url = "${ctxPath}/admin/sysuserpermission/" + operateTypeIds + "/delete";
                data = "";
            } else if (operateType == batchDeleteToOperateConfirmFlag) {
                url = "${ctxPath}/admin/sysuserpermission/batch/delete";
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
                        $.toaster("删除成功", "系统提示");
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

        // 类型选择
        $("#type").on("change", function () {
            var selectedValue = $(this).children("option:selected").val();
            $("#edit-form :input").parent().parent().hide();
            $("#id").parent().parent().show();
            $("#type").parent().parent().show();
            $("#name").parent().parent().show();
            $("#parentId").parent().parent().show();
            $("#remark").parent().parent().show();
            $("#btn-submit").parent().parent().show();
            $("#orderNum").parent().parent().show();
            $("#permissionCode").parent().parent().show();

            if (1 == selectedValue || 2 == selectedValue) {
                $("#icon").parent().parent().show();
            } else if (3 == selectedValue) {
                $("#url").parent().parent().show();

                $("#icon").parent().parent().show();
            } else if (4 == selectedValue || 5 == selectedValue) {
            }
        });

        var setting = {
            data: {
                simpleData: {
                    enable: true
                }
            }
        };
        var ztree;
        // 上级目录
        $("#parentName").on("click", function () {
            $("#tree-modal").modal("show");
            var parentId = $("#parentId").val();
            //加载菜单树
            $.get("${ctxPath}/admin/sysuserpermission/queryNotButtonNodes", function (data) {
                console.debug(data);
                ztree = $.fn.zTree.init($("#menuTree"), setting, data.result);

                if (parentId && parentId.length > 0) {
                    var node = ztree.getNodeByParam("id", parentId);
                    ztree.selectNode(node);
                }
            })
        });

        // 目录树 确认 按钮
        $("#btn-tree-modal-confirm").on("click", function () {
            $("#tree-modal").modal("hide");
            var node = ztree.getSelectedNodes();
            $("#parentId").val(node[0].id);
            $("#parentName").val(node[0].name);
        });

    });

</script>