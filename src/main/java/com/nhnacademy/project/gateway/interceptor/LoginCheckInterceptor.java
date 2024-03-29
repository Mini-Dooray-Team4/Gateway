package com.nhnacademy.project.gateway.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);

        if(session == null || session.getAttribute("user") == null) {

            response.sendRedirect("/auth/login");
            return false;
        }
        // 로그인 되어있을 떄
        return true;
    }
}
