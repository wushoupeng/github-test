package com.intouch.ssm.service.impl;

import com.intouch.ssm.dao.UserMapper;
import com.intouch.ssm.domain.User;
import com.intouch.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public User login(String email) {
        User user=userMapper.selectByEmailField(email);
        return user;
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED)
    public void modifyUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
        User user1 = new User();
        user.setUserIntegral(10000);
        userMapper.updateByPrimaryKeySelective(user1);

    }
}
