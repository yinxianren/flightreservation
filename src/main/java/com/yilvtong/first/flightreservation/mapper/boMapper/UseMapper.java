package com.yilvtong.first.flightreservation.mapper.boMapper;

import com.yilvtong.first.flightreservation.mapper.MapperModule;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UseMapper<User> extends MapperModule<User> {

    User getByIdAndAccount(@Param("id") int id, @Param("account")String account);

}
