<template>
    <div class="addProject UserAdd">
        <div class="addForm zll-form">
            <el-form :model="addForm" :rules="rules" ref="addForm" class="demo-ruleForm">
                <el-form-item class="formList" prop="addFormData1" label="部门：">
                    <el-input clearable class="input_right" placeholder="请输入部门" v-model="addForm.addFormData1" :disabled="disabled"></el-input>
                </el-form-item>
                <el-form-item class="formList" prop="addFormData2" label="角色：">
                    <el-input clearable class="input_right" placeholder="请输入角色：" v-model="addForm.addFormData2" :disabled="disabled"></el-input>
                </el-form-item>
            </el-form>
        </div>
        <div class="Table_body zll-table powerTable">
            <el-table :data="powerTable"
                      border style="width: 100%"
                      tooltip-effect="light"
                      :span-method="arraySpanMethod"
            >
                <el-table-column prop="index"  label="序号" width="50" :show-overflow-tooltip="true"></el-table-column>
                <el-table-column prop="tableNum1" label="主标题"  width="100"  :show-overflow-tooltip="true"></el-table-column>
                <el-table-column prop="tableNum2" label="副标题"  width="150" :show-overflow-tooltip="true"></el-table-column>
                <el-table-column label="内容" :show-overflow-tooltip="true">
                    <template slot-scope="{row}">
                        <el-checkbox-group v-model="check">
                            <el-checkbox :label="item.value" v-for="(item,index) in row.tableNum3"  :key="index" >{{item.title}}</el-checkbox>
                        </el-checkbox-group>
                    </template>
                </el-table-column>
            </el-table>
        </div>
    </div>
</template>
<script>
    export default {
        props: ['type'],
        data(){
            return {
                check: [],
                disabled: false,
                addForm:{
                    addFormData1: '',
                    addFormData2: '',
                },
                rules: {
                    addFormData1:[
                        { required: true, message: '请输入部门', trigger: 'blur' },
                    ],
                    addFormData2:[
                        { required: true, message: '请输入角色', trigger: 'blur' },
                    ],
                },
                powerTable:[],
                powerData: [{
                    mainTitle: '首页',
                    children: [{
                        subtitle: '',
                    }]
                    
                },{
                    mainTitle: '销售',
                    children: [{
                        subtitle: '',
                        content: [{
                            title: '新建',
                            value: '新建'
                        },{
                            title: '删除',
                            value: '删除'
                        },],
                    },] 
                },{
                    mainTitle: '运行',
                    children: [{
                        subtitle: '待排产',
                        content: [{
                            title: '新建',
                            value: '待排产新建'
                        }],
                    },{
                        subtitle: '已计划',
                        content: [{
                            title: '查看',
                            value: '已计划查看'
                        },{
                            title: '编辑',
                            value: '已计划编辑'
                        },{
                            title: '取消',
                            value: '已计划取消'
                        }],
                    },{
                        subtitle: '在生产',
                        content: [{
                            title: '查看',
                            value: '在生产查看'
                        }],
                    }]
                },{
                    mainTitle: '生产',
                    children: [{
                        subtitle: '启动生产',
                    },{
                        subtitle: '生产作业',
                    }]
                },{
                    mainTitle: '质量',
                    children: [{
                        subtitle: 'SRP监管',
                        content: [{
                            title: '查看',
                            value: 'SRP监管查看'
                        },{
                            title: '激活',
                            value: 'SRP监管激活'
                        }],
                    },{
                        subtitle: 'QC检验',
                        content: [{
                            title: '录入',
                            value: 'QC检验录入'
                        },],
                    },{
                        subtitle: '质量标准',
                        content: [{
                            title: '新建',
                            value: '质量标准新建'
                        },{
                            title: '查看',
                            value: '质量标准查看'
                        },{
                            title: '编辑',
                            value: '质量标准编辑'
                        },{
                            title: '修订',
                            value: '质量标准修订'
                        }],
                    },{
                        subtitle: '检验方法',
                        content: [{
                            title: '新建',
                            value: '检验方法新建'
                        },{
                            title: '查看',
                            value: '检验方法查看'
                        },{
                            title: '编辑',
                            value: '检验方法编辑'
                        },{
                            title: '修订',
                            value: '检验方法修订'
                        }],
                    }]
                },{
                    mainTitle: '仓库',
                    children: [{
                        subtitle: '入库',
                        content: [{
                            title: '查看',
                            value: '入库查看'
                        },{
                            title: '入库',
                            value: '入库入库'
                        }],
                    },{
                        subtitle: '统计',
                    }]
                },{
                    mainTitle: '看板',
                    children: [{
                        subtitle: '',
                    }]
                },{
                    mainTitle: '系统',
                    children: [{
                        subtitle: '参数管理',
                    },{
                        subtitle: '角色权限',
                    },{
                        subtitle: '用户管理',
                    },{
                        subtitle: '数据备份',
                    },{
                        subtitle: '系统日志',
                    }]
                }],
            }
        },
        methods: {
            tableList(){
                let i = 1;
                for (let _i of this.powerData) {
                    let rowSpan = false;
                    let j = 1;
                    for(let _j of _i.children){
                        let obj ={
                            index: i,
                            tableNum1: _i.mainTitle,
                            tableNum2: _j.subtitle,
                            tableNum3: [],
                            rowSpan: _i.children.length,
                        }
                        if(_j.content){
                            for(let _k of _j.content){
                                let child = {
                                    title: _k.title,
                                    value: _k.value,
                                    rowSpan: _j.content.length,
                                };
                                obj.tableNum3.push(child);
                            }
                        }
                        if(rowSpan){
                            obj.rowSpan = 0;
                        }
                        j++;
                        rowSpan = true;
                        this.powerTable.push(obj);
                    }
                    i++;
                }
            },
            arraySpanMethod({ row, column, rowIndex, columnIndex }) {
                if (columnIndex < 2) {
                    if (row.rowSpan === 0) {
                        return [0, 0]
                    } else {
                        return [row.rowSpan, 1]
                    }
                }
            },
            setFormData(formName){
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        this.$emit('addForm',this.addForm)
                    }else {
                        return false
                    }
                })
            },
            disabledFun(){
                if(this.type == "新建"){
                    this.disabled = false
                }else{
                    this.disabled = true
                }
            }
        },
        mounted(){
            this.disabledFun()
            this.tableList()
            console.log(this.powerTable)
        }
    }
</script>
<style lang="scss" scoped>
    @import "@/assets/style/dialog.scss";
    .UserAdd {
        .addForm {
            width: 50%;
        }
        .zll-table {
            margin-top: 15px;
        }
    }
    
</style>