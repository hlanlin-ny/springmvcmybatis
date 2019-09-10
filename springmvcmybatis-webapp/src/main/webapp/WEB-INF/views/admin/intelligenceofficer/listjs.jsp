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
    var ztree;

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
        $('#extra-search-hireDateStart').val(picker.startDate.format('YYYY-MM-DD'));
        $('#extra-search-hireDateEnd').val(picker.endDate.format('YYYY-MM-DD'));
    });

    //Date picker
    $('#hireDate').datetimepicker({
        startView: 2,
        minView: 2,
        weekStart: 1,
        autoclose: true,
        todayBtn: "linked",
        language: "zh-CN",
        todayHighlight: true,
        format: 'yyyy-mm-dd'
    });

    //Date picker
    $('#birthDate').datetimepicker({
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
                        url: "${ctxPath}/admin/intelligenceofficer/queryList",
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
                    <shiro:lacksPermission name="intelligenceofficer:batchdelete">
                    "order": [[1, "desc"]],
                    </shiro:lacksPermission>
                    <shiro:hasPermission name="intelligenceofficer:batchdelete">
                    "order": [[2, "desc"]],
                    </shiro:hasPermission>
                    columns: [
                        <shiro:hasPermission name="intelligenceofficer:batchdelete">
                        {
                            "data": "id",
                            "bSortable": false
                        },
                        </shiro:hasPermission>
                        {"data": null, "bSortable": false},
                        {"data": "id"},
                        {"data": "name", defaultContent: ""},
                        {
                            "data": "sex",
                            "render": function (data, type, full, callback) {
                                if (data == true) {
                                    return "男";
                                } else if (data == false) {
                                    return "女";
                                }
                                return "";
                            }
                        },
                        {"data": "idNumbers", defaultContent: ""},
                        {"data": "adress", defaultContent: ""},
                        {"data": "hireDate", defaultContent: ""},
                        {"data": "profession", defaultContent: ""},
                        {
                            "data": "maritalStatus",
                            "render": function (data, type, full, callback) {
                                if (data == 0) {
                                    return "未婚";
                                } else if (data == 1) {
                                    return "已婚";
                                }else if (data == 2) {
                                    return "离异";
                                }
                                return "";
                            }
                        },
                        {"data": "phone", defaultContent: ""},
                        {
                            "data": "status",
                            "render": function (data, type, full, callback) {
                                if (data == 0) {
                                    return "启用";
                                } else if (data == 1) {
                                    return "停用";
                                }else if (data == 2) {
                                    return "失效";
                                }
                                return "";
                            }
                        },
                        {"data": "wechatName", defaultContent: ""},
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
                        {"data": "remark", defaultContent: ""}
    
                        <myshiro:hasAnyPermission permissions="intelligenceofficer:edit,intelligenceofficer:delete">
                        ,
                        {"data": null, "bSortable": false}
                        </myshiro:hasAnyPermission>
                    ],
                    //操作按钮
                    columnDefs: [
                        <shiro:hasPermission name="intelligenceofficer:batchdelete">
                        {
                            "targets": [0],
                            "data": "id",
                            "render": function (data, type, full) {
                                return "<input type='checkbox' name='checkList' value='" + data + "'>";
                            }
                        },
                        </shiro:hasPermission>
                        <myshiro:hasAnyPermission permissions="intelligenceofficer:edit,intelligenceofficer:delete">
                        {
                            targets: -1,
                            defaultContent: "<div class='btn-group'>" +
                            <shiro:hasPermission name="intelligenceofficer:edit">
                            "<button type='button' id='btn-edit-row' class='btn btn-default btn-sm' data-toggle='tooltip' data-container='body' title='编 辑'><i class='fa fa-edit'></i></button>" +
                            </shiro:hasPermission>
                            <shiro:hasPermission name="intelligenceofficer:delete">
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

                        <shiro:lacksPermission name="intelligenceofficer:batchdelete">
                        api.column(0).nodes().each(function (cell, i) {
                            cell.innerHTML = startIndex + i + 1;
                        });
                        </shiro:lacksPermission>

                        <shiro:hasPermission name="intelligenceofficer:batchdelete">
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
            url = "${ctxPath}/admin/intelligenceofficer/add";
            $("#edit-modal-label").html("添加");
            $("#edit-form :input").val("");
            $("#sex").val("true");
            $("#maritalStatus").val(0);
            $("#status").val(0);
            $("#isOfficer").val("false");
            $("#belongwechat").find("option").eq(0).attr("selected",true);
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
            url = "${ctxPath}/admin/intelligenceofficer/update";
            $("#edit-modal-label").html("编辑");
            var data = tables.api().row($(this).parents("tr")).data();
            $("#edit-form :input").val("");
            $("#id").val(data.id);
                                $("#name").val(data.name);
                                $("#sex").val(data.sex.toString());
                                $("#idNumbers").val(data.idNumbers);
                                $("#birthDate").val(data.birthDate);
                                $("#adress").val(data.adress);
                                $("#hireDate").val(data.hireDate);
                                $("#profession").val(data.profession);
                                $("#maritalStatus").val(data.maritalStatus);
                                $("#phone").val(data.phone);
                                $("#qq").val(data.qq);
                                $("#wechat").val(data.wechat);
                                $("#email").val(data.email);
                                $("#status").val(data.status);
                                $("#belongwechat").val(data.belongwechat);
                                $("#isOfficer").val(data.isOfficer==true?'true':'false');
                                $("#remark").val(data.remark);
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
                url = "${ctxPath}/admin/intelligenceofficer/" + operateTypeIds + "/delete";
                data = "";
            } else if (operateType == batchDeleteToOperateConfirmFlag) {
                url = "${ctxPath}/admin/intelligenceofficer/batch/delete";
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

        //所属微信群option获取
        $.ajax({
            type: "POST",
            url: '${ctxPath}/admin/syswechat/queryList',
            contentType: "application/json;charset=UTF-8",
            cache: false,
            success: function (json) {
                var dataWechat = json.result.data;
                $.each(dataWechat,function(idx,item){
                    //输出
                    $("#extra-search-belongwechat").append("<option value='"+item.id+"'>"+item.name+"</option>");
                    $("#belongwechat").append("<option value='"+item.id+"'>"+item.name+"</option>");
                })
            }
        });
    });


</script>