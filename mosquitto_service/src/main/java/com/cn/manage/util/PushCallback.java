package com.cn.manage.util;

import afu.org.checkerframework.checker.signature.qual.SourceName;
import com.cn.manage.api.ILoginService;
import com.cn.manage.dao.LoginMapper;
import com.cn.manage.domain.Login;
import com.cn.manage.service.LoginServiceImpl;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

public class PushCallback  implements MqttCallback {

    @Override
    public void connectionLost(Throwable throwable) {
        // 连接丢失后，一般在这里面进行重连
        System.out.println("连接断开，可以做重连");
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        // subscribe后得到的消息会执行到这里面
        System.out.println("接收消息主题 : " + topic);
        System.out.println("接收消息Qos : " + message.getQos());
        System.out.println("接收消息内容 : " + new String(message.getPayload()));
        WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
        LoginServiceImpl loginService = (LoginServiceImpl) wac.getBean("loginServiceImpl");
        loginService.addUser(new Login());
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        System.out.println("deliveryComplete---------" + iMqttDeliveryToken.isComplete());
    }
}
