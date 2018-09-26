package com.yilvtong.first.flightreservation.tool;


import java.util.*;

public  class MyCollections {


    private static Map<Integer,List<String>> photoPathMap;

    public static synchronized Map<Integer,List<String>>  getphotoPathMap(){

        if(null==photoPathMap){
            photoPathMap= Collections.synchronizedMap(new HashMap<Integer,List<String>>());
        }

        if(photoPathMap.size()==0){




        }


        return photoPathMap;
    }




   public List<String>  getPhotoPathList(int accountId){

       Map<Integer,List<String>> photoPathMap=getphotoPathMap();
       if(photoPathMap.size()==0){
           return null; //数据库没数据
       }



       return null;
   }













}
