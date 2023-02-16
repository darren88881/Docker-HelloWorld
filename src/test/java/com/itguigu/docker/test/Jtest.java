package com.itguigu.docker.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itguigu.docker.entity.User;
import org.junit.Test;

/**
 *
 * @Author darren
 * @Date 2023/2/15 20:23
 */
public class Jtest {

    @Test
    public void test01() throws JsonProcessingException {
        User user = new User();
        user.setId(1);
        user.setName("hahah");
        user.setAge(20);

        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(user);
        System.out.println(s);

        User user1 = objectMapper.readValue(s, User.class);
        System.out.println(user1);


    }
}
