package com.cloud.feignhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients("com.cloud.feignhi.inters")
@EnableDiscoveryClient
@EnableHystrix
@EnableConfigServer
@SpringBootApplication
public class FeignHiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignHiApplication.class, args);
    }

}
