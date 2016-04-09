package com.lihong.common.bean;

public class SafeAnError extends Error {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ErrorCode errorCode;
	
	public SafeAnError(Integer code,String message){
		errorCode = new ErrorCode(code, message);
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}

}
