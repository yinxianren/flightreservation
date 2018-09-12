package com.yilvtong.first.flightreservation.mapper.boMapper;
import com.yilvtong.first.flightreservation.mapper.MapperModule;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DapMapper<Dep> extends MapperModule<Dep> {
    List<Dep> getDepByCompany(int id);

    /**
     *  统计该部门含有多少个员工
     * @param id
     * @return
     */
    int countDepAndAccount(int id);
}
