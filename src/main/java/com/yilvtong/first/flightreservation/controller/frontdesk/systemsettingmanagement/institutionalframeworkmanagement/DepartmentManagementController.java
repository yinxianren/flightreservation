package com.yilvtong.first.flightreservation.controller.frontdesk.systemsettingmanagement.institutionalframeworkmanagement;

import com.yilvtong.first.flightreservation.controller.frontdesk.IFrontDeskController;
import com.yilvtong.first.flightreservation.entity.frontdesk.Department;
import com.yilvtong.first.flightreservation.service.frontdesk.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@RequestMapping("/body")
@Controller
public class DepartmentManagementController  {

    @Autowired
    private DepartmentService departmentService;


    @RequestMapping("/systemsettingmanagement/institutional-framework-management/ifm_department_management")
    public String pageJump(Map<String,Object> map) {

        List<Department> list= departmentService.getAllDepartment();
        map.put("lists",list);

        return "/frontdesk/body/systemSettingManagement/ifm_department_management";

    }





}
