package com.yilvtong.first.flightreservation.controller.frontdesk.ordermanagement;

import com.yilvtong.first.flightreservation.controller.frontdesk.IFrontDeskController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 机票流程管理
 *
 *   http://localhost:8080/body/order-manage/air-ticket-process-management
 */
@RequestMapping("/body")
@Controller
public class AirTicketProcessManangementController implements IFrontDeskController {

    @RequestMapping("/order-manage/air-ticket-process-management")
    @Override
    public String pageJump() {
        return "/frontdesk/body/orderManagement/air-ticket-process-management";
    }
}
