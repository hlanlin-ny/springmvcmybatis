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



    $().ready(function () {
        $("#changeBgImg").click(function(){
            if($('#backgroundImage').val()==''||$('#backgroundImage').size()<0){
                alert('请选择文件');
                return;
            }
            var form = $("form[name=img-form]");
            var options = {
                url:'${ctxPath}/admin/sysconfig/uploadImage',
                type:'post',
                success:function(data){
                    if (data.code == 0) {
                        $.cookie("imgUrl",data.result,{expires : 365,path: '/'});
                        $.toaster("更换成功", "系统提示");
                    } else {
                        console.log("服务异常:" + data);
                        $.toaster("异常信息:" + data.message, "服务异常", "danger");
                    }
                }
            };
            form.ajaxSubmit(options);
        });

        $("#warningMusicChange").click(function(){
            if($('#musicWarning').val()==''||$('#musicWarning').size()<0){
                alert('请选择文件');
                return;
            }
            var form = $("form[name=warning-form]");
            var options = {
                url:'${ctxPath}/admin/sysconfig/uploadWarningMusic',
                type:'post',
                success:function(data){
                    if (data.code == 0) {
                        $.cookie("musicUrl",data.result,{path: '/' });
                        $.toaster("更换成功", "系统提示");
                    } else {
                        console.log("服务异常:" + data);
                        $.toaster("异常信息:" + data.message, "服务异常", "danger");
                    }
                }
            };
            form.ajaxSubmit(options);
        });
    });
</script>