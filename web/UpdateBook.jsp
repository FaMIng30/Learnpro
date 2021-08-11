<%--
  Created by IntelliJ IDEA.
  User: Tomorrow
  Date: 2021/2/5
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="ManagerServlet?ID=${requestScope.book.ID}" method="post">
    <input type="hidden" name="action" value=${(empty requestScope.book.ID)? "addBook":"updateBook"}>
     名称<input type="text" name="name" value="${requestScope.book.name}">
     作家<input type="text" name="author" value="${requestScope.book.author}">
     描述 <input type="text" name="descrip" value="${requestScope.book.descrip}">
       <input type="submit" value="提交">
</form>
</body>
</html>
