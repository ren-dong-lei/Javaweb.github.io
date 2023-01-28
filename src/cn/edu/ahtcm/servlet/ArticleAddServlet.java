package cn.edu.ahtcm.servlet;

import cn.edu.ahtcm.dao.ArticleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ArticleAddServlet")
public class ArticleAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        ArticleDao dao = new ArticleDao();
        boolean success = dao.addArticle(title,content);
        if (success){
            response.sendRedirect("/admin/manage.jsp");
        }else {
            request.setAttribute("error","文章添加失败");
            request.getRequestDispatcher("/error.jsp").forward(request,response);
      }
    }
}
