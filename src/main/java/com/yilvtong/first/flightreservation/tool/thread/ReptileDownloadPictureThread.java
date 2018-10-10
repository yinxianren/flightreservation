package com.yilvtong.first.flightreservation.tool.thread;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.net.ftp.FTPClient;

import java.net.URL;

@Setter
@Getter
public class ReptileDownloadPictureThread implements Runnable{



    private int tiems=0;//记录运行次数
    private boolean busy=false;//标记是否在执行任务
    private String src="";//图片下载路径   http://bpic.588ku.com/back_pic/04/62/56/40586fb21cee0d0.jpg
    private FTPClient ftpClient=null;
    private boolean task=false;//标记是否执行任务
    private String storagePath="";//图片保存到服务器的绝对路径

    @Override
    public void run() {

        try {
            while (true) {
                while (task) {
                    //切换目录
                    boolean how=ftpClient.changeWorkingDirectory(storagePath);
                    if(!how){
                        how=ftpClient.makeDirectory(storagePath);
                        if(!how){
                            busy=false;
                            break;
                        }
                    }
                    how=ftpClient.changeWorkingDirectory(storagePath);
                    if(!how){
                        busy=false;
                        break;
                    }
                    String pictureName=src.substring(src.lastIndexOf("/")+1);
                    how=ftpClient.storeFile(pictureName,new URL(src).openStream());
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            src="";
            ftpClient=null;
            busy=false;
            task=false;
        }
    }


    //    private static Set<String> srcSet=null;

    /**
     *   多线程竞争的资源
     * @param srcSet
     */
//    public synchronized void setSrcSet(Set<String> srcSet){
//        if(null==this.srcSet){
//            this.srcSet=srcSet;
//        }
//    }

    /**
     * 多线程竞争的资源
     * @return
     */
//    public synchronized Set<String> getSrcSet(){
//        return this.srcSet;
//    }




}
