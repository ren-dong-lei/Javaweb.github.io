package cn.edu.ahtcm.servlet;

import cn.edu.ahtcm.dao.ArticleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ArticleUpdateServlet")
public class ArticleUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        ArticleDao dao = new ArticleDao();
        //根据id更新文章
        boolean success = dao.updateArticle(id,title,content);
        if (success){
            response.sendRedirect("/ArticleListServlet");
        }else {
            request.setAttribute("error","文章更新失败");
            request.getRequestDispatcher("/error.jsp").forward(request,response);
        }

    }
}
