package com.yilvtong.first.flightreservation.tool.thread;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReptileDownloadPictureThread implements Runnable{



    private int tiems=0;
    private boolean busy=false;
    private String src=null;




    @Override
    public void run() {

        busy=true;


        int i=0;
        try {
            while(true){
                i++;
                Thread.sleep(3000);
                System.out.println(":::::::::::::"+i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        busy=false;
    }



}
