package cn.axg.study.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {

    private Integer id;

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    @NotBlank(message = "性别不能为空")
    private String gender;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date birtdhay;

}
