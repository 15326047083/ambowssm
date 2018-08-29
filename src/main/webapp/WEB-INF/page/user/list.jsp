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
    <%--添加bootstarp CSS样式文件--%>
    <link href="/bootstrap/twitter-bootstrap-v2/docs/assets/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/bootstrap/twitter-bootstrap-v2/docs/assets/css/bootstrapValidator.min.css"/>

    <script type="text/javascript" src="/bootstrap/twitter-bootstrap-v2/js/jquery-3.3.1.js"></script>
    <script src="/bootstrap/twitter-bootstrap-v2/js/bootstrap.min.js"></script>
    <%--带众多默认验证规则的--%>
    <script type="text/javascript" src="/bootstrap/twitter-bootstrap-v2/js/bootstrapValidator.js"></script>
    <%--需要自定义规则--%>
    <script type="text/javascript" src="/bootstrap/twitter-bootstrap-v2/js/bootstrapValidator.min.js"></script>
</head>
<body class="body">
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>读者列表</legend>
</fieldset>
<div class="my-btn-box" style="width: 1100px">
    <span class="fl">

<c:if test="${admin!=null}">
        <a class="layui-btn mgl-20" id="btn-delete-all" data-toggle="modal" data-target="#newModal"
           onclick="clearUser()">添加</a>
    <a href="/user/export" class="layui-btn mgl-20">导出</a>
</c:if>
         <a href="/user/selectAllByBorrowNum" class="layui-btn mgl-20">刷新</a>
    </span>
    <span class="fr">
        <form method="post" action="/user/likeSelect">
             <span class="layui-form-label" style="width: 100px">搜索条件</span>
           <div class="layui-input-inline">
               <input type="text" name="selectKey" value="" placeholder="用户名，地址，手机号" class="layui-input">
           </div>
               <input name="" type="submit" value="查询" class="layui-btn mgl-20">
        </form>
    </span>
