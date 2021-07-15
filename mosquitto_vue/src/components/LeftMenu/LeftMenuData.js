//左侧菜单数据
export default [
    {
        name: 'FirstPage',//路由name
        title: '首页',
        icon: 'el-icon-s-home'
    }, {
        title: '销售',
        icon: 'el-icon-document-copy',
        name: 'SalePage',
    }, {
        title: '运行',
        icon: 'el-icon-connection',
        name: 'RunPage',//路由name
    }, {
        title: '生产',
        icon: 'el-icon-printer',
        children: [ //子菜单
            {
                name: 'StartProduct',//路由name
                title: '启动生产',
            }, {
                name: 'ProductWork',//路由name
                title: '生产作业',
            }
        ]
    }, {
        title: '质量',
        icon: 'el-icon-s-data',
        children: [ //子菜单
            {
                name: 'Srp',//路由name
                title: 'SRP监管',
            }, {
                name: 'Qc',//路由name
                title: 'QC检验',
            }, {
                name: 'Standard',//路由name
                title: '质量标准',
            }, {
                name: 'TestMethod',//路由name
                title: '检验方法',
            }
        ]
    }, {
        title: '仓库',
        icon: 'el-icon-coin',
        children: [ //子菜单
            {
                name: 'Instore',//路由name
                title: '入库',
            }, {
                name: 'Info',//路由name
                title: '统计',
            }
        ]
    }, {
        title: '看板',
        icon: 'el-icon-monitor',
        children: [ //子菜单
            {
                name: 'Statistics',//路由name
                title: '生产信息统计表',
            }, {
                name: 'ProductLine',//路由name
                title: '产线实时看板',
            },
        ]
    }, {
        title: '系统',
        icon: 'el-icon-setting',
        children: [ //子菜单
            // {
            //     name: 'Send',//路由name
            //     title: '消息发布',
            // }, 
            {
                name: 'ParamManage',//路由name
                title: '参数管理',
            }, {
                name: 'Power',//路由name
                title: '角色权限',
            }, {
                name: 'User',//路由name
                title: '用户管理',
            },  {
                name: 'DataCopy',//路由name
                title: '数据备份',
            }, {
                name: 'SystemLog',//路由name
                title: '系统日志',
            }
        ]
    },
]
