package com.example.user.service;

import com.example.user.mapper.UserMapper;
import com.example.user.pojo.User;
import com.example.utils.Result;
import com.example.utils.StatusCode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {


    @Resource
    private UserMapper userMapper;

    public User login(User user) {

        User login = userMapper.login(user.getUsername());

        if (login !=null && login.getPassword().equals(user.getPassword())){
            return login;
        }

        return null;
    }
}
