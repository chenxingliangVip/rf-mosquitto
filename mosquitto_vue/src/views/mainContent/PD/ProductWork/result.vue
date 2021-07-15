<template>
    <div class="addProject">
        <div class="tableList">
            <table border="1" class="result_table">
                <tr>
                    <td class="column">批次号</td>
                    <td>{{ tableData.tableData1 }}</td>
                    <td class="column">检验号</td>
                    <td>{{ tableData.tableData8 }}</td>
                </tr>
                <tr>
                    <td class="column">阶段</td>
                    <td>{{ tableData.tableData2 }}</td>
                    <td class="column">检验人</td>
                    <td>{{ tableData.tableData9 }}</td>
                </tr>
                <tr>
                    <td class="column">产品</td>
                    <td>{{ tableData.tableData3 }}</td>
                    <td class="column">报告日期</td>
                    <td>{{ tableData.tableData10 }}</td>
                </tr>
                <tr>
                    <td class="column">编号</td>
                    <td>{{ tableData.tableData4 }}</td>
                    <td class="column" rowspan="4">QC结果</td>
                    <td rowspan="4">
                        <img :src="tableData.imgSrc">
                    </td>
                </tr>
                <tr>
                    <td class="column">规格</td>
                    <td>{{ tableData.tableData5 }}</td>
                </tr>
                <tr>
                    <td class="column">产线</td>
                    <td>{{ tableData.tableData6 }}</td>
                </tr>
                <tr>
                    <td class="column">申请人</td>
                    <td>{{ tableData.tableData7 }}</td>
                </tr>
            </table>
            <p class="time">{{ timeOut }}秒后自动关闭</p>
        </div>
    </div>
</template>
<script>
export default {
    props: ['timeOut'],
    data() {
        return {
            tableData: {
                tableData1: 'P191212028',
                tableData2: 'M2',
                tableData3: '聚山梨酯20',
                tableData4: 'E010232',
                tableData5: '药用级',
                tableData6: '高分子聚合线·T1',
                tableData7: '张三',
                tableData8: 'J191212028',
                tableData9: '任思娟',
                tableData10: '2019-12-12',
                tableData11: '合格',
                imgSrc: ''
            }
        };
    },
    mounted() {
        if( this.tableData.tableData11 == '合格') {
            this.tableData.imgSrc = require('@/assets/img/result_yes.png')
        }else {
            this.tableData.imgSrc = require('@/assets/img/result_no.png')
        }
    }
};
</script>

<style scoped lang="scss">
@import "@/assets/style/dialog.scss";
.result_table {
    table-layout:fixed;
    td {
        width: calc(50% - 80px);
        overflow:hidden;
        text-overflow:ellipsis;
        white-space:nowrap;
        height: 30px !important;
        line-height: 30px !important;
        img {
            height: 60px;
        }
    }
    .column {
        background: #a6a6a6;
        text-align: right;
        padding-right: 10px !important;
        color: #ffffff;
        width: 80px !important;
    }
}
.time {
    text-align: right;
    color: #459dd2;
    font-size: 14px;
}
</style>
