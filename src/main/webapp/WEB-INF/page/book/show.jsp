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
    <label class="layui-form-label">图书编号</label>
    <div class="layui-input-block">
        <input type="text" value="${bookTypeVo.bookId}" disabled="disabled" lay-verify="required" autocomplete="off" class="layui-input">
    </div>
</div>
    <div class="layui-form-item">
        <label class="layui-form-label">图书名称</label>
        <div class="layui-input-block">
            <input type="text" value="${bookTypeVo.bookName}" disabled="disabled" lay-verify="required" autocomplete="off" class="layui-input">
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
            <input type="radio" checked="checked" name="status"  value="" title="在馆" ></c:if>
            <c:if test="${bookTypeVo.bookStatus==2}">
            <input type="radio"checked="checked" name="status" title="借出" >
            </c:if>

        </div>
    </div>


    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">图书简介</label>
        <div class="layui-input-block">
            <textarea class="layui-textarea layui-hide" disabled="disabled"  name="info" lay-verify="content" id="LAY_demo_editor">${bookTypeVo.bookInfo}</textarea>
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

            <a href="/borrow/toNew/${bookTypeVo.bookId}">
                <button class="layui-btn layui-btn-primary layui-btn-small">借书</button>
            </a>


        </div>
    </div>



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
    });
</script>
</body>
</html>