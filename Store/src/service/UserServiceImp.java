package service;

import bean.User;
import dao.UserDaoImp;

import java.sql.SQLException;

public class UserServiceImp implements UserService{
    public void saveUser(User user) throws SQLException {
        UserDaoImp ud = new UserDaoImp();
        ud.inserUser(user);
    }

    public int queryUsername(String username) throws SQLException {
        UserDaoImp ud = new UserDaoImp();
        int intValue = ud.QueryUsername(username);
        return intValue;
    }

    public int queryEmail(String email) throws SQLException {
        UserDaoImp ud = new UserDaoImp();
        int intValue = ud.QueryEmail(email);
        return intValue;
    }
    public User queryUser(User submit) throws SQLException {
        UserDaoImp ud = new UserDaoImp();
        User user =ud.queryUser(submit);
        return user;
    }
}
