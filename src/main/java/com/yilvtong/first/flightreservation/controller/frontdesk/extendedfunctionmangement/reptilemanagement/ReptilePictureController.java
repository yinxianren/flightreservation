package com.yilvtong.first.flightreservation.controller.frontdesk.extendedfunctionmangement.reptilemanagement;


import com.yilvtong.first.flightreservation.controller.ReturnResult;
import com.yilvtong.first.flightreservation.entity.frontdesk.User;
import com.yilvtong.first.flightreservation.service.frontdesk.TitleService;
import com.yilvtong.first.flightreservation.tool.DateTimeUtils;
import com.yilvtong.first.flightreservation.tool.StatusCode;
import com.yilvtong.first.flightreservation.tool.collections.MyApplications;
import com.yilvtong.first.flightreservation.tool.ftp.FtpClientConnectionPool;
import com.yilvtong.first.flightreservation.tool.ftp.ModifyTheFtpClient;
import com.yilvtong.first.flightreservation.tool.reptile.ReptileSingleWebPage;
import com.yilvtong.first.flightreservation.tool.thread.ReptileDownloadPictureThread;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Controller
@RequestMapping("/reptile")
public class ReptilePictureController {

    @Autowired
    private TitleService titleService;


    @RequestMapping("/extendedfunctionmangement/reptilemanagement/reptilePicture")
    public String pageJump(){


        return "/frontdesk/body/extendedFunctionManagement/reptile-picture";
    }

    /**
     *  一级图片爬虫
     * @param url
     * @return
     *
     *     reptile/extendedfunctionmangement/reptilemanagement/reptilePicture/one
     */
    @ResponseBody
    @RequestMapping("/extendedfunctionmangement/reptilemanagement/reptilePicture/one")
    public ReturnResult reptilePictureOneClass(@PathParam("url")String url,
                                               @PathParam("charset") String charset,
                                               @Autowired MyApplications myApplications
    ){
        ReturnResult rr=new ReturnResult();
        if(StringUtils.isEmpty(url)){
            rr.setCode(StatusCode.INTERNAL_ERROR_400_04_01.getCode());
            rr.setStatus(StatusCode.INTERNAL_ERROR_400_04_01.getMsg());
            return rr;
        }
        ReptileSingleWebPage rswp=new ReptileSingleWebPage();
        String HTML =null;
        try {
            if(StringUtils.isEmpty(charset)){
                charset="utf-8";
            }
            HTML = rswp.getHtml(url,charset);
        } catch (Exception e) {
            e.printStackTrace();
            rr.setCode(StatusCode.INTERNAL_ERROR_400_04_02.getCode());
            rr.setStatus(StatusCode.INTERNAL_ERROR_400_04_02.getMsg());
            return rr;
        }
        //获取图片标签
        List<String> imgUrl = rswp.getImageUrl(HTML);
        //获取图片src地址
        Set<String> imgSrc = rswp.getImageSrc(imgUrl);
        String key=myApplications.getKey();
        myApplications.putObjct(key,imgSrc);

        rr.setCode(StatusCode.SUCCESS.getCode());
        rr.setStatus(StatusCode.SUCCESS.getMsg());
        rr.setSet(imgSrc);
        rr.setMessage(key);
        rr.setTitle("returnSrc");
        return rr;
    }


    /**
     *  启动下载线程
     * @return
     */
    @ResponseBody
    @RequestMapping("/extendedfunctionmangement/reptilemanagement/reptilePicture/startDownloadPicture")
    public ReturnResult startDownloadPicture(@PathParam("key")String key, @Autowired MyApplications myApplications, HttpSession session){

        ReturnResult rr=new ReturnResult();
        if(StringUtils.isEmpty(key)){
            rr.setCode(StatusCode.INTERNAL_ERROR_400_04_01.getCode());
            rr.setStatus(StatusCode.INTERNAL_ERROR_400_04_01.getMsg());
            return rr;
        }
        String newKey=myApplications.getKey();
        Set<String> srcSet= (Set<String>) myApplications.getObject(key);
        //启用一个异步线程，完成下载图片任务
        Runnable runnable=()->{
            taskDecompositionOnStartDownloadPicture(srcSet,myApplications,newKey,session);
        };
        new Thread(runnable).start();//启动
        myApplications.delObject(key);//移除资源
        rr.setCode(StatusCode.SUCCESS.getCode());
        rr.setStatus(StatusCode.SUCCESS.getMsg());
        rr.setMessage(newKey);
        rr.setTitle("startDownloadPicture");
        return rr;
    }


