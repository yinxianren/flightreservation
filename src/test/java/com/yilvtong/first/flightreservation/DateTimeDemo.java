package com.yilvtong.first.flightreservation;


import com.yilvtong.first.flightreservation.tool.DateTimeUtils;




public class DateTimeDemo {

    public  static void getCurrentLocalDateTime(){
        System.out.println("current local date time="+DateTimeUtils.getCurrentDateTimeStr1());//2018/08/16 17:18:33
    }

  //
    public static void main(String[] args) {

        getCurrentLocalDateTime();
    }

}
