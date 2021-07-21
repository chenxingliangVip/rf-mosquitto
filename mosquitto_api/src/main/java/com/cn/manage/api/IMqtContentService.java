package com.cn.manage.api;

import com.alibaba.fastjson.JSONObject;
import com.cn.manage.domain.MqtContent;
import com.cn.manage.domain.QueryForm;

import javax.management.Query;
import java.util.List;
import java.util.Map;

public interface IMqtContentService {

    Map<String,List<JSONObject>> queryMqtContents(QueryForm queryForm);

    boolean addMqtContents(MqtContent mqtContent);

}
