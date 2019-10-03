package com.zl52074.service.impl;


import com.github.pagehelper.PageHelper;
import com.zl52074.dao.RoleDao;
import com.zl52074.domain.Permission;
import com.zl52074.domain.Role;
import com.zl52074.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public void deleteRoleById(String roleId) {
        //从user_role表中删除
        roleDao.deleteFromUser_RoleByRoleId(roleId);
        //从role_permission表中删除
        roleDao.deleteFromRole_PermissionByRoleId(roleId);
        //从role表中删除
        roleDao.deleteRoleById(roleId);
    }

    @Override
    public Integer findCount() {
        return roleDao.findCount();
    }


    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) {
        for(String permissionId:permissionIds){
            roleDao.addPermissionToRole(roleId,permissionId);
        }
    }

    @Override
    public Role findById(String roleId) {
        return roleDao.findById(roleId);
    }

    @Override
    public List<Permission> findOtherPermissions(String roleId) {
        return roleDao.findOtherPermissions(roleId);
    }
    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public List<Role> findAll(int page, int size) throws Exception{
        //参数pageNum 是页码值   参数pageSize 代表是每页显示条数
        PageHelper.startPage(page, size);
        return roleDao.findAll();
    }
}
