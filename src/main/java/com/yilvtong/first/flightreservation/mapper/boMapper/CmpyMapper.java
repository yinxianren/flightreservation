package com.yilvtong.first.flightreservation.mapper.boMapper;

import com.yilvtong.first.flightreservation.mapper.MapperModule;
import org.springframework.stereotype.Repository;

@Repository
public interface CmpyMapper<Cmpy> extends MapperModule<Cmpy> {

    /**
     *  统计传入的公司id 被多少个部门所依赖
     * @param id
     * @return
     */
    int countComAndDep(int id);



}
