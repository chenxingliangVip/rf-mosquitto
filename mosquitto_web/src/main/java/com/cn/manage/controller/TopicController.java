package com.cn.manage.controller;


import com.cn.manage.api.ITopicService;
import com.cn.manage.domain.QueryForm;
import com.cn.manage.domain.Topic;
import com.cn.manage.utils.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private ITopicService topicService;

    @RequestMapping("/queryTopics")
    @ResponseBody
    public JsonResponse<List<Topic>> queryTopics(QueryForm queryForm) throws Exception {
        JsonResponse<List<Topic>> response = new JsonResponse<List<Topic>>();
        List<Topic> list  = topicService.queryTopics(queryForm);
        response.setResult(list);
        response.setSuccess(true);
        return  response;
    }

    @RequestMapping("/addTopics")
    @ResponseBody
    public JsonResponse<Boolean> addTopics(Topic topic) throws Exception {
        JsonResponse<Boolean> response = new JsonResponse<Boolean>();
        boolean result  = topicService.addTopic(topic);
        response.setSuccess(result);
        return  response;
    }

    @RequestMapping("/updateTopic")
    @ResponseBody
    public JsonResponse<Boolean> updateTopic(Topic topic) throws Exception {
        JsonResponse<Boolean> response = new JsonResponse<Boolean>();
        boolean result  = topicService.updateTopic(topic);
        response.setSuccess(result);
        return  response;
    }

    @RequestMapping("/deleteTopic")
    @ResponseBody
    public JsonResponse<Boolean> deleteTopic(String topId) throws Exception {
        JsonResponse<Boolean> response = new JsonResponse<Boolean>();
        boolean result  = topicService.deleteTopic(topId);
        response.setSuccess(result);
        return  response;
    }
}
