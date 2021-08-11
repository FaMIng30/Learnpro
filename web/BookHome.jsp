<%--
  Created by IntelliJ IDEA.
  User: Tomorrow
  Date: 2021/2/1
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <title>Title</title>
</head>
<body>
<jsp:forward page="ClientServlet">
    <jsp:param name="action" value="page"/>
</jsp:forward>
</body>

