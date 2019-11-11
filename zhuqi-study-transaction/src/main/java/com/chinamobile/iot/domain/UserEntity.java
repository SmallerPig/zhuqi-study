package com.chinamobile.iot.domain;

import com.chinamobile.iot.wuxi.common.mysql.model.BaseModel;

/**
 * @author zhuqi
 * @Description
 * @Date create at 2019-07-24 8:43
 */
public class UserEntity extends BaseModel {

    private String name;

    private Integer age;

    /**
     * get the value of name;
     **/
    public String getName() {
        return name;
    }

    /**
     * set the value of name;
     **/
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get the value of age;
     **/
    public Integer getAge() {
        return age;
    }

    /**
     * set the value of age;
     **/
    public void setAge(Integer age) {
        this.age = age;
    }
}