    private void taskDecompositionOnStartDownloadPicture(Set<String> srcSet,MyApplications myApplications,String key,HttpSession session){
        //创建 FtpClient
        FtpClientConnectionPool ftpClientConnectionPool=new FtpClientConnectionPool();
        ftpClientConnectionPool.setMaxConnectNum(10);
        ftpClientConnectionPool.inits();
        List<ModifyTheFtpClient> modifyTheFtpClientList=ftpClientConnectionPool.getModifyTheFtpClientList();


        //创建存放线程容器
        List<ReptileDownloadPictureThread> threadList=new ArrayList<>();
        User user= (User) session.getAttribute("userInfo");
        String userAccount=user.getAccount();

        //设置保存路径
        String path="/home/ftpuser/www/images/";
        String data= DateTimeUtils.getCurrentDateStr();
        path=path+userAccount+"/reptile/picture/"+data;


        //创建线程
        for(int i=0;i<10;i++){
            threadList.add(new ReptileDownloadPictureThread());
        }

        Iterator<String> iterator=srcSet.iterator();
        while(iterator.hasNext()){
            while(true){
                //获取一个ModifyTheFtpClient资源
                ModifyTheFtpClient modifyTheFtpClient= getModifyTheFtpClient(modifyTheFtpClientList);

                //创建保存路径
                boolean how=mkdirOnPictureService(modifyTheFtpClient,userAccount);
                if(!how){
                    return ;
                }


                //给任务线程提供必要的资源
                initThreadTask(threadList,iterator.next(),modifyTheFtpClient,path);
                break;
            }
        }
    }





    /**
     *  创建图片保存路径
     * @param modifyTheFtpClient
     * @param
     * @return
     */
    private boolean mkdirOnPictureService(ModifyTheFtpClient modifyTheFtpClient,String userAccount){

        String path="/home/ftpuser/www/images/";
        FTPClient ftpClient= modifyTheFtpClient.getFtpClient();
        try {

            boolean how=ftpClient.changeWorkingDirectory(path+userAccount+"/reptile/picture");

            if(how){
               return true;
            }

           how=ftpClient.changeWorkingDirectory(path+userAccount);
           if(!how){
               how=ftpClient.makeDirectory(path+userAccount);
               if(!how){
                   return  false;
               }
           }

            how=ftpClient.makeDirectory(path+userAccount+"/reptile/");
            if(!how){
                return  false;
            }

            how=ftpClient.makeDirectory(path+userAccount+"/reptile/picture");
            if(!how){
                return  false;
            }

        } catch (IOException e) {
            e.printStackTrace();
            return  false;
        }

            return true;
    }


    /**
     *   从容器中获取一个ModifyTheFtpClient
     * @param modifyTheFtpClientList
     * @return
     */
    private ModifyTheFtpClient getModifyTheFtpClient(List<ModifyTheFtpClient> modifyTheFtpClientList){

        ModifyTheFtpClient modifyTheFtpClient=null;
        for(int index=0;index<modifyTheFtpClientList.size();index++){
             modifyTheFtpClient= modifyTheFtpClientList.get(index);
            //判断FtpClient是否忙碌中
            boolean how=modifyTheFtpClient.isBusy();
            if(how){
                if(index==modifyTheFtpClientList.size()){
                    index=0;
                }
                modifyTheFtpClient=null;
                continue;
            }
            modifyTheFtpClient.setBusy(true);
            int times=modifyTheFtpClient.getTimes();
            modifyTheFtpClient.setTimes(++times);

          break;
        }

        return modifyTheFtpClient;
    }

    /**
     *   线程资源赋值
     * @param threadList
     * @param src
     * @param modifyTheFtpClient
     */
    private void initThreadTask( List<ReptileDownloadPictureThread> threadList,String src,ModifyTheFtpClient modifyTheFtpClient,String path){
        //寻找可以使用的线程
        for(int index=0;index<threadList.size();index++){
            ReptileDownloadPictureThread reptileDownloadPictureThread= threadList.get(index);
            //判断当前线程是否属于忙碌状态
            boolean busy= reptileDownloadPictureThread.isBusy();
            if(busy){
                index++;
                if(index==threadList.size()){
                    index=0;
                }
                continue;//如果忙碌，轮询下一个线程
            }
            //判断该线程是否是第一次使用
            int threadTimes=reptileDownloadPictureThread.getTiems();
            if(threadTimes==0){
                new Thread(reptileDownloadPictureThread).start();//启动线程，但并未开设下载
            }

            //给线程下载路径赋值
            reptileDownloadPictureThread.setBusy(true);
            String storagePath=reptileDownloadPictureThread.getStoragePath();
            if(!storagePath.equals(path)){
                reptileDownloadPictureThread.setStoragePath(path);
            }
            reptileDownloadPictureThread.setSrc(src);
            reptileDownloadPictureThread.setTiems(++threadTimes);//累加次数
            reptileDownloadPictureThread.setFtpClient(modifyTheFtpClient.getFtpClient());
            reptileDownloadPictureThread.setTask(true);//这个标记，是启动下载任务
            break;
        }

    }



    /**
     *  获取下载信息
     * @return
     */
    @ResponseBody
    @RequestMapping("/extendedfunctionmangement/reptilemanagement/reptilePicture/getDownloadMsg")
    public ReturnResult getDownloadMsg(){
        ReturnResult rr=new ReturnResult();

        return rr;
    }




}
