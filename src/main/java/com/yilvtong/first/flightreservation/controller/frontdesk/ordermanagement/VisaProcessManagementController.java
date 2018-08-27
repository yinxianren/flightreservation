package com.yilvtong.first.flightreservation.controller.frontdesk.ordermanagement;

import com.yilvtong.first.flightreservation.controller.frontdesk.IFrontDeskController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 签证流程管理
 *    http://localhost:8080/body/order-manage/visa-process-management
 */
@RequestMapping("/body")
@Controller
public class VisaProcessManagementController implements IFrontDeskController {

    @RequestMapping("/order-manage/visa-process-management")
    @Override
    public String pageJump() {
        return "/frontdesk/body/orderManagement/visa-process-management";
    }
}
