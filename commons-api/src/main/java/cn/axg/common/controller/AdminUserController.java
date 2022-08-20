/**
 * @filename:AdminUserController 2022年8月20日
 * @project cloud-study  V1.0
 * Copyright(c) 2020 安晓国 Co. Ltd.
 * All right reserved.
 */
package cn.axg.common.controller;

import cn.axg.common.dto.AdminUserDTO;
import cn.axg.common.model.admin.AdminUser;
import cn.axg.common.service.AdminUserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>自动生成工具：mybatis-dsc-generator</p>
 *
 * <p>说明： 后台用户信息表API接口层</P>
 * @version V1.0
 * @author 安晓国
 *
 */
@Api(tags = "后台用户信息表", value = "后台用户信息表")
@RestController
@RequestMapping("/adminUser")
public class AdminUserController {


    @Resource
    private AdminUserService adminUserService;

    /**
     * 根据性别查询信息
     * @return
     */
    @PostMapping("/getInfo")
    public List<AdminUser> getInfo(@RequestBody @Validated AdminUserDTO adminUserDTO) {
        List<AdminUser> list = adminUserService.list(new LambdaQueryWrapper<AdminUser>().eq(AdminUser::getGender, adminUserDTO.getGender()));
        return list;
    }

}