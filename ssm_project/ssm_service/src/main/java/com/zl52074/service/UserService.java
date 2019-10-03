package com.zl52074.service;

import com.zl52074.domain.Role;
import com.zl52074.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<UserInfo> findAll(int page, int size) throws Exception;

    void save(UserInfo userInfo) throws Exception;

    UserInfo findById(String id) throws Exception;

    List<Role> findOtherRoles(String userId) throws Exception;

    void addRoleToUser(String userId, String[] roleIds);

    void deleteUserById(String id);

    Integer findCount();
}
