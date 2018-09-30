package com.yilvtong.first.flightreservation.controller.frontdesk.extendedfunctionmangement.reptilemanagement;


import com.yilvtong.first.flightreservation.entity.frontdesk.Title;
import com.yilvtong.first.flightreservation.entity.frontdesk.User;
import com.yilvtong.first.flightreservation.service.frontdesk.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/reptile")
public class ReptilePictureController {

    @Autowired
    private TitleService titleService;


      @RequestMapping("/extendedfunctionmangement/reptilemanagement/reptilePicture")
      public String pageJump(){


          return "/frontdesk/body/extendedFunctionManagement/reptile-picture";
      }


}
