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
    <title>表单</title>
    <link rel="stylesheet" href="../frame/layui/css/layui.css">
    <link rel="stylesheet" href="../frame/static/css/style.css">
    <link rel="icon" href="../frame/static/image/code.png">
    <link href="/bootstrap/twitter-bootstrap-v2/docs/assets/css/bootstrap.css" rel="stylesheet">
</head>
<body class="body">


<blockquote class="layui-elem-quote layui-text">
    尽情查看书籍吧。。。
</blockquote>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>图书查看</legend>
</fieldset>


    <div class="layui-form-item">
        <label class="layui-form-label">图书类型</label>
        <div class="layui-input-block">
            <input type="text" value="${bookTypeVo.typeName}" disabled="disabled" lay-verify="required"  autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">所属类型</label>
        <div class="layui-input-block">
            <input type="text" value="${bookTypeVo.typeName}" disabled="disabled" lay-verify="required" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">所在位置</label>
        <div class="layui-input-block">
            <input type="text" value="${bookTypeVo.typePlace}" disabled="disabled" lay-verify="required" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">图书名称</label>
        <div class="layui-input-block">
            <input type="text" value="《${bookTypeVo.bookName}》" disabled="disabled" lay-verify="required" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">图书作者</label>
        <div class="layui-input-block">
            <input type="text" name="authorName" value="${bookTypeVo.bookAuthorName}" disabled="disabled"  lay-verify="required"  autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">出版社</label>
        <div class="layui-input-block">
            <input type="text"  value="${bookTypeVo.bookPress}" disabled="disabled" name="press" lay-verify="required"  autocomplete="off" class="layui-input">
        </div>
    </div>
    </div>
   <div class="layui-form-item">
        <label class="layui-form-label">出版日期</label>
        <div class="layui-input-block">
            <input type="date" name="publishDate" value="${bookTypeVo.bookPublishDate}" disabled="disabled"  placeholder="请输入图书出版日期" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">图书状态</label>
        <div class="layui-input-block">

            <c:if test="${bookTypeVo.bookStatus==1}">
                <input type="text"  value="在馆" disabled="disabled" name="press" lay-verify="required"  autocomplete="off" class="layui-input">
            </c:if>
            <c:if test="${bookTypeVo.bookStatus==2}">
                <input type="text"  value="借出"  disabled="disabled" name="press" lay-verify="required"  autocomplete="off" class="layui-input">
            </c:if>

        </div>
    </div>
<div class="layui-form-item layui-form-text">
    <label class="layui-form-label">图书简介</label>
    <div class="layui-input-block">
        <textarea  disabled="disabled" class="layui-textarea"name="remark">${bookTypeVo.bookInfo}</textarea>

    </div>
