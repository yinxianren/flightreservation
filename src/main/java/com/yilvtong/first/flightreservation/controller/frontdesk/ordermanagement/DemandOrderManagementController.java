package com.yilvtong.first.flightreservation.controller.frontdesk.ordermanagement;

import com.yilvtong.first.flightreservation.controller.frontdesk.IFrontDeskController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 需求订单管理
 *
 *    http://localhost:8080/body/order-manage/demand-order-management
 */
@RequestMapping("/body")
@Controller
public class DemandOrderManagementController  implements IFrontDeskController {


    @RequestMapping("/order-manage/demand-order-management")
    @Override
    public String pageJump() {
        return "/frontdesk/body/orderManagement/demand-order-management";

    }
}

