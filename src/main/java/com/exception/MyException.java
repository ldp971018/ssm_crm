package com.exception;

/**
 * 自定义异常
 * @author Steven
 *
 */
public class MyException extends Exception {
	
	//错误消息
	private String msg;

	public MyException() {
		super();
	}
	public MyException(String msg) {
		super();
		this.msg = msg;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
