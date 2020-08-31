<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2020/8/29
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/login.css">
    <script>
        window.onload = function () {
            document.querySelector("#img").onclick = function () {
           this.src = "/checkCodeServlet?time="+new Date().getTime()
            }
        }

    </script>
</head>
<body>
<form action="/loginServlet" method="post">
    <h3 align="center">账号登录</h3>
    <p class="username"><span>账户</span><input type="text" name="loginName" value="" placeholder="请输入会员名/邮箱" class="name"></p>
    <hr>
    <p class="password"><span>登录密码</span><input type="password" name="loginPs" value="" placeholder="请输入密码" class="ps"></p>
    <p class="check"><span>验证码</span><input type="text" name="checkCode" value="" placeholder="请输入验证码" class="checkCode"></p>
    <div class="img"><img id="img" src="/checkCodeServlet" alt="" align="center"></div>
    <div class="error"><%=request.getAttribute("login_error") == null?"":request.getAttribute("login_error")%></div>
    <div class="error"><%=request.getAttribute("cc_error") == null?"":request.getAttribute("cc_error")%></div>
    <button type="button" class="forget">忘记密码</button>
    <button type="submit" class="login">登录</button>
    <button type="button" class="reg">注册</button>
</form>
<div class="other">
    <p>—————— 其他方式登录 ——————</p>


</div>
<script>

</script>
</body>
</html>
