package com.dagamer.mall.sso.web.mall;

import com.dagamer.mall.common.base.enums.IncorrectCodeEnum;
import com.dagamer.mall.common.util.Wrapper;
import com.dagamer.mall.common.util.WrapperOperator;
import com.dagamer.mall.sso.model.dto.UacUserDto;
import com.dagamer.mall.sso.service.LoginService;
import com.dagamer.mall.sso.service.consumer.RedisService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Api(tags = "用户登录")
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private RedisService redisService;

    @ApiOperation(value = "用户登录", notes = "用户登录接口")
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Wrapper login(@RequestParam(value = "loginName") String loginName,
                         @RequestParam(value = "loginPwd") String loginPwd, HttpServletResponse response) {
        UacUserDto uodUserDTO = loginService.login(loginName, loginPwd);
        // 判断用户时候存在
        if (null != uodUserDTO) {

            // 将用户保存到redis
            ObjectMapper ob = new ObjectMapper();
            String token = UUID.randomUUID().toString().replace("-", "").toLowerCase();
            try {
                // 允许跨域访问
                response.setHeader("Access-Control-Expose-Headers", "TOKEN");
                response.addHeader("token", token); // 将token返回给前端
                redisService.put(token, ob.writeValueAsString(uodUserDTO), 60 * 60 * 24);
                return WrapperOperator.ok();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

        }
        return WrapperOperator.wrap(IncorrectCodeEnum.UR1006.getCode(), IncorrectCodeEnum.UR1006.getMessage());
    }

}
