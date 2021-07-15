<template>
    <div class="WaitTask">
        <!-- 头部input搜索 -->
        <div class="Search_Top_Input">
            <div class="search_list" style="width: calc(100% - 100px) !important">
                <div class="input_flex">
                    <el-input clearable v-model="searchInput1" placeholder="批次号"></el-input>
                </div>
                <div class="input_flex">
                    <el-input clearable v-model="searchInput2" placeholder="申请人"></el-input>
                </div>
                <div class="input_flex">
                    <el-select clearable v-model="searchInput3" placeholder="阶段">
                        <el-option label="M1" value="M1"></el-option>
                    </el-select>
                </div>
                <div class="input_flex">
                    <el-input clearable v-model="searchInput4" placeholder="产品名称"></el-input>
                </div>
                <div class="input_flex search">
                    <el-select clearable v-model="searchInput5" placeholder="规格">
                        <el-option label="药用级" value="药用级"></el-option>
                        <el-option label="工业级" value="工业级"></el-option>
                    </el-select>
                </div>
                <div class="input_flex">
                    <el-input clearable v-model="searchInput6" placeholder="检验号"></el-input>
                </div>
                <div class="input_flex">
                    <span class="zll-search">搜索</span>
                    <span class="zll-search-reset" @click="searchReset()">重置</span>
                </div>
            </div>
			<div class="addNew" style="width: 100px !important">
                <span @click="batchCancal" class="warning"><i class="el-icon-edit-outline"></i> 批量领检</span>
			</div>
        </div>
        <!-- table -->
        <sys-table  
            :isMultipleSelection="true" class="start"
            :tableData="tableData" 
            :tableLoading="tableLoading" 
            :tableHeader="tableHeader"
            :scopeWidth="100"
            @getSelection="getSelection"
        >
            <template slot-scope="scope" slot="operate">
                <el-button @click="add(scope.row)" size="small" type="warning" v-if="scope.row.state == '待领检'">
                    <i class="el-icon-edit-outline"></i> 领检
                </el-button>
                <el-button size="small" type="info" plain disabled v-else>
                    <i class="el-icon-edit-outline"></i> 领检
                </el-button>
            </template>
        </sys-table>

        <!-- 查看弹框 -->
        <div class="zll-dialog">
            <popout title="QC领检 · 阶段样品" :visible.sync="addDialog" v-if="addDialog" height="550px">
                <Add ref="add"  slot="content" @addForm="getFormData" ></Add>
                <template slot="bottom">
                    <p class="zll-botton" @click="()=>{this.$refs.add.setFormData('addForm')}">领 检</p>
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
                searchInput1: '',
                searchInput2: '',
                searchInput3: '',
                searchInput4: '',
                searchInput5: '',
                searchInput6: '',
                tableLoading:true, //table刷新
                tableData: [{
                    tableNum1: '批次号', //批次号
                    tableNum2: 'M1',//阶段
                    tableNum3: '产品名称',//产品名称
                    tableNum4: '工业级',//规格
                    tableNum5: '',//申请人
                    tableNum6: '',//送样时间
                    tableNum7: '',//检验号
                    tableNum8: 11,//检项数
                    tableNum9: '',//结果录入
                    tableNum10: '',//录入时间
                    state: '待领检'
                }, {
                    tableNum1: '批次号', //批次号
                    tableNum2: 'M1',//阶段
                    tableNum3: '产品名称',//产品名称
                    tableNum4: '工业级',//规格
                    tableNum5: '',//申请人
                    tableNum6: '',//送样时间
                    tableNum7: '',//检验号
                    tableNum8: 11,//检项数
                    tableNum9: '',//结果录入
                    tableNum10: '',//录入时间
                    state: '已领检'
                }],
                tableHeader:[],
                selectList: [],
                addDialog: false,
            }
        },
        methods: {
            getTableList(){//获取表格数据
                this.tableLoading = true;
                setTimeout(()=>{
                    this.tableHeader =  [
                        {"columnValue": "tableNum1", "columnName": "批次号"},
                        {"columnValue": "tableNum2", "columnName": "阶段", 'width': '100'},
                        {"columnValue": "tableNum3", "columnName": "产品名称"},
                        {"columnValue": "tableNum4", "columnName": "规格", 'width': '100'},
                        {"columnValue": "tableNum5", "columnName": "申请人", 'width': '100'},
                        {"columnValue": "tableNum6", "columnName": "送样时间"},
                        {"columnValue": "tableNum7", "columnName": "检验号"},
                        {"columnValue": "tableNum8", "columnName": "检项数", 'width': '100', isSortable: true},
                        {"columnValue": "tableNum9", "columnName": "结果录入", 'width': '100'},
                        {"columnValue": "tableNum10", "columnName": "录入时间"},
                    ]
                    this.tableData = JSON.parse(JSON.stringify(this.tableData))
                    this.tableLoading = false;
                },500)
            },
            getFormData(data) {
                this.addDialog = false
            },
            add(row){
                this.addDialog = true
            },
            batchCancal(){//批量取消
                if(this.selectList.length <1 ){
                    this.$message.warning("至少选择一列数据！");
                }else{
                    for (let i = 0; i < this.tableData.length; i++) {
                        for (let j = 0; j < this.selectList.length; j++) {
                            this.addDialog = true
                        }
                    }
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