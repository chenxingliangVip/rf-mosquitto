package com.cn.manage;

import javax.servlet.ServletContext;

import com.cn.manage.domain.QueryForm;
import com.cn.manage.domain.Topic;
import com.cn.manage.service.TopicServiceImpl;
import com.cn.manage.util.ClientMQTT;
import com.cn.manage.utils.CollectionsUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import java.util.List;

@Component
public class StartupListener implements ApplicationListener<ContextRefreshedEvent> {

    private void action(ApplicationContext ctx) throws BeansException {
        TopicServiceImpl topicService = (TopicServiceImpl) ctx.getBean("topicServiceImpl");
        List<Topic> topicList = topicService.queryTopics(new QueryForm());
        if(CollectionsUtil.isNotEmpty(topicList)){
            for(int i = 0; i< topicList.size();i++){
                Topic topic = topicList.get(i);
                String topicName = topic.getTopicName();
                System.out.println(topicName);
                String clientId= "client1"+i;
                ClientMQTT clientMQTT = new ClientMQTT(topicName,clientId);
                clientMQTT.start();
            }
        }
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent evt) {
        if (evt.getApplicationContext().getParent() == null) {
            action(evt.getApplicationContext());
            System.out.println("4.2 => MyApplicationListener.onApplicationEvent");
        }
    }
}
