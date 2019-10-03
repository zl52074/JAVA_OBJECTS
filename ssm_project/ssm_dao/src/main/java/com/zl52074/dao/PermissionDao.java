package com.zl52074.dao;


import com.zl52074.domain.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionDao {
    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id} )")
    public List<Permission> findPermissionByRoleId(String id) throws Exception;

    @Select("select * from permission")
    List<Permission> findAll() throws Exception;

    @Insert("insert into permission values(#{id},#{permissionName},#{url})")
    void save(Permission permission) throws Exception;

    @Delete("delete from role_permission where permissionId=#{id}")
    void deleteFromRole_PermissionByPermissionId(String id);

    @Delete("delete from permission where id=#{id}")
    void deletePermissionById(String id);
    @Select("select count(*) from permission")
    Integer finCount();
}
