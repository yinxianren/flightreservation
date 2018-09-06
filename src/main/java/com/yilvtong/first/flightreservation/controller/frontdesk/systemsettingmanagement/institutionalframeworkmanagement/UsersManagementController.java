package com.yilvtong.first.flightreservation.controller.frontdesk.systemsettingmanagement.institutionalframeworkmanagement;

import com.yilvtong.first.flightreservation.controller.frontdesk.IFrontDeskController;
import com.yilvtong.first.flightreservation.entity.frontdesk.User;
import com.yilvtong.first.flightreservation.service.frontdesk.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/body")
public class UsersManagementController  {

    @Autowired
    private UserService userService;

    @RequestMapping("/systemsettingmanagement/institutional-framework-management/ifm_users_management")
    public String pageJump(Map<String,Object> map) {
        List<User> userList=userService.getAll();

        map.put("userList",userList);

        return "/frontdesk/body/systemSettingManagement/ifm_users_management";
    }

    @ResponseBody
    @RequestMapping("/systemsettingmanagement/institutional-framework-management/ifm_users_management/freeze")
    public boolean freezeAccuont(@PathParam("id") int id, @PathParam("status")int status){
       boolean how=userService.freezeAccount(id,status);
       if(how){
           return true;
       }
       return false;
    }


    @ResponseBody
    @RequestMapping("/systemsettingmanagement/institutional-framework-management/ifm_users_management/del")
    public boolean delAccuont(@PathParam("id") int id){
        boolean how=userService.delById(id);
        if(how){
            return true;
        }
        return false;
    }


}
