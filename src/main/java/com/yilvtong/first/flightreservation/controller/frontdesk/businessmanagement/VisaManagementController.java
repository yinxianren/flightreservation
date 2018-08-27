package com.yilvtong.first.flightreservation.controller.frontdesk.businessmanagement;

import com.yilvtong.first.flightreservation.controller.frontdesk.IFrontDeskController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  签证管理
 */
@RequestMapping("/body")
@Controller
public class VisaManagementController implements IFrontDeskController {



    // http://localhost:8080/body/busi-manage/visa-management
    @RequestMapping("/busi-manage/visa-management")
    @Override
    public String pageJump() {
        return "/frontdesk/body/businessManagement/visa-management";

    }
}
