package com.ikkat.los.system;

import java.io.Serializable;

public class OperationErrorDetailJson implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2905986992087830866L;
	private final long errCode;
	private final String errMsg;
	private final String errDesc;
	
	public OperationErrorDetailJson(long errCode, String errMsg) {
		this(errCode, errMsg, null);
	}
	public OperationErrorDetailJson(long errCode, String errMsg, String errDesc) {
		super();
		this.errCode = errCode;
		this.errMsg = errMsg;
		this.errDesc = errDesc;
	}
	public long getErrCode() {
		return errCode;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public String getErrDesc() {
		return errDesc;
	}
}
