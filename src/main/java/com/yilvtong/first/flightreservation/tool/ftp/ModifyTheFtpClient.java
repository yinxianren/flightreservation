package com.yilvtong.first.flightreservation.tool.ftp;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.net.ftp.FTPClient;

@Getter
@Setter
@NoArgsConstructor
public class ModifyTheFtpClient {

    private FTPClient ftpClient=null;
    private boolean busy=false;
    private int times=0;




}
