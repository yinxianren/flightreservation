package com.yilvtong.first.flightreservation.controller.frontdesk.systemsettingmanagement.institutionalframeworkmanagement;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yilvtong.first.flightreservation.controller.frontdesk.IFrontDeskController;
import com.yilvtong.first.flightreservation.service.frontdesk.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/body")
public class ModifyPasswordManagementController implements IFrontDeskController{

    @Autowired
    private UserService userService;


    @RequestMapping("/systemsettingmanagement/institutional-framework-management/ifm_modify_password_management")
    @Override
    public String pageJump() {


        return "/frontdesk/body/systemSettingManagement/ifm_modify_password_management";

    }

    @RequestMapping("/systemsettingmanagement/institutional-framework-management/ifm_modify_password_management/mod")
    public String updataPassowrd(int id,String password,Map<String,Object> map){

       boolean how= userService.updataPassword(id,password);
       if(how){
           return "redirect:/body/systemsettingmanagement/institutional-framework-management/ifm_users_management";
       }
       String json="{id:"+password+";password:"+password+"}";
        map.put("message",json);
        return "/frontdesk/body/error500";
    }


}
