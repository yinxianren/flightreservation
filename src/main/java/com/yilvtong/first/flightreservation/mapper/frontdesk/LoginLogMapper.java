package com.yilvtong.first.flightreservation.mapper.frontdesk;

import com.yilvtong.first.flightreservation.mapper.MapperModule;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginLogMapper<LoginLog> extends MapperModule<LoginLog> {

    LoginLog getByAccount(String account);

}
