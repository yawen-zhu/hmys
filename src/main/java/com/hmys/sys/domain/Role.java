package com.hmys.sys.domain;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色
 */
@Component
public class Role implements Serializable{
    private Long pkId;
    private String name;
    private Date createTime;
    private Long createUser;
    private Date updateTime;
    private Long updateUser;
    private String ds;

    public Long getPkId() {
        return pkId;
    }

    public void setPkId(Long pkId) {
        this.pkId = pkId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    public String getDs() {
        return ds;
    }

    public void setDs(String ds) {
        this.ds = ds;
    }

    public Role(){}

    public Role(Long pkId, String name){
        this.pkId = pkId;
        this.name = name;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("pkId=").append(getPkId());
        sb.append(",name=").append(getName());
        sb.append("]");
        return sb.toString();
    }
}
