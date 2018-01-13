package com.hmys.sys.domain.vo;

import com.hmys.sys.domain.User;

/**
 * @Description:  登录（视图对象）
 * @Author:  yawen.zhu
 * @create:  2017/12/1 21:19
 * @Modified:  
 */
public class LoginVo extends User {
    /**
     * 用户名
     */
    private String account;
    /**
     * 密码
     */
    private String pwd;
    /**
     * 验证码
     */
    private String checkCode;
}
