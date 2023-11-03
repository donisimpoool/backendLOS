package com.ikkat.los.system;

import java.io.Serializable;

public class OperationResultJson implements Serializable{
	private static final long serialVersionUID = 3654533222360888659L;
	private long opResult;
    private Object data;
    private OperationErrorJson err;

    public OperationResultJson() {
        this.opResult = 0;
    }

    public OperationResultJson(long opResult) {
        this.opResult = opResult;
    }

    public long getOpResult() {
        return opResult;
    }

    public void setOpResult(long opResult) {
        this.opResult = opResult;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public OperationErrorJson getErr() {
        return err;
    }

    public void setErr(OperationErrorJson err) {
        this.err = err;
    }
}
