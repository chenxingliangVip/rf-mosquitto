const getters = {
  user: state => state.user.userInfo,
  permission_routes: state => state.permission.routes,
  addRouters: state => state.permission.addRoutes,
}
export default getters
