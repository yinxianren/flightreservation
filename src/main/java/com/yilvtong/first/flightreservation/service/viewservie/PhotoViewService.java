package com.yilvtong.first.flightreservation.service.viewservie;


import com.yilvtong.first.flightreservation.entity.view.PhotoView;
import com.yilvtong.first.flightreservation.mapper.viewmapper.PhotoViewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoViewService {

    @Autowired
    private PhotoViewMapper photoViewMapper;



    /**
     *   带分页查询,一次最多30条记录
     *@param uid      用户id
     *@param page      页数
     * @return
     */
   public List<PhotoView> getByUidAndLimit(int uid, int page){
     try {
         int rowNum=30;
         int offset=(page-1)*30;
         return photoViewMapper.getByUidAndLimit(uid,offset,rowNum);
     }catch(Exception e){
         e.printStackTrace();
         return null;
     }
    }



}
