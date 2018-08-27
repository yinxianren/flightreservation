package com.yilvtong.first.flightreservation.controller.frontdesk.customerrelationsmangement;

import com.yilvtong.first.flightreservation.controller.frontdesk.IFrontDeskController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 客户维护
 */
@Controller
@RequestMapping("/body")
public class CustomerMaintainManagementController implements IFrontDeskController {

    @RequestMapping("/customerrelationsmanagement/customer-maintain-management")
    @Override
    public String pageJump() {
        return "/frontdesk/body/customerRelationsManagement/customer-maintain-management";
    }
}
