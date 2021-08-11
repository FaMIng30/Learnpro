<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript" src="jquery-1.7.2.js"></script>
    <script type="text/javascript " src="Login.js"></script>


</head>
<body>

    <table   bgcolor="#7fffd4">
        <h1 align="right">用户登录</h1>
        <button  id ="da" >试一试</button>
        <p id="demo"></p>
        <form action="LoginServlet?action=registers" method="post"  enctype="multipart/form-data" accept-charset="UTF-8" >
            <input type="hidden" name="login">
            <tr>
                <td>头像</td>
                <td>  <input  id="logo" type="file" name="logopath" value=""><span ></span></td>
            </tr>
        <tr>

            <td> 用户名：</td>
            <td>   <input id="user01"  type="text" name="username" value="" ><span id="uname"></span></td>
        </tr>
        <tr>
            <td>  密码:</td>
            <td>   <input id="psw" type="text" name="passwords" value="" ><span id="pswd"></span></td>
        </tr>
            <tr>
                <td>  姓名:</td>
                <td>   <input id="truename" type="text" name="truename" value="" ><span ></span></td>
            </tr>
            <tr>
                <td>电话</td>
             <td>  <input  id="telph" type="text" name="tellphone" value=""><span id="telp"></span></td>
            </tr>
            <tr>
                <td>性别</td>
                <td><input  type="radio" name="gender" value="男">男
                    <input  type="radio" name="gender" value="女">女 <span></span></td>
            </tr>

        <tr>
            <td>    验证码：</td>
            <td>   <input id="checkcode" type="text"  name="yzcode"  value=""><span id="yzm"></span></td>
        </tr>
            <tr>
                <td>  <img src="http://localhost:8088/Learnpro/kaptcha.jpg" style="width: 70px ; height: 28px" alt=""></td>
            </tr>
            <tr>
                <td><input type="submit" value="注册"  align="center"></td>
                <td><a href="Login.jsp">登录</a> </td>
            </tr>

</form>
</table>
</body>
</html>