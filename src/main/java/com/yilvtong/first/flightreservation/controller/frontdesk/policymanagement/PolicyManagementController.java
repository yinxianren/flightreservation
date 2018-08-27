package com.yilvtong.first.flightreservation.controller.frontdesk.policymanagement;

import com.yilvtong.first.flightreservation.controller.frontdesk.IFrontDeskController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 政策管理
 */
@RequestMapping("/body")
@Controller
public class PolicyManagementController implements IFrontDeskController{

    @RequestMapping("/policymanagement/policy-management")
    @Override
    public String pageJump() {
        return "/frontdesk/body/policyManagement/policy-management";
    }
}
