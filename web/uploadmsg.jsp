--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="UploadServlet?action=upload" method="post" enctype="multipart/form-data" onsubmit="">
    <select>
        <option name="booktypes" value="教育">教育</option>
        <option name="booktypes" value="小说">小说</option>
        <option name="booktypes" value="科学">科学</option>
    </select>
    书名<input type="text" name="bookname" value=""><br>
    作者<input type="text" name="author" value=""><br>
    价格<input type="text" name="prices" value=""><br>
    描述<input type="text" name="descrip" value=""><br>
    图片<input type="file" name="photo"><br>
    <input type="submit"value="上传">
</form>
</body>
</html>
