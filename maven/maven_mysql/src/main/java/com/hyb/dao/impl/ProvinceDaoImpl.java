package com.hyb.dao.impl;

import com.hyb.dao.ProvinceDao;
import com.hyb.domain.Province;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProvinceDaoImpl implements ProvinceDao {
    public List<Province> findAll() throws Exception {
        List<Province> list = new ArrayList<Province>();
        //先获取contection对象
        Connection connection = null;
        //获取真正操作数据的对象
        PreparedStatement pst = null;
        //执行数据库查询操作
        ResultSet rs = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            //先获取contection对象
            connection = DriverManager.getConnection("jdbc:mysql:///db2","root", "123456789");
            //获取真正操作数据的对象
            pst = connection.prepareCall("select * from province");
            //执行数据库查询操作
            rs = pst.executeQuery();
            //把数据库结果集转成java的List集合
            while (rs.next()){
                Province province = new Province();
                province.setId(rs.getInt("id"));
                province.setName(rs.getString("name"));
                list.add(province);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            connection.close();
            pst.close();
            rs.close();
        }

        return list;

    }
    
}
