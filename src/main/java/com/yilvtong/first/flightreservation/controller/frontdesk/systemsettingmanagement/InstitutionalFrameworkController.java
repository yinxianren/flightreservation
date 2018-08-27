package com.yilvtong.first.flightreservation.controller.frontdesk.systemsettingmanagement;

import com.yilvtong.first.flightreservation.controller.frontdesk.IFrontDeskController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 系统设置管理
 *
 */
@Controller
@RequestMapping("/body")
public class InstitutionalFrameworkController  {

    /**
     *   系统设置管理 --组织架构
     * @return
     */
    @RequestMapping("/systemsettingmanagement/institutional-framework-management")
//    @Override
    public String pageJump( Map<String, Object> map) {


        return "/frontdesk/body/systemSettingManagement/institutional-framework-management";
    }

    /**
     *  系统设置管理 --组织架构--公司管理
     * @return
     */
    @RequestMapping("/systemsettingmanagement/institutional-framework-management/ifm-company-management")
    public String gotoCompanyManagement(Map<String, Object> map){




        return "/frontdesk/body/systemSettingManagement/ifm-company-management";
    }





}
