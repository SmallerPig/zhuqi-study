package zhuqi.study.study;

import org.springframework.stereotype.Component;

/**
 * @author zhuqi at 2019/1/9
 */
public class DemoService implements IDemoService {

    private String message;

    private Integer age;

    private String name;

    public String sayHello() {
        String result = this.name + " is " + this.age + " and said the message :" + this.message;
        System.out.println(result);
        return result;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
}
