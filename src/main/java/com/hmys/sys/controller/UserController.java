package com.hmys.sys.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hmys.frame.core.constants.Constants;
import com.hmys.frame.core.constants.Result;
import com.hmys.frame.core.controller.BaseController;
import com.hmys.frame.core.bean.PageBean;
import com.hmys.sys.domain.User;
import com.hmys.sys.domain.vo.LoginVo;
import com.hmys.sys.domain.vo.UserVo;
import com.hmys.sys.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @Description:  系统管理 => 用户管理(控制器)
 * @Author:  yawen.zhu
 * @Date:  2017/12/4 19:45
 * @Modified:  
 */
@Controller
public class UserController extends BaseController {
    private Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    protected UserService getBaseService(){
      return userService;
    }


    @GetMapping (value = "/user/index")
    public String userList()  {
        return "index";
    }

    /**
     * 去列表页面
     * @return
     */
    @GetMapping(value = "/user/list")
    public String toList(){
        return "user/listUser";
    }

    /**
     * 列表分页查询
     * @param user
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/user/getPageList")
    public PageBean<Object> getPageList(UserVo user, int limit, int offset){
        Page<Object> p = PageHelper.offsetPage(offset, limit, true);
        getBaseService().getPageList(UserVo.class,user);
        return new PageBean(p);
    }

    /**
     * 用户加载
     * @param user
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/user/load")
    public Result load(User user){
        Result result = new Result();
        User data = getBaseService().load(User.class, user.getPkId());
        result.setData(data);
        return result;
    }

    /**
     * 用户登录
     * @param login
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/login")
    public Result login(LoginVo login){
        Result result = new Result();
        User user = null;
        try{
            user = getBaseService().loadEqual(User.class,"login",login);
        }catch(Exception e){
            e.printStackTrace();
            result.setStatus(Result.Status.ERROR);
            result.setMessage("系统错误");
            return result;
        }
        if (user == null){
            result.setStatus(Result.Status.ERROR);
            result.setMessage("用户名密码不正确");
            return result;
        }else{
            result.setStatus(Result.Status.OK);
            result.setMessage("登录成功");
            getSession().setAttribute(Constants.CURRENT_USER, user);
        }
        return result;
    }
}
