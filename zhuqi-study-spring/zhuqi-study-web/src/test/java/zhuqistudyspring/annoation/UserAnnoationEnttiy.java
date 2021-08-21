package zhuqistudyspring.annoation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author zhuqi at 2020/8/19
 */
@Component
// 此种方式替代了在applicationContext.xml文件中的 <context:property-placeholder location="init-user.properties"/>
@PropertySource(value = "init-user.properties")
public class UserAnnoationEnttiy implements Serializable {

    @Value("${id}")
    private Integer id;

    @Value("${username}")
    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserAnnoationEnttiy{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
