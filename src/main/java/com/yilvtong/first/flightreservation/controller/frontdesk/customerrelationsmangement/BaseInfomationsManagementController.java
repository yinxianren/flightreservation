package com.yilvtong.first.flightreservation.controller.frontdesk.customerrelationsmangement;

import com.yilvtong.first.flightreservation.controller.frontdesk.IFrontDeskController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 客户基本信息管理
 */
@Controller
@RequestMapping("/body")
public class BaseInfomationsManagementController implements IFrontDeskController{
    @RequestMapping("/customerrelationsmanagement/base-info-management")
    @Override
    public String pageJump() {
        return "/frontdesk/body/customerRelationsManagement/base-info-management";
    }
}
