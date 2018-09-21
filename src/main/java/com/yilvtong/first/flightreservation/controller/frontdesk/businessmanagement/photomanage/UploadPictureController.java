package com.yilvtong.first.flightreservation.controller.frontdesk.businessmanagement.photomanage;


import com.yilvtong.first.flightreservation.tool.BASE64DecodedMultipartFile;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Map;

@Controller
@RequestMapping("/photo")
public class UploadPictureController {


    @RequestMapping("/businessmanagement/photomanage/UploadPictureController")
    public String pageJump(Map<String,Object> map) {


        return "/frontdesk/body/businessManagement/photograph-upload-management";
    }


    @RequestMapping("/upload/singlePhoto")
    public String  uploadSinglePhoto(@PathParam("photoTitle") String photoTitle,
                                     @PathParam("photoName") String photoName,
                                     @PathParam("file") MultipartFile photoObject,
                                     HttpSession session
                                     ){


        //连接ftp服务器
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect("192.168.0.120", 21);
            //登录ftp服务器
            ftpClient.login("ftpuser", "123456");
            //指定上传目录
            ftpClient.changeWorkingDirectory("/home/ftpuser/www/images/lo");
            // 指定文件类型
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);

            ftpClient.storeFile("photo.jpg",photoObject.getInputStream());  //存储图片
            //5、退出登录
            ftpClient.logout();

        } catch (IOException e) {
            e.printStackTrace();
        }




        return null;
    }







//    @ResponseBody
//    @RequestMapping("/upload/singlePhoto")
    public String uploadSinglePhoto1(@PathParam("src") String src,
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
     * base64字符串转换成图片
     * @param imgStr		base64字符串
     * @param imgFilePath	图片存放路径
     * @return
     *
     * @author ZHANGJL
     * @dateTime 2018-02-23 14:42:17
     */
    public  boolean Base64ToImage(String imgStr,String imgFilePath) { // 对字节数组字符串进行Base64解码并生成图片



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





    public  MultipartFile base64ToMultipart(String base64) {
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
