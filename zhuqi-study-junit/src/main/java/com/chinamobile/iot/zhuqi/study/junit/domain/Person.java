package com.chinamobile.iot.zhuqi.study.junit.domain;

/**
 * @author zhuqi
 * @date create at 2019-10-16 20:08
 */
public class Person {

    private Long id;

    private String username;

    private Integer age;

    /**
     * get the value of id;
     **/
    public Long getId() {
        return id;
    }

    /**
     * set the value of id;
     **/
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * get the value of username;
     **/
    public String getUsername() {
        return username;
    }

    /**
     * set the value of username;
     **/
    public void setUsername(String username) {
        this.username = username;
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


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                '}';
    }


}
