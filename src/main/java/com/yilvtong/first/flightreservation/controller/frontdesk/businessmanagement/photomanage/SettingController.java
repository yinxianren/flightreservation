package com.yilvtong.first.flightreservation.controller.frontdesk.businessmanagement.photomanage;

import com.yilvtong.first.flightreservation.controller.ReturnResult;
import com.yilvtong.first.flightreservation.entity.frontdesk.Title;
import com.yilvtong.first.flightreservation.entity.frontdesk.User;
import com.yilvtong.first.flightreservation.service.frontdesk.TitleService;
import com.yilvtong.first.flightreservation.tool.DateTimeUtils;
import com.yilvtong.first.flightreservation.tool.StatusCode;
import com.yilvtong.first.flightreservation.tool.ftp.SingleFtpClientConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/photo")
public class SettingController {

    @Autowired
    private TitleService titleService;

    /**
     *  页面跳转
     * @param map
     * @return
     */
    @RequestMapping("/businessmanagement/photomanage/SettingController")
    public String pageJump(Map<String,Object> map,HttpSession session) {
        User user=(User)session.getAttribute("userInfo");
        List<Title>  titleList=titleService.getByUserID(user.getId());
        if(null!=titleList){
            map.put("titleList",titleList);
        }
        return "/frontdesk/body/businessManagement/photograph-setting-management";
    }

    /**
     *  插入title.title是为了保持图片的路径而准备的
     * @param title
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/businessmanagement/photomanage/SettingController/addTitle")
    public ReturnResult addTitle(@PathParam("title")String title, HttpSession session){
        User user=(User)session.getAttribute("userInfo");
        title=title.trim();
        ReturnResult rr=new ReturnResult();
        rr.setTitle("addTitle");
        if(StringUtils.isEmpty(title)){
            rr.setCode(StatusCode.INTERNAL_ERROR_400_04_01.getCode());
            rr.setMessage(StatusCode.INTERNAL_ERROR_400_04_01.getMsg());
            return rr;
        }
       int count= titleService.countByTitleAnd(title,user.getId());
       if(count>0){ //title已经在了
           rr.setCode(StatusCode.INTERNAL_ERROR_500_14_05.getCode());
           rr.setMessage(StatusCode.INTERNAL_ERROR_500_14_05.getMsg());
           return rr;
       }

        SingleFtpClientConnection singleFtpClientConnection=new SingleFtpClientConnection();
        //预先创建照片保存的根目录
        singleFtpClientConnection.init();
        boolean howmkdir=singleFtpClientConnection.mkdir("/home/ftpuser/www/images/"+user.getAccount()+"/"+title);
        if(!howmkdir){
            howmkdir=singleFtpClientConnection.mkdir("/home/ftpuser/www/images/"+user.getAccount());
            if(!howmkdir){
                rr.setCode(StatusCode.INTERNAL_ERROR_500_14_03.getCode());
                rr.setMessage(StatusCode.INTERNAL_ERROR_500_14_03.getMsg());
                singleFtpClientConnection.close();
                return rr;
            }else {
                howmkdir = singleFtpClientConnection.mkdir("/home/ftpuser/www/images/" + user.getAccount() + "/" + title);
                if(!howmkdir){
                    rr.setCode(StatusCode.INTERNAL_ERROR_500_14_03.getCode());
                    rr.setMessage(StatusCode.INTERNAL_ERROR_500_14_03.getMsg());
                    singleFtpClientConnection.close();
                    return rr;
                }
            }
        }
        Title tt=new Title();
        tt.setTitle(title);
        tt.setUserId(user.getId());
        tt.setCreateDate(DateTimeUtils.getCurrentDateTimeStr2());
        tt.setUpdate(DateTimeUtils.getCurrentDateTimeStr2());
        boolean how= titleService.add(tt);  //插入数据
        if(!how){
            rr.setCode(StatusCode.INTERNAL_ERROR_500_14_01.getCode());
            rr.setMessage(StatusCode.INTERNAL_ERROR_500_14_01.getMsg());
            singleFtpClientConnection.removeDirectory("/home/ftpuser/www/images/"+user.getAccount()+"/"+title);
            return rr;
        }
        singleFtpClientConnection.close();
        //程序无任何异常
        rr.setCode(StatusCode.SUCCESS.getCode());
        rr.setMessage(StatusCode.SUCCESS.getMsg());
        return rr;
    }








}
