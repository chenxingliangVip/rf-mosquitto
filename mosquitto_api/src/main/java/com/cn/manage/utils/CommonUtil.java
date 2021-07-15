package com.cn.manage.utils;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CommonUtil {

    public static String generateRandomNum(String flag){
        String uuid = UUID.randomUUID().toString().replaceAll("-",flag);
        return uuid;
    }

    public static String generateMethodCode(List<String> existCode) throws Exception{
        int max = 0;
        for(String str:existCode){
            String fourStr = str.replace("SOP","");
            int num = Integer.parseInt(fourStr);
            max = max >num?max:num;
        }
        max = max+1;
        String code = "SOP"+max;
        return code;
    }

    public static String generateFileName(String originalFilename){
        Date date = new Date();
        long time = date.getTime();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName = originalFilename.substring(0,originalFilename.lastIndexOf("."))+"-"+time+suffix;
        return fileName;
    }

    public static  List<String> sortDataStr(List<String> list){
        List<String> collect = list.stream().sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                try {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date d1 = simpleDateFormat.parse(o1);
                    Date d2 = simpleDateFormat.parse(o2);
                    return d1.compareTo(d2);
                }catch (Exception e){

                }
                return 0;
            }
        }).collect(Collectors.toList());
        return collect;
    }

    public static  List<String> sortStr(List<String> list){
        List<String> collect = list.stream().sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                try {
                    return o1.compareTo(o2);
                }catch (Exception e){

                }
                return 0;
            }
        }).collect(Collectors.toList());
        return collect;
    }

    public static String getStrTime(Date date,String format){
        String strTime = "";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        if(date != null){
            try {
                strTime = simpleDateFormat.format(date);
            }catch (Exception e){

            }
        }
        return strTime;
    }

}
