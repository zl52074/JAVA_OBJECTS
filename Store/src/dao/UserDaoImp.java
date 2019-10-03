package dao;

import bean.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;

public class UserDaoImp implements UserDao{
    public void inserUser(User user) throws SQLException {
        QueryRunner qr = new QueryRunner(utils.JDBCUtils.getDataSource());
        String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?,?)";
        qr.update(sql, user.getUid(),user.getUsername(),user.getPassword(),user.getEmail(),user.getName(),user.getSex(),user.getBirthday(),null,null,0,null);
    }
    public int QueryUsername(String username) throws SQLException {
        QueryRunner qr = new QueryRunner(utils.JDBCUtils.getDataSource());
        String sql = "select count(*) from user where username = ?";
        int intValue = ((Long)qr.query(sql, new ScalarHandler(), username)).intValue();
        return intValue;
    }
    public int QueryEmail(String email) throws SQLException {
        QueryRunner qr = new QueryRunner(utils.JDBCUtils.getDataSource());
        String sql = "select count(*) from user where email = ?";
        int intValue = ((Long)qr.query(sql, new ScalarHandler(), email)).intValue();
        return intValue;
    }

    public User queryUser(User submit) throws SQLException {
        QueryRunner qr = new QueryRunner(utils.JDBCUtils.getDataSource());
        String sql = "select * from user where username = ? and password = ?";
        User user = qr.query(sql, new BeanHandler<User>(User.class),submit.getUsername(),submit.getPassword());
        return user;
    }
}
