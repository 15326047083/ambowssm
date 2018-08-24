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
    <title>失信列表</title>
    <link rel="stylesheet" href="../frame/layui/css/layui.css">
    <link rel="stylesheet" href="../frame/static/css/style.css">
    <link rel="icon" href="../frame/static/image/code.png">
</head>
<body class="body">


<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>失信列表</legend>
</fieldset>
<div class="my-btn-box" style="width: 1100px">
    <span class="fl">

 <a href="/borrow/export" class="layui-btn mgl-20" id="">导出</a>
    </span>

</div>
<table class="layui-table" style="width: 1100px">
    <colgroup>
        <col width="80">
        <col width="180">
        <col width="120">
        <col width="100">
    </colgroup>
    <thead>
    <tr>
        <th>编号</th>
        <th>用户姓名</th>
        <th>用户手机号</th>
        <th>用户地址</th>
        <th>图书名字</th>
        <th>借出时间</th>
        <th>应当归还时间</th>






    </tr>
    </thead>
    <tbody>

    <c:forEach items="${list.rows}" var="lost" varStatus="status">

        <tr >
            <td>${status.count}</td>

            <td>${lost.userName}</td>
            <td>${lost.userPhone}</td>
            <td>${lost.userPlace}</td>
            <td>${lost.bookName}</td>
            <td>${lost.start}</td>
            <td>${lost.endDate}</td>





                <%----%>


    </c:forEach>
    </tbody>
</table>
<div class="my-btn-box" style="width: 1100px">

    <span class="fr">
     <a href="/lost/toLost?page=1 && size=${list.size}">  <button class="layui-btn layui-btn-primary layui-btn-small">首页</button></a>

        <c:if test="${list.page>1}">

            <a href="/lost/toLost?page=${list.page-1}&&size=${list.size}">    <button class="layui-btn layui-btn-primary layui-btn-small">上一页</button></a>
        </c:if>
      ${list.page}/${ye}
    <c:if test="${list.page<ye}">
        <a href="/lost/toLost?page=${list.page+1}&&size=${list.size}">  <button class="layui-btn layui-btn-primary layui-btn-small">下一页</button></a>

    </c:if>
       <a href="/lost/toLost?page=${ye}&& size=${list.size}"><button class="layui-btn layui-btn-primary layui-btn-small">尾页</button> </a>
    </span>



</div>

<script type="text/javascript" src="../frame/layui/layui.js"></script>
<script src="/js/jquery-1.11.3.min.js"></script>

<script type="text/javascript">

</script>
</body>
</html>
