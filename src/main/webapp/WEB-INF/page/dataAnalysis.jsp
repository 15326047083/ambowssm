<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
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
<form id="time" action="/dataAnalysis/toDataAnalysis">
      请选择日期：<input type="date" name="start" style="height: 25px"/>
    <input type="date" name="end" style="height: 25px"/>
    <input type="submit" class="layui-btn layui-btn-primary layui-btn-small" value="查询" onclick="return toDataAnalysis()">
</form>
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
            url: "/dataAnalysis/toDataAnalysis",
            data: $('#time').serialize(),
            dataType: "json",
            error() {
            },
            success(json) {
                //获取数据
                var count1 = json.count1;
                var count2 = json.count2;
                var date = json.date;

                // option 里面的内容基本涵盖你要画的图表的所有内容
                var option = {
                    title : {
                        text: '租借数据图',
                        left:'center',
                        top:'10'
                        },
                    backgroundColor: '#FBFBFB',
                    tooltip: {
                        trigger: 'axis'
                    },
                    legend: {
                        orient:'vertical',
                        left:'right',
                        data: ['捐入数量', '借出数量']
                    },
                    calculable: true,
                    xAxis: [{
                        axisLabel: {
                            rotate: 30,
                            interval: 0
                        },
                        name:'日期',
                        axisLine: {
                            lineStyle: {
                                color: 'black'
                            }
                        },
                        type: 'category',
                        boundaryGap: false,
                        data: date
                    }],
                    yAxis: [{
                        name:'数量',
                        type: 'value',
                        axisLine: {
                            lineStyle: {
                                color: 'black'
                            }
                        }
                    }],
                    series: [{
                        name: '捐入数量',
                        type: 'line',
                        symbol: 'none',
                        smooth: 0.2,
                        color: ['#FF6E33'],
                        data: count1
                    }, {
                        name: '借出数量',
                        type: 'line',
                        symbol: 'none',
                        smooth: 0.2,
                        color: ['#8087CC'],
                        data: count2
                    }],
                    dataZoom:[ {
                        type: 'slider',
                        orient: 'horizontal',
                        handleIcon: 'M10.7,11.9v-1.3H9.3v1.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4v1.3h1.3v-1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7V23h6.6V24.4z M13.3,19.6H6.7v-1.4h6.6V19.6z',
                        handleSize: '80%',
                        handleStyle: {
                            color: '#fff',
                            borderColor: '#0e84de'
                        }
                    }],
                };
                // 一定不要忘了这个，具体是干啥的我忘了，官网是这样写的使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);
            }
        });
        return false;
    }
</script>