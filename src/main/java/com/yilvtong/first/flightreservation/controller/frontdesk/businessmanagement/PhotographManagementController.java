package com.yilvtong.first.flightreservation.controller.frontdesk.businessmanagement;

import com.yilvtong.first.flightreservation.controller.frontdesk.IFrontDeskController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 照片管理
 *
 */
@RequestMapping("/body")
@Controller
public class PhotographManagementController implements IFrontDeskController {




    // http://localhost:8080/body/busi-manage/photograph-management

    @RequestMapping("/busi-manage/photograph-management")
    @Override
    public String pageJump() {
        return "/frontdesk/body/businessManagement/photograph-management";
    }
}
