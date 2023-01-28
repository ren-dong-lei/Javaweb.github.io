package cn.edu.ahtcm.servlet;

import cn.edu.ahtcm.bean.User;
import cn.edu.ahtcm.dao.Userdao;
import cn.edu.ahtcm.dao.UserdaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        System.out.println(name);
        System.out.println(password);
        //todo 查询数据表t_user 有没有该用户
        Userdao dao = new UserdaoImpl();
        User user = dao.login(name,password);
        if(user!=null){
            request.getSession().setAttribute("user",user);
            //重定向到后台管理界面
            response.sendRedirect("/admin/manage.jsp");
        }else{
            //请求转发
            request.getRequestDispatcher("/error.jsp").forward(request,response);
        }

    }
}



