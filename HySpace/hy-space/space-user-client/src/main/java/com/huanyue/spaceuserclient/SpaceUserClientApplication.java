package com.huanyue.spaceuserclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpaceUserClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpaceUserClientApplication.class, args);
    }

}
