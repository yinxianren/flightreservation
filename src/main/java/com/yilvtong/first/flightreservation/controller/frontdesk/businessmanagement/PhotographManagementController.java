package com.yilvtong.first.flightreservation.controller.frontdesk.businessmanagement;

import com.yilvtong.first.flightreservation.controller.ReturnResult;
import com.yilvtong.first.flightreservation.entity.frontdesk.User;
import com.yilvtong.first.flightreservation.entity.view.PhotoView;
import com.yilvtong.first.flightreservation.service.frontdesk.PhotoService;
import com.yilvtong.first.flightreservation.service.viewservie.PhotoViewService;
import com.yilvtong.first.flightreservation.tool.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
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
    @Autowired
    private PhotoService photoService;

    @RequestMapping("/busi-manage/photograph-management")
    public String pageJump(Map<String,Object> map, HttpSession session) {
        User user=(User)session.getAttribute("userInfo");
        List<PhotoView> photoList = photoViewService.getByUidAndLimit(user.getId(), 1);
        map.put("photoList",photoList);
        return "/frontdesk/body/businessManagement/photograph-management";
    }

    /**
     *  删除图片，底层并不是真正删除，只是隐藏图片而已
     * @param pid
     * @param aid
     * @return
     */
    @ResponseBody
    @RequestMapping("/busi-manage/photograph-management/del")
    public ReturnResult delPhoto(@PathParam("pid") int pid,@PathParam("aid")int aid){

        ReturnResult rr=new ReturnResult();
        if(pid==0||aid==0){
            rr.setCode(StatusCode.INTERNAL_ERROR_400_04_01.getCode());
            rr.setMessage(StatusCode.INTERNAL_ERROR_400_04_01.getMsg());
            return rr;
        }
        boolean how=photoService.updataAndDeleter(pid,aid);
        if(!how){
            rr.setCode(StatusCode.INTERNAL_ERROR_500_13.getCode());
            rr.setMessage(StatusCode.INTERNAL_ERROR_500_13.getMsg());
            return rr;
        }
        rr.setCode(StatusCode.SUCCESS.getCode());
        rr.setMessage(StatusCode.SUCCESS.getMsg());
        return rr;
    }


}
