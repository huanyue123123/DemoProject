package com.cloud.feignhi.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TestSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private Queue queue;


    public void sendMsg(String msg){
        Map<String,Object> map = new HashMap<>();
        map.put("name","轿车");
        map.put("count",150);
       amqpTemplate.convertAndSend(queue.getName(),msg);
        //amqpTemplate.convertAndSend(queue.getName(),map);
        Object s = amqpTemplate.convertSendAndReceive(queue.getName(),map);
        System.out.println(s);
    }


}
