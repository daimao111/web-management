package com.demo.controller;

import com.demo.anno.Log;
import com.demo.pojo.Result;
import com.demo.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

    @Autowired
    private AliOSSUtils aliOSSUtils;

//    /**
//     * 本地存储
//     * @param username
//     * @param age
//     * @param image
//     * @return
//     * @throws IOException
//     */
//    @PostMapping("/upload")
//    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
//        log.info("上传的信息{},{},{}", username, age, image);
//
//        //获取原始文件名
//        String originalFilename = image.getOriginalFilename();
//
//        //构造唯一的文件名（不可重复） - uuid(通用唯一标识符) 39ba1bb8-deac-4fe2-bff2-125bab8fa697
//        //获取原始文件的拓展名
//        int index = originalFilename.lastIndexOf(".");
//        String extname = originalFilename.substring(index);
//        String newFileName = UUID.randomUUID().toString() + extname;
//
//        log.info("新的文件名:{}", newFileName);
//
//        //将接收到的文件存储在本地磁盘中
//        image.transferTo(new File("D:\\idea\\tlias-web-management02\\images\\" + newFileName));
//
//        return Result.success();
//    }

    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        log.info("文件的名字：{}", image.getOriginalFilename());

        //调用阿里云oss工具类进行文件上传
        String url = aliOSSUtils.upload(image);
        log.info("文件上传完成，url为：{}", url);

        return Result.success(url);

    }
}
