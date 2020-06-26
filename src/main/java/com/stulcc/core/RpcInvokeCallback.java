package com.stulcc.core;

public abstract class RpcInvokeCallback<T> {

    private static ThreadLocal<RpcInvokeCallback> threadInvokerFuture = new ThreadLocal<>();

    abstract void onSuccess(T result);

    abstract void onFailure(Throwable exception);

    public static RpcInvokeCallback getCallback() {
        RpcInvokeCallback invokeCallback = threadInvokerFuture.get();
        threadInvokerFuture.remove();
        return invokeCallback;
    }

    public static void setCallback(RpcInvokeCallback invokeCallback) {
        threadInvokerFuture.set(invokeCallback);
    }


    public static void removeCallback() {
        threadInvokerFuture.remove();
    }

}
