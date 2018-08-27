package com.yilvtong.first.flightreservation.controller.frontdesk.financeManagement;

import com.yilvtong.first.flightreservation.controller.frontdesk.IFrontDeskController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/body")
@Controller
public class FinanceManagementController implements IFrontDeskController{

    @RequestMapping("/financemanagement/finance-management")
    @Override
    public String pageJump() {
        return "/frontdesk/body/financeManagement/finance-management";
    }
}
