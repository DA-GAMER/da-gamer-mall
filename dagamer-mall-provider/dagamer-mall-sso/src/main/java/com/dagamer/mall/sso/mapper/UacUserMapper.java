package com.dagamer.mall.sso.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dagamer.mall.sso.model.domain.UacUser;
import com.dagamer.mall.sso.model.dto.UacUserDto;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author DaGamer
 * @since 2020-03-04
 */
public interface UacUserMapper extends BaseMapper<UacUser> {

    UacUserDto login(String loginName);

}
