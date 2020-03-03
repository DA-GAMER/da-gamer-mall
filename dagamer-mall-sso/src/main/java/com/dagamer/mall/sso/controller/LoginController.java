package com.dagamer.mall.sso.controller;

import com.dagamer.mall.sso.mapper.LoginMapper;
import com.dagamer.mall.sso.model.dto.UocUserDTO;
import com.dagamer.mall.sso.model.query.UocUserQuery;
import com.dagamer.mall.sso.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户登录")
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private LoginMapper loginMapper;

    @ApiOperation(value = "用户登录", notes = "用户登录接口")
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public void login(@RequestBody UocUserQuery uodUserQuery) {
//        UocUserDTO uodUserDTO = loginService.login(uodUserQuery.getU(), uodUserQuery.getP());
        UocUserDTO uocUserDTO = loginMapper.selectById("1");
        System.out.println(uocUserDTO.toString());
    }

}
