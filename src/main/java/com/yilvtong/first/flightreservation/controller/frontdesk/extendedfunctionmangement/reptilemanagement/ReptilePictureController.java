package com.yilvtong.first.flightreservation.controller.frontdesk.extendedfunctionmangement.reptilemanagement;


import com.yilvtong.first.flightreservation.controller.ReturnResult;
import com.yilvtong.first.flightreservation.service.frontdesk.TitleService;
import com.yilvtong.first.flightreservation.tool.StatusCode;
import com.yilvtong.first.flightreservation.tool.collections.MyApplications;
import com.yilvtong.first.flightreservation.tool.ftp.FtpClientConnectionPool;
import com.yilvtong.first.flightreservation.tool.ftp.ModifyTheFtpClient;
import com.yilvtong.first.flightreservation.tool.reptile.ReptileSingleWebPage;
import com.yilvtong.first.flightreservation.tool.thread.ReptileDownloadPictureThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
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
    public ReturnResult startDownloadPicture(@PathParam("key")String key,@Autowired MyApplications myApplications){

        ReturnResult rr=new ReturnResult();
        if(StringUtils.isEmpty(key)){
            rr.setCode(StatusCode.INTERNAL_ERROR_400_04_01.getCode());
            rr.setStatus(StatusCode.INTERNAL_ERROR_400_04_01.getMsg());
            return rr;
        }
        String newKey=myApplications.getKey();
        Set<String> srcSet= (Set<String>) myApplications.getObject(key);
        Runnable runnable=()->{
            taskDecompositionOnStartDownloadPicture(srcSet,myApplications,newKey);
        };
        new Thread(runnable).start();
        myApplications.delObject(key);
        rr.setCode(StatusCode.SUCCESS.getCode());
        rr.setStatus(StatusCode.SUCCESS.getMsg());
        rr.setMessage(newKey);
        rr.setTitle("startDownloadPicture");
        return rr;
    }


    private void taskDecompositionOnStartDownloadPicture(Set<String> srcSet,MyApplications myApplications,String key){
        //创建 FtpClient
        FtpClientConnectionPool ftpClientConnectionPool=new FtpClientConnectionPool();
        ftpClientConnectionPool.setMaxConnectNum(10);
        ftpClientConnectionPool.inits();
        List<ModifyTheFtpClient> modifyTheFtpClientList=ftpClientConnectionPool.getModifyTheFtpClientList();


        //创建存放线程容器
        List<ReptileDownloadPictureThread> threadList=new ArrayList<ReptileDownloadPictureThread>();
        //设置线程数量
        int maxThreadNum=0;
        if(srcSet.size()<100){
            maxThreadNum=10;
        }else if(srcSet.size()>100||srcSet.size()<1000){
            maxThreadNum=30;
        }else{
            maxThreadNum=50;
        }
        //创建线程池对象
        ExecutorService pool = Executors.newFixedThreadPool(maxThreadNum);

        //创建线程
        for(int i=0;i<maxThreadNum;i++){
            threadList.add(new ReptileDownloadPictureThread());
        }

        Iterator<String> iterator=srcSet.iterator();
        while(iterator.hasNext()){
            int index=0;
            while(true){
                ReptileDownloadPictureThread reptileDownloadPictureThread= threadList.get(index);
                boolean busy= reptileDownloadPictureThread.isBusy();
                if(busy){
                    index++;
                    if(index==maxThreadNum){
                        index=0;
                    }
                    continue;
                }

                reptileDownloadPictureThread.setSrc(iterator.next());//设置下载路径
                //执行程序任务
                pool.execute(reptileDownloadPictureThread);
                break;
            }

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
