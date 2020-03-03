package com.dagamer.mall.sso.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dagamer.mall.sso.model.dto.UocUserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginMapper extends BaseMapper<UocUserDTO> {
}
