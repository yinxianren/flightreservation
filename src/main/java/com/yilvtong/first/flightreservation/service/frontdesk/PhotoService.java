package com.yilvtong.first.flightreservation.service.frontdesk;

import com.yilvtong.first.flightreservation.entity.frontdesk.Photo;
import com.yilvtong.first.flightreservation.mapper.frontdesk.PhotoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService extends ServiceParent<Photo> {

    private PhotoMapper photoMapper;

    @Autowired
    public PhotoService( PhotoMapper photoMapper){
        super.setMapperModule(photoMapper);
        this.photoMapper=photoMapper;
    }


    /**
     *  批量插入照片相关信息
     * @param list
     * @return
     */
    public boolean addPhotoBatch(List<Photo> list){
        try {
            photoMapper.addPhotoBatch(list);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     *  根据账号ID获取该账号下所有图片保存路径
     *  @param accountId
     *  @return
     */
    public List<String> getPhotoPath(int accountId){
        try {
            return photoMapper.getPhotoPath(accountId);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     *  獲取所有圖片路徑
     * @return
     */
    public List<Photo> getAllPhotoPath(){
        try {
            return photoMapper.getAllPhotoPath();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }


    public boolean updataAndDeleter(int pid,int uid){
        try {
            return photoMapper.updataAndDeleter(pid,uid);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }

    }



}
