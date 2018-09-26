package com.yilvtong.first.flightreservation.tool;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Component
public class FtpClientConnectionPool {

    private int maxConnectionNum=6; //默认最多连接6,和上图图片最大数量保存一直
    private String host="192.168.0.120";
    private int port=21;
    private String userName="ftpuser";
    private String password="123456";
    private List<FTPClient> ftpClientList= Collections.synchronizedList(new ArrayList<FTPClient>());


    public FtpClientConnectionPool(){

    }

    /**
     *  随机获取一个连接
     * @return
     */
    public FTPClient getNoneFtpcClient(){
        int index=new Random().nextInt(10);
        return ftpClientList.get(index);
    }


    /**
     * 初始FTP client 的连接数
     */
    public void inits(){
        try {
            for(int i=0;i<this.maxConnectionNum;i++){
                FTPClient ftpClient = new FTPClient();
                ftpClient.setControlEncoding("GBK");
                ftpClient.connect(host, port);
                ftpClient.login(userName,password);
                ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);//指定传输的是图片类型
                ftpClientList.add(ftpClient);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  设置最大连接数
     * @param maxConnectionNum
     * @return
     */
    public int setMaxConnectNum(int maxConnectionNum){
        this.maxConnectionNum=maxConnectionNum;
        return this.maxConnectionNum;
    }



    /**
     *  获取所有FTPClient 连接对象
     * @return
     */
    public  List<FTPClient> getFtpClientList(){
        return this.ftpClientList;
    }


    /**
     *  销毁所有FTPClient连接
     * @return
     */
    public boolean  destroys(){
        try {
            for(int i=0;i<maxConnectionNum;i++){
                FTPClient ftpClient=ftpClientList.get(i);
                ftpClient.logout();
                ftpClient.disconnect();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     *  关闭指定的FTPClient
     * @param ftpClient
     * @return
     */
    public boolean destroysNone( FTPClient ftpClient){

        try {
            ftpClient.logout();
            ftpClient.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }




}
