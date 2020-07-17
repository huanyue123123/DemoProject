package com.cloud.rabbit.recevier;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;


@RabbitListener(queues = "hello-world")
public class TestRecevier {

    @RabbitHandler
    public void receive(String in){
        System.out.println("Received:--->  \"" + in + "\"");
    }
}
