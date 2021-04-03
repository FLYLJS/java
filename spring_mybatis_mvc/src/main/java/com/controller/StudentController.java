package com.controller;


import com.domain.Student;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.VolatileImage;
import java.io.IOException;

/**
 * @author Administrator
 */
@Controller
public class StudentController {

    /**
     * 自定义类型转换 保存用户
     * @param student
     * @return
     */
    @RequestMapping("saveStudent")
    public String saveStudent(Student student){
        System.out.println(student);
        return "success";
    }

    /**
     * 请求转发
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("testForward")
    public void testForward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println(request.getServletPath());
//        System.out.println(request.getRequestURI());
        /**
         * 转发
         */
//        request.getRequestDispatcher("/WEB-INF/page/success.jsp").forward(request,response);

        /**
         * 重定向
         */
//        response.sendRedirect(request.getContextPath()+"index.jsp");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html:charset=UTF-8");
        response.getWriter().write("直接响应页面");
    }
}
