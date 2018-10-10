package com.yilvtong.first.flightreservation.tool.ftp;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.net.ftp.FTPClient;

import java.net.URL;

@Getter
@Setter
@NoArgsConstructor
public class ModifyTheFtpClient {

    private FTPClient ftpClient=null;  //FTPClient对象
    private URL url=null;
    private boolean busy=false;   //标记是否忙碌状态
    private int times=0;       //使用次数




}
