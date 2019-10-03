package dao;

import bean.Order;
import bean.OrderItem;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface OrderDao {
    void insertOrder(Connection conn ,Order order) throws SQLException;
    void insertOrderitem(Connection conn ,OrderItem orderitem) throws SQLException;
    List<Order> queryOrder(String uid) throws SQLException;
    List<OrderItem> queryOrderitem(String oid) throws SQLException;
    void deleteOrder(Connection conn,String oid) throws SQLException;
}
