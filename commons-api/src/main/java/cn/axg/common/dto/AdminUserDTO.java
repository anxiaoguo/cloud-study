package cn.axg.common.dto;

import cn.axg.common.annotation.FlagValidator;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class AdminUserDTO {

    @FlagValidator(value = {"1", "2", "3"}, message = "参数只能传入1、2、3")
    @NotNull(message = "性别不能为空")
    private Integer gender;


}
