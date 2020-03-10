package com.dagamer.mall.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dagamer.mall.common.base.enums.IncorrectCodeEnum;
import com.dagamer.mall.user.exception.UserMallBizException;
import com.dagamer.mall.user.model.domain.UacUser;
import com.dagamer.mall.user.mapper.UacUserMapper;
import com.dagamer.mall.user.model.dto.UserRegisterDto;
import com.dagamer.mall.user.service.UacUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author DaGamer
 * @since 2020-03-05
 */
@Service
public class UacUserServiceImpl extends ServiceImpl<UacUserMapper, UacUser> implements UacUserService {

    @Autowired
    private UacUserMapper uacUserMapper;

    @Override
    public void register(UserRegisterDto userRegisterDto) {
        checkRegisterInfo(userRegisterDto);

        UacUser uacUser = new UacUser();
        LocalDateTime date = LocalDateTime.now();
        uacUser.setLoginName("");
        uacUser.setLoginName(userRegisterDto.getLoginName());
        uacUser.setLoginPwd(new BCryptPasswordEncoder().encode(userRegisterDto.getLoginPwd()));
        uacUser.setBalance(new BigDecimal("0"));
        uacUser.setLoginLastTime(date);
        uacUser.insertNewDomain();
        uacUserMapper.insert(uacUser);
    }

    /**
     * 检查注册信息是否规范
     *
     * @param userRegisterDto instance
     */
    private void checkRegisterInfo(UserRegisterDto userRegisterDto) {

        Preconditions.checkArgument(!StringUtils.isBlank(userRegisterDto.getLoginName()), IncorrectCodeEnum.UR1001.getMessage());
        Preconditions.checkArgument(!StringUtils.isBlank(userRegisterDto.getLoginPwd()), IncorrectCodeEnum.UR1002.getMessage());
        Preconditions.checkArgument(userRegisterDto.getLoginPwd().equals(userRegisterDto.getConfirmedPwd()), IncorrectCodeEnum.UR1003.getMessage());

        Integer count = uacUserMapper.selectCount(new QueryWrapper<UacUser>().eq("login_name", userRegisterDto.getLoginName()));
        if (count > 0) {
            throw new UserMallBizException(IncorrectCodeEnum.UR1004);
        }

    }
}
