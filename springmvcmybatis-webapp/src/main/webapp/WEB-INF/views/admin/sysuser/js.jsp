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
    var tables;
    var ztree;
    var deleteToOperateConfirmFlag = "delete";
    var batchDeleteToOperateConfirmFlag = "batch-delete";

    $.validator.setDefaults({
        submitHandler: function () {

            var node = ztree.getSelectedNodes();
            $("#userDepartmentId").val(node[0].id);

            var checkedUserRoleIds = new Array();
            $("input[name='userRoleList']:checkbox").each(function () {
                if (true == $(this).is(":checked")) {
                    checkedUserRoleIds.push($(this).val());
                }
            });
            if (checkedUserRoleIds.length > 0) {
                $("#userRoleIds").val(JSON.stringify(checkedUserRoleIds));
            }

            var data = JSON.parse($("#edit-form").serializeJSON());
            data.userRoleIds = checkedUserRoleIds;
            data = JSON.stringify(data);

            $.ajax({
                cache: false,
                type: "POST",
                url: url,
//                data: $("#edit-form").serialize(),
                data: data,
                contentType: "application/json;charset=UTF-8",
                success: function (data) {
                    console.debug(data);
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
        var validator = $("#edit-form").validate({
//            errorPlacement: function (error, element) {
//                $(element).closest("div").append(error).parent().addClass("has-error");
//            },
//            errorElement: "span",
//            errorClass: "help-block",
            messages: {
                realName: {
                    required: "请输入姓名",
                    minlength: "姓名不能少于 2 个字符"
                },
                username: {
                    required: "请输入用户名",
                    minlength: "用户名不能少于 5 个字符"
                },
                password: {
                    required: "请输入密码",
                    minlength: "密码不能少于 6 个字符",
                    maxlength: "密码不能大于 20 个字符"
                }
            }
        });

        $("#btn-cancel").on("click", function () {
            validator.resetForm();
//            $("#edit-form :input").parent().parent().removeClass("has-error");
        });


        tables = $("#data-table")
                .dataTable({
                    //详细配置信息参见 http://datatables.club/reference/option/
                    serverSide: true,//分页，取数据等等的都放到服务端去
                    paging: true,//是否分页
                    processing: true,//载入数据的时候是否显示“载入中”
                    pageLength: 10,  //首次加载的数据条数
                    ordering: true, //排序
                    pagingType: "full_numbers",
//                autoWidth: true,
                    info: true,
                    stateSave: true,//保持翻页状态，和comTable.fnDraw(false);结合使用
                    searching: false,//禁用datatables搜索
//                responsive: true, //支持响应式布局
                    ajax: {
                        type: "post",
                        url: "${ctxPath}/admin/sysuser/queryListWithCustom",
                        //dataSrc: "result",
                        dataSrc: function (json) {
                            json.draw = json.result.draw;
                            json.recordsTotal = json.result.recordsTotal;
                            json.recordsFiltered = json.result.recordsFiltered;
                            return json.result.data;
                        },
                        data: function (d) {
                            //添加需要传递的自定义参数。
                            var formData = $("#query-form").serializeArray();//把form里面的数据序列化成数组
                            formData.forEach(function (e) {
//                    d["extra_search_" + e.name] = e.value;
                                d[e.name] = e.value;
                            });
                            return d;
                        }
                    },
                    <shiro:lacksPermission name="sysuser:batchdelete">
                    "order": [[1, "desc"]],
                    </shiro:lacksPermission>
                    <shiro:hasPermission name="sysuser:batchdelete">
                    "order": [[2, "desc"]],
                    </shiro:hasPermission>
                    columns: [//对应上面thead里面的序列
                        <shiro:hasPermission name="sysuser:batchdelete">
                        {
                            "data": "id",
                            "bSortable": false,
                            "width": "10px"
                        }, //checkbox
                        </shiro:hasPermission>
                        {"data": null, "bSortable": false}, //序号
                        {"data": "id"},
                        {"data": "realName"},
                        {"data": "username"},
                        {
                            "data": "isAdmin",
                            "render": function (data, type, full, callback) {
                                if (data == "1") {
                                    return "<span class='label label-success'>是</span>";
                                }
                                return "<span class='label label-danger'>否</span>";
                            }
                        },
                        {"data": "userDepartmentName"},
                        {"data": "userRoleNames"},
                        {"data": "mobile"},
                        {"data": "email"},

                        {
                            "data": "activated",
                            "render": function (data, type, full, callback) {
                                if (data == "1") {
                                    return "<span class='label label-success'>激活</span>";
                                }
                                return "<span class='label label-danger'>未激活</span>";
                            }
                        },
                        {
                            "data": "locked",
                            "render": function (data, type, full, callback) {
                                if (data == "1") {
                                    return "<span class='label label-danger'>锁定</span>";
                                }
                                return "<span class='label label-success'>正常</span>";
                            }
                        },
                        {
                            "data": "disabled",
                            "render": function (data, type, full, callback) {
                                if (data == "1") {
                                    return "<span class='label label-danger'>禁用</span>";
                                }
                                return "<span class='label label-success'>正常</span>";
                            }
                        },
//                        {"data": "createdTime"},
//                        {"data": "createdBy"},
//                        {"data": "createdIp"},
//                        {"data": "modificationTime"},
//                        {"data": "modificationBy"},
//                        {"data": "modificationIp"},
                        {"data": "remark", defaultContent: ""}
                        <myshiro:hasAnyPermission permissions="sysuser:edit,sysuser:delete">
                        ,
                        {"data": null, "bSortable": false}
                        </myshiro:hasAnyPermission>
                    ],
                    //操作按钮
                    columnDefs: [
                        <shiro:hasPermission name="sysuser:batchdelete">
                        {
                            "targets": [0], //表示具体需要操作的目标列，下标从0开始
                            "data": "id",
                            "render": function (data, type, full) { // 返回需要显示的内容。在此我们可以修改列中样式，增加具体内容
                                return "<input type='checkbox' name='checkList' value='" + data + "'>";
                            }
//              defaultContent: "<input type='checkbox' name='checkList' value=''>"
                        }
                        ,
                        </shiro:hasPermission>
                        //{
                        //    "targets": [3], // 表示具体需要操作的目标列，下标从0开始。这里的意思是要在第四列增加自定义的超级链接操作
                        //    "data": "id", // 表示我们需要的某一列数据对应的属性名
                        //    "render": function(data, type, full) { // 返回需要显示的内容。在此我们可以修改列中样式，增加具体内容
                        //        return "<a href='/update?id=" + data + "'>Update</a>";
                        //    }
                        //},
                        <myshiro:hasAnyPermission permissions="sysuser:edit,sysuser:delete">
                        {
                            targets: -1,
                            defaultContent: "<div class='btn-group'>" +
                            <shiro:hasPermission name="sysuser:edit">
                            "<button type='button' id='btn-edit-row' class='btn btn-default btn-sm' data-toggle='tooltip' data-container='body' title='编 辑'><i class='fa fa-edit'></i></button>" +
                            </shiro:hasPermission>
                            <shiro:hasPermission name="sysuser:delete">
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

                        <shiro:lacksPermission name="sysuser:batchdelete">
                        api.column(0).nodes().each(function (cell, i) {
                            cell.innerHTML = startIndex + i + 1;
                        });
                        </shiro:lacksPermission>

                        <shiro:hasPermission name="sysuser:batchdelete">
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
            tables.fnDraw();//查询后不需要保持分页状态，回首页
            return false;
        });

        //重置
        $("#btn-reset").on("click", function () {
            $("#query-form :input").val("");
            tables.fnDraw(false);//刷新保持分页状态
        });


        //添加
        $("#btn-add").on("click", function () {
            url = "${ctxPath}/admin/sysuser/saveUserAndUserRoles";
//        $("#edit-form :input").iCheck("uncheck");
            $("#edit-modal-label").html("添加");
            initEditForm();
            $("#password-area").show();
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

        //导出
        $("#btn-export").on("click", function () {
        });

        //刷新
        $("#btn-refresh").on("click", function () {
            tables.fnDraw(false);//刷新保持分页状态
        });


        //修改
        $("#data-table tbody").on("click", "#btn-edit-row", function () {
            url = "${ctxPath}/admin/sysuser/updateUserAndUserRoles";
            $("#edit-modal-label").html("编辑");
            initEditForm();
            var data = tables.api().row($(this).parents("tr")).data();
            $("#id").val(data.id);
            $("#realName").val(data.realName);
            $("#username").val(data.username);
            $("#password-area").hide();
            $("#isAdmin").val(data.isAdmin ? 1 : 0);
            $("#mobile").val(data.mobile);
            $("#email").val(data.email);
            $("#activated").val(data.activated ? 1 : 0);
            $("#locked").val(data.locked ? 1 : 0);
            $("#disabled").val(data.disabled ? 1 : 0);
            $("#remark").val(data.remark);
            var userRoleNames = data.userRoleNames.split('，');
            $.each(userRoleNames,
                    function (i, userRoleName) {
                        $("input[name='userRoleList']:checkbox").each(function () {
                            console.debug($(this));
                            console.debug($.trim($(this).parent().parent()));
                            if (userRoleName == $.trim($(this).parent().parent().text())) {
                                $(this).iCheck("check");
                            }
                        });
                    });

            $("#userRoleId").val(data.userRoleId);
            $("#userRoleName").val($("#userRoleId").find("option:selected").text());
            var node = ztree.getNodeByParam("id", data.userDepartmentId);
            if (node) {
                ztree.selectNode(node);
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
                url = "${ctxPath}/admin/sysuser/" + operateTypeIds + "/deleteUserAndUserRoles";
                data = "";
            } else if (operateType == batchDeleteToOperateConfirmFlag) {
                url = "${ctxPath}/admin/sysuser/batch/deleteUserAndUserRoles";
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


        //加载角色
        $.get("${ctxPath}/admin/sysuserrole/queryAllUserRoles", function (data) {
            var item;
            $.each(data.result,
                    function (i, result) {
                        item = "<label><input type='checkbox' name='userRoleList' value='" + result['id'] + "'> " + result['name'] + "</label>";
                        $('#userRoleList').append(item);
                    })
        });

        var setting = {
            data: {
                simpleData: {
                    enable: true
                }
            }
        };
        //加载组织树
        $.get("${ctxPath}/admin/sysarea/queryAllNodes", function (data) {
            ztree = $.fn.zTree.init($("#menuTree"), setting, data.result);
        });

        function initEditForm() {
            $("#id").val("");
            $("#realName").val("");
            $("#username").val("");
            $("#password").val("");
            $("#isAdmin").find("option").eq(0).attr("selected", "selected");
            var node = ztree.getNodeByParam("id", 0);
            if (node) {
                ztree.selectNode(node);
            }
            $("input[name='userRoleList']:checkbox").iCheck("uncheck");
            $("#mobile").val("");
            $("#email").val("");
            $("#activated").find("option").eq(0).attr("selected", "selected");
            $("#locked").find("option").eq(0).attr("selected", "selected");
            $("#disabled").find("option").eq(0).attr("selected", "selected");
            $("#remark").val("");
            $("#userDepartmentId").val("");
            $("#userRoleIds").val("");
        }

    });

</script>