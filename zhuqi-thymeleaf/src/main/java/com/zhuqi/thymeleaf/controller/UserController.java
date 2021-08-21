package com.zhuqi.thymeleaf.controller;

import com.zhuqi.thymeleaf.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

/**
 * @author zhuqi at 2020/9/20
 */
@Controller
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);


    @RequestMapping("/ping")
    public String ping(){
        return "pong";
    }



    @GetMapping("info")
    public String info(Model model){
        User user =  new User();
        user.setName("zhuqi");
        user.setAddress("wuxi");
        user.setAge(34);
        model.addAttribute("name", user.getName());
        return "info";
    }


    @GetMapping("add")
    public String add(){
        User user =  new User();
        user.setName("zhuqi");
        user.setAddress("wuxi");
        user.setAge(34);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);

        return "add";
    }

    @GetMapping("edit")
    public String edit(){
        return "edit";
    }
}
