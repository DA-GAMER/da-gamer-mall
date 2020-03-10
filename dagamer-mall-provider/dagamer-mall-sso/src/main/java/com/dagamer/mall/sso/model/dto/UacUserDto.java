package com.dagamer.mall.sso.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UacUserDto {

    private String id;

    private String loginName;

    private String loginPwd;

}
