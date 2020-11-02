package com.wil.template.exception;


import com.wil.template.common.CommonResponseCode;

public enum BusinessExMsgEnum implements BaseMsgEnum {

    // 成功
    IS_SUCCESS(CommonResponseCode.IS_SUCCESS_CODE, CommonResponseCode.IS_SUCCESS_MSG),
    // 失败
    IS_ERROR(CommonResponseCode.IS_ERROR_CODE, CommonResponseCode.IS_ERROR_MSG),
    // 参数错误
    PARAM_ERROR(CommonResponseCode.PARAM_ERROR_CODE, CommonResponseCode.PARAM_ERROR_MSG),

    ;

    private Integer code;
    private String msg;

    BusinessExMsgEnum(String msg) {
        this.msg = msg;
    }

    BusinessExMsgEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
