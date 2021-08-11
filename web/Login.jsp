<%--
  Created by IntelliJ IDEA.
  User: Tomorrow
  Date: 2021/2/1
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<form action="LoginServlet?action=Login" method="post"  >
    <input type="hidden" >
    <div >${ (empty requestScope.user)? "":"密码错误"}</div>
    <tr>
        <td> 用户名：</td>
        <td>   <input id="user01"  type="text" name="username" value=${cookie.username.value} ><span id="uname"></span></td>
    </tr>
    <tr>
        <td>  密码:</td>
        <td>   <input id="psw" type="text" name="passwords" value="" ><span id="pswd" va></span></td>
    </tr>
     <tr>
         <td><input type="submit" value="登录"></td>
         <a href="registers.jsp">注册</a>
     </tr>
</form>
</body>
</html>
