package com.huanyue.usermanage.feignInters;

import com.huanyue.usermanage.entity.Result;
import com.huanyue.usermanage.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name = "user-client")
public interface UserFeignInterface {


    @PostMapping("/user/login")
    @ResponseBody
    Object login(@RequestBody Object user);
}
