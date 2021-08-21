package zhuqi.study.study;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zhuqi at 2019/1/9
 */
@ConfigurationProperties(prefix = "person")
public class DemoProperties {

    private String message = "hello world";

    private Integer age = 32;

    private String name = "smallerpig";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
