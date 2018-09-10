package com.yilvtong.first.flightreservation.config;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptorAdapter extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if(null==request.getSession().getAttribute("userInfo")){
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }
        return true;
    }


}



