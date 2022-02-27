package cn.axg.study.controller;

import cn.axg.common.api.CommonResult;
import cn.axg.study.model.User;
import cn.axg.study.service.UserService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 用户接口
 */
@Api(tags = "UserController/用户API")
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @return
     */
    @PostMapping("/login")
    public CommonResult login(@RequestBody @Validated User user){
        log.info("用户名：[{}]",user.getUsername());
        log.info("密码:[{}]",user.getPassword());
        return  userService.login(user.getUsername(),user.getPassword());
    }

    /**
     * 用于测试JWT
     * @return
     */
    @GetMapping("/test")
    public CommonResult testJwt(){
        log.info("进入方法testJwt~~~~~~~");
        return null;
    }

}
