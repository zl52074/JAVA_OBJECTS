package servlet;

import bean.User;
import com.google.gson.Gson;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import service.UserServiceImp;
import utils.BaseServlet;
import utils.UUIDUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends BaseServlet {
    //请求转发登陆页面
    public String login(HttpServletRequest request,HttpServletResponse response){
        System.out.println("1112332");
        return "/login.jsp";
    }
    //请求转发注册页面
    public String register(HttpServletRequest request,HttpServletResponse response){
        return "/register.jsp";
    }

    public String quitLogin(HttpServletRequest request,HttpServletResponse response){
        request.getSession().removeAttribute("user");
        return "/product?method=product_page&pagenumber=1";
    }

    //ajax请求验证验证码
    public String validateCode(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String sessionYzm = (String)request.getSession().getAttribute("sessionYzm");
        String code = request.getParameter("code");
        Map<String,String> map1 = new HashMap<>();
        Map<String,String> map2 = new HashMap<>();
        map1.put("invalid","true");
        map2.put("valid","true");
        Gson g = new Gson();
        String f= g.toJson(map1);
        String t = g.toJson(map2);
        if(!sessionYzm.equals(code.toUpperCase())){
            response.getWriter().print(f);
        }else{
            response.getWriter().print(t);
        }
        return null;
    }

    //ajax请求验证用户名
    public String validateUsername(HttpServletRequest request,HttpServletResponse response) throws Exception {
        String username = request.getParameter("username");
        Map<String,String> map1 = new HashMap<>();
        Map<String,String> map2 = new HashMap<>();
        map1.put("invalid","true");
        map2.put("valid","true");
        Gson g = new Gson();
        String f= g.toJson(map1);
        String t = g.toJson(map2);
        UserServiceImp us  = new UserServiceImp();
        int intValue = us.queryUsername(username);
        if(intValue!=0){
            response.getWriter().print(f);
        }else{
            response.getWriter().print(t);
        }
        return null;
    }
    //ajax请求验证邮箱
    public String validateEmail(HttpServletRequest request,HttpServletResponse response) throws Exception {
        String email = request.getParameter("email");
        Map<String,String> map1 = new HashMap<>();
        Map<String,String> map2 = new HashMap<>();
        map1.put("invalid","true");
        map2.put("valid","true");
        Gson g = new Gson();
        String f= g.toJson(map1);
        String t = g.toJson(map2);
        UserServiceImp us  = new UserServiceImp();
        int intValue = us.queryEmail(email);
        if(intValue!=0){
            response.getWriter().print(f);
        }else{
            response.getWriter().print(t);
        }
        return null;
    }

    //请求登陆
    public String submitLogin(HttpServletRequest request,HttpServletResponse response){
        //获取前台录入的数据  map
        try {
            Map<String, String[]> map = request.getParameterMap();
            //创建bean
            User submit = new User();
            //把map中的数据拷贝到bean中
            BeanUtils.populate(submit, map);
            //创建service对象
            UserServiceImp us  = new UserServiceImp();
            User user = us.queryUser(submit);
            System.out.println("Login"+submit+" "+user);
            if(user==null){
                request.setAttribute("msg", "账号或者密码有误，请重新输入");
                return "/login.jsp";
            }else{
                request.getSession().setAttribute("user", user);
                return "/product?method=product_page&pagenumber=1";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "/error.jsp";
        }
    }

    public String submitRegister(HttpServletRequest request,HttpServletResponse response){
        try {
            //获取前台录入的数据  map
            Map<String, String[]> map = request.getParameterMap();
            //创建bean
            User user = new User();
            //把map中的数据拷贝到bean中
            BeanUtils.populate(user, map);
            user.setUid(UUIDUtils.getUUID());
            System.out.println("Register:"+user);
            //创建service对象
            UserServiceImp us  = new UserServiceImp();
            //调用service方法传递数据
            us.saveUser(user);
            return "/userpage.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "RegisterServlet");
            return "/error.jsp";
        }
    }
}
