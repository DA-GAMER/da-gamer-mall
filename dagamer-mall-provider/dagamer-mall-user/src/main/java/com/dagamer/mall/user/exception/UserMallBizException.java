package com.dagamer.mall.user.exception;

import com.dagamer.mall.common.base.enums.IncorrectCodeEnum;
import com.dagamer.mall.common.base.exceptions.BusinessException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserMallBizException extends BusinessException {

    public UserMallBizException() {
    }

    /**
     * 用户服务异常
     *
     * @param incorrect instance
     */
    public UserMallBizException(IncorrectCodeEnum incorrect) {
        super(incorrect);
        log.info("<== UserMallBizException, code: " + super.code + ", message: " + super.getMessage());
    }

}
