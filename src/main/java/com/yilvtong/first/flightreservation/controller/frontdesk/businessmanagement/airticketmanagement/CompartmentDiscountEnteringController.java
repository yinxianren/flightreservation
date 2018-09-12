package com.yilvtong.first.flightreservation.controller.frontdesk.businessmanagement.airticketmanagement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping("/body")
@Controller
public class CompartmentDiscountEnteringController {


    @RequestMapping("/BusinessManagement/AirTicketManagement/CompartmentDiscountEnteringController")
    public String pageJump(Map<String,Object> map) {



        return "/frontdesk/body/businessManagement/atm-compartment-discount-entering";

    }


}
