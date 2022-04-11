package com.dzj.blog.controller;

import com.dzj.blog.dao.pojo.Message;
import com.dzj.blog.service.MessageService;
import com.dzj.blog.vo.MessageVo;
import com.dzj.blog.vo.Result;
import com.dzj.blog.vo.params.MessageParam;
import com.dzj.blog.vo.params.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired()
    private MessageService messageService;

    @PostMapping
    public Result pbMessage(@RequestBody Message message){
        System.out.println(message);
        return messageService.pbMessage(message);
    }

    @GetMapping("/list")
    public Result listMessage(){
        return messageService.listMessage();
    }
}
