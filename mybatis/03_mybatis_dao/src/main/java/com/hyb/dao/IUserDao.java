package com.hyb.dao;

import com.hyb.domain.User;


import java.util.List;

/**
 * 用户的持久层接口
 */
public interface IUserDao {
    /**
     * 查询所有操作
     * @return
     */
    public List<User> findAll();
}
