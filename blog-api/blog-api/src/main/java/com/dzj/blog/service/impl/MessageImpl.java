package com.dzj.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dzj.blog.dao.mapper.MessageMapper;
import com.dzj.blog.dao.pojo.Message;
import com.dzj.blog.service.MessageService;
import com.dzj.blog.vo.MessageVo;
import com.dzj.blog.vo.Result;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MessageImpl implements MessageService {

    @Autowired(required = false)
    private MessageMapper messageMapper;

    @Override
    public Result listMessage() {
        QueryWrapper<Message> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("create_date");
        List<Message> messages = messageMapper.selectList(queryWrapper);
        //日期格式转换
        List<MessageVo> messageVos = copyList(messages);
        return Result.success(messageVos);
    }

    @Override
    public Result pbMessage(Message message) {
        message.setCreateDate(new Date().getTime());
        messageMapper.insert(message);
        return listMessage();
    }



    private List<MessageVo> copyList(List<Message> messages) {
        List<MessageVo> messagestemp = new ArrayList<>();
        for(Message message : messages){
            MessageVo vo = new MessageVo(message.getMemberName(),message.getContent(),new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date(message.getCreateDate())));
            messagestemp.add(vo);
        }
        return messagestemp;
    }
}
