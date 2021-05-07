package com.hyb.ssm.service;

import com.hyb.ssm.domain.Permission;
import com.hyb.ssm.domain.Role;

import java.util.List;

public interface IRoleService {

    public List<Role> findAll() throws Exception;

    void save(Role role) throws Exception;

    void addPermissionToRole(String roleId, String[] permissionIds) throws Exception;

    Role findById(String roleId) throws Exception;

    List<Permission> findOtherPermissions(String roleId) throws Exception;

    public void deleteRoleById(String roleId) throws Exception;
}
