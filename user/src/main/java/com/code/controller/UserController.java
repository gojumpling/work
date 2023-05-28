package com.code.controller;


import com.code.pojo.User;
import com.code.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xiaoshuai
 * @since 2023-05-12
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @Resource
    UserService userService;

    @RequestMapping("/get_user")
    public List<User> getAllUser(){

        return userService.getAllUser();
    }


    @RequestMapping("/login")
    public User login(@RequestBody Map<String, Object> map){
        String account = map.get("account").toString();
        String password = map.get("password").toString();
        return userService.login(account,password);
    }

    @RequestMapping("/register")
    public Boolean register(@RequestBody Map<String, Object> map){
        String name = map.get("name").toString();
        String account = map.get("account").toString();
        String password = map.get("password").toString();

        User user =  User.builder()
                .name(name)
                .account(account)
                .password(password)
                .build();

        return userService.register(user);
    }





}

