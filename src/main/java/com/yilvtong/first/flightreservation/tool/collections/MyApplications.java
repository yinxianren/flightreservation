package com.yilvtong.first.flightreservation.tool.collections;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class MyApplications {

    //全局自定储存容器
    private static Map<String,Object> appMap=null;

    //单例私有构造器
    private MyApplications(){}



    /**
     *  init inner class instance
     */
    private static class  singletonPatternInstance{
        private static final MyApplications MY_APPLICATIONS=new MyApplications();

    }

    /**
     *  get singleton object
     * @return
     */
    public static MyApplications getMyApplicationsInstance(){
        return singletonPatternInstance.MY_APPLICATIONS;
    }

    /**
     *  get the appMap
     * @return
     */
   public synchronized Map<String,Object> getAppMap(){

        if(null==appMap){
            appMap= Collections.synchronizedMap(new HashMap<String,Object>());
        }
        return appMap;
   }

    /**
     *  store an object by key
     * @param key
     * @param value
     * @return
     */
  public synchronized Map<String,Object> putObjct(String key,Object value){

      if(null==appMap){
          getAppMap();
      }
      return (Map<String, Object>) getAppMap().put(key,value);

  }

    /**
     * get an object by key
     * @param key
     * @return
     */
  public synchronized  Object getObject(String key){
      if(null==appMap){
          getAppMap();
          return null;
      }
     return getAppMap().get(key);

  }

    /**
     *  remove an object according to the key
     * @param key
     * @return
     */
  public synchronized boolean delObject(String key){
      if(null==appMap){
          return false;
      }
      if(!whetherExist(key)){
          return false;
      }
      return getAppMap().remove(key)==null?false:true;
  }


    /**
     *  determine  whether the value exist based ont the key
     * @param key
     * @return
     */
  public boolean whetherExist(String key){

      if(null==appMap){

          return false;
      }
      return getAppMap().containsKey(key);
  }


    /**
     *  gets a  unique primary key
     * @return
     */
  public synchronized String getKey(){
      String date=LocalDateTime.now().format( DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
      Random random = new Random();
      int salt=random.nextInt();
      char ch1=(char) (65 + random.nextInt(26));// 取得大写字母
      char ch2=(char) (65 + random.nextInt(26));// 取得大写字母
      char ch3=(char) (65 + random.nextInt(26));// 取得大写字母
      return ""+ch1+ch2+date+ch3+salt;
  }



}
