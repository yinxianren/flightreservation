package com.yilvtong.first.flightreservation.service.frontdesk;

import com.yilvtong.first.flightreservation.entity.frontdesk.Photo;
import com.yilvtong.first.flightreservation.mapper.frontdesk.PhotoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoService extends ServiceParent<Photo> {

    private PhotoMapper photoMapper;

    @Autowired
    public PhotoService( PhotoMapper photoMapper){
        super.setMapperModule(photoMapper);
        this.photoMapper=photoMapper;
    }



    public boolean inseterMultiple(){

      return true;
    }


}
