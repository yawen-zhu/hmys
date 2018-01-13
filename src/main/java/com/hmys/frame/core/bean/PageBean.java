package com.hmys.frame.core.bean;

import com.github.pagehelper.Page;

import java.util.List;

public class PageBean<T> {
    private static final long serialVersionUID = 1L;
    private long total; //总记录数
    private Page<T> rows;

    public Page<T> getRows() {
        return rows;
    }

    public void setRows(Page<T> rows) {
        this.rows = rows;
    }

    private List<T> list; //结果集
    private int pageNum; //第几页
    private int pageSize; //每页记录数
    private int pages; // 总页数
    private int size; //当前页的数量<=pageSize

    public PageBean(List<T> list){
        if (list instanceof Page){
            Page<T> page = (Page<T>) list;
            this.pageNum = page.getPageNum();
            this.pageSize = page.getPageSize();
            this.total = page.getTotal();
            this.pages = page.getPages();
            this.list = page;
            this.size = page.size();
            this.rows = page;
        }
    }
    public long getTotal() {
        return total;
    }
    public void setTotal(long total) {
        this.total = total;
    }
    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public int getPageNum() {
        return pageNum;
    }
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getPages() {
        return pages;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }
}