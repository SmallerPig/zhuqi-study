package com.zhuqi.study.zhuqistudyshiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ZhuqiStudyShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhuqiStudyShiroApplication.class, args);
    }

    @RequestMapping("/ping")
    public String ping() {
        return "pong";
    }


    public static class ReferenceCountingGC {
        public Object instance = null;

        private static final int _1MB = 1024 * 1024;

        private byte[] bigSize = new byte[2 * _1MB];

    }

}

