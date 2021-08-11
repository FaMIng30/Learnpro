<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Tomorrow
  Date: 2021/2/20
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="jquery-1.7.2.js"></script>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        $(function () {

            $("#counts").onchange(function () {
                var count=this.value();
                $.getJSON("CartServlet?action=updatecounts&countss="+count, function (data) {

                })
            })
        })
    </script>
</head>
<body>
<a href="http://localhost:8088/Learnpro/BookHome.jsp">主页</a>

    <table cellpadding="50">
        <c:if test="${ empty sessionScope.cart.cartiterm}">
            <div>
                <a href="BookHome.jsp">购物车为空，快去购物吧</a>
            </div>
        </c:if>
        <tr>
            <td> <span>商品名称</span></td>
            <td><span>商品数量</span></td>
            <td> <span>商品单价</span></td>
            <td> <span>商品总价</span></td>
        </tr>
        <c:forEach items="${sessionScope.cart.cartiterm}" var="cartiterms">
        <tr >
            <td>${cartiterms.value.itermname}</td>
            <td><input id="counts" type="text" name="countss" value="${cartiterms.value.itermcounts}"style="width: 30px"></td>
            <td>${cartiterms.value.price}</td>
            <td id="total">${cartiterms.value.totalprice}</td>
            <td><a href="CartServlet?action=deliterm&ID=${cartiterms.value.ID}" id="dele">删除 </a></td>
        </tr>
        </c:forEach>
    </table>
<h3>总共${sessionScope.cart.itermtotalCount}件商品共${sessionScope.cart.totalPrice}元</h3>


</body>
</html>
