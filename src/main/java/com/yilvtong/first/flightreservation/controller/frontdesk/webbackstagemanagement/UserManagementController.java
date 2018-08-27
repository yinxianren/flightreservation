package com.yilvtong.first.flightreservation.controller.frontdesk.webbackstagemanagement;

import com.yilvtong.first.flightreservation.controller.frontdesk.IFrontDeskController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/body")
public class UserManagementController implements IFrontDeskController {
    @Override
    @RequestMapping("/webbackstagemanagement/user-management")
    public String pageJump() {
        return "/frontdesk/body/webBack-stageManagement/user-management";
    }
}
