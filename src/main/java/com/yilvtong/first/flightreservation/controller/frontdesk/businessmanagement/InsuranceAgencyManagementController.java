package com.yilvtong.first.flightreservation.controller.frontdesk.businessmanagement;

import com.yilvtong.first.flightreservation.controller.frontdesk.IFrontDeskController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  保险代理管理
 *
 *
 *
 *   http://localhost:8080/body/busi-manage/insurance-agency-management
 */
@RequestMapping("/body")
@Controller
public class InsuranceAgencyManagementController implements IFrontDeskController {



    @RequestMapping("/busi-manage/insurance-agency-management")
    @Override
    public String pageJump() {
        return "/frontdesk/body/businessManagement/insurance-agency-management";
    }
}
