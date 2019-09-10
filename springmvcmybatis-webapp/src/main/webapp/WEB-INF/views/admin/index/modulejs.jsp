<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/basejs.jsp" %>
<!-- AdminLTE for demo purposes -->
<script src="${ctxPath}/resources/dist/js/demo.js"></script>
<%@ include file="/WEB-INF/views/admin/common/listjs.jsp" %>

<!-- 本页面用到的js -->
<script type="text/javascript">

    // To make Pace works on Ajax calls
    $(document).ajaxStart(function () {
        Pace.restart();
    });

        $.validator.setDefaults({
        submitHandler: function () {
//            var data = "password=" + $("#oldPassword").val() + "&newPassword=" + $("#newPassword").val() ;
            $.ajax({
                cache: false,
                type: "POST",
                url: "${ctxPath}/admin/sysuser/changepassword",
//                data: $("#change-password-form").serializeJSON(),
                data: $("#change-password-form").serialize(),
                contentType: "application/x-www-form-urlencoded",
                success: function (data) {
                    if (data.code == 0) {
                        $("#edit-modal").modal("hide");
                        $.toaster("修改成功", "系统提示");
                        location.href = "${ctxPath}/admin/admin/login/login.html";
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
        // 提交时验证表单
        var validator = $("#change-password-form").validate();

        $("#btn-cancel").on("click", function () {
            validator.resetForm();
        });

        //iframe自适应
        $(window).on('resize', function () {
            var content = $("#main_content");
            content.height($(this).height() - 120);
            content.find("iframe").each(function () {
                $(this).height(content.height());
            });
        }).resize();

        //处理导航菜单
        $('.treeview-menu > li').click(function () {
            $(this).addClass('active').siblings().removeClass('active');
        });
        $('.sidebar-menu li').click(function () {
            var url = $(this).attr('data-url');
            if (url != undefined && url.length > 0) {
                $('#content-frame').attr('src', url);
                return false;
            }
        });


        //修改密码
        $("#btn-change-password").on("click", function () {
            $("#change-password-modal :input").val("");
            $("#change-password-modal").modal("show");
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
                        url: "${ctxPath}/admin/warningdispostion/queryList",
                        dataSrc: function (json) {
                            json.draw = json.result.draw;
                            json.recordsTotal = json.result.recordsTotal;
                            json.recordsFiltered = json.result.recordsFiltered;
                            return json.result.data;
                        }
                    },
                    columns: [
                        {"data": "name","bSortable": false},
                        {"data": "warningTime","bSortable": false},
                        {"data": "acceptProvider","bSortable": false},
                        {"data": "tel","bSortable": false},
                        {"data": null, "bSortable": false}
                    ],
                    //操作按钮
                    columnDefs: [
                        {
                            targets: -1,
                            "data":"dispositionStatus",
                            "render": function (data, type, full) {
                                if(data.claimStatus=="未签收"){
                                    return "<div class='btn-group'>" +
                                            "<button type='button' id='btn-claim-row' class='btn btn-default btn-sm' data-toggle='tooltip' data-container='body' title='签 收'><i class='fa fa-paint-brush'></i></button>" +
                                            "</div>";
                                }else{
                                    return "<div class='btn-group'>" +
                                            "<button type='button' id='btn-detail-row' class='btn btn-default btn-sm' data-toggle='tooltip' data-container='body' title='详 情'>" +
                                            "<a href='${ctxPath}/admin/index/detail.html?id="+data.id+"' target='_bank'>" +
                                            "<i class='fa fa-info'></i>" +
                                            "</a>" +
                                            "</button>" +
                                            "</div>";
                                }
                            }
                        }
                    ],
                    language: {
                        url: "${ctxPath}/resources/plugins/datatables/i18n/Chinese.json"
                    }
                    ,
                    "fnInitComplete": function () {
                        this.width("100%");
                        this.fnAdjustColumnSizing();//重置列宽
                        this.fnDraw();//重新绘制
                    }
                });



        //签收
        $("#data-table tbody").on("click", "#btn-claim-row", function () {
            var data = tables.api().row($(this).parents("tr")).data();
            url = "${ctxPath}/admin/warningdispostion/claim";
            $.ajax({
                url:url,
                data:{id:data.id},
                type:"post",
                success:function(data){
                    if(data.code==0){
                        $.toaster("签收成功");
                        tables.fnDraw(false);
                    }else{
                        $.toaster("异常信息:" + data.message, "服务异常", "danger");
                    }
                }
            });
        });

        $("#user-main-candan").on("click",function(){
            $("#user-caidan").toggle();
        });






        $("#time-warning-modal").on("click",function(){
            $("#warning-modal").modal("show");
        });


</script>