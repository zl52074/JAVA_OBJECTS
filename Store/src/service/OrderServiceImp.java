package service;

import bean.Order;
import bean.OrderItem;
import bean.Product;
import dao.OrderDao;
import dao.OrderDaoImp;
import dao.ProductDao;
import dao.ProductDaoImp;
import org.apache.commons.dbutils.DbUtils;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OrderServiceImp implements OrderService {

    @Override
    public void saveOrder(Order order) {

        try {
            Connection conn = JDBCUtils.getConnection();
            JDBCUtils.start();
            OrderDao od = new OrderDaoImp();
            od.insertOrder(conn, order);
            for(OrderItem orderitem:order.getOrderItems()){
                od.insertOrderitem(conn,orderitem);
            }
            JDBCUtils.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                JDBCUtils.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

    }

    @Override
    public List<Order> findOrder(String uid) throws SQLException {
        OrderDao od = new OrderDaoImp();
        ProductDao pd = new ProductDaoImp();
        List<Order> orders = od.queryOrder(uid);
        for(Order order:orders){
            List<OrderItem> orderitems = od.queryOrderitem(order.getOid());
            for(OrderItem orderitem:orderitems){
                Product pro = pd.queryProduct(orderitem.getPid());
                orderitem.setProduct(pro);
                order.getOrderItems().add(orderitem);
            }
        }
        return orders;
    }

    @Override
    public void deleteOrder(String pid) {

        try {
            Connection conn = JDBCUtils.getConnection();
            JDBCUtils.start();
            OrderDao od = new OrderDaoImp();
            od.deleteOrder(conn,pid);
            JDBCUtils.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                JDBCUtils.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}
