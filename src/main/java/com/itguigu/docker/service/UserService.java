package com.itguigu.docker.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itguigu.docker.entity.User;
import com.itguigu.docker.mapper.UserMapper;
import com.itguigu.docker.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @Author darren
 * @Date 2023/2/15 10:57
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisUtil redisUtil;

    private ObjectMapper objectMapper = new ObjectMapper();

    public User getUser(final Integer id) throws JsonProcessingException {
        String userStr = (String) redisUtil.get("user_" + id);
        User user;
        if (userStr != null ) {
            // 将结果转成对象返回
            user = objectMapper.readValue(userStr, User.class);
        } else {
            user = userMapper.getUser(id);
            redisUtil.set("user_"+id, objectMapper.writeValueAsString(user),60);
        }
        return user;
    }

    public List<User> getUserAll() throws JsonProcessingException {
        String user_all = (String) redisUtil.get("user_all");
        if (user_all != null) {
            return objectMapper.readValue(user_all, List.class);
        } else {
            List<User> userAll = userMapper.getUserAll();
            redisUtil.set("user_all", objectMapper.writeValueAsString(userAll),60);
            return userAll;
        }
    }
}
