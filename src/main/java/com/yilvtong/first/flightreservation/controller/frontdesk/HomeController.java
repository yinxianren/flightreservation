package com.yilvtong.first.flightreservation.controller.frontdesk;


import com.yilvtong.first.flightreservation.controller.ReturnResult;
import com.yilvtong.first.flightreservation.entity.frontdesk.User;
import com.yilvtong.first.flightreservation.service.frontdesk.UserService;
import com.yilvtong.first.flightreservation.tool.VerifyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    /**
     *  http://localhost:8080/
     * @return
     */
    @RequestMapping("/")
    public String home(){
        return "frontdesk/home/index";
    }



    /**
     * @author
     * @date
     * @param
     * @desc 图形验证码生成方法
     *
     */
    @RequestMapping("/home/valicode")
    public void valicode(HttpServletResponse response, HttpSession session) throws Exception {
        //利用图片工具生成图片
        //第一个参数是生成的验证码，第二个参数是生成的图片
        Object[] objs = VerifyUtil.createImage();
        //将验证码存入Session
        session.setAttribute("imageCode", objs[0]);

        //将图片输出给浏览器
        BufferedImage image = (BufferedImage) objs[1];
        response.setContentType("image/png");
        OutputStream os = response.getOutputStream();
        ImageIO.write(image, "png", os);
    }

    @ResponseBody
    @RequestMapping("/home/imageCode")
    public ReturnResult  getVerifyCode(HttpSession session){

        ReturnResult rr=new ReturnResult();
        rr.setStatus("success");
        String ic=(String)session.getAttribute("imageCode");
        rr.setMessage(ic);
        rr.setCode(202);
        rr.setTitle("imageCode");
        return rr;
    }


    @ResponseBody
    @RequestMapping("/home/login")
    public ReturnResult checkLogin(@PathParam("name") String uname,
                                   @PathParam("password") String password,
                                   HttpSession session
                                   ){
        User user=(User)userService.getUserInfo(uname,password);
        ReturnResult<User> rr=new ReturnResult<User>();
        if(null!=user){
            rr.setTitle("login");
            rr.setCode(200);
            rr.setStatus("success");
            session.setAttribute("userInfo",user);
            return rr;
        }
        rr.setTitle("login");
        rr.setCode(401);
        rr.setStatus("failed");
        return rr;
    }


}
