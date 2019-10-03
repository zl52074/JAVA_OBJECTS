package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCUtils {
//    private static String driver = "com.mysql.cj.jdbc.Driver";
//    private static String url = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
//    private static String user="root";
//    private static String password = "root";
    private static DataSource ds = new ComboPooledDataSource();
    //获取数据源对象
    public static DataSource getDataSource(){
        return ds;
    }

    private static ThreadLocal<Connection> tl = new ThreadLocal<>();
    public static Connection getConnection() throws SQLException {
        Connection conn = tl.get();
        if(conn==null){
            conn = ds.getConnection();
            tl.set(conn);
        }
        return conn;
    }
    //开启事务
    public static  void start() throws SQLException{
        JDBCUtils.getConnection().setAutoCommit(false);
    }

    //提交事务
    public static void commit() throws SQLException{
        JDBCUtils.getConnection().commit();
    }
    //回滚事务
    public static void rollback() throws SQLException{
        JDBCUtils.getConnection().rollback();
    }
    //关闭连接
    public static void close() throws SQLException{
        JDBCUtils.getConnection().close();
    }
}
