package com.yilvtong.first.flightreservation.tool;

import com.yilvtong.first.flightreservation.entity.frontdesk.Photo;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *   使用多线程传输多张图片
 */
public class UploadPhotoThread  implements Runnable{

    private Photo photo;
    private MultipartFile photoObject;
    private FTPClient ftpClient;
    private List<String> pathList;
    private MyCollections myCollections;

    public  UploadPhotoThread(Photo photo,MultipartFile photoObject,FTPClient ftpClient,List<String> pathList, MyCollections myCollections){
       this.photo=photo;
       this.photoObject=photoObject;
       this.ftpClient=ftpClient;
       this.pathList=pathList;
       this.myCollections=myCollections;
    }

    /**
     *   上傳圖片線程
     */

    @Override
    public void run() {
        try {

            boolean iscontain=pathList.contains(photo.getSavePath());
            if(!iscontain){
                Set<String> setBootPath=new HashSet<>();
                Set<String> setSubPath=new HashSet<>();
                for(String str :pathList){
                    String[] strs=str.split("/");
                    setBootPath.add(strs[0]);
                    setSubPath.add(strs[1]);
                }
                String[] str=photo.getSavePath().split("/");
                boolean iscontainBoot=setBootPath.contains(str[0]);
                if(!iscontainBoot){
                  boolean isSuccessfully=ftpClient.makeDirectory("/home/ftpuser/www/images/"+str[0]);
                  if(isSuccessfully){
                  boolean isSuccessfullySub =ftpClient.makeDirectory("/home/ftpuser/www/images/"+str[0]+"/"+str[1]);//创建路径
                      myCollections.addPhotoPathToAccount(photo.getAccount(),str[0]+"/"+str[1]+"/");
                  }
                }else{
                    boolean iscontainSub=setSubPath.contains(str[1]);
                    if(!iscontainSub){
                        boolean isSuccessfullySub = ftpClient.makeDirectory("/home/ftpuser/www/images/"+str[0]+"/"+str[1]);//创建路径
                        myCollections.addPhotoPathToAccount(photo.getAccount(),str[0]+"/"+str[1]+"/");
                    }
                }
            }
            ftpClient.changeWorkingDirectory("/home/ftpuser/www/images/"+photo.getSavePath());//指定上传目录
            ftpClient.storeFile(photo.getNewPhotoName(),photoObject.getInputStream());  //存储图片
            ftpClient.logout();
            ftpClient.disconnect();
        }catch (IOException e){
            e.printStackTrace();

        }
    }




}
