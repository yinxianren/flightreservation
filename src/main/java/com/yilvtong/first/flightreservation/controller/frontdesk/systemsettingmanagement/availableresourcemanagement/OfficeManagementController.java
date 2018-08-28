package com.yilvtong.first.flightreservation.controller.frontdesk.systemsettingmanagement.availableresourcemanagement;

import com.yilvtong.first.flightreservation.controller.frontdesk.IFrontDeskController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/body")
public class OfficeManagementController implements IFrontDeskController {

    @RequestMapping("/systemsettingmanagement/available-resources-management/avaires_office_manage")
    @Override
    public String pageJump() {


        return "/frontdesk/body/systemSettingManagement/avaires_office_manage";

    }
}