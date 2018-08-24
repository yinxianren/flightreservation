package com.yilvtong.first.flightreservation.controller.frontdesk;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@RequestMapping("/body")
@Controller
public class BodyController {

    //http://localhost:8080/body/index
    @RequestMapping("/index")
    public String gotoBody(){


        return "/frontdesk/body/index";
    }




}
