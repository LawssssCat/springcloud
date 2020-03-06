package com.spring.sp01.util;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JsonResult<T> {
	/** 成功 */
	public static final int SUCCESS = 200;
	/** 没有登录 */
	public static final int NOT_LOGIN = 400;
	/** 发现异常 */
	public static final int EXCPTION = 401;
	/** 系统错误 */
	public static final int SYS_ERROR = 402;
	/** 参数错误 */
	public static final int PARAMS_ERROR = 403;
	/** 不支持域或已经废弃 */
	public static final int NOT_SUPPORTED = 410;
	/** AuthCode错误 */
	public static final int INVALID_AUTHCODE = 444;
	/** 太频繁的调用 */
	public static final int TOO_FREQUENT = 445;
	/** 未知的错误 */
	public static final int UNKNOW_ERROR = 499;

	private int code;
	private String msg;
	private T data;

	@SuppressWarnings("rawtypes")
	public static JsonResult build() {
		return new JsonResult();
	}

	@SuppressWarnings("rawtypes")
	public static JsonResult build(int code) {
		return new JsonResult().code(code);
	}

	// build

	public static <T> JsonResult<T> build(int code, String msg) {
		return new JsonResult<T>().code(code).msg(msg);
	}

	public static <T> JsonResult<T> build(int code, T data) {
		return new JsonResult<T>().code(code).data(data);
	}

	public static <T> JsonResult<T> build(int code, String msg, T data) {
		return new JsonResult<T>().code(code).msg(msg).data(data);
	}

	// code / msg / data

	public JsonResult<T> code(int code) {
		this.code = code;
		return this;
	}

	public JsonResult<T> msg(String msg) {
		this.msg = msg;
		return this;
	}

	public JsonResult<T> data(T data) {
		this.data = data ;
		return this;
	}

	// ok / error

	public static JsonResult ok() {
		return build(SUCCESS);
	}

	public static JsonResult ok(String msg) {
		return build(SUCCESS, msg);
	}

	public static <T> JsonResult<T> ok(T data) {
		return build(SUCCESS, data);
	}

	public static JsonResult err() {
		return build(EXCPTION);
	}

	public static JsonResult err(String msg) {
		return build(EXCPTION, msg);
	}

	@Override
	public String toString() {
		return JsonUtil.to(this);
	}
}