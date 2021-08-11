package Filter;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns = "/ShoppingCart.jsp")
public class LoginFilter implements Filter {
    public void destroy (){
    }

    public void doFilter (ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException{
        HttpServletRequest request=(HttpServletRequest) req;
       String username=(String) request.getSession().getAttribute("username");
        System.out.println(request.getRemoteAddr());
        if (username==null)  {
            request.getRequestDispatcher("Login.jsp").forward(req,resp);
        }
        System.out.println(request.getRemoteAddr());
            chain.doFilter(req, resp);

    }

    public void init (FilterConfig config) throws ServletException{

    }

}
