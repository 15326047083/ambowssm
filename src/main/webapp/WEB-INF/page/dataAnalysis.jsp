<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="/frame/echarts.js"></script>
    <title></title>
</head>

<body>
<div id="box" style="width: 600px;height:400px;"></div>
</body>

</html>
<script>
    // 获取到这个DOM节点，然后初始化

    var myChart = echarts.init(document.getElementById("box"));

    // option 里面的内容基本涵盖你要画的图表的所有内容
    var option = {
        backgroundColor: '#FBFBFB',
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: ['充值', '消费']
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
            data: function() {
                var list = [];
                for(var i = 10; i <= 18; i++) {
                    if(i <= 12) {
                        list.push('2016-' + i + '-01');
                    } else {
                        list.push('2017-' + (i - 12) + '-01');
                    }
                }
                return list;
            }()
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
            name: '充值',
            type: 'line',
            symbol: 'none',
            smooth: 0.2,
            color: ['#66AEDE'],
            data: [800, 300, 500, 800, 300, 600, 500, 600]
        }, {
            name: '消费',
            type: 'line',
            symbol: 'none',
            smooth: 0.2,
            color: ['#90EC7D'],
            data: [600, 300, 400, 200, 300, 300, 200, 400]
        }],
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
</script>