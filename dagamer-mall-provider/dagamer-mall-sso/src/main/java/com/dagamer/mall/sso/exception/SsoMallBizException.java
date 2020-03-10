package com.dagamer.mall.sso.exception;

import com.dagamer.mall.common.base.enums.IncorrectCodeEnum;
import com.dagamer.mall.common.base.exceptions.BusinessException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SsoMallBizException extends BusinessException {

    public SsoMallBizException() {

    }

    /**
     * 单点登录服务异常
     *
     * @param incorrect instance
     */
    public SsoMallBizException(IncorrectCodeEnum incorrect) {
        super(incorrect);
        log.info("<== SsoMallBizException, code: " + super.code + ", message: " + super.getMessage());
    }

}
