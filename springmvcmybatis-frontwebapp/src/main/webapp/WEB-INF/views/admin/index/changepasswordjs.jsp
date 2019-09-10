<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- 本页面用到的js -->
<script type="text/javascript">

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

    $().ready(function () {

        // 提交时验证表单
        var validator = $("#change-password-form").validate();

        $("#btn-cancel").on("click", function () {
            validator.resetForm();
        });

        //修改密码
        $("#btn-change-password").on("click", function () {
            $("#change-password-modal :input").val("");
            $("#change-password-modal").modal("show");
        });
    });

</script>