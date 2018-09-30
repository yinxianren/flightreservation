package com.yilvtong.first.flightreservation.controller.frontdesk.extendedfunctionmangement.reptilemanagement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reptile")
public class ReptileManagementController {


    @RequestMapping("/extendedfunctionmangement/reptilemanagement/reptileManage")
    public String pageJump(){

        return "/frontdesk/body/extendedFunctionManagement/reptile-function-management";
    }

}
