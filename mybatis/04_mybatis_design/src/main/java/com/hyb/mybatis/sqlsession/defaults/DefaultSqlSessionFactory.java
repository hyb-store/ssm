package com.hyb.mybatis.sqlsession.defaults;

import com.hyb.mybatis.cfg.Configuration;
import com.hyb.mybatis.sqlsession.SqlSession;
import com.hyb.mybatis.sqlsession.SqlSessionFactory;

/**
 * SqlSessionFactory的实现类
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration cfg;

    public DefaultSqlSessionFactory(Configuration cfg) {
        this.cfg = cfg;
    }
    /**
     * 用于创建一个新的操作数据库对象
     * @return
     */
    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
