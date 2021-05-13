package com.intouch.ssm.dao;


import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;

public class UserMapperTest extends TestCase {

    private SqlSession sqlSession;
    private UserMapper userMapper;

    public void setUp() throws Exception {

        userMapper = sqlSession.getMapper(UserMapper.class);
    }


}