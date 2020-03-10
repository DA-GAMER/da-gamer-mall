package com.dagamer.mall.user.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "用户注册Dto")
public class UserRegisterDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "登录名")
    private String loginName;

    @ApiModelProperty(value = "用户密码")
    private String loginPwd;

    @ApiModelProperty(value = "确认密码")
    private String confirmedPwd;

}
