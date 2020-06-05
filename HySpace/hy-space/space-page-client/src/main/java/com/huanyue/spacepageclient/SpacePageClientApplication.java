package com.huanyue.spacepageclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpacePageClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpacePageClientApplication.class, args);
    }

}
