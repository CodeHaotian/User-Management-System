package com.ums.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 登录验证的过滤器
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //0.强制转换
        HttpServletRequest request = (HttpServletRequest) req;

        //1.获取资源请求路径
        String uri = request.getRequestURI();
        //2.判断是否包含登录相关的资源路径
        if (uri.contains( "/login.jsp" ) || uri.contains( "/loginServlet" ) || uri.contains( "/checkCodeServlet" ) || uri.contains( "/css/" ) || uri.contains( "/fonts/" ) || uri.contains( "/js/" )) {
            //包含，用户想去登录。放行
            chain.doFilter( req, resp );
        } else {
            //不包含，需要验证用户是否登录
            //3.从session中获取user
            Object user = request.getSession().getAttribute( "user" );
            if (user != null) {
                //已经登录，放行
                chain.doFilter( req, resp );
            } else {
                //没有登录，跳转登录页面
                request.setAttribute( "login_msg", "您尚未登录，请先登录" );
                request.getRequestDispatcher( "login.jsp" ).forward( request, resp );
            }
        }


    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {

    }

}
