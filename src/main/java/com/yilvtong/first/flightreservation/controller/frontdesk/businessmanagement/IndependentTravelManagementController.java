package com.yilvtong.first.flightreservation.controller.frontdesk.businessmanagement;

import com.yilvtong.first.flightreservation.controller.frontdesk.IFrontDeskController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  自由行管理
 *
 *
 *    http://localhost:8080/body/busi-manage/independent-travel-management
 */
@RequestMapping("/body")
@Controller
public class IndependentTravelManagementController implements IFrontDeskController {







    @RequestMapping("/busi-manage/independent-travel-management")
    @Override
    public String pageJump() {
        return "/frontdesk/body/businessManagement/independent-travel-management";
    }
}
