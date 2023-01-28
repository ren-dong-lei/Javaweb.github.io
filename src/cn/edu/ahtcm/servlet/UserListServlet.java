package cn.edu.ahtcm.servlet;
import cn.edu.ahtcm.bean.User;
import cn.edu.ahtcm.dao.Listdao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Listdao  dao = new Listdao();
        List<User> userList = dao.getUser();
        request.setAttribute("userList",userList);
        request.getRequestDispatcher("/admin/UserList.jsp").forward(request,response);
    }
}
