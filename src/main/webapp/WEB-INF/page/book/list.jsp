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
    <link rel="stylesheet" href="../frame/layui/css/layui.css">
    <link rel="stylesheet" href="../frame/static/css/style.css">
    <link rel="icon" href="../frame/static/image/code.png">
</head>
<body>
<body class="body">


<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>全部类型</legend>
</fieldset>
<span class="fr">
        <span class="layui-form-label">搜索条件：</span>
        <div class="layui-input-inline">
            <input type="text" autocomplete="off" placeholder="请输入搜索条件" class="layui-input">
        </div>
        <button class="layui-btn mgl-20">查询</button>
    </span>

<span class="fr">
        <span class="layui-form-label">搜索类型：</span>
        <div class="layui-input-inline">
            <input type="text" autocomplete="off" placeholder="请输入类型条件" class="layui-input">
        </div>
        <button class="layui-btn mgl-20">查询</button>
    </span>


<div class="my-btn-box" style="width: 1100px">
    <span class="fl">
     <a href="/book/toNew" class="layui-btn mgl-20" id="btn-delete-all">添加</a>

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
        <th>书架编号</th>
        <th>书架名称</th>
        <th>书架位置</th>
        <th>数目</th>
        <th>图书编号</th>
        <th>图书名称</th>
        <th>图书作者</th>
        <th>出版社</th>
        <th>出版日期</th>
        <th>图书简介</th>
        <th>图书状态</th>
        <th>借出次数</th>
        <th>图书备注</th>



        <th class="actions">操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list.rows}" var="type" varStatus="status">
        <tr >
            <td>${status.count}</td>
            <td>${type.typeId}</td>
            <td>${type.typeName}</td>
            <td>${type.typePlace}</td>
            <td>${type.bookNum}</td>
            <td>${type.bookId}</td>
            <td>${type.bookName}</td>
            <td>${type.bookAuthorName}</td>
            <td>${type.bookPress}</td>
            <td>${type.bookPublishDate}</td>
            <td>${type.bookInfo}</td>

            <c:if test="${type.bookStatus==1}">
            <td>在馆</td></c:if>
            <c:if test="${type.bookStatus==2}">
                <td>借出</td></c:if>


           <%-- <td>${type.bookStatus}</td>--%>
            <td>${type.bookBorrowNum}</td>
            <td>${type.bookRemark}</td>
            <td class="actions">
                <a href="/book/toUpdate"><button class="layui-btn layui-btn-primary layui-btn-small">修改</button></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="my-btn-box" style="width: 1100px">

    <span class="fr">
        <a href="/book/listVo?page=1 && size=${list.size}">  <button class="layui-btn layui-btn-primary layui-btn-small">首页</button></a>

        <c:if test="${list.page>1}">
        
        <a href="/book/listVo?page=${list.page-1}&&size=${list.size}">    <button class="layui-btn layui-btn-primary layui-btn-small">上一页</button></a>
        </c:if>
      ${list.page}/${ye}
    <c:if test="${list.page<ye}">
      <a href="/book/listVo?page=${list.page+1}&&size=${list.size}">  <button class="layui-btn layui-btn-primary layui-btn-small">下一页</button></a>

    </c:if>
       <a href="/book/listVo?page=${ye}&& size=${list.size}"><button class="layui-btn layui-btn-primary layui-btn-small">尾页</button> </a>
    </span>
</div
<%----%>
<script type="text/javascript" src="../frame/layui/layui.js"></script>
<script type="text/javascript">
    // you code ...
</script>
</body>
</html>
