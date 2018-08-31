package com.yilvtong.first.flightreservation.controller.frontdesk.systemsettingmanagement.institutionalframeworkmanagement;

import com.yilvtong.first.flightreservation.controller.frontdesk.IFrontDeskController;
import com.yilvtong.first.flightreservation.entity.frontdesk.Department;
import com.yilvtong.first.flightreservation.service.frontdesk.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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


    /**
     *  删除指定的部门
     * @param id
     * @return
     */
    @ResponseBody
    @PostMapping("/systemsettingmanagement/institutional-framework-management/ifm_department_management/del")
    public boolean delDepartmentById(int id){
        Boolean  how=departmentService.delDepartmentById(id);
        if(how){
            return true;
        }else {
            return false;
        }
    }



    /**
     *  修改指定的部门
     * @param
     * @return
     */
    @ResponseBody
    @PostMapping("/systemsettingmanagement/institutional-framework-management/ifm_department_management/mod")
    public boolean modDepartmentById(Department dep){
        Boolean  how=departmentService.updateDepartmentById(dep);
        if(how){
            return true;
        }else {
            return false;
        }
    }



}
