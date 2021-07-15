<template>
    <div class="Standard">
        <!-- 头部input搜索 -->
        <div class="Search_Top_Input">
            <div class="search_list" style="width: calc(100% - 100px) !important">
                <div class="input_flex">
                    <el-input clearable v-model="searchInput1" placeholder="标准编号"></el-input>
                </div>
                <div class="input_flex">
                    <el-input clearable v-model="searchInput2" placeholder="产品编码"></el-input>
                </div>
                <div class="input_flex">
                    <el-input clearable v-model="searchInput3" placeholder="产品名称"></el-input>
                </div>
                <div class="input_flex">
                    <el-select clearable v-model="searchInput4" placeholder="规格">
                        <el-option label="药用级" value="药用级"></el-option>
                        <el-option label="工业级" value="工业级"></el-option>
                    </el-select>
                </div>
                <div class="input_flex search">
                    <span class="zll-search">搜索</span>
                    <span class="zll-search-reset" @click="searchReset()">重置</span>
                </div>
            </div>
			<div class="addNew" style="width: 100px !important">
                <span @click="add()"><i class="el-icon-circle-plus-outline"></i> 新建标准</span>
			</div>
        </div>
        <!-- table -->
        <sys-table  
            :isMultipleSelection="false" 
            :tableData="tableData" 
            :tableLoading="tableLoading" 
            :tableHeader="tableHeader"
            :scopeWidth="150"
        >
            <template slot-scope="scope" slot="operate">
                <el-button @click="godetail(scope.row)" type="text" size="small">查看</el-button>
                <el-button @click="edit(scope.row)" type="text" size="small">编辑</el-button>
                <el-button @click="revise(scope.row)" type="text" size="small">修订</el-button>
            </template>
        </sys-table>

        <!-- 查看新建编辑弹框 -->
        <div class="zll-dialog">
            <popout :title="title +' · 质量标准'" :visible.sync="addDialog" v-if="addDialog" height="550px">
                <Add ref="add" slot="content" :title="title" @addForm="getFormData"></Add>
                <template slot="bottom">
                    <p class="zll-botton" v-if="title == '查看'" @click="addDialog = false">确 定</p>
                    <p class="zll-botton" v-else @click="()=>{this.$refs.add.setFormData('addForm')}">提 交</p>
                </template>
            </popout>
        </div>  
        <!-- 修订弹框 -->
        <div class="zll-dialog">
            <popout :title="title +' · 质量标准'" :visible.sync="reviseDialog" v-if="reviseDialog" class="revise_dialog">
                <Revise ref="add" slot="content" @addForm="getFormData"></Revise>
                <template slot="bottom">
                    <p class="zll-botton void" @click="()=>{this.$refs.add.setFormData('addForm')}">修 订</p>
                </template>
            </popout>
        </div>  
    </div>
</template>

<script>
    import Add from "./add"
    import Revise from "./revise"
    export default {
        data(){
            return {
                title: '',
                searchInput1: '',
                searchInput2: '',
                searchInput3: '',
                searchInput4: '',
                tableLoading:true, //table刷新
                tableData: [{
                    tableNum1: '标准编号', //标准编号
                    tableNum2: 'M1',//产品编码
                    tableNum3: '产品名称',//产品名称
                    tableNum4: '工业级',//规格
                    tableNum5: '',//补充说明
                }],
                tableHeader:[],
                addDialog: false,
                reviseDialog: false,
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
                        {"columnValue": "tableNum1", "columnName": "标准编号"},
                        {"columnValue": "tableNum2", "columnName": "产品编码"},
                        {"columnValue": "tableNum3", "columnName": "产品名称"},
                        {"columnValue": "tableNum4", "columnName": "规格", 'width': '100'},
                        {"columnValue": "tableNum5", "columnName": "补充说明"},
                    ]
                    this.tableData = JSON.parse(JSON.stringify(this.tableData))
                    this.tableLoading = false;
                },500)
            },
            getFormData(data) {
                this.addDialog = false
            },
            add() {//新建
                this.addDialog = true
                this.title = '新建'
            },
            godetail(row) {//查看
                this.addDialog = true
                this.title = '查看'
            },
            edit(row) {//编辑
                this.addDialog = true
                this.title = '编辑'
            },
            revise(row) {//修订
                this.reviseDialog = true
                this.title = '修订'
            },
            searchReset() { //重置搜索
                this.searchInput1 = "";
                this.searchInput2 = "";
                this.searchInput3 = "";
                this.searchInput4 = "";
                this.getTableList();
            },
        },
        mounted(){
            this.getTableList();//显示table
        },
        components: {
            Add, Revise
        }
    }
</script>

<style lang="scss" scoped>
    @import "@/assets/style/SearchTop.scss";
</style>