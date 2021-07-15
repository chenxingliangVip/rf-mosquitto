<template>
    <div class="SystemLog">
        <div class="Search_Top_Input">
			<div class="search_list">
                <div class="input_flex">
                    <el-input clearable v-model="searchInput1" placeholder="姓名"></el-input>
                </div>
                <div class="input_flex">
                    <el-input clearable v-model="searchInput2" placeholder="日期"></el-input>
                </div>
                <div class="input_flex search">
                    <span class="zll-search">搜索</span>
                    <span class="zll-search-reset" @click="searchReset()">重置</span>
                </div>
			</div>
			<div class="addNew">
                <span class="delete" @click="batchCancal"><i class="el-icon-delete"></i> 批量删除</span>
			</div>
        </div>
        <!-- table -->
        <sys-table  
            :isMultipleSelection="true" 
            :tableData="tableData" 
            :tableLoading="tableLoading" 
            :tableHeader="tableHeader"
            :scopeWidth="120"
            :isOperate="false"
            @getSelection="getSelection"
        >
        </sys-table>
    </div>
</template>

<script>
    export default {
        data(){
            return {
                searchInput1: '',
                searchInput2: '',
                tableLoading:true, //table刷新
                tableData: [{
                    tableNum1: '用户名',//用户名
                    tableNum2: '姓名',//姓名
                    tableNum3: '操作记录',//操作记录
                    tableNum4: '操作时间',//操作时间
                }],
                tableHeader:[],
                selectList: [],
            }
        },
        methods: {
             getTableList(){//获取表格数据
                this.tableLoading = true;
                setTimeout(()=>{
                    this.tableHeader =  [
                        {"columnValue": "tableNum1", "columnName": "用户名"},
                        {"columnValue": "tableNum2", "columnName": "姓名"},
                        {"columnValue": "tableNum3", "columnName": "操作记录"},
                        {"columnValue": "tableNum4", "columnName": "操作时间"},
                    ]
                    this.tableData = JSON.parse(JSON.stringify(this.tableData))
                    this.tableLoading = false;
                },500)
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
                        this.$message.success("已删除")
                    }).catch(() => {
                        this.$message.info("已取消")           
                    });
                }
            },
            getSelection(val){
                this.selectList = val;
            },
            searchReset() { //重置搜索
                this.searchInput1 = "";
                this.searchInput2 = "";
                this.getTableList();
            },
        },
        mounted(){
            this.getTableList();//显示table
        },
    }
</script>

<style lang="scss" scoped>
    @import "@/assets/style/SearchTop.scss";
</style>