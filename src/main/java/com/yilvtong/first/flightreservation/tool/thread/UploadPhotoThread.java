package com.yilvtong.first.flightreservation.tool.thread;

import com.yilvtong.first.flightreservation.entity.frontdesk.Photo;
import com.yilvtong.first.flightreservation.tool.collections.MyCollections;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *   使用多线程传输多张图片
 */
public class UploadPhotoThread implements Runnable{

    private Photo photo;
    private MultipartFile photoObject;
    private FTPClient ftpClient;

    public UploadPhotoThread(Photo photo, MultipartFile photoObject, FTPClient ftpClient){
       this.photo=photo;
       this.photoObject=photoObject;
       this.ftpClient=ftpClient;
    }

    /**
     *   上傳圖片線程
     */

    @Override
    public void run() {
            try {
                boolean how=ftpClient.changeWorkingDirectory("/home/ftpuser/www/images/"+photo.getSavePath());//切换目录
                if(!how){
                      String[] str=photo.getSavePath().split("/");
                      how=ftpClient.changeWorkingDirectory("/home/ftpuser/www/images/"+str[0]);
                      if(how){
                          ftpClient.makeDirectory("/home/ftpuser/www/images/"+str[0]+"/"+str[1]);//创建路径
                          ftpClient.changeWorkingDirectory("/home/ftpuser/www/images/"+photo.getSavePath());//切换目录
                      }else{
                          ftpClient.makeDirectory("/home/ftpuser/www/images/"+str[0]);
                          ftpClient.makeDirectory("/home/ftpuser/www/images/"+str[0]+"/"+str[1]);
                          ftpClient.changeWorkingDirectory("/home/ftpuser/www/images/"+photo.getSavePath());//切换目录
                      }
                }
            ftpClient.storeFile(photo.getNewPhotoName(),photoObject.getInputStream());  //存储图片
            ftpClient.logout();
            ftpClient.disconnect();
        }catch (IOException e){
            e.printStackTrace();

        }
    }




}
