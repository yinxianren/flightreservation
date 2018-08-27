package com.yilvtong.first.flightreservation.controller.frontdesk.systemsettingmanagement;

import com.yilvtong.first.flightreservation.controller.frontdesk.IFrontDeskController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/body")
public class InstitutionalFrameworkController implements IFrontDeskController {
    @RequestMapping("/systemsettingmanagement/institutional-framework-management")
    @Override
    public String pageJump() {
        return "/frontdesk/body/systemSettingManagement/institutional-framework-management";
    }
}
