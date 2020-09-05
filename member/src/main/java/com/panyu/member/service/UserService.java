package com.panyu.member.service;

import com.panyu.member.entity.User;

public interface UserService {

    public User findById(String id);

    public Integer addUser(User user);

    public User findByName(String name);
}
