package com.yilvtong.first.flightreservation.controller.frontdesk.systemsettingmanagement.institutionalframeworkmanagement;

import com.yilvtong.first.flightreservation.controller.frontdesk.IFrontDeskController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/body")
@Controller
public class DepartmentManagementController implements IFrontDeskController {

    @RequestMapping("/systemsettingmanagement/institutional-framework-management/ifm_department_management")
    @Override
    public String pageJump() {

        return "/frontdesk/body/systemSettingManagement/ifm_department_management";

    }

    @RequestMapping("/systemsettingmanagement/institutional-framework-management/ifm_department_management/modifyDepartmentInfo")
    public String modifyDepartmentInfo(){

        return "/frontdesk/body/systemSettingManagement/ifm_department_modify_management";
    }




}
