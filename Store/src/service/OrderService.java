package service;

import bean.Order;
import bean.OrderItem;

import java.sql.SQLException;
import java.util.List;

public interface OrderService {
    void saveOrder(Order order) throws SQLException;
    List<Order> findOrder(String uid) throws SQLException;
    void deleteOrder(String pid);
}
