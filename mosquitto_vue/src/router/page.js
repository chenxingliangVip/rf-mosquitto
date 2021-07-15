import FirstPage from '@/views/mainContent/Firstpage/Index' //首页
import SalePage from '@/views/mainContent/SalePage//Index' //销售
import RunPage from '@/views/mainContent/RunPage/Index' //运行
import StartProduct from '@/views/mainContent/PD/StartProduct/Index' //生产——启动生产
import ProductWork from '@/views/mainContent/PD/ProductWork/Index' //生产——生产作业
import Srp from '@/views/mainContent/Quality/Srp/Index' //质量——SRP监管
import Qc from '@/views/mainContent/Quality/Qc/Index' //质量——Qc检验
import Standard from '@/views/mainContent/Quality/Standard/Index' //质量——质量标准
import TestMethod from '@/views/mainContent/Quality/TestMethod/Index' //质量——检验方法
import Instore from '@/views/mainContent/Storage/Instore/Index' //仓库——入库
import Info from '@/views/mainContent/Storage/Info/Index' //仓库——统计
import Statistics from '@/views/BigScreen/Statistics/Index' //看板——生产信息统计表
import User from '@/views/mainContent/System/User/Index' //系统——用户管理
import Power from '@/views/mainContent/System/Power/Index' //系统——角色管理
import ParamManage from '@/views/mainContent/System/ParamManage/Index' //系统——参数管理
import DataCopy from '@/views/mainContent/System/DataCopy/Index' //系统——数据备份
import SystemLog from '@/views/mainContent/System/SystemLog/Index' //系统——系统日志
import Send from '@/views/mainContent/System/Send/Index' //系统——消息发布

// **************登录后访问的路由**********
export default [
    {
        path: 'FirstPage',
        name: 'FirstPage',
        meta: {title: '首页'},
        component: FirstPage
    }, {
        path: 'SalePage',
        name: 'SalePage',
        meta: {title: '销售'},
        component: SalePage
    }, {
        path: 'RunPage',
        name: 'RunPage',
        meta: {title: '运行'},
        component: RunPage
    }, {
        path: 'StartProduct',
        name: 'StartProduct',
        meta: {title: '启动生产'},
        component: StartProduct
    }, {
        path: 'ProductWork',
        name: 'ProductWork',
        meta: {title: '生产作业'},
        component: ProductWork
    }, {
        path: 'Srp',
        name: 'Srp',
        meta: {title: 'SRP监管'},
        component: Srp
    }, {
        path: 'Qc',
        name: 'Qc',
        meta: {title: 'QC检验'},
        component: Qc
    }, {
        path: 'Standard',
        name: 'Standard',
        meta: {title: '质量标准'},
        component: Standard
    }, {
        path: 'TestMethod',
        name: 'TestMethod',
        meta: {title: '检验方法'},
        component: TestMethod
    }, {
        path: 'Instore',
        name: 'Instore',
        meta: {title: '入库'},
        component: Instore
    }, {
        path: 'Info',
        name: 'Info',
        meta: {title: '统计'},
        component: Info
    }, 
    // {
    //     path: 'Statistics',
    //     name: 'Statistics',
    //     meta: {title: '生产信息统计表'},
    //     component: Statistics
    // }, 
    {
        path: 'User',
        name: 'User',
        meta: {title: '用户管理'},
        component: User
    }, {
        path: 'Power',
        name: 'Power',
        meta: {title: '角色管理'},
        component: Power
    }, {
        path: 'ParamManage',
        name: 'ParamManage',
        meta: {title: '参数管理'},
        component: ParamManage
    }, {
        path: 'DataCopy',
        name: 'DataCopy',
        meta: {title: '数据备份'},
        component: DataCopy
    }, {
        path: 'SystemLog',
        name: 'SystemLog',
        meta: {title: '系统日志'},
        component: SystemLog
    }, {
        path: 'Send',
        name: 'Send',
        meta: {title: '消息发布'},
        component: Send
    }
]
