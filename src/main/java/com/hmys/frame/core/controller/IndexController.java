package com.hmys.frame.core.controller;

import com.hmys.frame.core.bean.TreeBean;
import com.hmys.frame.core.constants.Result;
import com.hmys.sys.domain.Action;
import com.hmys.sys.domain.Menu;
import com.hmys.sys.domain.User;
import com.hmys.sys.domain.vo.ActionVo;
import com.hmys.sys.domain.vo.MenuActionVo;
import com.hmys.sys.service.ActionService;
import com.hmys.sys.service.MenuService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
public class IndexController extends BaseController{

    @Autowired
    private MenuService menuService;

    @Autowired
    private ActionService actionService;

    @GetMapping (value = "/demo")
    public String demo()  {
        return "demo";
    }

    @GetMapping (value = "/")
    public String login()  {
        return "login";
    }

    @GetMapping (value = "/index")
    public ModelAndView index()  {
        ModelAndView model = new ModelAndView();
        User user = getCurrentUser();
        if(user == null){
            model.setViewName("login");
            return model;
        }
        List<Menu> menuList = menuService.getPageList(Menu.class,user);
        model.addObject(user);
        model.addObject(menuList);
        model.setViewName("index");
        return model;
    }

    @ResponseBody
    @GetMapping(value = "/menu")
    public Result menu(){
        Result result = new Result();
        User user = getCurrentUser();
        List<Menu> menuList = menuService.getPageList(Menu.class,user);
        if(menuList.size() > 0 ){
            JSONArray tree = new JSONArray();
            for(Menu m : menuList){
                JSONObject node = new JSONObject();
                node.put("id",m.getPkId());
                node.put("parentId",m.getParentId());
                node.put("text",m.getText());
                node.put("murl",m.getMurl());
                tree.add(node);
            }
            result.setStatus(Result.Status.OK);
            result.setData(tree);
        }
        return result;
    }

    /**
     * 查询菜单功能权限树
     */
    @ResponseBody
    @GetMapping(value = "/getMenuActionTree")
    public JSONArray getMenuActionTree(){
        Long roleId = getCurrentUser().getPkId();
        List<Menu> menuList = menuService.getPageList(Menu.class,roleId);
        List<ActionVo> allActionList = actionService.getPageList(ActionVo.class,roleId);
        List<ActionVo> authorizedActionList = actionService.getPageList(ActionVo.class,"select_authorized_list",roleId);
        JSONArray tree = new JSONArray();
        //添加操作
        for(ActionVo a : allActionList){
            TreeBean node = new TreeBean();
            node.setId(a.getPkId()+1000L);
            node.setParentId(a.getParentId());
            node.setText(a.getText());
            //节点状态
            JSONObject state = new JSONObject();
            state.put("checked",false);
            node.setState(state);
            for(ActionVo  au: authorizedActionList){
                if(au.getPkId() == a.getPkId()){
                    state.put("checked",true);
                    node.setState(state);
                }
            }
            tree.add(node);
        }
        //添加菜单
        for(Menu m : menuList){
            TreeBean node = new TreeBean();
            node.setId(m.getPkId());
            node.setParentId(m.getParentId());
            node.setText(m.getText());
            JSONObject state = new JSONObject();
            state.put("checked",true);
            state.put("expanded",true);
            node.setState(state);
            tree.add(node);
        }
        return tree;
    }
}
