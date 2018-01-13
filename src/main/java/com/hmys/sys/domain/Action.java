package com.hmys.sys.domain;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 功能权限
 */
@Component
public class Action implements Serializable{
    private Long pkId;
    private Long menuId;
    private String text;
    private String memo;
    private String html;
    private String ds;

    public Long getPkId() {
        return pkId;
    }

    public void setPkId(Long pkId) {
        this.pkId = pkId;
    }

    public String getDs() {
        return ds;
    }

    public void setDs(String ds) {
        this.ds = ds;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("pkId=").append(getPkId());
        sb.append(",text=").append(getText());
        sb.append("]");
        return sb.toString();
    }
}
