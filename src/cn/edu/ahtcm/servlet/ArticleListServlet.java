package cn.edu.ahtcm.servlet;

import cn.edu.ahtcm.bean.Article;
import cn.edu.ahtcm.dao.ArticleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ArticleListServlet")
public class ArticleListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArticleDao dao = new ArticleDao();
        List<Article> articleList = dao.getArticles();
        request.setAttribute("articleList",articleList);
        request.getRequestDispatcher("/admin/articleList.jsp").forward(request,response);

    }

}
