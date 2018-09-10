package com.yilvtong.first.flightreservation.service.frontdesk;

import com.yilvtong.first.flightreservation.mapper.frontdesk.LoginLogMapper;
import com.yilvtong.first.flightreservation.service.ServiceModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginLogService<LoginLog>  implements ServiceModule<LoginLog> {

    @Autowired
    private LoginLogMapper loginLogMapper;


    public LoginLog getByAccount(String account){
        try {
            LoginLog loginLog = (LoginLog) loginLogMapper.getByAccount(account);
            return loginLog;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }


    @Override
    public LoginLog getById(int id) {
        return null;
    }

    @Override
    public List<LoginLog> getAll() {
        try{
            return loginLogMapper.getAll();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean delById(int id) {
        return false;
    }

    @Override
    public boolean updataById(LoginLog loginLog) {
        return false;
    }

    @Override
    public boolean add(LoginLog loginLog) {
        try {
            loginLogMapper.add(loginLog);
            return true;
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
