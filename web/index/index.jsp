<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/11/16
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>学生成绩信息管理系统</title>
    <link rel="stylesheet" href="../static/dist/css/layui.css" tppabs="https://www.layui.site/layui/dist/css/layui.css?t=1632428048355"  media="all">

    <style>
        /* 移动端 */
        @media screen and (max-width: 768px) {
            .layui-layout-admin .layui-layout-left,
            .layui-layout-admin .layui-body,
            .layui-layout-admin .layui-footer{left: 0;}
            .layui-layout-admin .layui-side{left: -300px;}
        }
    </style>
</head>
<body>
    <div class="layui-layout layui-layout-admin">
        <div class="layui-header">
            <div class="layui-logo layui-hide-xs layui-bg-black">学生成绩管理系统</div>
            <!-- 头部区域（可配合layui 已有的水平导航） -->
            <ul class="layui-nav layui-layout-left">
                <!-- 移动端显示 -->
                <li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-header-event="menuLeft">
                    <i class="layui-icon layui-icon-spread-left"></i>
                </li>



            </ul>
<%--            ${teacher.getImage_addr()}--%>
            <ul class="layui-nav layui-layout-right">
                <li class="layui-nav-item layui-hide layui-show-md-inline-block">
                    <a href="javascript:;">
                        <img src="${teacher.getImage_addr()}"  class="layui-nav-img">
                            ${teacher.getName()}
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a >我的信息</a></dd>
                        <dd><a href="/LoginOut">退出登录</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item" lay-header-event="menuRight" lay-unselect>
                    <a href="javascript:;">
                        <i class="layui-icon layui-icon-more-vertical"></i>
                    </a>
                </li>
            </ul>
        </div>

        <div class="layui-side layui-bg-black">
            <div class="layui-side-scroll">
                <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
                <ul class="layui-nav layui-nav-tree" lay-filter="test">
                    <li class="layui-nav-item layui-nav-itemed">
                        <a class="" href="javascript:;">学生信息管理</a>
                        <dl class="layui-nav-child">
                            <dd><a onclick="mainbut()">基本信息</a></dd>
                            <dd><a onclick="baidubut()">班级信息</a></dd>
                            <dd><a href="javascript:;">课程信息</a></dd>
                        </dl>
                    </li>
                    <li class="layui-nav-item">
                        <a href="javascript:;">成绩信息</a>
                        <dl class="layui-nav-child">
                            <dd><a href="javascript:;">公开课</a></dd>
                            <dd><a href="javascript:;">专业课</a></dd>
                        </dl>
                    </li>
                    <li class="layui-nav-item"><a href="javascript:;">公告</a></li>
                </ul>
            </div>
        </div>

        <div class="layui-body">
            <!-- 内容主体区域 -->
            <iframe id="kj" src="../index/main.jsp" frameborder="0" width="100%" height="100%"></iframe>
        </div>
        <div class="layui-footer">
            <!-- 底部固定区域 -->
            @YSZ出品：学生成绩管理系统
        </div>
    </div>
    <script src="../static/dist/layui.js" tppabs="https://www.layui.site/layui/dist/layui.js?t=1632428048355" charset="utf-8"></script>
    <script>
        //JS
        layui.use(['element', 'layer', 'util'], function(){
            var element = layui.element
                ,layer = layui.layer
                ,util = layui.util
                ,$ = layui.$;

            //头部事件
            util.event('lay-header-event', {
                //左侧菜单事件
                menuLeft: function(othis){
                    layer.msg('展开左侧菜单的操作', {icon: 0});
                }
                ,menuRight: function(){
                    layer.open({
                        type: 1
                        ,title: '更多'
                        ,content: '<div style="padding: 15px;">暂无消息</div>'
                        ,area: ['260px', '100%']
                        ,offset: 'rt' //右上角
                        ,anim: 5
                        ,shadeClose: true
                        ,scrollbar: false
                    });
                }
            });

        });
        function mainbut(){
            document.getElementById('kj').src="../index/main.jsp";
        }
        function baidubut(){
            document.getElementById('kj').src="https://www.w3school.com.cn/tags/tag_map.asp";
        }

    </script>

</body>
</html>
