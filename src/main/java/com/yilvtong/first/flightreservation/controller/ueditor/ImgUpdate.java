package com.yilvtong.first.flightreservation.controller.ueditor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;

@RequestMapping("/test/")
@Controller
public class ImgUpdate {


    @RequestMapping(value = "/imgUpdate")
    @ResponseBody
    public String imgUpdate(MultipartFile[] upfile) throws FileNotFoundException {

        System.out.println(upfile);

//        File path = new File(ResourceUtils.getURL("classpath:").getPath());
//        String imgPath = path.getAbsolutePath() + "\\static\\img\\";
//        if(!path.exists()) path = new File("");
//        if (upfile.isEmpty()) {
//            return "error";
//        }
//        String fileName = upfile.getOriginalFilename(); // 获取文件名
//        String suffixName = fileName.substring(fileName.lastIndexOf(".")); // 获取文件的后缀名
//        fileName = Calendar.getInstance().getTimeInMillis() + StrUtil.createRandom(true, 6) + suffixName;
//        File dest = new File(imgPath + fileName);
//        if (!dest.getParentFile().exists()) { // 检测是否存在目录
//            dest.getParentFile().mkdirs();
//        }
//        try {
//            upfile.transferTo(dest); // 上传图片
//            ObjectMapper mapper = new ObjectMapper();
//            HashMap<String,Object> configs = new HashMap<String,Object>();
//            configs.put("state", "SUCCESS");
//            configs.put("url", datdDirectory + newFileName);
//            configs.put("title", newFileName);
//            configs.put("original", newFileName);
//
//            return mapper.writeValueAsString(configs);
//        } catch (IllegalStateException e) {
//            logger.error(e.toString());
//        } catch (IOException e) {
//            logger.error(e.toString());
//        }

        return "error";
    }


}
