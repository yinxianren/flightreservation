package com.yilvtong.first.flightreservation.controller.frontdesk;


import com.yilvtong.first.flightreservation.entity.frontdesk.LoginLog;
import com.yilvtong.first.flightreservation.entity.frontdesk.User;
import com.yilvtong.first.flightreservation.service.frontdesk.LoginLogService;
import com.yilvtong.first.flightreservation.tool.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@RequestMapping("/body")
@Controller
public class BodyController {

    @Autowired
    private LoginLogService loginLogService;

    //http://localhost:8080/body/index
    @RequestMapping("/index")
    public String gotoBody(HttpServletRequest request,HttpSession session){

        return "/frontdesk/body/index";
    }



    @RequestMapping("/index/login")
    public String gotoLogin(HttpServletRequest request,HttpSession session){

        try {
            LoginLog ll=new LoginLog();
            User usr= (User) session.getAttribute("userInfo");
            ll.setAccount(usr.getAccount());
            ll.setIpAddr(getIpAddr(request));
            ll.setCreateDate( DateTimeUtils.getCurrentDateTimeStr2());
            loginLogService.add(ll);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/frontdesk/body/index";
    }



    public String getIpAddr(HttpServletRequest request) throws Exception {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }


}
