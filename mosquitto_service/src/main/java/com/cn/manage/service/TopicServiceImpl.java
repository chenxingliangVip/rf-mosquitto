package com.cn.manage.service;

import com.cn.manage.api.ITopicService;
import com.cn.manage.dao.TopicMapper;
import com.cn.manage.domain.QueryForm;
import com.cn.manage.domain.Topic;
import com.cn.manage.domain.TopicExample;
import com.cn.manage.util.Constants;
import com.cn.manage.utils.CommonUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements ITopicService {

    @Autowired
    private TopicMapper topicMapper;

    @Override
    public List<Topic> queryTopics(QueryForm queryForm) {

        TopicExample example = new TopicExample();
        TopicExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(Constants.NORMAL_STATUS);
        if(StringUtils.isNotBlank(queryForm.getName())){
            criteria.andTopicNameEqualTo(queryForm.getName());
        }
        List<Topic> list = topicMapper.selectByExample(example);
        return list;
    }

    @Override
    public boolean addTopic(Topic topic) {
        String id = CommonUtil.generateRandomNum("topic-");
        topic.setId(id);
        int count = topicMapper.insertSelective(topic);
        return count > 0;
    }

    @Override
    public boolean deleteTopic(String topId) {
        int count = 0;
        if(StringUtils.isNotBlank(topId)){
            TopicExample example = new TopicExample();
            example.createCriteria().andIdEqualTo(topId);
            count = topicMapper.deleteByExample(example);
        }
        return count > 0;
    }

    @Override
    public boolean updateTopic(Topic topic) {
        TopicExample example = new TopicExample();
        return false;
    }
}
