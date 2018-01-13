package com.hmys.frame.core.bean;

import net.sf.json.JSONObject;

public class TreeBean {
    private Long id;
    private Long parentId;
    private String text;
    private String murl;
    private JSONObject state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMurl() {
        return murl;
    }

    public void setMurl(String murl) {
        this.murl = murl;
    }

    public JSONObject getState() {
        return state;
    }

    public void setState(JSONObject state) {
//        JSONObject obj = new JSONObject();
//        obj.put(type,bl);
        this.state = state;
    }

}
