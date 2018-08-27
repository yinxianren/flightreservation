package com.yilvtong.first.flightreservation.controller.frontdesk.dispatchsendmanagement;

import com.yilvtong.first.flightreservation.controller.frontdesk.IFrontDeskController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/body")
public class ExpressageSendManagementController implements IFrontDeskController {


    @RequestMapping("/dispatchsendmanagement/expressage-send-management")
    @Override
    public String pageJump() {
        return "/frontdesk/body/dispatchSendManagement/expressage-send-management";
    }
}
