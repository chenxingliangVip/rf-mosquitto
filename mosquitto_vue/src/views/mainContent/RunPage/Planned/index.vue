<template>
    <div class="Planned">
        <!-- 头部input搜索 -->
        <div class="Search_Top_Input">
            <div class="search_list" style="width: calc(100% - 100px) !important">
                <div class="input_flex">
                    <el-select clearable v-model="searchInput1" placeholder="计划人">
                        <el-option label="张三" value="张三"></el-option>
                    </el-select>
                </div>
                <div class="input_flex">
                    <el-select clearable v-model="searchInput2" placeholder="产线">
                        <el-option label="T1" value="T1"></el-option>
                        <el-option label="T2" value="T2"></el-option>
                    </el-select>
                </div>
                <div class="input_flex">
                    <el-input clearable v-model="searchInput3" placeholder="产品名称"></el-input>
                </div>
                <div class="input_flex">
                    <el-input clearable v-model="searchInput4" placeholder="产品编码"></el-input>
                </div>
                <div class="input_flex">
                    <el-select clearable v-model="searchInput5" placeholder="规格">
                        <el-option label="药用级" value="药用级"></el-option>
                        <el-option label="工业级" value="工业级"></el-option>
                    </el-select>
                </div>
                <div class="input_flex">
                    <el-select clearable v-model="searchInput6" placeholder="状态">
                        <el-option label="待审" value="待审"></el-option>
                        <el-option label="通过" value="通过"></el-option>
                        <el-option label="驳回" value="驳回"></el-option>
                        <el-option label="已取消" value="已取消"></el-option>
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
			<div class="addNew" style="width: 100px !important">
                <span class="delete" @click="batchCancal"><i class="el-icon-circle-close"></i> 批量取消</span>
			</div>
        </div>
        <!-- table -->
        <sys-table  
            :isMultipleSelection="true" 
            :tableData="tableData" 
            :tableLoading="tableLoading" 
            :tableHeader="tableHeader"
            :scopeWidth="150"
            @getSelection="getSelection"
        >
            <template slot-scope="scope" slot="operate">
                <el-button @click="goDetail(scope.row)" type="text" size="small">查看</el-button>
                <el-button @click="edit(scope.row)" type="text" size="small">编辑</el-button>
                <el-button v-if="scope.row.tableNum11 !== '待审' && scope.row.tableNum11 !== '已取消'" @click="cancal(scope.row)" type="text" size="small">取消</el-button>
            </template>
        </sys-table>

        <!-- 查看弹框 -->
        <div class="zll-dialog">
            <popout :title="title + ' · 排产计划'" :visible.sync="addDialog" v-if="addDialog" class="gantt">
                <Add ref="add"  slot="content" :titleTxt="title" @addForm="getFormData" ></Add>
                <template slot="bottom">
                    <p class="zll-botton" v-if="title != '查看'" @click="()=>{this.$refs.add.setFormData('addForm')}">提 交</p>
                    <p class="zll-botton" v-else @click="addDialog = false">确 定</p>
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
                searchInput6: '',
                searchInput7: '',
                tableLoading:true, //table刷新
                tableData: [{
                    tableNum1: '计划日期', //计划日期
                    tableNum2: '计划人',//计划人
                    tableNum3: '2',//关联订单
                    tableNum4: 'T1',//产线
                    tableNum5: '产品名称',//产品名称
                    tableNum6: '11123',//产品编码
                    tableNum7: '工业级',//产品规格
                    tableNum8: 11,//批产量
                    tableNum9: '开始日期',//开始日期
                    tableNum10: '结束日期',//结束日期
                    tableNum11: '待审',//状态
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
                        {"columnValue": "index", "columnName": "序号", 'width': '50'},
                        {"columnValue": "tableNum1", "columnName": "计划日期"},
                        {"columnValue": "tableNum2", "columnName": "计划人"},
                        {"columnValue": "tableNum3", "columnName": "关联订单"},
                        {"columnValue": "tableNum4", "columnName": "产线", 'width': '50px' },
                        {"columnValue": "tableNum5", "columnName": "产品名称"},
                        {"columnValue": "tableNum6", "columnName": "产品编码"},
                        {"columnValue": "tableNum7", "columnName": "产品规格"},
                        {"columnValue": "tableNum8", "columnName": "批产量", 'width': '100', isSortable: true},
                        {"columnValue": "tableNum9", "columnName": "开始日期"},
                        {"columnValue": "tableNum10", "columnName": "结束日期"},
                        {"columnValue": "tableNum11", "columnName": "状态", 'width': '100'},
                    ]
                    this.tableData = JSON.parse(JSON.stringify(this.tableData))
                    this.tableLoading = false;
                },500)
            },
            getFormData(data) {
                console.log(data)
                this.addDialog = false
            },
            edit(row) {
                this.addDialog = true
                this.title = '编辑'
            },
            goDetail(row){
                this.addDialog = true
                this.title = '查看'
            },
            cancal(row) {
                this.$confirm('确定取消计划？', '提示', {       
                    distinguishCancelAndClose: true,
                    cancelButtonText: '关闭',
                    confirmButtonText: '确定',
                }).then(() => {
                    row.tableNum8 = '已取消'
                    this.$message.success("已取消计划")
                    this.getTableList()
                }).catch(() => {
                        
                });
            },
            batchCancal(){//批量取消
                if(this.selectList.length <1 ){
                    this.$message.warning("至少选择一列数据！");
                }else{
                    for (let i = 0; i < this.tableData.length; i++) {
                        for (let j = 0; j < this.selectList.length; j++) {
                            if(this.selectList[j].tableNum11 == '待审' || this.selectList[j].tableNum11 == '已取消') {
                                this.$message.error("仅通过或驳回的计划可取消")
                                return false
                            }
                            if( this.tableData[i].index == this.selectList[j].index){
                                this.$confirm('确定取消计划？', '提示', {       
                                    distinguishCancelAndClose: true,
                                    cancelButtonText: '关闭',
                                    confirmButtonText: '确定',
                                }).then(() => {
                                    this.$message.success("已取消计划")
                                    this.getTableList()
                                }).catch(() => {
                                        
                                });
                            }
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
                this.searchInput7 = "";
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