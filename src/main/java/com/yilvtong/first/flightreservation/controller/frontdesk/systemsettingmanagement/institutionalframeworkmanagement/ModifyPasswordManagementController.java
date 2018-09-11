package com.yilvtong.first.flightreservation.controller.frontdesk.systemsettingmanagement.institutionalframeworkmanagement;

import com.yilvtong.first.flightreservation.bo.User;
import com.yilvtong.first.flightreservation.controller.ReturnResult;
import com.yilvtong.first.flightreservation.controller.frontdesk.IFrontDeskController;
import com.yilvtong.first.flightreservation.service.frontdesk.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @Autowired
    private  com.yilvtong.first.flightreservation.service.boservice.UseService useService;

    @ResponseBody
    @RequestMapping("/systemsettingmanagement/institutional-framework-management/ifm_modify_password_management/modpw")
    public ReturnResult modifyPassword(User user){
        ReturnResult returnResult=new ReturnResult();
        User usr= useService.getByIdAndAccount(user.getId(),user.getAccount());
       if(null==usr){
           returnResult.setCode(400);
           returnResult.setMessage("该用户不存在");
           returnResult.setStatus("failure");
           return returnResult;
       }

       if(!user.getOldPassword().equals(usr.getOldPassword())){
           returnResult.setCode(400);
           returnResult.setMessage("密码错误");
           returnResult.setStatus("failure");
           return returnResult;
       }


        boolean how= userService.updataPassword(usr.getId(),user.getNewPassword());

       if(how){
           returnResult.setCode(200);
           returnResult.setMessage("修改成功");
           returnResult.setStatus("success");
           return returnResult;
       }
        returnResult.setCode(400);
        returnResult.setMessage("内部错误！");
        returnResult.setStatus("failure");
        return returnResult;
    }




}
