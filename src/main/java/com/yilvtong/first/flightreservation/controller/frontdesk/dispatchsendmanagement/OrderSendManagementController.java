package com.yilvtong.first.flightreservation.controller.frontdesk.dispatchsendmanagement;

import com.yilvtong.first.flightreservation.controller.frontdesk.IFrontDeskController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/body")
public class OrderSendManagementController  implements IFrontDeskController {


    @RequestMapping("/dispatchsendmanagement/order-send-management")
    @Override
    public String pageJump() {
        return "/frontdesk/body/dispatchSendManagement/order-send-management";

    }
}
