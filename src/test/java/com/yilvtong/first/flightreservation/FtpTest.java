package com.yilvtong.first.flightreservation;

import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FtpTest {


//    @Test
//    public void testFtp() throws Exception {
//        //1、连接ftp服务器
//        FTPClient ftpClient = new FTPClient();
//        ftpClient.connect("192.168.0.120", 21);
//        //2、登录ftp服务器
//        ftpClient.login("ftpuser", "123456");
//        ftpClient.makeDirectory("/home/ftpuser/www/images/gallery");//创建目录
//        //3、读取本地文件
//        FileInputStream inputStream = new FileInputStream(new File("D:\\picture\\4e7d65cc76d9be4d.jpg"));
//        //4、上传文件
//        //1）指定上传目录
//        ftpClient.changeWorkingDirectory("/home/ftpuser/www/images/lo");
////        2）指定文件类型
//        ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
////        第一个参数：文件在远程服务器的名称
////        第二个参数：文件流
//
//        ftpClient.storeFile("lr.jpg", inputStream);  //存储图片
//        //5、退出登录
//        ftpClient.logout();
//    }
}
