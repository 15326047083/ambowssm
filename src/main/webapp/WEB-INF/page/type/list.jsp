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
    <meta charset="utf-8">
    <title>图书类型列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="http://fonts.googleapis.com/css?family=Oxygen|Marck+Script" rel="stylesheet" type="text/css">
    <link href="<%=request.getContextPath()%>/assets/css/bootstrap.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/assets/css/font-awesome.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/assets/css/admin.css" rel="stylesheet">

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

</head>
<body>

<div class="container">
    <div class="row">
        <!--left-->
        <%--<jsp:include page="<%=request.getContextPath()%>/left.jsp"/>--%>
        <div class="span10">
            <div class="main-area dashboard">
                <div class="row">
                    <div class="span10">
                        <div class="slate">
                            <form class="form-inline">
                                <input type="text" class="input-large" placeholder="Keyword...">
                                <select class="span2">
                                    <option value=""> - From Date - </option>
                                </select>
                                <select class="span2">
                                    <option value=""> - To Date - </option>
                                </select>
                                <select class="span2">
                                    <option value=""> - Filter - </option>
                                </select>
                                <button type="submit" class="btn btn-primary">查找</button>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="span10 listing-buttons">
                        <button class="btn btn-info">Action</button>
                        <button class="btn btn-success">Action</button>
                        <button class="btn btn-primary">添加</button>
                    </div>

                    <div class="span10">
                        <div class="slate">
                            <div class="page-header">
                                <div class="btn-group pull-right">
                                    <button class="btn dropdown-toggle" data-toggle="dropdown">
                                        <i class="icon-download-alt"></i> Export
                                        <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu">
                                        <li><a href="">Excel</a></li>
                                    </ul>
                                </div>
                                <h2>Listings</h2>
                            </div>

                            <table class="orders-table table">
                                <thead>
                                <tr>
                                    <th>图书类型</th>
                                    <th>位置</th>
                                    <th>数目</th>
                                    <th class="actions">Actions</th>
                                </tr>
                                </thead>
                                <tbody>
                        <c:forEach items="${list}" var="type">
                                <tr>
                                    <td><a href="">${type.name}</a></td>
                                    <td><a href="">${type.place}</a></td>
                                    <td><a href="">${type.bookNum}</a></td>
                                    <td class="actions">
                                        <a class="btn btn-small btn-danger" data-toggle="modal" href="#removeItem">修改</a>
                                        <a class="btn btn-small btn-primary" href="form.html">查看</a>
                                    </td>
                                </tr>
                        </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>

                    <div class="modal hide fade" id="removeItem">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">×</button>
                            <h3>Remove Item</h3>
                        </div>
                        <div class="modal-body">
                            <p>Are you sure you would like to remove this item?</p>
                        </div>
                        <div class="modal-footer">
                            <a href="#" class="btn" data-dismiss="modal">Close</a>
                            <a href="#" class="btn btn-danger">Remove</a>
                        </div>
                    </div>

                    <div class="span5">

                        <div class="pagination pull-left">
                            <ul>
                                <li><a href="#">Prev</a></li>
                                <li class="active">
                                    <a href="#">1</a>
                                </li>
                                <li><a href="#">2</a></li>
                                <li><a href="#">3</a></li>
                                <li><a href="#">4</a></li>
                                <li><a href="#">Next</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

        </div> <!-- end span10 -->
    </div> <!-- end row -->
</div> <!-- end container -->

<!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/bootstrap.js"></script>


</body>
</html>