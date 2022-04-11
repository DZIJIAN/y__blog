package com.dzj.blog.controller;

import com.dzj.blog.utils.QiniuUtils;
import com.dzj.blog.vo.Result;
import com.qiniu.common.QiniuException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("upload")
public class UploadController {

    @Autowired
    private QiniuUtils qiniuUtils;

    @PostMapping
    public Result upload(@RequestParam("image") MultipartFile file){
        //原始文件名称 比如 aa.png
        String originalFilename = file.getOriginalFilename();
        //唯一的文件名称
        String fileName = UUID.randomUUID().toString() + "." + StringUtils.substringAfterLast(originalFilename, ".");
        //上传文件 上传到哪呢？ 七牛云 云服务器 按量付费 速度快 把图片发放到离用户最近的服务器上
        // 降低 我们自身应用服务器的带宽消耗

        boolean upload = qiniuUtils.upload(file, fileName);
        if (upload){
            return Result.success( "上传成功"+ fileName);
        }
        return Result.fail(20001,"上传失败");
    }


    public Result deleteFile(){
        try {
            qiniuUtils.deleteAll();
        } catch (QiniuException e) {
            e.printStackTrace();
        }
        return Result.success(null);
    }
}
