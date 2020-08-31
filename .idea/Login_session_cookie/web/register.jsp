<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="/loginServlet" method="post">
    <h3 align="center">账号登录</h3>
    <p class="username"><span>账户</span><input type="text" name="loginName" value="" placeholder="请输入会员名/邮箱" class="name"></p>
    <hr>
    <p class="password"><span>登录密码</span><input type="password" name="loginPs" value="" placeholder="请输入密码" class="ps"></p>
    <p class="password"><span>确认密码</span><input type="password" name="loginNextPs" value="" placeholder="请再次输入密码" class="ps"></p>
    <button type="button" class="reg">注册</button>
    <button type="submit" class="login">返回登录</button>

</form>
<div class="other">
    <p>—————— 其他方式登录 ——————</p>


</div>
</body>
</html>