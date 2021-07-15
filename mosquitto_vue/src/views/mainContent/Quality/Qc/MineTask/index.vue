<template>
    <div class="MineTask">
        <!-- 头部input搜索 -->
        <div class="Search_Top_Input">
            <div class="search_list" style="width: 100% !important">
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
                <div class="input_flex">
                    <el-select clearable v-model="searchInput5" placeholder="规格">
                        <el-option label="药用级" value="药用级"></el-option>
                        <el-option label="工业级" value="工业级"></el-option>
                    </el-select>
                </div>
                <div class="input_flex">
                    <el-input clearable v-model="searchInput6" placeholder="检验号"></el-input>
                </div>
                <div class="input_flex search">
                    <span class="zll-search">搜索</span>
                    <span class="zll-search-reset" @click="searchReset()">重置</span>
                </div>
            </div>
        </div>
        <div class="input_sao">
            <div class="input_img"><img src="@/assets/img/saomiao.png"></div>
            <el-input clearable class="input_right" v-model="searchInput7" placeholder="请扫检验码录入"></el-input>
            <div style="clear: both"></div>
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
                <el-button @click="add(scope.row)" type="text" size="small">录入</el-button>
            </template>
        </sys-table>

        <!-- 查看弹框 -->
        <div class="zll-dialog">
            <popout title="录入 · QC检验结果" :visible.sync="addDialog" v-if="addDialog" height="550px">
                <Add ref="add" slot="content" @addForm="getFormData" ></Add>
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
        data(){
            return {
                searchInput1: '',
                searchInput2: '',
                searchInput3: '',
                searchInput4: '',
                searchInput5: '',
                searchInput6: '',
                searchInput7: '',
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
                    tableNum11: '检验中',//状态
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
                        {"columnValue": "tableNum2", "columnName": "阶段", 'width': '100'},
                        {"columnValue": "tableNum3", "columnName": "产品名称"},
                        {"columnValue": "tableNum4", "columnName": "规格", 'width': '100'},
                        {"columnValue": "tableNum5", "columnName": "申请人", 'width': '100'},
                        {"columnValue": "tableNum6", "columnName": "送样时间"},
                        {"columnValue": "tableNum7", "columnName": "检验号"},
                        {"columnValue": "tableNum8", "columnName": "检项数", 'width': '100', isSortable: true},
                        {"columnValue": "tableNum9", "columnName": "结果录入", 'width': '100'},
                        {"columnValue": "tableNum10", "columnName": "录入时间"},
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
            add(row){
                this.addDialog = true
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
    .MineTask {
        .input_sao {
            width: 200px;
            margin-bottom: 10px;
            .input_img {
                width: 26px;
                height: 26px;
                background: #34BFC6;
                float: left;
                img {
                    width: 20px;
                    height: 20px;  
                    margin: 3px;
                }
            }
            .input_right {
                width: calc(100% - 26px);
                float: right;
            }
        }
    }
</style>