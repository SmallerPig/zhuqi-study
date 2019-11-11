package com.chinamobile.iot.zhuqi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhuqi
 * @Description
 * @Date create at 2019/4/17 9:24
 */
@RestController
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class Boot {

    public static void main(String[] args) {
        SpringApplication.run(Boot.class);
    }

    @RequestMapping("/ping")
    public String ping() {
        return "pong";
    }

    @RequestMapping("/re")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/ping");
//        response.setStatus(302);
//        response.setHeader("location", "http://www.baidu.com");
    }


}
