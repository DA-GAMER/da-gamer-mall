package com.dagamer.mall.sso.web;

import com.dagamer.mall.common.base.enums.IncorrectCodeEnum;
import com.dagamer.mall.common.base.exceptions.BusinessException;
import com.dagamer.mall.common.util.Wrapper;
import com.dagamer.mall.common.util.WrapperOperator;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 参数异常
     *
     * @param e exception
     * @return instance
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public Wrapper illegalArgumentException(IllegalArgumentException e) {
        return WrapperOperator.wrap(IncorrectCodeEnum.UR1005.getCode(), e.getMessage());
    }

    /**
     * 业务异常
     *
     * @param e exception
     * @return instance
     */
    public Wrapper businessException(BusinessException e) {
        return WrapperOperator.wrap(e.getCode(), e.getMessage());
    }

}
