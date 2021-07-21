package com.cn.manage.api;

import com.cn.manage.domain.QueryForm;
import com.cn.manage.domain.Topic;

import java.util.List;

public interface ITopicService {

    List<Topic> queryTopics(QueryForm queryForm);

    boolean addTopic(Topic topic);

    boolean deleteTopic(String topId);

    boolean updateTopic(Topic topic);
}
