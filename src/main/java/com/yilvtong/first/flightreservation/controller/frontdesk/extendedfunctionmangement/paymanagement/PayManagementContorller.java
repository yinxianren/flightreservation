package com.yilvtong.first.flightreservation.controller.frontdesk.extendedfunctionmangement.paymanagement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pay")
public class PayManagementContorller {


    @RequestMapping("/extendedfunctionmangement/reptilemanagement/payManage")
    public String pageJump(){

        return "/frontdesk/body/extendedFunctionManagement/pay-function-management";
    }

}
