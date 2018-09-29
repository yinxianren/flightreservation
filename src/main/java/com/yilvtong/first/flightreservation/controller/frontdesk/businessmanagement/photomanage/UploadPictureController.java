package com.yilvtong.first.flightreservation.controller.frontdesk.businessmanagement.photomanage;


import com.yilvtong.first.flightreservation.controller.ReturnResult;
import com.yilvtong.first.flightreservation.entity.frontdesk.Photo;
import com.yilvtong.first.flightreservation.entity.frontdesk.Title;
import com.yilvtong.first.flightreservation.entity.frontdesk.User;
import com.yilvtong.first.flightreservation.service.frontdesk.PhotoService;
import com.yilvtong.first.flightreservation.service.frontdesk.TitleService;
import com.yilvtong.first.flightreservation.tool.*;
import com.yilvtong.first.flightreservation.tool.entity.PhotoInfo;
import com.yilvtong.first.flightreservation.tool.ftp.FtpClientConnectionPool;
import com.yilvtong.first.flightreservation.tool.ftp.SingleFtpClientConnection;
import com.yilvtong.first.flightreservation.tool.thread.UploadPhotoThread;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/photo")
public class UploadPictureController {

    @Autowired
    private  PhotoService PhotoService;

    @Autowired
    private TitleService titleService;

    @Value("${web.photo.service.host}")
    private String host;
    @Value("${web.photo.service.domain}")
    private String domain;

    /**
     *  跳转到单图片上传
     * @param map
     * @return
     */
    @RequestMapping("/businessmanagement/photomanage/UploadPictureController")
    public String pageJump(Map<String,Object> map,HttpSession session) {

        User user=(User)session.getAttribute("userInfo");
        List<Title>  titleList = titleService.getByUserID(user.getId());
        map.put("titleList",titleList);
        return "/frontdesk/body/businessManagement/photograph-upload-management";
    }

    /**
     * 跳转到多图片上传
     * @param map
     * @return
     */

    @RequestMapping("/businessmanagement/photomanage/UploadPictureController/multiple")
    public String pageJumpToMultipleUploadPhoto(Map<String,Object> map,HttpSession session) {
        User user=(User)session.getAttribute("userInfo");
        List<Title>  titleList = titleService.getByUserID(user.getId());
        map.put("titleList",titleList);
        return "/frontdesk/body/businessManagement/photograph-multiple-upload-management";
    }


