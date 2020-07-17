package com.cloud.feignhi.controller;

import com.cloud.feignhi.inters.HiFeignInterface;
import com.cloud.feignhi.service.TestRecevier;
import com.cloud.feignhi.service.TestSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feign")
public class FeignController {

    @Autowired
    private HiFeignInterface hiFeignInterface;

    @Autowired
    private TestSender testSender;

    @Autowired
    private TestRecevier testRecevier;

    @GetMapping("/hi")
    public String getMsgByFeign(@RequestParam("name") String name){
        return hiFeignInterface.sayHiToName(name);
    }

    @GetMapping("/send/{msg}")
    public void sendMsg(@PathVariable("msg") String msg){
        testSender.sendMsg(msg);
    }

}
