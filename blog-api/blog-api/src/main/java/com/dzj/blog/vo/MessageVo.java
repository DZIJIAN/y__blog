package com.dzj.blog.vo;

import com.dzj.blog.dao.pojo.Message;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageVo {
    private String memberName;
    private String content;
    private String createDate;
}
