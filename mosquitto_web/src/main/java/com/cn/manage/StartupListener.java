package com.cn.manage;

import javax.servlet.ServletContext;

import com.cn.manage.util.ClientMQTT;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

@Component
public class StartupListener implements ApplicationContextAware, ServletContextAware,
        InitializingBean, ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        Runnable clientMQTT = new ClientMQTT();
        Thread thread=new Thread(clientMQTT);
        thread.setDaemon(true);
        thread.start();
        System.out.println("1 => StartupListener.setApplicationContext");
    }

    @Override
    public void setServletContext(ServletContext context) {
        System.out.println("2 => StartupListener.setServletContext");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("3 => StartupListener.afterPropertiesSet");
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent evt) {
        System.out.println("4.1 => MyApplicationListener.onApplicationEvent");
        if (evt.getApplicationContext().getParent() == null) {
            System.out.println("4.2 => MyApplicationListener.onApplicationEvent");
        }
    }
}
