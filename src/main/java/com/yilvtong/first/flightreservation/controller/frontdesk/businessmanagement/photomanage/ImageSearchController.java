package com.yilvtong.first.flightreservation.controller.frontdesk.businessmanagement.photomanage;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/photo")
public class ImageSearchController {



    @RequestMapping("/businessmanagement/photomanage/ImageSearchController")
    public String pageJump(Map<String,Object> map) {


        return "/frontdesk/body/businessManagement/photograph-search-management";
    }

}
