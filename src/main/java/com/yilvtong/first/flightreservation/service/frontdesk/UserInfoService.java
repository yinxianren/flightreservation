package com.yilvtong.first.flightreservation.service.frontdesk;

import com.yilvtong.first.flightreservation.entity.frontdesk.User;
import com.yilvtong.first.flightreservation.mapper.frontdesk.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

    @Autowired
    private  UserMapper userMapper;


    public User getUserInfoByidService(int id){
       return userMapper.getUserById(id);
    }
}
