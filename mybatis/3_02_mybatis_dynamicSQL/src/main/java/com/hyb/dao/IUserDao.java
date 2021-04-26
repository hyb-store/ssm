package com.hyb.dao;

import com.hyb.domain.QueryVo;
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

    /**
     * 根据id查询用户信息
     * @param userId
     * @return
     */
    User findById(Integer userId);

    /**
     * 根据姓名模糊查询用户信息
     * @param username
     * @return
     */
    List<User> findByName(String username);

    /**
     * 根据queryVo中的条件查询用户
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);

    /**
     * 根据传入参数条件
     * @param user 查询的条件:有可能有用户名，有可能有性别，也有可能有地址，还有可能都有
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据QueryVo提供的集合信息，查询用户信息
     * @return
     */
    List<User> findUserInIds(QueryVo vo);
}
