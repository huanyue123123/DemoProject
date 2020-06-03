package com.huanyue.spaceuserclient.service;

import com.huanyue.spaceuserclient.dao.UserDao;
import com.huanyue.spaceuserclient.entity.Result;
import com.huanyue.spaceuserclient.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    private UserDao userDao;

    public Result login(User user){
        User checkUser = new User();
        checkUser.setUsername(user.getUsername());
        checkUser = userDao.selectByName(checkUser);
        if(checkUser == null){
            return new Result(-1,"不存在此用户");
        }
        User loginUser = userDao.selectByName(user);
        if(loginUser == null){
            return new Result(-2,"密码错误");
        }
        return new Result(1,"登录成功",loginUser);
    }

}