</div>


    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-block">
            <textarea  disabled="disabled" class="layui-textarea"name="remark">${bookTypeVo.bookRemark}</textarea>
        </div>
    </div>


    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">

            <a href="/book/toUpdate?bookId=${bookTypeVo.bookId}">
                <button class="layui-btn layui-btn-primary layui-btn-small">修改</button>
            </a>

            <a href="/book/delete?bookId=${bookTypeVo.bookId}&&typeId=${bookTypeVo.typeId}">
                <button class="layui-btn layui-btn-primary layui-btn-small">删除</button>
            </a>

           <%-- <a href="/borrow/toNew/${bookTypeVo.bookId}">
                <button class="layui-btn layui-btn-primary layui-btn-small">
                借书</button>

                && /borrow/newBorrow/${bookTypeVo.bookId}
            </a>--%>
            <a data-toggle="modal" href="#example" onclick="bookId=${bookTypeVo.bookId}">

                <button class="layui-btn layui-btn-primary layui-btn-small">
                    借书</button>
            </a>


        </div>
    </div>


    <div id="example" class="modal hide fade in" style="display: none; ">
        <div class="modal-header">
            <a class="close" data-dismiss="modal">×</a>
            <h3>借书窗口</h3>
        </div>
        <div class="modal-body">
            <form  id="new_form" class="layui-form" action="/borrow/newBorrow/${bookTypeVo.bookId}">
                <div class="layui-form-item">
                    <label class="layui-form-label">用户手机号</label>
                    <div class="layui-input-block">
                        <input type="text" name="phone" lay-verify="required" id="phone" onkeyup="checkPhone(this.value)" placeholder="请输入您的手机号" autocomplete="off" class="layui-input">
                    </div>
                </div>


                <div class="layui-form-item">
                    <div class="layui-input-block">
                       <%-- <input type="submit" onclick="createBorrow('${bookTypeVo.bookId}')" class="layui-btn" lay-submit="" lay-filter="demo1"/>--%>
                        <input type="hidden" id="bookId" value="${bookTypeVo.bookId}"/>
                        <input type="submit"   class="layui-btn" lay-submit="" lay-filter="demo1" value="确认" onclick="return submitNewUser()" />
                    </div>
                </div>
                <script>
                    function checkPhone(phone) {
                        var partten = /^((\(\d{3}\))|(\d{3}\-))?13[0-9]\d{8}|15[0-9]\d{8}|189\d{8}$/;
                        if(!partten.test(phone)){
                            return false;
                        }else{
                            $.ajax({
                                type: "get",
                                url: "/borrow/checkPhone/" + phone,
                                success(data) {
                                    if (data == 1) {
                                        document.getElementById("phone").style.color = "red";
                                    } else {
                                        document.getElementById("phone").style.color = "black";
                                    }
                                }
                            });
                        }
                    }
                </script>
                <script>
                    function submitNewUser() {
                        if (document.getElementById("phone").value.length!=11){
                            document.getElementById("phone").style.color="red"
                            return false;
                        }else if (document.getElementById("phone").value.length==11&&document.getElementById("phone").style.color=="black"){
                            return true
                        }
                        else if (document.getElementById("phone").style.color=="red")
                            return false;
                        return true;
                    }
                </script>

            </form>
        </div>
        <div class="modal-footer">


            <a href="#" class="btn" data-dismiss="modal">Close</a>
        </div>
    </div>
    <script src="/bootstrap/twitter-bootstrap-v2/docs/assets/js/jquery.js"></script>
    <script src="/bootstrap/twitter-bootstrap-v2/js/bootstrap-modal.js"></script>

    <script src="/js/jquery-1.11.3.min.js"></script>
    <!-- Bootstrap Core JavaScript -->

    <!-- Metis Menu Plugin JavaScript -->
    <script src="/js/metisMenu.min.js"></script>
    <!-- DataTables JavaScript -->
    <script src="/js/jquery.dataTables.min.js"></script>
    <script src="/js/dataTables.bootstrap.min.js"></script>
    <!-- Custom Theme JavaScript -->
    <script src="/js/sb-admin-2.js"></script>

<script src="../frame/layui/layui.js" charset="utf-8"></script>

<script>
    layui.use(['form', 'layedit', 'laydate'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate;

        //日期
        laydate.render({
            elem: '#date'
        });
        laydate.render({
            elem: '#date1'
        });

        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');

        //自定义验证规则
        form.verify({
            title: function(value){
                if(value.length < 5){
                    return '标题至少得5个字符啊';
                }
            }
            ,pass: [/(.+){6,12}$/, '密码必须6到12位']
            ,content: function(value){
                layedit.sync(editIndex);
            }
        });

        //监听指定开关
        form.on('switch(switchTest)', function(data){
            layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
                offset: '6px'
            });
            layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
        });

        //监听提交
        // form.on('submit(demo1)', function(data){
        //     layer.alert(JSON.stringify(data.field), {
        //         title: '最终的提交信息'
        //     });
        //     return false;
        // });
   /* });*/
        /*$("form").blur(function () {
            alert("okokok");
            var bookId=$("#bookId").val();
            $.ajax({
                url:"borrow/newBorrow/"+ bookId,
                dataType: "json",
                error() {
                    alert("error");
                },
                success(json) {
                    alert("json="+json);
                    if (json=="OK"){
                        alert("借书成功");
                    }
                    else {
                        alert("你已经失信！");
                    }
                }
            })
        })*/
       // $.post("/borrow/newBorrow",{"bookId":bookId},

           /* $("#new_form").serialize(),function(data){
                if(data =="OK"){
                    alert("借书成功！");
                    window.location.reload();
                }
                if(data=="false"){
                    alert("你已经失信！");
                    window.location.reload();
                }
            });*/
    })



</script>

</body>
</html>