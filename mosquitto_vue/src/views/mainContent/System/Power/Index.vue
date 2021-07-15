<template>
    <div class="Power">
        <!-- 头部搜索 -->
        <div class="Search_Top_Input">
            <div class="search_list">
                <div class="input_flex">
                    <el-input clearable v-model="searchInput1" placeholder="部门"></el-input>
                </div>
                <div class="input_flex">
                    <el-input clearable v-model="searchInput2" placeholder="角色"></el-input>
                </div>
                <div class="input_flex search">
                    <span class="zll-search">搜索</span>
                    <span class="zll-search-reset" @click="searchReset()">重置</span>
                </div>
            </div>
            <div class="addNew">
                <span class="delete" @click="batchCancal"><i class="el-icon-delete"></i> 批量删除</span>
                <span @click="addPower()"><i class="el-icon-circle-plus-outline"></i> 新建角色</span>
            </div>
        </div>
        <!-- table -->
        <sys-table  
            :isMultipleSelection="true" 
            :tableData="tableData" 
            :tableLoading="tableLoading" 
            :tableHeader="tableHeader"
            :scopeWidth="120"
            @getSelection="getSelection"
        >
            <template slot-scope="scope" slot="operate">
                <el-button @click="edit(scope.row)" type="text" size="small">编辑</el-button>
            </template>
        </sys-table>
        
        <!-- 新建管理角色弹框 -->
        <div class="zll-dialog">
            <popout :title="type + ' · 角色权限'" :visible.sync="addDialog" v-if="addDialog" class="bigSize">
                <Add ref="add" slot="content" :type="type" @addForm="getFormData"></Add>
                <template slot="bottom">
                    <p class="zll-botton" @click="()=>{this.$refs.add.setFormData('addForm')}">提 交</p>
                </template>
            </popout>
        </div>
    </div>
</template>

<script>
    import Add from './Add'
    export default {
        data(){
            return {
                type: '',
                tableLoading:true, //table刷新
                searchInput1: '',
                searchInput2: '',
                tableData: [{
                    tableNum1: '部门',//部门
                    tableNum2: '角色',//角色
                    tableNum3: '',//权限
                    tableNum4: '',//状态
                }],
                tableHeader:[],
                addDialog: false, //角色弹框
                selectList: [],
            }
        },
        methods: {
             getTableList(){//获取表格数据
                this.tableLoading = true;
                setTimeout(()=>{
                    this.tableHeader =  [
                        {"columnValue": "tableNum1", "columnName": "部门", width: "100"},
                        {"columnValue": "tableNum2", "columnName": "角色", width: "100"},
                        {"columnValue": "tableNum3", "columnName": "权限"},
                        {"columnValue": "tableNum4", "columnName": "状态", width: "100"},
                    ]
                    this.tableData = JSON.parse(JSON.stringify(this.tableData))
                    this.tableLoading = false;
                },500)
            },
            addPower(){
                this.addDialog = true
                this.type = "新建"
            },
            getFormData(data){
                this.addDialog = false
            },
            edit(){ //管理
                this.addDialog = true
                this.type = "编辑"
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
        components: {
            Add,
        }
    }
</script>

<style lang="scss" scoped>
    @import "@/assets/style/SearchTop.scss";
    .Power{
        .leadOut{
            background: #e69c2d;
            color: #ffffff;
            position: relative;
            padding: 10px 10px 10px 20px;
            img {
                position: absolute;
                left: 7px;
            }
            &:hover {
                opacity: .8;
                transition: all .3s;
            }
        }
    }
    
</style>