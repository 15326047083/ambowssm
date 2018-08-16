<%--
  Created by IntelliJ IDEA.
  User: leiyuan
  Date: 2018/8/16
  Time: 上午11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>人工智障</title>
    <style>
        .main {
            text-align: center; /*让div内部文字居中*/
            background-color: none;
            border-radius: 20px;
            width: 700px;
            height: 350px;
            margin: auto;
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
        }
    </style>
</head>
<body style="background: #fff url(frame/static/image/buxie.jpg) no-repeat center 0;">
<div class="main">
    <div style="width: 700px;height: 300px;border-color: red;overflow: scroll;" id="chat">
        <span style="float: left;">我叫小i机器人，很乐意为您服务。</span><br/>
    </div>
    <div style="width: 700px;height:300px;border-color: red;">
        <input style="width: 500px; height: 60px;" id="question" placeholder="请输入你的问题哟！"/>
        <button style="height: 60px;width: 190px; " onclick="getReply()">发送</button>
    </div>
</div>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

<script>
    <%-- 发送对话 --%>

    function getReply() {
        // 根据ID获取发送的对话
        var question = document.getElementById("question");
        // 根据ID获取div
        var div = document.getElementById("chat");
        // 创建span标签
        var span = document.createElement("span");
        // 设置span属性
        span.style.cssFloat = "right";
        span.style.textAlign = "right";
        span.style.width = "500px";
        // 设置span值
        span.innerHTML = question.value;
        // 将span添加至div
        div.appendChild(span);
        var br = document.createElement("br");
        div.appendChild(br);
        // ajax异步提交问题到后台
        $.ajax({
            // 链接
            url: "ai",
            // 提交方式
            type: "get",
            // 传递参数 question问题
            data: {"question": question.value},
            // 返回值类型为json
            dataType: "json",
            // 调用成功
            success(data) {
                // 添加回复到div
                var replySpan = document.createElement("span");
                replySpan.style.cssFloat = "left";
                replySpan.style.textAlign = "left";
                replySpan.style.width = "500px";
                replySpan.innerHTML = data.result.content;
                div.appendChild(replySpan);
                var br = document.createElement("br");
                div.appendChild(br);
                // 清空输入框
                question.value = "";
            }
        });
    }
</script>
</body>
</html>
