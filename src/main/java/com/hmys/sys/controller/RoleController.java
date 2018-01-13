package com.hmys.sys.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hmys.frame.core.constants.Result;
import com.hmys.frame.core.controller.BaseController;
import com.hmys.frame.core.bean.PageBean;
import com.hmys.sys.domain.Role;
import com.hmys.sys.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @Description:  系统管理 => 角色管理(控制器)
 * @Author:  yawen.zhu
 * @Date:  2017/12/4 19:45
 * @Modified:  
 */
@Controller
public class RoleController extends BaseController {
    private Logger log = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;

    protected RoleService getBaseService(){
      return roleService;
    }

    /**
     * 去列表页面
     * @return
     */
    @GetMapping(value = "/role/list")
    public String toList(){
        return "role/listRole";
    }
    /**
     * 去授权页面
     * @return
     */
    @GetMapping(value = "/role/authorise")
    public String toAuthorise(){
        return "role/authorise";
    }

    /**
     * 列表分页查询
     * @param role
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/role/getPageList")
    public PageBean<Object> getPageList(Role role, int limit, int offset){
        Page<Object> p = PageHelper.offsetPage(offset, limit, true);
        getBaseService().getPageList(Role.class,role);
        return new PageBean(p);
    }

    /**
     * 角色加载
     * @param role
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/role/load")
    public Result load(Role role){
        Result result = new Result();
        Role data = getBaseService().load(Role.class, role.getPkId());
        result.setData(data);
        return result;
    }

}