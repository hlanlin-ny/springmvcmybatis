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
                        tables.fnDraw(false);
                        $.toaster("提交成功", "系统提示");
                    } else {
                        console.log("服务异常:" + data);
                        $.toaster("异常信息:" + data.message, "服务异常", "danger");
                    }
                },
                error: function (data) {
                    console.log("请求异常:" + data);
                    $.toaster("请求异常:" + data.message, "请求异常", "danger");
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
        $('#extra-search-bornTime').val(picker.startDate.format('YYYY-MM-DD'));
        $('#extra-search-bornTime').val(picker.endDate.format('YYYY-MM-DD'));
    });

    //Date picker
    $('#bornTime').datetimepicker({
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
                        url: "${ctxPath}/admin/importantperson/queryList",
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
                    <shiro:lacksPermission name="importantperson:batchdelete">
                    "order": [[1, "desc"]],
                    </shiro:lacksPermission>
                    <shiro:hasPermission name="importantperson:batchdelete">
                    "order": [[2, "desc"]],
                    </shiro:hasPermission>
                    columns: [
                        <shiro:hasPermission name="importantperson:batchdelete">
                        {
                            "data": "id",
                            "bSortable": false
                        },
                        </shiro:hasPermission>
//                        {"data": null, "bSortable": false},
                        {"data": "id"},

                        {"data": "name", defaultContent: ""},
                        {"data": "idCardNo", defaultContent: ""},
                        {"data": "sex", defaultContent: ""},
                        {"data": "nation", defaultContent: ""},
                        {"data": 'bornTime', defaultContent: ""},
                        {"data": "address", defaultContent: ""},
                        {"data": "personType", defaultContent: ""},
                        {"data": "controlName", defaultContent: ""},
                        {"data": "controlPersonUnit", defaultContent: ""},
                        {"data": "controlUnit", defaultContent: ""},
                        {"data": "controlTel", defaultContent: ""}

                        <myshiro:hasAnyPermission permissions="importantperson:edit,importantperson:delete">
                        ,
                        {"data": null, "bSortable": false}
                        </myshiro:hasAnyPermission>
                    ],
                    //操作按钮
                    columnDefs: [
                        <shiro:hasPermission name="importantperson:batchdelete">
                        {
                            "targets": [0],
                            "data": "id",
                            "render": function (data, type, full) {
                                return "<input type='checkbox' name='checkList' value='" + data + "'>";
                            }
                        },
                        </shiro:hasPermission>
                        <myshiro:hasAnyPermission permissions="importantperson:edit,importantperson:delete">
                        {
                            targets: -1,
                            "data": "id",
                            "render": function (data, type, full) {
                                var div = "<div class='btn-group'>";
                                if(data.status == "未布控"){
                                    div+=
                                     <shiro:hasPermission name='importantperson:control'>
                                     "<button type='button' id='btn-control-row' class='btn btn-default btn-sm' data-toggle='tooltip' data-container='body' title='布 控'><i class='fa fa-wrench'></i></button>"+
                                    </shiro:hasPermission>
                                    "</div>";
                                }else if(data.status == "已布控"){
                                    div+= <shiro:hasPermission name='importantperson:reply'>
                                    "<button type='button' id='btn-reply-row' class='btn btn-default btn-sm' data-toggle='tooltip' data-container='body' title='撤 销 布 控'><i class='fa fa-reply'></i></button>"+
                                    </shiro:hasPermission>
                                    "</div>";
                                }
                                div+=  <shiro:hasPermission name="importantperson:delete">
                                        "<button type='button' id='btn-del-row' class='btn btn-default btn-sm' data-toggle='tooltip' data-container='body' title='删 除'><i class='fa fa-trash-o'></i></button>" ;
                                </shiro:hasPermission>;
                                return div;
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

                        <shiro:lacksPermission name="importantperson:batchdelete">
                        api.column(0).nodes().each(function (cell, i) {
                            cell.innerHTML = startIndex + i + 1;
                        });
                        </shiro:lacksPermission>

                        <shiro:hasPermission name="importantperson:batchdelete">


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
            url = "${ctxPath}/admin/importantperson/add";
            $("#edit-modal-label").html("添加");
            $("#edit-form :input").val("");
            $("#edit-modal").modal("show");
        });

        //导入
        $("#btn-batchadd").on("click", function () {
            $("#import-form :input").val("");
            $("#import-modal").modal("show");
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

        //撤销布控
        $("#data-table tbody").on("click", "#btn-reply-row", function () {
            var data = tables.api().row($(this).parents("tr")).data();
            url = "${ctxPath}/admin/importantperson/reply";
            $.ajax({
                url:url,
                type:"post",
                data:{id:data.id},
                success:function(data){
                    if(data.code == 0){
                        $.toaster("撤销布控成功", "系统提示");
                        tables.fnDraw(false);
                    }else{
                        $.toaster("撤销布控失败", "系统提示", "danger");
                    }
                },
                error:function(data){
                    $.toaster("撤销布控失败"+data.message, "系统提示", "danger");
                }
            });
        });

        //布控
        $("#data-table tbody").on("click", "#btn-control-row", function () {
            var data = tables.api().row($(this).parents("tr")).data();
            url = "${ctxPath}/admin/importantperson/control";
            $.ajax({
                url:url,
                data:{id:data.id},
                type:"post",
                success:function(data){
                    if(data.code == 0){
                        $.toaster("布控成功", "系统提示");
                        tables.fnDraw(false);
                    }else{
                        $.toaster("布控失败", "系统提示", "danger");
                    }
                },
                error:function(data){
                    $.toaster("布控失败"+data.message, "系统提示", "danger");
                }
            });
        });



        //删除
        $("#data-table tbody").on("click", "#btn-del-row", function () {
            $("#operate-confirm-form :input").val("");
            var data = tables.api().row($(this).parents("tr")).data();
            $("#ids-to-operate-confirm").val(data.id);
            $("#type-to-operate-confirm").val(deleteToOperateConfirmFlag);
            $("#operate-confirm-modal").modal("show");
        });

        //监听上传文件事件
        $("#import-modal").on("click", "#btn-upload", function () {
            if($('#excel_file').val()==''||$('#excel_file').size()<0){
                $.toaster("请选择文件", "系统提示", "danger");
                return;
            }
            var form = $("form[name=import-form]");
            var options = {
                url:'${ctxPath}/admin/importantperson/batch/import',
                type:'post',
                success:function(resultJson){
                    //回调操作
                    console.log(resultJson);
                    if(resultJson.message == "导入成功"){
                        $.toaster("导入成功", "系统提示");
                        $("#import-modal").modal("hide");
                        tables.fnDraw();
                    }else{
                        $.toaster("导入失败", "系统提示","danger");
                    }
                }
            };
            form.ajaxSubmit(options);
        });
        //监听导出文件事件
        $(".box-tools").on("click", "#btn-export-excel", function () {
            var formElement = document.createElement('form');
            formElement.setAttribute('id','batchfiledownload');
            formElement.setAttribute('action','${ctxPath}/admin/importantperson/batch/export');
            formElement.setAttribute('method','post');
            $(document.body).append($(formElement));
            $(formElement).submit();
        });

        //删除
        $("#btn-operate-confirm").on("click", function () {

            var url;
            var data;
            var operateTypeIds = $("#ids-to-operate-confirm").val();
            var operateType = $("#type-to-operate-confirm").val();
            if (operateType == deleteToOperateConfirmFlag) {
                url = "${ctxPath}/admin/importantperson/" + operateTypeIds + "/delete";
                data = "";
            } else if (operateType == batchDeleteToOperateConfirmFlag) {
                url = "${ctxPath}/admin/importantperson/batch/delete";
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
    });

</script>