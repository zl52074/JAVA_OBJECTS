package com.zl52074.service;



import com.zl52074.domain.Permission;

import java.util.List;

public interface PermissionService {
    public List<Permission> findAll(int page, int size) throws Exception;

    void save(Permission permission) throws Exception;

    void deletePermissionById(String id);

    Integer findCount();
}
