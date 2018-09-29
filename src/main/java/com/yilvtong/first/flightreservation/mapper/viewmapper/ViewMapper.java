package com.yilvtong.first.flightreservation.mapper.viewmapper;


import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ViewMapper<T> {


    /**
     *   带分页查询,一次最多30条记录
     * @param uid      用户id
     * @param offset   偏移量
     * @param rowNum  行数
     * @return
     */
    List<T> getByUidAndLimit(@Param("uid") int uid,@Param("offset") int offset,@Param("rowNum") int rowNum);


}
