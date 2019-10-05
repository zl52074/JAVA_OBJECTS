package com.zl52074.dao;


import com.zl52074.domain.User;

public interface UserDao extends BaseDao<User>{

	User login(User user);

}
