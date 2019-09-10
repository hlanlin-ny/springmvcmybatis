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
    var treeType = 1;

    $.validator.setDefaults({
        submitHandler: function () {
            $("#btn-submit").addClass("disabled");
            var formData = new FormData($("#edit-form")[0]);
            $.ajax({
                cache: false,
                async: false,
                type: "POST",
                url: url,
                data: formData,
                // 告诉jQuery不要去处理发送的数据
                processData: false,
                // 告诉jQuery不要去设置Content-Type请求头
                contentType: false,
                beforeSend: function () {
                    console.log("正在进行，请稍候");
                },
                success: function (data) {
                    if (data.code == 0) {
                        $("#edit-modal").modal("hide");
                        tables.fnDraw();
                        $.toaster("提交成功", "系统提示");
                    } else {
                        $("#btn-submit").removeClass("disabled");
                        console.log("服务异常:" + data);
                        $.toaster("异常信息:" + data.message, "服务异常", "danger");
                    }
                },
                error: function (data) {
                    $("#btn-submit").removeClass("disabled");
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
                        url: "${ctxPath}/admin/intelligenceimportcity/queryList",
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
                    <shiro:lacksPermission name="intelligenceimportcity:batchdelete">
                    "order": [[1, "desc"]],
                    </shiro:lacksPermission>
                    <shiro:hasPermission name="intelligenceimportcity:batchdelete">
                    "order": [[2, "desc"]],
                    </shiro:hasPermission>
                    columns: [
                        <shiro:hasPermission name="intelligenceimportcity:batchdelete">
                        {
                            "data": "id",
                            "bSortable": false
                        },
                        </shiro:hasPermission>
                        {"data": null, "bSortable": false},
                        {"data": "id"},

                        {"data": "businessTypeName", defaultContent: ""},


                        {
                            "data": "fileType",
                            "render": function (data, type, full, callback) {
                                if (data == "1") {
                                    return "结构化数据";
                                } else if (data == "2") {
                                    return "word文件";
                                } else if (data == "3") {
                                    return "ppt文件";
                                } else if (data == "4") {
                                    return "excel文件";
                                } else if (data == "5") {
                                    return "txt文件";
                                } else if (data == "6") {
                                    return "csv文件";
                                } else if (data == "7") {
                                    return "pdf文件";
                                } else if (data == "8") {
                                    return "图片文件";
                                } else if (data == "9") {
                                    return "音频文件";
                                } else if (data == "10") {
                                    return "视频文件";
                                }
                                return "";
                            }
                        },
                        {
                            "data": "filename",
                            "render": function (data, type, full, callback) {
                                return "<a id='file-href' href='#'>" + data + "</a>";
                            }
                        },
                        {
                            "data": "fileDesc",
                            "render": function (data, type, full, callback) {
                                return "<textarea class='form-control' rows='2' readonly>" + data + "</textarea>";
                            }
                        },
                        {"data": "collectTime", defaultContent: ""},
                        {"data": "remark", defaultContent: ""}

                        <myshiro:hasAnyPermission permissions="intelligenceimportcity:edit,intelligenceimportcity:delete">
                        ,
                        {"data": null, "bSortable": false}
                        </myshiro:hasAnyPermission>
                    ],
                    //操作按钮
                    columnDefs: [
                        <shiro:hasPermission name="intelligenceimportcity:batchdelete">
                        {
                            "targets": [0],
                            "data": "id",
                            "render": function (data, type, full) {
                                return "<input type='checkbox' name='checkList' value='" + data + "'>";
                            }
                        },
                        </shiro:hasPermission>
                        <myshiro:hasAnyPermission permissions="intelligenceimportcity:edit,intelligenceimportcity:delete">
                        {
                            targets: -1,
                            defaultContent: "<div class='btn-group'>" +
                            <shiro:hasPermission name="intelligenceimportcity:edit">
                            "<button type='button' id='btn-edit-row' class='btn btn-default btn-sm' data-toggle='tooltip' data-container='body' title='编 辑'><i class='fa fa-edit'></i></button>" +
                            </shiro:hasPermission>
                            <shiro:hasPermission name="intelligenceimportcity:delete">
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

                        <shiro:lacksPermission name="intelligenceimportcity:batchdelete">
                        api.column(0).nodes().each(function (cell, i) {
                            cell.innerHTML = startIndex + i + 1;
                        });
                        </shiro:lacksPermission>

                        <shiro:hasPermission name="intelligenceimportcity:batchdelete">
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

        //燃气数据上传
        $("#btn-add").on("click", function () {
            $.ajax({
                cache: "false",
                url: "${ctxPath}/admin/intelligenceimportcity/updatetocity",
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



        //自来水数据上传
        $("#btn-add-water").on("click", function () {
            $.ajax({
                cache: "false",
                url: "${ctxPath}/admin/intelligenceimportcity/updatewatertocity",
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



        //从业人员数据上传
        $("#btn-add-people").on("click", function () {
            $.ajax({
                cache: "false",
                url: "${ctxPath}/admin/intelligenceimportcity/updatepeopletocity",
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



        //职工健康证明数据上传
        $("#btn-add-healthy").on("click", function () {
            $.ajax({
                cache: "false",
                url: "${ctxPath}/admin/intelligenceimportcity/updatehealthytocity",
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



        //新农合数据上传
        $("#btn-add-ncms").on("click", function () {
            $.ajax({
                cache: "false",
                url: "${ctxPath}/admin/intelligenceimportcity/updatencms",
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



        //医保人员数据上传
        $("#btn-medical-insurance").on("click", function () {
            $.ajax({
                cache: "false",
                url: "${ctxPath}/admin/intelligenceimportcity/updatemedicalinsurance",
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



        //公积金数据上传
        $("#btn-accumulation-fund").on("click", function () {
            $.ajax({
                cache: "false",
                url: "${ctxPath}/admin/intelligenceimportcity/updateaccumulationfund",
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

        //学籍数据上传
        $("#btn-student-calls").on("click", function () {
            $.ajax({
                cache: "false",
                url: "${ctxPath}/admin/intelligenceimportcity/updateStudentToCity",
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

        //有线数据上传
        $("#btn-television-calls").on("click", function () {
            $.ajax({
                cache: "false",
                url: "${ctxPath}/admin/intelligenceimportcity/updateTelevisionToCity",
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

        //信访数据上传
        $("#btn-letters-calls").on("click", function () {
            $.ajax({
                cache: "false",
                url: "${ctxPath}/admin/intelligenceimportcity/updateletterscalls",
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


        //医院体检数据上传
        $("#btn-PhysicalExamination-calls").on("click", function () {
            $.ajax({
                cache: "false",
                url: "${ctxPath}/admin/intelligenceimportcity/updatePhysicalExaminationToCity",
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



        //停车场数据上传
        $("#btn-paking-calls").on("click", function () {
            $.ajax({
                cache: "false",
                url: "${ctxPath}/admin/intelligenceimportcity/updatePakingToCity",
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

        //会员登记数据上传
        $("#btn-vip-calls").on("click", function () {
            $.ajax({
                cache: "false",
                url: "${ctxPath}/admin/intelligenceimportcity/updateVipToCity",
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

        //出租车轨迹数据上传
        $("#btn-cargps-calls").on("click", function () {
            $.ajax({
                cache: "false",
                url: "${ctxPath}/admin/intelligenceimportcity/updateCarGpsToCity",
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

        //旅行社接待游客数据上传
        $("#btn-visitor-calls").on("click", function () {
            $.ajax({
                cache: "false",
                url: "${ctxPath}/admin/intelligenceimportcity/updateVisitorToCity",
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

        //电动车车辆数据上传
        $("#btn-economical-calls").on("click", function () {
            $.ajax({
                cache: "false",
                url: "${ctxPath}/admin/intelligenceimportcity/updateEconomicalToCity",
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

        //燃气缴费数据上传
        $("#btn-gasfee-calls").on("click", function () {
            $.ajax({
                cache: "false",
                url: "${ctxPath}/admin/intelligenceimportcity/updateGasFeeToCity",
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

        //电动车轨迹数据上传
        $("#btn-EcoGps-calls").on("click", function () {
            $.ajax({
                cache: "false",
                url: "${ctxPath}/admin/intelligenceimportcity/updateEcoGpsToCity",
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

        //快递数据上传
        $("#btn-Express-calls").on("click", function () {
            $.ajax({
                cache: "false",
                url: "${ctxPath}/admin/intelligenceimportcity/updateExpressToCity",
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

        //电力用户
        $("#btn-power-calls").on("click", function () {
            $.ajax({
                cache: "false",
                url: "${ctxPath}/admin/intelligenceimportcity/updatePowerToCity",
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

        //电力缴费
        $("#btn-powerdata-calls").on("click", function () {
            $.ajax({
                cache: "false",
                url: "${ctxPath}/admin/intelligenceimportcity/updatePowerDataToCity",
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

       //新生儿数据
        $("#btn-newborn-calls").on("click", function () {
            $.ajax({
                cache: "false",
                url: "${ctxPath}/admin/intelligenceimportcity/updateNewbornToCity",
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

        //查看文件详情
        $("#data-table tbody").on("click", "#file-href", function () {
            var data = tables.api().row($(this).parents("tr")).data();
            window.open(data.fileUrl);
        });

        //修改
        $("#data-table tbody").on("click", "#btn-edit-row", function () {
            url = "${ctxPath}/admin/intelligenceimportcity/updateAndUpload";
            $("#edit-modal-label").html("编辑");
            var data = tables.api().row($(this).parents("tr")).data();
            $("#edit-form :input").val("");
            $("#id").val(data.id);
            $("#businessTypeId").val(data.businessTypeId);
            $("#businessTypeName").val(data.businessTypeName);
            $("#fileType").val(data.fileType);
            $("#filename").val(data.filename);
            $("#fileDesc").val(data.fileDesc);
            $("#collectTime").val(data.collectTime);
            $("#remark").val(data.remark);
            $("#areaId").val($("#extra-search-areaId").val());
            $("#btn-submit").removeClass("disabled");
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
                url = "${ctxPath}/admin/intelligenceimportcity/" + operateTypeIds + "/delete";
                data = "";
            } else if (operateType == batchDeleteToOperateConfirmFlag) {
                url = "${ctxPath}/admin/intelligenceimportcity/batch/delete";
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


        var ztree;
        var setting = {
            data: {
                simpleData: {
                    enable: true
                }
            }
        };


        $("#businessTypeName").on("click", function () {
            $("#tree-modal").modal("show");
            treeType = 1;
            var parentId = $("#businessTypeId").val();
            $.get("${ctxPath}/admin/intelligencebusinesstype/queryAllNodes", function (data) {
                ztree = $.fn.zTree.init($("#menuTree"), setting, data.result);
                if (parentId && parentId.length > 0) {
                    var node = ztree.getNodeByParam("id", parentId);
                    ztree.selectNode(node);
                }
            })
        });

        $("#extra-search-businessTypeName").on("click", function () {
            $("#tree-modal").modal("show");
            treeType = 2;
            var parentId = $("#extra-search-businessTypeId").val();
            $.get("${ctxPath}/admin/intelligencebusinesstype/queryAllNodes", function (data) {
                console.log(data);
                ztree = $.fn.zTree.init($("#menuTree"), setting, data.result);
                if (parentId && parentId.length > 0) {
                    var node = ztree.getNodeByParam("id", parentId);
                    ztree.selectNode(node);
                }
            })
        });

        // 确认 按钮
        $("#btn-tree-modal-confirm").on("click", function () {
            $("#tree-modal").modal("hide");
            var node = ztree.getSelectedNodes();
            if (treeType == 1) {
                $("#businessTypeId").val(node[0].id);
                $("#businessTypeName").val(node[0].name);
            } else {
                $("#extra-search-businessTypeId").val(node[0].id);
                $("#extra-search-businessTypeName").val(node[0].name);
            }
        });

        //Date picker
        $('#collectTime').datetimepicker({
            startView: 2,
            minView: 2,
            weekStart: 1,
            autoclose: true,
            todayBtn: "linked",
            language: "zh-CN",
            todayHighlight: true,
            format: 'yyyy-mm-dd'
        });

        function getNowFormatDate() {
            var date = new Date();
            var seperator1 = "-";
            var seperator2 = ":";
            var month = date.getMonth() + 1;
            var strDate = date.getDate();
            if (month >= 1 && month <= 9) {
                month = "0" + month;
            }
            if (strDate >= 0 && strDate <= 9) {
                strDate = "0" + strDate;
            }
            var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
//                    + " " + date.getHours() + seperator2 + date.getMinutes();
//                    + seperator2 + date.getSeconds();
            return currentdate;
        };


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
            $('#extra-search-collectTimeBegin').val(picker.startDate.format('YYYY-MM-DD'));
            $('#extra-search-collectTimeEnd').val(picker.endDate.format('YYYY-MM-DD'));
        });
    });
</script>