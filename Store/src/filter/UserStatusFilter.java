package filter;

import bean.User;
import sun.misc.Request;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.SequenceInputStream;

@WebFilter(filterName = "UserStatusFilter",urlPatterns ="/order" )
public class UserStatusFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        Object user = request.getSession().getAttribute("user");
        String url = "/forcelogin.jsp";
        if(user==null){
            request.getRequestDispatcher(url).forward(request,response );
        }
        else{
        chain.doFilter(request, response);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
