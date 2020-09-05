package com.panyu.member.service.impl;

import com.panyu.member.dao.UserDao;
import com.panyu.member.entity.User;
import com.panyu.member.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;

    @Override
    public User findById(String id) {
        return userDao.findById(id);
    }

    @Override
    public Integer addUser(User user) {

        Integer resultNum=userDao.addUser(user);
        if(resultNum>0){
            return resultNum;
        }
        return null;
    }
    @Override
    public User findByName(String name) {
        return userDao.findByName(name);
    }
}
