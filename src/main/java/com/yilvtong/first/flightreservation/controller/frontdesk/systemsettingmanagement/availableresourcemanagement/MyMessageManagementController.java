package com.yilvtong.first.flightreservation.controller.frontdesk.systemsettingmanagement.availableresourcemanagement;

import com.yilvtong.first.flightreservation.controller.frontdesk.IFrontDeskController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/body")
public class MyMessageManagementController implements IFrontDeskController {

    @RequestMapping("/systemsettingmanagement/available-resources-management/avaires_my_message_manage")
    @Override
    public String pageJump() {


        return "/frontdesk/body/systemSettingManagement/avaires_my_message_manage";

    }
}