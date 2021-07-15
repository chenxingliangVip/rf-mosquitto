var data1 = [87.5, 95.9, 79, 60]; //echart1 产品状态数据
var data2 = [88, 86, 91, 89];//echart2 各生产部准点率
var data3 = [//echart3 各生产部准点率 酯化部
    { "value": 880 },  
    { "value": 670 },
    { "value": 880 }
];
var data4 = [//聚合部
    { "value": 670 },  
    { "value": 670 },
    { "value": 670 }
];
var data5 = [//封端部
    { "value": 910 },  
    { "value": 910 },
    { "value": 910 }
];
var data6 = [//药铺部
    { "value": 550 },  
    { "value": 550 },
    { "value": 550 }
];

export default {
    option1: {
        tooltip: {
            trigger: 'axis',
            padding: [10, 10],
            axisPointer: {
                type: 'line',
            },
            backgroundColor: 'rgba(64, 200, 255, .4)',
            formatter: function (param) {
                return param[0].name + "：" + param[0].value
            }
        },
        grid: {
            left: 120,
            right: 48,
            top: 0,
            bottom: 0
        },
        xAxis: {
            type: 'value',
            axisLabel: {
                show: false
            },
            axisTick: {
                show: false
            },
            axisLine: {
                show: false
            },
            splitLine: {
                show: false
            }
        },
        yAxis: [{
            type: 'category',
            data: ['PEG400\n20200101', 'PEG400\n20200103', '聚山梨酯20\n20200105', '聚山梨酯20\n20200106',],
            axisLabel: {
                color: "#eeeeee",
                fontSize: 14,
                lineHeight: 18,
            },
            axisTick: {
                show: false
            },
            axisLine: {
                show: false
            }
        }, {
            type: 'category',
            axisTick: 'none',
            axisLine: 'none',
            show: false,
        }],
        series: [{
            name: '',
            type: 'bar',
            data: data1,
            barWidth: 26,
            zlevel: 1,
            itemStyle: {
                normal: {
                    color: {
                        x: 1,
                        y: 0,
                        x2: 0,
                        y2: 0,
                        colorStops: [
                            { offset: 0, color: 'rgb(57,89,255,1)' },
                            { offset: 1, color: 'rgb(46,200,207,1)' }
                        ]
                    },
                    barBorderRadius: 30,
                    borderColor: 'rgba(180,240,255,.3)',
                    borderWidth: 1
                }
            },
            label: {
                normal: {
                    show: true,
                    position: 'insideRight',
                    formatter: '{c}',
                    color: "#eeeeee",
                    textStyle: {
                        fontSize: 16,
                        align: 'right'
                    },
                },
            },
            emphasis: {
                itemStyle: {
                    borderColor: 'rgba(180,240,255,1)',
                }
            }
        },
        {
            name: '',
            type: 'bar',
            barWidth: 26,
            barGap: '-100%',
            data: [100, 100, 100, 100],
            itemStyle: {
                normal: {
                    color: '#1c2156',
                    barBorderRadius: 30,
                },
            }
        }
        ]
    },

    option2: {
        tooltip: {
            // trigger: 'axis',
            formatter: '{b}：\n{c}%',
            backgroundColor: 'rgba(64, 200, 255, .4)',
            axisPointer: {
                type: 'line',
            },
        },
        grid: {
            left: 10,
            right: 10,
            top: 20,
            bottom: 42
        },
        xAxis: [{
            type: 'category',
            data: ['酯化部', '聚合部', '封端部', '药铺部'],
            axisLabel: {
                color: '#eeeeee',
                textStyle: {
                    fontSize: 16
                },
            },
            axisLine: {
                lineStyle: {
                    color: '#2ec8cf',
                }
            },
            axisTick: {
                show: false
            },
        }],
        yAxis: [{
            min: 0,
            max: 100,
            axisLabel: {
                show: false
            },
            axisLine: {
                show: false
            },
            axisTick: {
                show: false
            },
            splitLine: {
                show: false
            }
        }],
        series: [{
            type: 'bar',
            data: data2,
            barWidth: '40px',
            itemStyle: {
                normal: {
                    color: {
                        x: 0,
                        y: 1,
                        x2: 0,
                        y2: 0,
                        colorStops: [
                            { offset: 0, color: 'rgba(0, 79, 197, 1)' },
                            { offset: 1, color: 'rgba(0, 79, 197, 0)' }
                        ]
                    },
                    barBorderRadius: [30, 30, 0, 0],
                }
            },
            label: {
                show: true,
                fontSize: 16,
                position: 'top',
                color: '#fbde0d',
                formatter: '{c}%'
            }
        }]
    },

    option4: {
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            }
        },
        color: ['rgba(51, 140, 249, .7)', 'rgba(150, 237, 193,.7)', 'rgba(234, 107, 124, .7)', 'rgba(252, 183, 91,.7)'],
        grid: {
            top: "40",
            left: "200",
            bottom: "30",
            right: "20",
        },
        legend: {
            show: true,
            top: 80,
            left: 30,
            data: ['酯化部', '聚合部', '封端部', '药铺部'],
            textStyle: {
                color: "#eeeeee",
                fontSize: 16,
                padding: [0, 0, 0, 15]
            },
            orient: 'vertical',
            itemHeight: 20,
            itemWidth: 40,
            itemGap: 25
        },
        xAxis: [{
            type: "category",
            data: ["2020-01", "2020-02", "2020-03"],
            axisTick: {
                show: false
            },
            nameTextStyle: {
                color: "#fff"
            },
            axisLine: {
                lineStyle: {
                    color: "#2ec8cf"
                }
            },
            axisLabel: {
                textStyle: {
                    color: "#eeeeee",
                    fontSize: 16,
                },
            }
        }],
        yAxis: [{
            type: "value",
            axisLabel: {
                show: false
            },
            axisLine: {
                show: false
            },
            axisTick: {
                show: false
            },
            splitLine: {
                show: false
            }
        }],
        series: [{
            name: '酯化部',
            type: 'bar',
            barWidth: "35",
            data: data3,
            itemStyle: {
                normal: {
                    color: {
                        x: 0,
                        y: 1,
                        x2: 0,
                        y2: 0,
                        colorStops: [
                            { offset: 0,  color: "#f5c379" },
                            { offset: 1,  color: "#f5c379" }
                        ]
                    },
                    shadowBlur: 5,
                    shadowColor: 'rgba(255, 255, 255, 0.3)',
                },
            },
            label: {
                show: true,
                fontSize: 16,
                position: 'top',
                color: '#f5c379',
                formatter: '{c}'
            },
        },
        {
            name: '聚合部',
            type: 'bar',
            barWidth: "35",
            data: data4,
            itemStyle: {
                normal: {
                    color: {
                        x: 0,
                        y: 1,
                        x2: 0,
                        y2: 0,
                        colorStops: [
                            { offset: 0, color: '#118df0' },
                            { offset: 1, color: '#118df0' }
                        ]
                    },
                    shadowBlur: 5,
                    shadowColor: 'rgba(255, 255, 255, 0.3)',
                }
            },
            label: {
                show: true,
                fontSize: 16,
                position: 'top',
                color: '#118df0',
                formatter: '{c}'
            }
        },
        {
            name: '封端部',
            type: 'bar',
            barWidth: "35",
            data: data5,
            itemStyle: {
                normal: {
                    color: {
                        x: 0,
                        y: 1,
                        x2: 0,
                        y2: 0,
                        colorStops: [
                            { offset: 0, color: '#AF89D6' },
                            { offset: 1, color: '#AF89D6' }
                        ]
                    },
                    shadowBlur: 5,
                    shadowColor: 'rgba(255, 255, 255, 0.3)',
                }
            },
            label: {
                show: true,
                fontSize: 16,
                position: 'top',
                color: '#AF89D6',
                formatter: '{c}'
            }
        },
        {
            name: '药铺部',
            type: 'bar',
            barWidth: "35",
            data: data6,
            itemStyle: {
                normal: {
                    color: {
                        x: 0,
                        y: 1,
                        x2: 0,
                        y2: 0,
                        colorStops: [
                            { offset: 0, color: "#11cbd7" },
                            { offset: 1, color: '#11cbd7' }
                        ]
                    },
                    shadowBlur: 5,
                    shadowColor: 'rgba(255, 255, 255, 0.3)',
                }
            },
            label: {
                show: true,
                fontSize: 16,
                position: 'top',
                color: '#11cbd7',
                formatter: '{c}'
            }
        }
        ]
    },
}