package com.neusoft.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkCodeServlet")
public class checkCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 图片验证码
        int width = 100;
        int height = 50;
        //1. 创建一个 图片验证码对象
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // 2.美化图片
        Graphics g = image.getGraphics(); // 画笔对象
        g.setColor(Color.PINK);
        g.fillRect(0, 0, width, height);

        //画边框
        g.setColor(Color.BLUE);
        g.drawRect(0, 0, width-1, height-1);
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        // 随机选index
        Random random = new Random();
        StringBuffer checkCode = new StringBuffer();
        for (int i = 1; i <= 4 ; i++) {
            int index = random.nextInt(str.length());
            // 获取字符
            char ch = str.charAt(index);
            checkCode.append(ch);
            // 写验证码
            g.drawString(ch+"", width/5*i, height/2);
        }
        req.getSession().setAttribute("checkCode_session", checkCode.toString());

        // 画干扰线
        g.setColor(Color.GREEN);
        // 随机生成坐标
        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            g.drawLine(x1, y1, x2, y2);
        }

        // 将图片输出到页面中
        ImageIO.write(image, "jpg", resp.getOutputStream());
    }
}
