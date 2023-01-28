package cn.edu.ahtcm.dao;

import cn.edu.ahtcm.bean.Article;
import cn.edu.ahtcm.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleDao {


    public boolean addArticle(String tile, String content) {
        Connection conn = DBUtil.getConnection();
        String sql = "insert into t_article(title,content) values(?,?)";
        int count = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tile);
            ps.setString(2, content);
            count = ps.executeUpdate();
            DBUtil.release(null, null, ps, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (count == 0) {
            return false;
        } else {
            return true;
        }
    }
    public List<Article> getArticles(){
        List<Article> articleList = new ArrayList<Article>();
        String sql = "select * from t_article";
        Connection conn = DBUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Article article = new Article();
                article.setId(rs.getInt("id"));
                article.setTitle(rs.getString("title"));
                article.setContent(rs.getString("content"));
                articleList.add(article);
            }
            DBUtil.release(rs,null,ps,conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articleList;
    }
    public  Article getArticleById(int id){
        String sql = "select * from t_article where id = ?";
        Connection conn = DBUtil.getConnection();
        Article article = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, String.valueOf(id));
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                article = new Article();
                article.setId(rs.getInt("id"));
                article.setTitle(rs.getString("title"));
                article.setContent(rs.getString("content"));
            }
            DBUtil.release(rs,null,ps,conn);
        } catch (SQLException e) {
            e.printStackTrace();  
    }
   return  article;
    }
    //删除操作
    public boolean deleteArticle(int id){
        String sql = "delete from t_article where id=?";
        Connection conn = DBUtil.getConnection();
        int count = 0;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            count = ps.executeUpdate();
            DBUtil.release(null,null,ps,conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(count==0){
            return false;
        }else {
            return true;
        }
    }


    public boolean updateArticle(int id) {
        String sql = "delete from t_article where id=?";
        Connection conn = DBUtil.getConnection();
        int count = 0;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            count = ps.executeUpdate();
            DBUtil.release(null,null,ps,conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(count==0){
            return false;
        }else {
            return true;
        }

    }
    /**
     * 更新文章
     * @param id
     * @param tile
     * @param content
     * @return
     */
    public boolean updateArticle(int id,String tile,String content){
        Connection conn = DBUtil.getConnection();
        String sql = "update t_article set title=?,content=? where id=?";
        int count = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,tile);
            ps.setString(2,content);
            ps.setInt(3,id);
            count = ps.executeUpdate();
            DBUtil.release(null,null,ps,conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(count==0){
            return false;
        }else {
            return true;
        }
    }

}




