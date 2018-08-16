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
    <title>图书类型</title>
    <link rel="stylesheet" href="/frame/layui/css/layui.css">
    <link rel="stylesheet" href="/frame/static/css/style.css">
    <link rel="icon" href="/frame/static/image/code.png">
</head>

<body class="body">


<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>全部类型</legend>
</fieldset>
<div class="my-btn-box" style="width: 1100px">
    <span class="fl">
        <a href="/type/toNew" class="layui-btn mgl-20" id="btn-delete-all">添加</a>
         <a href="/type/export" class="layui-btn mgl-20" id="">导出</a>

    </span>

</div>
<table class="layui-table" style="width: 1100px">
    <colgroup>
        <col width="100">
        <col width="200">
        <col width="500">
        <col width="100">
    </colgroup>
    <thead>
    <tr>
        <th>编号</th>
        <th>图书类型</th>
        <th>位置</th>
        <th>数目</th>
        <th class="actions">操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="type" varStatus="status">
        <tr >
            <td><a> ${status.count}</a></td>
            <td><a href="">${type.name}</a></td>
            <td>${type.place}</td>
            <td>${type.bookNum}</td>
            <td class="actions">
                <a href="/type/toUpdate/${type.id}">
                <button class="layui-btn layui-btn-primary layui-btn-small">修改</button></a>
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
