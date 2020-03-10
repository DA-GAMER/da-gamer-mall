package com.dagamer.mall.user.service;

import com.dagamer.mall.user.model.domain.UacUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dagamer.mall.user.model.dto.UserRegisterDto;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author DaGamer
 * @since 2020-03-05
 */
public interface UacUserService extends IService<UacUser> {

    void register(UserRegisterDto userRegisterDto);
}
