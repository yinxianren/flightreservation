package com.yilvtong.first.flightreservation.controller.ueditor;


import com.baidu.ueditor.ActionEnter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/ueditor")
public class UeditorController {




    @RequestMapping(value="/config")
    public void config(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        String rootPath = request.getSession().getServletContext().getRealPath("/");
        try {
            String exec = new ActionEnter(request, rootPath).exec();
            PrintWriter writer = response.getWriter();
            writer.write(exec);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }






//    @RequestMapping(value = "/ueditor-config")
//    @ResponseBody
    public String ueditor(HttpServletRequest request, HttpServletResponse response) {


        StringBuilder sb=new StringBuilder();
        sb.append("{\\n")
                  /* 上传图片配置项 */
                .append("\"imageActionName\": \"uploadimage\",\\n")/* 执行上传图片的action名称 */
                .append("\"imageFieldName\": \"upfile\",\\n")/* 提交的图片表单名称 */
                .append("\"imageMaxSize\": 2048000,\\n")  /* 上传大小限制，单位B */
                .append("\"imageAllowFiles\": [\".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\"],\\n")  /* 上传图片格式显示 */
                .append("\"imageCompressEnable\": true,\\n")  /* 是否压缩图片,默认是true */
                .append("\"imageCompressBorder\": 1600,\\n")  /* 图片压缩最长边限制 */
                .append("\"imageInsertAlign\": \"none\",\\n") /* 插入的图片浮动方式 */
                .append("\"imageUrlPrefix\": \"\",\\n")/* 图片访问路径前缀 */
                .append(" \"imagePathFormat\": \"/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\",\\n")  /* 上传保存路径,可以自定义保存路径和文件名格式 */
                                /* {filename} 会替换成原文件名,配置这项需要注意中文乱码问题 */
                                /* {rand:6} 会替换成随机数,后面的数字是随机数的位数 */
                                /* {time} 会替换成时间戳 */
                                /* {yyyy} 会替换成四位年份 */
                                /* {yy} 会替换成两位年份 */
                                /* {mm} 会替换成两位月份 */
                                /* {dd} 会替换成两位日期 */
                                /* {hh} 会替换成两位小时 */
                                /* {ii} 会替换成两位分钟 */
                                /* {ss} 会替换成两位秒 */
                                /* 非法字符 \ : * ? " < > | */
                                /* 具请体看线上文档: fex.baidu.com/ueditor/#use-format_upload_filename */

                /* 涂鸦图片上传配置项 */
                .append("\"scrawlActionName\": \"uploadscrawl\",\\n")  /* 执行上传涂鸦的action名称 */
                .append("\"scrawlFieldName\": \"upfile\",\\n")/* 提交的图片表单名称 */
                .append("\"scrawlPathFormat\": \"/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\",\\n")/* 上传保存路径,可以自定义保存路径和文件名格式 */
                .append("\"scrawlMaxSize\": 2048000,\\n")/* 上传大小限制，单位B */
                .append("\"scrawlUrlPrefix\": \"\",\\n") /* 图片访问路径前缀 */
                .append("\"scrawlInsertAlign\": \"none\",\\n")/* 插入的图片浮动方式 */

                /* 截图工具上传 */
                .append("\"snapscreenActionName\": \"uploadimage\",\\n")/* 执行上传截图的action名称 */
                .append("\"snapscreenPathFormat\": \"/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\",\\n") /* 上传保存路径,可以自定义保存路径和文件名格式 */
                .append("\"snapscreenUrlPrefix\": \"\",\\n")/* 图片访问路径前缀 */
                .append("\"snapscreenInsertAlign\": \"none\",\\n")/* 插入的图片浮动方式 */

                /* 抓取远程图片配置 */
                .append("\"catcherLocalDomain\": [\"127.0.0.1\", \"localhost\", \"img.baidu.com\"],\\n")
                .append("\"catcherActionName\": \"catchimage\",\\n") /* 执行抓取远程图片的action名称 */
                .append("\"catcherFieldName\": \"source\",\\n")/* 提交的图片列表表单名称 */
                .append("\"catcherPathFormat\": \"/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\",\\n")/* 上传保存路径,可以自定义保存路径和文件名格式 */
                .append("\"catcherUrlPrefix\": \"\",\\n")/* 图片访问路径前缀 */
                .append("\"catcherMaxSize\": 2048000,\\n") /* 上传大小限制，单位B */
                .append("\"catcherAllowFiles\": [\".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\"],\\n") /* 抓取图片格式显示 */

                 /* 上传视频配置 */
                .append("\"videoActionName\": \"uploadvideo\",\\n")/* 执行上传视频的action名称 */
                .append("\"videoFieldName\": \"upfile\",\\n")/* 提交的视频表单名称 */
                .append("\"videoPathFormat\": \"/ueditor/jsp/upload/video/{yyyy}{mm}{dd}/{time}{rand:6}\",\\n")/* 上传保存路径,可以自定义保存路径和文件名格式 */
                .append("\"videoUrlPrefix\": \"\",\\n")/* 视频访问路径前缀 */
                .append("\"videoMaxSize\": 102400000,\\n")/* 上传大小限制，单位B，默认100MB */
                .append("\"videoAllowFiles\": [\n" +
                        "        \".flv\", \".swf\", \".mkv\", \".avi\", \".rm\", \".rmvb\", \".mpeg\", \".mpg\",\n" +
                        "                \".ogg\", \".ogv\", \".mov\", \".wmv\", \".mp4\", \".webm\", \".mp3\", \".wav\", \".mid\"],\\n")  /* 上传视频格式显示 */



                  /* 上传文件配置 */
                .append("\"fileActionName\": \"uploadfile\",\\n")/* controller里,执行上传视频的action名称 */
                .append("\"fileFieldName\": \"upfile\",\\n")/* 提交的文件表单名称 */
                .append("\"filePathFormat\": \"/ueditor/jsp/upload/file/{yyyy}{mm}{dd}/{time}{rand:6}\",\\n")/* 上传保存路径,可以自定义保存路径和文件名格式 */
                .append("\"fileUrlPrefix\": \"\",\\n")/* 文件访问路径前缀 */
                .append("\"fileMaxSize\": 51200000,\\n")/* 上传大小限制，单位B，默认50MB */
                .append("\"fileAllowFiles\": [\n" +
                        "        \".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\",\n" +
                        "        \".flv\", \".swf\", \".mkv\", \".avi\", \".rm\", \".rmvb\", \".mpeg\", \".mpg\",\n" +
                        "        \".ogg\", \".ogv\", \".mov\", \".wmv\", \".mp4\", \".webm\", \".mp3\", \".wav\", \".mid\",\n" +
                        "        \".rar\", \".zip\", \".tar\", \".gz\", \".7z\", \".bz2\", \".cab\", \".iso\",\n" +
                        "        \".doc\", \".docx\", \".xls\", \".xlsx\", \".ppt\", \".pptx\", \".pdf\", \".txt\", \".md\", \".xml\"\n" +
                        "    ],\\n")/* 上传文件格式显示 */
                .append("\\n")
                .append("\\n")



               /* 列出指定目录下的图片 */
                .append("\"imageManagerActionName\": \"listimage\",\\n")/* 执行图片管理的action名称 */
                .append("\"imageManagerListPath\": \"/ueditor/jsp/upload/image/\",\\n")/* 指定要列出图片的目录 */
                .append("\"imageManagerListSize\": 20,\\n")/* 每次列出文件数量 */
                .append("\"imageManagerUrlPrefix\": \"\",\\n")/* 图片访问路径前缀 */
                .append("\"imageManagerInsertAlign\": \"none\",\\n") /* 插入的图片浮动方式 */
                .append("\"imageManagerAllowFiles\": [\".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\"],\\n") /* 列出的文件类型 */


               /* 列出指定目录下的文件 */
                .append("\"fileManagerActionName\": \"listfile\",\\n")/* 执行文件管理的action名称 */
                .append("\"fileManagerListPath\": \"/ueditor/jsp/upload/file/\",\\n")/* 指定要列出文件的目录 */
                .append("\"fileManagerUrlPrefix\": \"\",\\n")/* 文件访问路径前缀 */
                .append("\"fileManagerListSize\": 20,\\n")/* 每次列出文件数量 */
                .append("\"fileManagerAllowFiles\": [\n" +
                        "        \".png\", \".jpg\", \".jpeg\", \".gif\", \".bmp\",\n" +
                        "                \".flv\", \".swf\", \".mkv\", \".avi\", \".rm\", \".rmvb\", \".mpeg\", \".mpg\",\n" +
                        "                \".ogg\", \".ogv\", \".mov\", \".wmv\", \".mp4\", \".webm\", \".mp3\", \".wav\", \".mid\",\n" +
                        "                \".rar\", \".zip\", \".tar\", \".gz\", \".7z\", \".bz2\", \".cab\", \".iso\",\n" +
                        "                \".doc\", \".docx\", \".xls\", \".xlsx\", \".ppt\", \".pptx\", \".pdf\", \".txt\", \".md\", \".xml\"\n" +
                        "    ] \\n")/* 列出的文件类型 */
                .append(" }");
        return sb.toString();

    }


    /**
     * 这里返回值是参照文档中的http://fex.baidu.com/ueditor/#dev-request_specification.需要注意的是，
     * mgUpdate方法里面的参数名称一定要与ueditor方法中字符串s中的imageFieldName值相同，都是file，不然会报空指针异常。
     *这样，应该就可以上传了。
     * @param file
     * @return
     */
//    @RequestMapping(value = "/imgUpdate")
//    @ResponseBody
    public String imgUpdate(MultipartFile file) {
        if (file.isEmpty()) {
            return "error";
        }
//        // 获取文件名
//        String fileName = file.getOriginalFilename();
//        // 获取文件的后缀名
//        String suffixName = fileName.substring(fileName.lastIndexOf("."));
//        // 这里我使用随机字符串来重新命名图片
//        fileName = Calendar.getInstance().getTimeInMillis() + Randoms.getRandomStringLower(4) + suffixName;
//        // 这里的路径为Nginx的代理路径，这里是/data/images/xxx.png
//        File dest = new File(ConstantL.IMAGE_UPDATE_PATH + fileName);
//        // 检测是否存在目录
//        if (!dest.getParentFile().exists()) {
//            dest.getParentFile().mkdirs();
//        }
//        try {
//            file.transferTo(dest);
//            //url的值为图片的实际访问地址 这里我用了Nginx代理，访问的路径是http://localhost/xxx.png
//            String config = "{\"state\": \"SUCCESS\"," +
//                    "\"url\": \"" + ConstantL.BASE_URL + fileName + "\"," +
//                    "\"title\": \"" + fileName + "\"," +
//                    "\"original\": \"" + fileName + "\"}";
//            return config;
//        } catch (IllegalStateException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return "error";
    }


}
