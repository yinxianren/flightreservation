package com.yilvtong.first.flightreservation.controller.frontdesk.extendedfunctionmangement;

import com.yilvtong.first.flightreservation.controller.frontdesk.IFrontDeskController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/body")
@Controller
public class ExtendedFunctionManagementController implements IFrontDeskController{
    @Override
    @RequestMapping("/extnetedfunctionmangement/extended-function-management")
    public String pageJump() {
        return "/frontdesk/body/extendedFunctionManagement/extended-function-management";
    }
}
