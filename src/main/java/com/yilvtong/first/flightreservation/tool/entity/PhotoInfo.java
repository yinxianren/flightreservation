package com.yilvtong.first.flightreservation.tool.entity;

import com.yilvtong.first.flightreservation.entity.frontdesk.Photo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
public class PhotoInfo {

    private Photo  photo;
    private MultipartFile photoObject;

}
