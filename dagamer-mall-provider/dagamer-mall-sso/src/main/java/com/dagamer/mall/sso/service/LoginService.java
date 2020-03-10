package com.dagamer.mall.sso.service;

import com.dagamer.mall.sso.model.dto.UacUserDto;

public interface LoginService {
    UacUserDto login(String loginName, String loginPwd);
}
