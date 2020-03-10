package com.dagamer.mall.common.util;

import org.apache.commons.lang3.StringUtils;

public class WrapperOperator {

    /**
     * Wrap.
     *
     * @param code    编码
     * @param message 消息
     * @param result  结果
     * @return instance
     */
    public static <E> Wrapper<E> wrap(int code, String message, E result) {
        return new Wrapper<>(code, message, result);
    }

    /**
     * Wrap.
     *
     * @param code    编码
     * @param message 消息
     * @return instance
     */
    public static <E> Wrapper<E> wrap(int code, String message) {
        return wrap(code, message, null);
    }

    /**
     * Wrap.
     *
     * @param code 编码
     * @return instance
     */
    public static <E> Wrapper<E> wrap(int code) {
        return wrap(code, null);
    }

    /**
     * Wrap exception.
     *
     * @param e 异常
     * @return instance
     */
    public static <E> Wrapper<E> wrap(Exception e) {
        return wrap(Wrapper.ERROR_CODE, e.getMessage());
    }

    /**
     * Wrap error.
     *
     * @return instance
     */
    public static <E> Wrapper<E> error() {
        return wrap(Wrapper.ERROR_CODE, Wrapper.ERROR_MESSAGE);
    }

    /**
     * Wrap error.
     *
     * @param <E> The element
     * @param message 结果
     * @return instance
     */
    public static <E> Wrapper<E> error(String message) {
        return wrap(Wrapper.ERROR_CODE, StringUtils.isBlank(message) ? Wrapper.ERROR_MESSAGE : message);
    }

    /**
     * Wrap ok.
     *
     * @param <E> The element
     *
     * @return instance
     */
    public static <E> Wrapper<E> ok() {
        return wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE);
    }

    /**
     * Wrap ok.
     *
     * @param <E> The element
     * @param result 结果
     *
     * @return instance
     */
    public static <E> Wrapper<E> ok(E result) {
        return wrap(Wrapper.SUCCESS_CODE, Wrapper.SUCCESS_MESSAGE, result);
    }

}
