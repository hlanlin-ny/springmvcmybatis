<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/admin/common/basejs.jsp" %>
<%-- iCheck 1.0.1 --%>
<script src="${ctxPath}/resources/plugins/iCheck/icheck.min.js"></script>
<%-- jQuery validation --%>
<script src="${ctxPath}/resources/plugins/jquery-validation/jquery.validate.min.js"></script>
<script src="${ctxPath}/resources/plugins/jquery-validation/localization/messages_zh.js"></script>
<!-- 本页面用到的js -->
<script type="text/javascript">

    function refreshCaptchaImg() {
        var src = "${ctxPath}/captcha.html?t=" + $.now();
        $("#captcha-img").attr('src', src);
    }

    $.validator.setDefaults({
        submitHandler: function () {
            var rememberMe = 0;
            if (true == $("#rememberMe").is(":checked")) {
                rememberMe = 1;
            }
            var data = "username=" + $("#username").val() + "&password=" + $("#password").val() + "&captcha=" + $("#captcha").val() + "&rememberMe=" + rememberMe;
            $.ajax({
                cache: false,
                type: "POST",
                url: "${ctxPath}/admin/login/login",
                data: data,
                dataType: "json",
                success: function (data) {
                    if (data.code == 0) {
                        parent.location.href = "${ctxPath}/admin/index/index.html";
                    } else {
                        $("#login-message").show();
                        $("#login-message-content").text(data.message);
                        refreshCaptchaImg();
                    }
                },
                error: function (data) {
                    $("#login-message").show();
                    $("#login-message-content").text(data.message);
                    refreshCaptchaImg();
                }
            });
        }
    });

    $().ready(function () {

        // 提交时验证表单
        var validator = $("#login-form").validate({
            messages: {
                username: {
                    required: "请输入用户名",
                    minlength: "用户名不能少于 5 个字符"
                },
                password: {
                    required: "请输入密码",
                    minlength: "密码不能少于 6 个字符",
                    maxlength: "密码不能大于 20 个字符"
                },
                captcha: {
                    required: "请输入验证码",
                    minlength: "验证码不能少于 5 个字符",
                    maxlength: "验证码不能大于 5 个字符"
                }
            }
        });

        $("input[name='fileType']").iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' // optional
        });

        $("#username").focus();

        $("#username").focus(function(){
            $("#login-message").hide();
        });
        $("#password").focus(function(){
            $("#login-message").hide();
        });
        $("#captcha").focus(function(){
            $("#login-message").hide();
        });
        $("#rememberMe").focus(function(){
            $("#login-message").hide();
        });

        $("#captcha-img").on("click", function () {
            refreshCaptchaImg();
        });

        $("#captcha-img-refersh").on("click", function () {
            refreshCaptchaImg();
        });

        $('#rememberMe').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' // optional
        });
    });

</script>