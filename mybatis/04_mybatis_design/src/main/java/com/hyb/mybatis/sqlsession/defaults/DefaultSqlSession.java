package com.hyb.mybatis.sqlsession.defaults;

import com.hyb.mybatis.cfg.Configuration;
import com.hyb.mybatis.sqlsession.Proxy.MapperProxy;
import com.hyb.mybatis.sqlsession.SqlSession;
import com.hyb.mybatis.utils.DateSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/***
 * SqlSession接口的实现类
 */
public class DefaultSqlSession implements SqlSession {

    private Configuration cfg;
    private Connection connection;

    public DefaultSqlSession(Configuration cfg) {
        this.cfg = cfg;
        connection = DateSourceUtil.getConnection(cfg);
    }

    /**
     * 创建代理对象
     * @param daoInterfaceClass dao的接口字节码
     * @param <T>
     * @return
     */
    @Override
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass},new MapperProxy(cfg.getMappers(),connection));
    }

    /**
     * 释放资源
     */
    @Override
    public void close() {
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
}
