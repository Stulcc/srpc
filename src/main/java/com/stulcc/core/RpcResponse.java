package com.stulcc.core;

public class RpcResponse {
    private static final long serialVersionUID = 2L;


    private String requestId;


    private int retCode;
    private String retMessage;

    private Object result;

    public RpcResponse(int retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }
    public RpcResponse(int retCode) {
        this.retCode = retCode;
    }
    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public int getRetCode() {
        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public String getRetMessage() {
        return retMessage;
    }

    public void setRetMessage(String retMessage) {
        this.retMessage = retMessage;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
