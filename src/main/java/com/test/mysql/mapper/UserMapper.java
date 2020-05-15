package com.test.mysql.mapper;

/**
 * @ClassName UserMapper
 * @Description UserMapper
 * @Author liyz
 * @Date 2020/5/15 15:52
 * @Version 1.0
 */
public interface UserMapper {

    /**
     * id查询
     * @param id
     * @return
     */
    User selectUserById(String id);

}
