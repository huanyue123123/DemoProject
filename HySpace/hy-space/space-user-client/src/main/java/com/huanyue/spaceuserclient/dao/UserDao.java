package com.huanyue.spaceuserclient.dao;

import com.huanyue.spaceuserclient.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao {

    User selectByName(User user);

    List<User> queryUserList(User user);
}
