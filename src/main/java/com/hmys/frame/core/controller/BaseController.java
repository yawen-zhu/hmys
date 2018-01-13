package com.hmys.frame.core.controller;

import com.hmys.frame.core.constants.Constants;
import com.hmys.sys.domain.User;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Description:  基础控制器接口
 * @Author:  yawen.zhu
 * @Date:  2017/12/4 19:44
 * @Modified:  
 */
public class BaseController {
    public HttpSession getSession() {
        HttpSession session = null;
        try {
            session = getRequest().getSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return session;
    }

    public HttpServletRequest getRequest() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        return attrs.getRequest();
    }

    public ServletContext getServletContext() {
        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        return webApplicationContext.getServletContext();
    }

    /**
     *
     * @Title: getCurrentUser
     * @Description: 获取当前用户
     * @return User 返回类型
     * @throws
     */
    public User getCurrentUser() {
        return (User) getSession().getAttribute(Constants.CURRENT_USER);
    }
}
