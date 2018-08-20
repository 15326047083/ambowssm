<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="/frame/echarts.js"></script>
    <script type="text/javascript" src="/frame/jquery-3.3.1.js"></script>
    <title></title>
</head>

<body>
<form id="time" action="/dataAnalysis/toDataAnalysis">
    <input type="date" name="start"/>
    <input type="date" name="end"/>
    <input type="submit" value="查询" onclick="return toDataAnalysis()">
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
                var count = json.count;
                var date = json.date;

                // option 里面的内容基本涵盖你要画的图表的所有内容
                var option = {
                    backgroundColor: '#FBFBFB',
                    tooltip: {
                        trigger: 'axis'
                    },
                    legend: {
                        data: ['借阅量', '消费']
                    },
                    calculable: true,
                    xAxis: [{
                        axisLabel: {
                            rotate: 30,
                            interval: 0
                        },
                        axisLine: {
                            lineStyle: {
                                color: '#CECECE'
                            }
                        },
                        type: 'category',
                        boundaryGap: false,
                        data: date
                    }],
                    yAxis: [{
                        type: 'value',
                        axisLine: {
                            lineStyle: {
                                color: '#CECECE'
                            }
                        }
                    }],
                    series: [{
                        name: '数量',
                        type: 'line',
                        symbol: 'none',
                        smooth: 0.2,
                        color: ['#66AEDE'],
                        data: count
                    }/*, {
                        name: '消费',
                        type: 'line',
                        symbol: 'none',
                        smooth: 0.2,
                        color: ['#90EC7D'],
                        data: [2, 3, 2]
                    }*/],
                    dataZoom: {
                        show: true,
                        realtime: true,
                        y: 36,
                        height: 20,
                        start: 20,
                        end: 80
                    }
                };
                // 一定不要忘了这个，具体是干啥的我忘了，官网是这样写的使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);
            }
        });
        return false;
    }
</script>