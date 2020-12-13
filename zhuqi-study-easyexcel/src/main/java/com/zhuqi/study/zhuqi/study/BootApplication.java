package com.zhuqi.study.zhuqi.study;


import com.alibaba.excel.metadata.BaseRowModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhuqi at 2019/3/11
 */
@SpringBootApplication
public class BootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class);


    }

    @RequestMapping("/ping")
    public String ping() {
        return "pong";
    }

    class JavaModel extends BaseRowModel {
        private String name;

        private Integer age;
    }

}

