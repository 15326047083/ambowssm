<%--
  Created by IntelliJ IDEA.
  User: leiyuan
  Date: 2018/8/15
  Time: 下午5:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>爱心书屋</title>
    <link rel="stylesheet" href="../../frame/layui/css/layui.css">
    <link rel="stylesheet" href="../../frame/static/css/style.css">
    <link rel="icon" href="../../frame/static/image/code.png">
</head>
<body>

<!-- layout admin -->
<div class="layui-layout layui-layout-admin"> <!-- 添加skin-1类可手动修改主题为纯白，添加skin-2类可手动修改主题为蓝白 -->
    <!-- header -->
    <div class="layui-header my-header">
        <a href="index.html">
            <!--<img class="my-header-logo" src="" alt="logo">-->
            <div class="my-header-logo">后台模板 HTML</div>
        </a>
        <div class="my-header-btn">
            <button class="layui-btn layui-btn-small btn-nav"><i class="layui-icon">&#xe65f;</i></button>
        </div>

        <!-- 顶部左侧添加选项卡监听 -->
        <ul class="layui-nav" lay-filter="side-top-left">
            <li class="layui-nav-item">
                <a href="javascript:;"><i class="layui-icon">&#xe671;</i>借阅</a>
                <dl class="layui-nav-child">
                    <dd><a style="color: #008B8B" href="javascript:;" href-url="demo/btn.html"><i class="layui-icon">&#xe630;</i>借书</a>
                    </dd>
                    <dd><a style="color: #008B8B" href="javascript:;" href-url="demo/form.html"><i class="layui-icon">&#xe630;</i>还书</a>
                    </dd>
                </dl>
            </li>
        </ul>

        <!-- 顶部右侧添加选项卡监听 -->
        <ul class="layui-nav my-header-user-nav" lay-filter="side-top-right">
            <li class="layui-nav-item">
                <a class="name" href="javascript:;"><i class="layui-icon">&#xe629;</i>主题</a>
                <dl class="layui-nav-child">
                    <dd data-skin="0"><a style="color: #008B8B" href="javascript:;">默认</a></dd>
                    <dd data-skin="1"><a style="color: #008B8B" href="javascript:;">纯白</a></dd>
                    <dd data-skin="2"><a style="color: #008B8B" href="javascript:;">蓝白</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item" style="width: 10px"></li>

            <li class="layui-nav-item">
                <a class="name" href="javascript:;">Admin </a>
                <dl class="layui-nav-child">
                    <dd><a style="color: #008B8B" href="javascript:;" href-url="demo/login.html"><i class="layui-icon">&#xe68e;</i>首页</a>
                    </dd>
                    <dd><a style="color: #008B8B" href="/"><i class="layui-icon">&#x1006;</i>退出</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item" style="width: 15px"></li>
        </ul>

    </div>
    <!-- side -->
    <div class="layui-side my-side">
        <div class="layui-side-scroll">
            <!-- 左侧主菜单添加选项卡监听 -->
            <ul class="layui-nav layui-nav-tree" lay-filter="side-main">
                <li class="layui-nav-item  layui-nav-itemed">
                    <a href="javascript:;"><i class="layui-icon">&#xe705;</i>图书管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" href-url="/book/listVo"><i class="layui-icon">&#xe62d;</i>图书列表</a>
                        </dd>
                        <dd><a href="javascript:;" href-url="/book/toNew"><i class="layui-icon">&#xe61f;</i>添加图书</a>
                        </dd>
                        <dd><a href="javascript:;" href-url="/dataAnalysis/getDonate"><i class="layui-icon">&#xe62d;</i>捐书列表</a>
                        </dd>

                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="layui-icon">&#xe656;</i>类型管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" href-url="/type/toList"><i class="layui-icon">&#xe62d;</i>类型列表</a>
                        </dd>
                        <dd><a href="javascript:;" href-url="/type/toNew"><i class="layui-icon">&#xe61f;</i>添加类型</a>
                        </dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="layui-icon">&#xe630;</i>借阅管理管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" href-url="demo/login.html"><i class="layui-icon">&#xe62d;</i>借阅列表</a>
                        </dd>
                        <dd><a href="javascript:;" href-url="demo/register.html"><i
                                class="layui-icon">&#xe621;</i>借书</a></dd>
                        <dd><a href="javascript:;" href-url="demo/register.html"><i
                                class="layui-icon">&#xe621;</i>还书</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="layui-icon">&#xe612;</i>读者管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" href-url="demo/login.html"><i class="layui-icon">&#xe62d;</i>读者列表</a>
                        </dd>
                        <dd><a href="javascript:;" href-url="demo/register.html"><i class="layui-icon">&#xe61f;</i>添加读者</a>
                        </dd>
                        <dd><a href="javascript:;" href-url="demo/register.html"><i class="layui-icon">&#xe62d;</i>失信列表</a>
                        </dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="layui-icon">&#xe68e;</i>我的书屋</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" href-url="/book/sort"><i class="layui-icon">&#xe62d;</i>图书排行榜</a>
                        </dd>
                        <dd><a href="javascript:;" href-url="demo/register.html"><i class="layui-icon">&#xe62d;</i>读者排行榜</a>
                        </dd>
                        <dd><a href="javascript:;" href-url="/type/toPie"><i class="layui-icon">&#xe62c;</i>图书库存统计</a>
                        </dd>
                        <dd><a href="javascript:;" href-url="/jump/todataAnalysis"><i class="layui-icon">&#xe62c;</i>租借数据统计</a>
                        </dd>
                        <dd><a id="xiaoai" href="javascript:;" href-url="../../ai.jsp"><i
                                class="layui-icon">&#xe61c;</i>智障小Ai</a>
                        </dd>
                    </dl>
                </li>


                <li class="layui-nav-item  layui-nav-itemed">
                    <a href="javascript:;"><i class="layui-icon">&#xe705;</i>自助服务</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" href-url="/book/listVo"><i class="layui-icon">&#xe705;</i>图书查询</a>
                        </dd>
                        <dd><a href="javascript:;" href-url=""><i class="layui-icon">&#xe656;</i>类型查询</a>
                        </dd>
                        <dd><a href="javascript:;" href-url="/book/sort"><i class="layui-icon">&#xe62d;</i>借阅排行榜</a>
                        </dd>
                        <dd><a href="javascript:;" href-url=""><i class="layui-icon">&#xe62d;</i>读者排行榜</a>
                        </dd>
                        <dd><a href="javascript:;" href-url=""><i class="layui-icon">&#xe62d;</i>失信读者公示</a>
                        </dd>

                    </dl>
                </li>
                <li>
                    <div id="msg" style="width: 140px;height: 70px; position:absolute; right: 158px">
                        <img onclick="goToXiaoAi()" style="width: 140px;height: 70px"
                             src="/frame/static/image/ai.png">
                    </div>
                </li>
            </ul>
            <script>
                function goToXiaoAi() {
                    document.getElementById("xiaoai").click();
                }
            </script>

        </div>
    </div>
    <!-- body -->
    <div class="layui-body my-body">
        <div class="layui-tab layui-tab-card my-tab" lay-filter="card" lay-allowClose="true">
            <ul class="layui-tab-title">
                <li class="layui-this" lay-id="1"><span><i class="layui-icon">&#xe638;</i>欢迎页</span></li>
            </ul>
            <div class="layui-tab-content">
                <div class="layui-tab-item layui-show">
                    <iframe id="iframe" src="demo/welcome.html" frameborder="0"></iframe>
                </div>
            </div>
        </div>
    </div>

</div>

<script type="text/javascript" src="../../frame/layui/layui.js"></script>
<script type="text/javascript" src="../../frame/static/js/vip_comm.js"></script>
<script type="text/javascript" src="/frame/jquery-3.3.1.js"></script>
<script>
    $("#msg").mouseenter(function () {
        $("#msg").stop().animate({
            left: '0px',
            opacity: '0.5',
            height: '80px',
            width: '160px',

        });
    });
    $("#msg").mouseleave(function () {
        $("#msg").stop().animate({
            left: '-100px',
            opacity: '0.5',
            height: '80px',
            width: '160px'
        });
    });
</script>
<script type="text/javascript">
    layui.use(['layer', 'vip_nav'], function () {

        // 操作对象
        var layer = layui.layer
            , vipNav = layui.vip_nav
            , $ = layui.jquery;

        // 顶部左侧菜单生成 [请求地址,过滤ID,是否展开,携带参数]
        vipNav.top_left('./json/nav_top_left.json', 'side-top-left', false);
        // 主体菜单生成 [请求地址,过滤ID,是否展开,携带参数]
        vipNav.main('./json/nav_main.json', 'side-main', true);

        // you code ...


    });
</script>
</body>
</html>
