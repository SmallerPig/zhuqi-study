package com.chinamobile.iot.controller;

import com.chinamobile.iot.domain.UserEntity;
import com.chinamobile.iot.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuqi
 * @Description
 * @Date create at 2019-07-24 14:13
 */
@RestController
public class DemoController {

    @Autowired
    private UserService userService;


    @PostMapping("/ping")
    @RequiresPermissions("sys:user:info")
    public String ping(@RequestBody UserEntity entity){
        userService.add(entity);
        return "pong";
    }
}
