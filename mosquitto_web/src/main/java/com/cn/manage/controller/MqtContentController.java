package com.cn.manage.controller;


import com.alibaba.fastjson.JSONObject;
import com.cn.manage.api.IMqtContentService;
import com.cn.manage.domain.MqtContent;
import com.cn.manage.domain.QueryForm;
import com.cn.manage.utils.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/mqt")
public class MqtContentController {

    @Autowired
    private IMqtContentService mqtContentService;

    @RequestMapping("/queryMqtContents")
    @ResponseBody
    public JsonResponse<Map<String,List<JSONObject>>> queryMqtContents(QueryForm queryForm) throws Exception {
        JsonResponse<Map<String,List<JSONObject>>> response = new JsonResponse<Map<String,List<JSONObject>>>();
        Map<String,List<JSONObject>> list  = mqtContentService.queryMqtContents(queryForm);
        response.setResult(list);
        response.setSuccess(true);
        return  response;
    }

    @RequestMapping("/addMqtContents")
    @ResponseBody
    public JsonResponse<Boolean> addMqtContents(MqtContent mqtContent) throws Exception {
        JsonResponse<Boolean> response = new JsonResponse<Boolean>();
        boolean result  = mqtContentService.addMqtContents(mqtContent);
        response.setSuccess(result);
        return  response;
    }

    @RequestMapping("/queryMqtContentsCounts")
    @ResponseBody
    public JsonResponse<Integer> queryMqtContentsCounts(MqtContent mqtContent) throws Exception {
        JsonResponse<Integer> response = new JsonResponse<Integer>();
        int count  = mqtContentService.queryMqtContentsCounts(mqtContent);
        response.setSuccess(true);
        response.setResult(count);
        return  response;
    }

}
