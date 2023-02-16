package com.itguigu.docker.mapper;

import com.itguigu.docker.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @Author darren
 * @Date 2023/2/15 10:57
 */
@Repository
public interface UserMapper {
    User getUser(Integer id);

    List<User> getUserAll();
}
