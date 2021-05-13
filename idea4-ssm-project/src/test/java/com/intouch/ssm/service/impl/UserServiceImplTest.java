package com.intouch.ssm.service.impl;

import com.intouch.ssm.domain.User;
import com.intouch.ssm.service.UserService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class UserServiceImplTest  {
    @Autowired
    private UserService userService;

    public void setUp() throws Exception {
        System.out.println(userService.getClass().getName());
    }
    @Test
    public void testLogin() {
        String email = "1";
        User user = userService.login(email);
        System.out.println(user.getEmail());
    }

    @Test
    public void testModifyUser() {
        String email = "1";
        User user = userService.login(email);
        user.setLastLoginTime(System.currentTimeMillis());
        user.setLastLoginIp("100");
        userService.modifyUser(user);
        System.out.println(user.getEmail());
    }
}