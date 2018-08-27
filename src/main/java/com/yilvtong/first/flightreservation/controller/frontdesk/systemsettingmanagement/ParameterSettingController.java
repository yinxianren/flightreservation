package com.yilvtong.first.flightreservation.controller.frontdesk.systemsettingmanagement;

import com.yilvtong.first.flightreservation.controller.frontdesk.IFrontDeskController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/body")
public class ParameterSettingController implements IFrontDeskController {
    @Override
    @RequestMapping("/systemsettingmanagement/parameter-setting-management")
    public String pageJump() {
        return "/frontdesk/body/systemSettingManagement/parameter-setting-management";
    }
}
