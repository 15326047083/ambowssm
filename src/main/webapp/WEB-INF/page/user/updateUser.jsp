<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/16
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>修改读者信息</title>
    <link rel="stylesheet" href="../frame/layui/css/layui.css">
    <link rel="stylesheet" href="../frame/static/css/style.css">
    <link rel="icon" href="../frame/static/image/code.png">
</head>
<body class="body">


<blockquote class="layui-elem-quote layui-text">
    修改读者信息吧。。。
</blockquote>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>信息修改</legend>
</fieldset>

<form class="layui-form" action="/user/updateUser" method="post">
    <input type="hidden" name="id" value="${userList.id}">
    <div class="layui-form-item">
        <label class="layui-form-label">读者姓名</label>
        <div class="layui-input-block">
            <input type="text" name="name" lay-verify="required" placeholder="请输入书名" autocomplete="off" class="layui-input"  value="${userList.name}">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">性别</label>
        <div class="layui-input-block">
            <select name="sex" lay-filter="aihao">
                <option value="0">男</option>
                <option value="1">女</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">读者年龄</label>
        <div class="layui-input-block">
            <input type="text" id="age" name="age" lay-verify="required" autocomplete="off"
                  onblur="checkAge()" class="layui-input"  value="${userList.age}">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">读者电话</label>
        <div class="layui-input-block">
            <input type="text" name="phone" lay-verify="required" autocomplete="off" class="layui-input" value="${userList.phone}"
                   id="phone" onblur="checkPhone()">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">注册时间</label>
        <div class="layui-input-block">
            <input type="text" name="newDate" lay-verify="required" autocomplete="off" class="layui-input" value="${userList.newDate}">
        </div>
    </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">读者地址</label>
        <div class="layui-input-block">
            <input type="text" name="place" lay-verify="required" autocomplete="off" class="layui-input"  value="${userList.place}">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">借阅次数</label>
        <div class="layui-input-block">
            <input type="text" name="borrowNum" lay-verify="required" autocomplete="off" class="layui-input"  value="${userList.borrowNum}">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">读者密码</label>
        <div class="layui-input-block">
            <input type="text" name="password" lay-verify="required"  autocomplete="off" class="layui-input"  value="${userList.password}">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <input type="submit" class="layui-btn" lay-submit="" lay-filter="demo1" value="确定修改" onclick="return submitUpdateUser()">
            <input type="reset" class="layui-btn layui-btn-primary" value="重置">
        </div>
    </div>
    <script>
        function submitUpdateUser() {
            if (document.getElementById("phone").value.length!=11){
                document.getElementById("phone").style.color="red"
                return false;
            }else if (document.getElementById("phone").value.length==11&&document.getElementById("phone").style.color=="black"){
                return true
            }
            else if (document.getElementById("phone").style.color=="red")
                return false;
            return true;
        }
    </script>
</form>


<script src="../frame/layui/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form', 'layedit', 'laydate'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate;

        //日期
        laydate.render({
            elem: '#date'
        });
        laydate.render({
            elem: '#date1'
        });

        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');

        //自定义验证规则
        form.verify({
            title: function(value){
                if(value.length < 5){
                    return '标题至少得5个字符啊';
                }
            }
            ,pass: [/(.+){6,12}$/, '密码必须6到12位']
            ,content: function(value){
                layedit.sync(editIndex);
            }
        });

        //监听指定开关
        form.on('switch(switchTest)', function(data){
            layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
                offset: '6px'
            });
            layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
        });

        //监听提交
        // form.on('submit(demo1)', function(data){
        //     layer.alert(JSON.stringify(data.field), {
        //         title: '最终的提交信息'
        //     });
        //     return false;
        // });
    });
</script>

<script src="../frame/jquery-3.3.1.js"></script>
<script>
    function checkAge() {
        var val=document.getElementById("age").value;
        reg=/^[-+]?\d*$/;
        if(!reg.test(val)){
            alert('对不起，您输入的是字符,请输入5到120之间的数字');
            document.getElementById("id").value='';
        }
        if(val>parseInt("120")||val<5){
            alert('对不起，您输入的年龄不在范围,请输入5到120之间的数字');
            document.getElementById("age").value='';
        }
    }
</script>
<script src="../frame/jquery-3.3.1.js"></script>
<script>
    function checkPhone() {
        var phone = document.getElementById("phone").value;
        var partten = /^((\(\d{3}\))|(\d{3}\-))?13[0-9]\d{8}|15[0-9]\d{8}|189\d{8}$/;
        if(!partten.test(phone)){
            document.getElementById("phone").style.color="red";
            return false;
        }else{
            document.getElementById("phone").style.color="black";
        }
    }
</script>
</body>
</html>