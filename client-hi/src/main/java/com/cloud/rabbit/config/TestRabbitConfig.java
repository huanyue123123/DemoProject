package com.cloud.rabbit.config;

import com.cloud.rabbit.recevier.TestRecevier;
import com.cloud.rabbit.sender.TestSender;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"tut1","hello-world"})
public class TestRabbitConfig {


    @Bean
    public Queue queue() {
        return new Queue("hello-world");
    }

    @Profile("receiver")
    @Bean
    public TestRecevier receiver() {
        return new TestRecevier();
    }

    @Profile("sender")
    @Bean
    public TestSender sender() {
        return new TestSender();
    }
}
