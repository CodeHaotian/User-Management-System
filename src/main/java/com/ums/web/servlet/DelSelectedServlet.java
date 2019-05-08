package com.ums.web.servlet;

import com.ums.service.UserService;
import com.ums.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除选中列
 */
@WebServlet("/delSelectedServlet")
public class DelSelectedServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取所有的id
        String[] ids = request.getParameterValues( "uid" );

        //2.调用service删除
        UserService service = new UserServiceImpl();
        service.delSelectedUser( ids );

        //3.跳转查询所有的servlet
        response.sendRedirect( request.getContextPath() + "/findUserByPageServlet" );

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost( request, response );
    }
}
