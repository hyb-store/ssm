package com.hyb.ssm.dao;

import com.hyb.ssm.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IRoleDao {

    //根据用户id查询所有对应角色
    @Select("select * from role where id in (select roleId from users_role where userId = #{userId}) ")
    public List<Role> findRoleByUserId(String userId) throws Exception;
}
