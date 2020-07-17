package com.cloud.feignhi.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestRabbitConfig {


    @Bean
    public Queue queue() {
        return new Queue("hello-world");
    }


}
