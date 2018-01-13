package com.hmys.sys.domain.vo;


import com.hmys.sys.domain.Menu;

/**
 * @Description:  功能菜单以及权限（视图对象）
 * @Author:  yawen.zhu
 * @Date:  2017/12/12 20:57
 * @Modified:  
 */
public class MenuActionVo extends Menu{
    /**
     * 功能菜单ID
     */
    private Long menuId;

    /**
     * 功能菜单名称
     */
    private String menuText;

    /**
     * 功能菜单父节点ID
     */
    private Long parentId;

    /**
     * 权限ID
     */
    private Long actionId;

    /**
     * 权限名称
     */
    private String actionText;


    public Long getActionId() {
        return actionId;
    }

    public void setActionId(Long actionId) {
        this.actionId = actionId;
    }

    public String getActionText() {
        return actionText;
    }

    public void setActionText(String actionText) {
        this.actionText = actionText;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getMenuText() {
        return menuText;
    }

    public void setMenuText(String menuText) {
        this.menuText = menuText;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
