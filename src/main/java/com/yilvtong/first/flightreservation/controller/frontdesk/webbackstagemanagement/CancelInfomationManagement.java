package com.yilvtong.first.flightreservation.controller.frontdesk.webbackstagemanagement;

import com.yilvtong.first.flightreservation.controller.frontdesk.IFrontDeskController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/body")
public class CancelInfomationManagement implements IFrontDeskController {

    @RequestMapping("/webbackstagemanagement/cancel-info-management")
    @Override
    public String pageJump() {
        return "/frontdesk/body/webBack-stageManagement/cancel-info-management";
    }
}
