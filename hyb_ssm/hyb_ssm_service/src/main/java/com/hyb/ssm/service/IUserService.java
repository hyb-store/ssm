package com.hyb.ssm.service;

import com.hyb.ssm.domain.Role;
import com.hyb.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {

    List<UserInfo> findAll() throws Exception;

    void save(UserInfo userInfo) throws Exception;

    UserInfo findById(String id)throws Exception;

    void addRoleToUser(String userId, String[] roleIds)throws Exception;

    List<Role> findOtherRoles(String userid)throws Exception;

}
