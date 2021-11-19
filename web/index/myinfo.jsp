<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/11/19
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息添加</title>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="Access-Control-Allow-Origin" content="IE=edge,chrome=1">
    <link rel="stylesheet" href="../static/dist/css/layui.css" tppabs="https://www.layui.site/layui/dist/css/layui.css?t=1632428048355"  media="all">
    <script src="../static/dist/layui.js" tppabs="https://www.layui.site/layui/dist/layui.js?t=1632428048355" charset="utf-8"></script>
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
    <script src="../static/jquery-3.6.0.js"></script>
</head>
<style>
    h1{
        text-align: center;
        margin-bottom: 10px;
    }
</style>
<body>
    <div style="width: 520px; ">
        <h1>学生信息添加</h1>
        <form class="layui-form" >
            <div class="layui-form-item">
                <label class="layui-form-label">学号</label>
                <div class="layui-input-block">
                    <input type="text" name="id" required  lay-verify="required" placeholder="请输入学号" autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">姓名</label>
                <div class="layui-input-block">
                    <input type="text" name="username" required  lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">身份证号码</label>
                <div class="layui-input-block">
                    <input type="text" name="experience" required  lay-verify="required" placeholder="请输入身份证号码" autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">年级</label>
                <div class="layui-input-block">
                    <select name="score" lay-verify="required">
                        <option value="2018">2018</option>
                        <option value="2019">2019</option>
                        <option value="2020">2020</option>
                        <option value="2021">2021</option>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">班级</label>
                <div class="layui-input-block">
                    <input type="text" name="classify" required  lay-verify="required" placeholder="请输入班级" autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">班主任</label>
                <div class="layui-input-block">
                    <input type="text" name="TeacherName" required  lay-verify="required" value=" ${teacher.getName()}" disabled="disabled"  autocomplete="off" class="layui-input">
                </div>
            </div>



            <div class="layui-form-item">
                <label class="layui-form-label">性别</label>
                <div class="layui-input-block">
                    <input type="radio" name="sex" value="男" title="男">
                    <input type="radio" name="sex" value="女" title="女" checked>
                </div>
            </div>


            <div class="layui-form">
                <div class="layui-form-item" id="area-picker">
                    <div class="layui-form-label">地址</div>
                    <div class="layui-input-inline" style="width: 120px;">
                        <select name="province" class="province-selector">
                            <option value="">--选择省--</option>
                        </select>
                    </div>
                    <div class="layui-input-inline" style="width: 120px;">
                        <select name="city" class="city-selector">
                            <option value="">--选择市--</option>
                        </select>
                    </div>
                    <div class="layui-input-inline" style="width: 120px;">
                        <select name="county" class="county-selector">
                            <option value="">--选择区--</option>
                        </select>
                    </div>
                </div>
            </div>


            <div class="layui-form-item">
                <label class="layui-form-label">详细地址</label>
                <div class="layui-input-block">
                    <input type="text" name="xxadd" required  lay-verify="required" placeholder="请输入详细地址" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="formDemo">提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>

        </form>
    </div>


    <script>


        //配置插件目录
        layui.config({
            base: './mods/'
            , version: '1.0'
        });
        //一般直接写在一个js文件中
        layui.use(['layer', 'form', 'layarea'], function () {
            var layer = layui.layer
                , form = layui.form
                , layarea = layui.layarea;

            let obj1 = layarea.render({
                elem: '#area-picker',
                change: function (res) {
                    //选择结果
                    console.log(res.province);
                }
            });
        });


        layui.use('form', function(){
            var form = layui.form;

            //监听提交
            form.on('submit(formDemo)', function(data){
                //layer.msg(JSON.stringify(data.field));
                console.log(data.field)
                $.post("/AddStudentInfo",{
                    id:data.field.id,
                    username:data.field.username,
                    experience:data.field.experience,
                    score:data.field.score,
                    classify:data.field.classify,
                    sex:data.field.sex,
                    TeacherName:data.field.TeacherName,
                    province:data.field.province,
                    city:data.field.city,
                    county:data.field.county,
                    xxadd:data.field.xxadd,
                },function(data,status){
                    if(status=="success"){
                        layer.msg('添加成功！');
                    }else{
                        layer.msg('添加失败！');
                    }

                });
                return false;
            });
        });


    </script>
</body>
</html>
