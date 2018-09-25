package com.yilvtong.first.flightreservation.entity.frontdesk;

import com.yilvtong.first.flightreservation.entity.EntityModule;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Photo extends EntityModule {

       private String host;//保存主机IP
       private String domainName;//主机域名
       private String oldPhotoName; //老照片名字
       private String newPhotoName; //新照片名字
       private String savePath; //图片保存的路径
       private int account;  //对应的账户



}
