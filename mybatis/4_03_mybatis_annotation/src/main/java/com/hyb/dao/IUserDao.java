package com.hyb.dao;

import com.hyb.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 在mybatis中，针对CRUD有四个注解
 * 分别是@Select @Insert @Update @Delete
 */
public interface IUserDao {
    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    List<User> findAll();

    /**
     * 保存用户
     * @param user
     */
    @Insert("insert into user(username,address,sex,birthday)values(#{username},#{address},#{sex},#{birthday})")
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    @Update("update user set username = #{username},address = #{address},sex = #{sex},birthday = #{birthday} where id = #{id}")
    void updateUser(User user);

    /**
     * 删除用户
     * @param userId
     */
    @Delete("delete from user where id = #{id}")
    void deleteUser(Integer userId);

    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    @Select("select * from user where id = #{id}")
    User findById(Integer userId);

    /**
     * 根据用户名称模糊查询
     * @param username
     * @return
     */
    @Select("select * from user where username like #{username}")//参数占位符==>Preparing: select * from user where username like ?
//    @Select("select * from user where username like '%${value}%'")//字符串拼接==>Preparing: select * from user where username like '%王%'
    List<User> findUserByName(String username);

    /**
     * 查询总用户数
     * @return
     */
    @Select("select count(*) from user ")
    int findTotalUser();
}
