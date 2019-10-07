package com.uw.recycleviewdemo.entity;

public abstract class BaseBean {

    private String name;

    public BaseBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
