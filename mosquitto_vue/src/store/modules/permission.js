import page from '../../router/page'

const state = {
  addRoutes: [],
  routes: []
}

const mutations = {
  SET_ROUTES: (state, routes) => {
    state.routes = routes;
    state.addRoutes = routes;
  }
}

const actions = {
  generateRoutes({ commit }, roles) {
    return new Promise(resolve => {
      commit('SET_ROUTES', page);
      resolve()
    })
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}
