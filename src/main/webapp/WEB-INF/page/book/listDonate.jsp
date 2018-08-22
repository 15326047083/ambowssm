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
    <title>捐赠信息</title>
    <link rel="stylesheet" href="../frame/layui/css/layui.css">
    <link rel="stylesheet" href="../frame/static/css/style.css">
    <link rel="icon" href="../frame/static/image/code.png">
</head>
<body>
<body class="body">


<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>捐赠信息</legend>
</fieldset>



   <span class="fr">


    </span>


<table class="layui-table" style="width: 1100px">
    <colgroup>
        <col width="150">

        <col width="150">
        <col width="150">
        <col width="150">
        <col width="150">

    </colgroup>
    <thead>
    <tr>
        <th>编号</th>
        <th>图书名称</th>
        <th>捐赠人</th>
        <th>捐赠人联系方式</th>
        <th>捐赠时间</th>




    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list.rows}" var="donate" varStatus="status">
        <tr>
            <td>${status.count}</td>

            <td>${donate.bookName}</td>
            <td>${donate.userName}</td>
            <td>${donate.userPhone}</td>

            <td>${donate.donateTime}</td>

        </tr>
    </c:forEach>
    </tbody>





</table>
<div class="my-btn-box" style="width: 1100px">
    <c:if test="${root=='donate'}">
    <span class="fr">
        <a href="/dataAnalysis/getDonate?page=1 && size=${list.size}">  <button
                class="layui-btn layui-btn-primary layui-btn-small">首页</button></a>

        <c:if test="${list.page>1}">

            <a href="/dataAnalysis/getDonate?page=${list.page-1}&&size=${list.size}">    <button
                    class="layui-btn layui-btn-primary layui-btn-small">上一页</button></a>
        </c:if>
      ${list.page}/${ye}
    <c:if test="${list.page<ye}">
        <a href="/dataAnalysis/getDonate?page=${list.page+1}&&size=${list.size}">  <button
                class="layui-btn layui-btn-primary layui-btn-small">下一页</button></a>

    </c:if>
        <c:if test="${ye>0}">
       <a href="/dataAnalysis/getDonate?page=${ye}&& size=${list.size}"><button
               class="layui-btn layui-btn-primary layui-btn-small">尾页</button> </a>
        </c:if>
    </span>
    </c:if>








</div
<%----%>
<script type="text/javascript" src="../frame/layui/layui.js"></script>
<script type="text/javascript">
    // you code ...
</script>
</body>
</html>
