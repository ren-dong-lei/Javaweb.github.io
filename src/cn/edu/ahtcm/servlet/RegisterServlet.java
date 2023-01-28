package cn.edu.ahtcm.servlet;

import cn.edu.ahtcm.dao.Userdao;
import cn.edu.ahtcm.dao.UserdaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        System.out.println(name);
        System.out.println(password);
        Userdao dao = new UserdaoImpl();
        boolean success =dao.register(name,password);
        if (success) {
            response.sendRedirect("/login.jsp");
        }else{
            request.getRequestDispatcher("/error.jsp").forward(request,response);
        }

    }
}
