var data = [70]
var formatter = 'M2 / 延期2h'

export default {
    option: {
        xAxis: {
            show: false
        },
        yAxis: [{
            show: true,
            data: [''],
            inverse: true,
            axisLine: {
                show: false
            },
            splitLine: {
                show: false
            },
            axisTick: {
                show: false
            },
            axisLabel: {
                show: false
            },
        }, {//背景柱
            show: true,
            inverse: true,
            data: [100],
            axisLabel: {
                show: false
            },
            axisLine: {
                show: false
            },
            splitLine: {
                show: false
            },
            axisTick: {
                show: false
            },
    
        }],
        series: [{
            name: '条',
            type: 'bar',
            yAxisIndex: 0,
            data: data,
            barWidth: 60,
            itemStyle: {
                normal: {
                    barBorderRadius: 30,
                    color: 'rgba(16, 137, 231, .7)'
                }
            },
            label: {
                normal: {
                    show: true,
                    position: 'inside',
                    formatter: formatter,
                    fontSize: 16
                }
            },
        }, {
            name: '框',
            type: 'bar',
            yAxisIndex: 1,
            barGap: '-100%',
            data: [100,],
            barWidth: 60,
            itemStyle: {
                normal: {
                    color: 'none',
                    borderColor: '#00c1de',
                    borderWidth: 3,
                    barBorderRadius: 30,
                }
            }
        }, ]
    }
}