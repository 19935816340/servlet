package com.neusoft.dao.Impl;

import com.neusoft.dao.UserDao;
import com.neusoft.domain.User;
import com.neusoft.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDaoImpl implements UserDao {
    private  Connection conn =null;
    private PreparedStatement ps =null;
    private ResultSet rs =null;
    private User user =null;


    @Override
    public User login(User loginUser) throws SQLException {

        String sql = "select * from user where username = ? and password = ?";

        try{
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,loginUser.getUsername() );
            ps.setString(2, loginUser.getPassword());
            rs = ps.executeQuery();
            while (rs.next()){
                user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs, ps, conn);
        }
        return user;
    }
}