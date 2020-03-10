package com.dagamer.mall.user.web.mall;

import com.dagamer.mall.common.util.Wrapper;
import com.dagamer.mall.common.util.WrapperOperator;
import com.dagamer.mall.user.model.dto.UserRegisterDto;
import com.dagamer.mall.user.service.UacUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user", produces = {"application/json;charset=UTF-8"})
@Api(value = "WEB - UserRegisterController", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserRegisterController {

    private final Logger logger = LoggerFactory.getLogger(UserRegisterController.class);

    @Autowired
    private UacUserService uacUserService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ApiOperation(value = "用户注册")
    public Wrapper register(@ApiParam(name = "userRegisterDto", value = "用户注册Dto")
                            @RequestBody UserRegisterDto userRegisterDto) {
        logger.info("User registration, loginName: {}", userRegisterDto.getLoginName());
        uacUserService.register(userRegisterDto);
        return WrapperOperator.ok();
    }

}
