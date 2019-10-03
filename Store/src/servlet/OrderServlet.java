package servlet;

import bean.*;
import service.OrderService;
import service.OrderServiceImp;
import utils.BaseServlet;
import utils.UUIDUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet(name = "OrderServlet", urlPatterns = "/order")
public class OrderServlet extends BaseServlet {
    public String orderList(HttpServletRequest request,HttpServletResponse response) throws SQLException {
        User user = (User)request.getSession().getAttribute("user");
        OrderService os = new OrderServiceImp();
        List<Order> orders = os.findOrder(user.getUid());
        request.setAttribute("orders", orders);
        return "/order_list.jsp";
    }


    public String addOrder(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null||cart.getTotal()==0) {
                return "/cart.jsp";
            }else{
                User user = (User) session.getAttribute("user");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String date = dateFormat.format(new Date());
                Order order = new Order();
                order.setOid(UUIDUtils.getUUID());
                order.setOrdertime(date);
                order.setTotal(cart.getTotal());
                order.setUid(user.getUid());
                List<OrderItem> orderitemList = order.getOrderItems();

                //把购物项存入订单项
                Map<String, CartItem> map = cart.getMap();
                for (String key : map.keySet()) {
                    OrderItem orderitem = new OrderItem();
                    orderitem.setItemid(UUIDUtils.getUUID());
                    orderitem.setCount(map.get(key).getCount());
                    orderitem.setSubtotal(map.get(key).getSubtotal());
                    orderitem.setPid(map.get(key).getProduct().getPid());
                    orderitem.setProduct(map.get(key).getProduct());
                    orderitem.setOid(order.getOid());
                    orderitemList.add(orderitem);
                }
                OrderService os = new OrderServiceImp();
                os.saveOrder(order);
                session.removeAttribute("cart");
                return "/order?method=orderList";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "/error.jsp";
        }
    }

    public String deleteOrder(HttpServletRequest request,HttpServletResponse response) throws SQLException {
        String oid = request.getParameter("oid");
        OrderService os = new OrderServiceImp();
        os.deleteOrder(oid);
        return "/order?method=orderList";
    }

}
