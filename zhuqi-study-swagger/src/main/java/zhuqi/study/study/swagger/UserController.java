package zhuqi.study.study.swagger;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuqi at 2018/8/8
 */

@RestController
@RequestMapping("/user")
@Api("userController相关api")
public class UserController {

    @Autowired
    @ApiOperation("获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "username", dataType = "String", required = true, value = "用户的姓名", defaultValue = "thuempire"),
            @ApiImplicitParam(paramType = "query", name = "password", dataType = "String", required = true, value = "用户的密码", defaultValue = "123456")
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public User getUser(/*@RequestHeader("username") String username, @RequestParam("password") String password*/) {
        User us = new User();
        us.setUserName("thuempire");
        us.setPassword("123456");
        us.setAge(18);
        return us;
    }


}