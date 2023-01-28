package cn.edu.ahtcm.servlet;

import cn.edu.ahtcm.bean.Article;
import cn.edu.ahtcm.dao.ArticleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ArticleDetailServlet")
public class ArticleDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //获取id；
        int id = Integer.parseInt(request.getParameter("id"));//字符1强制转换为int型
        ArticleDao dao = new ArticleDao();
        Article article = dao.getArticleById(id);
        request.setAttribute("article",article);
        request.getRequestDispatcher("/articleDetail.jsp").forward(request,response);
    }
}
