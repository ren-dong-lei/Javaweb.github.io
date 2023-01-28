package cn.edu.ahtcm.dao;

import cn.edu.ahtcm.bean.User;

import java.util.List;

public interface Userdao {
    /**
     *
     * @param name
     * @param password
     * @return
     */
    User login(String name, String password);

    /**
     *
     * @param name
     * @param password
     * @return
     */
    boolean register(String name, String password);

    /**
     *
     * @return
     */
    List<User> getUsers();
}

