package com.cn.manage.util;

import com.cn.manage.domain.Deptment;
import com.cn.manage.utils.CollectionsUtil;
import com.google.common.collect.Lists;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.util.ArrayList;
import java.util.List;

public class ConvertTree {

    /**
     * 把列表转换为树结构
     *
     * @param originalList 原始list数据
     * @param keyName 作为唯一标示的字段名称
     * @return 组装后的集合
     */
    public static <T> List<T> getTree(List<T> originalList, String keyName) throws Exception {
        String parentFieldName = "pId";
        String childrenFieldName = "children";

        // 获取根节点，即找出父节点为空的对象
        List<T> topList = new ArrayList<>();
        for (int i = 0; i < originalList.size(); i++) {
            T t = originalList.get(i);
            String parentId = BeanUtils.getProperty(t, parentFieldName);
            if (StringUtils.isBlank(parentId)) {
                topList.add(t);
            }
        }

        // 将根节点从原始list移除，减少下次处理数据
        originalList.removeAll(topList);

        // 递归封装树
        fillTree(topList, originalList, keyName, parentFieldName, childrenFieldName);

        return topList;
    }

    public static <T> void fillTree(List<T> parentList, List<T> originalList, String keyName, String parentFieldName, String childrenFieldName) throws Exception {
        for (int i = 0; i < parentList.size(); i++) {
            List<T> children = fillChildren(parentList.get(i), originalList, keyName, parentFieldName, childrenFieldName);
            if (children.isEmpty()) {
                continue;
            }
            originalList.removeAll(children);
            fillTree(children, originalList, keyName, parentFieldName, childrenFieldName);
        }
    }

    /**
     * 封装子对象
     *
     * @param parent 父对象
     * @param originalList 待处理对象集合
     * @param keyName 作为唯一标示的字段名称
     * @param parentFieldName 模型中作为parent字段名称
     * @param childrenFieldName 模型中作为children的字段名称
     */
    public static <T> List<T> fillChildren(T parent, List<T> originalList, String keyName, String parentFieldName, String childrenFieldName) throws Exception {
        List<T> childList = new ArrayList<>();
        String parentId = BeanUtils.getProperty(parent, keyName);
        for (int i = 0; i < originalList.size(); i++) {
            T t = originalList.get(i);
            String childParentId = BeanUtils.getProperty(t, parentFieldName);
            if (parentId.equals(childParentId)) {
                childList.add(t);
            }
        }
        if (!childList.isEmpty()) {
            FieldUtils.writeDeclaredField(parent, childrenFieldName, childList, true);
        }
        return childList;
    }

    public static List<String> getAllChildrenNodes(String originId,List<Deptment> deptmentList){
        List<String>deptIds = Lists.newArrayList();
        List<Deptment> children = Lists.newArrayList();
        findComputeDept(originId,children,deptmentList);
        if(CollectionsUtil.isNotEmpty(children)){
            getChildrenNodes(deptIds,children);
        }
        deptIds.add(originId);
        return deptIds;
    }




    private static void findComputeDept(String originId,List<Deptment> childrenDept,List<Deptment> deptmentList){
        if(CollectionsUtil.isEmpty(deptmentList)){
            return;
        }
        for(Deptment deptment :deptmentList){
            if(StringUtils.equals(deptment.getId(),originId)){
                if(CollectionsUtil.isNotEmpty(deptment.getChildren())){
                    childrenDept.addAll(deptment.getChildren());
                }
                return;
            }
            findComputeDept(originId,childrenDept,deptment.getChildren());
        }
    }


    private static void getChildrenNodes(List<String> deptIds,List<Deptment> deptmentList){
        if(CollectionsUtil.isEmpty(deptmentList)){
            return;
        }
        for(Deptment deptment :deptmentList){
            deptIds.add(deptment.getId());
            getChildrenNodes(deptIds,deptment.getChildren());
        }
    }
}
