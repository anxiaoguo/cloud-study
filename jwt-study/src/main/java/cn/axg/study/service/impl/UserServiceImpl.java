package cn.axg.study.service.impl;

import cn.axg.common.api.Asserts;
import cn.axg.common.api.CommonResult;
import cn.axg.study.utils.JwtUtils;
import cn.axg.study.mapper.UserMapper;
import cn.axg.study.model.User;
import cn.axg.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public CommonResult login(String username, String password) {

        User user = userMapper.selectLoginUser(username, password);
        if(user == null){
            Asserts.fail("用户名或者密码错误");
        }
        Map<String,String> map = new HashMap<>();
        map.put("username",user.getUsername());
        return CommonResult.success(JwtUtils.getToken(map));
    }


}
