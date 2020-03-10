package com.dagamer.mall.common.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * 返回结果 -> 元数据
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Wrapper<T> implements Serializable {

    public static final long serialVersionUID = 1L;

    /**
     * 操作成功
     */
    public static final int SUCCESS_CODE = 200;

    public static final String SUCCESS_MESSAGE = "操作成功";

    /**
     * 内部异常
     */
    public static final int ERROR_CODE = 500;

    public static final String ERROR_MESSAGE = "内部异常";

    /**
     * 非法参数
     */
    public static final int ILLEGAL_ARGUMENT_CODE = 100;

    public static final String ILLEGAL_ARGUMENT_MESSAGE = "非法参数";

    /**
     * 编码
     */
    private int code;

    /**
     * 消息
     */
    private String message;

    /**
     * 结果
     */
    private T result;

    /**
     * Wrapper实化默认 -> SUCCESS
     */
    Wrapper() {
        this(SUCCESS_CODE, SUCCESS_MESSAGE);
    }

    /**
     * Wrapper实例化，不带有result
     *
     * @param code    编码
     * @param message 消息
     */
    Wrapper(int code, String message) {
        this(code, message, null);
    }

    /**
     * Wrapper实例化，带有result
     * @param code    编码
     * @param message 消息
     * @param result  结果
     */
    Wrapper(int code, String message, T result) {
        this.code(code).message(message).result(result);
    }

    /**
     * 设置code，返回自身引用
     *
     * @param code 编码
     * @return this
     */
    private Wrapper<T> code(int code) {
        this.setCode(code);
        return this;
    }

    /**
     * 设置code，返回自身引用
     *
     * @param message 消息
     * @return this
     */
    private Wrapper<T> message(String message) {
        this.setMessage(message);
        return this;
    }

    /**
     * 设置code，返回自身引用
     *
     * @param result 结果
     * @return this
     */
    private Wrapper<T> result(T result) {
        this.setResult(result);
        return this;
    }

}
