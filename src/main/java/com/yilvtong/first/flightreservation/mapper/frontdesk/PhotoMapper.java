package com.yilvtong.first.flightreservation.mapper.frontdesk;

import com.yilvtong.first.flightreservation.entity.frontdesk.Photo;
import com.yilvtong.first.flightreservation.mapper.MapperModule;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoMapper extends MapperModule<Photo> {

    /**
     *  根据账号ID获取该账号下所有图片保存路径
     * @param accountId
     * @return
     */
   List<String> getPhotoPath(int accountId);


    /**
     *  批量插入照片相关信息
     * @param list
     * @return
     */
   boolean addPhotoBatch(List<Photo> list);


    /**
     *  獲取所有圖片路徑
     * @return
     */
   List<Photo> getAllPhotoPath();


    /**
     *  替代删除功能
     * @param pid
     * @param uid
     * @return
     */
   boolean updataAndDeleter(@Param("pid") int pid,@Param("uid") int uid);

}
