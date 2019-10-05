package com.zl52074.service;


import com.zl52074.domain.LinkMan;
import com.zl52074.domain.PageBean;
import com.zl52074.domain.User;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface UserService {
	void regist(User user);
	User login(User user);
	List<User> findAll();
	PageBean<User> userList(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize);

    User findById(Long user_id);

	void delete(User user);
}