</div>
<table class="layui-table" style="width: 1100px">
    <colgroup>
        <col width="70">
        <col width="100">
        <col width="70">
        <col width="70">
        <col width="100">
        <col width="145">
        <col width="145">
        <col width="200">
        <col width="100">
        <col width="100">
        <col width="100">
    </colgroup>
    <thead>
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <c:if test="${admin!=null}">
            <th>电话</th>
            <th>注册时间</th>
            <th>注销时间</th>
            <th>地址</th>
        </c:if>
        <th>借阅次数</th>
        <c:if test="${admin!=null}">
            <th class="actions">操作</th>
        </c:if>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${userList}" var="ul" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${ul.name}</td>
            <td>${ul.sex}</td>
            <td>${ul.age}</td>
            <c:if test="${admin!=null}">
                <td>${ul.phone}</td>
                <td>${ul.newDate}</td>
                <td>${ul.outDate}</td>
                <td>${ul.place}</td>
            </c:if>
            <td>${ul.borrowNum}</td>
            <c:if test="${admin!=null}">
                <td class="actions">
                    <a class="layui-btn layui-btn-primary layui-btn-small" data-toggle="modal"
                       data-target="#updateModal"
                       onclick="toUpdateUser('${ul.id}')">修改</a>
                </td>
            </c:if>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="my-btn-box" style="width: 1100px">

    <c:if test="${tiao==1}">
    <span class="fr">
        <span>${pageUtil.pageIndex}</span>/<span>${pageUtil.pageCount}</span>
        <a href="/user/selectAll?pageIndex=1" class="layui-btn layui-btn-primary layui-btn-small">首页</a>
        <a href="/user/selectAll?pageIndex=${pageUtil.pageIndex>1?pageUtil.pageIndex-1:1}"
           class="layui-btn layui-btn-primary layui-btn-small">上一页</a>
        <a href="/user/selectAll?pageIndex=${pageUtil.pageIndex<pageUtil.pageCount?pageUtil.pageIndex+1:pageUtil.pageCount}"
           class="layui-btn layui-btn-primary layui-btn-small">下一页</a>
        <a href="/user/selectAll?pageIndex=${pageUtil.pageCount}"
           class="layui-btn layui-btn-primary layui-btn-small">尾页</a>
    </span>
    </c:if>

    <c:if test="${tiao==2}">
    <span class="fr">
        <span>${pageUtil.pageIndex}</span>/<span>${pageUtil.pageCount}</span>
        <a href="/user/selectAllByBorrowNum?pageIndex=1" class="layui-btn layui-btn-primary layui-btn-small">首页</a>
        <a href="/user/selectAllByBorrowNum?pageIndex=${pageUtil.pageIndex>1?pageUtil.pageIndex-1:1}"
           class="layui-btn layui-btn-primary layui-btn-small">上一页</a>
        <a href="/user/selectAllByBorrowNum?pageIndex=${pageUtil.pageIndex<pageUtil.pageCount?pageUtil.pageIndex+1:pageUtil.pageCount}"
           class="layui-btn layui-btn-primary layui-btn-small">下一页</a>
        <a href="/user/selectAllByBorrowNum?pageIndex=${pageUtil.pageCount}"
           class="layui-btn layui-btn-primary layui-btn-small">尾页</a>
    </span>
    </c:if>
    <c:if test="${tiao==3}">
    <span class="fr">
        <span>${pageUtil.pageIndex}</span>/<span>${pageUtil.pageCount}</span>
        <a href="/user/likeSelect?pageIndex=1&selectKey=${selectKey}"
           class="layui-btn layui-btn-primary layui-btn-small">首页</a>
        <a href="/user/likeSelect?pageIndex=${pageUtil.pageIndex>1?pageUtil.pageIndex-1:1}&selectKey=${selectKey}"
           class="layui-btn layui-btn-primary layui-btn-small">上一页</a>
        <a href="/user/likeSelect?pageIndex=${pageUtil.pageIndex<pageUtil.pageCount?pageUtil.pageIndex+1:pageUtil.pageCount}&selectKey=${selectKey}"
           class="layui-btn layui-btn-primary layui-btn-small">下一页</a>
        <a href="/user/likeSelect?pageIndex=${pageUtil.pageCount}&selectKey=${selectKey}"
           class="layui-btn layui-btn-primary layui-btn-small">尾页</a>
    </span>
    </c:if>

</div>


