package com.yilvtong.first.flightreservation.controller.frontdesk.businessmanagement;

import com.yilvtong.first.flightreservation.controller.frontdesk.IFrontDeskController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *   旅游团管理
 *
 *   http://localhost:8080/body/busi-manage/tourist-groups-management
 */

@RequestMapping("/body")
@Controller
public class TouristGroupsManagementController implements IFrontDeskController {





    @RequestMapping("/busi-manage/tourist-groups-management")
    @Override
    public String pageJump() {
        return "/frontdesk/body/businessManagement/tourist-groups-management";

    }
}
