package zhuqi.study.dubbo.client.controller;

import zhuqi.study.dubbo.client.dubbo.CityDubboService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuqi at 2018/12/7
 */
@RestController
public class HomeController {

    private CityDubboService cityDubboService;

    @RequestMapping("/ping")
    public String ping() {
        return "pong";
    }


    @RequestMapping("/hi")
    public String hello() {
        return "world";
    }
}