<c:if test="${admin!=null}">
    <%----新增读者--模态框----%>
    <div class="modal fade" id="newModal" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="static">
        <div class="modal-dialog">
            <div class="modal-content">
                    <%--<!--Modal-header-->--%>
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
                    <h4 class="modal-title" id="newUserModal">新增读者</h4>
                </div>
                    <%--Modal-boby--%>
                <div class="modal-body">
                    <form class="form-horizontal" id="newForm" name="newForm">
                        <div class="layui-form-item">
                            <label for="new_name" class="col-sm-2 control-label">读者姓名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" required="required" id="new_name"
                                       placeholder="读者姓名"
                                       name="name"/>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label for="new_sex" class="col-sm-2 control-label">读者性别</label>
                            <div class="col-sm-10">
                                <input type="radio" id="new_sex" name="sex" value="男" title="男" checked="">男
                                <input type="radio" name="sex" value="女" title="男">女
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label for="new_age" class="col-sm-2 control-label">读者年龄</label>
                            <div class="col-sm-10">
                                <input type="number" class="form-control" id="new_age" placeholder="读者年龄" name="age"/>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label for="new_place" class="col-sm-2 control-label">读者地址</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" required="required" id="new_place"
                                       placeholder="读者地址" name="place"/>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label for="new_phone" class="col-sm-2 control-label">读者电话</label>
                            <div class="col-sm-5">
                                <div style="float: left;">
                                    <input id="new_phone" type="text" class="form-control" style="width: 200px;"
                                           placeholder="读者电话" name="phone"/>
                                </div>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label for="new_phone" class="col-sm-2 control-label">验证码</label>
                            <div class="col-sm-10" style="width: 150px">
                                <input style="width: 180px" type="text" class="form-control" required="required" id="new_code"
                                       placeholder="请输入验证码" name="phone"/>

                            </div>
                            <div style="margin-left: 150px">
                                <button onclick="run(this)" id="phonecode" style="margin-left: 150px" type="button" class="btn btn-default" >点击发送验证码</button>
                            </div>
                        </div>

                      <%--  <div class="layui-form-item">
                            <label class="col-sm-2 control-label">验证码</label>
                            <div class="col-sm-10">
                                <input class="form-control" id="codename" placeholder="验证码">
                                <span id="codenameTip"></span>
                            </div>
                        </div>--%>
                            <%--<div class="layui-form-item">
                                <label for="new_phone" class="col-sm-2 control-label">读者电话</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" required="required" id="new_phone"
                                           placeholder="读者电话" name="phone"/>
                                </div>
                            </div>--%>
                      <%--  <div style="float: left;">
                            <input class="btn btn-info" type="button" id="getcode" value="点击获取手机验证码"/>
                            <span id="telephonenameTip"></span>
                        </div>--%>
                    </form>

                        <%--Modal-footer--%>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-info" id="newUser">新增</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <%----修改页面--模态框----%>
    <div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="static">
        <div class="modal-dialog">
            <div class="modal-content">
                    <%--<!--Modal-header-->--%>
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
                    <h4 class="modal-title" id="myModalLabel">修改读者信息</h4>
                </div>
                    <%--Modal-boby--%>
                <div class="modal-body">
                    <form class="form-horizontal" id="updateForm" name="updateForm">
                        <input type="hidden" id="update_id" name="id">
                        <div class="layui-form-item">
                            <label for="update_name" class="col-sm-2 control-label">读者姓名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="update_name" placeholder="读者姓名"
                                       name="name"/>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label for="update_sex" class="col-sm-2 control-label">读者性别</label>
                            <div class="col-sm-10">
                                <input type="hidden" id="update_sex">
                                <input type="radio" name="sex" value="男" title="男" checked="">男
                                <input type="radio" name="sex" value="女" title="女">女
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label for="update_age" class="col-sm-2 control-label">读者年龄</label>
                            <div class="col-sm-10">
                                <input type="number" class="form-control" id="update_age" placeholder="读者年龄"
                                       name="age"/>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label for="update_phone" class="col-sm-2 control-label">读者电话</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="update_phone" placeholder="读者电话"
                                       name="phone"/>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label for="update_place" class="col-sm-2 control-label">读者地址</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="update_place" placeholder="读者地址"
                                       name="place"/>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label for="upadte_password" class="col-sm-2 control-label">读者密码</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="upadte_password" placeholder="读者密码"
                                       name="password"/>
                            </div>
                        </div>
                    </form>

                        <%--Modal-footer--%>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-info" id="updateUser">保存修改</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

</c:if>

<script type="text/javascript" src="../frame/layui/layui.js"></script>

