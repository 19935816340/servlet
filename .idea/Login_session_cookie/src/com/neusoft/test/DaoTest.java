package com.neusoft.test;


import com.neusoft.dao.UserDaoI.UserDao;
import com.neusoft.domain.User;
import org.junit.Test;

import java.sql.SQLException;

public class DaoTest {
    @Test
    public void test() throws SQLException {
        User loginUser = new User();
        loginUser.setUsername("zhangsan");
        loginUser.setPassword("123");

        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);
        System.out.println(user);
    }
}


