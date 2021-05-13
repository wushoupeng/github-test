package com.intouch.ssm.service;

import com.intouch.ssm.domain.User;

public interface UserService {
    //登录
    public User login(String email);
    //最新登录时间
    public void modifyUser(User user);
}
