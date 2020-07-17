package com.cloud.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RefreshScope
public class ConfigController {

    @Value("${neo.hello}")
    private String profile;

    @GetMapping("/info")
    public Mono<String> hello(){
        return Mono.justOrEmpty(profile);
    }
}
