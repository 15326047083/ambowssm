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
    <title>借阅列表</title>
    <link rel="stylesheet" href="../frame/layui/css/layui.css">
    <link rel="stylesheet" href="../frame/static/css/style.css">
    <link rel="icon" href="../frame/static/image/code.png">
</head>
<body class="body">


<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>借阅列表</legend>
</fieldset>
<div class="my-btn-box" style="width: 1100px">
    <span class="fl">
        <a class="layui-btn mgl-20" id="btn-delete-all" onclick="sendMessage()">一键提醒即将逾期用户</a>
        <script>
            function sendMessage() {
                $.ajax({
                    url: "/borrow/sendMessage",
                    type: "get",
                    dataType: "json",
                    success(data) {
                        alert("成功提醒" + data + "名用户！！！");
                    }
                });
            }
        </script>
 <a href="/borrow/export" class="layui-btn mgl-20" id="">导出</a>
    </span>
    <form action="/borrow/toLikeList">
    <span class="fr">
        <span class="layui-form-label">搜索条件：</span>
        <div class="layui-input-inline">
            <input type="text" name="mohu" autocomplete="off" placeholder="读者姓名/手机号/书名" class="layui-input">


        </div>
       借书日期：
        <div class="layui-input-inline">
            <input type="Date" name="borrowDate" autocomplete="off"  class="layui-input">


        </div>
        至
         <div class="layui-input-inline">
            <input type="Date" name="borrowSrdate" autocomplete="off"  class="layui-input">


        </div>
        <input type="submit" class="layui-btn mgl-20" value="查询"></input>
    </span>
    </form>
</div>
<table class="layui-table" style="width: 1100px">
    <colgroup>
        <col width="80">
        <col width="180">
        <col width="120">
        <col width="110">
    </colgroup>
    <thead>
    <tr>
        <th>编号</th>
        <th>图书名字</th>
        <th>用户姓名</th>
        <th>用户手机号</th>
        <th>借出日期</th>
        <th>应当归还日期</th>
        <th>借阅状态</th>
        <th class="actions">操作</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${list.rows}" var="borrow" varStatus="status">

        <tr>
            <td>${status.count}</td>
            <td>《${borrow.bookName}》</td>
            <td>${borrow.userName}</td>
            <td>${borrow.userPhone}</td>
            <td>${borrow.borrowDate}</td>
            <td>${borrow.borrowSrdate}</td>
            <c:if test="${borrow.borrowStatus==2}">
                <td style="color:red">借阅中</td>
            </c:if>
            <c:if test="${borrow.borrowStatus==3}">
                <td style="color:red ">逾期未还
                </td>
            </c:if>
            <c:if test="${borrow.borrowStatus==4}">
                <td style="color: green">逾期已还
                </td>
            </c:if>
            <c:if test="${borrow.borrowStatus==5}">
                <td style="color: green">按时归还
                </td>
            </c:if>
                <%----%>
            <td class="actions">
                    <%--  <a href="/borrow/updateBorrow?bookId=${borrow.bookId}"><button class="layui-btn layui-btn-primary layui-btn-small" >还书</button></a>--%>

            <c:choose>
                <c:when test="${borrow.borrowStatus==2}"><button onclick="updateBorrow('${borrow.borrowId}')"
                        class="layui-btn layui-btn-primary layui-btn-small">还书
                </button>
                </c:when>
                <c:when test="${borrow.borrowStatus==3}"><button onclick="updateBorrow('${borrow.borrowId}')"
                                                                 class="layui-btn layui-btn-primary layui-btn-small">还书
                </button>
                </c:when>
                <c:otherwise>
                        <a class="notice" href="#">
                        <button
                                class="layui-btn layui-btn-primary layui-btn-small">还书
                        </button></a>
                </c:otherwise>
            </c:choose>
            </td>
        </tr>

    </c:forEach>
    </tbody>
