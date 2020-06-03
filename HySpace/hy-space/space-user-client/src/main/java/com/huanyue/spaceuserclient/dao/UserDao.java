package com.huanyue.spaceuserclient.dao;

import com.huanyue.spaceuserclient.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    User selectByName(User user);

    List<User> queryUserList(User user);
}
