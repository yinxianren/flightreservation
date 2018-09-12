package com.yilvtong.first.flightreservation.controller.frontdesk.businessmanagement.airticketmanagement;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping("/body")
@Controller
public class YCompartmentPriceMaintenanceController {



    @RequestMapping("/BusinessManagement/AirTicketManagement/YCompartmentPriceMaintenanceController")
    public String pageJump(Map<String,Object> map) {



        return "/frontdesk/body/businessManagement/atm-Y-compartment-price-maintenance";

    }
}