</table>
<div class="my-btn-box" style="width: 1100px">
    <c:if test="${chuanzhi=='cat'}">
    <span class="fr">
     <a href="/borrow/toList?page=1 && size=${list.size}">  <button class="layui-btn layui-btn-primary layui-btn-small">首页</button></a>

        <c:if test="${list.page>1}">

            <a href="/borrow/toList?page=${list.page-1}&&size=${list.size}">    <button
                    class="layui-btn layui-btn-primary layui-btn-small">上一页</button></a>
        </c:if>
      ${list.page}/${ye}
    <c:if test="${list.page<ye}">
        <a href="/borrow/toList?page=${list.page+1}&&size=${list.size}">  <button
                class="layui-btn layui-btn-primary layui-btn-small">下一页</button></a>

    </c:if>
       <a href="/borrow/toList?page=${ye}&& size=${list.size}"><button
               class="layui-btn layui-btn-primary layui-btn-small">尾页</button> </a>
    </span>
    </c:if>

    <c:if test="${chuanzhi=='dog'}">
    <span class="fr">
     <a href="/borrow/toLikeList?mohu=${mohu}&& page=1&&size=${list.size}&&borrowDate=${borrowDate}&&borrowSrdate=${borrowSrdate}">  <button
             class="layui-btn layui-btn-primary layui-btn-small">首页</button></a>

        <c:if test="${list.page>1}">

            <a href="/borrow/toLikeList?mohu=${mohu}&&page=${list.page-1}&&size=${list.size}&&borrowDate=${borrowDate}&&borrowSrdate=${borrowSrdate}">    <button
                    class="layui-btn layui-btn-primary layui-btn-small">上一页</button></a>
        </c:if>
      ${list.page}/${ye}
    <c:if test="${list.page<ye}">
        <a href="/borrow/toLikeList?mohu=${mohu}&&page=${list.page+1}&&size=${list.size}&&borrowDate=${borrowDate}&&borrowSrdate=${borrowSrdate}">  <button
                class="layui-btn layui-btn-primary layui-btn-small">下一页</button></a>

    </c:if>
       <a href="/borrow/toLikeList?mohu=${mohu}&&page=${ye}&&size=${list.size}&&borrowDate=${borrowDate}&&borrowSrdate=${borrowSrdate}"><button
               class="layui-btn layui-btn-primary layui-btn-small">尾页</button> </a>
    </span>
    </c:if>
</div>

<script type="text/javascript" src="../frame/layui/layui.js"></script>
<script src="/js/jquery-1.11.3.min.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="/js/bootstrap.min.js"></script>
<!-- Metis Menu Plugin JavaScript -->
<script src="/js/metisMenu.min.js"></script>
<!-- DataTables JavaScript -->
<script src="/js/jquery.dataTables.min.js"></script>
<script src="/js/dataTables.bootstrap.min.js"></script>
<!-- Custom Theme JavaScript -->
<script src="/js/sb-admin-2.js"></script>
<script src="/js/jquery.growl.js" type="text/javascript"></script>
<link href="/stylesheets/jquery.growl.css" rel="stylesheet" type="text/css" />
<script>
    ${flag}
</script>
<script type="text/javascript">
    function updateBorrow(borrowId) {

        if (confirm('确定要归还此书吗?')) {
            $.post("/borrow/updateBorrow", {"borrowId": borrowId},
                function (data) {
                    if (data == "OK") {
                        alert("还书成功！");
                        window.location.reload();
                    }
                    if (data == "false") {
                        alert("你已经逾期还书！");
                        window.location.reload();
                    }
                    if (data == "error") {
                        alert("该书已经归还！");
                        window.location.reload();
                    }
                });
        }
    }

    $('.notice').click(function(event) {
        event.preventDefault();
        event.stopPropagation();
        return $.growl.notice({
            title: "提醒标题",
            message: "该书已经归还!"
        });
    });
</script>
</body>
</html>
