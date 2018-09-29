package com.yilvtong.first.flightreservation.controller.frontdesk.systemsettingmanagement.institutionalframeworkmanagement;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yilvtong.first.flightreservation.bo.Cmpy;
import com.yilvtong.first.flightreservation.bo.Dep;
import com.yilvtong.first.flightreservation.controller.frontdesk.IFrontDeskController;
import com.yilvtong.first.flightreservation.entity.frontdesk.Company;
import com.yilvtong.first.flightreservation.entity.frontdesk.User;
import com.yilvtong.first.flightreservation.service.boservice.CmpyService;
import com.yilvtong.first.flightreservation.service.boservice.DepService;
import com.yilvtong.first.flightreservation.service.frontdesk.CompanyService;
import com.yilvtong.first.flightreservation.service.frontdesk.UserService;
import com.yilvtong.first.flightreservation.tool.DateTimeUtils;
import com.yilvtong.first.flightreservation.tool.ftp.SingleFtpClientConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/body")
public class AddUsersManagementController{

    @Autowired
    private UserService userService;

    @Autowired
    private CmpyService cmpyService;

    @Autowired
    private DepService depService;


    /**
     *  页面跳转到添加用户
     * @param map
     * @return
     */
    @RequestMapping("/systemsettingmanagement/institutional-framework-management/ifm_add_users_manage")
    public String pageJump(Map<String,Object> map) {

        List<Cmpy>  companyList=cmpyService.getAllCompany();
        map.put("companyList",companyList);
        return "/frontdesk/body/systemSettingManagement/ifm_add_users_manage";

    }

    /**
     *  添加用户
     * @param user
     * @param map
     * @return
     */
    @RequestMapping("/systemsettingmanagement/institutional-framework-management/ifm_add_users_manage/add")
    public String addUser(User user,Map<String,Object> map) {
        String time= DateTimeUtils.getCurrentDateTimeStr2();
        user.setUpdate(time);
        user.setCreateDate(time);
        boolean how=userService.add(user);
        if(how){
            SingleFtpClientConnection singleFtpClientConnection=new SingleFtpClientConnection();
            //预先创建照片保存的根目录
            singleFtpClientConnection.init();
            singleFtpClientConnection.mkdir("/home/ftpuser/www/images/"+user.getAccount());
            singleFtpClientConnection.close();
            return "redirect:/body/systemsettingmanagement/institutional-framework-management/ifm_users_management";
        }
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        map.put("message",json);
        return "/frontdesk/body/error500";

    }


    /**
     *  获取部门
     * @param id
     * @return
     */
    @RequestMapping("/systemsettingmanagement/institutional-framework-management/ifm_add_users_manage/getDep")
    @ResponseBody
    public List<Dep> getDepartment(int id){
        List<Dep> depList=depService.getDepByCompany(id);
        if(null!=depList){
            return depList;
        }
        return null;
    }

    /**
     *  检查账号是否存在
     * @param account
     * @return
     */
    @RequestMapping("/systemsettingmanagement/institutional-framework-management/ifm_add_users_manage/checkAccount")
    @ResponseBody
    public boolean checkAccount(@PathParam("account") String account){
        int in=userService.checkAccount(account);
        if(in>0){
            return false;
        }
        return true;
    }
}
