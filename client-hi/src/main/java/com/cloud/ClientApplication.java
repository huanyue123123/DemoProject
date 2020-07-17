package com.cloud;

import com.cloud.rabbit.RabbitTutorialRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableEurekaClient
@SpringBootApplication
@EnableScheduling
public class ClientApplication {

    public static void main(String[] args) {

        //SpringApplication.run(ClientApplication.class, args);
        new SpringApplicationBuilder()
                .sources(ClientApplication.class)
                // 设置成非 web 环境
                .web(WebApplicationType.NONE)
                .run(args);
    }

    @Profile("usage_message")
    @Bean
    public CommandLineRunner usage() {
        return arg0 -> {
            System.out.println("This app uses Spring Profiles to control its behavior.\n");
            System.out.println("Sample usage: java -jar target/rabbitmq-tutorial-0.0.1-SNAPSHOT.jar --spring.profiles.active=hello-world,sender");
        };
    }

    @Profile("!usage_message")
    @Bean
    public CommandLineRunner tutorial() {
        return new RabbitTutorialRunner();
    }
}
