<template>
    <div class="ParamManage">
        <div class="list" v-for="(item, index) in paramList" :key="index"
            @mouseenter="showActive(index,1)"
            @mouseleave="showActive(index,0)"
            @click="edit(item)"
        >
            <img v-show="item.active === 0" :src="item.icon" />
            <img v-show="item.active === 1" :src="item.hovericon" />
            <p class="name">{{ item.name }}</p>
        </div>
        <div style="clear: both"></div>

        <div class="zll-dialog">
            <popout :title="title" :visible.sync="addDialog" v-if="addDialog" :class="{ 'minSize' :  title == '初始密码','bigSize' : title == 'LOGO设定'}">
                <cp-add ref="add" slot="content" @addForm="getFormData" v-if="title == '产品管理'"></cp-add>
                <gy-add ref="add" slot="content" @addForm="getFormData" v-if="title == '工艺规程'"></gy-add>
                <cx-add ref="add" slot="content" @addForm="getFormData" v-if="title == '产线设定'"></cx-add>
                <sc-add ref="add" slot="content" @addForm="getFormData" v-if="title == '生产组'"></sc-add>
                <bc-add ref="add" slot="content" @addForm="getFormData" v-if="title == '班次设定'"></bc-add>
                <jx-add ref="add" slot="content" @addForm="getFormData" v-if="title == '检项名称'"></jx-add>
                <password-add ref="add" slot="content" @addForm="getFormData" v-if="title == '初始密码'"></password-add>
                <logo-add ref="add" slot="content" @addForm="getFormData" v-if="title == 'LOGO设定'"></logo-add>
                <template slot="bottom">
                    <p class="zll-botton" @click="()=>{this.$refs.add.setFormData('addForm')}">提 交</p>
                </template>
            </popout>
        </div>
    </div>
</template>

<script>
import cpAdd from './cp'
import gyAdd from './gy'
import cxAdd from './chanxian'
import scAdd from './shengchan'
import bcAdd from './banci'
import jxAdd from './jianxiang'
import passwordAdd from './passwordAdd'
import logoAdd from './logoAdd'
export default {
    data() {
        return {
            title: '',
            paramList: [
                {
                    name: "产品管理",
                    icon: require("@/assets/img/chanpin.png"),
                    hovericon: require("@/assets/img/chanpin2.png"),
                    active: 0,
                }, {
                    name: "工艺规程",
                    icon: require("@/assets/img/gongyi.png"),
                    hovericon: require("@/assets/img/gongyi2.png"),
                    active: 0,
                }, {
                    name: "产线设定",
                    icon: require("@/assets/img/chanxian.png"),
                    hovericon: require("@/assets/img/chanxian2.png"),
                    active: 0,
                }, {
                    name: "生产组",
                    icon: require("@/assets/img/shengchan.png"),
                    hovericon: require("@/assets/img/shengchan2.png"),
                    active: 0,
                }, {
                    name: "班次设定",
                    icon: require("@/assets/img/banci.png"),
                    hovericon: require("@/assets/img/banci2.png"),
                    active: 0,
                }, {
                    name: "检项名称",
                    icon: require("@/assets/img/jianxiang.png"),
                    hovericon: require("@/assets/img/jianxiang2.png"),
                    active: 0,
                }, {
                    name: "LOGO设定",
                    icon: require("@/assets/img/logogl.png"),
                    hovericon: require("@/assets/img/logogl2.png"),
                    active: 0,
                }, {
                    name: "初始密码",
                    icon: require("@/assets/img/initialpassword.png"),
                    hovericon: require("@/assets/img/initialpassword2.png"),
                    active: 0,
                }
            ],
            addDialog: false,
        };
    },
    methods: {
        showActive(index, active) {
            this.paramList[index].active = active
        },
        edit(val) {
            this.title = val.name
            this.addDialog = true
        },
        getFormData(data){
            console.log(data)
            this.addDialog = false
        },
    },
    components: {
        cpAdd, gyAdd, cxAdd, scAdd, logoAdd, passwordAdd, bcAdd, jxAdd
    }
};
</script>

<style lang="scss" scoped>
.ParamManage {
    margin-top: 150px;
    .list {
        float: left;
        cursor: pointer;
        width: 100px;
        margin: 15px 20px;
        border-radius: 15px;
        padding: 10px 0;
        img {
            width: 50px;
            height: 50px;
            display: inherit;
            margin: 0 auto;
        }
        .name {
            margin-top: 10px;
            text-align: center;
        }
        &:hover {
            box-shadow: 0 0 10px #ccc;
            transition: all .3s;
            .name {
                color: #e26835;
            }
        }
    }
}
</style>