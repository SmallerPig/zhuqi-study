package zhuqistudyspring.bean;

import zhuqistudyspring.processer.MyBeanPostProcesser;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author zhuqi at 2020/8/9
 */
@Configuration
public class BeanConfiguration {

    @Bean
    public Person person(){
        return new Person();
    }

    /**
     * 初始化bean时可增加部分配置
     * @return
     */
    @Bean
    public MyBeanPostProcesser myBeanPostProcesser(){
        return new MyBeanPostProcesser();
    }
}
