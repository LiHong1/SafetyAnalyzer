package com.lihong.common.bean;

public class ErrorCode {
	
	private Integer errorCode;
	private String Message;
	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public ErrorCode(Integer errorCode, String message) {
		super();
		this.errorCode = errorCode;
		Message = message;
	}

	
}
