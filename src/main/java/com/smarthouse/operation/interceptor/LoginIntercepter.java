package com.smarthouse.operation.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginIntercepter implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String url = request.getRequestURI();
        System.out.println("----->" + url);
        //URL:login.jsp是公开的;这个demo是除了login.jsp是可以公开访问的，其它的URL都进行拦截控制
        if(url.indexOf("login")>=0 || url.indexOf("index") >=0){
            return true;
        }
        //获取Session
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
//        String userId = (String)session.getAttribute("userId");

        if(username != null){
            return true;
        }
        //不符合条件的，跳转到登录界面
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);

        return false;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
