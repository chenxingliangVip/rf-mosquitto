<template>
    <div class="Srp">
        <!-- 头部input搜索 -->
        <div class="Search_Top_Input">
            <div class="search_list" style="width: 100% !important">
                <div class="input_flex">
                    <el-select clearable v-model="searchInput1" placeholder="产线">
                        <el-option label="M2" value="M2"></el-option>
                        <el-option label="M1" value="M1"></el-option>
                    </el-select>
                </div>
                <div class="input_flex">
                    <el-input clearable v-model="searchInput2" placeholder="产品名称"></el-input>
                </div>
                <div class="input_flex">
                    <el-input clearable v-model="searchInput3" placeholder="产品编码"></el-input>
                </div>
                <div class="input_flex">
                    <el-select clearable v-model="searchInput4" placeholder="规格">
                        <el-option label="药用级" value="药用级"></el-option>
                        <el-option label="工业级" value="工业级"></el-option>
                    </el-select>
                </div>
                <div class="input_flex">
                    <el-date-picker v-model="searchInput5" type="daterange" range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期"></el-date-picker>
                </div>
                <div class="input_flex search">
                    <span class="zll-search">搜索</span>
                    <span class="zll-search-reset" @click="searchReset()">重置</span>
                </div>
            </div>
        </div>
        <!-- table -->
        <sys-table :isMultipleSelection="false" 
            :tableData="tableData" 
            :tableLoading="tableLoading" 
            :tableHeader="tableHeader"
            :scopeWidth="120">
            <template slot-scope="scope" slot="operate">
                <el-button type="text" size="small" v-if="scope.row.tabledata8 == '待生产'" style="color: #e82626" @click="activate()">SRP激活</el-button>
                <el-button type="text" size="small" v-else @click="goDetail(scope.row)">查看</el-button>
            </template>
        </sys-table>

        <!-- 查看弹框 -->
        <div class="zll-dialog">
            <popout title="查看 · SRP" :visible.sync="addDialog" v-if="addDialog">
                <Add ref="add" slot="content"></Add>
                <template slot="bottom">
                    <p class="zll-botton" @click="addDialog = false">确 定</p>
                </template>
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
                searchInput1: '',
                searchInput2: '',
                searchInput3: '',
                searchInput4: '',
                searchInput5: '',
                tableData: [{
                    tabledata1: '',//计划日期
                    tabledata2: 'M1',//产线
                    tabledata3: '2',//批产量
                    tabledata4: '产品名称',//产品名称
                    tabledata5: '',//产品编码
                    tabledata6: '药用级',//规格
                    tabledata7: '',//开始日期
                    tabledata8: '已完成',//任务状态
                    tabledata9: 3,//SRP
                    tabledata10: '',//SRP归档
                    tabledata11: '',//完成日期
                }, {
                    tabledata1: '',//计划日期
                    tabledata2: 'M1',//产线
                    tabledata3: '2',//批产量
                    tabledata4: '产品名称',//产品名称
                    tabledata5: '',//产品编码
                    tabledata6: '药用级',//规格
                    tabledata7: '',//开始日期
                    tabledata8: '待生产',//任务状态
                    tabledata9: 3,//SRP
                    tabledata10: '',//SRP归档
                    tabledata11: '',//完成日期
                }],
                tableHeader:[],
                addDialog: false, //新建编辑
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
                        {"columnValue": "tabledata1", "columnName": "计划日期"},
                        {"columnValue": "tabledata2", "columnName": "产线"},
                        {"columnValue": "tabledata3", "columnName": "批产量", isSortable: true},
                        {"columnValue": "tabledata4", "columnName": "产品名称"},
                        {"columnValue": "tabledata5", "columnName": "产品编码"},
                        {"columnValue": "tabledata6", "columnName": "规格"},
                        {"columnValue": "tabledata7", "columnName": "开始日期" },
                        {"columnValue": "tabledata8", "columnName": "任务状态" },
                        {"columnValue": "tabledata9", "columnName": "SRP"},
                        {"columnValue": "tabledata10", "columnName": "SRP归档" },
                        {"columnValue": "tabledata11", "columnName": "完成日期"},
                    ]
                    this.tableData = JSON.parse(JSON.stringify(this.tableData))
                    this.tableLoading = false;
                },500)
            },
            goDetail() {
                this.addDialog = true
            },
            activate() { //激活
                this.$confirm('确定激活？', '提示', {       
                        distinguishCancelAndClose: true,
                        cancelButtonText: '取消',
                        confirmButtonText: '确定',
                    }).then(() => {
                        this.$message.success("激活成功")
                    }).catch(() => {
                            
                    });
            },
            searchReset() { //重置搜索
                this.searchInput1 = "";
                this.searchInput2 = "";
                this.searchInput3 = "";
                this.searchInput4 = "";
                this.searchInput5 = "";
                this.getTableList();
            },
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
