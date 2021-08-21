package com.zhuqi.study.zhuqistudypurespringboot.domain;

/**
 * @author zhuqi at 2020/9/2
 */
public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
