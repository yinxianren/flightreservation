package com.yilvtong.first.flightreservation.controller.frontdesk.systemsettingmanagement.institutionalframeworkmanagement;

import com.yilvtong.first.flightreservation.controller.frontdesk.IFrontDeskController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/body")
public class CompanyManagementController implements IFrontDeskController{

    @RequestMapping("/systemsettingmanagement/institutional-framework-management/ifm-company-management")
    @Override
    public String pageJump() {

        return "/frontdesk/body/systemSettingManagement/ifm-company-management";

    }
}
