package com.hyb.dao;

import com.hyb.domain.User;
import com.hyb.mybatis.annotations.Select;

import java.util.List;

/**
 * 用户的持久层接口
 */
public interface IUserDao {
    /**
     * 查询所有操作
     * @return
     */
    @Select("select * from user")
    public List<User> findAll();
}
