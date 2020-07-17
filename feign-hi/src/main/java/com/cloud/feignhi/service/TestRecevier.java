package com.cloud.feignhi.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.ReceiveAndReplyCallback;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;


@RabbitListener(queues = "hello-world")
@Service
public class TestRecevier {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @RabbitHandler
    public void receive(String in){

        System.out.println("Received:--->  \"" + in + "\"");
    }

    @RabbitHandler
    @SendTo("hello-world")
    public String receiveMap(Map<String,Object> in){

        System.out.println("ReceivedMap:--->  \"" + in + "\"");
        return "收到!!!";
    }





}
