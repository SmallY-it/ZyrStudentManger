var obj = JSON.parse(localStorage.getItem('objdate'));
//console.log(obj)
var sex=obj.sex
var city=obj.city
var souc=obj.score
$('input[name="id"]').val(obj.id);
$('input[name="sex"][value=sex]').attr("checked",true);
$("input[type='radio'][name='sex'][value='"+sex+"']").attr("checked",true);
//$(":radio[name='sex'][value='" + sex + "']").prop("checked", "checked");
$('select').find('option[value=souc]').attr('selected','selected')
$('input[name="username"]').val(obj.username);
$('input[name="experience"]').val(obj.experience);
$('select[name="score"]').val(obj.score);
$('input[name="classify"]').val(obj.classify);

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
            //console.log(res.province);
        }
    });
});


layui.use('form', function() {
    var form = layui.form;
//监听提交
    form.on('submit(formDemo)', function (data) {
        //layer.msg(JSON.stringify(data.field));
        //console.log(JSON.stringify(data.field))
        $.post("/UpdataServlet",{
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
                layer.msg('更新成功！');
            }else{
                layer.msg('更新失败！');
            }

        });
        return false;
    });
});

