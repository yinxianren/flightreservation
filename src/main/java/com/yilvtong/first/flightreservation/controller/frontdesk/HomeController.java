package com.yilvtong.first.flightreservation.controller.frontdesk;


import com.yilvtong.first.flightreservation.tool.VerifyUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

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
    public Map<String,Object>  getVerifyCode(HttpSession session){

        Map<String,Object> map=new HashMap<>();
        map.put("status","imageCode");
        map.put("content",session.getAttribute("imageCode"));
        return map;
    }



}
