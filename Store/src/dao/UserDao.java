package dao;

import bean.User;

import java.sql.SQLException;

public interface UserDao {
    void inserUser(User user) throws SQLException;
    int QueryUsername(String username) throws SQLException;
    int QueryEmail(String email) throws SQLException;
    User queryUser(User submit) throws SQLException;
}
