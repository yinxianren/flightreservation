package com.yilvtong.first.flightreservation.controller.frontdesk.businessmanagement;

import com.yilvtong.first.flightreservation.controller.frontdesk.IFrontDeskController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  酒店管理
 *
 *
 *   http://localhost:8080/body/busi-manage/hotel-management
 */
@RequestMapping("/body")
@Controller
public class HotelManagementController implements IFrontDeskController {




    @RequestMapping("/busi-manage/hotel-management")
    @Override
    public String pageJump() {
        return"/frontdesk/body/businessManagement/hotel-management";
    }
}
