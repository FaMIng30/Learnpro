<%--
  Created by IntelliJ IDEA.
  User: Tomorrow
  Date: 2021/2/11
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-1.7.2.js"></script>
    <script>
        $(function () {
            $(".btn").click(function () {
                var bookid =$(this).attr("bookid")
                 $.getJSON("CartServlet?action=addCart&ID="+bookid,function (data) {
                     alert("你将 "+ data +" 加入了购物车")

                 })

        })
        })
    </script>

    <style type="text/css">
        #box{
            border:1px solid
        }
        .head-img {width: 66px;height: 66px;
            background-color: #fff;padding: 3px;
            box-shadow: 0 2px 2px rgba(0, 0, 0, 0.3);
            /*margin: 0 auto 10px;*/
            margin:10px 5px 15px;
            box-sizing: border-box;
            border-radius: 50%;}
        .head-img img {display: block;width: 60px;height: 60px;border-radius: 50%;}



    </style>



</head>
<body>
<h1 align="center">书城主页</h1>
<div class="head-img">
    <img src="images/${sessionScope.logo}" >
    <a href="https://baike.baidu.com/item/%E4%B9%A0%E8%BF%91%E5%B9%B3/515617?fr=aladdin" >${sessionScope.username}</a>
</div>


<a href="ManagerServlet?action=page">图书管理</a>
<a href="ShoppingCart.jsp">购物车</a>
<div>
<form action="ManagerServlet?action=search" method="post">
    <input type="text" name="search" value="">
    <input type="submit" value="搜索">
</form>
</div>
<div>
    <div id="box"> <table cellpadding="30" >

            <tr >
                <c:forEach items="${requestScope.page.pageitem}" var="book" begin="${0}" end="${3}">
                <td>  <img src="images/${book.bookpath}" style="width: 300px" height="200"></br>
                ${book.ID}
                ${book.name}
                ${book.author}
                ${book.descrip}
               <input  class="btn"  type="button" bookid="${book.ID}" value="加入购物车">
              </td>
                </c:forEach>
            </tr>
        <tr >
            <c:forEach items="${requestScope.page.pageitem}" var="book" begin="${4}" end="${7}">
                <td>  <img src="images/${book.bookpath}" style="width: 300px" height="200"></br>
                        ${book.ID}
                        ${book.name}
                        ${book.author}
                        ${book.descrip}
                    <input  class="btn" type="button" bookid="${book.ID}" value="加入购物车">
                </td>
            </c:forEach>
        </tr>

        </table>

    </div>
</div>
<%@include file="../Pages.jsp"%>
</body>
</html>
