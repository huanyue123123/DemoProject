package com.huanyue.spacepageclient.controller;

import com.huanyue.spacepageclient.entity.Result;
import com.huanyue.spacepageclient.entity.User;
import com.huanyue.spacepageclient.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public Result login(@RequestBody User user){
        return userService.login(user);
    }

}
