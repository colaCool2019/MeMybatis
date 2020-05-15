package com.test.mysql;

import com.test.mysql.mapper.UserMapper;

/**
 * @ClassName MyTest
 * @Description MyTest
 * @Author liyz
 * @Date 2020/5/15 16:17
 * @Version 1.0
 */
public class MyTest {

    public static void main(String[] args) {
        MySqlSession sqlSession = new MySqlSession(new ExcoteMysql(), new MyConfiguration());
        UserMapper userMapper =sqlSession.getMapper(UserMapper.class);
        userMapper.selectUserById("1");
    }

}
