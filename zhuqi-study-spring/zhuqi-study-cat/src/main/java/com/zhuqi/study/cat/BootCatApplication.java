package com.zhuqi.study.cat;

import com.zhuqi.study.east.common.web.exception.DataException;
import com.dianping.cat.Cat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuqi at 2021/1/7
 */
@SpringBootApplication
@RestController
@ComponentScan("com.zhuqi.study")
public class BootCatApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(BootCatApplication.class);
    }


    @RequestMapping("/ping")
    public String ping(){
//        Cat.disable();
        Cat.logEvent("type_name", "log_of_event");

        DataException dataException = new DataException("error happen");
        throw dataException;
//        return "pong";
    }

}
