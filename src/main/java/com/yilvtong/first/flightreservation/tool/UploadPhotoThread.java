package com.yilvtong.first.flightreservation.tool;

import com.yilvtong.first.flightreservation.entity.frontdesk.Photo;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 *   使用多线程传输多张图片
 */
public class UploadPhotoThread  implements Runnable{

    private Photo photo;
    private MultipartFile photoObject;
    private FTPClient ftpClient;

    public  UploadPhotoThread(Photo photo,MultipartFile photoObject,FTPClient ftpClient){
       this.photo=photo;
       this.photoObject=photoObject;
       this.ftpClient=ftpClient;

    }


    @Override
    public void run() {

        try {
            String path = "/home/ftpuser/www/images/" + photo.getSavePath();
            ftpClient.makeDirectory(path);//创建路径
            Thread.sleep(100);
            ftpClient.changeWorkingDirectory(path);//指定上传路径
            ftpClient.storeFile(photo.getNewPhotoName(),photoObject.getInputStream());  //存储图片
            ftpClient.logout();
            ftpClient.disconnect();
        }catch (IOException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }



    }




}
