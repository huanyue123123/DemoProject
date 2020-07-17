package com.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hi")
public class HiController {

    @Value("${server.port}")
    private int port;

    @GetMapping("/sayHiToName/{name}")
    public String getName(@PathVariable("name") String name){
        return "Hi " + name + " I am from " + port ;
    }
}