<script type="text/javascript">
    // you code ...


    //清空新建客户窗口中的数据
    function clearUser() {
        $("#new_name").val("");
        $("#new_age").val("");
        $("#new_phone").val("");
        $("#new_place").val("");
    }

    // 新增用户短信验证
    window.onload = function () {

        //短信验证码
        var InterValObj; //timer变量，控制时间
        var count = 60; //间隔函数，1秒执行
        var curCount;//当前剩余秒数
        var code = ""; //验证码
        var codeLength = 6;//验证码长度

        $("#getcode").click(function () {

            //获取输入的手机号码
            var phoNum = $("#new_phone").val();
            //alert(phoNum);
            curCount = count;

            //用正则表达式验证手机号是否合法
            //var re = /(^1[3|5|8][0-9]{9}$)/;
            //略
            // 产生随记验证码
            for (var i = 0; i < codeLength; i++) {
                code += parseInt(Math.random() * 9).toString();
            }

            // 设置按钮显示效果，倒计时
            $("#getcode").attr("disabled", "true");
            $("#getcode").val("请在" + curCount + "秒内输入验证码");
            InterValObj = window.setInterval(SetRemainTime, 1000); // 启动计时器，1秒执行一次

            // 向后台发送处理数据
            $.ajax({
                type: "POST", // 用POST方式传输
                dataType: "text", // 数据格式:JSON
                url: "/user/getCode", // 目标地址
                data: { "Code": code, "phoNum": phoNum },
                error: function (msg) {
                    alert(msg);
                },
                success: function (data) {
                    //前台给出提示语
                    if (data == "true") {
                        $("#telephonenameTip").html("<font color='#339933'>√ 短信验证码已发到您的手机,请查收(30分钟内有效)</font>");
                    } else if (data == "false") {
                        $("#telephonenameTip").html("<font color='red'>× 短信验证码发送失败，请重新发送</font>");
                        return false;
                    }
                }
            });

        });

        //timer处理函数
        function SetRemainTime() {
            if (curCount == 0) {
                window.clearInterval(InterValObj);// 停止计时器
                $("#getcode").removeAttr("disabled");// 启用按钮
                $("#getcode").val("重新发送验证码");
                code = ""; // 清除验证码。如果不清除，过时间后，输入收到的验证码依然有效
            } else {
                curCount--;
                $("#getcode").val("请在" + curCount + "秒内输入验证码");
            }
        }

       /* //提交注册按钮
        $("#submit").click(function () {
            var CheckCode = $("#codename").val();
            // 向后台发送处理数据
            $.ajax({
                url: "/Register/CheckCode",
                data: { "CheckCode": CheckCode },
                type: "POST",
                dataType: "text",
                success: function (data) {
                    if (data == "true") {
                        $("#codenameTip").html("<font color='#339933'>√</font>");
                    } else {
                        $("#codenameTip").html("<font color='red'>× 短信验证码有误，请核实后重新填写</font>");
                        return;
                    }
                }
            });
        });*/
    }

    // 通过id获取修改的客户信息
    function toUpdateUser(id) {
        $.ajax({
            type: "get",
            url: "/user/selectByPrimaryKey",
            data: {"id": id},
            success: function (data) {
                $("#update_id").val(data.id);
                $("#update_name").val(data.name);
                $("#update_sex").val(data.sex)
                $("#update_age").val(data.age)
                $("#update_phone").val(data.phone)
                $("#update_place").val(data.place);
                $("#upate_borrow_num").val(data.borrowNum);
                $("#upadte_password").val(data.password);
            }
        });
    }

    // 删除读者
    function deleteUser(id) {
        if (confirm("确定要删除吗？")) {
            $.post("/user/deleteUser", {"id": id},
                function (data) {
                    if (data == "OK") {
                        alert("读者删除成功！！！")
                        window.location.reload();
                    } else {
                        alert("读者删除失败！！！")
                        window.location.reload();
                    }
                });
        }
    }

    // 给新增读者模态框添加验证

    $('#newForm').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {        //提示图标
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {

            name: {
                message: 'The username is not valid',
                validators: {
                    notEmpty: {
                        message: 'The username is required and cannot be empty'
                    },
                    regexp: {           //正则校验
                        regexp: /([\u4e00-\u9fa5]{2,4})/,
                        message: 'The name must be more than two words in Chinese'
                    },
                }
            },
            age: {
                validators: {
                    notEmpty: {
                        message: 'The age is required and cannot be empty'
                    },
                    regexp: {           //正则校验
                        regexp: /^(?:[1-9][0-9]?|1[01][0-9]|120)$/,
                        message: 'The age must be between 1 and 120'
                    },
                }
            },
            phone: {
                validators: {
                    notEmpty: {
                        message: 'The phone is required and cannot be empty'
                    },
                    remote: {
                        url: '/user/checkPhone',
                        message: 'The phone already exists. Please re-enter!',
                        type: 'POST',
                    },
                    regexp: {           //正则校验
                        regexp: /(^1[3|5|8][0-9]{9}$)/,
                        message: 'The phone must be rightful!!!'
                    },
                }
            },
            place: {
                validators: {
                    notEmpty: {
                        message: 'The place is required and cannot be empty'
                    },
                    regexp: {           //正则校验
                        regexp: /([\u4e00-\u9fa5]{2,4})/,
                        message: 'The place must be more than two words in Chinese'
                    },
                }
            },
        }
    });

    $("#newUser").click(function () {//非submit按钮点击后进行验证，如果是submit则无需此句直接验证
        $("#newForm").bootstrapValidator('validate');//提交验证
        if ($("#newForm").data('bootstrapValidator').isValid()) {//获取验证结果，如果成功，执行下面代码
            // 创建客户
            $.post("/user/insertUser",
                $("#newForm").serialize(),
                function (data) {
                    if (data == "OK") {
                        alert("读者创建成功！");
                        window.location.reload();
                    } else {
                        alert("读者创建失败！");
                        window.location.reload();
                    }
                });
        }
    });


    // 修改读者模态框添加验证

    $('#updateForm').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {        //提示图标
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            name: {
                message: 'The username is not valid',
                validators: {
                    notEmpty: {
                        message: 'The username is required and cannot be empty'
                    },
                    /*  stringLength: {     //输入　长度限制　　校验
                          min: 6,
                          max: 30,
                          message: 'The username must be more than 6 and less than 30 characters long'
                      },*/
                    regexp: {           //正则校验
                        regexp: /([\u4e00-\u9fa5]{2,4})/,
                        message: 'The name must be more than two words in Chinese'
                    },
                }
            },
            age: {
                validators: {
                    notEmpty: {
                        message: 'The age is required and cannot be empty'
                    },
                    regexp: {           //正则校验
                        regexp: /^(?:[1-9][0-9]?|1[01][0-9]|120)$/,
                        message: 'The age must be between 1 and 120'
                    },
                }
            },
            phone: {
                validators: {
                    notEmpty: {
                        message: 'The phone is required and cannot be empty'
                    },
                    remote: {
                        url: '/user/checkUpdatePhone',
                        data: {                                     // 给后台传递phone，id值
                            phone: function () {
                                return $('#update_phone').val()
                            },
                            id: function () {
                                return $('#update_id').val()
                            }
                        },
                        message: 'The phone already exists. Please re-enter!',
                        type: 'POST',
                    },
                    regexp: {           //正则校验
                        regexp: /^[1][3,4,5,7,8][0-9]{9}$/,
                        message: 'The phone must be valid'
                    },
                }
            },
            place: {
                validators: {
                    notEmpty: {
                        message: 'The place is required and cannot be empty'
                    },
                    regexp: {           //正则校验
                        regexp: /([\u4e00-\u9fa5]{2,4})/,
                        message: 'The place must be more than two words in Chinese'
                    },
                }
            },
            borrowNum: {
                validators: {
                    notEmpty: {
                        message: 'The borrownum is required and cannot be empty'
                    },
                    stringLength: {
                        min: 1,
                        max: 9,
                        message: 'The borrownum is between 1 and 9 digits.'
                    },
                    regexp: {
                        regexp: /^[1-9]\d*$/,
                        message: 'The borrownum is a positive integer.'
                    },
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: 'The borrownum is required and cannot be empty'
                    },
                    regexp: {
                        regexp: /^\d{6}$/,
                        message: 'Please enter the 6 bit password.'
                    },
                }
            },
        }
    });

    $("#updateUser").click(function () {//非submit按钮点击后进行验证，如果是submit则无需此句直接验证
        $("#updateForm").bootstrapValidator('validate');//提交验证
        if ($("#updateForm").data('bootstrapValidator').isValid()) {//获取验证结果，如果成功，执行下面代码
            // 执行修改客户操作
            $.post("/user/updateUser",
                $("#updateForm").serialize(),
                function (data) {
                    if (data == "OK") {
                        alert("读者信息更新成功！");
                        window.location.reload();
                    } else {
                        alert("读者信息更新失败！");
                        window.location.reload();
                    }
                });
        }
    });

</script>

</body>
</html>
