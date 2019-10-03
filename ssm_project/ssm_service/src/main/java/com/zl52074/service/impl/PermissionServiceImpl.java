package com.zl52074.service.impl;


import com.github.pagehelper.PageHelper;
import com.zl52074.dao.PermissionDao;
import com.zl52074.domain.Permission;
import com.zl52074.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public void save(Permission permission) throws Exception{
        permissionDao.save(permission);
    }

    @Override
    public void deletePermissionById(String id) {
        permissionDao.deleteFromRole_PermissionByPermissionId(id);
        permissionDao.deletePermissionById(id);
    }

    @Override
    public Integer findCount() {
        return permissionDao.finCount();
    }

    @Override
    public List<Permission> findAll(int page, int size) throws Exception{
        //参数pageNum 是页码值   参数pageSize 代表是每页显示条数
        PageHelper.startPage(page, size);
        return permissionDao.findAll();
    }
}
