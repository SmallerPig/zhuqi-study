package zhuqi.study.study;

/**
 * @author zhuqi at 2019/1/9
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration//开启配置
@EnableConfigurationProperties(DemoProperties.class)//开启使用映射实体对象
@ConditionalOnClass(DemoService.class)//存在HelloService时初始化该配置类
@ConditionalOnProperty//存在对应配置信息时初始化该配置类
        (
                prefix = "person",//存在配置前缀hello
                value = "enabled",//开启
                matchIfMissing = true//缺失检查
        )
public class DemoConfiguration {

    @Autowired
    private DemoProperties demoProperties;

    @Bean
    @ConditionalOnMissingBean(DemoService.class)
    public DemoService demoService() {
        System.out.println("begin create DemoService");

        DemoService demoService = new DemoService();
        demoService.setAge(demoProperties.getAge());
        demoService.setMessage(demoProperties.getMessage());
        demoService.setName(demoProperties.getName());

        return demoService;
    }


}
