package com.zl52074.service.impl;

import com.zl52074.dao.UserDao;
import com.zl52074.domain.LinkMan;
import com.zl52074.domain.PageBean;
import com.zl52074.domain.User;
import com.zl52074.service.UserService;
import com.zl52074.utils.MD5Utils;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class UserServiceImpl implements UserService {

    // 注入DAO:
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    // 业务层注册用户的方法
    public void regist(User user) {
        // 对密码进行加密处理：
        user.setUser_password(MD5Utils.md5(user.getUser_password()));
        // 调用DAO
        userDao.save(user);
    }

    @Override
    // 业务层用户登录的方法
    public User login(User user) {
        user.setUser_password(MD5Utils.md5(user.getUser_password()));
        // 调用DAO
        return userDao.login(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    // 业务层分页查询用户的方法
    public PageBean<User> userList(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize) {
        PageBean<User> pageBean = new PageBean<User>();
        // 设置当前页数:
        pageBean.setCurrPage(currPage);
        // 设置每页显示记录数:
        pageBean.setPageSize(pageSize);
        // 设置总记录数
        Integer totalCount = userDao.findCount(detachedCriteria);
        pageBean.setTotalCount(totalCount);
        // 设置总页数
        double tc = totalCount;
        Double num = Math.ceil(tc / pageSize);
        pageBean.setTotalPage(num.intValue());
        // 每页显示数据的集合
        Integer begin = (currPage - 1) * pageSize;
        List<User> list = userDao.findByPage(detachedCriteria,begin,pageSize);
        pageBean.setList(list);
        return pageBean;
    }

    @Override
    public User findById(Long user_id) {
        return userDao.findById(user_id);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

}
