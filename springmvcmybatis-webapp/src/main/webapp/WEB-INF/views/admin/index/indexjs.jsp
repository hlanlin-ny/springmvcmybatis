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
            $.ajax({
                cache: false,
                type: "POST",
                url: "${ctxPath}/admin/sysuser/changepassword",
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

    $().ready(function () {

        //抽取停车系统定时任务

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
                    {"data": "name", "bSortable": false},
                    {"data": "warningTime", "bSortable": false},
                    {"data": "acceptProvider", "bSortable": false},
                    {"data": "tel", "bSortable": false},
                    {"data": null, "bSortable": false}
                ],
                //操作按钮
                columnDefs: [
                    {
                        targets: -1,
                        "data": "dispositionStatus",
                        "render": function (data, type, full) {
                            if (data.claimStatus == "未签收") {
                                return "<div class='btn-group'>" +
                                    "<button type='button' id='btn-claim-row' class='btn btn-default btn-sm' data-toggle='tooltip' data-container='body' title='签 收'><i class='fa fa-paint-brush'></i></button>" +
                                    "</div>";
                            } else {
                                return "<div class='btn-group'>" +
                                    "<button type='button' id='btn-detail-row' class='btn btn-default btn-sm' data-toggle='tooltip' data-container='body' title='详 情'>" +
                                    "<a href='${ctxPath}/admin/index/detail.html?id=" + data.id + "' target='_bank'>" +
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
                url: url,
                data: {id: data.id},
                type: "post",
                success: function (data) {
                    if (data.code == 0) {
                        $.toaster("签收成功");
                        tables.fnDraw(false);
                        var audio = document.getElementById('music1');
                        if (audio !== null) {
                            if (!audio.paused)
                                audio.pause();// 这个就是暂停
                        }
                    } else {
                        $.toaster("异常信息:" + data.message, "服务异常", "danger");
                    }
                }
            });
        });

        //定时预警任务和刷新未签收条数任务
        /*setInterval(function(){
            tables.fnDraw();
            $.ajax({
                url:"${ctxPath}/admin/warningdispostion/warningTime",
                success:function(data){
                    console.log(data);
                    if(data.code == 0){
                        var data = data.result;
                        if(data!=null && data!=""){//说明当前有预警信息，开始报警
                            $("#warning-modal").modal("show");
                            var audio = document.getElementById('music1');
                            if(audio!==null){
                                //检测播放是否已暂停.audio.paused 在播放器播放时返回false.
                                if(audio.paused)                     {
                                    audio.play();//audio.play();// 这个就是播放
                                }
                            }
                        }
                    }
                }
            });

            $.ajax({
                url:"${ctxPath}/admin/warningdispostion/queryUnclaim",
                success:function(data){
                    if(data.code == 0){
                        var result = data.result;
                        if(result>0){
                            $("#un_claim_number").html(result);
                        }else{
                            $("#un_claim_number").html("");
                        }
                    }
                }
            })
        },10000);*/


        var imgurl = $.cookie("imgUrl");
        $("#body-bg").attr("style", "background-image: url('" + imgurl + "');min-height: 780px");
        // 提交时验证表单
        var validator = $("#change-password-form").validate();

        $("#btn-cancel").on("click", function () {
            validator.resetForm();
        });

        $("#changeBgImg").click(function () {
            if ($('#backgroundImage').val() == '' || $('#backgroundImage').size() < 0) {
                alert('请选择文件');
                return;
            }
            var form = $("form[name=img-form]");
            var options = {
                url: '${ctxPath}/admin/sysconfig/uploadImage',
                type: 'post',
                success: function (data) {
                    if (data.code == 0) {
                        $.cookie("imgUrl", data.result, {expires: 365, path: '/'});
                        $.toaster("更换成功", "系统提示");
                        $("#image-modal").modal("hide");
                        location.reload();
                    } else {
                        console.log("服务异常:" + data);
                        $.toaster("异常信息:" + data.message, "服务异常", "danger");
                    }
                }
            };
            form.ajaxSubmit(options);
        });

        $("#user-main-candan").on("click", function () {
            $("#user-caidan").toggle();
        });

        //修改密码
        $("#btn-change-password").on("click", function () {
            $("#change-password-modal :input").val("");
            $("#change-password-modal").modal("show");
        });

        $.ajax({
            url: "${ctxPath}/admin/index/verification",
            type: "POST",
            success: function (data) {
                var result = data.result;
                if (result.admin == 1) {//说明有管理员模块权限
                    <%--$("#adminModule").attr("href","${ctxPath}/admin/index/adminmodule.html");--%>
                    $("#adminModuleDiv").on("click", function () {
                        window.open("${ctxPath}/admin/index/adminmodule.html"); //打开新的页面
                    }).css("cursor", "pointer");
                }
                if (result.intell == 1) {//说明有情报数据权限
                    <%--$("#intellInfo").attr("href","${ctxPath}/admin/index/intelligencedata.html");--%>
                    $("#intellInfoDiv").on("click", function () {
                        window.open("${ctxPath}/admin/index/intelligencedata.html"); //打开新的页面
                    }).css("cursor", "pointer");
                }
                if (result.search == 1) {//说明有搜索平台权限
                    <%--$("#searchplat").attr("href","${ctxPath}/front/admin/login/login.html");--%>
                    <%--$("#searchplat").attr("href","${pageContext.request.getScheme()}://${pageContext.request.getServerName()}:${pageContext.request.getServerPort()}/front/admin/index/index.html");--%>
                    $("#searchplatDiv").on("click", function () {
                        window.open("${pageContext.request.getScheme()}://${pageContext.request.getServerName()}:${pageContext.request.getServerPort()}/front/admin/index/index.html"); //打开新的页面
                    }).css("cursor", "pointer");
                }
                if (result.searchw == 1) {//说明有预警设置权限
                    <%--$("#searchwarning").attr("href","${ctxPath}/admin/index/searchwarning.html");--%>
                    $("#searchwarningDiv").on("click", function () {
                        window.open("${ctxPath}/admin/index/searchwarning.html"); //打开新的页面
                    }).css("cursor", "pointer");
                }
                if (result.sysconfig == 1) {//说明有系统设置权限
                    <%--$("#sysconfig").attr("href","${ctxPath}/admin/index/sysconfig.html");--%>
                    $("#sysconfigDiv").on("click", function () {
                        window.open("${ctxPath}/admin/index/sysconfig.html"); //打开新的页面
                    }).css("cursor", "pointer");
                }
            }
        });

        $("#adminModule").click(function () {
            var url = $("#adminModule").attr("href");
            if (url == "javascript:void(0);") {
                $.toaster("没有相关权限，请联系系统管理员", "请求异常", "danger");
            }
        });

        $("#intellInfo").click(function () {
            var url = $("#intellInfo").attr("href");
            if (url == "javascript:void(0);") {
                $.toaster("没有相关权限，请联系系统管理员", "请求异常", "danger");
            }
        });

        $("#searchplat").click(function () {
            var url = $("#searchplat").attr("href");
            if (url == "javascript:void(0);") {
                $.toaster("没有相关权限，请联系系统管理员", "请求异常", "danger");
            }
        });

        $("#searchwarning").click(function () {
            var url = $("#searchwarning").attr("href");
            if (url == "javascript:void(0);") {
                $.toaster("没有相关权限，请联系系统管理员", "请求异常", "danger");
            }
        });

        $("#sysconfig").click(function () {
            var url = $("#sysconfig").attr("href");
            if (url == "javascript:void(0);") {
                $.toaster("没有相关权限，请联系系统管理员", "请求异常", "danger");
            }
        });

        $("#change").on("click", function () {
            var imgurl = $.cookie("imgUrl");
            $("#image").attr("src", imgurl);
            $("#image-modal").modal("show");
        });

        $("#time-warning-modal").on("click", function () {
            $("#warning-modal").modal("show");
        });

    });

</script>