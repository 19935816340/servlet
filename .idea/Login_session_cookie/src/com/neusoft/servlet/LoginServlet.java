package com.neusoft.servlet;

import com.neusoft.dao.UserDaoI.UserDao;
import com.neusoft.dao.UserDaoImpl;
import com.neusoft.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
String checkCode = null;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        checkCode = req.getParameter("checkCode");
    }
            @Override
            protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           doGet(req,resp);
             User loginUser = new User();

                HttpSession session = req.getSession();
                String name = req.getParameter("loginName");
                String ps = req.getParameter("loginPs");
                System.out.println(name + " "+ ps);
                loginUser.setUsername(name);
                loginUser.setPassword(ps);
                System.out.println(loginUser);
                String checkCode_session = (String) session.getAttribute("checkCode_session");
                session.removeAttribute("checkCode_session");
                UserDaoImpl userDao = new UserDao();
                if (checkCode_session != null && checkCode_session.equalsIgnoreCase(checkCode)) {

                    // 判断 用户名和密码是否正确
                    try {
                        if (userDao.login(loginUser) != null) {
                            // 登录成功
                            //  将用户的信息存储到session里面
                            session.setAttribute("user", loginUser.getUsername());

                            //  重定向到success.jsp页面
                            resp.sendRedirect(req.getContextPath() + "/success.jsp");
                        } else {
                            req.setAttribute("login_error", "账号或密码错误，请重新登录");
                            req.getRequestDispatcher(req.getContextPath() + "/login.jsp").forward(req, resp);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else {
                    req.setAttribute("cc_error", "验证码错误");
                    req.getRequestDispatcher(req.getContextPath() + "/login.jsp").forward(req, resp);
                }
            }
        }
