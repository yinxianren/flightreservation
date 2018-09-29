package com.yilvtong.first.flightreservation.controller.frontdesk.businessmanagement;

import com.yilvtong.first.flightreservation.entity.frontdesk.User;
import com.yilvtong.first.flightreservation.entity.view.PhotoView;
import com.yilvtong.first.flightreservation.service.viewservie.PhotoViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * 照片管理
 *
 */
@RequestMapping("/body")
@Controller
public class PhotographManagementController {


    @Autowired
    private PhotoViewService photoViewService;//访问的数据库视图

    // http://localhost:8080/body/busi-manage/photograph-management

    @RequestMapping("/busi-manage/photograph-management")
    public String pageJump(Map<String,Object> map, HttpSession session) {
        User user=(User)session.getAttribute("userInfo");
        List<PhotoView> photoList = photoViewService.getByUidAndLimit(user.getId(), 1);
        map.put("photoList",photoList);
        return "/frontdesk/body/businessManagement/photograph-management";
    }






}
