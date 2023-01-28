package cn.edu.ahtcm.dao;

import cn.edu.ahtcm.bean.User;
import cn.edu.ahtcm.util.DBUtil;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Listdao {
    public boolean addArticle(String id, String name) {
        Connection conn = DBUtil.getConnection();
        String sql = "insert into t_usr(id,name ) values(?,?)";
        int count = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, name);
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

    public List<User> getUser() {
        List<User> userList = new ArrayList<User>();
        String sql = "select * from t_usr";
        Connection conn = DBUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                userList.add(user);
            }
            DBUtil.release(rs, null, ps, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public User getUserById(int id) {

        String sql = "select * from t_usr where id=?";
        Connection conn = DBUtil.getConnection();
        User user = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
            }
            DBUtil.release(rs, null, ps, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


}
