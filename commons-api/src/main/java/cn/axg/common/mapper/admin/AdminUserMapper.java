/**
* @filename:AdminUserDao 2022年8月20日
* @project cloud-study  V1.0
* Copyright(c) 2020 安晓国 Co. Ltd.
* All right reserved.
*/
package cn.axg.common.mapper.admin;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import cn.axg.common.model.admin.AdminUser;

import java.util.List;

/**
* <p>自动生成工具：mybatis-dsc-generator</p>
*
* <p>说明： 后台用户信息表数据访问层</p>
* @version V1.0
* @author 安晓国
*
*/
@Mapper
public interface AdminUserMapper extends BaseMapper<AdminUser> {

    boolean saveBatchByNative(List<AdminUser> list);
}
