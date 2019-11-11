package com.chinamobile.iot;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;

/**
 * @author zhuqi
 * @date create at 2019-11-08 16:38
 */
@RestController
@Validated
public class HomeController {


    /**
     * 只有在Validated增加在类上面才会生效，且报错误如下：
     * <p>
     * {
     * "timestamp": 1573202001315,
     * "status": 500,
     * "error": "Internal Server Error",
     * "exception": "javax.validation.ConstraintViolationException",
     * "message": "No message available",
     * "path": "/ping"
     * }
     *
     * @param id
     * @return
     */
    @GetMapping("/ping")
    public String ping(@Length(max = 2, message = "最长不超过2") @RequestParam String id) {
        return id;
    }


    /**
     * 在方法级别上增加Validated注解并不会生效
     * 也就是如果删除了类级别的注解，只是增加如下Validated注解，调用方法时的@Length并不会保证最长为2
     *
     * @param id
     * @return
     */
    @GetMapping("/ping1")
    @Validated
    public long ping1(@Max(value = 2, message = "最长不超过2") @RequestParam long id) {
        return id;
    }

}
