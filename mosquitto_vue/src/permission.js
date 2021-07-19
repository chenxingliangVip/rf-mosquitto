import router from './router'
import { getToken } from '@/utils/auth' // 验权
import store from './store'
import { asyncRouterMap, constantRouterMap } from '@/router/index'
import {
    setTitle
} from '@/utils/util'
import { default as api } from "./utils/api"; // 设置浏览器头部标题

// permission judge function
function hasPermission(roles, permissionRoles) {
    if (roles.indexOf('admin') >= 0) return true // admin permission passed directly
    if (!permissionRoles) return true
    return roles.some(role => permissionRoles.indexOf(role) >= 0)
}
const whiteList = ['/Login'] // 不重定向白名单
router.beforeEach((to, from, next) => {
    // let allPermissionNarHead = {};
    // for (let k in constantRouterMap) {
    //     let router = constantRouterMap[k];
    //     if (router.meta && router.meta.permission) {
    //         allPermissionNarHead[router.path] = router.meta.permission;
    //     }
    //     if (router.children) {
    //         for (let child of router.children) {
    //             let r = router.path + "/" + child.path;
    //             if (child.meta && child.meta.permission) {
    //                 allPermissionNarHead[r] = child.meta.permission;
    //             }
    //         }

    //     }
    // }
    let user = localStorage.getItem('login')
    if (user) {
        user = JSON.parse(user);
        /* has token*/
        if (to.path == '/' || to.path == '') {
            next({ path: '/Login' })
        } else if (to.path === '/Login') {
            next()
        } else {
            api({
                url: "/mosquitto/permission/queryRolePermission",
                method: "post",
                params: { userAccount: user.userAccount }
            }).then(function (response) {
                let _permission = response.result;
                store.dispatch('user/setPermission', _permission || []);
                store.dispatch('permission/generateRoutes').then(() => { // 根据roles权限生成可访问的路由表
                    router.addRoutes(store.getters.addRouters) // 动态添加可访问路由表
                    let path = to.path;
                    let access = allPermissionNarHead[path];
                    next()
                });
                next();
            }).catch(function (resp) {
                next({ path: '/Login' })
            });
        }
        next();
    } else {
        if (whiteList.indexOf(to.path) !== -1) {
            next()
        } else {
            next('/Login')
        }
    }
})

router.afterEach(() => {
    setTimeout(() => {
        // const browserHeaderTitle = store.getters.browserHeaderTitle
        setTitle("数据采集系统")
    }, 0)
})
