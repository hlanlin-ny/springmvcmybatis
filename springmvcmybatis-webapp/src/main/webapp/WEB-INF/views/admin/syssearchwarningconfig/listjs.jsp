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
    var pauseOperateConfirmFlag = "pause";//暂停
    var resumeToOperateConfirmFlag = "resume";//回复
    var runToOperateConfirmFlag = "run";//立即执行

    $.validator.setDefaults({
        submitHandler: function () {
            //获取选择的菜单
            var nodes = ztree.getCheckedNodes(true);
            var intelligenceBusinessTypeIds = new Array();
            var intelligenceBusinessTypeNames = new Array();
            for (var i = 0; i < nodes.length; i++) {
                if (nodes[i].id > 0) {
                    intelligenceBusinessTypeIds.push(nodes[i].id);
                    intelligenceBusinessTypeNames.push(nodes[i].name);
                }
            }
            if (intelligenceBusinessTypeIds.length > 0) {
                $("#businesstypeid").val(JSON.stringify(intelligenceBusinessTypeIds));
                $("#businesstypename").val(intelligenceBusinessTypeNames);
            }

            var fileTypes = new Array();
            var fileTypeNames = new Array();
            $("input[name='filetypeitem']:checkbox").each(function () {
                if (true == $(this).is(":checked")) {
                    fileTypes.push($(this).val());
                    //console.info($(this).parent().parent()[0].innerText);
                    fileTypeNames.push($(this).parent().parent()[0].innerText);
                }
            });
            if (fileTypes.length > 0) {
                $("#filetype").val(JSON.stringify(fileTypes));
               $("#filetypename").val(fileTypeNames);
            }

            $.ajax({
                cache: false,
                type: "POST",
                url: url,
                data:$("#edit-form").serializeJSON(),
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

    $('#startTime').datetimepicker({
        startView: 2,
        minView: 2,
        weekStart: 1,
        autoclose: true,
        todayBtn: "linked",
        language: "zh-CN",
        todayHighlight: true,
        format: 'yyyy-mm-dd'
    });

    $().ready(function () {
        $('.modal').on('shown.bs.modal', function () {
            $(this).find('input:text:visible:first').focus();
        });

        $("input").iCheck({
            checkboxClass: "icheckbox_square-blue",
            radioClass: "iradio_square-blue"
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
                        url: "${ctxPath}/admin/syssearchwarningconfig/queryList",
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
                    <shiro:lacksPermission name="syssearchwarningconfig:batchdelete">
                    "order": [[1, "desc"]],
                    </shiro:lacksPermission>
                    <shiro:hasPermission name="syssearchwarningconfig:batchdelete">
                    "order": [[2, "desc"]],
                    </shiro:hasPermission>
                    columns: [
                        <shiro:hasPermission name="syssearchwarningconfig:batchdelete">
                        {
                            "data": "id",
                            "bSortable": false
                        },
                        </shiro:hasPermission>
                        {"data": null, "bSortable": false},
                        {"data": "id"},

        		{"data": "keywords", defaultContent: ""}, 
        		{"data": "businesstypename", defaultContent: ""},
        		{"data": "filetypename", defaultContent: ""},
        		{"data": "startTime", defaultContent: ""},
        		{"data": "isExactMatching",
                    "render": function (data, type, full, callback) {
                        if (data == true) {
                            return "是";
                        } else if (data == false) {
                            return "否";
                        }
                        return "";
                    }
                },
        		{"data": "status",
                    "render": function (data, type, full, callback) {
                        if (data == 0) {
                            return "正常";
                        } else if (data == 1) {
                            return "暂停";
                        }
                        return "";
                    }
                },
        		{"data": "noticeFrequency", defaultContent: ""}, 
        		{"data": "cronFrequency", defaultContent: ""}
    
                        <myshiro:hasAnyPermission permissions="syssearchwarningconfig:edit,syssearchwarningconfig:delete">
                        ,
                        {"data": null, "bSortable": false}
                        </myshiro:hasAnyPermission>
                    ],
                    //操作按钮
                    columnDefs: [
                        <shiro:hasPermission name="syssearchwarningconfig:batchdelete">
                        {
                            "targets": [0],
                            "data": "id",
                            "render": function (data, type, full) {
                                return "<input type='checkbox' name='checkList' value='" + data + "'>";
                            }
                        },
                        </shiro:hasPermission>
                        <myshiro:hasAnyPermission permissions="syssearchwarningconfig:edit,syssearchwarningconfig:delete">
                        {
                            targets: -1,
                            defaultContent: "<div class='btn-group'>" +
                            <shiro:hasPermission name="syssearchwarningconfig:edit">
                            "<button type='button' id='btn-edit-row' class='btn btn-default btn-sm' data-toggle='tooltip' data-container='body' title='编 辑'><i class='fa fa-edit'></i></button>" +
                            </shiro:hasPermission>
                            <shiro:hasPermission name="syssearchwarningconfig:delete">
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

                        <shiro:lacksPermission name="syssearchwarningconfig:batchdelete">
                        api.column(0).nodes().each(function (cell, i) {
                            cell.innerHTML = startIndex + i + 1;
                        });
                        </shiro:lacksPermission>

                        <shiro:hasPermission name="syssearchwarningconfig:batchdelete">
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

        $("#extra-search-keywords").focus();
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
            url = "${ctxPath}/admin/syssearchwarningconfig/add";
            $("#edit-modal-label").html("添加");
            //$("#edit-form :input").val("");
            $("#keywords").val("");
            $("#businesstypeid").val("");
            $("#filetype").val("");
            $("#startTime").val("");
            $("#noticeFrequency").val("");
            $("#cronFrequency").val("");
            $("#remark").val("");

            $("#isExactMatching").val("false");
            $("#status").val("0");
            $("input[name='filetypeitem']:checkbox").iCheck("uncheck");
            ztree.checkAllNodes(false);
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
            url = "${ctxPath}/admin/syssearchwarningconfig/update";
            $("#edit-modal-label").html("编辑");

            $("input[name='filetypeitem']:checkbox").iCheck("uncheck");
            ztree.checkAllNodes(false);

            var data = tables.api().row($(this).parents("tr")).data();
            //$("#edit-form :input").val("");
            $("#id").val(data.id);
            $("#keywords").val(data.keywords);
            $("#startTime").val(data.startTime);
            $("#isExactMatching").val(data.isExactMatching==true?'true':'false');
            $("#status").val(data.status);
            $("#noticeFrequency").val(data.noticeFrequency);
            $("#cronFrequency").val(data.cronFrequency);
            $("#remark").val(data.remark);
            //情报类型回显
            var nodesId = eval(data.businesstypeid);
            if(nodesId!=null&&nodesId.length>0) {
                $.each(nodesId, function (index, value) {
                    var node = ztree.getNodeByParam("id", value);
                    if (node) {
                        ztree.checkNode(node);
                    }
                });
            }
            //文件类型回显
            var checkList = eval(data.filetype);
            if(checkList!=null&&checkList.length>0) {
                $.each(checkList, function (index, d) {
                    $("input[name='filetypeitem'][value='"+d+"']").iCheck("check");
                });
            }

            $("#edit-modal").modal("show");
        });
        var setting = {
            data: {
                simpleData: {
                    enable: true
                }
            },
            check: {
                enable: true,
                nocheckInherit: true
            }
        };
        //加载情报类型树
        $.get("${ctxPath}/admin/intelligencebusinesstype/queryAllRightIntelligenceBusinessType", function (data) {
            ztree = $.fn.zTree.init($("#menuTree2"), setting, data.result);
            //展开所有节点
            ztree.expandAll(true);
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
                url = "${ctxPath}/admin/syssearchwarningconfig/" + operateTypeIds + "/delete";
                data = "";
            } else if (operateType == batchDeleteToOperateConfirmFlag) {
                url = "${ctxPath}/admin/syssearchwarningconfig/batch/delete";
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

        //暂停
        $("#btn-pause").on("click", function () {
            batchOperation(pauseOperateConfirmFlag);
        });

        //恢复
        $("#btn-resume").on("click", function () {
            batchOperation(resumeToOperateConfirmFlag);
        });

        //立即执行
        $("#btn-run").on("click", function () {
            batchOperation(runToOperateConfirmFlag);
        });

        function batchOperation(typeToOperateConfirmFlag) {
            $("#deleteConfirmForm :input").val("");
            var checkedIds = new Array();
            $("input[name='checkList']:checkbox").each(function () {
                if (true == $(this).is(":checked")) {
                    checkedIds.push($(this).val());

                }
            });
            if (checkedIds.length > 0) {
                $("#ids-to-operate-confirm").val(JSON.stringify(checkedIds));
                $("#type-to-operate-confirm").val(typeToOperateConfirmFlag);
                $("#operate-confirm-modal").modal("show");
            }
        }
        //确认框【确认】动作
        $("#btn-operate-confirm").on("click", function () {
            var url;
            var data;
            var operateTypeIds = $("#ids-to-operate-confirm").val();
            var operateType = $("#type-to-operate-confirm").val();
            if (operateType == pauseOperateConfirmFlag) {
                url = "${ctxPath}/admin/syssearchwarningconfig/batch/pause";
                data = operateTypeIds;
            } else if (operateType == resumeToOperateConfirmFlag) {
                url = "${ctxPath}/admin/syssearchwarningconfig/batch/resume";
                data = operateTypeIds;
            } else if (operateType == runToOperateConfirmFlag) {
                url = "${ctxPath}/admin/syssearchwarningconfig/batch/run";
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
                        $.toaster("执行成功", "系统提示");
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
    });
</script>