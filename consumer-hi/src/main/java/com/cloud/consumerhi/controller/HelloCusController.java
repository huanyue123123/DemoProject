package com.cloud.consumerhi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/hello")
public class HelloCusController {

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("/{name}")
    public String getClientMsg(@PathVariable("name") String name){
        String url ="http://eureka-client-hi/hi/sayHiToName/"+name;
        return restTemplate.getForObject(url,String.class);
    }
}
