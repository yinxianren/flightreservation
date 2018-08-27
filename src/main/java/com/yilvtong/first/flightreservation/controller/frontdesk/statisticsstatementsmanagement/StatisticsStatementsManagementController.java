package com.yilvtong.first.flightreservation.controller.frontdesk.statisticsstatementsmanagement;

import com.yilvtong.first.flightreservation.controller.frontdesk.IFrontDeskController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 报表统计管理
 */
@Controller
@RequestMapping("/body")
public class StatisticsStatementsManagementController implements IFrontDeskController {

    @RequestMapping("/statisticsstatementsmanagement/statistics-statements-management")
    @Override
    public String pageJump() {
        return "/frontdesk/body/statisticsStatementsManagement/statistics-statements-management";
    }
}
