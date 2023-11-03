package com.ikkat.los.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OperationErrorJson implements Serializable{
	 /**
		 * 
		 */
		private static final long serialVersionUID = -1848286283681570362L;
		private final long errCode;
	    private final String errMsg;
	    private final List<OperationErrorDetailJson> errDetail;

	    public OperationErrorJson(long errCode, String errMsg) {
	        this(errCode, errMsg, Collections.emptyList());
	    }
	    
	    public OperationErrorJson(long errCode, String errMsg, List<OperationErrorDetailJson> errDetail) {
	    	this.errCode = errCode;
	        this.errMsg = errMsg;
	        this.errDetail = new ArrayList<OperationErrorDetailJson>(errDetail);
	    }

	    public long getErrCode() {
	        return errCode;
	    }

	    public String getErrMsg() {
	        return errMsg;
	    }

		public List<OperationErrorDetailJson> getErrDetail() {
			return Collections.unmodifiableList(this.errDetail);
		}
}
