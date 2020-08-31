package com.neusoft.dao;

import com.neusoft.domain.User;

import java.sql.SQLException;

public interface UserDaoImpl {
    public User login(User loginUser) throws SQLException;
}
