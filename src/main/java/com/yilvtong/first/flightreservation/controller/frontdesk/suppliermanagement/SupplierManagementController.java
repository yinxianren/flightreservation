package com.yilvtong.first.flightreservation.controller.frontdesk.suppliermanagement;

import com.yilvtong.first.flightreservation.controller.frontdesk.IFrontDeskController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 供应商管理
 */
@RequestMapping("/body")
@Controller
public class SupplierManagementController implements IFrontDeskController {

    @RequestMapping("/suppliermanagement/supplier-management")
    @Override
    public String pageJump() {
        return "/frontdesk/body/supplierManagement/supplier-management";
    }
}
