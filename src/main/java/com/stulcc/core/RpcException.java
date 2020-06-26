package com.stulcc.core;

public class RpcException extends RuntimeException {

    private static final long serialVersionUID = 2L;

    public RpcException(String msg) {
        super(msg);
    }

    public RpcException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public RpcException(Throwable cause) {
        super(cause);
    }

    public RpcException(int retCode, String message) {
        super("server repsonse code is " + retCode + ",server response msg is " + message);

    }
}
