package com.dzj.blog.service;

import com.dzj.blog.dao.pojo.Message;
import com.dzj.blog.vo.MessageVo;
import com.dzj.blog.vo.Result;

public interface MessageService {

    Result listMessage();

    Result pbMessage(Message message);

}
