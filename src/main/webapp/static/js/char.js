$(function() {
	var line = echarts.init(document.getElementById('line'));
	var pie = echarts.init(document.getElementById('pie'));
	var category = [];
	var dottedBase = +new Date();
	var lineData = [];
	var barData = [];

	for (var i = 0; i < 20; i++) {
	    var date = new Date(dottedBase += 3600 * 24 * 1000);
	    category.push([
	        date.getFullYear(),
	        date.getMonth() + 1,
	        date.getDate()
	    ].join('-'));
	    var b = Math.random() * 200;
	    var d = Math.random() * 200;
	    barData.push(b)
	    lineData.push(d + b);
	}
	// option
	optionLine = {
	    backgroundColor: '#0f375f',
	    tooltip: {
	        trigger: 'axis',
	        axisPointer: {
	            type: 'shadow'
	        }
	    },
	    legend: {
	        data: ['line', 'bar'],
	        textStyle: {
	            color: '#ccc'
	        }
	    },
	    xAxis: {
	        data: category,
	        axisLine: {
	            lineStyle: {
	                color: '#ccc'
	            }
	        }
	    },
	    yAxis: {
	        splitLine: {show: false},
	        axisLine: {
	            lineStyle: {
	                color: '#ccc'
	            }
	        }
	    },
	    series: [{
	        name: 'line',
	        type: 'line',
	        smooth: true,
	        showAllSymbol: true,
	        symbol: 'emptyCircle',
	        symbolSize: 15,
	        data: lineData
	    }, {
	        name: 'bar',
	        type: 'bar',
	        barWidth: 10,
	        itemStyle: {
	            normal: {
	                barBorderRadius: 5,
	                color: new echarts.graphic.LinearGradient(
	                    0, 0, 0, 1,
	                    [
	                        {offset: 0, color: '#14c8d4'},
	                        {offset: 1, color: '#43eec6'}
	                    ]
	                )
	            }
	        },
	        data: barData
	    }, {
	        name: 'line',
	        type: 'bar',
	        barGap: '-100%',
	        barWidth: 10,
	        itemStyle: {
	            normal: {
	                color: new echarts.graphic.LinearGradient(
	                    0, 0, 0, 1,
	                    [
	                        {offset: 0, color: 'rgba(20,200,212,0.5)'},
	                        {offset: 0.2, color: 'rgba(20,200,212,0.2)'},
	                        {offset: 1, color: 'rgba(20,200,212,0)'}
	                    ]
	                )
	            }
	        },
	        z: -12,
	        data: lineData
	    }, {
	        name: 'dotted',
	        type: 'pictorialBar',
	        symbol: 'rect',
	        itemStyle: {
	            normal: {
	                color: '#0f375f'
	            }
	        },
	        symbolRepeat: true,
	        symbolSize: [12, 4],
	        symbolMargin: 1,
	        z: -10,
	        data: lineData
	    }]
	};
	
	pieoption = {
			title : {
		        text: '某站点用户访问来源',
		        subtext: '纯属虚构',
		        x:'center'
		    },
		    tooltip : {
		        trigger: 'item',
		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    },
		    legend: {
		        orient: 'vertical',
		        left: 'left',
		        data: ['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
		    },
		    series : [
		        {
		            name: '访问来源',
		            type: 'pie',
		            radius : '55%',
		            center: ['50%', '60%'],
		            data:[
		                {value:335, name:'直接访问'},
		                {value:310, name:'邮件营销'},
		                {value:234, name:'联盟广告'},
		                {value:135, name:'视频广告'},
		                {value:1548, name:'搜索引擎'}
		            ],
		            itemStyle: {
		                emphasis: {
		                    shadowBlur: 10,
		                    shadowOffsetX: 0,
		                    shadowColor: 'rgba(0, 0, 0, 0.5)'
		                }
		            }
		        }
		    ]
	};
	pie.setOption(pieoption);
	line.setOption(optionLine);
})