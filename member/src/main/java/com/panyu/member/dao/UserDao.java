package com.panyu.member.dao;

import com.panyu.member.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    public User findById(String id);

    public Integer addUser(User user);

    public  User findByName(String name);
}
