package com.yilvtong.first.flightreservation.tool.ftp;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class SingleFtpClientConnection {



    private String host="192.168.0.120";
    private int port=21;
    private String userName="ftpuser";
    private String password="123456";
    private FTPClient ftpClient;






    /**
     *   连接及登入
     * @return
     */
    public boolean init(){
        try {
            ftpClient = new FTPClient();
            ftpClient.setControlEncoding("utf-8");
            ftpClient.connect(host, port);
            int replyCode=ftpClient.getReplyCode();
            if(!FTPReply.isPositiveCompletion(replyCode)){
                log.info("======日志打印======：------>>ftpClient初始化连接失败，请检查主机ip和端口，或者检查主机是否开机");
                return false;
            }
            if(!ftpClient.login(userName,password)){
                log.info("======日志打印======：------>>ftpClient登入失败，请检查密码和账号");
                return false;
            }
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);//指定传输的是图片类型
        } catch (IOException e) {
            e.printStackTrace();

            return false;
        }
        return true;
    }

    /**
     *  关闭连接
     * @return
     */
    public boolean close(){

        if(null==ftpClient ){
            log.info("======日志打印======：------>>ftpClient这个对象是null");
            return false;
        }
        try {
            ftpClient.noop();
            ftpClient.logout();
            ftpClient.disconnect();
        } catch (IOException e) {
            log.info("======日志打印======：------>>ftpClient 关闭异常了");
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     *  上传图片
     * @param photoObject
     * @param newPhotoName
     * @return
     */
   public boolean upload(MultipartFile photoObject,String newPhotoName){

       if(null==ftpClient){
           return false;
       }

       InputStream inputStream = null;
       try {
           inputStream=photoObject.getInputStream();
           boolean how=ftpClient.storeFile(newPhotoName,inputStream);
           if(!how){
               log.info("======日志打印======：------>>ftpClient 上传失败");
               return  false;
           }
       } catch (IOException e) {
           e.printStackTrace();
           return  false;
       }finally {
           try {
               inputStream.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
       return true;
   }

    /**
     *  创建目录
     * @param dirName
     * @return
     */
   public boolean mkdir(String dirName){
       if(null==ftpClient){
           return false;
       }
       try {
         return ftpClient.makeDirectory(dirName);
       } catch (IOException e) {
           e.printStackTrace();
           return false;
       }
   }


    /**
     *  删除指定的目录
     * @param pathname
     * @return
     */
  public boolean removeDirectory(String pathname){
      try {
          ftpClient.removeDirectory(pathname);
      } catch (IOException e) {
          e.printStackTrace();
          return false;
      }
      return true;
  }

    /**
     *  切换目录
     * @param pathname
     * @return
     */
  public boolean changeWorkingDirectory(String pathname){

      try {
       return   ftpClient.changeWorkingDirectory(pathname);
      } catch (IOException e) {
          e.printStackTrace();
          return false;
      }
  }


/*
  public static void main(String[] arg){

      SingleFtpClientConnection s=new SingleFtpClientConnection();
      s.init();
      boolean is=s.removeDirectory("/home/ftpuser/www/images/admin/图片1");
      System.out.println(is);
      s.close();
  }

*/

}
