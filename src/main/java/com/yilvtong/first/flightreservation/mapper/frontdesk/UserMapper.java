package com.yilvtong.first.flightreservation.mapper.frontdesk;

import com.yilvtong.first.flightreservation.mapper.MapperModule;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper<User> extends MapperModule<User> {

    boolean updataPassword(@Param("id")int id,@Param("password")String password,@Param("update")String update);
    boolean freezeAccount(@Param("id")int id,@Param("status")int status,@Param("update")String update);
    User getUserInfo(@Param("account")String account, @Param("password")String password);
}
