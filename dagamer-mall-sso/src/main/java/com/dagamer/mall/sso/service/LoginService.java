package com.dagamer.mall.sso.service;

import com.dagamer.mall.sso.model.dto.UocUserDTO;

public interface LoginService {
    UocUserDTO login(String u, String p);
}
