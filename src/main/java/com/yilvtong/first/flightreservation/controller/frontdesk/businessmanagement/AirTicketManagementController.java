package com.yilvtong.first.flightreservation.controller.frontdesk.businessmanagement;

import com.yilvtong.first.flightreservation.controller.frontdesk.IFrontDeskController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *   机票管理
 *
 */
@RequestMapping("/body")
@Controller
public class AirTicketManagementController implements IFrontDeskController {



    // http://localhost:8080/body/busi-manage/air-ticket-management

    @RequestMapping("/busi-manage/air-ticket-management")
    @Override
    public String pageJump() {
        return "/frontdesk/body/businessManagement/air-ticket-management";
    }
}
