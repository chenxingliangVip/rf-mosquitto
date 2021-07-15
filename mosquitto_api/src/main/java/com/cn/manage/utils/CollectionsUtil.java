package com.cn.manage.utils;

import java.util.Collection;

public class CollectionsUtil {
    public static boolean isEmpty(Collection collection){
        return !isNotEmpty(collection);
    }

    public static boolean isNotEmpty(Collection collection){
        boolean isNotEmpty = false;
        if(null != collection && collection.size() > 0){
            isNotEmpty = true;
        }
        return isNotEmpty;
    }


}
