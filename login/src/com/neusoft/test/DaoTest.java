package com.neusoft.test;

import com.neusoft.dao.Impl.UserDaoImpl;
import com.neusoft.dao.UserDao;
import com.neusoft.domain.User;
import org.junit.Test;

import java.sql.SQLException;

public class DaoTest {
    @Test
    public void test() throws SQLException {
        User loginUser = new User();
        loginUser.setUsername("张三");
        loginUser.setPassword("123");

        UserDao dao = new UserDaoImpl();
        User user = dao.login(loginUser);
        System.out.println(user);
    }
}


