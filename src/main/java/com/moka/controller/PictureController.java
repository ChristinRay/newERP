package com.moka.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.moka.result.Result;

/**
* @author    created by lbq
* @date	     2018年10月16日 下午6:31:01
**/
@RestController
@RequestMapping("/api/erp/pic/")
public class PictureController {

    @RequestMapping("upload")
    @ResponseBody
    public Result<?> getfile(MultipartFile file){
        System.out.println("file name = "+file.getOriginalFilename());
        // 获取文件名
        String fileName = file.getOriginalFilename();
//        // 获取后缀
//        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 文件上产的路径
        String filePath = "G:/pic/";
        // fileName处理
        fileName = filePath+ UUID.randomUUID()+fileName;
        // 文件对象
        File dest = new File(fileName);
        // 创建路径
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }
        try {
            //保存文件
            file.transferTo(dest);
            return Result.create("上传成功", fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
 
        return Result.create("ERROR", "上传失败");
    }
 
    @RequestMapping("download")
    public void download(HttpServletResponse response) throws FileNotFoundException {
        File file =new File("C:\\Users\\ASUS\\Desktop\\spring-boot-reference.pdf");
        FileInputStream fileInputStream=new FileInputStream(file);
        // 设置被下载而不是被打开
        response.setContentType("application/gorce-download");
        // 设置被第三方工具打开,设置下载的文件名
        response.addHeader("Content-disposition","attachment;fileName=spring-boot-reference.pdf");
        try {
            OutputStream outputStream = response.getOutputStream();
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fileInputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
