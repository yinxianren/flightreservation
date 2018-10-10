package com.yilvtong.first.flightreservation.tool.reptile;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReptileSingleWebPage {



    /**
     *
     * @param url
     * @return
     * @throws Exception
     */
    public String getHtml(String url,String charset)throws Exception{
        URL url1=new URL(url);
        URLConnection connection=url1.openConnection();
        InputStream in=connection.getInputStream();
        InputStreamReader isr=new InputStreamReader(in,charset);
        BufferedReader br=new BufferedReader(isr);

        String line;
        StringBuffer sb=new StringBuffer();
        while((line=br.readLine())!=null){
            sb.append(line,0,line.length());
            sb.append('\n');
        }
        br.close();
        isr.close();
        in.close();
        return sb.toString();
    }


    //获取ImageUrl地址
    public List<String> getImageUrl(String html){
        // 获取img标签正则
        String IMGURL_REG = "<img.*src=(.*?)[^>]*?>";
        Matcher matcher= Pattern.compile(IMGURL_REG).matcher(html);
        List<String> listimgurl=new ArrayList<String>();
        while (matcher.find()){
            listimgurl.add(matcher.group());
        }
        return listimgurl;
    }




    //获取ImageSrc地址
    public Set<String> getImageSrc(List<String> listimageurl){

        String IMGSRC_REG = "[a-zA-z]+://[^\\s]*(.jpg|.png|.gif|.jpeg|.bmp)";
        Set<String> setImageSrc=new HashSet<>();
        for (String image:listimageurl){
            Matcher matcher=Pattern.compile(IMGSRC_REG).matcher(image);
            while (matcher.find()){
                setImageSrc.add(matcher.group().substring(0, matcher.group().length()));
            }
        }
        return setImageSrc;
    }


    //下载图片
    public void Download(List<String> listImgSrc) {
        try {
            //开始时间
            Date begindate = new Date();
            for (String url : listImgSrc) {
                //开始时间
                Date begindate2 = new Date();
                String imageName = url.substring(url.lastIndexOf("/") + 1, url.length());
                URL uri = new URL(url);
                InputStream in = uri.openStream();


                FileOutputStream fo = new FileOutputStream(new File("src/res/"+imageName));
                byte[] buf = new byte[1024];
                int length = 0;
                System.out.println("开始下载:" + url);
                while ((length = in.read(buf, 0, buf.length)) != -1) {
                    fo.write(buf, 0, length);
                }
                in.close();
                fo.close();
                System.out.println(imageName + "下载完成");
                //结束时间
                Date overdate2 = new Date();
                double time = overdate2.getTime() - begindate2.getTime();
                System.out.println("耗时：" + time / 1000 + "s");
            }
            Date overdate = new Date();
            double time = overdate.getTime() - begindate.getTime();
            System.out.println("总耗时：" + time / 1000 + "s");
        } catch (Exception e) {
            System.out.println("下载失败");
        }
    }


}
