package cn.axg.study.service;

import cn.axg.common.api.CommonResult;

public interface UserService {

    CommonResult login(String username, String password);

}
