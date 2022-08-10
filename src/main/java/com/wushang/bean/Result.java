package com.wushang.bean;

public class Result {
    String flag;
    Object data;
    Page page;

    public Result(String flag, Object data, Page page) {
        this.flag = flag;
        this.data = data;
        this.page = page;
    }

    public Result() {
    }

    @Override
    public String toString() {
        return "Result{" +
                "flag='" + flag + '\'' +
                ", data=" + data +
                ", page=" + page +
                '}';
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }


}
