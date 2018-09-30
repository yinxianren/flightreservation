package com.yilvtong.first.flightreservation.controller.frontdesk.extendedfunctionmangement.reptilemanagement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reptile")
public class ReptileBrainpowerController {


    @RequestMapping("/extendedfunctionmangement/reptilemanagement/reptileBrainpower")
    public String pageJump(){

        return "/frontdesk/body/extendedFunctionManagement/reptile-brainpower";
    }

}
