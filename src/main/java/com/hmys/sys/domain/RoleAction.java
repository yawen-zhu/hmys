package com.hmys.sys.domain;

import java.util.Date;

/**
 * @Description:  角色权限
 * @Author:  yawen.zhu
 * @Date:  2017/12/12 20:48
 * @Modified:  
 */
public class RoleAction {
    private Long pkId;
    private Long roleId;
    private Long actionId;
    private Date createTime;
    private String ds;

    public Long getPkId() {
        return pkId;
    }

    public void setPkId(Long pkId) {
        this.pkId = pkId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getActionId() {
        return actionId;
    }

    public void setActionId(Long actionId) {
        this.actionId = actionId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDs() {
        return ds;
    }

    public void setDs(String ds) {
        this.ds = ds;
    }
}
