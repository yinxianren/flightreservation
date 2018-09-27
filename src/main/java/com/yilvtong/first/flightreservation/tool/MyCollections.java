package com.yilvtong.first.flightreservation.tool;


import com.yilvtong.first.flightreservation.entity.frontdesk.Photo;
import com.yilvtong.first.flightreservation.service.frontdesk.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Stream;

@Component
public  class MyCollections {

    @Autowired
    private  PhotoService photoService;

    private static Map<Integer,List<String>> photoPathMap;

    /**
     *   初始 photoPathMap
     * @return
     */
    private synchronized Map<Integer,List<String>>  getphotoPathMap(){
        if(null==photoPathMap){
            photoPathMap= Collections.synchronizedMap(new HashMap<Integer,List<String>>());
        }
        return photoPathMap;
    }


    /**
     *  獲取所路徑信息，此時信息包含所有賬號原始數據
     * @return
     */
    private List<Photo> produceOriginalData(){
        return photoService.getAllPhotoPath();
    }



    /**
     *  獲取指定的賬戶里的圖片路徑
     * @param accountId
     * @return
     */
    public List<String>  getPhotoPathList(int accountId){


        boolean isContain=getphotoPathMap().containsKey(accountId);
        if(isContain){
            return getphotoPathMap().get(accountId);  //如果map中已經有了這個賬號圖片路徑，就直接拿來用
        }
        //map沒有相關信息時，需要繼續往下執行
        List<String> photoList=filterPhotoPathToAccount(accountId);
        if(null==photoList){
            return null;
        }
        getphotoPathMap().put(accountId,photoList);
        return photoList;
    }

    /**
     *   從原始數據中鍋爐出指定的賬戶相關信息
     * @param accountId
     * @return
     */
    private List<String> filterPhotoPathToAccount(int accountId){
        List<Photo> produceOriginalData=produceOriginalData();
        if(null==produceOriginalData){
            return null;
        }
        List<String> list=new ArrayList<>();
        Stream<Photo>stream=produceOriginalData.stream();
        stream.filter((e)->e.getAccount()==accountId)
                .forEach((e)->{
                    String path=e.getSavePath();
                    list.add(path);
                });
        return list;
    }


    /**
     *   更新路徑值
     * @param accountId
     * @param path
     * @return
     */
   public boolean addPhotoPathToAccount(int accountId,String path){
       try {
           List<String> pathList = getPhotoPathList(accountId);
           pathList.add(path);
           Map<Integer, List<String>> map = getphotoPathMap();
           map.replace(accountId, pathList);
       }catch (Exception e){
           e.printStackTrace();
           return false;
       }
       return true;
   }





}
