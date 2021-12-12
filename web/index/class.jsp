<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/11/29
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="Access-Control-Allow-Origin" content="IE=edge,chrome=1">
    <link rel="stylesheet" href="../static/dist/css/layui.css" tppabs="https://www.layui.site/layui/dist/css/layui.css?t=1632428048355"  media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
    <script src="../static/jquery-3.6.0.js"></script>
</head>
<body>
<%--    功能栏--%>
    <script type="text/html" id="addtoolbarDemo">
        <div class="layui-btn-container">
<%--            <button class="layui-btn layui-btn-sm" lay-event="add">添加</button>--%>
<%--            <button class="layui-btn layui-btn-sm" lay-event="update">编辑</button>--%>
            <button class="layui-btn layui-btn-sm" lay-event="flush">刷新</button>

        </div>
    </script>

    <table id="demo" lay-filter="test"></table>
    <script src="../static/dist/layui.js"></script>
    <script>
        layui.use('table', function(){
            var table = layui.table;

            //第一个实例
            table.render({
                toolbar: '#addtoolbarDemo' ,
                elem: '#demo'
                ,height: 312
                ,id: 'queryList'
                ,url: '/ClassInfoServlet' //数据接口
                ,response: {
                    dataName: 'list'
                },
                    dataType: 'json'
                // ,page: true //开启分页
                ,cols: [[ //表头
                    {field: 'Id', title: 'id', width:180}
                    ,{field: 'ClassName', title: '班级', width:180}
                    ,{field: 'ClassTeacher', title: '班主任', width:180}
                    ,{field: 'ClassYer', title: '隶属年级', width:180}
                    ,{field: 'Class_size', title: '班级人数', width:180}
                ]]
            });
        });
    </script>
</body>
</html>
