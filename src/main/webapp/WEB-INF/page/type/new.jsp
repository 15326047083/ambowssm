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
    <title>新增类型</title>
    <link rel="stylesheet" href="/frame/layui/css/layui.css">
    <link rel="stylesheet" href="/frame/static/css/style.css">
    <link rel="icon" href="/frame/static/image/code.png">
    <script type="text/javascript" src="/frame/jquery-3.3.1.js"></script>
</head>
<body class="body">


<blockquote class="layui-elem-quote layui-text">
    为书籍加一个分类吧，让读者们能更快的找到他^-^
</blockquote>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>图书分类</legend>
</fieldset>

<form class="" action="/type/new">

    <div class="layui-form-item">
        <label class="layui-form-label">分类名称</label>
        <div class="layui-input-block">
            <input onkeyup="checkType(this.value)" required type="text" id="name" name="name" lay-verify="required"
                   placeholder="请输入分类名称" autocomplete="off" class="layui-input">
            <span id="errorMsg" style="color: red"></span>
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">分类位置</label>
        <div class="layui-input-block">
            <textarea placeholder="请输入分类的位置" class="layui-textarea" name="place"></textarea>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">

            <input type="submit" value="提交" onclick="return submitType()" class="layui-btn">
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
<script src="../frame/layui/layui.js" charset="utf-8"></script>
</body>
</html>
<script>
    var bj = 0;

    function checkType(name) {
        //发ajax请求到后台判断用户名是否重复
        $.ajax({
            url: "/type/checkname/" + name,
            data: {name: name},
            dataType: "json",
            error() {
            },
            success(json) {
                if (json == 0) {
                    $("#errorMsg").html("可以注册");
                    bj = 0;
                }
                else {
                    $("#errorMsg").html("该名字已经存在");
                    bj = 1;
                }
            }
        });
    }

    function submitType() {
        if (bj == 0)
            return true;
        return false;
    }
</script>
