package com.cn.manage.controller;


import com.cn.manage.api.IDictionaryService;
import com.cn.manage.api.ITopicService;
import com.cn.manage.domain.Dictionary;
import com.cn.manage.domain.QueryForm;
import com.cn.manage.domain.Topic;
import com.cn.manage.utils.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController {

    @Autowired
    private IDictionaryService dictionaryService;

    @RequestMapping("/queryDictionaryList")
    @ResponseBody
    public JsonResponse<List<Dictionary>> queryDictionaryList(QueryForm queryForm) throws Exception {
        JsonResponse<List<Dictionary>> response = new JsonResponse<List<Dictionary>>();
        List<Dictionary> list  = dictionaryService.queryDictionaryList(queryForm);
        response.setResult(list);
        response.setSuccess(true);
        return  response;
    }

    @RequestMapping("/addDictionary")
    @ResponseBody
    public JsonResponse<Boolean> addDictionary(Dictionary dictionary) throws Exception {
        JsonResponse<Boolean> response = new JsonResponse<Boolean>();
        boolean result  = dictionaryService.addDictionary(dictionary);
        response.setSuccess(result);
        return  response;
    }

    @RequestMapping("/updateDictionary")
    @ResponseBody
    public JsonResponse<Boolean> updateDictionary(Dictionary dictionary) throws Exception {
        JsonResponse<Boolean> response = new JsonResponse<Boolean>();
        boolean result  = dictionaryService.updateDictionary(dictionary);
        response.setSuccess(result);
        return  response;
    }

    @RequestMapping("/deleteDictionary")
    @ResponseBody
    public JsonResponse<Boolean> deleteDictionary(String id) throws Exception {
        JsonResponse<Boolean> response = new JsonResponse<Boolean>();
        boolean result  = dictionaryService.deleteDictionary(id);
        response.setSuccess(result);
        return  response;
    }
}
