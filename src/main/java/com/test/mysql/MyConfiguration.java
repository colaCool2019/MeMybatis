package com.test.mysql;

import java.lang.reflect.Proxy;
import java.util.ResourceBundle;

/**
 * @ClassName MyConfiguration
 * @Description MyConfiguration
 * @Author liyz
 * @Date 2020/5/15 15:37
 * @Version 1.0
 */
public class MyConfiguration {

    public static final ResourceBundle sqlMappings;

    static {
        sqlMappings = ResourceBundle.getBundle("sql");
    }

    public <T> T getMapper(Class clazz,MySqlSession sqlSession){
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{clazz},
                new MyMapperProxy(sqlSession));
    }

}
