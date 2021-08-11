<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page language="java"  pageEncoding="utf-8"%>
    <script type="text/javascript" src="jquery-1.7.2.js"></script>
    <script type="text/javascript">
      $(function () {
// 跳到指定的页码
            $("#Btn").click(function () {
                var pageNo = $("#inputs").val();
                <%--var pageTotal = ${requestScope.page.pageTotal};--%>
                <%--alert(pageTotal);--%>
// javaScript 语言中提供了一个 location 地址栏对象
// 它有一个属性叫 href.它可以获取浏览器地址栏中的地址
// href 属性可读，可写
                location.href = "ManagerServlet?action=page&pageNo=" +
                    pageNo;
            });
        });


     /*  $(function () {
           $("#Btn").click(function () {
                    var pageNo = $("#inputs").val();
                    Location.href= "ManagerServlet?action=page&pageNo=" +
                        pageNo;
           });

       });*/
    </script>
</head>
<table cellpadding="30">
    <tr>
        <td> <span>商品编号</span></td>
        <td><span>商品名称</span></td>
        <td> <span>商品作者</span></td>
        <td> <span>商品描述</span></td>
    </tr></table>
<c:forEach items="${requestScope.page.pageitem}" var="book">
<table cellpadding="20">
    <tr >
        <td>${book.ID}</td>
        <td>${book.name}</td>
        <td>${book.author}</td>
        <td>${book.descrip}</td>
        <td><a href="ManagerServlet?action=getBook&ID=${book.ID}&name=${book.name}&author=${book.author}&descrip=${book.descrip}" >修改</a></td>
        <td><a href="ManagerServlet?action=deleteBook&ID=${book.ID}" id="dele">删除 </a></td>
    </tr>
</table>
</c:forEach>


<div>
<%@include file="Pages.jsp"%>
</div>