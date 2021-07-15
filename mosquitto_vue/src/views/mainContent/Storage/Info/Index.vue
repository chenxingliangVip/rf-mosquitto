<template>
    <div class="Info">
        <!-- 头部input搜索 -->
        <div class="Search_Top_Input">
            <div class="search_list" style="width: calc(100% - 100px) !important">
                <div class="input_flex">
                    <el-input clearable v-model="searchInput1" placeholder="批次号"></el-input>
                </div>
                <div class="input_flex">
                    <el-input clearable v-model="searchInput2" placeholder="产品名称"></el-input>
                </div>
                <div class="input_flex">
                    <el-select clearable v-model="searchInput3" placeholder="规格">
                        <el-option label="药用级" value="药用级"></el-option>
                        <el-option label="工业级" value="工业级"></el-option>
                    </el-select>
                </div>
                <div class="input_flex">
                    <el-select clearable v-model="searchInput4" placeholder="包装">
                        <el-option label="PPR50塑胶桶" value="PPR50塑胶桶"></el-option>
                    </el-select>
                </div>
                <div class="input_flex">
                    <el-select clearable v-model="searchInput5" placeholder="计件">
                        <el-option label="托盘" value="托盘"></el-option>
                    </el-select>
                </div>
                <div class="input_flex search">
                    <span class="zll-search">搜索</span>
                    <span class="zll-search-reset" @click="searchReset()">重置</span>
                </div>
            </div>
			<div class="addNew" style="width: 100px !important">
                <span>非整合并</span>
			</div>
        </div>
        <!-- table -->
        <sys-table  
            :isMultipleSelection="false" 
            :tableData="tableData" 
            :tableLoading="tableLoading" 
            :tableHeader="tableHeader"
            :scopeWidth="120"
        >
            <template slot-scope="scope" slot="operate">
                <el-button @click="godetail(scope.row)" type="text" size="small">查看</el-button>
                <el-button @click="inStore(scope.row)" type="text" size="small">入库</el-button>
            </template>
        </sys-table>

        <!-- 查看新建编辑弹框 -->
        <div class="zll-dialog">
            <popout :title="title +' · 入库'" :visible.sync="addDialog" v-if="addDialog">
                <Add ref="add" slot="content" @addForm="getFormData"></Add>
                <template slot="bottom">
                    <p class="zll-botton" v-if="title == '查看'" @click="addDialog = false">确 定</p>
                    <p class="zll-botton" v-else @click="()=>{this.$refs.add.setFormData('addForm')}">提 交</p>
                </template>
            </popout>
        </div>  
    </div>
</template>

<script>
    import Add from "./add"
    export default {
        data(){
            return {
                title: '',
                searchInput1: '',
                searchInput2: '',
                searchInput3: '',
                searchInput4: '',
                searchInput5: '',
                tableLoading:true, //table刷新
                tableData: [{
                    tableNum1: '批次号', //批次号
                    tableNum2: '产品名称',//产品名称
                    tableNum3: '药用级',//规格
                    tableNum4: '',//包装
                    tableNum5: '1',//数量
                    tableNum6: '',//计件
                    tableNum7: '2',//件数
                    tableNum8: '',//已入库
                    tableNum9: '',//未入库
                }],
                tableHeader:[],
                addDialog: false,
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
                        {"columnValue": "index", "columnName": "序号", 'width': '50'},
                        {"columnValue": "tableNum1", "columnName": "批次号"},
                        {"columnValue": "tableNum2", "columnName": "产品名称"},
                        {"columnValue": "tableNum3", "columnName": "规格", 'width': '100'},
                        {"columnValue": "tableNum4", "columnName": "包装"},
                        {"columnValue": "tableNum5", "columnName": "数量"},
                        {"columnValue": "tableNum6", "columnName": "计件"},
                        {"columnValue": "tableNum7", "columnName": "件数"},
                        {"columnValue": "tableNum8", "columnName": "已入库", 'width': '100'},
                        {"columnValue": "tableNum9", "columnName": "未入库", 'width': '100'},
                    ]
                    this.tableData = JSON.parse(JSON.stringify(this.tableData))
                    this.tableLoading = false;
                },500)
            },
            getFormData(data) {
                this.addDialog = false
            },
            inStore() {//入库
                this.addDialog = true
                this.title = '入库'
            },
            godetail(row) {//查看
                this.addDialog = true
                this.title = '查看'
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
        components: {
            Add, 
        }
    }
</script>

<style lang="scss" scoped>
    @import "@/assets/style/SearchTop.scss";
</style>