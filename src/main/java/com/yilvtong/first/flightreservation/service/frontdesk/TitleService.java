package com.yilvtong.first.flightreservation.service.frontdesk;

import com.yilvtong.first.flightreservation.entity.frontdesk.Title;
import com.yilvtong.first.flightreservation.mapper.frontdesk.TitleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TitleService extends  ServiceParent<Title>{

    private TitleMapper titleMapper;

    @Autowired
    public  TitleService(TitleMapper titleMapper){
        super.setMapperModule(titleMapper);
        this.titleMapper=titleMapper;
    }




    /**
     *  根据用户id 获取相关信息
     * @param useId
     * @return
     */
    public List<Title> getByUserID(int useId){
       try {
           return titleMapper.getByUserID(useId);
       }catch(Exception e){
           e.printStackTrace();
           return null;
       }
    }

    /**
     *  判断title 是否存在
     * @param title
     * @return
     */
    public int countByTitleAnd(String title,int uid){
      try {
          return titleMapper.countByTitleAnd(title,uid);
      }catch (Exception e){
          e.printStackTrace();
          return 500;
      }
    }

}
