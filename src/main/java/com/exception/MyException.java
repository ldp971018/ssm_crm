package com.exception;

/**
 * �Զ����쳣
 * @author Steven
 *
 */
public class MyException extends Exception {
	
	//������Ϣ
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
