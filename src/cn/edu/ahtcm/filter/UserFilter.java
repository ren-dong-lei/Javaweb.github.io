package cn.edu.ahtcm.filter;

import cn.edu.ahtcm.bean.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter( "/admin/*")
public class UserFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest)req;
        HttpServletResponse httpResponse = (HttpServletResponse)resp;
        User user = (User)httpRequest.getSession().getAttribute("user");
        if (user == null){
            httpResponse.sendRedirect("/login.jsp");
        }else{
            chain.doFilter(req, resp);
        }
    }


    public void init(FilterConfig config) throws ServletException {

    }

}
