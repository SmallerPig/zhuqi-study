package com.zhuqi.study;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zhuqi at 2020/12/10
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Tester.class)
@EnableFeignClients
public class Tester {

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * 测试:feign使用bean
     */
    @Test
    public void testFeignClient(){
//        Object feign = applicationContext.getBean("client");
//        System.out.println("feign = " + feign);

    }




    static class User{
        private String name;

        private Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }

    @FeignClient(url = "http://localhost:8080")
    interface client{

        @GetMapping("/hi")
        void sayHello(User user);
    }
}
