package com.dagamer.mall.sso.service.impl;

import com.dagamer.mall.sso.model.dto.UocUserDTO;
import com.dagamer.mall.sso.service.LoginService;
import com.dagamer.mall.sso.service.consumer.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private RedisService redisService;

    @Override
    public UocUserDTO login(String u, String p) {



        return null;
    }

}
