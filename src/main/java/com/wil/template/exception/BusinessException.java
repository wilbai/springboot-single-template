package com.wil.template.exception;

import lombok.Getter;

/**
 * @Description 业务异常类
 * @Author wil
 * @Date 2020/08/10/ 11:35:27
 * @Version 1.0
 */
@Getter
public class BusinessException extends RuntimeException {

    /**
     * code
     */
    private Integer code;

    /**
     * msgs
     */
    private String[] args;

    /**
     * @Description
     * @Author wil
     * @Date 2019年11月18日 04:46:13
     * @param message 消息
     * @Return
     */
    public BusinessException(String message) {
        super(message);
    }

    /**
     * @Description
     * @Author wil
     * @Date 2019年11月18日 04:46:13
     * @param code 错误code
     * @param message 消息
     * @Return
     */
    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * @Description
     * @Author wil
     * @Date 2019年05月31日 09:16:10
     * @param exceptionEnum 异常枚举
     * @Return
     */
    public BusinessException(BaseMsgEnum exceptionEnum) {
        super(exceptionEnum.getMsg());
        this.code = exceptionEnum.getCode();
    }


    /**
     * @Description
     * @Author wil
     * @Date 2019年11月18日 04:45:56
     * @param exceptionEnum 异常枚举
     * @param args 参数
     * @Return
     */
    public BusinessException(BaseMsgEnum exceptionEnum, String... args) {
        this.code = exceptionEnum.getCode();
        this.args = args;
    }

}
