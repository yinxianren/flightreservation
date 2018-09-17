package com.yilvtong.first.flightreservation.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UeditorTest {


    @RequestMapping("/test/ueditor/index")
    public String showIndex(){
        return "/test/ueditor-index";
    }

}
