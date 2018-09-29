package com.yilvtong.first.flightreservation.mapper.frontdesk;

import com.yilvtong.first.flightreservation.entity.frontdesk.Title;
import com.yilvtong.first.flightreservation.mapper.MapperModule;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TitleMapper extends MapperModule<Title> {

    /**
     *  根据用户id 获取相关信息
     * @param useId
     * @return
     */
   List<Title> getByUserID(int useId);

    /**
     *  主要用于判断title 是否已经存在
     * @param title
     * @return
     */
   int countByTitleAnd(@Param("title") String title,@Param("id") int uid);

}
