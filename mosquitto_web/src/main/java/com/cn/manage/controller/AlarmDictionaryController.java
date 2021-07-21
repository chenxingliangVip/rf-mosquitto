package com.cn.manage.controller;


import com.cn.manage.api.IAlarmDictionaryService;
import com.cn.manage.domain.AlarmDictionary;
import com.cn.manage.domain.QueryForm;
import com.cn.manage.utils.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/alarmDictionary")
public class AlarmDictionaryController {

    @Autowired
    private IAlarmDictionaryService alarmDictionaryService;

    @RequestMapping("/queryDictionaryList")
    @ResponseBody
    public JsonResponse<List<AlarmDictionary>> queryDictionaryList(QueryForm queryForm) throws Exception {
        JsonResponse<List<AlarmDictionary>> response = new JsonResponse<List<AlarmDictionary>>();
        List<AlarmDictionary> list  = alarmDictionaryService.queryDictionaryList(queryForm);
        response.setResult(list);
        response.setSuccess(true);
        return  response;
    }

    @RequestMapping("/addDictionary")
    @ResponseBody
    public JsonResponse<Boolean> addDictionary(AlarmDictionary dictionary) throws Exception {
        JsonResponse<Boolean> response = new JsonResponse<Boolean>();
        boolean result  = alarmDictionaryService.addDictionary(dictionary);
        response.setSuccess(result);
        return  response;
    }

    @RequestMapping("/updateDictionary")
    @ResponseBody
    public JsonResponse<Boolean> updateDictionary(AlarmDictionary dictionary) throws Exception {
        JsonResponse<Boolean> response = new JsonResponse<Boolean>();
        boolean result  = alarmDictionaryService.updateDictionary(dictionary);
        response.setSuccess(result);
        return  response;
    }

    @RequestMapping("/deleteDictionary")
    @ResponseBody
    public JsonResponse<Boolean> deleteDictionary(String id) throws Exception {
        JsonResponse<Boolean> response = new JsonResponse<Boolean>();
        boolean result  = alarmDictionaryService.deleteDictionary(id);
        response.setSuccess(result);
        return  response;
    }
}
