package com.test.mysql;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName MyMapperProxy
 * @Description MyMapperProxy
 * @Author liyz
 * @Date 2020/5/15 16:08
 * @Version 1.0
 */
public class MyMapperProxy implements InvocationHandler {
    private MySqlSession sqlSession;

    public MyMapperProxy(MySqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    /**
     * 动态代理获取mapper类信息
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String mapperInterce = method.getDeclaringClass().getName();
        String methodName = method.getName();
        String statementId = mapperInterce+'.'+methodName;
        return sqlSession.selectOne(statementId,args[0]);
    }
}
