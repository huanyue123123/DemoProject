package com.huanyue.spaceuserclient.controller;

import com.huanyue.spaceuserclient.entity.Result;
import com.huanyue.spaceuserclient.entity.User;
import com.huanyue.spaceuserclient.service.UserService;
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
