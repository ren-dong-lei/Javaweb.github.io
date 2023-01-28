package cn.edu.ahtcm.servlet;

import cn.edu.ahtcm.bean.Article;
import cn.edu.ahtcm.dao.ArticleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ArticleEditServlet")
public class ArticleEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        ArticleDao dao = new ArticleDao();
        //根据id查询该文章内容
        Article article = dao.getArticleById(id);
        if(article!=null){
            request.setAttribute("article",article);
            System.out.println(article.getTitle());
            //页面转发到编辑界面
            request.getRequestDispatcher("/admin/articleEdit.jsp").forward(request,response);
        }else{
            request.setAttribute("error","文章编辑失败");
            request.getRequestDispatcher("/error.jsp").forward(request,response);
        }

    }
}

