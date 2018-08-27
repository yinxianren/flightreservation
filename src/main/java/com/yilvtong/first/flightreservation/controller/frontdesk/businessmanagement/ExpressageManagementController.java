package com.yilvtong.first.flightreservation.controller.frontdesk.businessmanagement;

import com.yilvtong.first.flightreservation.controller.frontdesk.IFrontDeskController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  快递管理
 *
 *
 *  http://localhost:8080/body/busi-manage/expressage-management
 */

@RequestMapping("/body")
@Controller
public class ExpressageManagementController implements IFrontDeskController {





    @RequestMapping("/busi-manage/expressage-management")
    @Override
    public String pageJump() {
        return "/frontdesk/body/businessManagement/expressage-management";
    }
}
