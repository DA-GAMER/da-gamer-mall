package com.dagamer.mall.common.base.exceptions;

import com.dagamer.mall.common.base.enums.IncorrectCodeEnum;

public class BusinessException extends RuntimeException {

    protected int code;

    public BusinessException(){}

    /**
     * 业务异常
     *
     * @param incorrect instance
     */
    public BusinessException(IncorrectCodeEnum incorrect) {
        super(incorrect.getMessage());
        this.code = incorrect.getCode();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
