package com.wil.template.common;

import cn.hutool.core.date.DateUnit;

/**
 * @Description 常量
 * @Author wil
 * @Date 2020/08/13 12:28:59
 * @Version 1.0
 */
public class Constants {

	public static final String CONTROL_PACKAGE_PATH = "com.qs.app.calculator.api.controller";

	/**
	 * 成功标记
	 */
	public static final Integer SUCCESS = 0;
	/**
	 * 失败标记
	 */
	public static final Integer FAIL = 1;

	public static final String EMPTYSTR = "";

	public static final String TOKEN = "token";

	/**
	 * 本地缓存过期时间,默认420分钟
	 */
	public static final Long LOCAL_REFRESH_TIME = DateUnit.MINUTE.getMillis() * 420;


	/**
	 * 数据库缓存过期时间,默认720分钟
	 */
	public static final Long SQL_REFRESH_TIME = DateUnit.MINUTE.getMillis() * 720;
}

