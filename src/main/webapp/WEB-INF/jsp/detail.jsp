<%--
  Created by IntelliJ IDEA.
  User: kewenkang
  Date: 2018/6/6
  Time: 上午11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail</title>
    <%--<script src="/WEB-INF/jsp/js/echarts.js"></script>--%>
    <%--<script src="http://echarts.baidu.com/build/dist/echarts.js"></script>--%>
    <script src="https://cdn.jsdelivr.net/npm/echarts@3.5.4/dist/echarts.min.js"></script>
</head>
<body align="center">
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 600px;height:400px;"  align="center"></div>
<label>${msg}</label>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: 'Sale summation'
        },
        tooltip: {},
        legend: {
            data:['销量']
        },
        xAxis: {
            data: ["locks", "stocks", "barrels"]
        },
        yAxis: {},
        series: [{
            name: '销量',
            type: 'bar',
            data: [${locks}, ${stocks}, ${barrels}]
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>
<%--<script src="http://echarts.baidu.com/build/dist/echarts.js"></script>--%>
<%--<script type="text/javascript">--%>
    <%--// 路径配置--%>
    <%--require.config({--%>
        <%--paths: {--%>
            <%--echarts: 'http://echarts.baidu.com/build/dist'--%>
        <%--}--%>
    <%--});--%>

    <%--// 使用--%>
    <%--require(--%>
        <%--[--%>
            <%--'echarts',--%>
            <%--'echarts/chart/bar' // 使用柱状图就加载bar模块，按需加载--%>
        <%--],--%>
        <%--function (ec) {--%>
            <%--// 基于准备好的dom，初始化echarts图表--%>
            <%--var myChart = ec.init(document.getElementById('main'));--%>

            <%--var option = {--%>
                <%--tooltip: {--%>
                    <%--show: true--%>
                <%--},--%>
                <%--legend: {--%>
                    <%--data:['销量']--%>
                <%--},--%>
                <%--xAxis : [--%>
                    <%--{--%>
                        <%--type : 'category',--%>
                        <%--data : ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]--%>
                    <%--}--%>
                <%--],--%>
                <%--yAxis : [--%>
                    <%--{--%>
                        <%--type : 'value'--%>
                    <%--}--%>
                <%--],--%>
                <%--series : [--%>
                    <%--{--%>
                        <%--"name":"销量",--%>
                        <%--"type":"bar",--%>
                        <%--"data":[5, 20, 40, 10, 10, 20]--%>
                    <%--}--%>
                <%--]--%>
            <%--};--%>

            <%--// 为echarts对象加载数据--%>
            <%--myChart.setOption(option);--%>
        <%--}--%>
    <%--);--%>
<%--</script>--%>
</body>
</html>
