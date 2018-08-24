package com.yilvtong.first.flightreservation.controller.frontdesk;

import com.yilvtong.first.flightreservation.entity.frontdesk.User;
import com.yilvtong.first.flightreservation.service.frontdesk.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserInfoController {

 @Autowired
 private UserInfoService userInfoService;

  public User varifyUserInfo(User  user){

      return null;
  }

    /**
     * http://localhost:8080/use/byId?id=10001
     * @param id
     * @return
     */
  @GetMapping("/use/byId")
  public User  getUserInfoById(int id){
      System.out.println("id==========="+id);
      return userInfoService.getUserInfoByidService(id);
  }



}
