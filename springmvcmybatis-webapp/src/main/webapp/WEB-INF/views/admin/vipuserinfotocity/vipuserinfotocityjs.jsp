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
            alert("-------");
            console.log(formData);
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
                        url: "${ctxPath}/admin/vipuserinfotocity/queryList",
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

                    columns: [
                        {"data": "id", "bSortable": false,visiable:false},
                        {"data": "xm"},
                        {
                            "data": "sfzh"
                        },
                        {
                            "data": "lxdh"
                        },
                        {
                            "data": "xzddzmc"
                        },
                        {
                            "data": "blsj"
                        },
                        {
                            "data": "bldzdzmc"
                        },
                        {
                            "data": "djsj"
                        },
                        <myshiro:hasAnyPermission permissions="vipuserinfotocity:export">
                        {"data": null, "bSortable": false}
                        </myshiro:hasAnyPermission>

                    ],
                    //操作按钮
                    columnDefs: [
                        <myshiro:hasAnyPermission permissions="vipuserinfotocity:export">
                        {
                            targets: -1,
                            defaultContent: "<div class='btn-group'>" +
                            <shiro:hasPermission name="vipuserinfotocity:export">
                            "<button type='button' id='btn-edit-row' class='btn btn-default btn-sm' data-toggle='tooltip' data-container='body' title='查看'><i class='fa fa-check-circle'></i></button>" +
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



                        <shiro:hasPermission name="vipuserinfotocity:export">


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

        //刷新
        $("#btn-refresh").on("click", function () {
            tables.fnDraw(false);
        });

        //查看文件详情
        $("#data-table tbody").on("click", "#file-href", function () {
            var data = tables.api().row($(this).parents("tr")).data();
            window.open(data.fileUrl);
        });






        var ztree;
        var setting = {
            data: {
                simpleData: {
                    enable: true
                }
            }
        };






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

    //修改
    $("#data-table tbody").on("click", "#btn-edit-row", function () {
        $("#edit-modal-label").html("查看");
        var data = tables.api().row($(this).parents("tr")).data();
        $("#edit-form :input").val("");
        $("#id").val(data.id);
        $("#xm").val(data.xm);
        $("#sfzh").val(data.sfzh);
        $("#lxdh").val(data.lxdh);
        $("#xzddzmc").val(data.xzddzmc);
        $("#blsj").val(data.blsj);
        $("#bldzdzmc").val(data.bldzdzmc);
        $("#djsj").val(data.djsj);

/*
        $("#edit-form :input").parent().parent().hide();
        $("#id").parent().parent().show();
        $("#xfrXm").parent().parent().show();
        $("#sfrq").parent().parent().show();
        $("#xfrGmsfhm").parent().parent().show();
        $("#xfrLxdh").parent().parent().show();
        $("#sldwDwmc").parent().parent().show();
        $("#xfsyJyqk").parent().parent().show();
        $("#gjxwJyqk").parent().parent().show();
        $("#btn-cancel").parent().parent().show();*/
        $("#edit-modal").modal("show");
    });
</script>