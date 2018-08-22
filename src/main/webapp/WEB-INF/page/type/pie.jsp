<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/21
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="/frame/echarts.js"></script>
    <script type="text/javascript" src="/frame/jquery-3.3.1.js"></script>
    <title></title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/frame/layui/css/layui.css">
    <link rel="stylesheet" href="/frame/static/css/style.css">
    <link rel="icon" href="/frame/static/image/code.png">
</head>
<body>
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    </fieldset>
    <div id="box" style="width: 600px;height:400px;"></div>
</body>
</html>
<script>
    // 获取到这个DOM节点，然后初始化
    var myChart = echarts.init(document.getElementById("box"));
    var url = '/dataAnalysis/toDataAnalysis';
    window.onload = toDataAnalysis();
    function toDataAnalysis() {
        $.ajax({
            url: "/type/pie",
            dataType: "json",
            error() {
            },
            success(json) {
                //获取数据
                var count = json.count;
                var name = json.name;

                // option 里面的内容基本涵盖你要画的图表的所有内容
                var option = {
                    title : {
                        text: '图书类型占比',
                        subtext: '前5名',
                        x:'center'
                    },
                    tooltip : {
                        trigger: 'item',
                        formatter: "{a} <br/>{b} : {c} ({d}%)"
                    },
                    legend: {
                        orient : 'vertical',
                        x : 'left',
                        data: name
                    },
                    toolbox: {
                        show : true,
                        feature : {
                            mark : {show: true},
                            dataView : {show: true, readOnly: false},
                            magicType : {
                                show: true,
                                type: ['pie', 'funnel'],
                                option: {
                                    funnel: {
                                        x: '25%',
                                        width: '50%',
                                        funnelAlign: 'left',
                                        max: 1548
                                    }
                                }
                            },
                            restore : {show: true},
                            saveAsImage : {show: true}
                        }
                    },
                    calculable : true,
                    series : [
                        {
                            name:'图书类型',
                            type:'pie',
                            radius : '55%',
                            center: ['50%', '60%'],
                            data:(function () {
                                var arrNum = [];
                                for (var i=0;i<count.length;i++){
                                    arrNum.push({"value": count[i],"name":name[i]});
                                }
                                return arrNum;
                            })(),

                        }
                    ]
                };
                // 一定不要忘了这个，具体是干啥的我忘了，官网是这样写的使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);
            }
        });
        return false;
    }
</script>
