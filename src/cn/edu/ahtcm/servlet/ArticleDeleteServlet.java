package cn.edu.ahtcm.servlet;

import cn.edu.ahtcm.dao.ArticleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ArticleDeleteServlet")
public class ArticleDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ArticleDao dao = new ArticleDao();
        boolean success = dao.deleteArticle(id);
        if (success){
            response.getWriter().print("删除成功");
        }else {
            response.getWriter().print("删除失败");
        }
    }

}

