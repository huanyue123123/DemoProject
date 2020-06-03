package com.huanyue.usermanage.controller;

import com.alibaba.fastjson.JSON;
import com.huanyue.usermanage.entity.User;
import com.huanyue.usermanage.feignInters.UserFeignInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserFeignInterface userFeignInterface;

    @PostMapping("/login")
    @ResponseBody
    public Object login(@RequestBody Object user){
        Object obj = userFeignInterface.login(user);
        return obj;

    }
}
