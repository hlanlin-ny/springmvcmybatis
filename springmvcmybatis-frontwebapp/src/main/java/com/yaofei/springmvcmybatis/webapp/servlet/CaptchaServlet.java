package com.yaofei.springmvcmybatis.webapp.servlet;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * Created by f_yao on 2016/9/10.
 */
public class CaptchaServlet extends HttpServlet {

    //不包括0，O，1,I 等难以识别的字符
    public static final char[] CHARS = {'2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    public static Random random = new Random();

    public static String getRandomString() {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            buffer.append(CHARS[random.nextInt(CHARS.length)]);
        }
        return buffer.toString();
    }

    public static Color getRandomColor() {
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    public static Color getReverseColor(Color color) {
        return new Color(255 - color.getRed(), 255 - color.getGreen(), 255 - color.getBlue());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/jpeg");
        String randomString = getRandomString();
        request.getSession(true).setAttribute("randomString", randomString);

        int width = 100;
        int height = 30;

        Color color = getRandomColor();
        Color reverse = getReverseColor(color);

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        Graphics2D g = bufferedImage.createGraphics();
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        g.setColor(color);
        //绘制背景
        g.fillRect(0, 0, width, height);
        g.setColor(reverse);
        g.drawString(randomString, 18, 20);
        //画 最多100个噪音点
        for (int i = 0, n = random.nextInt(100); i < n; i++) {
            g.drawRect(random.nextInt(width),random.nextInt(height),1,1);
        }
        ServletOutputStream outputStream=response.getOutputStream();
        //转成JPEG格式
        //编码器
        JPEGImageEncoder encoder= JPEGCodec.createJPEGEncoder(outputStream);
        //对图片进行编码
        encoder.encode(bufferedImage);
        outputStream.flush();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}