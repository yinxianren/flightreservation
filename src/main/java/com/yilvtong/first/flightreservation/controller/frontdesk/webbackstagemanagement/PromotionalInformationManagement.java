package com.yilvtong.first.flightreservation.controller.frontdesk.webbackstagemanagement;

import com.yilvtong.first.flightreservation.controller.frontdesk.IFrontDeskController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/body")
public class PromotionalInformationManagement implements IFrontDeskController {

    @RequestMapping("/webbackstagemanagement/promotional-info-management")
    @Override
    public String pageJump() {
        return "/frontdesk/body/webBack-stageManagement/promotional-info-management";
    }
}
