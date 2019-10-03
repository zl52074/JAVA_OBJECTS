package service;

import bean.User;

import java.sql.SQLException;

public interface UserService {
    void saveUser(User user) throws SQLException;
    int queryUsername(String username) throws SQLException;
    int queryEmail(String email) throws SQLException;
    User queryUser(User submit) throws SQLException;
}
