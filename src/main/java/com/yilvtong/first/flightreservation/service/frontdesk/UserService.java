package com.yilvtong.first.flightreservation.service.frontdesk;

import com.yilvtong.first.flightreservation.mapper.frontdesk.UserMapper;
import com.yilvtong.first.flightreservation.service.ServiceModule;
import com.yilvtong.first.flightreservation.tool.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService<User> implements ServiceModule<User> {

    @Autowired
    private  UserMapper userMapper;




    @Override
    public User getById(int id) {
        try {
            return (User)userMapper.getById(id);
        }catch(Exception e){
            e.printStackTrace();
            return  null;
        }
    }

    @Override
    public List<User> getAll() {
        try {
            return userMapper.getAll();
        }catch(Exception e){
            e.printStackTrace();
            return  null;
        }
    }

    @Override
    public boolean delById(int id) {
        try {
            userMapper.delById(id);
        }catch(Exception e){
            e.printStackTrace();
            return  false;
        }
        return true;
    }

    @Override
    public boolean updataById(User user) {
        try {
            userMapper.updataById(user);
        }catch(Exception e){
            e.printStackTrace();
            return  false;
        }
        return true;
    }

    /**
     *  更新密码
     * @param id
     * @param ps
     * @return
     */
    public boolean updataPassword(int id,String ps) {
        try {
            userMapper.updataPassword(id,ps,DateTimeUtils.getCurrentDateTimeStr2());
        }catch(Exception e){
            e.printStackTrace();
            return  false;
        }
        return true;
    }

    @Override
    public boolean add(User user) {
        try {
            userMapper.add(user);
        }catch(Exception e){
            e.printStackTrace();
            return  false;
        }
        return true;
    }

    /**
     *    冻结账户
     * @param id
     * @param status
     * @return
     */
    public boolean freezeAccount(int id,int status){
        try {

            userMapper.freezeAccount(id,status,DateTimeUtils.getCurrentDateTimeStr2());
        }catch(Exception e){
            e.printStackTrace();
            return  false;
        }
        return true;
    }

    public User getUserInfo(String un,String ps){
      try {
          User user = (User) userMapper.getUserInfo(un, ps);
          return user;
      }catch(Exception e){
          e.printStackTrace();
          return null;
      }
    }
}
