package com.ums.web.servlet;


import com.ums.domain.Admin;
import com.ums.service.AdminService;
import com.ums.service.impl.AdminServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 登录处理
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编码
        req.setCharacterEncoding( "utf-8" );

        //2.获取数据
        //2.1 获取用户输入验证码
        String verifycode = req.getParameter( "verifycode" );

        //3.验证码校验
        HttpSession session = req.getSession();
        //3.1 获取存放在session作用域中的验证码，忽略大小写比较，需要String类型，强转
        String checkcode_server = (String) req.getSession().getAttribute( "CHECKCODE_SERVER" );
        //3.2 确保验证码一次性
        session.removeAttribute( "CHECKCODE_SERVER" );
        //验证码不正确
        if (!checkcode_server.equalsIgnoreCase( verifycode )) {
            //提示信息
            req.setAttribute( "login_msg", "验证码错误！" );
            //跳转登录页面
            req.getRequestDispatcher( "/login.jsp" ).forward( req, resp );
            return;
        }

        Map<String, String[]> map = req.getParameterMap();
        //4.封装admin对象
        Admin admin = new Admin();
        try {
            BeanUtils.populate( admin, map );
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //5.调用Service查询
        AdminService service = new AdminServiceImpl();
        Admin loginUser = service.login( admin );

        //6.判断是否登录成功
        if (loginUser != null) {
            //登录成功
            //创建cookie储存session的id
            Cookie c = new Cookie( "JSESSIONID", session.getId() );
            //设置持久化时间
            c.setMaxAge( 60 * 60 );
            resp.addCookie( c );
            //将用户存入持久化的session中
            session.setAttribute( "admin", loginUser );
            //跳转页面
            resp.sendRedirect( "/index.jsp" );
        } else {
            //登录失败，提示信息
            req.setAttribute( "login_msg", "用户名或密码错误！" );
            //跳转登录页面
            req.getRequestDispatcher( "/login.jsp" ).forward( req, resp );
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost( req, resp );
    }
}
