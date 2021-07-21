
const state = {
  outParam:{},
};

const mutations = {
  SET_OUT_PARAM(state,param){
    state.outParam = param;
  },
};

const actions = {
  setOutParam({commit},param) {
    return new Promise(resolve => {
      commit('SET_OUT_PARAM',param);
      resolve()
    })
  },
};

export default {
  namespaced: true,
  state,
  mutations,
  actions
};
