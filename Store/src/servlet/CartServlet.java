package servlet;

import bean.Cart;
import bean.CartItem;
import bean.Product;
import service.ProductService;
import service.ProductServiceImp;
import utils.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CartServlet", urlPatterns = "/cart")
public class CartServlet extends BaseServlet {
    private Cart getCart(HttpServletRequest request){
        // 获取session
        HttpSession session = request.getSession();
        Cart cart =(Cart)session.getAttribute("cart");
        if(cart==null)
        {
            // 创建购物车
            cart=new Cart();
            // 放在session中
            session.setAttribute("cart", cart);
        }
        return cart;
    }


    public String addCart(HttpServletRequest request, HttpServletResponse response) {
        try {
            String pid = request.getParameter("pid");
            int count = Integer.parseInt(request.getParameter("count"));
            ProductService ps = new ProductServiceImp();
            Product pro = ps.getProduct(pid);
            System.out.println(pid + " " + count + " " + pro);
            CartItem item = new CartItem();
            item.setProduct(pro);
            item.setCount(count);
            Cart cart = getCart(request);
            cart.add(item);
            request.setAttribute("cart", cart);
            return "/cart.jsp";
        } catch (SQLException e) {
            e.printStackTrace();
            return "/error.jsp";
        }
    }
    // 删除购物项
    public String remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // 获取id
        String pid = request.getParameter("pid");
        // 获取购物车
        Cart cart = getCart(request);
        // 调用购物车删除的方法
        cart.remove(pid);

        // 重定向
        return "/cart.jsp";
    }


    // 清空购物车
    public String removeAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // 获取购物车
        Cart cart = getCart(request);
        // 调用清空方法
        cart.clear();
        // 重定向
        return "/cart.jsp";
    }
}
