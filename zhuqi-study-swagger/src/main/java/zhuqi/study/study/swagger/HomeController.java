package zhuqi.study.study.swagger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhuqi at 2018/8/8
 */
@RestController
@RequestMapping("/home")
@Api(value = "检查模板操作", description = "检查模板操作")
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("/hello/{name}")
    public String hello(@ApiParam(name = "name", value = "name") @RequestParam(value = "name", required = false, defaultValue = "world") String name) {

        return "hello " + name;
    }


}
