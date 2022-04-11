package com.dzj.blog.controller;

import com.dzj.blog.dao.pojo.SysUser;
import com.dzj.blog.utils.UserThreadLocal;
import com.dzj.blog.vo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping
    public Result test(){
        SysUser sysUser = UserThreadLocal.get();
        System.out.println(sysUser);
        return Result.success(null);
    }
}
