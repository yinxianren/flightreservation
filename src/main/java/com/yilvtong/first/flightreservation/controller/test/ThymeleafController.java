package com.yilvtong.first.flightreservation.controller.test;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {


    /**
     *
     *   http://localhost:8080/thymeleaf/test
     * @param map
     * @return
     */
    @RequestMapping("/test")
    public String hello(Map<String, Object> map) {
        map.put("name", "fanfan");
        map.put("age",29);
        map.put("addr","xiaMenShi");
        return "test/test01";
    }


}
