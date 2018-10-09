package com.yilvtong.first.flightreservation.tool.ftp;

import com.yilvtong.first.flightreservation.tool.DateTimeUtils;
import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;


public class FtpClientConnectionPool {

    private int maxConnectionNum=6; //默认最多连接6,和上图图片最大数量保存一直

    private String host="192.168.0.120";

    private int port=21;

    private String userName="ftpuser";

    private String password="123456";

    private List<FTPClient> ftpClientList= Collections.synchronizedList(new ArrayList<FTPClient>());

    private List<ModifyTheFtpClient> modifyTheFtpClientList= Collections.synchronizedList(new ArrayList<ModifyTheFtpClient>());

    public FtpClientConnectionPool(){

    }

    /**
     *  随机获取一个连接
     * @return
     */
    @Deprecated
    public FTPClient getNoneFtpcClient(){
        int index=new Random().nextInt(maxConnectionNum);
        return ftpClientList.get(index);
    }







    /**
     * 初始FTP client 的连接数
     */
    public void inits(){
        try {
            for(int i=0;i<this.maxConnectionNum;i++){
                FTPClient ftpClient = new FTPClient();
                ftpClient.setControlEncoding("utf-8");
                ftpClient.connect(host, port);
                ftpClient.login(userName,password);
                ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);//指定传输的是图片类型
                ftpClientList.add(ftpClient);
            }
            setModifyTheFtpClientList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 包装 FTPClient，使之有一些新状态指
     */
    private  void setModifyTheFtpClientList(){

        synchronized (ftpClientList){
            Iterator<FTPClient>  ftpClientIterator=ftpClientList.iterator();
            while (ftpClientIterator.hasNext()){
                FTPClient ftpClient=ftpClientIterator.next();
                ModifyTheFtpClient modifyTheFtpClient=new ModifyTheFtpClient();
                modifyTheFtpClient.setFtpClient(ftpClient);
                modifyTheFtpClientList.add(modifyTheFtpClient);
            }
        }
    }


    public List<ModifyTheFtpClient> getModifyTheFtpClientList(){
        return modifyTheFtpClientList;
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

    public boolean uploadPictureBySrc(String src){

        URL uri = null;
        InputStream inputStream=null;
        //http://bpic.588ku.com/back_pic/04/89/17/9258f8bebbaf1eb.jpg!/fh/300/quality/90/unsharp/true/compress/true


        try {
            uri = new URL(src);
            inputStream = uri.openStream();
            String date= DateTimeUtils.getCurrentDateTimeStr();
            boolean how=getNoneFtpcClient().storeFile(date+".jpg",inputStream);
            if(!how){
                return false;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;

    }


}
