<%--
  Created by IntelliJ IDEA.
  User: leiyuan
  Date: 2018/8/15
  Time: 上午10:03
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
    <title>读者管理</title>
    <link rel="stylesheet" href="../frame/layui/css/layui.css">
    <link rel="stylesheet" href="../frame/static/css/style.css">
    <link rel="icon" href="../frame/static/image/code.png">
</head>
<body>
<body class="body">


<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>全部读者</legend>
</fieldset>
<div class="my-btn-box" style="width: 1100px">
    <span class="fl">
        <a class="layui-btn mgl-20" id="btn-delete-all" href="/toInsertUser.action">添加</a>
    </span>
    <span class="fl"  style="float: right">
        <a class="layui-btn mgl-20" id="btn-delete-all2" href="/selectAllByBorrowNum.action">借书排行查询</a>
    </span>
    <span class="fr">
        <span class="layui-form-label">搜索条件：</span>
        <div class="layui-input-inline">
            <input type="text" autocomplete="off" placeholder="请输入搜索条件" class="layui-input">
        </div>
        <button class="layui-btn mgl-20">查询</button>
    </span>
</div>
<table class="layui-table" style="width: 1100px">
    <colgroup>
        <col width="100">
        <col width="100">
        <col width="100">
        <col width="100">
        <col width="100">
        <col width="100">
        <col width="100">
        <col width="100">
        <col width="100">
        <col width="100">
        <col width="200">
    </colgroup>
    <thead>
    <tr>
        <th>读者编号</th>
        <th>读者姓名</th>
        <th>读者性别</th>
        <th>读者年龄</th>
        <th>读者电话</th>
        <th>注册时间</th>
        <th>注销时间</th>
        <th>读者地址</th>
        <th>借阅次数</th>
        <th>读者密码</th>
        <th class="actions">操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${userList}" var="ul">
        <tr >
            <td>${ul.id}</td>
            <td>${ul.name}</td>
            <td>${ul.sex}</td>
            <td>${ul.age}</td>
            <td>${ul.phone}</td>
            <td>${ul.newDate}</td>
            <td>${ul.outDate}</td>
            <td>${ul.place}</td>
            <td>${ul.borrowNum}</td>
            <td>${ul.password}</td>
            <td class="actions">
                <a class="layui-btn layui-btn-primary layui-btn-small" href="/toUpdateUser.action?id=${ul.id}">修改</a>
                <a class="layui-btn layui-btn-primary layui-btn-small" href="/deleteUser.action?id=${ul.id}">删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="my-btn-box" style="width: 1100px">

    <span class="fr">
     <button class="layui-btn layui-btn-primary layui-btn-small">首页</button>
      <button class="layui-btn layui-btn-primary layui-btn-small">上一页</button>
      1/5
        <button class="layui-btn layui-btn-primary layui-btn-small">下一页</button>
        <button class="layui-btn layui-btn-primary layui-btn-small">尾页</button>
    </span>
</div>
<%----%>
<script type="text/javascript" src="../frame/layui/layui.js"></script>
<script type="text/javascript">
    // you code ...
</script>
</body>
</html>
