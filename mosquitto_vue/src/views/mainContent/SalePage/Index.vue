<template>
    <div class="SalePage">
        <!-- 头部input搜索 -->
        <div class="Search_Top_Input">
            <div class="search_list">
                <div class="input_flex">
                    <el-input clearable v-model="searchInput1" placeholder="销售人"></el-input>
                </div>
                <div class="input_flex">
                    <el-input clearable v-model="searchInput2" placeholder="客户名称"></el-input>
                </div>
                <div class="input_flex">
                    <el-input clearable v-model="searchInput3" placeholder="订单号"></el-input>
                </div>
                <div class="input_flex">
                    <el-input clearable v-model="searchInput4" placeholder="产品名称"></el-input>
                </div>
                <div class="input_flex">
                    <el-input clearable v-model="searchInput5" placeholder="产品编码"></el-input>
                </div>
                <div class="input_flex">
                    <el-select clearable v-model="searchInput6" placeholder="规格">
                        <el-option label="药用级" value="药用级"></el-option>
                        <el-option label="工业级" value="工业级"></el-option>
                    </el-select>
                </div>
                <div class="input_flex">
                    <el-date-picker v-model="searchInput7" type="daterange" range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期"></el-date-picker>
                </div>
                <div class="input_flex search">
                    <span class="zll-search">搜索</span>
                    <span class="zll-search-reset" @click="searchReset()">重置</span>
                </div>
            </div>
			<div class="addNew">
                <span @click="add()"><i class="el-icon-circle-plus-outline"></i> 新建订单</span>
                <span class="delete" @click="batchCancal"><i class="el-icon-delete"></i> 批量删除</span>
			</div>
        </div>
        <!-- table -->
        <sys-table :isMultipleSelection="true" 
            :tableData="tableData" 
            :tableLoading="tableLoading" 
            :tableHeader="tableHeader"
            @getSelection="getSelection"
            :scopeWidth="120"
            :isOperate="false">
        </sys-table>

        <!-- 新建编辑弹框 -->
        <div class="zll-dialog">
            <popout :title="title + ' · 订单'" :visible.sync="addDialog" v-if="addDialog">
                <Add ref="add" slot="content" @addForm="getFormData"></Add>
                <template slot="bottom">
                    <p class="zll-botton" @click="()=>{this.$refs.add.setFormData('addForm')}">提 交</p>
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
                searchInput6: '',
                searchInput7: '',
                tableData: [{
                    tabledata1: '',//订单日期
                    tabledata2: '张三',//销售人
                    tabledata3: '客户名称',//客户名称
                    tabledata4: '0000',//订单号
                    tabledata5: '',//产品名称
                    tabledata6: '',//产品编码
                    tabledata7: '药用级',//规格
                    tabledata8: 12,//订单量
                    tabledata9: 3,//未排产
                    tabledata10: '',//排产状态
                    tabledata11: '',//备注
                }],
                tableHeader:[],
                addDialog: false, //新建编辑
                title: '',
                selectList: [],
            }
        },
        methods: {
            getTableList(){//获取表格数据
                this.tableLoading = true;
                setTimeout(()=>{
                    this.tableHeader =  [
                        {"columnValue": "tabledata1", "columnName": "订单日期"},
                        {"columnValue": "tabledata2", "columnName": "销售人"},
                        {"columnValue": "tabledata3", "columnName": "客户名称"},
                        {"columnValue": "tabledata4", "columnName": "订单号"},
                        {"columnValue": "tabledata5", "columnName": "产品名称"},
                        {"columnValue": "tabledata6", "columnName": "产品编码"},
                        {"columnValue": "tabledata7", "columnName": "规格" },
                        {"columnValue": "tabledata8", "columnName": "订单量", isSortable: true },
                        {"columnValue": "tabledata9", "columnName": "未排产", isSortable: true },
                        {"columnValue": "tabledata10", "columnName": "排产状态" },
                        {"columnValue": "tabledata11", "columnName": "备注"},
                    ]
                    this.tableData = JSON.parse(JSON.stringify(this.tableData))
                    this.tableLoading = false;
                },500)
            },
            getFormData(data){ //新建
                this.addDialog = false
            },
            add(){
                this.addDialog = true
                this.title = "新建"
            },
            batchCancal(){//批量删除
                if(this.selectList.length <1 ){
                    this.$message.warning("至少选择一列数据！");
                }else{
                    this.$confirm('确定删除？', '提示', {       
                        distinguishCancelAndClose: true,
                        cancelButtonText: '取消',
                        confirmButtonText: '确定',
                    }).then(() => {
                        for (let i = 0; i < this.tableData.length; i++) {
                            for (let j = 0; j < this.selectList.length; j++) {
                                if( this.tableData[i].index == this.selectList[j].index){
                                    this.tableData.splice(i,1)
                                }
                            }
                        }
                        this.$message.success("已删除")
                        this.getTableList()

                    }).catch(() => {
                        this.$message.info("已取消")          
                    });
                }
            },
            getSelection(val){ //选中List
                this.selectList = val;
            },
            searchReset() { //重置搜索
                this.searchInput1 = "";
                this.searchInput2 = "";
                this.searchInput3 = "";
                this.searchInput4 = "";
                this.searchInput5 = "";
                this.searchInput6 = "";
                this.searchInput7 = "";
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
