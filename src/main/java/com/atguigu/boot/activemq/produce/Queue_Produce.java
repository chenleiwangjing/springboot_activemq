package com.atguigu.boot.activemq.produce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import java.util.UUID;

@Component
public class Queue_Produce {

    // JmsMessagingTemplate是Springboot的Jms模板,Spring的是JmsTemplate
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    // 把ConfigBean类的ActiveMQQueue注入进来
    @Autowired
    private Queue queue;

    public void producerMsg(){
        jmsMessagingTemplate.convertAndSend(queue,"**************" + UUID.randomUUID().toString());
    }

    // 定时投递消息(每3秒发送一条)
    // 需要在启动类上添加@EnableScheduling注解
    @Scheduled(fixedDelay = 3000)
    public void producerMsgScheduled(){
        jmsMessagingTemplate.convertAndSend(queue,"*******Scheduled*******" + UUID.randomUUID().toString());
        System.out.println("定时投递任务*********");
    }
}
