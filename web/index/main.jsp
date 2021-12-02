<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/11/16
  Time: 10:48
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
<table id="demo" lay-filter="test"></table>

    <script src="../static/dist/layui.js"></script>
    <script type="text/html" id="toolbarDemo">
        <div class="layui-btn-container">

            <button class="layui-btn layui-btn-sm layui-btn-danger" lay-event="delete">删除</button>
        </div>
    </script>
    <script type="text/html" id="addtoolbarDemo">
        <div class="layui-btn-container">
            <button class="layui-btn layui-btn-sm" lay-event="add">添加</button>
            <button class="layui-btn layui-btn-sm" lay-event="update">编辑</button>
            <button class="layui-btn layui-btn-sm" lay-event="flush">刷新</button>
<%--            <button class="layui-btn layui-btn-sm" lay-event="serach">搜索</button>--%>
        </div>
    </script>
    <script>
        layui.use('table', function () {
            var table = layui.table;

            //第一个实例
            table.render({
                //toolbar:true,
                toolbar: '#addtoolbarDemo' ,
                elem: '#demo',
                id: 'queryList',
                height: 600,
                // url: 'http://127.0.0.1:8000/api/test', //数据接口Python
                url: '/MainData', //数据接口Java
                response: {
                    dataName: 'list'
                },
                dataType: 'json',
                // crossDomain: true,
                // page: true, //开启分页

                cols: [
                    [ //表头
                        {
                            field:"select",
                            title: '选择',
                            type:"checkbox",
                        },
                        {
                            field: 'id',
                            title: '学号',
                            width: 80,
                            sort: true,
                        }, {
                        field: 'username',
                        title: '姓名',
                        width: 80
                    }, {
                        field: 'sex',
                        title: '性别',
                        width: 80,


                    }, {
                        field: 'experience',
                        title: '身份证号码',
                        width: 200,

                    }, {
                        field: 'score',
                        title: '年级',
                        width: 120,

                    }, {
                        field: 'classify',
                        title: '班级',
                        width: 120,

                    }, {
                        field: 'city',
                        title: '家庭住址',
                        width: 300,

                    }, {
                        field: 'pro',
                        title: '操作',
                        toolbar: "#toolbarDemo"
                    }
                    ]
                ],
            });
            table.on('tool(test)', function(obj){
                // console.log(obj.data)
                 var data = obj.data.username; //获得当前行数据
                // console.log(data);
                 var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
                 var tr = obj.data; //获得当前行 tr 的 DOM 对象（如果有的话）
                // console.log(tr)
                 var layEvent = obj.event;
                if(layEvent === 'delete'){ //删除
                    layer.confirm('确定删除:'+data+"同学吗！", function(index){
                        obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                        layer.close(index);
                        //向服务端发送删除指令
                        $.post("/MainData",{
                            id:obj.data.id,
                            name:obj.data.username,
                            experience:obj.data.experience,
                        },function(data,status){
                            //alert("状态: " + status);
                            if(status=="success"){
                                layer.msg("删除成功");
                            }else{
                                layer.msg("删除失败");
                                setTimeout(function(){ location.reload(); }, 3000);
                            }
                        })
                    });
                }
            });

            table.on('row(test)',function (obj){
                localStorage.setItem('objdate',JSON.stringify(obj.data))
                //console.log(obj.data)
            })
            table.on('toolbar(test)', function(obj){
                var checkStatus = table.checkStatus(obj.config.id);

                if(obj.event=="add"){
                    //console.log("添加按钮")
                    layer.open({
                        title: '添加学生信息',
                        type: 2,
                        content: 'myinfo.jsp',
                        area: ['530px', '100%']
                    });
                }else if (obj.event=="update"){
                    //window.location.replace("updateinfo.jsp");
                    layer.open({
                        title: '修改学生信息',
                        type: 2,
                        content: 'updateinfo.jsp',
                        area: ['530px', '100%']
                    });
                    //console.log("刷新")
                }else {
                    //页面刷新
                    location.reload();
                }
            });

        });
    </script>
</body>
</html>
