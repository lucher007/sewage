package com.shenya.sewage.service.impl;

import com.shenya.sewage.dao.IUserDao;
import com.shenya.sewage.model.User;
import com.shenya.sewage.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    public User findById(Integer id) {
        return userDao.findById(id);
    }

}
