package servlet;

import bean.Product;
import bean.ProductPage;
import service.ProductService;
import service.ProductServiceImp;
import utils.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends BaseServlet {
    public String product_page(HttpServletRequest request,HttpServletResponse response){
        try {
            //获取当前页数
            int pageNumber = Integer.parseInt(request.getParameter("pagenumber"));
            //设置每页显示商品条数
            int pageSize = 12;
            //查询商品总条数
            ProductService ps = new ProductServiceImp();
            int productCount = ps.getProductCount();
            //封装数据到pagebean
            ProductPage<Product> pp = new ProductPage(pageNumber, pageSize);
            pp.setProductCount(productCount);
            //查询当前页显示商品列表
            List<Product> list = ps.getList(pp.getPageIndex(),pp.getPageSize());
            pp.setList(list);
            //将pagebean放入request域对象
            request.setAttribute("pp",pp );
            return "/product_list.jsp";

        } catch (Exception e) {
            e.printStackTrace();
            return "/error.jsp";
        }
    }

    public String search_result(HttpServletRequest request,HttpServletResponse response){
        try {
            //获取当前页数
            int pageNumber = Integer.parseInt(request.getParameter("pagenumber"));
            //设置每页显示商品条数
            int pageSize = 12;
            String keyword = request.getParameter("keyword");
            //查询商品总条数
            ProductService ps = new ProductServiceImp();
            int productCount = ps.getSerachCount(keyword);
            //封装数据到pagebean
            ProductPage<Product> pp = new ProductPage(pageNumber, pageSize);
            pp.setProductCount(productCount);
            //查询当前页显示商品列表
            List<Product> list = ps.getSearchList(keyword,pp.getPageIndex(),pp.getPageSize());
            pp.setList(list);
            //将pagebean放入request域对象
            request.setAttribute("pp",pp );
            request.setAttribute("key", keyword);
            return "/product_list.jsp";

        } catch (Exception e) {
            e.printStackTrace();
            return "/error.jsp";
        }
    }

    public String product_info(HttpServletRequest request,HttpServletResponse response){
        try {
            String pid = request.getParameter("pid");
            ProductService ps = new ProductServiceImp();
            Product pro = ps.getProduct(pid);
            request.setAttribute("pro", pro);
            return "/product_info.jsp";
        } catch (SQLException e) {
            e.printStackTrace();
            return "/error.jsp";
        }
    }

    public String cart(HttpServletRequest request,HttpServletResponse response){
        try {
            return "/cart.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            return "/error.jsp";
        }
    }

}
