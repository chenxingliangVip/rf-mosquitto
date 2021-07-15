<template>
    <div class="StartProduct">
        <!-- table -->
        <sys-table :isMultipleSelection="false"  class="start"
            :tableData="tableData" 
            :tableLoading="tableLoading" 
            :tableHeader="tableHeader"
            :scopeWidth="120">
            <template slot-scope="scope" slot="operate">
                <el-button v-if="scope.row.state == '启动'" @click="start(scope.row)" type="primary" size="small">启 动</el-button>
                <el-button v-if="scope.row.state == '生产中'" type="danger" plain disabled size="small">生产中</el-button>
                <el-button v-if="scope.row.state == '完成'" type="success" plain disabled size="small">完 成</el-button>
            </template>
        </sys-table>

        <!-- 启动新任务弹框 -->
        <div class="zll-dialog">
            <popout title="启动新任务" :visible.sync="addDialog" v-if="addDialog" class="start_dialog">
                <Add ref="add" slot="content" @addForm="getFormData"></Add>
            </popout>
        </div> 
    </div>
</template>

<script>
    import Add from "./add"
    export default {
        data () {
            return {
                tableLoading:true, //table刷新
                tableData: [{
                    tabledata1: '批次号',//批次号
                    tabledata2: 'T1',//
                    tabledata3: '产品名称',//产品名称
                    tabledata4: '产品编码',//产品编码
                    tabledata5: '药用级',//产品规格
                    tabledata6: '',//预开始日期
                    tabledata7: '',//预结束日期
                    tabledata8: '生产部门',//生产部门
                    tabledata9: '张三',//负责人
                    tabledata10: '未下发',//SRP
                    state: '启动',
                }, {
                    tabledata1: '批次号',//批次号
                    tabledata2: 'T1',//
                    tabledata3: '产品名称',//产品名称
                    tabledata4: '产品编码',//产品编码
                    tabledata5: '药用级',//产品规格
                    tabledata6: '',//预开始日期
                    tabledata7: '',//预结束日期
                    tabledata8: '生产部门',//生产部门
                    tabledata9: '张三',//负责人
                    tabledata10: '已下发',//SRP
                    state: '生产中'
                }, {
                    tabledata1: '批次号',//批次号
                    tabledata2: 'T1',//
                    tabledata3: '产品名称',//产品名称
                    tabledata4: '产品编码',//产品编码
                    tabledata5: '药用级',//产品规格
                    tabledata6: '',//预开始日期
                    tabledata7: '',//预结束日期
                    tabledata8: '生产部门',//生产部门
                    tabledata9: '张三',//负责人
                    tabledata10: '已下发',//SRP
                    state: '完成'
                }],
                tableHeader:[],
                addDialog: false, //启动新任务弹框
            }
        },
        methods: {
            getTableList(){//获取表格数据
                this.tableLoading = true;
                setTimeout(()=>{
                    for (let i = 0; i < this.tableData.length; i++) {
                        this.tableData[i]['index'] = i +1
                    }
                    this.tableHeader =  [
                        {"columnValue": "index", "columnName": "序号", 'width': '50px' },
                        {"columnValue": "tabledata1", "columnName": "批次号"},
                        {"columnValue": "tabledata2", "columnName": "产线", 'width': '50px' },
                        {"columnValue": "tabledata3", "columnName": "产品名称"},
                        {"columnValue": "tabledata4", "columnName": "产品编码"},
                        {"columnValue": "tabledata5", "columnName": "产品规格", 'width': '100px'},
                        {"columnValue": "tabledata6", "columnName": "预开始日期"},
                        {"columnValue": "tabledata7", "columnName": "预结束日期" },
                        {"columnValue": "tabledata8", "columnName": "生产部门", 'width': '100px'},
                        {"columnValue": "tabledata9", "columnName": "负责人" },
                        {"columnValue": "tabledata10", "columnName": "SRP", 'width': '100px' },
                    ]
                    this.tableData = JSON.parse(JSON.stringify(this.tableData))
                    this.tableLoading = false;
                },500)
            },
            getFormData(data){ //新建
                this.addDialog = false
            },
            start(row){
                this.addDialog = true
            }
        },
        mounted(){
            this.getTableList();//显示table
        },
        components:{
           Add
        },
    }
</script>
<style scoped lang="scss">
    @import "@/assets/style/SearchTop.scss";
</style>
