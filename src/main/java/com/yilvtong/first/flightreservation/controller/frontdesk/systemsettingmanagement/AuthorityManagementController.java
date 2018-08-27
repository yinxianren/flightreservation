package com.yilvtong.first.flightreservation.controller.frontdesk.systemsettingmanagement;

import com.yilvtong.first.flightreservation.controller.frontdesk.IFrontDeskController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/body")
public class AuthorityManagementController implements IFrontDeskController {

    @RequestMapping("/systemsettingmanagement/authority-management")
    @Override
    public String pageJump() {
        return "/frontdesk/body/systemSettingManagement/authority-management";
    }
}
