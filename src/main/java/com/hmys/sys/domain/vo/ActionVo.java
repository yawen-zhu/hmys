package com.hmys.sys.domain.vo;

import com.hmys.sys.domain.Action;

/**
 * @Description:  菜单功能（视图对象）
 * @Author:  yawen.zhu
 * @create:  2017/12/1 21:18
 * @Modified:  
 */
public class ActionVo extends Action {
    /**
     * 所属菜单，加载权限树用到
     */
    private Long parentId;

    public Long getParentId() {
        return super.getMenuId();
    }
}
