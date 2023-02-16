package com.itguigu.docker.controller;

import com.itguigu.docker.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @Author darren
 * @Date 2023/2/13 21:38
 */
@RestController
public class HelloController {

    @Autowired
    private RedisUtil mRedisUtil;

    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }

    @RequestMapping("/getKey/{k1}")
    public String getRedisK1(@PathVariable String k1){
        return (String) mRedisUtil.get(k1);
    }
}
