package zhuqi.study.study.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zhuqi at 2018/7/5
 */
@Controller
public class HomeController {

    @RequestMapping("/ping")
    public String ping() {
        return "pong";
    }


    @RequestMapping("/modelandview")
    public ModelAndView modelAndView() {
        return new ModelAndView("test");
    }

}