    /**
     *   多图片上传
     * @param photoObject
     * @param imgNewName
     * @param imgTitle
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/upload/uploadMultiplePhoto")
    public ReturnResult uploadMultiplePhoto(@PathParam("photoObject")MultipartFile[] photoObject,
                                            @PathParam("imgNewName")String[] imgNewName,
                                            @PathParam("imgTitle") String[] imgTitle,
                                            HttpSession session){
        ReturnResult<Photo> rr=new ReturnResult<Photo>();

        if(null==photoObject||null==imgNewName||null==imgTitle){
            rr.setCode(StatusCode.INTERNAL_ERROR_400_04_01.getCode());
            rr.setMessage(StatusCode.INTERNAL_ERROR_400_04_01.getMsg());
            return rr;
        }

        List<Photo> photoList=processingPhotoData(photoObject,imgNewName,imgTitle,session);

        boolean isSuccessUpload=uploadeToPhotoService();
        if(!isSuccessUpload){
            rr.setCode(StatusCode.INTERNAL_ERROR_500_14_02.getCode());
            rr.setMessage(StatusCode.INTERNAL_ERROR_500_14_02.getMsg());
            return rr;
        }
        boolean isSuccess=PhotoService.addPhotoBatch(photoList);//批量插入
        rr.setTitle("uploadMultiplePhoto");
        if(!isSuccess){
            rr.setCode(StatusCode.INTERNAL_ERROR_500_14_01.getCode());
            rr.setMessage(StatusCode.INTERNAL_ERROR_500_14_01.getMsg());
            return rr;
        }
        rr.setCode(StatusCode.SUCCESS.getCode());
        rr.setMessage(StatusCode.SUCCESS.getMsg());
        return rr;
    }

    /**
     *
     * @return
     *
     *
     */
    private  boolean  uploadeToPhotoService(){

        List<PhotoInfo> photoInfos= getPhotoInfos();

        if(null==photoInfos){
            return false;
        }

        if(photoInfos.size()==0){
            return false;
        }
        FtpClientConnectionPool ftpClientConnectionPool=new FtpClientConnectionPool();
        ftpClientConnectionPool.setMaxConnectNum(photoInfos.size());//设置初始连接数
        ftpClientConnectionPool.inits();
        List<FTPClient> ftpClientList = ftpClientConnectionPool.getFtpClientList();
        for (int i = 0; i < photoInfos.size(); i++) {
            PhotoInfo photoInfo = photoInfos.get(i);
            Photo photo=photoInfo.getPhoto();
            MultipartFile photoObject = photoInfo.getPhotoObject();
            FTPClient ftpClient = ftpClientList.get(i);
            try {
                Thread photoThread=new Thread(new UploadPhotoThread(photo, photoObject, ftpClient));
                photoThread.start();
                photoThread.join();
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }



    /**
     *   生成批量photo对象
     * @param photoObject
     * @param imgNewName
     * @param imgTitle
     * @param session
     * @return
     */
    private List<Photo> processingPhotoData(MultipartFile photoObject[],String[] imgNewName,String[] imgTitle,HttpSession session){

        User user=(User)session.getAttribute("userInfo");
        List<Photo> photoList=new ArrayList<>();
        List<PhotoInfo> photoInfos=new ArrayList<>();
        String time= DateTimeUtils.getCurrentDateTimeStr2();
        for(int i=0;i<photoObject.length;i++){
            Photo ph=new Photo();
            PhotoInfo photoInfo=new PhotoInfo();
            ph.setAccount(user.getId());
            ph.setDomainName(domain);
            ph.setHost(host);
            String oldName=photoObject[i].getOriginalFilename();
            String[] st= oldName.split("\\.");
            ph.setOldPhotoName(oldName);
            String photoSuffic=st[st.length-1];
            ph.setNewPhotoName(imgNewName[i]+"."+photoSuffic);
            String path=user.getAccount()+"/"+imgTitle[i]+"/";
            ph.setSavePath(path);
            ph.setCreateDate(time);
            ph.setUpdate(time);
            photoList.add(ph);
            photoInfo.setPhoto(ph);
            photoInfo.setPhotoObject(photoObject[i]);
            photoInfos.add(photoInfo);
        }

        setPhotoInfo(photoInfos);
        return photoList;
    }

    private List<PhotoInfo> photoInfos;

    /**
     *  设置图片信息
     * @param photoInfos
     */
    private void setPhotoInfo(List<PhotoInfo> photoInfos){
        this.photoInfos=photoInfos;
    }

    /**
     *  获取图片信息
     * @return
     */
    private List<PhotoInfo> getPhotoInfos(){
        return this.photoInfos;
    }


    /**
     *   单图片上传
     * @param photoTitle
     * @param photoName
     * @param photoObject
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/upload/singlePhoto")
    public ReturnResult  uploadSinglePhoto(@PathParam("photoTitle") String photoTitle,
                                           @PathParam("photoName") String photoName,
                                           @PathParam("file") MultipartFile photoObject,
                                           HttpSession session
    ){

        photoTitle=photoTitle.trim();
        photoName=photoName.trim();
        ReturnResult<Photo> rr=new ReturnResult<Photo>();
        if(StringUtils.isEmpty(photoTitle)||StringUtils.isEmpty(photoName)||null==photoObject){
            rr.setCode(StatusCode.INTERNAL_ERROR_400_04_01.getCode());
            rr.setMessage(StatusCode.INTERNAL_ERROR_400_04_01.getMsg());
            return rr;
        }
        User user=(User)session.getAttribute("userInfo");
        SingleFtpClientConnection singleFtpClientConnection=new SingleFtpClientConnection();
        singleFtpClientConnection.init();
        boolean how=singleFtpClientConnection.changeWorkingDirectory("/home/ftpuser/www/images/"+user.getAccount()+"/"+photoTitle);
        boolean hows=true;
        if(!how){
            how=singleFtpClientConnection.changeWorkingDirectory("/home/ftpuser/www/images/"+user.getAccount());
            if(!how){
                singleFtpClientConnection.mkdir("/home/ftpuser/www/images/"+user.getAccount());
                singleFtpClientConnection.mkdir("/home/ftpuser/www/images/"+user.getAccount()+"/"+photoTitle);
                hows=singleFtpClientConnection.changeWorkingDirectory("/home/ftpuser/www/images/"+user.getAccount()+"/"+photoTitle);//切换目录
            }else{
                singleFtpClientConnection.mkdir("/home/ftpuser/www/images/"+user.getAccount()+"/"+photoTitle);
                hows=singleFtpClientConnection.changeWorkingDirectory("/home/ftpuser/www/images/"+user.getAccount()+"/"+photoTitle);//切换目录
            }
        }
        if(!hows){//创建目录失败
            rr.setCode(StatusCode.INTERNAL_ERROR_500_14_03.getCode());
            rr.setMessage(StatusCode.INTERNAL_ERROR_500_14_03.getMsg());
            return rr;
        }
        String oldName=photoObject.getOriginalFilename();
        String[] st= oldName.split("\\.");
        String photoSuffic=st[st.length-1];



        if(!singleFtpClientConnection.upload(photoObject,photoName+"."+photoSuffic)){//上传失败
            rr.setCode(StatusCode.INTERNAL_ERROR_500_14_02.getCode());
            rr.setMessage(StatusCode.INTERNAL_ERROR_500_14_02.getMsg());
            return rr;
        }

        Photo pt=new Photo();
        pt.setOldPhotoName(oldName);
        pt.setNewPhotoName(photoName+"."+photoSuffic);
        String time= DateTimeUtils.getCurrentDateTimeStr2();
        pt.setUpdate(time);
        pt.setCreateDate(time);
        pt.setAccount(user.getId());
        pt.setSavePath(user.getAccount()+"/"+photoTitle+"/");
        pt.setHost(host);
        pt.setDomainName(domain);

        if(!PhotoService.add(pt)){//数据保存失败
            rr.setCode(StatusCode.INTERNAL_ERROR_500_14_01.getCode());
            rr.setMessage(StatusCode.INTERNAL_ERROR_500_14_01.getMsg());
            return rr;
        }

        rr.setCode(StatusCode.SUCCESS.getCode());
        rr.setMessage(StatusCode.SUCCESS.getMsg());
        return rr;
    }


    /**
     *    抛弃
     * @param src
     * @param photoTitle
     * @param photoName
     * @param session
     * @return
     */

    //    @ResponseBody
//    @RequestMapping("/upload/singlePhoto")
    private String uploadSinglePhoto1(@PathParam("src") String src,
                                      @PathParam("photoTitle") String photoTitle,
                                      @PathParam("photoName") String photoName,
                                      HttpSession session
    ){
        MultipartFile m= base64ToMultipart(src);
        try {


            //连接ftp服务器
            FTPClient ftpClient = new FTPClient();
            ftpClient.connect("192.168.0.120", 21);
            //登录ftp服务器
            ftpClient.login("ftpuser", "123456");
            //指定上传目录
            ftpClient.changeWorkingDirectory("/home/ftpuser/www/images/lo");
            // 指定文件类型
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);

            ftpClient.storeFile("asdfaa.jpg",m.getInputStream());  //存储图片
            //5、退出登录
            ftpClient.logout();
        } catch (IOException e) {
            e.printStackTrace();
            return  null ;
        }



        return "success";

    }

    /**
     *  抛弃   base64字符串转换成图片
     * @param imgStr		base64字符串
     * @param imgFilePath	图片存放路径
     * @return
     *
     * @author ZHANGJL
     * @dateTime 2018-02-23 14:42:17
     */
    private  boolean Base64ToImage(String imgStr,String imgFilePath) { // 对字节数组字符串进行Base64解码并生成图片



        BASE64Decoder decoder = new BASE64Decoder();

        try {
            // Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据
                    b[i] += 256;
                }
            }

            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();

            return true;
        } catch (Exception e) {
            return false;
        }
    }


    /**
     *   抛弃
     * @param base64
     * @return
     */


    private  MultipartFile base64ToMultipart(String base64) {
        try {
            String[] baseStrs = base64.split(",");

            BASE64Decoder decoder = new BASE64Decoder();
            byte[] b = new byte[0];
            b = decoder.decodeBuffer(baseStrs[1]);

            for(int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }

            return new BASE64DecodedMultipartFile(b, baseStrs[0]);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }





}
