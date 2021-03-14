package com.example.user.controller;


import com.example.user.pojo.User;
import com.example.user.service.UserService;
import com.example.utils.JWTUtils;
import com.example.utils.Result;
import com.example.utils.StatusCode;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {


     @Resource
     private UserService userService;
     @Resource
     private JWTUtils jwtUtils;

     //用户名不存在   密码错误
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public Result login(@RequestBody User user){
        User user1 = userService.login(user);
        if (user1 != null){
            String utilsJWT = jwtUtils.createJWT(user.getUsername(), "user");
            HashMap<Object, Object> map = new HashMap<>();
            map.put("token",utilsJWT);
            map.put("username",user1.getUsername());
            return new Result(true,StatusCode.OK,"登录成功",map,user1);
        }
        return new Result(false, StatusCode.ERROR,"用户名不存在或密码错误");
    }
}
