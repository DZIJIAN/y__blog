package com.dzj.blog.service;

import com.dzj.blog.dao.pojo.SysUser;
import com.dzj.blog.vo.Result;
import com.dzj.blog.vo.params.LoginParam;
import org.springframework.transaction.annotation.Transactional;

public interface LoginService {
    /**
     * 登录功能
     * @param loginParam
     * @return
     */
    Result login(LoginParam loginParam);

    SysUser checkToken(String token);

    /**
     * 退出登录
     * @param token
     * @return
     */
    Result logout(String token);

    /**
     * 注册
     * @param loginParam
     * @return
     */
    Result register(LoginParam loginParam);
}
