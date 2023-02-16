package com.itguigu.docker.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.itguigu.docker.entity.User;
import com.itguigu.docker.service.UserService;
import com.itguigu.docker.utils.RedisUtil;
import io.netty.util.internal.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @Author darren
 * @Date 2023/2/15 10:58
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUserID/{id}")
    public User getUserID(@PathVariable  Integer id) throws JsonProcessingException {
        return userService.getUser(id);
    }

    @RequestMapping("/getUserAll")
    public List<User> getUserAll() throws JsonProcessingException {
        return userService.getUserAll();
    }
}
