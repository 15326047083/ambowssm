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

<form action="/book/listVoBlurTypeId">
        <span class="layui-form-label">搜索条件：</span>

        <div class="layui-input-inline">
            <input type="text" name="blur" placeholder="输入书名/作者/出版社/简介" class="layui-input">
        </div>
        <div class="layui-input-inline">
         <select name="typeId"  autocomplete="off"  class="layui-input" >
             <option value="">请选择图书类型</option>
                <c:forEach items="${types}" var="types">
                    <option value="${types.id}">${types.name}</option>
                </c:forEach>
            </select>

        </div>
       <input type="submit" value="查询" class="layui-btn mgl-20" >
</form>
    </span>


<div class="my-btn-box" style="width: 1100px">
    <span class="fl">
     <a href="/book/toNew" class="layui-btn mgl-20" id="btn-delete-all">添加</a>
           <a href="/book/sort" class="layui-btn mgl-20" id="btn-delete-all">借阅排行</a>

    </span>

</div>


<div class="my-btn-box" style="width: 1100px">
    <span class="fl">


    </span>

</div>
<c:if test="${show=='duo'}">
<table class="layui-table" style="width: 1100px">
    <colgroup>
        <col width="150">
        <col width="150">
        <col width="150">
        <col width="150">
        <col width="150">
        <col width="150">
        <col width="150">
        <col width="150">
    </colgroup>
    <thead>
    <tr>
        <th>编号</th>

        <th>图书类型</th>
        <th>书架位置</th>


        <th>图书名称</th>
        <th>图书作者</th>

        <th>图书状态</th>
        <th>借出次数</th>


        <th class="actions">操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list.rows}" var="type" varStatus="status">
        <tr>
            <td>${status.count}</td>

            <td>${type.typeName}</td>
            <td>${type.typePlace}</td>

            <td>《${type.bookName}》</td>
            <td>${type.bookAuthorName}</td>




            <c:if test="${type.bookStatus==1}">
                <td>在馆</td>
            </c:if>
            <c:if test="${type.bookStatus==2}">
                <td><font color="red">借出</font></td>
            </c:if>


                <%-- <td>${type.bookStatus}</td>--%>
            <td>${type.bookBorrowNum}</td>

            <td class="actions">


                <a href="/book/get?bookId=${type.bookId} ">
                    <button class="layui-btn layui-btn-primary layui-btn-small">查看</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
    </c:if>




</table>
<div class="my-btn-box" style="width: 1100px">
    <c:if test="${root=='vo'}">
    <span class="fr">
        <a href="/book/listVo?page=1 && size=${list.size}">  <button
                class="layui-btn layui-btn-primary layui-btn-small">首页</button></a>

        <c:if test="${list.page>1}">

            <a href="/book/listVo?page=${list.page-1}&&size=${list.size}">    <button
                    class="layui-btn layui-btn-primary layui-btn-small">上一页</button></a>
        </c:if>
      ${list.page}/${ye}
    <c:if test="${list.page<ye}">
        <a href="/book/listVo?page=${list.page+1}&&size=${list.size}">  <button
                class="layui-btn layui-btn-primary layui-btn-small">下一页</button></a>

    </c:if>
        <c:if test="${ye>0}">
       <a href="/book/listVo?page=${ye}&& size=${list.size}"><button
               class="layui-btn layui-btn-primary layui-btn-small">尾页</button> </a>
        </c:if>
    </span>
    </c:if>




    <c:if test="${root=='typeBlur'}">
    <span class="fr">
        <a href="/book/listVoBlurTypeId?typeId=${typeId}&&blur=${blur}&&page=1 && size=${list.size}">  <button
                class="layui-btn layui-btn-primary layui-btn-small">首页</button></a>

        <c:if test="${list.page>1}">

            <a href="/book/listVoBlurTypeId?typeId=${typeId}&&blur=${blur}&&page=${list.page-1}&&size=${list.size}">    <button
                    class="layui-btn layui-btn-primary layui-btn-small">上一页</button></a>
        </c:if>
      ${list.page}/${ye}
    <c:if test="${list.page<ye}">
        <a href="/book/listVoBlurTypeId?typeId=${typeId}&&blur=${blur}&&page=${list.page+1}&&size=${list.size}">  <button
                class="layui-btn layui-btn-primary layui-btn-small">下一页</button></a>

    </c:if>
        <c:if test="${ye>0}">
       <a href="/book/listVoBlurTypeId?typeId=${typeId}&&blur=${blur}&&page=${ye}&&size=${list.size}"><button
               class="layui-btn layui-btn-primary layui-btn-small">尾页</button> </a>
        </c:if>
    </span>
    </c:if>


    <c:if test="${root=='sort'}">
    <span class="fr">
        <a href="/book/sort?page=1 && size=${list.size}">  <button
                class="layui-btn layui-btn-primary layui-btn-small">首页</button></a>

        <c:if test="${list.page>1}">

            <a href="/book/sort?page=${list.page-1}&&size=${list.size}">    <button
                    class="layui-btn layui-btn-primary layui-btn-small">上一页</button></a>
        </c:if>
      ${list.page}/${ye}
    <c:if test="${list.page<ye}">
        <a href="/book/sort?page=${list.page+1}&&size=${list.size}">  <button
                class="layui-btn layui-btn-primary layui-btn-small">下一页</button></a>

    </c:if>
        <c:if test="${ye>0}">
       <a href="/book/sort?page=${ye}&&size=${list.size}"><button
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
