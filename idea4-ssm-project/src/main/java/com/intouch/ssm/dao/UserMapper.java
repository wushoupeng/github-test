package com.intouch.ssm.dao;

import com.intouch.ssm.domain.User;

public interface UserMapper {


    int insert(User record);
    int insertSelective(User record);

    int deleteByPrimaryKey(Integer id);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);
    int updateByPrimaryKey(User record);

    User selectByEmailField(String email);
}