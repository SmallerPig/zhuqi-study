package zhuqi.study.study.stater.use;

import zhuqi.study.study.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zhuqi.study.study.IDemoService;

/**
 * @author zhuqi at 2019/1/10
 */
@SpringBootApplication
@RestController
public class Boot {

    public static void main(String[] args) {

        SpringApplication.run(Boot.class);
    }


    @Autowired
    private IDemoService demoService;


    @RequestMapping("/hello")
    public String hello() {
        System.out.println("demoService = " + demoService);
        return demoService.sayHello();
    }

}
