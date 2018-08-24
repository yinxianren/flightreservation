package com.yilvtong.first.flightreservation.mapper.frontdesk;

import com.yilvtong.first.flightreservation.entity.frontdesk.User;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper {
    /**
     *  根据id获取唯一用户
     * @param id
     * @return
     */
    User getUserById(int id);



}
