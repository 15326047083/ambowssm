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
</head>
<body>
<div style="width: 300px;height: 300px;border-color: red;overflow: scroll;" id="chat">
    <span style="float: left;">我叫小i机器人，很乐意为您服务。</span><br/>
</div>
<div style="width: 300px;height:300px;border-color: red;">
    <input style="width: 200px; height: 60px;" id="question"/>
    <button style="height: 60px;width: 90px; " onclick="getReply()">发送</button>
</div>

<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

<script>
    function getReply() {
        var question = document.getElementById("question");
        var div = document.getElementById("chat");
        var span = document.createElement("span");
        span.style.cssFloat = "right";
        span.style.textAlign = "right";
        span.style.width = "500px";
        span.innerHTML = question.value;
        div.appendChild(span);
        var br = document.createElement("br");
        div.appendChild(br);
        $.ajax({
            url: "ai",
            type: "get",
            data: {"question": question.value},
            dataType: "json",
            success(data) {
                var replySpan = document.createElement("span");
                replySpan.style.cssFloat = "left";
                replySpan.style.textAlign = "left";
                replySpan.style.width = "500px";
                replySpan.innerHTML = data.result.content;
                div.appendChild(replySpan);
                var br = document.createElement("br");
                div.appendChild(br);
                question.value = "";
            }
        });
    }
</script>
</body>
</html>
