<template>
    <div class="addProject doPrint">
        <span @click="doPrint()" class="print_icon" title="打印"><i class="el-icon-printer"></i></span>
        <div class="printOrder-data">
            <h2>SRP-批生产记录表</h2>
            <div class="tableList">
                <table class="result_table">
                    <tr>
                        <td class="column">产品名称</td>
                        <td>{{ tableData.tableData1 }}</td>
                        <td class="column" rowspan="3">SRP识别码</td>
                        <td rowspan="3">
                            <img :src="tableData.tableData6">
                        </td>
                    </tr>
                    <tr>
                        <td class="column">产品编码</td>
                        <td>{{ tableData.tableData2 }}</td>
                    </tr>
                    <tr>
                        <td class="column">产品规格</td>
                        <td>{{ tableData.tableData3 }}</td>
                    </tr>
                    <tr>
                        <td class="column">产线</td>
                        <td>{{ tableData.tableData4 }}</td>
                        <td class="column">打印人</td>
                        <td>{{ tableData.tableData7 }}</td>
                    </tr>
                    <tr>
                        <td class="column">批次号</td>
                        <td>{{ tableData.tableData5 }}</td>
                        <td class="column">日期</td>
                        <td>{{ tableData.tableData8 }}</td>
                    </tr>
                </table>
            </div>
            <div class="tableList">
                <table class="print_bottom">
                    <tr>
                        <th>阶段</th>
                        <th>生产阈值记录</th>
                        <th>记录人</th>
                    </tr>
                    <tr>
                        <td>M1</td>
                        <td></td>
                        <td></td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</template>
<script>
export default {
    data() {
        return {
            tableData: {
                tableData1: "聚山梨酯20",
                tableData2: "E010232",
                tableData3: "药用级",
                tableData4: "高分子聚合线·T1",
                tableData5: "P191212028",
                tableData6: require("@/assets/img/erweima.png"),
                tableData7: "张三",
                tableData8: "2020-08-23",
            },
        };
    },
    methods: {
        doPrint() {
            var newstr = document.getElementsByClassName("printOrder-data")[0].innerHTML;
            var bdhtml = window.document.body.innerHTML;
            window.document.body.innerHTML = newstr;
            window.print();
            window.document.body.innerHTML = bdhtml; // 最后还原页面
            window.location.reload();
        },
    },
};
</script>

<style scoped lang="scss">
@page {
    size: auto; /* auto is the initial value */
    margin: 0mm; /* this affects the margin in the printer settings */
}
@import "@/assets/style/dialog.scss";
.doPrint {
    position: relative;
    .print_icon {
        color: #F56C6C;
        font-size: 20px;
        position: absolute;
        right: 40px;
        top: 20px;
        cursor: pointer;
    }
    h2 {
        text-align: center;
        font-weight: 400;
    }
    .tableList {
        padding: 15px;
        margin-top: 0 !important;
    }
    .result_table {
        width: 100%;
        border: 0px solid #aaa !important;
        table-layout: fixed;
        td {
            width: calc(50% - 100px);
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
            background: #ffffff !important;
            border: 1px solid #aaa !important;
            img {
                height: 60px;
            }
        }
        .column {
            background: #dddddd !important;
            padding-right: 10px !important;
            width: 100px !important;
        }
    }
    .print_bottom {
        th {
            background: #dddddd !important;
            color: #222 !important;
            border: 1px solid #aaa !important;
        }
        td {
            background: #ffffff !important;
            border: 1px solid #aaa !important;
        }
    }
}
</style>
<style media="print">
h2 {
    text-align: center;
    font-weight: 400;
    padding-top: 20px;
}
.tableList {
    padding: 15px;
}
.tableList table {
    text-align: center;
    width: 100%;
    border-collapse: collapse;
}
.tableList table th, td {
    height: 35px;
    line-height: 35px;
    padding: 3px;
}
.result_table {
    table-layout: fixed;
}
.result_table td {
    width: calc(50% - 100px);
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    border: 1px solid #aaa;
}
.result_table td img {
    height: 60px;
}
.result_table .column {
    background-color: #dddddd;-webkit-print-color-adjust: exact;
    padding-right: 10px;
    width: 100px;
}
.print_bottom th {
    background-color: #dddddd;-webkit-print-color-adjust: exact;
    font-weight: normal;
    border: 1px solid #aaa;
}
.print_bottom td {
    border: 1px solid #aaa;
}
</style>
