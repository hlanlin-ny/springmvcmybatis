<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="${pageContext.request.contextPath}/UploadFile/upload" enctype="multipart/form-data" method="post" >
  <%--用户名称:<input type="text" name="username"> <br/>--%>
  上传图片1:<input type="file" name="uploadfile"><br/>
  上传图片2:<input type="file" name="uploadfile"><br/>
  上传图片3:<input type="file" name="uploadfile"><br/>
  上传图片4:<input type="file" name="uploadfile"><br/>
  <input type="submit" value="提交"/>
</form>
</body>
</html>
