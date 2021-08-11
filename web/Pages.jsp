<%--
  Created by IntelliJ IDEA.
  User: Tomorrow
  Date: 2021/2/11
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="jquery-1.7.2.js"></script>

<html>
<head>
    <title>Title</title>
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
                location.href = "${requestScope.page.url}&pageNo=" +
                    pageNo;
            });
        });
    </script>
        </head>
<body>
<c:choose>
    <%--情况一：页数少于5--%>
    <c:when test="${requestScope.page.pageTotal<=5}">
        <c:set var="beignss" value="1"/>
        <c:set var="end" value="${requestScope.page.pageTotal}"/>
    </c:when>
    <%--情况 2：总页码大于 5 的情况--%>
    <c:when test="${requestScope.page.pageTotal > 5}">
        <c:choose>
            <%--小情况 1：当前页码为前面 3 个：1，2，3 的情况，页码范围是：1-5.--%>
            <c:when test="${requestScope.page.pageNo <= 3}">
                <c:set var="beginss" value="1"/>
                <c:set var="end" value="5"/>
            </c:when>
            <%--小情况 2：当前页码为最后 3 个，8，9，10，页码范围是：总页码减 4 - 总页码--%>
            <c:when test="${requestScope.page.pageNo > requestScope.page.pageTotal-3}">
                <c:set var="beginss" value="${requestScope.page.pageTotal-4}"/>
                <c:set var="end" value="${requestScope.page.pageTotal}"/>
            </c:when>
            <%--小情况 3：4，5，6，7，页码范围是：当前页码减 2 - 当前页码加 2--%>
            <c:otherwise>
                <c:set var="beginss" value="${requestScope.page.pageNo-2}"/>
                <c:set var="end" value="${requestScope.page.pageNo+2}"/>
            </c:otherwise>
        </c:choose>
    </c:when>
</c:choose>




<div>


    <c:if test="${requestScope.page.pageNo>1}">
        <a href="${requestScope.page.url}&pageNo=1">首页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">上一页</a>
    </c:if>

    <c:forEach begin="${beginss}" end="${end}" var="i">
        <c:if test="${i == requestScope.page.pageNo}">
            【${i}】
        </c:if>
        <c:if test="${i != requestScope.page.pageNo&& i!= 0}">
            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
        </c:if>
    </c:forEach>

    <c:if test="${requestScope.page.pageNo<requestScope.page.pageTotal}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}">下一页</a>
    </c:if>
     共${requestScope.page.pagecount}条记录
     共${requestScope.page.pageTotal}页
      当前${requestScope.page.pageNo}/${requestScope.page.pageTotal}
    <input  id="inputs" type="text" name="search" value=""style="width: 80px">
    <input id="Btn" type="button" value="跳转">
</div>
</body>
</html>
