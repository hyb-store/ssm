package com.hyb.dao;

import com.hyb.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * 在mybatis中，针对CRUD有四个注解
 * 分别是@Select @Insert @Update @Delete
 */
@CacheNamespace(blocking = true)//主要用于mybatis二级缓存，等同于<cache>属性
public interface IUserDao {
    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    @Results(id = "userMap",value = {
            @Result(id = true,column = "id",property = "userId"),
            @Result(column = "username",property = "userName"),
            @Result(column = "address",property = "userAddress"),
            @Result(column = "sex",property = "userSex"),
            @Result(column = "birthday",property = "userBirthday"),
            @Result(property = "accounts",column = "id",many = @Many(select = "com.hyb.dao.IAccountDao.findAccountById",fetchType = FetchType.LAZY))
    })                                                 //FetchType.LAZY 懒加载     FetchType.EAGER 立刻加载
    List<User> findAll();

    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    @Select("select * from user where id = #{id}")
    @ResultMap(value = {"userMap"})//引用上边的@Results
    User findById(Integer userId);

    /**
     * 根据用户名称模糊查询
     * @param username
     * @return
     */
    @Select("select * from user where username like #{username}")
    @ResultMap("userMap")
    List<User> findUserByName(String username);


}
