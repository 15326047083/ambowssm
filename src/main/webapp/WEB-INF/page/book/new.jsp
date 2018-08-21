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
    尽情的添加书籍吧。。。
</blockquote>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>图书添加</legend>
</fieldset>

<form class="layui-form" action="/book/insert">
    <div class="layui-form-item">
        <label class="layui-form-label">图书类型</label>
        <div class="layui-input-block">
            <select name="typeId"  lay-filter="aihao" >
                <c:forEach items="${types}" var="types">
                    <option value="${types.id}">${types.name}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">图书名称</label>
        <div class="layui-input-block">
            <input type="text" name="bookName"  lay-verify="required" placeholder="请输入书名" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">图书作者</label>
        <div class="layui-input-block">
            <input type="text" name="authorName"   lay-verify="required" placeholder="请输入作者名字" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">出版社</label>
        <div class="layui-input-block">
            <input type="text" name="press" lay-verify="required" placeholder="请输入图书出版社" autocomplete="off" class="layui-input">
        </div>
    </div>
    </div>
   <div class="layui-form-item">
        <label class="layui-form-label">出版日期</label>
        <div class="layui-input-block">
            <input type="date" name="publishDate"  placeholder="请输入图书出版日期" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">图书状态</label>
        <div class="layui-input-block">
            <input type="radio" name="status" value="1" title="在馆" checked="">
            <input type="radio" name="status" value="2" title="借出" disabled="">

        </div>
    </div>


    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">图书简介</label>
        <div class="layui-input-block">
            <textarea class="layui-textarea layui-hide"  name="info" lay-verify="content" id="LAY_demo_editor"></textarea>
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-block">
            <textarea placeholder="请输入图为位置" class="layui-textarea"name="remark"></textarea>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">数量</label>
        <div class="layui-input-block">
            <input type="text" name="num" lay-verify="required" placeholder="请输入图书数量" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">捐赠人</label>
        <div class="layui-input-block">
            <input type="text" name="userName" lay-verify="required" placeholder="请输入捐赠人" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">联系方式</label>
        <div class="layui-input-block">
            <input type="text" name="userPhone" lay-verify="required" placeholder="请输入联系方式" autocomplete="off" class="layui-input">
        </div>
    </div>



    <div class="layui-form-item">
        <div class="layui-input-block">

            <input type="submit" value="提交" class="layui-btn"  lay-filter="demo1" >
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>

        </div>
    </div>
</form>


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