package com.yilvtong.first.flightreservation.controller.frontdesk.systemsettingmanagement.institutionalframeworkmanagement;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yilvtong.first.flightreservation.bo.Cmpy;
import com.yilvtong.first.flightreservation.bo.Dep;
import com.yilvtong.first.flightreservation.controller.frontdesk.IFrontDeskController;
import com.yilvtong.first.flightreservation.entity.frontdesk.Department;
import com.yilvtong.first.flightreservation.service.boservice.CmpyService;
import com.yilvtong.first.flightreservation.service.boservice.DepService;
import com.yilvtong.first.flightreservation.service.frontdesk.DepartmentService;
import com.yilvtong.first.flightreservation.tool.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@RequestMapping("/body")
@Controller
public class DepartmentManagementController  {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private CmpyService cmpyService;

    @RequestMapping("/systemsettingmanagement/institutional-framework-management/ifm_department_management")
    public String pageJump(Map<String,Object> map) {

        List<Department> list= departmentService.getAll();//对象全
        map.put("lists",list);

        return "/frontdesk/body/systemSettingManagement/ifm_department_management";

    }

    /**
     *  跳转到添加页面
     *
     * @return
     */
    @RequestMapping("/systemsettingmanagement/institutional-framework-management/ifm_department_add_management")
    public String pageJumpToAdd(Map<String,Object> map) {

        List<Cmpy> cmpyList=cmpyService.getAllCompany();
        map.put("cmpyList",cmpyList);
        return "/frontdesk/body/systemSettingManagement/ifm_department_add_management";

    }


    /**
     *  跳转到修改页面
     *
     * @return
     */
    @RequestMapping("/systemsettingmanagement/institutional-framework-management/ifm_department_modify_management")
    public String pageJumpToModify(@RequestParam("id") int id,
                                   Map<String,Object> map) {

        Department department= (Department) departmentService.getById(id);
        map.put("department",department);
        return "/frontdesk/body/systemSettingManagement/ifm_department_modify_management";

    }



    /**
     *  删除指定的部门
     * @param id
     * @return
     */
    @ResponseBody
    @PostMapping("/systemsettingmanagement/institutional-framework-management/ifm_department_management/del")
    public boolean delDepartmentById(int id){
        Boolean  how=departmentService.delById(id);
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
    @PostMapping("/systemsettingmanagement/institutional-framework-management/ifm_department_management/mod")
    public String modDepartmentById(Department dep,Map<String,Object> map){

        dep.setUpdate(DateTimeUtils.getCurrentDateTimeStr2());
        dep.setCompanyName(null); //不更新
        dep.setDepName(null);//不更新
        Boolean  how=departmentService.updataById(dep);
        if(how){
            return "redirect:/body/systemsettingmanagement/institutional-framework-management/ifm_department_management";
//            return RedirectToAction("/body/systemsettingmanagement/institutional-framework-management/ifm_department_management");
        }else {
            ObjectMapper mapper = new ObjectMapper();
            String json = null;
            try {
                json = mapper.writeValueAsString(dep);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            map.put("message",json);
            return "/frontdesk/body/error500";
        }
    }



    /**
     * 添加部门
     * @param
     * @return
     */
    @PostMapping("/systemsettingmanagement/institutional-framework-management/ifm_department_management/add")
    public String addDepartmentById(Department dep,Map<String,Object> map){

        String date= DateTimeUtils.getCurrentDateTimeStr2();
        dep.setCreateDate(date);
        dep.setUpdate(date);
        Boolean  how=departmentService.add(dep);
        if(how){
            return "redirect:/body/systemsettingmanagement/institutional-framework-management/ifm_department_management";
        }
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(dep);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        map.put("message",json);
        return "/frontdesk/body/error500";

    }





}
