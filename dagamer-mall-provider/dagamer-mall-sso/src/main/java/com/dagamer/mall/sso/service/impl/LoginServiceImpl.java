package com.dagamer.mall.sso.service.impl;

import com.dagamer.mall.common.base.enums.IncorrectCodeEnum;
import com.dagamer.mall.sso.exception.SsoMallBizException;
import com.dagamer.mall.sso.mapper.UacUserMapper;
import com.dagamer.mall.sso.model.dto.UacUserDto;
import com.dagamer.mall.sso.service.LoginService;
import com.dagamer.mall.sso.service.consumer.RedisService;
import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UacUserMapper uacUserMapper;

    @Autowired
    private RedisService redisService;

    @Override
    public UacUserDto login(String loginName, String loginPwd) {

        checkLoginInfo(loginName, loginPwd);
        UacUserDto uacUserDTO = uacUserMapper.login(loginName);
        if (null != uacUserDTO) {
            boolean pwd = new BCryptPasswordEncoder().matches(loginPwd, uacUserDTO.getLoginPwd());
            if (pwd) {
                return uacUserDTO;
            }
        }
        return null;
    }

    /**
     * 检测邓论信息
     *
     * @param loginName 登录名
     * @param loginPwd  登录密码
     */
    private void checkLoginInfo(String loginName, String loginPwd) {
        Preconditions.checkArgument(!StringUtils.isBlank(loginName), IncorrectCodeEnum.UR1001.getMessage());
        Preconditions.checkArgument(!StringUtils.isBlank(loginPwd), IncorrectCodeEnum.UR1002.getMessage());
    }

}
