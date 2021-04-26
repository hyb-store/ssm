package com.hyb.mybatis.utils;

import com.hyb.mybatis.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 用于创建数据源的工具类
 */
public class DateSourceUtil {
    /**
     * 用于获取一个连接
     * @param cfg
     * @return
     */
    public static Connection getConnection(Configuration cfg) {
        Connection connection = null;
        try {
            Class.forName(cfg.getDriver());
            connection = DriverManager.getConnection(cfg.getUrl(), cfg.getUsername(), cfg.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
