package com.yilvtong.first.flightreservation.service.boservice;

import com.yilvtong.first.flightreservation.bo.User;
import com.yilvtong.first.flightreservation.mapper.boMapper.UseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UseService {

    @Autowired
    public UseMapper userMapper;

    public User getByIdAndAccount(int id,String account){
        try {
            User user = (User) userMapper.getByIdAndAccount(id, account);
            return user;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
