package com.wil.template.common;

public class CommonResponseCode {

	public final static int IS_SUCCESS_CODE = 10000;
	public final static String IS_SUCCESS_MSG = "操作成功";

	public final static int IS_ERROR_CODE = -10000;
	public final static String IS_ERROR_MSG = "操作失败";

	public final static int LOGIN_TIME_OUT_CODE = -10001;
	public final static String LOGIN_TIME_OUT_MSG = "登录超时";

	public final static int PARAM_ERROR_CODE = -10002;
	public final static String PARAM_ERROR_MSG = "参数错误";

	public final static int IS_NOT_LOGIN_CODE = -10003;
	public final static String IS_NOT_LOGIN_MSG = "尚未登录";

	public final static int REPEAT_REQUEST_CODE = -10004;
	public final static String REPEAT_REQUEST_MSG = "请不要在短时间内频繁操作";

	public final static int ILLEGAL_REQUEST_CODE = -10005;
	public final static String ILLEGAL_REQUEST_MSG = "非法请求";

	public final static int OVER_FLOW_LIMIT_CODE = -10006;
	public final static String OVER_FLOW_LIMIT_MSG = "超过访问限制，请稍后再试";

	public final static int IS_NOT_PRIV_CODE = -10007;
	public final static String IS_NOT_PRIV_MSG = "权限不足";
	
	public final static int USER_NOT_EXIST_CODE = -10008;
	public final static String USER_NOT_EXIST_MSG = "系统用户不存在";
	
	public final static int PASSWORD_IS_ERROR_CODE = -10009;
	public final static String PASSWORD_IS_ERROR_MSG = "密码错误";
	
	public final static int USER_STATUS_ERROR_CODE = -10010;
	public final static String USER_STATUS_ERROR_MSG = "该账号已失效，联系管理员";

	public static final int USER_EXIST_CODE = -10011;
	public static final String USER_EXIST_MSG = "系统用户已存在";

	public static final int ACTIVE_CODE_INVALID_CODE = -10012;
	public static final String ACTIVE_CODE_INVALID_MSG = "激活码无效";

	public static final int APP_NOT_EXIST_CODE = -10013;
	public static final String APP_NOT_EXIST_MSG = "APP不存在";

	public static final int APP_USER_NOT_EXIST_CODE = -10014;
	public static final String APP_USER_NOT_EXIST_MSG = "APP用户不存在";

	public static final int APP_COUNT_UPPER_LIMIT_CODE = -10015;
	public static final String APP_COUNT_UPPER_LIMIT_MSG = "代理可以创建的激活码数量已达上限";

	public static final int APP_BOUND_CODE = -10016;
	public static final String APP_BOUND_MSG = "APP已经被手机绑定，删除操作请先解绑客户端";

    public static final int CLIENT_NOT_BIND_APP_CODE = -10017;
	public static final String CLIENT_NOT_BIND_APP_MSG = "客户端未绑定app";

	public static final int CLIENT_BIND_APP_CODE = -10018;
	public static final String CLIENT_BIND_APP_MSG = "客户端已绑定app";

	public static final int APP_USER_EXIST_CODE = -10019;
	public static final String APP_USER_EXIST_MSG = "APP用户已存在";

	public static final int APP_UNABLE_CODE = -10020;
	public static final String APP_UNABLE_MSG = "APP被禁用";

	public static final int TOKEN_NOT_EXIST_CODE = -10021;
	public static final String TOKEN_NOT_EXIST_MSG = "token不存在";

	public static final int TOKEN_ILLEGAL_CODE = -10022;
	public static final String TOKEN_ILLEGAL_MSG = "token失效，请重新登录";

	public static final int CODE_BIND_ILLEGAL_CODE = -10023;
	public static final String CODE_BIND_ILLEGAL_MSG = "激活码只能绑定客户";

    public static final int CODE_NOT_EXIST_CODE = -20024;
	public static final String CODE_NOT_EXIST_MSG = "激活码不存在";

	public static final int CODE_UNABLE_CODE = -20025;
	public static final String CODE_UNABLE_MSG = "激活码被禁用";

	public static final int CODE_SOLD_CODE = -20026;
	public static final String CODE_SOLD_MSG = "激活码已售出";

	public static final int USER_UNABLE_CODE = -20027;
	public static final String USER_UNABLE_MSG = "系统用户被禁用";

	public static final int ROLE_TYPE_ILLEGAL_CODE = -20028;
	public static final String ROLE_TYPE_ILLEGAL_MSG = "当前角色不可进行该操作";

	public static final int CUSTOMER_ILLEGAL_CODE = -20029;
	public static final String CUSTOMER_ILLEGAL_MSG = "激活码不属于该客户";

    public static final int ERROR_PERMISSION_DENIED_CODE = -20030;
	public static final String ERROR_PERMISSION_DENIED_MSG = "无权操作他人数据";

	public static final int CODE_USED_CODE = -20031;
	public static final String CODE_USED_MSG = "激活码已创建app";

	public static final int CODE_EXIST_CODE = -20032;
	public static final String CODE_EXIST_MSG = "激活码已存在";

	public static final int CODE_VIP_CODE = -20033;
	public static final String CODE_VIP_MSG = "激活码被预留";

    public static final int CODE_FORMAT_ERROR_CODE = -20034;
	public static final String CODE_FORMAT_ERROR_MSG = "激活码格式错误";

}
