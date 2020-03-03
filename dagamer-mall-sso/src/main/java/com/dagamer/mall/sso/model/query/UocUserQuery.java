package com.dagamer.mall.sso.model.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ApiModel(value = "用户登录")
public class UocUserQuery {

    @ApiModelProperty(name = "u", value = "登录账号", required = true)
    private String u;

    @ApiModelProperty(name = "p", value = "登录密码", required = true)
    private String p;

}
