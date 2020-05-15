package com.test.mysql;

import com.mysql.jdbc.StringUtils;
import com.test.mysql.mapper.UserMapper;

/**
 * @ClassName MySqlSession
 * @Description MySqlSession
 * @Author liyz
 * @Date 2020/5/15 15:36
 * @Version 1.0
 */
public class MySqlSession {

    private ExcoteMysql excoteMysql;
    private MyConfiguration myConfiguration;

    public MySqlSession(ExcoteMysql excoteMysql, MyConfiguration myConfiguration) {
        this.excoteMysql = excoteMysql;
        this.myConfiguration = myConfiguration;
    }

    public <T> T selectOne(String statementId,Object paramater){
        String sql =MyConfiguration.sqlMappings.getString(statementId);
        if (!StringUtils.isNullOrEmpty(sql)){
            return excoteMysql.query(sql,paramater);
        }

        return null;
    }

    public <T> T getMapper (Class clazz) {
        return myConfiguration.getMapper(clazz,this);
    }

}
