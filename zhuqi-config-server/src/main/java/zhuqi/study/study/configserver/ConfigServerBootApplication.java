package zhuqi.study.study.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author zhuqi at 2018/7/20
 */
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class ConfigServerBootApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ConfigServerBootApplication.class, args);
//        new SpringApplicationBuilder(ConfigServerBootApplication.class).web(true).run(args);


    }
}
