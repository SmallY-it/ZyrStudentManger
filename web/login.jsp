<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/11/16
  Time: 8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>教师登录</title>
    <link rel="stylesheet" href="./static/dist/css/layui.css">
    <script src="./static/jquery-3.6.0.js"></script>
  </head>
  <style>
    .login {
      display: flex;
      margin: auto;
      width: 400px;
      height: 280px;
      background-color: antiquewhite;
      border-radius: 30px;
      margin-top: 150px;
    }
  </style>
  <body>
  <div class="login">

    <form action="/TearLoginCheck" method="post">
      <h1 style="text-align: center;margin-left: 55px">用户登录</h1>
      <div class="layui-form-item" style="margin-left: -30px;margin-top: 10px">
        <label class="layui-form-label">工号</label>
        <div class="layui-input-block">
          <input type="text" name="username" required lay-verify="required" placeholder="请输入工号"
                 autocomplete="off" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item" style="margin-left: -30px;margin-top: 10px">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-block">
          <input type="password" name="password" required lay-verify="required" placeholder="请输入密码"
                 autocomplete="off" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item" style="margin-left: -30px;margin-top: 10px">
        <label class="layui-form-label">验证码</label>
        <div class="layui-input-inline">
          <input type="text" name="cheackcode" style="width: 120px" required lay-verify="required"
                 placeholder="请输入验证码" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"><img id="scode" src="/Codeimg"
                                                        style="margin-top: -10px;margin-left: -30px;  width: 120px; height: 30px;"></div>
      </div>
      <div class="layui-form-item">
        <div class="layui-input-block">
          <button class="layui-btn" lay-submit lay-filter="formDemo">登录</button>
          <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
      </div>
    </form>
  </div>
  <script>
    $("#scode").click(function (){
      $.get("/Codeimg",function (data,status){
        $('#scode').attr('src', "/Codeimg");
      })
    })
  </script>
  </body>
</html>
