<%--
  Created by IntelliJ IDEA.
  User: Tomorrow
  Date: 2021/3/9
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="UploadServlet?action=upload" method="post" enctype="multipart/form-data">
    用户名<input type="text" name="username" value=""><br>
    头像<input type="file" name="photo"><br>
    <input type="submit"value="上传">
</form>
</body>
</html>
