import colorDataList from '@/components/colorPopout/colorData'
const state = {
  leftMenuMin: false, //左侧菜单最小化
  //主题数据
  colorData: localStorage.getItem('colorData') ? JSON.parse(localStorage.getItem('colorData')) : colorDataList[0],
};


const mutations = {
  SET_leftMenuMin(state, val) {
    state.leftMenuMin = val;
  },
  setColorData(state, data) {//设置主题数据
    localStorage.setItem('colorData', JSON.stringify(data));
    state.colorData = data;
  },
};

const actions = {

};

export default {
  namespaced: true,
  state,
  mutations,
  actions
};
