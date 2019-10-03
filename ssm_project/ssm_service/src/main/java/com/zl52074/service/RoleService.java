package com.zl52074.service;


import com.zl52074.domain.Permission;
import com.zl52074.domain.Role;

import java.util.List;

public interface RoleService {

    public List<Role> findAll(int page, int size) throws Exception;

    void save(Role role) throws Exception;

    Role findById(String roleId) throws  Exception;

    List<Permission> findOtherPermissions(String roleId) throws Exception;

    void addPermissionToRole(String roleId, String[] permissionIds) throws Exception;

    void deleteRoleById(String roleId) throws Exception;

    Integer findCount();
}
