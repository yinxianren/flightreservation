package com.yilvtong.first.flightreservation.controller.frontdesk.businessmanagement;


import com.yilvtong.first.flightreservation.controller.frontdesk.IFrontDeskController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *  其他
 *
 *
 *  http://localhost:8080/body/busi-manage/other-management
 */
@RequestMapping("/body")
@Controller
public class OtherManagementController implements IFrontDeskController {




    @RequestMapping("/busi-manage/other-management")
    @Override
    public String pageJump() {
        return "/frontdesk/body/businessManagement/other-management";
    }
}
