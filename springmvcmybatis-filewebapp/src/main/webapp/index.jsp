<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
<form action="${pageContext.request.contextPath}/UploadFile/Upload" enctype="multipart/form-data" method="post" >
    <%--用户名称:<input type="text" name="username"> <br/>--%>
    上传图片1:<input type="file" name="uploadfile"><br/>
    上传图片2:<input type="file" name="uploadfile"><br/>
    上传图片3:<input type="file" name="uploadfile"><br/>
    上传图片4:<input type="file" name="uploadfile"><br/>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
