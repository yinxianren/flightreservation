package com.yilvtong.first.flightreservation.controller.frontdesk.businessmanagement;

import com.yilvtong.first.flightreservation.controller.frontdesk.IFrontDeskController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *    证照管理
 *   http://localhost:8080/body/busi-manage/license-management
 */
@RequestMapping("/body")
@Controller
public class LicenseManagementController implements IFrontDeskController {






    @RequestMapping("/busi-manage/license-management")
    public String pageJump() {
        return "/frontdesk/body/businessManagement/license-management";
    }
}
