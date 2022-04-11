package com.dzj.blog.dao.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dzj.blog.vo.MessageVo;
import lombok.Data;

@Data
public class Message{

    private String memberName;

    private String content;


    @TableField(value = "create_date")
    private Long createDate;
}
